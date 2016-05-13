package atg.repository.beans.productcatalog;                                                                                                     
import java.util.*;                                                                                                                       
import java.util.Comparator;                                                                                                              
import atg.repository.*;                                                                                                                  
import java.sql.Timestamp;                                                                                                                
import atg.adapter.gsa.MutableRepositoryItemExt;                                                                                          

                                                                                                                       
                                                                                                                                          
@SuppressWarnings({ "serial", "unused" })                                                                                             
public class UpsellAction extends MutableRepositoryItemExt implements java.io.Serializable {                                            
   static transient MutableRepository REPOSITORY;                                                                                         
   static transient String DESCRIPTOR = "upsellAction";                                                                          
   static transient String REPOSITORY_COMPONENT = "/atg/commerce/catalog/ProductCatalog";                                                                
   static final transient Set<String> COMPLEX_PROPERTIES;                                                                                 
                                                                                                                                          
   static {                                                                                                                               
     Set<String> s  = new HashSet<String>();                                                                                              
          s.add("upsellProducts");
          s.add("fixedUpsellProducts");
          s.add("dynamicUpsellProducts");
                                                                                                                  
     COMPLEX_PROPERTIES = s;                                                                                                              
   }                                                                                                                                      
                                                                                                                                          
                                                                                                                                          
   public UpsellAction()  {                                                                                                           
   }                                                                                                                                      
                                                                                                                                          
   public UpsellAction(MutableRepositoryItem delegate) {                                                                              
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


   public String getName(){
      return getSimpleProperty("name",String.class);
   }

   public void setName(String pName){
      setSimpleProperty("name", pName);
   }


   public String getUpsellProductsGroup(){
      return getSimpleProperty("upsellProductsGroup",String.class);
   }

   public void setUpsellProductsGroup(String pUpsellProductsGroup){
      setSimpleProperty("upsellProductsGroup", pUpsellProductsGroup);
   }


   public List<Product> getUpsellProducts(){
      return getListProperty("upsellProducts", Product.class);
   }

   public void setUpsellProducts(List<Product> pUpsellProducts){
       setListProperty("upsellProducts", pUpsellProducts);
   } 


   public List<Product> getFixedUpsellProducts(){
      return getListProperty("fixedUpsellProducts", Product.class);
   }

   public void setFixedUpsellProducts(List<Product> pFixedUpsellProducts){
       setListProperty("fixedUpsellProducts", pFixedUpsellProducts);
   } 


   public List<Product> getDynamicUpsellProducts(){
      return getListProperty("dynamicUpsellProducts", Product.class);
   }

   public void setDynamicUpsellProducts(List<Product> pDynamicUpsellProducts){
       setListProperty("dynamicUpsellProducts", pDynamicUpsellProducts);
   } 


   public Integer getVersion(){
      return getSimpleProperty("version",Integer.class);
   }

   public void setVersion(Integer pVersion){
      setSimpleProperty("version", pVersion);
   }


                                                                                                                        
}                                                                                                                                         
