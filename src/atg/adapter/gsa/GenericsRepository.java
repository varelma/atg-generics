/*   
Copyright 2011 Jon Pallas

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package atg.adapter.gsa;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.ConstructorUtils;
import org.apache.commons.io.FileUtils;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import atg.repository.MutableRepositoryItem;
import atg.repository.RepositoryException;
import atg.repository.RepositoryItem;
import atg.repository.RepositoryItemDescriptor;
import atg.repository.RepositoryPropertyDescriptor;
import atg.repository.RepositoryView;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.SerializerConfig;
import com.hazelcast.core.HazelcastInstance;

/**
 * @author Jon Pallas
 */
public class GenericsRepository extends RepositoryWithCachesDisabled {

    public static final String RBEANS_PACKAGE = "atg.repository.beans";
    public static final String SPLIT_CHAR = "#";

    private Map<String, MutableRepositoryItemExt> itemCache;
    private Map<String, MutableRepositoryItemExt> queryCache;
    private DB mapDB = null;
    private boolean changeAware = true;

    public boolean isChangeAware() { 
        return changeAware;
    }

    public void setChangeAware(boolean changeAware) {
        this.changeAware = changeAware;
    }

    public GenericsRepository() {
	super();
    }

    private boolean usingHazelcast;
    private boolean usingMapDB;
    private boolean usingMap;

    public boolean isUsingMap() {
	return usingMap;
    }

    public void setUsingMap(boolean usingMap) {
	this.usingMap = usingMap;
    }

    public boolean isUsingHazelcast() {
	return usingHazelcast;
    }

    public void setUsingHazelcast(boolean usingHazelcast) {
	this.usingHazelcast = usingHazelcast;
    }

    public boolean isUsingMapDB() {
	return usingMapDB;
    }

    public void setUsingMapDB(boolean usingMapDB) {
	this.usingMapDB = usingMapDB;
    }

    private String[] hazelcastServers;

    public String[] getHazelcastServers() {
	return hazelcastServers;
    }

    public void setHazelcastServers(String[] hazelcastServers) {
	this.hazelcastServers = hazelcastServers;
    }

    private void checkConfig() {
	int total = 0;
	if (usingHazelcast) {
	    total++;
	}
	if (usingMapDB) {
	    total++;
	}
	if (usingMap) {
	    total++;
	}
	if (total == 0) {
	    logError("Repository config error, please set the caching mechanism to uses one of: usingHazelcast usingMapDB usingMap");
	}
	if (total > 1) {
	    logError("Repository config error, please set the caching mechanism uses just one of: usingHazelcast usingMapDB usingMap");
	}
    }

    private void init() {
	checkConfig();

	if (usingHazelcast) {
	    ClientConfig clientConfig = new ClientConfig();
	    clientConfig.getGroupConfig().setName(hazelcastUser).setPassword(hazelcastPassword);

	    for (int i = 0; i < hazelcastServers.length; i++) {
		clientConfig.getNetworkConfig().addAddress(hazelcastServers[i]);
	    }
	    clientConfig.getSerializationConfig().getSerializerConfigs().add(new SerializerConfig().setTypeClass(MutableRepositoryItemExt.class).setImplementation(new MutableRepositoryItemExtHazelcastSerializer()));
	    HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
	    
	    itemCache = client.getMap("itemCacheMap");
	    //itemCache = new HashMap<String, MutableRepositoryItemExt>(); 
	} else if (usingMapDB) {
	    MutableRepositoryItemExtMapDBSerializer MutableRepositoryItemExtMapDBSerializer = new MutableRepositoryItemExtMapDBSerializer();
	    MutableRepositoryItemExtArrayMapDBSerializer MutableRepositoryItemExtArrayMapDBSerializer = new MutableRepositoryItemExtArrayMapDBSerializer();

	    mapDB = DBMaker.newTempFileDB().transactionDisable().asyncWriteEnable().make();
	    itemCache = mapDB.createHashMap("itemCacheMap").keySerializer(org.mapdb.Serializer.STRING).valueSerializer(MutableRepositoryItemExtMapDBSerializer).make();
	    MutableRepositoryItemExtArrayMapDBSerializer.setItemCache(itemCache);
	    queryCache = mapDB.createHashMap("queryCacheMap").keySerializer(org.mapdb.Serializer.STRING).valueSerializer(MutableRepositoryItemExtArrayMapDBSerializer).make();

	} else {
	    itemCache = new HashMap<String, MutableRepositoryItemExt>();
	    queryCache = new HashMap<String, MutableRepositoryItemExt>();
	}
    }

    private String hazelcastUser;
    private String hazelcastPassword;

    public String getHazelcastUser() {
	return hazelcastUser;
    }

    public void setHazelcastUser(String hazelcastUser) {
	this.hazelcastUser = hazelcastUser;
    }

    public String getHazelcastPassword() {
	return hazelcastPassword;
    }

    public void setHazelcastPassword(String hazelcastPassword) {
	this.hazelcastPassword = hazelcastPassword;
    }

    public void doStartService() {
	super.doStartService();
	init();
    }

    public void invalidateCaches() {
	super.invalidateCaches();
	clearMapCache();
    }

    public void invalidateCaches(boolean pGlobal) {
	super.invalidateCaches(pGlobal);
	clearMapCache();
    }

    public void invalidateExternalCaches() {
	super.invalidateExternalCaches();
	clearMapCache();
    }

    private void clearMapCache() {
	itemCache.clear();
	queryCache.clear();
    }

    public RepositoryView getView(String pName) throws RepositoryException {
	RepositoryView view = super.getView(pName);
	return new GenericsRepositoryView(view, this);
    }

    public RepositoryView getView(RepositoryItemDescriptor repositoryItemDescriptor) throws RepositoryException {
	RepositoryView view = super.getView(repositoryItemDescriptor);
	return new GenericsRepositoryView(view, this);
    }

    public GenericsRepositoryView getGenericRepositoryView(String pName) throws RepositoryException {
	RepositoryView view = super.getView(pName);
	return new GenericsRepositoryView(view, this);
    }

    public GenericsRepositoryView getGenericRepositoryView(RepositoryItemDescriptor repositoryItemDescriptor) throws RepositoryException {
	RepositoryView view = super.getView(repositoryItemDescriptor);
	return new GenericsRepositoryView(view, this);
    }

    @SuppressWarnings({ "unchecked" })
    public <T extends MutableRepositoryItem> T getItem(String pId, Class<T>  type) throws RepositoryException {
	String descriptorName = getDescriptorName(type);
	return (T) getItem(pId, descriptorName);
    }

    protected Map<String, MutableRepositoryItemExt> getItemCache() {
	return itemCache;
    }

    protected Map<String, MutableRepositoryItemExt> getQueryCache() {
	return queryCache;
    }

    public RepositoryItem getSuperItem(String pId, String pDescriptorName) throws RepositoryException {
	return super.getItem(pId, pDescriptorName);
    }

    @SuppressWarnings({ "rawtypes" })
    public RepositoryItem getItem(String pId, String pDescriptorName) throws RepositoryException {
	String javaClassName = getPackageName() + "." + getClassName(pDescriptorName);
	String key = pId + SPLIT_CHAR + javaClassName;
	MutableRepositoryItemExt cachedValue = (MutableRepositoryItemExt) itemCache.get(key);
	if (cachedValue != null) {
	    return cachedValue;
	}
	MutableRepositoryItem result = (MutableRepositoryItem) super.getItem(pId, pDescriptorName);
	try {
	    Class beanClass = Class.forName(javaClassName);
	    MutableRepositoryItemExt mutableRepositoryItemExt = create(result, beanClass);
	    return mutableRepositoryItemExt;
	} catch (Exception e) {
	    throw new RepositoryException(e);
	}
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected MutableRepositoryItemExt create(MutableRepositoryItem in, Class beanClass) throws RepositoryException {
	MutableRepositoryItemExt mutableRepositoryItemExt = null;
	try {
	    mutableRepositoryItemExt = ConstructorUtils.invokeExactConstructor(beanClass, null);
	    mutableRepositoryItemExt.setDelegate(in);
	    mutableRepositoryItemExt.setRepositoryId(in.getRepositoryId());
	    String className = beanClass.getCanonicalName();
	    String key = in.getRepositoryId() + SPLIT_CHAR + className;
	    itemCache.put(key, mutableRepositoryItemExt);
	} catch (Exception e) {
	    throw new RepositoryException(e);
	}
	return mutableRepositoryItemExt;
    }

    @SuppressWarnings({ "rawtypes" })
    protected MutableRepositoryItemExt findOrCreate(MutableRepositoryItem in, Class beanClass) throws RepositoryException {
	MutableRepositoryItemExt result = (MutableRepositoryItemExt) itemCache.get(in.getRepositoryId() + SPLIT_CHAR + beanClass.getCanonicalName());
	if (result != null) {
	    return result;
	}
	result = create(in, beanClass);
	return result;
    }

    protected void putAllToItemCache(MutableRepositoryItemExt[] in) {
	try {
	    String javaClassName = null;
	    for (int i = 0; i < in.length; i++) {
		MutableRepositoryItemExt item = in[i];
		if (javaClassName == null) {
		    javaClassName = getPackageName() + "." + getClassName(item.getItemDescriptor().getItemDescriptorName());
		}
		itemCache.put(item.getRepositoryId() + SPLIT_CHAR + javaClassName, item);
	    }
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    public void commit() {
	//mapDB.commit();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <T extends MutableRepositoryItem> T createItem(Class type) throws RepositoryException {
	String descriptorName = getDescriptorName(type);
	return (T) createItem(descriptorName);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public <T extends MutableRepositoryItem> T createItem(String arg1, Class type) throws RepositoryException {
	String descriptorName = getDescriptorName(type);
	return (T) createItem(descriptorName, arg1);
    }

    @SuppressWarnings("rawtypes")
    private Map<Class, String> descriptorNameMaps = new HashMap<Class, String>();

    @SuppressWarnings("rawtypes")
    private String getDescriptorName(Class type) {
	String result = descriptorNameMaps.get(type);
	if (result == null) {
	    String name = type.getSimpleName();
	    result = name.substring(0, 1).toLowerCase() + name.substring(1);
	    descriptorNameMaps.put(type, result);
	}
	return result;
    }

    public void generateAllClasses() {
	List<String> allItemDescriptorsName = getAllItemDescriptorsName();
	for (String repositoryItemDescriptorName : allItemDescriptorsName) {
	    createClassForOneItemDescriptor(repositoryItemDescriptorName);
	}
    }

    private Map<String, String> classNameDescriptorMap = new HashMap<String, String>();

    private String getClassName(String descriptorName) {
	String className = classNameDescriptorMap.get(descriptorName);
	if (className != null) {
	    return className;
	}
	className = "";
	String[] parts = descriptorName.split("[^a-zA-Z0-9]+");
	for (int i = 0; i < parts.length; i++) {
	    String part = parts[i];
	    className += part.substring(0, 1).toUpperCase() + part.substring(1);
	}
	classNameDescriptorMap.put(descriptorName, className);
	return className;
    }

    private String getMemberVariableName(String in) {
	String[] parts = in.split("[^a-zA-Z0-9]+");
	String memberVariableName = "";
	for (int i = 0; i < parts.length; i++) {
	    String part = parts[i];
	    if (i != 0) {
		memberVariableName += part.substring(0, 1).toUpperCase() + part.substring(1);
	    } else {
		memberVariableName += part;
	    }
	}

	return memberVariableName;
    }

    private String getMethodName(String in) {
	String memberVariableName = getMemberVariableName(in);
	String methodName = memberVariableName.substring(0, 1).toUpperCase() + memberVariableName.substring(1);

	return methodName;
    }

    private String getPackageName() {
	String repositoryName = getRepositoryName();
	String packageName = RBEANS_PACKAGE + '.' + repositoryName.toLowerCase();
	return packageName;
    }

    private String getPackageDirectory() {
	String repositoryName = getRepositoryName();
	String packageName = RBEANS_PACKAGE + '.' + repositoryName.toLowerCase();
	String packageDirectory = packageName.replace('.', File.separatorChar);
	return packageDirectory;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void createClassForOneItemDescriptor(String repositoryItemDescriptorName) {
	try {
	    RepositoryItemDescriptor repositoryItemDescriptor = getItemDescriptor(repositoryItemDescriptorName);

	    List<String> superProperties = new ArrayList<String>();
	    String superClassName = "MutableRepositoryItemExt";
	    if (repositoryItemDescriptor instanceof GSAItemDescriptor) {
		GSAItemDescriptor gsaItemDescriptor = (GSAItemDescriptor) repositoryItemDescriptor;
		if (gsaItemDescriptor.getSuperTypeDescriptor() != null) {
		    String superItemName = gsaItemDescriptor.getSuperTypeDescriptor().getItemDescriptorName();
		    superClassName = getClassName(superItemName);
		    superProperties = Arrays.asList(gsaItemDescriptor.getSuperTypeDescriptor().getPropertyNames());
		}
	    }

	    String className = getClassName(repositoryItemDescriptorName);
	    String javaFileName = getPackageDirectory() + File.separator + className + ".java";

	    String javaTemplateContents = javaTemplate();
	    javaTemplateContents = javaTemplateContents.replaceAll("###CLASS_NAME###", className);
	    javaTemplateContents = javaTemplateContents.replaceAll("###SUPER_CLASS_NAME###", superClassName);
	    javaTemplateContents = javaTemplateContents.replaceAll("###PACKAGE_NAME###", getPackageName());
	    javaTemplateContents = javaTemplateContents.replaceAll("###EXTRA_IMPORTS###", "\n");

	    String repositoryPath = getAbsoluteName();
	    javaTemplateContents = javaTemplateContents.replaceAll("###REPOSITORY_PATH###", repositoryPath);
	    javaTemplateContents = javaTemplateContents.replaceAll("###DESCRIPTOR_NAME###", repositoryItemDescriptorName);

	    Set<String> imports = new HashSet<String>();
	    Map<String, String> properties = new HashMap<String, String>();
	    // Add property name converter map
	    String[] names = repositoryItemDescriptor.getPropertyNames();
	    for (int i = 0; i < names.length; i++) {
		String name = names[i];
		RepositoryPropertyDescriptor dynamicPropertyDescriptor = (RepositoryPropertyDescriptor) repositoryItemDescriptor.getPropertyDescriptor(name);

		//
		Class clazz = dynamicPropertyDescriptor.getPropertyType();
		if (clazz.isAssignableFrom(Set.class) || clazz.isAssignableFrom(List.class) || clazz.isAssignableFrom(Map.class) || clazz.isAssignableFrom(RepositoryItem.class)) {

		    String subClassName = null;
		    Object componentItemDescriptor = dynamicPropertyDescriptor.getComponentItemDescriptor();
		    if (componentItemDescriptor == null) {
			if (dynamicPropertyDescriptor.getComponentPropertyType() == null) {
			    subClassName = dynamicPropertyDescriptor.getItemDescriptor().getItemDescriptorName();
			    subClassName = getClassName(subClassName);
			} else {
			    subClassName = dynamicPropertyDescriptor.getComponentPropertyType().getName();
			}
		    } else {
			RepositoryItemDescriptor subRepositoryItemDescriptor = getItemDescriptor(dynamicPropertyDescriptor.getComponentItemDescriptor().getItemDescriptorName());
			if (subRepositoryItemDescriptor == null) {
			    // its probably from anther repository...
			    subClassName = "Object";
			} else {
			    String subItemDescriptorName = subRepositoryItemDescriptor.getItemDescriptorName();
			    subClassName = getClassName(subItemDescriptorName);
			}
		    }
		    imports.add("import " + getPackageName() + "." + subClassName + ";\n");
		    if (clazz.isAssignableFrom(RepositoryItem.class)) {
			properties.put(name, getPackageName() + "." + subClassName);
		    } else if (clazz.isAssignableFrom(Set.class)) {
			properties.put(name, "Set<" + getPackageName() + "." + subClassName + ">");
		    } else if (clazz.isAssignableFrom(List.class)) {
			properties.put(name, "List<" + getPackageName() + "." + subClassName + ">");
		    }
		}
		if (clazz.isAssignableFrom(String.class)) {
		    properties.put(name, "String");
		} else if (clazz.isAssignableFrom(Integer.class)) {
		    properties.put(name, "Integer");
		} else if (clazz.isAssignableFrom(Long.class)) {
		    properties.put(name, "Long");
		} else if (clazz.isAssignableFrom(Short.class)) {
		    properties.put(name, "Short");
		} else if (clazz.isAssignableFrom(Float.class)) {
		    properties.put(name, "Float");
		} else if (clazz.isAssignableFrom(Double.class)) {
		    properties.put(name, "Double");
		} else if (clazz.isAssignableFrom(Long.class)) {
		    properties.put(name, "Long");
		} else if (clazz.isAssignableFrom(Boolean.class)) {
		    properties.put(name, "Boolean");
		} else if (clazz.isAssignableFrom(Date.class)) {
		    properties.put(name, "Date");
		} else if (clazz.isAssignableFrom(Timestamp.class)) {
		    properties.put(name, "Timestamp");
		} else if (clazz.isAssignableFrom(Byte.class)) {
		    properties.put(name, "Byte");
		} else {
		    // properties.put(name, "Object");   
		}
	    }
	    String beanMethods = generateBeanMethods(properties, superProperties);
	    javaTemplateContents = javaTemplateContents.replaceAll("###BEAN_METHODS###", beanMethods);

	    String complexProperties = getComplexProperties(properties, superProperties);
	    javaTemplateContents = javaTemplateContents.replaceAll("###COMPLEX_PROPERTIES###", complexProperties);

	    System.out.println("writing " + javaFileName);
	    File javaClassFileName = new File(outputDirectory, javaFileName);
	    FileUtils.writeStringToFile(javaClassFileName, javaTemplateContents);

	} catch (Exception e) {
	    logError(e);
	}
    }

    private String generateBeanMethods(Map<String, String> properties, List<String> superProperties) {
	String beanMethods = "";
	Set<String> prpoertyKeys = properties.keySet();
	for (String key : prpoertyKeys) {
	    boolean superTypeNameConfilct = false;
	    if (superProperties.contains(key)) {
		superTypeNameConfilct = true;
	    }
	    String type = properties.get(key);
	    String typeCleaned = type.replace(getPackageName() + ".", "");

	    String methodName = getMethodName(key);
	    if (superTypeNameConfilct) {
		methodName = methodName + "This";
	    }
	    String memberVariableName = getMemberVariableName(key);
	    String setParamName = "p" + memberVariableName.substring(0, 1).toUpperCase() + memberVariableName.substring(1);

	    String itemType = getItemTypeFromType(typeCleaned);
	    boolean needWrapping = true;
	 // @formatter:off   
	   
	    itemType = itemType.replaceAll("java.lang.", "");
	    if (itemType.equals("String") || itemType.equals("Date") ||  itemType.equals("Timestamp") || itemType.equals("Boolean") || itemType.equals("Integer") || itemType.equals("Byte") || itemType.equals("byte[]") || itemType.equals("Short")  || itemType.equals("Float") || itemType.equals("Double") || itemType.equals("Long") ) {
		needWrapping = false;
	    }
	     
   
       if (typeCleaned.startsWith("List") && needWrapping) {
            beanMethods +="   public " + typeCleaned + " get" + methodName + "(){\n"
                         + "      return getListProperty(\"" + memberVariableName + "\", " +itemType + ".class);\n"
                         + "   }\n\n" 
                         + "   public void set" + methodName + "(" + typeCleaned + " " + setParamName + "){\n" 
                         + "       setListProperty(\"" + memberVariableName + "\", " + setParamName + ");\n" 
                         + "   } \n\n\n";
         } 
         else if (typeCleaned.startsWith("Set") && needWrapping) {
            beanMethods +="   public " + typeCleaned + " get" + methodName + "(){\n"
                        + "      return getSetProperty(\"" + memberVariableName + "\", " +itemType + ".class);\n"
                        + "   }\n\n" 
                        + "   public void set" + methodName + "(" + typeCleaned + " " + setParamName + "){\n" 
                        + "       setSetProperty(\"" + memberVariableName + "\", " + setParamName + ");\n" 
                        + "   } \n\n\n";
         } 
         else if (typeCleaned.startsWith("Map") && needWrapping) {
             //TODO fix the map  
             beanMethods +=  
        	           "   public " + typeCleaned + " get" + methodName + "(){\n"    
                         + "      " + typeCleaned + " x = (" + typeCleaned + ")getCachedData().get(\"" +  memberVariableName + "\");\n"
                         + "      if (x != null){  \n"
                         + "        return x;\n"
                         + "      } \n"
                         + "      x= (" + typeCleaned + ") wrapMap((Map<RepositoryItem>)getPropertyValue(\"" + key + "\"), getRepositoryId(), \"" + key + "\" ," + itemType + ".class);\n"
                         + "      getCachedData().put(\"" +  memberVariableName + "\",x); \n"
                         + "      return x;\n"
                         + "   }\n\n" 
                         + "   public void set" + methodName + "(" + typeCleaned + " " + setParamName + "){\n" 
                         + "       setPropertyValue(\"" + memberVariableName + "\", " + setParamName + ");\n" 
                         + "       getCachedData().put(\"" +  memberVariableName + "\", " + setParamName +"); \n"
                         + "   } \n\n\n";
         }
        else { 
           String supressWarning = ""; 
           String packageName = getPackageName();
           boolean isRepositoryItemBean = false;
           if (type.startsWith(packageName)) {
               isRepositoryItemBean =true; 
            }  
           //HACK
           if (typeCleaned.contains("<")) {
               itemType = getItemTypeFromType(typeCleaned); 
           }else {
               itemType = typeCleaned;
           }
          
           if (isRepositoryItemBean) { 
               beanMethods  += supressWarning
        	       + "   public " + typeCleaned + " get" + methodName + "(){\n"
                       + "      return getSingleRepositoryProperty(\"" + key+ "\"," + itemType + ".class);\n"
                       + "   }\n\n"   
                       + "   public void set" + methodName + "(" + typeCleaned + " " + setParamName+ "){\n"
                       + "      setSingleRepositoryProperty(\"" + memberVariableName + "\", " + setParamName + ");\n"
                       + "   }\n\n\n"  ; 
      	  } else {
               beanMethods  += supressWarning
      	               + "   public " + typeCleaned + " get" + methodName + "(){\n"
                       + "      return getSimpleProperty(\"" + key+ "\"," + itemType + ".class);\n"
                       + "   }\n\n"   
                       + "   public void set" + methodName + "(" + typeCleaned + " " + setParamName+ "){\n"
                       + "      setSimpleProperty(\"" + memberVariableName + "\", " + setParamName + ");\n"
                       + "   }\n\n\n"  ; 
            }
         }
     
     }
	return beanMethods;
// @formatter:on
    }

    private String getComplexProperties(Map<String, String> properties, List<String> superProperties) {
	String complexProperties = "";
	Set<String> prpoertyKeys = properties.keySet();
	for (String key : prpoertyKeys) {
	    String type = properties.get(key);
	    String typeCleaned = type.replace(getPackageName() + ".", "");

	    String memberVariableName = getMemberVariableName(key);
	    String itemType = getItemTypeFromType(typeCleaned);
	    String packageName = getPackageName();
	    if (!itemType.contains("java.") && ((typeCleaned.startsWith("List") || typeCleaned.startsWith("Map") || typeCleaned.startsWith("Set")) || (type.startsWith(packageName)))) {
		complexProperties += "          s.add(\"" + memberVariableName + "\");\n";
	    }
	}
	return complexProperties;
    }

    private String getItemTypeFromType(String type) {
	if (type == null || type.equals("") || type.indexOf('<') == -1) {
	    return "";
	}
	String[] parts = type.split("<");
	if (parts.length != 2) {
	    return "";
	} 
	String result = parts[1].replaceAll(">", "");
	result = result.replaceAll("java.lang.","");
	return result;
    }

    private List<String> getAllItemDescriptorsName() {
	String[] itemDescriptorNames = getItemDescriptorNames();
	List<String> list = Arrays.asList(itemDescriptorNames);
	return list;
    }

// @formatter:off 
    private static String javaTemplate() { 
   String result = "package ###PACKAGE_NAME###;                                                                                                     \n" + 
         "import java.util.*;                                                                                                                       \n" + 
	 "import java.util.Comparator;                                                                                                              \n" + 
         "import atg.repository.*;                                                                                                                  \n" + 
         "import java.sql.Timestamp;                                                                                                                \n" + 
         "import atg.adapter.gsa.MutableRepositoryItemExt;                                                                                          \n" + 
         "###EXTRA_IMPORTS###                                                                                                                       \n" + 
         "                                                                                                                                          \n" + 
         "@SuppressWarnings({ \"serial\", \"unused\" })                                                                                             \n" + 
         "public class ###CLASS_NAME### extends ###SUPER_CLASS_NAME### implements java.io.Serializable {                                            \n" + 
         "   static transient MutableRepository REPOSITORY;                                                                                         \n" + 
         "   static transient String DESCRIPTOR = ^###DESCRIPTOR_NAME###^;                                                                          \n" + 
         "   static transient String REPOSITORY_COMPONENT = ^###REPOSITORY_PATH###^;                                                                \n" + 
         "   static final transient Set<String> COMPLEX_PROPERTIES;                                                                                 \n" + 
         "                                                                                                                                          \n" + 
         "   static {                                                                                                                               \n" + 
         "     Set<String> s  = new HashSet<String>();                                                                                              \n" + 
         "###COMPLEX_PROPERTIES###                                                                                                                  \n" + 
         "     COMPLEX_PROPERTIES = s;                                                                                                              \n" + 
         "   }                                                                                                                                      \n" + 
         "                                                                                                                                          \n" + 
         "                                                                                                                                          \n" + 
         "   public ###CLASS_NAME###()  {                                                                                                           \n" + 
         "   }                                                                                                                                      \n" + 
         "                                                                                                                                          \n" + 
         "   public ###CLASS_NAME###(MutableRepositoryItem delegate) {                                                                              \n" + 
         "      super(delegate);                                                                                                                    \n" + 
         "   }                                                                                                                                      \n" + 
         "                                                                                                                                          \n" + 
         "   @Override                                                                                                                              \n" + 
         "   protected Set<String> getComplexProperties() {                                                                                         \n" + 
         "      return COMPLEX_PROPERTIES;                                                                                                          \n" + 
         "   }                                                                                                                                      \n" + 
         "                                                                                                                                          \n" + 
         "   @Override                                                                                                                              \n" + 
         "   protected String getDescriptor() {                                                                                                     \n" + 
         "      return DESCRIPTOR;                                                                                                                  \n" + 
         "   }                                                                                                                                      \n" + 
         "                                                                                                                                          \n" + 
         "   @Override                                                                                                                              \n" + 
         "   protected String getRepositoryComponent() {                                                                                            \n" + 
         "      return REPOSITORY_COMPONENT;                                                                                                        \n" + 
         "   }                                                                                                                                      \n" + 
         "                                                                                                                                          \n" + 
         "###BEAN_METHODS###                                                                                                                        \n" + 
         "}                                                                                                                                         \n" ;
        
   result = result.replace('^', '"');                                                                                           
   return result;                                                                                                               
    }                                                                                                                                
// @formatter:on

    private String outputDirectory;

    public String getOutputDirectory() {
	return outputDirectory;
    }

    public void setOutputDirectory(String outputDirectory) {
	this.outputDirectory = outputDirectory;
    }

}
