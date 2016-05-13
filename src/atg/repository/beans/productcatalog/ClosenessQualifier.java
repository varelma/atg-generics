package atg.repository.beans.productcatalog;                                                                                                     
import java.util.*;                                                                                                                       
import java.util.Comparator;                                                                                                              
import atg.repository.*;                                                                                                                  
import java.sql.Timestamp;                                                                                                                
import atg.adapter.gsa.MutableRepositoryItemExt;                                                                                          

                                                                                                                       
                                                                                                                                          
@SuppressWarnings({ "serial", "unused" })                                                                                             
public class ClosenessQualifier extends MutableRepositoryItemExt implements java.io.Serializable {                                            
   static transient MutableRepository REPOSITORY;                                                                                         
   static transient String DESCRIPTOR = "closenessQualifier";                                                                          
   static transient String REPOSITORY_COMPONENT = "/atg/commerce/catalog/ProductCatalog";                                                                
   static final transient Set<String> COMPLEX_PROPERTIES;                                                                                 
                                                                                                                                          
   static {                                                                                                                               
     Set<String> s  = new HashSet<String>();                                                                                              
          s.add("upsellAction");
          s.add("promotion");
          s.add("upsellMedia");
                                                                                                                  
     COMPLEX_PROPERTIES = s;                                                                                                              
   }                                                                                                                                      
                                                                                                                                          
                                                                                                                                          
   public ClosenessQualifier()  {                                                                                                           
   }                                                                                                                                      
                                                                                                                                          
   public ClosenessQualifier(MutableRepositoryItem delegate) {                                                                              
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
                                                                                                                                          
   public ClosenessQualifier getUpsellAction(){
      return getSingleRepositoryProperty("upsellAction",ClosenessQualifier.class);
   }

   public void setUpsellAction(ClosenessQualifier pUpsellAction){
      setSingleRepositoryProperty("upsellAction", pUpsellAction);
   }


   public String getId(){
      return getSimpleProperty("id",String.class);
   }

   public void setId(String pId){
      setSimpleProperty("id", pId);
   }


   public Integer getPriority(){
      return getSimpleProperty("priority",Integer.class);
   }

   public void setPriority(Integer pPriority){
      setSimpleProperty("priority", pPriority);
   }


   public String getName(){
      return getSimpleProperty("name",String.class);
   }

   public void setName(String pName){
      setSimpleProperty("name", pName);
   }


   public ClosenessQualifier getPromotion(){
      return getSingleRepositoryProperty("promotion",ClosenessQualifier.class);
   }

   public void setPromotion(ClosenessQualifier pPromotion){
      setSingleRepositoryProperty("promotion", pPromotion);
   }


   public ClosenessQualifier getUpsellMedia(){
      return getSingleRepositoryProperty("upsellMedia",ClosenessQualifier.class);
   }

   public void setUpsellMedia(ClosenessQualifier pUpsellMedia){
      setSingleRepositoryProperty("upsellMedia", pUpsellMedia);
   }


   public String getNameDefault(){
      return getSimpleProperty("nameDefault",String.class);
   }

   public void setNameDefault(String pNameDefault){
      setSimpleProperty("nameDefault", pNameDefault);
   }


   public String getPmdlRule(){
      return getSimpleProperty("pmdlRule",String.class);
   }

   public void setPmdlRule(String pPmdlRule){
      setSimpleProperty("pmdlRule", pPmdlRule);
   }


   public Integer getVersion(){
      return getSimpleProperty("version",Integer.class);
   }

   public void setVersion(Integer pVersion){
      setSimpleProperty("version", pVersion);
   }


                                                                                                                        
}                                                                                                                                         
