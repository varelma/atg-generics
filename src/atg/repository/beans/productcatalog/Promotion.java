package atg.repository.beans.productcatalog;                                                                                                     
import java.util.*;                                                                                                                       
import java.util.Comparator;                                                                                                              
import atg.repository.*;                                                                                                                  
import java.sql.Timestamp;                                                                                                                
import atg.adapter.gsa.MutableRepositoryItemExt;                                                                                          

                                                                                                                       
                                                                                                                                          
@SuppressWarnings({ "serial", "unused" })                                                                                             
public class Promotion extends MutableRepositoryItemExt implements java.io.Serializable {                                            
   static transient MutableRepository REPOSITORY;                                                                                         
   static transient String DESCRIPTOR = "promotion";                                                                          
   static transient String REPOSITORY_COMPONENT = "/atg/commerce/catalog/ProductCatalog";                                                                
   static final transient Set<String> COMPLEX_PROPERTIES;                                                                                 
                                                                                                                                          
   static {                                                                                                                               
     Set<String> s  = new HashSet<String>();                                                                                              
          s.add("parentFolder");
          s.add("closenessQualifiers");
          s.add("excludedPromotions");
          s.add("includedPromotions");
          s.add("siteGroups");
          s.add("sites");
          s.add("stackingRule");
                                                                                                                  
     COMPLEX_PROPERTIES = s;                                                                                                              
   }                                                                                                                                      
                                                                                                                                          
                                                                                                                                          
   public Promotion()  {                                                                                                           
   }                                                                                                                                      
                                                                                                                                          
   public Promotion(MutableRepositoryItem delegate) {                                                                              
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
                                                                                                                                          
   public Timestamp getStartDate(){
      return getSimpleProperty("startDate",Timestamp.class);
   }

   public void setStartDate(Timestamp pStartDate){
      setSimpleProperty("startDate", pStartDate);
   }


   public Boolean getGiveToAnonymousProfiles(){
      return getSimpleProperty("giveToAnonymousProfiles",Boolean.class);
   }

   public void setGiveToAnonymousProfiles(Boolean pGiveToAnonymousProfiles){
      setSimpleProperty("giveToAnonymousProfiles", pGiveToAnonymousProfiles);
   }


   public Promotion getParentFolder(){
      return getSingleRepositoryProperty("parentFolder",Promotion.class);
   }

   public void setParentFolder(Promotion pParentFolder){
      setSingleRepositoryProperty("parentFolder", pParentFolder);
   }


   public Boolean getFilterForQualifierOnSale(){
      return getSimpleProperty("filterForQualifierOnSale",Boolean.class);
   }

   public void setFilterForQualifierOnSale(Boolean pFilterForQualifierOnSale){
      setSimpleProperty("filterForQualifierOnSale", pFilterForQualifierOnSale);
   }


   public Set<ClosenessQualifier> getClosenessQualifiers(){
      return getSetProperty("closenessQualifiers", ClosenessQualifier.class);
   }

   public void setClosenessQualifiers(Set<ClosenessQualifier> pClosenessQualifiers){
       setSetProperty("closenessQualifiers", pClosenessQualifiers);
   } 


   public String getQualifierService(){
      return getSimpleProperty("qualifierService",String.class);
   }

   public void setQualifierService(String pQualifierService){
      setSimpleProperty("qualifierService", pQualifierService);
   }


   public Timestamp getBeginUsable(){
      return getSimpleProperty("beginUsable",Timestamp.class);
   }

   public void setBeginUsable(Timestamp pBeginUsable){
      setSimpleProperty("beginUsable", pBeginUsable);
   }


   public Set<Promotion> getExcludedPromotions(){
      return getSetProperty("excludedPromotions", Promotion.class);
   }

   public void setExcludedPromotions(Set<Promotion> pExcludedPromotions){
       setSetProperty("excludedPromotions", pExcludedPromotions);
   } 


   public String getDiscountDescription(){
      return getSimpleProperty("discountDescription",String.class);
   }

   public void setDiscountDescription(String pDiscountDescription){
      setSimpleProperty("discountDescription", pDiscountDescription);
   }


   public Timestamp getEndDate(){
      return getSimpleProperty("endDate",Timestamp.class);
   }

   public void setEndDate(Timestamp pEndDate){
      setSimpleProperty("endDate", pEndDate);
   }


   public Integer getType(){
      return getSimpleProperty("type",Integer.class);
   }

   public void setType(Integer pType){
      setSimpleProperty("type", pType);
   }


   public Boolean getEvaluateTargetItemsFirst(){
      return getSimpleProperty("evaluateTargetItemsFirst",Boolean.class);
   }

   public void setEvaluateTargetItemsFirst(Boolean pEvaluateTargetItemsFirst){
      setSimpleProperty("evaluateTargetItemsFirst", pEvaluateTargetItemsFirst);
   }


   public Boolean getIsSiteRestricted(){
      return getSimpleProperty("isSiteRestricted",Boolean.class);
   }

   public void setIsSiteRestricted(Boolean pIsSiteRestricted){
      setSimpleProperty("isSiteRestricted", pIsSiteRestricted);
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


   public String getId(){
      return getSimpleProperty("id",String.class);
   }

   public void setId(String pId){
      setSimpleProperty("id", pId);
   }


   public String getDescription(){
      return getSimpleProperty("description",String.class);
   }

   public void setDescription(String pDescription){
      setSimpleProperty("description", pDescription);
   }


   public Integer getPriority(){
      return getSimpleProperty("priority",Integer.class);
   }

   public void setPriority(Integer pPriority){
      setSimpleProperty("priority", pPriority);
   }


   public Boolean getAllowMultiple(){
      return getSimpleProperty("allowMultiple",Boolean.class);
   }

   public void setAllowMultiple(Boolean pAllowMultiple){
      setSimpleProperty("allowMultiple", pAllowMultiple);
   }


   public Set<Promotion> getIncludedPromotions(){
      return getSetProperty("includedPromotions", Promotion.class);
   }

   public void setIncludedPromotions(Set<Promotion> pIncludedPromotions){
       setSetProperty("includedPromotions", pIncludedPromotions);
   } 


   public Integer getPmdlVersion(){
      return getSimpleProperty("pmdlVersion",Integer.class);
   }

   public void setPmdlVersion(Integer pPmdlVersion){
      setSimpleProperty("pmdlVersion", pPmdlVersion);
   }


   public Timestamp getEndUsable(){
      return getSimpleProperty("endUsable",Timestamp.class);
   }

   public void setEndUsable(Timestamp pEndUsable){
      setSimpleProperty("endUsable", pEndUsable);
   }


   public Set<Object> getSiteGroups(){
      return getSetProperty("siteGroups", Object.class);
   }

   public void setSiteGroups(Set<Object> pSiteGroups){
       setSetProperty("siteGroups", pSiteGroups);
   } 


   public Boolean getUpsell(){
      return getSimpleProperty("upsell",Boolean.class);
   }

   public void setUpsell(Boolean pUpsell){
      setSimpleProperty("upsell", pUpsell);
   }


   public Boolean getFilterForQualifierDiscountedByAny(){
      return getSimpleProperty("filterForQualifierDiscountedByAny",Boolean.class);
   }

   public void setFilterForQualifierDiscountedByAny(Boolean pFilterForQualifierDiscountedByAny){
      setSimpleProperty("filterForQualifierDiscountedByAny", pFilterForQualifierDiscountedByAny);
   }


   public String getTemplate(){
      return getSimpleProperty("template",String.class);
   }

   public void setTemplate(String pTemplate){
      setSimpleProperty("template", pTemplate);
   }


   public Set<Object> getSites(){
      return getSetProperty("sites", Object.class);
   }

   public void setSites(Set<Object> pSites){
       setSetProperty("sites", pSites);
   } 


   public Boolean getEnabled(){
      return getSimpleProperty("enabled",Boolean.class);
   }

   public void setEnabled(Boolean pEnabled){
      setSimpleProperty("enabled", pEnabled);
   }


   public String getDisplayNameDefault(){
      return getSimpleProperty("displayNameDefault",String.class);
   }

   public void setDisplayNameDefault(String pDisplayNameDefault){
      setSimpleProperty("displayNameDefault", pDisplayNameDefault);
   }


   public Timestamp getLastModified(){
      return getSimpleProperty("lastModified",Timestamp.class);
   }

   public void setLastModified(Timestamp pLastModified){
      setSimpleProperty("lastModified", pLastModified);
   }


   public Boolean getGlobal(){
      return getSimpleProperty("global",Boolean.class);
   }

   public void setGlobal(Boolean pGlobal){
      setSimpleProperty("global", pGlobal);
   }


   public String getUiAccessLevel(){
      return getSimpleProperty("uiAccessLevel",String.class);
   }

   public void setUiAccessLevel(String pUiAccessLevel){
      setSimpleProperty("uiAccessLevel", pUiAccessLevel);
   }


   public Timestamp getCreationDate(){
      return getSimpleProperty("creationDate",Timestamp.class);
   }

   public void setCreationDate(Timestamp pCreationDate){
      setSimpleProperty("creationDate", pCreationDate);
   }


   public Boolean getFilterForQualifierNegativePrices(){
      return getSimpleProperty("filterForQualifierNegativePrices",Boolean.class);
   }

   public void setFilterForQualifierNegativePrices(Boolean pFilterForQualifierNegativePrices){
      setSimpleProperty("filterForQualifierNegativePrices", pFilterForQualifierNegativePrices);
   }


   public Promotion getStackingRule(){
      return getSingleRepositoryProperty("stackingRule",Promotion.class);
   }

   public void setStackingRule(Promotion pStackingRule){
      setSingleRepositoryProperty("stackingRule", pStackingRule);
   }


   public Integer getEvaluationLimit(){
      return getSimpleProperty("evaluationLimit",Integer.class);
   }

   public void setEvaluationLimit(Integer pEvaluationLimit){
      setSimpleProperty("evaluationLimit", pEvaluationLimit);
   }


   public Integer getTimeUntilExpire(){
      return getSimpleProperty("timeUntilExpire",Integer.class);
   }

   public void setTimeUntilExpire(Integer pTimeUntilExpire){
      setSimpleProperty("timeUntilExpire", pTimeUntilExpire);
   }


   public Boolean getRelativeExpiration(){
      return getSimpleProperty("relativeExpiration",Boolean.class);
   }

   public void setRelativeExpiration(Boolean pRelativeExpiration){
      setSimpleProperty("relativeExpiration", pRelativeExpiration);
   }


   public String getDescriptionDefault(){
      return getSimpleProperty("descriptionDefault",String.class);
   }

   public void setDescriptionDefault(String pDescriptionDefault){
      setSimpleProperty("descriptionDefault", pDescriptionDefault);
   }


   public Integer getUses(){
      return getSimpleProperty("uses",Integer.class);
   }

   public void setUses(Integer pUses){
      setSimpleProperty("uses", pUses);
   }


   public String getDisplayName(){
      return getSimpleProperty("displayName",String.class);
   }

   public void setDisplayName(String pDisplayName){
      setSimpleProperty("displayName", pDisplayName);
   }


   public Boolean getFilterForQualifierZeroPrices(){
      return getSimpleProperty("filterForQualifierZeroPrices",Boolean.class);
   }

   public void setFilterForQualifierZeroPrices(Boolean pFilterForQualifierZeroPrices){
      setSimpleProperty("filterForQualifierZeroPrices", pFilterForQualifierZeroPrices);
   }


                                                                                                                        
}                                                                                                                                         
