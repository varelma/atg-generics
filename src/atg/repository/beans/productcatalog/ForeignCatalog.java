package atg.repository.beans.productcatalog;                                                                                                     
import java.util.*;                                                                                                                       
import java.util.Comparator;                                                                                                              
import atg.repository.*;                                                                                                                  
import java.sql.Timestamp;                                                                                                                
import atg.adapter.gsa.MutableRepositoryItemExt;                                                                                          

                                                                                                                       
                                                                                                                                          
@SuppressWarnings({ "serial", "unused" })                                                                                             
public class ForeignCatalog extends MutableRepositoryItemExt implements java.io.Serializable {                                            
   static transient MutableRepository REPOSITORY;                                                                                         
   static transient String DESCRIPTOR = "foreignCatalog";                                                                          
   static transient String REPOSITORY_COMPONENT = "/atg/commerce/catalog/ProductCatalog";                                                                
   static final transient Set<String> COMPLEX_PROPERTIES;                                                                                 
                                                                                                                                          
   static {                                                                                                                               
     Set<String> s  = new HashSet<String>();                                                                                              
                                                                                                                  
     COMPLEX_PROPERTIES = s;                                                                                                              
   }                                                                                                                                      
                                                                                                                                          
                                                                                                                                          
   public ForeignCatalog()  {                                                                                                           
   }                                                                                                                                      
                                                                                                                                          
   public ForeignCatalog(MutableRepositoryItem delegate) {                                                                              
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


   public Integer getPort(){
      return getSimpleProperty("port",Integer.class);
   }

   public void setPort(Integer pPort){
      setSimpleProperty("port", pPort);
   }


   public String getItemAcl(){
      return getSimpleProperty("itemAcl",String.class);
   }

   public void setItemAcl(String pItemAcl){
      setSimpleProperty("itemAcl", pItemAcl);
   }


   public String getHost(){
      return getSimpleProperty("host",String.class);
   }

   public void setHost(String pHost){
      setSimpleProperty("host", pHost);
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


   public String getBaseURL(){
      return getSimpleProperty("baseURL",String.class);
   }

   public void setBaseURL(String pBaseURL){
      setSimpleProperty("baseURL", pBaseURL);
   }


   public String getType(){
      return getSimpleProperty("type",String.class);
   }

   public void setType(String pType){
      setSimpleProperty("type", pType);
   }


   public Integer getVersion(){
      return getSimpleProperty("version",Integer.class);
   }

   public void setVersion(Integer pVersion){
      setSimpleProperty("version", pVersion);
   }


   public String getReturnURL(){
      return getSimpleProperty("returnURL",String.class);
   }

   public void setReturnURL(String pReturnURL){
      setSimpleProperty("returnURL", pReturnURL);
   }


                                                                                                                        
}                                                                                                                                         
