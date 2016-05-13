package atg.repository.beans.productcatalog;                                                                                                     
import java.util.*;                                                                                                                       
import java.util.Comparator;                                                                                                              
import atg.repository.*;                                                                                                                  
import java.sql.Timestamp;                                                                                                                
import atg.adapter.gsa.MutableRepositoryItemExt;                                                                                          

                                                                                                                       
                                                                                                                                          
@SuppressWarnings({ "serial", "unused" })                                                                                             
public class Product extends MutableRepositoryItemExt implements java.io.Serializable {                                            
   static transient MutableRepository REPOSITORY;                                                                                         
   static transient String DESCRIPTOR = "product";                                                                          
   static transient String REPOSITORY_COMPONENT = "/atg/commerce/catalog/ProductCatalog";                                                                
   static final transient Set<String> COMPLEX_PROPERTIES;                                                                                 
                                                                                                                                          
   static {                                                                                                                               
     Set<String> s  = new HashSet<String>();                                                                                              
          s.add("ancestorCategories");
          s.add("thumbnailImage");
          s.add("fullImage");
          s.add("nonShippableCountries");
          s.add("mediumImage");
          s.add("features");
          s.add("upsellProducts");
          s.add("template");
          s.add("displayableSkuAttributes");
          s.add("catalogsRelatedProducts");
          s.add("keywords");
          s.add("productTipsDefault");
          s.add("relatedMediaContent");
          s.add("manufacturer");
          s.add("shippableCountries");
          s.add("relatedProducts");
          s.add("parentCategory");
          s.add("dynamicRelatedProducts");
          s.add("productTips");
          s.add("derivedCatalogs");
          s.add("ancestorCategoryIds");
          s.add("relatedArticles");
          s.add("smallImage");
          s.add("asSeenIn");
          s.add("fixedRelatedProducts");
          s.add("largeImage");
          s.add("computedCatalogs");
          s.add("parentCategories");
          s.add("childSKUs");
          s.add("siteIds");
          s.add("catalogs");
          s.add("keywordsDefault");
          s.add("fixedUpsellProducts");
          s.add("dynamicUpsellProducts");
                                                                                                                  
     COMPLEX_PROPERTIES = s;                                                                                                              
   }                                                                                                                                      
                                                                                                                                          
                                                                                                                                          
   public Product()  {                                                                                                           
   }                                                                                                                                      
                                                                                                                                          
   public Product(MutableRepositoryItem delegate) {                                                                              
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
                                                                                                                                          
   public String getRelatedProductGroup(){
      return getSimpleProperty("relatedProductGroup",String.class);
   }

   public void setRelatedProductGroup(String pRelatedProductGroup){
      setSimpleProperty("relatedProductGroup", pRelatedProductGroup);
   }


   public Timestamp getEndDate(){
      return getSimpleProperty("endDate",Timestamp.class);
   }

   public void setEndDate(Timestamp pEndDate){
      setSimpleProperty("endDate", pEndDate);
   }


   public List<Category> getAncestorCategories(){
      return getListProperty("ancestorCategories", Category.class);
   }

   public void setAncestorCategories(List<Category> pAncestorCategories){
       setListProperty("ancestorCategories", pAncestorCategories);
   } 


   public Integer getType(){
      return getSimpleProperty("type",Integer.class);
   }

   public void setType(Integer pType){
      setSimpleProperty("type", pType);
   }


   public Product getThumbnailImage(){
      return getSingleRepositoryProperty("thumbnailImage",Product.class);
   }

   public void setThumbnailImage(Product pThumbnailImage){
      setSingleRepositoryProperty("thumbnailImage", pThumbnailImage);
   }


   public Product getFullImage(){
      return getSingleRepositoryProperty("fullImage",Product.class);
   }

   public void setFullImage(Product pFullImage){
      setSingleRepositoryProperty("fullImage", pFullImage);
   }


   public Set<java.lang.String> getNonShippableCountries(){
      return getSimpleProperty("nonShippableCountries",String.class);
   }

   public void setNonShippableCountries(Set<java.lang.String> pNonShippableCountries){
      setSimpleProperty("nonShippableCountries", pNonShippableCountries);
   }


   public String getDescription(){
      return getSimpleProperty("description",String.class);
   }

   public void setDescription(String pDescription){
      setSimpleProperty("description", pDescription);
   }


   public Product getMediumImage(){
      return getSingleRepositoryProperty("mediumImage",Product.class);
   }

   public void setMediumImage(Product pMediumImage){
      setSingleRepositoryProperty("mediumImage", pMediumImage);
   }


   public List<Feature> getFeatures(){
      return getListProperty("features", Feature.class);
   }

   public void setFeatures(List<Feature> pFeatures){
       setListProperty("features", pFeatures);
   } 


   public String getLongDescription(){
      return getSimpleProperty("longDescription",String.class);
   }

   public void setLongDescription(String pLongDescription){
      setSimpleProperty("longDescription", pLongDescription);
   }


   public List<Product> getUpsellProducts(){
      return getListProperty("upsellProducts", Product.class);
   }

   public void setUpsellProducts(List<Product> pUpsellProducts){
       setListProperty("upsellProducts", pUpsellProducts);
   } 


   public Product getTemplate(){
      return getSingleRepositoryProperty("template",Product.class);
   }

   public void setTemplate(Product pTemplate){
      setSingleRepositoryProperty("template", pTemplate);
   }


   public String getLongDescriptionDefault(){
      return getSimpleProperty("longDescriptionDefault",String.class);
   }

   public void setLongDescriptionDefault(String pLongDescriptionDefault){
      setSimpleProperty("longDescriptionDefault", pLongDescriptionDefault);
   }


   public List<java.lang.String> getDisplayableSkuAttributes(){
      return getSimpleProperty("displayableSkuAttributes",String.class);
   }

   public void setDisplayableSkuAttributes(List<java.lang.String> pDisplayableSkuAttributes){
      setSimpleProperty("displayableSkuAttributes", pDisplayableSkuAttributes);
   }


   public List<Category> getCatalogsRelatedProducts(){
      return getListProperty("catalogsRelatedProducts", Category.class);
   }

   public void setCatalogsRelatedProducts(List<Category> pCatalogsRelatedProducts){
       setListProperty("catalogsRelatedProducts", pCatalogsRelatedProducts);
   } 


   public List<java.lang.String> getKeywords(){
      return getSimpleProperty("keywords",String.class);
   }

   public void setKeywords(List<java.lang.String> pKeywords){
      setSimpleProperty("keywords", pKeywords);
   }


   public Timestamp getPreorderEndDate(){
      return getSimpleProperty("preorderEndDate",Timestamp.class);
   }

   public void setPreorderEndDate(Timestamp pPreorderEndDate){
      setSimpleProperty("preorderEndDate", pPreorderEndDate);
   }


   public List<java.lang.String> getProductTipsDefault(){
      return getSimpleProperty("productTipsDefault",String.class);
   }

   public void setProductTipsDefault(List<java.lang.String> pProductTipsDefault){
      setSimpleProperty("productTipsDefault", pProductTipsDefault);
   }


   public String getItemAcl(){
      return getSimpleProperty("itemAcl",String.class);
   }

   public void setItemAcl(String pItemAcl){
      setSimpleProperty("itemAcl", pItemAcl);
   }


   public Boolean getDiscountable(){
      return getSimpleProperty("discountable",Boolean.class);
   }

   public void setDiscountable(Boolean pDiscountable){
      setSimpleProperty("discountable", pDiscountable);
   }


   public List<Object> getRelatedMediaContent(){
      return getListProperty("relatedMediaContent", Object.class);
   }

   public void setRelatedMediaContent(List<Object> pRelatedMediaContent){
       setListProperty("relatedMediaContent", pRelatedMediaContent);
   } 


   public Boolean getDisallowAsRecommendation(){
      return getSimpleProperty("disallowAsRecommendation",Boolean.class);
   }

   public void setDisallowAsRecommendation(Boolean pDisallowAsRecommendation){
      setSimpleProperty("disallowAsRecommendation", pDisallowAsRecommendation);
   }


   public Product getManufacturer(){
      return getSingleRepositoryProperty("manufacturer",Product.class);
   }

   public void setManufacturer(Product pManufacturer){
      setSingleRepositoryProperty("manufacturer", pManufacturer);
   }


   public Boolean getNonreturnable(){
      return getSimpleProperty("nonreturnable",Boolean.class);
   }

   public void setNonreturnable(Boolean pNonreturnable){
      setSimpleProperty("nonreturnable", pNonreturnable);
   }


   public Boolean getNavigableProducts(){
      return getSimpleProperty("NavigableProducts",Boolean.class);
   }

   public void setNavigableProducts(Boolean pNavigableProducts){
      setSimpleProperty("NavigableProducts", pNavigableProducts);
   }


   public Set<java.lang.String> getShippableCountries(){
      return getSimpleProperty("shippableCountries",String.class);
   }

   public void setShippableCountries(Set<java.lang.String> pShippableCountries){
      setSimpleProperty("shippableCountries", pShippableCountries);
   }


   public Timestamp getDateAvailable(){
      return getSimpleProperty("dateAvailable",Timestamp.class);
   }

   public void setDateAvailable(Timestamp pDateAvailable){
      setSimpleProperty("dateAvailable", pDateAvailable);
   }


   public String getUsageInstructionsDefault(){
      return getSimpleProperty("usageInstructionsDefault",String.class);
   }

   public void setUsageInstructionsDefault(String pUsageInstructionsDefault){
      setSimpleProperty("usageInstructionsDefault", pUsageInstructionsDefault);
   }


   public Integer getDaysAvailable(){
      return getSimpleProperty("daysAvailable",Integer.class);
   }

   public void setDaysAvailable(Integer pDaysAvailable){
      setSimpleProperty("daysAvailable", pDaysAvailable);
   }


   public Timestamp getStartDate(){
      return getSimpleProperty("startDate",Timestamp.class);
   }

   public void setStartDate(Timestamp pStartDate){
      setSimpleProperty("startDate", pStartDate);
   }


   public List<Product> getRelatedProducts(){
      return getListProperty("relatedProducts", Product.class);
   }

   public void setRelatedProducts(List<Product> pRelatedProducts){
       setListProperty("relatedProducts", pRelatedProducts);
   } 


   public Boolean getEmailAFriendEnabled(){
      return getSimpleProperty("emailAFriendEnabled",Boolean.class);
   }

   public void setEmailAFriendEnabled(Boolean pEmailAFriendEnabled){
      setSimpleProperty("emailAFriendEnabled", pEmailAFriendEnabled);
   }


   public Product getParentCategory(){
      return getSingleRepositoryProperty("parentCategory",Product.class);
   }

   public void setParentCategory(Product pParentCategory){
      setSingleRepositoryProperty("parentCategory", pParentCategory);
   }


   public Boolean getOnlineOnly(){
      return getSimpleProperty("onlineOnly",Boolean.class);
   }

   public void setOnlineOnly(Boolean pOnlineOnly){
      setSimpleProperty("onlineOnly", pOnlineOnly);
   }


   public List<Product> getDynamicRelatedProducts(){
      return getListProperty("dynamicRelatedProducts", Product.class);
   }

   public void setDynamicRelatedProducts(List<Product> pDynamicRelatedProducts){
       setListProperty("dynamicRelatedProducts", pDynamicRelatedProducts);
   } 


   public List<java.lang.String> getProductTips(){
      return getSimpleProperty("productTips",String.class);
   }

   public void setProductTips(List<java.lang.String> pProductTips){
      setSimpleProperty("productTips", pProductTips);
   }


   public String getBriefDescriptionDefault(){
      return getSimpleProperty("briefDescriptionDefault",String.class);
   }

   public void setBriefDescriptionDefault(String pBriefDescriptionDefault){
      setSimpleProperty("briefDescriptionDefault", pBriefDescriptionDefault);
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


   public Set<Catalog> getDerivedCatalogs(){
      return getSetProperty("derivedCatalogs", Catalog.class);
   }

   public void setDerivedCatalogs(Set<Catalog> pDerivedCatalogs){
       setSetProperty("derivedCatalogs", pDerivedCatalogs);
   } 


   public Set<java.lang.String> getAncestorCategoryIds(){
      return getSimpleProperty("ancestorCategoryIds",String.class);
   }

   public void setAncestorCategoryIds(Set<java.lang.String> pAncestorCategoryIds){
      setSimpleProperty("ancestorCategoryIds", pAncestorCategoryIds);
   }


   public String getBriefDescription(){
      return getSimpleProperty("briefDescription",String.class);
   }

   public void setBriefDescription(String pBriefDescription){
      setSimpleProperty("briefDescription", pBriefDescription);
   }


   public Boolean getPreorderable(){
      return getSimpleProperty("preorderable",Boolean.class);
   }

   public void setPreorderable(Boolean pPreorderable){
      setSimpleProperty("preorderable", pPreorderable);
   }


   public List<Object> getRelatedArticles(){
      return getListProperty("relatedArticles", Object.class);
   }

   public void setRelatedArticles(List<Object> pRelatedArticles){
       setListProperty("relatedArticles", pRelatedArticles);
   } 


   public Product getSmallImage(){
      return getSingleRepositoryProperty("smallImage",Product.class);
   }

   public void setSmallImage(Product pSmallImage){
      setSingleRepositoryProperty("smallImage", pSmallImage);
   }


   public String getUsageInstructions(){
      return getSimpleProperty("usageInstructions",String.class);
   }

   public void setUsageInstructions(String pUsageInstructions){
      setSimpleProperty("usageInstructions", pUsageInstructions);
   }


   public Product getAsSeenIn(){
      return getSingleRepositoryProperty("asSeenIn",Product.class);
   }

   public void setAsSeenIn(Product pAsSeenIn){
      setSingleRepositoryProperty("asSeenIn", pAsSeenIn);
   }


   public String getDisplayNameDefault(){
      return getSimpleProperty("displayNameDefault",String.class);
   }

   public void setDisplayNameDefault(String pDisplayNameDefault){
      setSimpleProperty("displayNameDefault", pDisplayNameDefault);
   }


   public String getAdminDisplayName(){
      return getSimpleProperty("adminDisplayName",String.class);
   }

   public void setAdminDisplayName(String pAdminDisplayName){
      setSimpleProperty("adminDisplayName", pAdminDisplayName);
   }


   public Double getAverageCustomerRating(){
      return getSimpleProperty("averageCustomerRating",Double.class);
   }

   public void setAverageCustomerRating(Double pAverageCustomerRating){
      setSimpleProperty("averageCustomerRating", pAverageCustomerRating);
   }


   public List<Product> getFixedRelatedProducts(){
      return getListProperty("fixedRelatedProducts", Product.class);
   }

   public void setFixedRelatedProducts(List<Product> pFixedRelatedProducts){
       setListProperty("fixedRelatedProducts", pFixedRelatedProducts);
   } 


   public Product getLargeImage(){
      return getSingleRepositoryProperty("largeImage",Product.class);
   }

   public void setLargeImage(Product pLargeImage){
      setSingleRepositoryProperty("largeImage", pLargeImage);
   }


   public Set<Catalog> getComputedCatalogs(){
      return getSetProperty("computedCatalogs", Catalog.class);
   }

   public void setComputedCatalogs(Set<Catalog> pComputedCatalogs){
       setSetProperty("computedCatalogs", pComputedCatalogs);
   } 


   public Set<Category> getParentCategories(){
      return getSetProperty("parentCategories", Category.class);
   }

   public void setParentCategories(Set<Category> pParentCategories){
       setSetProperty("parentCategories", pParentCategories);
   } 


   public List<Sku> getChildSKUs(){
      return getListProperty("childSKUs", Sku.class);
   }

   public void setChildSKUs(List<Sku> pChildSKUs){
       setListProperty("childSKUs", pChildSKUs);
   } 


   public String getUpsellProductGroup(){
      return getSimpleProperty("upsellProductGroup",String.class);
   }

   public void setUpsellProductGroup(String pUpsellProductGroup){
      setSimpleProperty("upsellProductGroup", pUpsellProductGroup);
   }


   public Timestamp getCreationDate(){
      return getSimpleProperty("creationDate",Timestamp.class);
   }

   public void setCreationDate(Timestamp pCreationDate){
      setSimpleProperty("creationDate", pCreationDate);
   }


   public Boolean getNew(){
      return getSimpleProperty("new",Boolean.class);
   }

   public void setNew(Boolean pNew){
      setSimpleProperty("new", pNew);
   }


   public String getBrand(){
      return getSimpleProperty("brand",String.class);
   }

   public void setBrand(String pBrand){
      setSimpleProperty("brand", pBrand);
   }


   public Boolean getUseInventoryForPreorder(){
      return getSimpleProperty("useInventoryForPreorder",Boolean.class);
   }

   public void setUseInventoryForPreorder(Boolean pUseInventoryForPreorder){
      setSimpleProperty("useInventoryForPreorder", pUseInventoryForPreorder);
   }


   public Set<java.lang.String> getSiteIds(){
      return getSimpleProperty("siteIds",String.class);
   }

   public void setSiteIds(Set<java.lang.String> pSiteIds){
      setSimpleProperty("siteIds", pSiteIds);
   }


   public Set<Catalog> getCatalogs(){
      return getSetProperty("catalogs", Catalog.class);
   }

   public void setCatalogs(Set<Catalog> pCatalogs){
       setSetProperty("catalogs", pCatalogs);
   } 


   public String getDescriptionDefault(){
      return getSimpleProperty("descriptionDefault",String.class);
   }

   public void setDescriptionDefault(String pDescriptionDefault){
      setSimpleProperty("descriptionDefault", pDescriptionDefault);
   }


   public List<java.lang.String> getKeywordsDefault(){
      return getSimpleProperty("keywordsDefault",String.class);
   }

   public void setKeywordsDefault(List<java.lang.String> pKeywordsDefault){
      setSimpleProperty("keywordsDefault", pKeywordsDefault);
   }


   public List<Product> getFixedUpsellProducts(){
      return getListProperty("fixedUpsellProducts", Product.class);
   }

   public void setFixedUpsellProducts(List<Product> pFixedUpsellProducts){
       setListProperty("fixedUpsellProducts", pFixedUpsellProducts);
   } 


   public String getDisplayName(){
      return getSimpleProperty("displayName",String.class);
   }

   public void setDisplayName(String pDisplayName){
      setSimpleProperty("displayName", pDisplayName);
   }


   public List<Product> getDynamicUpsellProducts(){
      return getListProperty("dynamicUpsellProducts", Product.class);
   }

   public void setDynamicUpsellProducts(List<Product> pDynamicUpsellProducts){
       setListProperty("dynamicUpsellProducts", pDynamicUpsellProducts);
   } 


                                                                                                                        
}                                                                                                                                         
