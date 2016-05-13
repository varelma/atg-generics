package atg.repository.beans.productcatalog;                                                                                                     
import java.util.*;                                                                                                                       
import java.util.Comparator;                                                                                                              
import atg.repository.*;                                                                                                                  
import java.sql.Timestamp;                                                                                                                
import atg.adapter.gsa.MutableRepositoryItemExt;                                                                                          

                                                                                                                       
                                                                                                                                          
@SuppressWarnings({ "serial", "unused" })                                                                                             
public class OrderDiscountFixedPrice extends OrderDiscount implements java.io.Serializable {                                            
   static transient MutableRepository REPOSITORY;                                                                                         
   static transient String DESCRIPTOR = "Order Discount - Fixed Price";                                                                          
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
                                                                                                                                          
                                                                                                                                          
   public OrderDiscountFixedPrice()  {                                                                                                           
   }                                                                                                                                      
                                                                                                                                          
   public OrderDiscountFixedPrice(MutableRepositoryItem delegate) {                                                                              
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
                                                                                                                                          
   public Timestamp getStartDateThis(){
      return getSimpleProperty("startDate",Timestamp.class);
   }

   public void setStartDateThis(Timestamp pStartDate){
      setSimpleProperty("startDate", pStartDate);
   }


   public Boolean getGiveToAnonymousProfilesThis(){
      return getSimpleProperty("giveToAnonymousProfiles",Boolean.class);
   }

   public void setGiveToAnonymousProfilesThis(Boolean pGiveToAnonymousProfiles){
      setSimpleProperty("giveToAnonymousProfiles", pGiveToAnonymousProfiles);
   }


   public OrderDiscountFixedPrice getParentFolderThis(){
      return getSingleRepositoryProperty("parentFolder",OrderDiscountFixedPrice.class);
   }

   public void setParentFolderThis(OrderDiscountFixedPrice pParentFolder){
      setSingleRepositoryProperty("parentFolder", pParentFolder);
   }


   public Boolean getFilterForQualifierOnSaleThis(){
      return getSimpleProperty("filterForQualifierOnSale",Boolean.class);
   }

   public void setFilterForQualifierOnSaleThis(Boolean pFilterForQualifierOnSale){
      setSimpleProperty("filterForQualifierOnSale", pFilterForQualifierOnSale);
   }


   public Set<ClosenessQualifier> getClosenessQualifiersThis(){
      return getSetProperty("closenessQualifiers", ClosenessQualifier.class);
   }

   public void setClosenessQualifiersThis(Set<ClosenessQualifier> pClosenessQualifiers){
       setSetProperty("closenessQualifiers", pClosenessQualifiers);
   } 


   public String getQualifierServiceThis(){
      return getSimpleProperty("qualifierService",String.class);
   }

   public void setQualifierServiceThis(String pQualifierService){
      setSimpleProperty("qualifierService", pQualifierService);
   }


   public Timestamp getBeginUsableThis(){
      return getSimpleProperty("beginUsable",Timestamp.class);
   }

   public void setBeginUsableThis(Timestamp pBeginUsable){
      setSimpleProperty("beginUsable", pBeginUsable);
   }


   public Set<Promotion> getExcludedPromotionsThis(){
      return getSetProperty("excludedPromotions", Promotion.class);
   }

   public void setExcludedPromotionsThis(Set<Promotion> pExcludedPromotions){
       setSetProperty("excludedPromotions", pExcludedPromotions);
   } 


   public String getDiscountDescriptionThis(){
      return getSimpleProperty("discountDescription",String.class);
   }

   public void setDiscountDescriptionThis(String pDiscountDescription){
      setSimpleProperty("discountDescription", pDiscountDescription);
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


   public Boolean getEvaluateTargetItemsFirstThis(){
      return getSimpleProperty("evaluateTargetItemsFirst",Boolean.class);
   }

   public void setEvaluateTargetItemsFirstThis(Boolean pEvaluateTargetItemsFirst){
      setSimpleProperty("evaluateTargetItemsFirst", pEvaluateTargetItemsFirst);
   }


   public Boolean getIsSiteRestrictedThis(){
      return getSimpleProperty("isSiteRestricted",Boolean.class);
   }

   public void setIsSiteRestrictedThis(Boolean pIsSiteRestricted){
      setSimpleProperty("isSiteRestricted", pIsSiteRestricted);
   }


   public String getPmdlRuleThis(){
      return getSimpleProperty("pmdlRule",String.class);
   }

   public void setPmdlRuleThis(String pPmdlRule){
      setSimpleProperty("pmdlRule", pPmdlRule);
   }


   public Integer getVersionThis(){
      return getSimpleProperty("version",Integer.class);
   }

   public void setVersionThis(Integer pVersion){
      setSimpleProperty("version", pVersion);
   }


   public String getIdThis(){
      return getSimpleProperty("id",String.class);
   }

   public void setIdThis(String pId){
      setSimpleProperty("id", pId);
   }


   public String getDiscountType(){
      return getSimpleProperty("discountType",String.class);
   }

   public void setDiscountType(String pDiscountType){
      setSimpleProperty("discountType", pDiscountType);
   }


   public String getDescriptionThis(){
      return getSimpleProperty("description",String.class);
   }

   public void setDescriptionThis(String pDescription){
      setSimpleProperty("description", pDescription);
   }


   public String getPricingCalculatorService(){
      return getSimpleProperty("pricingCalculatorService",String.class);
   }

   public void setPricingCalculatorService(String pPricingCalculatorService){
      setSimpleProperty("pricingCalculatorService", pPricingCalculatorService);
   }


   public Integer getPriorityThis(){
      return getSimpleProperty("priority",Integer.class);
   }

   public void setPriorityThis(Integer pPriority){
      setSimpleProperty("priority", pPriority);
   }


   public Boolean getAllowMultipleThis(){
      return getSimpleProperty("allowMultiple",Boolean.class);
   }

   public void setAllowMultipleThis(Boolean pAllowMultiple){
      setSimpleProperty("allowMultiple", pAllowMultiple);
   }


   public Integer getPmdlVersionThis(){
      return getSimpleProperty("pmdlVersion",Integer.class);
   }

   public void setPmdlVersionThis(Integer pPmdlVersion){
      setSimpleProperty("pmdlVersion", pPmdlVersion);
   }


   public Set<Promotion> getIncludedPromotionsThis(){
      return getSetProperty("includedPromotions", Promotion.class);
   }

   public void setIncludedPromotionsThis(Set<Promotion> pIncludedPromotions){
       setSetProperty("includedPromotions", pIncludedPromotions);
   } 


   public Timestamp getEndUsableThis(){
      return getSimpleProperty("endUsable",Timestamp.class);
   }

   public void setEndUsableThis(Timestamp pEndUsable){
      setSimpleProperty("endUsable", pEndUsable);
   }


   public Set<Object> getSiteGroupsThis(){
      return getSetProperty("siteGroups", Object.class);
   }

   public void setSiteGroupsThis(Set<Object> pSiteGroups){
       setSetProperty("siteGroups", pSiteGroups);
   } 


   public Boolean getUpsellThis(){
      return getSimpleProperty("upsell",Boolean.class);
   }

   public void setUpsellThis(Boolean pUpsell){
      setSimpleProperty("upsell", pUpsell);
   }


   public Boolean getFilterForQualifierDiscountedByAnyThis(){
      return getSimpleProperty("filterForQualifierDiscountedByAny",Boolean.class);
   }

   public void setFilterForQualifierDiscountedByAnyThis(Boolean pFilterForQualifierDiscountedByAny){
      setSimpleProperty("filterForQualifierDiscountedByAny", pFilterForQualifierDiscountedByAny);
   }


   public String getTemplateThis(){
      return getSimpleProperty("template",String.class);
   }

   public void setTemplateThis(String pTemplate){
      setSimpleProperty("template", pTemplate);
   }


   public Set<Object> getSitesThis(){
      return getSetProperty("sites", Object.class);
   }

   public void setSitesThis(Set<Object> pSites){
       setSetProperty("sites", pSites);
   } 


   public Boolean getEnabledThis(){
      return getSimpleProperty("enabled",Boolean.class);
   }

   public void setEnabledThis(Boolean pEnabled){
      setSimpleProperty("enabled", pEnabled);
   }


   public String getDisplayNameDefaultThis(){
      return getSimpleProperty("displayNameDefault",String.class);
   }

   public void setDisplayNameDefaultThis(String pDisplayNameDefault){
      setSimpleProperty("displayNameDefault", pDisplayNameDefault);
   }


   public Timestamp getLastModifiedThis(){
      return getSimpleProperty("lastModified",Timestamp.class);
   }

   public void setLastModifiedThis(Timestamp pLastModified){
      setSimpleProperty("lastModified", pLastModified);
   }


   public Boolean getGlobalThis(){
      return getSimpleProperty("global",Boolean.class);
   }

   public void setGlobalThis(Boolean pGlobal){
      setSimpleProperty("global", pGlobal);
   }


   public String getUiAccessLevelThis(){
      return getSimpleProperty("uiAccessLevel",String.class);
   }

   public void setUiAccessLevelThis(String pUiAccessLevel){
      setSimpleProperty("uiAccessLevel", pUiAccessLevel);
   }


   public Double getAdjuster(){
      return getSimpleProperty("adjuster",Double.class);
   }

   public void setAdjuster(Double pAdjuster){
      setSimpleProperty("adjuster", pAdjuster);
   }


   public Timestamp getCreationDateThis(){
      return getSimpleProperty("creationDate",Timestamp.class);
   }

   public void setCreationDateThis(Timestamp pCreationDate){
      setSimpleProperty("creationDate", pCreationDate);
   }


   public Boolean getFilterForQualifierNegativePricesThis(){
      return getSimpleProperty("filterForQualifierNegativePrices",Boolean.class);
   }

   public void setFilterForQualifierNegativePricesThis(Boolean pFilterForQualifierNegativePrices){
      setSimpleProperty("filterForQualifierNegativePrices", pFilterForQualifierNegativePrices);
   }


   public OrderDiscountFixedPrice getStackingRuleThis(){
      return getSingleRepositoryProperty("stackingRule",OrderDiscountFixedPrice.class);
   }

   public void setStackingRuleThis(OrderDiscountFixedPrice pStackingRule){
      setSingleRepositoryProperty("stackingRule", pStackingRule);
   }


   public Integer getEvaluationLimitThis(){
      return getSimpleProperty("evaluationLimit",Integer.class);
   }

   public void setEvaluationLimitThis(Integer pEvaluationLimit){
      setSimpleProperty("evaluationLimit", pEvaluationLimit);
   }


   public Boolean getRelativeExpirationThis(){
      return getSimpleProperty("relativeExpiration",Boolean.class);
   }

   public void setRelativeExpirationThis(Boolean pRelativeExpiration){
      setSimpleProperty("relativeExpiration", pRelativeExpiration);
   }


   public Integer getTimeUntilExpireThis(){
      return getSimpleProperty("timeUntilExpire",Integer.class);
   }

   public void setTimeUntilExpireThis(Integer pTimeUntilExpire){
      setSimpleProperty("timeUntilExpire", pTimeUntilExpire);
   }


   public String getDescriptionDefaultThis(){
      return getSimpleProperty("descriptionDefault",String.class);
   }

   public void setDescriptionDefaultThis(String pDescriptionDefault){
      setSimpleProperty("descriptionDefault", pDescriptionDefault);
   }


   public Integer getUsesThis(){
      return getSimpleProperty("uses",Integer.class);
   }

   public void setUsesThis(Integer pUses){
      setSimpleProperty("uses", pUses);
   }


   public String getDisplayNameThis(){
      return getSimpleProperty("displayName",String.class);
   }

   public void setDisplayNameThis(String pDisplayName){
      setSimpleProperty("displayName", pDisplayName);
   }


   public Boolean getFilterForQualifierZeroPricesThis(){
      return getSimpleProperty("filterForQualifierZeroPrices",Boolean.class);
   }

   public void setFilterForQualifierZeroPricesThis(Boolean pFilterForQualifierZeroPrices){
      setSimpleProperty("filterForQualifierZeroPrices", pFilterForQualifierZeroPrices);
   }


                                                                                                                        
}                                                                                                                                         
