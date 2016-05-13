package atg.repository.beans.productcatalog;                                                                                                     
import java.util.*;                                                                                                                       
import java.util.Comparator;                                                                                                              
import atg.repository.*;                                                                                                                  
import java.sql.Timestamp;                                                                                                                
import atg.adapter.gsa.MutableRepositoryItemExt;                                                                                          

                                                                                                                       
                                                                                                                                          
@SuppressWarnings({ "serial", "unused" })                                                                                             
public class MediaExternal extends Media implements java.io.Serializable {                                            
   static transient MutableRepository REPOSITORY;                                                                                         
   static transient String DESCRIPTOR = "media-external";                                                                          
   static transient String REPOSITORY_COMPONENT = "/atg/commerce/catalog/ProductCatalog";                                                                
   static final transient Set<String> COMPLEX_PROPERTIES;                                                                                 
                                                                                                                                          
   static {                                                                                                                               
     Set<String> s  = new HashSet<String>();                                                                                              
          s.add("parentFolder");
                                                                                                                  
     COMPLEX_PROPERTIES = s;                                                                                                              
   }                                                                                                                                      
                                                                                                                                          
                                                                                                                                          
   public MediaExternal()  {                                                                                                           
   }                                                                                                                                      
                                                                                                                                          
   public MediaExternal(MutableRepositoryItem delegate) {                                                                              
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
                                                                                                                                          
   public String getIdThis(){
      return getSimpleProperty("id",String.class);
   }

   public void setIdThis(String pId){
      setSimpleProperty("id", pId);
   }


   public Timestamp getStartDateThis(){
      return getSimpleProperty("startDate",Timestamp.class);
   }

   public void setStartDateThis(Timestamp pStartDate){
      setSimpleProperty("startDate", pStartDate);
   }


   public Timestamp getCreationDateThis(){
      return getSimpleProperty("creationDate",Timestamp.class);
   }

   public void setCreationDateThis(Timestamp pCreationDate){
      setSimpleProperty("creationDate", pCreationDate);
   }


   public MediaExternal getParentFolderThis(){
      return getSingleRepositoryProperty("parentFolder",MediaExternal.class);
   }

   public void setParentFolderThis(MediaExternal pParentFolder){
      setSingleRepositoryProperty("parentFolder", pParentFolder);
   }


   public String getDescriptionThis(){
      return getSimpleProperty("description",String.class);
   }

   public void setDescriptionThis(String pDescription){
      setSimpleProperty("description", pDescription);
   }


   public String getNameThis(){
      return getSimpleProperty("name",String.class);
   }

   public void setNameThis(String pName){
      setSimpleProperty("name", pName);
   }


   public String getPathThis(){
      return getSimpleProperty("path",String.class);
   }

   public void setPathThis(String pPath){
      setSimpleProperty("path", pPath);
   }


   public Timestamp getEndDateThis(){
      return getSimpleProperty("endDate",Timestamp.class);
   }

   public void setEndDateThis(Timestamp pEndDate){
      setSimpleProperty("endDate", pEndDate);
   }


   public Integer getTypeThis(){
      return getSimpleProperty("type",Integer.class);
   }

   public void setTypeThis(Integer pType){
      setSimpleProperty("type", pType);
   }


   public String getUrlThis(){
      return getSimpleProperty("url",String.class);
   }

   public void setUrlThis(String pUrl){
      setSimpleProperty("url", pUrl);
   }


   public String getMimeType(){
      return getSimpleProperty("mimeType",String.class);
   }

   public void setMimeType(String pMimeType){
      setSimpleProperty("mimeType", pMimeType);
   }


   public Integer getVersionThis(){
      return getSimpleProperty("version",Integer.class);
   }

   public void setVersionThis(Integer pVersion){
      setSimpleProperty("version", pVersion);
   }


                                                                                                                        
}                                                                                                                                         
