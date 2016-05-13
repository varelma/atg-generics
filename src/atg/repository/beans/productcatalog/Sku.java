package atg.repository.beans.productcatalog;                                                                                                     
import java.util.*;                                                                                                                       
import java.util.Comparator;                                                                                                              
import atg.repository.*;                                                                                                                  
import java.sql.Timestamp;                                                                                                                
import atg.adapter.gsa.MutableRepositoryItemExt;                                                                                          

                                                                                                                       
                                                                                                                                          
@SuppressWarnings({ "serial", "unused" })                                                                                             
public class Sku extends MutableRepositoryItemExt implements java.io.Serializable {                                            
   static transient MutableRepository REPOSITORY;                                                                                         
   static transient String DESCRIPTOR = "sku";                                                                          
   static transient String REPOSITORY_COMPONENT = "/atg/commerce/catalog/ProductCatalog";                                                                
   static final transient Set<String> COMPLEX_PROPERTIES;                                                                                 
                                                                                                                                          
   static {                                                                                                                               
     Set<String> s  = new HashSet<String>();                                                                                              
          s.add("parentProducts");
          s.add("thumbnailImage");
          s.add("derivedCatalogs");
          s.add("bundleLinks");
          s.add("smallImage");
          s.add("template");
          s.add("largeImage");
          s.add("computedCatalogs");
          s.add("fixedReplacementProducts");
          s.add("catalogsReplacementProducts");
          s.add("replacementProducts");
          s.add("siteIds");
          s.add("catalogs");
                                                                                                                  
     COMPLEX_PROPERTIES = s;                                                                                                              
   }                                                                                                                                      
                                                                                                                                          
                                                                                                                                          
   public Sku()  {                                                                                                           
   }                                                                                                                                      
                                                                                                                                          
   public Sku(MutableRepositoryItem delegate) {                                                                              
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


   public Set<Product> getParentProducts(){
      return getSetProperty("parentProducts", Product.class);
   }

   public void setParentProducts(Set<Product> pParentProducts){
       setSetProperty("parentProducts", pParentProducts);
   } 


   public Boolean getOnlineOnly(){
      return getSimpleProperty("onlineOnly",Boolean.class);
   }

   public void setOnlineOnly(Boolean pOnlineOnly){
      setSimpleProperty("onlineOnly", pOnlineOnly);
   }


   public Timestamp getEndDate(){
      return getSimpleProperty("endDate",Timestamp.class);
   }

   public void setEndDate(Timestamp pEndDate){
      setSimpleProperty("endDate", pEndDate);
   }


   public String getType(){
      return getSimpleProperty("type",String.class);
   }

   public void setType(String pType){
      setSimpleProperty("type", pType);
   }


   public String getManufacturerPartNumber(){
      return getSimpleProperty("manufacturer_part_number",String.class);
   }

   public void setManufacturerPartNumber(String pManufacturerPartNumber){
      setSimpleProperty("manufacturerPartNumber", pManufacturerPartNumber);
   }


   public Sku getThumbnailImage(){
      return getSingleRepositoryProperty("thumbnailImage",Sku.class);
   }

   public void setThumbnailImage(Sku pThumbnailImage){
      setSingleRepositoryProperty("thumbnailImage", pThumbnailImage);
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


   public String getUnitOfMeasure(){
      return getSimpleProperty("unit_of_measure",String.class);
   }

   public void setUnitOfMeasure(String pUnitOfMeasure){
      setSimpleProperty("unitOfMeasure", pUnitOfMeasure);
   }


   public List<SkuLink> getBundleLinks(){
      return getListProperty("bundleLinks", SkuLink.class);
   }

   public void setBundleLinks(List<SkuLink> pBundleLinks){
       setListProperty("bundleLinks", pBundleLinks);
   } 


   public Double getListPrice(){
      return getSimpleProperty("listPrice",Double.class);
   }

   public void setListPrice(Double pListPrice){
      setSimpleProperty("listPrice", pListPrice);
   }


   public String getDescription(){
      return getSimpleProperty("description",String.class);
   }

   public void setDescription(String pDescription){
      setSimpleProperty("description", pDescription);
   }


   public Double getMargin(){
      return getSimpleProperty("margin",Double.class);
   }

   public void setMargin(Double pMargin){
      setSimpleProperty("margin", pMargin);
   }


   public Double getQuantity(){
      return getSimpleProperty("quantity",Double.class);
   }

   public void setQuantity(Double pQuantity){
      setSimpleProperty("quantity", pQuantity);
   }


   public Sku getSmallImage(){
      return getSingleRepositoryProperty("smallImage",Sku.class);
   }

   public void setSmallImage(Sku pSmallImage){
      setSingleRepositoryProperty("smallImage", pSmallImage);
   }


   public Sku getTemplate(){
      return getSingleRepositoryProperty("template",Sku.class);
   }

   public void setTemplate(Sku pTemplate){
      setSingleRepositoryProperty("template", pTemplate);
   }


   public Boolean getOnSale(){
      return getSimpleProperty("onSale",Boolean.class);
   }

   public void setOnSale(Boolean pOnSale){
      setSimpleProperty("onSale", pOnSale);
   }


   public String getDisplayNameDefault(){
      return getSimpleProperty("displayNameDefault",String.class);
   }

   public void setDisplayNameDefault(String pDisplayNameDefault){
      setSimpleProperty("displayNameDefault", pDisplayNameDefault);
   }


   public String getFulfiller(){
      return getSimpleProperty("fulfiller",String.class);
   }

   public void setFulfiller(String pFulfiller){
      setSimpleProperty("fulfiller", pFulfiller);
   }


   public Double getWholesalePrice(){
      return getSimpleProperty("wholesalePrice",Double.class);
   }

   public void setWholesalePrice(Double pWholesalePrice){
      setSimpleProperty("wholesalePrice", pWholesalePrice);
   }


   public String getTaxStatus(){
      return getSimpleProperty("taxStatus",String.class);
   }

   public void setTaxStatus(String pTaxStatus){
      setSimpleProperty("taxStatus", pTaxStatus);
   }


   public Sku getLargeImage(){
      return getSingleRepositoryProperty("largeImage",Sku.class);
   }

   public void setLargeImage(Sku pLargeImage){
      setSingleRepositoryProperty("largeImage", pLargeImage);
   }


   public Set<Catalog> getComputedCatalogs(){
      return getSetProperty("computedCatalogs", Catalog.class);
   }

   public void setComputedCatalogs(Set<Catalog> pComputedCatalogs){
       setSetProperty("computedCatalogs", pComputedCatalogs);
   } 


   public List<Product> getFixedReplacementProducts(){
      return getListProperty("fixedReplacementProducts", Product.class);
   }

   public void setFixedReplacementProducts(List<Product> pFixedReplacementProducts){
       setListProperty("fixedReplacementProducts", pFixedReplacementProducts);
   } 


   public List<Product> getCatalogsReplacementProducts(){
      return getListProperty("catalogsReplacementProducts", Product.class);
   }

   public void setCatalogsReplacementProducts(List<Product> pCatalogsReplacementProducts){
       setListProperty("catalogsReplacementProducts", pCatalogsReplacementProducts);
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


   public Timestamp getCreationDate(){
      return getSimpleProperty("creationDate",Timestamp.class);
   }

   public void setCreationDate(Timestamp pCreationDate){
      setSimpleProperty("creationDate", pCreationDate);
   }


   public Boolean getNonreturnable(){
      return getSimpleProperty("nonreturnable",Boolean.class);
   }

   public void setNonreturnable(Boolean pNonreturnable){
      setSimpleProperty("nonreturnable", pNonreturnable);
   }


   public List<Product> getReplacementProducts(){
      return getListProperty("replacementProducts", Product.class);
   }

   public void setReplacementProducts(List<Product> pReplacementProducts){
       setListProperty("replacementProducts", pReplacementProducts);
   } 


   public Boolean getGiftWrapEligible(){
      return getSimpleProperty("giftWrapEligible",Boolean.class);
   }

   public void setGiftWrapEligible(Boolean pGiftWrapEligible){
      setSimpleProperty("giftWrapEligible", pGiftWrapEligible);
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


   public Double getSalePrice(){
      return getSimpleProperty("salePrice",Double.class);
   }

   public void setSalePrice(Double pSalePrice){
      setSimpleProperty("salePrice", pSalePrice);
   }


   public String getDisplayName(){
      return getSimpleProperty("displayName",String.class);
   }

   public void setDisplayName(String pDisplayName){
      setSimpleProperty("displayName", pDisplayName);
   }


                                                                                                                        
}                                                                                                                                         
