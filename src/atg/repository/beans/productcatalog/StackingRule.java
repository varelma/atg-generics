package atg.repository.beans.productcatalog;                                                                                                     
import java.util.*;                                                                                                                       
import java.util.Comparator;                                                                                                              
import atg.repository.*;                                                                                                                  
import java.sql.Timestamp;                                                                                                                
import atg.adapter.gsa.MutableRepositoryItemExt;                                                                                          

                                                                                                                       
                                                                                                                                          
@SuppressWarnings({ "serial", "unused" })                                                                                             
public class StackingRule extends MutableRepositoryItemExt implements java.io.Serializable {                                            
   static transient MutableRepository REPOSITORY;                                                                                         
   static transient String DESCRIPTOR = "stackingRule";                                                                          
   static transient String REPOSITORY_COMPONENT = "/atg/commerce/catalog/ProductCatalog";                                                                
   static final transient Set<String> COMPLEX_PROPERTIES;                                                                                 
                                                                                                                                          
   static {                                                                                                                               
     Set<String> s  = new HashSet<String>();                                                                                              
          s.add("excludedStackingRules");
                                                                                                                  
     COMPLEX_PROPERTIES = s;                                                                                                              
   }                                                                                                                                      
                                                                                                                                          
                                                                                                                                          
   public StackingRule()  {                                                                                                           
   }                                                                                                                                      
                                                                                                                                          
   public StackingRule(MutableRepositoryItem delegate) {                                                                              
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


   public Timestamp getLastModified(){
      return getSimpleProperty("lastModified",Timestamp.class);
   }

   public void setLastModified(Timestamp pLastModified){
      setSimpleProperty("lastModified", pLastModified);
   }


   public Set<StackingRule> getExcludedStackingRules(){
      return getSetProperty("excludedStackingRules", StackingRule.class);
   }

   public void setExcludedStackingRules(Set<StackingRule> pExcludedStackingRules){
       setSetProperty("excludedStackingRules", pExcludedStackingRules);
   } 


   public Integer getOrderLimits(){
      return getSimpleProperty("orderLimits",Integer.class);
   }

   public void setOrderLimits(Integer pOrderLimits){
      setSimpleProperty("orderLimits", pOrderLimits);
   }


   public String getDisplayName(){
      return getSimpleProperty("displayName",String.class);
   }

   public void setDisplayName(String pDisplayName){
      setSimpleProperty("displayName", pDisplayName);
   }


                                                                                                                        
}                                                                                                                                         
