package atg.repository.beans.productcatalog;                                                                                                     
import java.util.*;                                                                                                                       
import java.util.Comparator;                                                                                                              
import atg.repository.*;                                                                                                                  
import java.sql.Timestamp;                                                                                                                
import atg.adapter.gsa.MutableRepositoryItemExt;                                                                                          

                                                                                                                       
                                                                                                                                          
@SuppressWarnings({ "serial", "unused" })                                                                                             
public class ClothingSkuTranslation extends SkuTranslation implements java.io.Serializable {                                            
   static transient MutableRepository REPOSITORY;                                                                                         
   static transient String DESCRIPTOR = "clothing-sku-translation";                                                                          
   static transient String REPOSITORY_COMPONENT = "/atg/commerce/catalog/ProductCatalog";                                                                
   static final transient Set<String> COMPLEX_PROPERTIES;                                                                                 
                                                                                                                                          
   static {                                                                                                                               
     Set<String> s  = new HashSet<String>();                                                                                              
                                                                                                                  
     COMPLEX_PROPERTIES = s;                                                                                                              
   }                                                                                                                                      
                                                                                                                                          
                                                                                                                                          
   public ClothingSkuTranslation()  {                                                                                                           
   }                                                                                                                                      
                                                                                                                                          
   public ClothingSkuTranslation(MutableRepositoryItem delegate) {                                                                              
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
                                                                                                                                          
   public String getColor(){
      return getSimpleProperty("color",String.class);
   }

   public void setColor(String pColor){
      setSimpleProperty("color", pColor);
   }


   public String getDescriptionThis(){
      return getSimpleProperty("description",String.class);
   }

   public void setDescriptionThis(String pDescription){
      setSimpleProperty("description", pDescription);
   }


   public Integer getTypeThis(){
      return getSimpleProperty("type",Integer.class);
   }

   public void setTypeThis(Integer pType){
      setSimpleProperty("type", pType);
   }


   public String getDisplayNameThis(){
      return getSimpleProperty("displayName",String.class);
   }

   public void setDisplayNameThis(String pDisplayName){
      setSimpleProperty("displayName", pDisplayName);
   }


   public String getSize(){
      return getSimpleProperty("size",String.class);
   }

   public void setSize(String pSize){
      setSimpleProperty("size", pSize);
   }


                                                                                                                        
}                                                                                                                                         
