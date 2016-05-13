package atg.repository.beans.productcatalog;                                                                                                     
import java.util.*;                                                                                                                       
import java.util.Comparator;                                                                                                              
import atg.repository.*;                                                                                                                  
import java.sql.Timestamp;                                                                                                                
import atg.adapter.gsa.MutableRepositoryItemExt;                                                                                          

                                                                                                                       
                                                                                                                                          
@SuppressWarnings({ "serial", "unused" })                                                                                             
public class Folder extends MutableRepositoryItemExt implements java.io.Serializable {                                            
   static transient MutableRepository REPOSITORY;                                                                                         
   static transient String DESCRIPTOR = "folder";                                                                          
   static transient String REPOSITORY_COMPONENT = "/atg/commerce/catalog/ProductCatalog";                                                                
   static final transient Set<String> COMPLEX_PROPERTIES;                                                                                 
                                                                                                                                          
   static {                                                                                                                               
     Set<String> s  = new HashSet<String>();                                                                                              
          s.add("parentFolder");
                                                                                                                  
     COMPLEX_PROPERTIES = s;                                                                                                              
   }                                                                                                                                      
                                                                                                                                          
                                                                                                                                          
   public Folder()  {                                                                                                           
   }                                                                                                                                      
                                                                                                                                          
   public Folder(MutableRepositoryItem delegate) {                                                                              
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


   public Timestamp getStartDate(){
      return getSimpleProperty("startDate",Timestamp.class);
   }

   public void setStartDate(Timestamp pStartDate){
      setSimpleProperty("startDate", pStartDate);
   }


   public Timestamp getCreationDate(){
      return getSimpleProperty("creationDate",Timestamp.class);
   }

   public void setCreationDate(Timestamp pCreationDate){
      setSimpleProperty("creationDate", pCreationDate);
   }


   public Folder getParentFolder(){
      return getSingleRepositoryProperty("parentFolder",Folder.class);
   }

   public void setParentFolder(Folder pParentFolder){
      setSingleRepositoryProperty("parentFolder", pParentFolder);
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


   public String getPath(){
      return getSimpleProperty("path",String.class);
   }

   public void setPath(String pPath){
      setSimpleProperty("path", pPath);
   }


   public Timestamp getEndDate(){
      return getSimpleProperty("endDate",Timestamp.class);
   }

   public void setEndDate(Timestamp pEndDate){
      setSimpleProperty("endDate", pEndDate);
   }


   public Integer getVersion(){
      return getSimpleProperty("version",Integer.class);
   }

   public void setVersion(Integer pVersion){
      setSimpleProperty("version", pVersion);
   }


                                                                                                                        
}                                                                                                                                         
