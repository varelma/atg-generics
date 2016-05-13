package atg.repository.beans.productcatalog;                                                                                                     
import java.util.*;                                                                                                                       
import java.util.Comparator;                                                                                                              
import atg.repository.*;                                                                                                                  
import java.sql.Timestamp;                                                                                                                
import atg.adapter.gsa.MutableRepositoryItemExt;                                                                                          

                                                                                                                       
                                                                                                                                          
@SuppressWarnings({ "serial", "unused" })                                                                                             
public class PromotionalContentTranslation extends MutableRepositoryItemExt implements java.io.Serializable {                                            
   static transient MutableRepository REPOSITORY;                                                                                         
   static transient String DESCRIPTOR = "promotionalContentTranslation";                                                                          
   static transient String REPOSITORY_COMPONENT = "/atg/commerce/catalog/ProductCatalog";                                                                
   static final transient Set<String> COMPLEX_PROPERTIES;                                                                                 
                                                                                                                                          
   static {                                                                                                                               
     Set<String> s  = new HashSet<String>();                                                                                              
                                                                                                                  
     COMPLEX_PROPERTIES = s;                                                                                                              
   }                                                                                                                                      
                                                                                                                                          
                                                                                                                                          
   public PromotionalContentTranslation()  {                                                                                                           
   }                                                                                                                                      
                                                                                                                                          
   public PromotionalContentTranslation(MutableRepositoryItem delegate) {                                                                              
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
                                                                                                                                          
   public String getStoreDisplayName(){
      return getSimpleProperty("storeDisplayName",String.class);
   }

   public void setStoreDisplayName(String pStoreDisplayName){
      setSimpleProperty("storeDisplayName", pStoreDisplayName);
   }


   public String getLinkUrl(){
      return getSimpleProperty("linkUrl",String.class);
   }

   public void setLinkUrl(String pLinkUrl){
      setSimpleProperty("linkUrl", pLinkUrl);
   }


   public String getLinkText(){
      return getSimpleProperty("linkText",String.class);
   }

   public void setLinkText(String pLinkText){
      setSimpleProperty("linkText", pLinkText);
   }


   public String getDescription(){
      return getSimpleProperty("description",String.class);
   }

   public void setDescription(String pDescription){
      setSimpleProperty("description", pDescription);
   }


   public String getLongDescription(){
      return getSimpleProperty("longDescription",String.class);
   }

   public void setLongDescription(String pLongDescription){
      setSimpleProperty("longDescription", pLongDescription);
   }


   public String getDisplayName(){
      return getSimpleProperty("displayName",String.class);
   }

   public void setDisplayName(String pDisplayName){
      setSimpleProperty("displayName", pDisplayName);
   }


                                                                                                                        
}                                                                                                                                         
