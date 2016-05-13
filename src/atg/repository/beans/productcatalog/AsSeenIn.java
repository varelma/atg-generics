package atg.repository.beans.productcatalog;                                                                                                     
import java.util.*;                                                                                                                       
import java.util.Comparator;                                                                                                              
import atg.repository.*;                                                                                                                  
import java.sql.Timestamp;                                                                                                                
import atg.adapter.gsa.MutableRepositoryItemExt;                                                                                          

                                                                                                                       
                                                                                                                                          
@SuppressWarnings({ "serial", "unused" })                                                                                             
public class AsSeenIn extends MutableRepositoryItemExt implements java.io.Serializable {                                            
   static transient MutableRepository REPOSITORY;                                                                                         
   static transient String DESCRIPTOR = "asSeenIn";                                                                          
   static transient String REPOSITORY_COMPONENT = "/atg/commerce/catalog/ProductCatalog";                                                                
   static final transient Set<String> COMPLEX_PROPERTIES;                                                                                 
                                                                                                                                          
   static {                                                                                                                               
     Set<String> s  = new HashSet<String>();                                                                                              
                                                                                                                  
     COMPLEX_PROPERTIES = s;                                                                                                              
   }                                                                                                                                      
                                                                                                                                          
                                                                                                                                          
   public AsSeenIn()  {                                                                                                           
   }                                                                                                                                      
                                                                                                                                          
   public AsSeenIn(MutableRepositoryItem delegate) {                                                                              
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


   public String getDisplayNameDefault(){
      return getSimpleProperty("displayNameDefault",String.class);
   }

   public void setDisplayNameDefault(String pDisplayNameDefault){
      setSimpleProperty("displayNameDefault", pDisplayNameDefault);
   }


   public String getSource(){
      return getSimpleProperty("source",String.class);
   }

   public void setSource(String pSource){
      setSimpleProperty("source", pSource);
   }


   public String getSourceDefault(){
      return getSimpleProperty("sourceDefault",String.class);
   }

   public void setSourceDefault(String pSourceDefault){
      setSimpleProperty("sourceDefault", pSourceDefault);
   }


   public String getDescription(){
      return getSimpleProperty("description",String.class);
   }

   public void setDescription(String pDescription){
      setSimpleProperty("description", pDescription);
   }


   public String getDescriptionDefault(){
      return getSimpleProperty("descriptionDefault",String.class);
   }

   public void setDescriptionDefault(String pDescriptionDefault){
      setSimpleProperty("descriptionDefault", pDescriptionDefault);
   }


   public Timestamp getDate(){
      return getSimpleProperty("date",Timestamp.class);
   }

   public void setDate(Timestamp pDate){
      setSimpleProperty("date", pDate);
   }


   public String getDisplayName(){
      return getSimpleProperty("displayName",String.class);
   }

   public void setDisplayName(String pDisplayName){
      setSimpleProperty("displayName", pDisplayName);
   }


   public Integer getVersion(){
      return getSimpleProperty("version",Integer.class);
   }

   public void setVersion(Integer pVersion){
      setSimpleProperty("version", pVersion);
   }


                                                                                                                        
}                                                                                                                                         
