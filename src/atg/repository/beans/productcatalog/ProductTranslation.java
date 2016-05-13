package atg.repository.beans.productcatalog;                                                                                                     
import java.util.*;                                                                                                                       
import java.util.Comparator;                                                                                                              
import atg.repository.*;                                                                                                                  
import java.sql.Timestamp;                                                                                                                
import atg.adapter.gsa.MutableRepositoryItemExt;                                                                                          

                                                                                                                       
                                                                                                                                          
@SuppressWarnings({ "serial", "unused" })                                                                                             
public class ProductTranslation extends MutableRepositoryItemExt implements java.io.Serializable {                                            
   static transient MutableRepository REPOSITORY;                                                                                         
   static transient String DESCRIPTOR = "productTranslation";                                                                          
   static transient String REPOSITORY_COMPONENT = "/atg/commerce/catalog/ProductCatalog";                                                                
   static final transient Set<String> COMPLEX_PROPERTIES;                                                                                 
                                                                                                                                          
   static {                                                                                                                               
     Set<String> s  = new HashSet<String>();                                                                                              
          s.add("keywords");
          s.add("productTips");
                                                                                                                  
     COMPLEX_PROPERTIES = s;                                                                                                              
   }                                                                                                                                      
                                                                                                                                          
                                                                                                                                          
   public ProductTranslation()  {                                                                                                           
   }                                                                                                                                      
                                                                                                                                          
   public ProductTranslation(MutableRepositoryItem delegate) {                                                                              
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
                                                                                                                                          
   public List<java.lang.String> getKeywords(){
      return getSimpleProperty("keywords",String.class);
   }

   public void setKeywords(List<java.lang.String> pKeywords){
      setSimpleProperty("keywords", pKeywords);
   }


   public String getBriefDescription(){
      return getSimpleProperty("briefDescription",String.class);
   }

   public void setBriefDescription(String pBriefDescription){
      setSimpleProperty("briefDescription", pBriefDescription);
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


   public String getUsageInstructions(){
      return getSimpleProperty("usageInstructions",String.class);
   }

   public void setUsageInstructions(String pUsageInstructions){
      setSimpleProperty("usageInstructions", pUsageInstructions);
   }


   public String getDisplayName(){
      return getSimpleProperty("displayName",String.class);
   }

   public void setDisplayName(String pDisplayName){
      setSimpleProperty("displayName", pDisplayName);
   }


   public List<java.lang.String> getProductTips(){
      return getSimpleProperty("productTips",String.class);
   }

   public void setProductTips(List<java.lang.String> pProductTips){
      setSimpleProperty("productTips", pProductTips);
   }


                                                                                                                        
}                                                                                                                                         
