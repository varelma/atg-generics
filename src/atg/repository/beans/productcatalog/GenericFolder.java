package atg.repository.beans.productcatalog;                                                                                                     
import java.util.*;                                                                                                                       
import java.util.Comparator;                                                                                                              
import atg.repository.*;                                                                                                                  
import java.sql.Timestamp;                                                                                                                
import atg.adapter.gsa.MutableRepositoryItemExt;                                                                                          

                                                                                                                       
                                                                                                                                          
@SuppressWarnings({ "serial", "unused" })                                                                                             
public class GenericFolder extends MutableRepositoryItemExt implements java.io.Serializable {                                            
   static transient MutableRepository REPOSITORY;                                                                                         
   static transient String DESCRIPTOR = "genericFolder";                                                                          
   static transient String REPOSITORY_COMPONENT = "/atg/commerce/catalog/ProductCatalog";                                                                
   static final transient Set<String> COMPLEX_PROPERTIES;                                                                                 
                                                                                                                                          
   static {                                                                                                                               
     Set<String> s  = new HashSet<String>();                                                                                              
          s.add("parentFolders");
          s.add("parent");
          s.add("childFolders");
                                                                                                                  
     COMPLEX_PROPERTIES = s;                                                                                                              
   }                                                                                                                                      
                                                                                                                                          
                                                                                                                                          
   public GenericFolder()  {                                                                                                           
   }                                                                                                                                      
                                                                                                                                          
   public GenericFolder(MutableRepositoryItem delegate) {                                                                              
      super(delegate);                                                                                                                    
   }                                                                                                                                      
                                                                                                                                          
   @Override                                                                                                                              
   protected Set<String> getComplexProperties() {                                                                                         
      return COMPLEX_PROPERTIES;                                                                                                          
   }                                                                                                                                      
                                                                                                                                          
   @Override                                                                                                                              
   protected String getDescriptor() {                                                                                                     
      return DESCRIPTOR;                                                                                                                  
   }                                                                                                                                      
                                                                                                                                          
   @Override                                                                                                                              
   protected String getRepositoryComponent() {                                                                                            
      return REPOSITORY_COMPONENT;                                                                                                        
   }                                                                                                                                      
                                                                                                                                          
   public String getId(){
      return getSimpleProperty("id",String.class);
   }

   public void setId(String pId){
      setSimpleProperty("id", pId);
   }


   public String getItemAcl(){
      return getSimpleProperty("itemAcl",String.class);
   }

   public void setItemAcl(String pItemAcl){
      setSimpleProperty("itemAcl", pItemAcl);
   }


   public String getChildItems(){
      return getSimpleProperty("childItems",String.class);
   }

   public void setChildItems(String pChildItems){
      setSimpleProperty("childItems", pChildItems);
   }


   public Set<GenericFolder> getParentFolders(){
      return getSetProperty("parentFolders", GenericFolder.class);
   }

   public void setParentFolders(Set<GenericFolder> pParentFolders){
       setSetProperty("parentFolders", pParentFolders);
   } 


   public String getDescription(){
      return getSimpleProperty("description",String.class);
   }

   public void setDescription(String pDescription){
      setSimpleProperty("description", pDescription);
   }


   public String getName(){
      return getSimpleProperty("name",String.class);
   }

   public void setName(String pName){
      setSimpleProperty("name", pName);
   }


   public GenericFolder getParent(){
      return getSingleRepositoryProperty("parent",GenericFolder.class);
   }

   public void setParent(GenericFolder pParent){
      setSingleRepositoryProperty("parent", pParent);
   }


   public String getType(){
      return getSimpleProperty("type",String.class);
   }

   public void setType(String pType){
      setSimpleProperty("type", pType);
   }


   public List<GenericFolder> getChildFolders(){
      return getListProperty("childFolders", GenericFolder.class);
   }

   public void setChildFolders(List<GenericFolder> pChildFolders){
       setListProperty("childFolders", pChildFolders);
   } 


                                                                                                                        
}                                                                                                                                         
