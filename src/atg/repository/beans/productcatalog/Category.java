package atg.repository.beans.productcatalog;                                                                                                     
import java.util.*;                                                                                                                       
import java.util.Comparator;                                                                                                              
import atg.repository.*;                                                                                                                  
import java.sql.Timestamp;                                                                                                                
import atg.adapter.gsa.MutableRepositoryItemExt;                                                                                          

                                                                                                                       
                                                                                                                                          
@SuppressWarnings({ "serial", "unused" })                                                                                             
public class Category extends MutableRepositoryItemExt implements java.io.Serializable {                                            
   static transient MutableRepository REPOSITORY;                                                                                         
   static transient String DESCRIPTOR = "category";                                                                          
   static transient String REPOSITORY_COMPONENT = "/atg/commerce/catalog/ProductCatalog";                                                                
   static final transient Set<String> COMPLEX_PROPERTIES;                                                                                 
                                                                                                                                          
   static {                                                                                                                               
     Set<String> s  = new HashSet<String>();                                                                                              
          s.add("parentCatalogs");
          s.add("ancestorCategories");
          s.add("thumbnailImage");
          s.add("childCategories");
          s.add("heroImage");
          s.add("myFeature");
          s.add("dynamicChildCategories");
          s.add("feature");
          s.add("childProducts");
          s.add("template");
          s.add("keywords");
          s.add("generatedAncestors");
          s.add("catalog");
          s.add("fixedChildProducts");
          s.add("defaultParentCategory");
          s.add("parentCatalog");
          s.add("subCatalogs");
          s.add("parentCategoryForCatalog");
          s.add("relatedProducts");
          s.add("parentCategory");
          s.add("fixedChildCategories");
          s.add("ancestorCategoryIds");
          s.add("subCatalogsChildCategories");
          s.add("smallImage");
          s.add("fixedParentCategories");
          s.add("dynamicChildProducts");
          s.add("dynamicRelatedCategories");
          s.add("relatedCategories");
          s.add("largeImage");
          s.add("computedCatalogs");
          s.add("siteIds");
          s.add("catalogs");
          s.add("keywordsDefault");
          s.add("fixedRelatedCategories");
                                                                                                                  
     COMPLEX_PROPERTIES = s;                                                                                                              
   }                                                                                                                                      
                                                                                                                                          
                                                                                                                                          
   public Category()  {                                                                                                           
   }                                                                                                                                      
                                                                                                                                          
   public Category(MutableRepositoryItem delegate) {                                                                              
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
                                                                                                                                          
   public String getChildCategoryGroup(){
      return getSimpleProperty("childCategoryGroup",String.class);
   }

   public void setChildCategoryGroup(String pChildCategoryGroup){
      setSimpleProperty("childCategoryGroup", pChildCategoryGroup);
   }


   public Set<Catalog> getParentCatalogs(){
      return getSetProperty("parentCatalogs", Catalog.class);
   }

   public void setParentCatalogs(Set<Catalog> pParentCatalogs){
       setSetProperty("parentCatalogs", pParentCatalogs);
   } 


   public List<Category> getAncestorCategories(){
      return getListProperty("ancestorCategories", Category.class);
   }

   public void setAncestorCategories(List<Category> pAncestorCategories){
       setListProperty("ancestorCategories", pAncestorCategories);
   } 


   public Timestamp getEndDate(){
      return getSimpleProperty("endDate",Timestamp.class);
   }

   public void setEndDate(Timestamp pEndDate){
      setSimpleProperty("endDate", pEndDate);
   }


   public Category getThumbnailImage(){
      return getSingleRepositoryProperty("thumbnailImage",Category.class);
   }

   public void setThumbnailImage(Category pThumbnailImage){
      setSingleRepositoryProperty("thumbnailImage", pThumbnailImage);
   }


   public Integer getType(){
      return getSimpleProperty("type",Integer.class);
   }

   public void setType(Integer pType){
      setSimpleProperty("type", pType);
   }


   public List<Category> getChildCategories(){
      return getListProperty("childCategories", Category.class);
   }

   public void setChildCategories(List<Category> pChildCategories){
       setListProperty("childCategories", pChildCategories);
   } 


   public String getDescription(){
      return getSimpleProperty("description",String.class);
   }

   public void setDescription(String pDescription){
      setSimpleProperty("description", pDescription);
   }


   public Category getHeroImage(){
      return getSingleRepositoryProperty("heroImage",Category.class);
   }

   public void setHeroImage(Category pHeroImage){
      setSingleRepositoryProperty("heroImage", pHeroImage);
   }


   public Category getMyFeature(){
      return getSingleRepositoryProperty("myFeature",Category.class);
   }

   public void setMyFeature(Category pMyFeature){
      setSingleRepositoryProperty("myFeature", pMyFeature);
   }


   public List<Category> getDynamicChildCategories(){
      return getListProperty("dynamicChildCategories", Category.class);
   }

   public void setDynamicChildCategories(List<Category> pDynamicChildCategories){
       setListProperty("dynamicChildCategories", pDynamicChildCategories);
   } 


   public String getLongDescription(){
      return getSimpleProperty("longDescription",String.class);
   }

   public void setLongDescription(String pLongDescription){
      setSimpleProperty("longDescription", pLongDescription);
   }


   public String getRelatedCategoryGroup(){
      return getSimpleProperty("relatedCategoryGroup",String.class);
   }

   public void setRelatedCategoryGroup(String pRelatedCategoryGroup){
      setSimpleProperty("relatedCategoryGroup", pRelatedCategoryGroup);
   }


   public Category getFeature(){
      return getSingleRepositoryProperty("feature",Category.class);
   }

   public void setFeature(Category pFeature){
      setSingleRepositoryProperty("feature", pFeature);
   }


   public List<Product> getChildProducts(){
      return getListProperty("childProducts", Product.class);
   }

   public void setChildProducts(List<Product> pChildProducts){
       setListProperty("childProducts", pChildProducts);
   } 


   public String getLongDescriptionDefault(){
      return getSimpleProperty("longDescriptionDefault",String.class);
   }

   public void setLongDescriptionDefault(String pLongDescriptionDefault){
      setSimpleProperty("longDescriptionDefault", pLongDescriptionDefault);
   }


   public Category getTemplate(){
      return getSingleRepositoryProperty("template",Category.class);
   }

   public void setTemplate(Category pTemplate){
      setSingleRepositoryProperty("template", pTemplate);
   }


   public List<java.lang.String> getKeywords(){
      return getSimpleProperty("keywords",String.class);
   }

   public void setKeywords(List<java.lang.String> pKeywords){
      setSimpleProperty("keywords", pKeywords);
   }


   public Category getGeneratedAncestors(){
      return getSingleRepositoryProperty("generatedAncestors",Category.class);
   }

   public void setGeneratedAncestors(Category pGeneratedAncestors){
      setSingleRepositoryProperty("generatedAncestors", pGeneratedAncestors);
   }


   public Category getCatalog(){
      return getSingleRepositoryProperty("catalog",Category.class);
   }

   public void setCatalog(Category pCatalog){
      setSingleRepositoryProperty("catalog", pCatalog);
   }


   public List<Product> getFixedChildProducts(){
      return getListProperty("fixedChildProducts", Product.class);
   }

   public void setFixedChildProducts(List<Product> pFixedChildProducts){
       setListProperty("fixedChildProducts", pFixedChildProducts);
   } 


   public Category getDefaultParentCategory(){
      return getSingleRepositoryProperty("defaultParentCategory",Category.class);
   }

   public void setDefaultParentCategory(Category pDefaultParentCategory){
      setSingleRepositoryProperty("defaultParentCategory", pDefaultParentCategory);
   }


   public Category getParentCatalog(){
      return getSingleRepositoryProperty("parentCatalog",Category.class);
   }

   public void setParentCatalog(Category pParentCatalog){
      setSingleRepositoryProperty("parentCatalog", pParentCatalog);
   }


   public List<Catalog> getSubCatalogs(){
      return getListProperty("subCatalogs", Catalog.class);
   }

   public void setSubCatalogs(List<Catalog> pSubCatalogs){
       setListProperty("subCatalogs", pSubCatalogs);
   } 


   public String getItemAcl(){
      return getSimpleProperty("itemAcl",String.class);
   }

   public void setItemAcl(String pItemAcl){
      setSimpleProperty("itemAcl", pItemAcl);
   }


   public Category getParentCategoryForCatalog(){
      return getSingleRepositoryProperty("parentCategoryForCatalog",Category.class);
   }

   public void setParentCategoryForCatalog(Category pParentCategoryForCatalog){
      setSingleRepositoryProperty("parentCategoryForCatalog", pParentCategoryForCatalog);
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


   public Category getParentCategory(){
      return getSingleRepositoryProperty("parentCategory",Category.class);
   }

   public void setParentCategory(Category pParentCategory){
      setSingleRepositoryProperty("parentCategory", pParentCategory);
   }


   public List<Category> getFixedChildCategories(){
      return getListProperty("fixedChildCategories", Category.class);
   }

   public void setFixedChildCategories(List<Category> pFixedChildCategories){
       setListProperty("fixedChildCategories", pFixedChildCategories);
   } 


   public Integer getVersion(){
      return getSimpleProperty("version",Integer.class);
   }

   public void setVersion(Integer pVersion){
      setSimpleProperty("version", pVersion);
   }


   public String getChildProductGroup(){
      return getSimpleProperty("childProductGroup",String.class);
   }

   public void setChildProductGroup(String pChildProductGroup){
      setSimpleProperty("childProductGroup", pChildProductGroup);
   }


   public String getId(){
      return getSimpleProperty("id",String.class);
   }

   public void setId(String pId){
      setSimpleProperty("id", pId);
   }


   public Set<java.lang.String> getAncestorCategoryIds(){
      return getSimpleProperty("ancestorCategoryIds",String.class);
   }

   public void setAncestorCategoryIds(Set<java.lang.String> pAncestorCategoryIds){
      setSimpleProperty("ancestorCategoryIds", pAncestorCategoryIds);
   }


   public List<Category> getSubCatalogsChildCategories(){
      return getListProperty("subCatalogsChildCategories", Category.class);
   }

   public void setSubCatalogsChildCategories(List<Category> pSubCatalogsChildCategories){
       setListProperty("subCatalogsChildCategories", pSubCatalogsChildCategories);
   } 


   public Boolean getIsAncestorsGenerated(){
      return getSimpleProperty("isAncestorsGenerated",Boolean.class);
   }

   public void setIsAncestorsGenerated(Boolean pIsAncestorsGenerated){
      setSimpleProperty("isAncestorsGenerated", pIsAncestorsGenerated);
   }


   public Category getSmallImage(){
      return getSingleRepositoryProperty("smallImage",Category.class);
   }

   public void setSmallImage(Category pSmallImage){
      setSingleRepositoryProperty("smallImage", pSmallImage);
   }


   public Set<Category> getFixedParentCategories(){
      return getSetProperty("fixedParentCategories", Category.class);
   }

   public void setFixedParentCategories(Set<Category> pFixedParentCategories){
       setSetProperty("fixedParentCategories", pFixedParentCategories);
   } 


   public List<Product> getDynamicChildProducts(){
      return getListProperty("dynamicChildProducts", Product.class);
   }

   public void setDynamicChildProducts(List<Product> pDynamicChildProducts){
       setListProperty("dynamicChildProducts", pDynamicChildProducts);
   } 


   public List<Category> getDynamicRelatedCategories(){
      return getListProperty("dynamicRelatedCategories", Category.class);
   }

   public void setDynamicRelatedCategories(List<Category> pDynamicRelatedCategories){
       setListProperty("dynamicRelatedCategories", pDynamicRelatedCategories);
   } 


   public String getDisplayNameDefault(){
      return getSimpleProperty("displayNameDefault",String.class);
   }

   public void setDisplayNameDefault(String pDisplayNameDefault){
      setSimpleProperty("displayNameDefault", pDisplayNameDefault);
   }


   public List<Category> getRelatedCategories(){
      return getListProperty("relatedCategories", Category.class);
   }

   public void setRelatedCategories(List<Category> pRelatedCategories){
       setListProperty("relatedCategories", pRelatedCategories);
   } 


   public Category getLargeImage(){
      return getSingleRepositoryProperty("largeImage",Category.class);
   }

   public void setLargeImage(Category pLargeImage){
      setSingleRepositoryProperty("largeImage", pLargeImage);
   }


   public Set<Catalog> getComputedCatalogs(){
      return getSetProperty("computedCatalogs", Catalog.class);
   }

   public void setComputedCatalogs(Set<Catalog> pComputedCatalogs){
       setSetProperty("computedCatalogs", pComputedCatalogs);
   } 


   public Timestamp getCreationDate(){
      return getSimpleProperty("creationDate",Timestamp.class);
   }

   public void setCreationDate(Timestamp pCreationDate){
      setSimpleProperty("creationDate", pCreationDate);
   }


   public Set<java.lang.String> getSiteIds(){
      return getSimpleProperty("siteIds",String.class);
   }

   public void setSiteIds(Set<java.lang.String> pSiteIds){
      setSimpleProperty("siteIds", pSiteIds);
   }


   public String getDescriptionDefault(){
      return getSimpleProperty("descriptionDefault",String.class);
   }

   public void setDescriptionDefault(String pDescriptionDefault){
      setSimpleProperty("descriptionDefault", pDescriptionDefault);
   }


   public Set<Catalog> getCatalogs(){
      return getSetProperty("catalogs", Catalog.class);
   }

   public void setCatalogs(Set<Catalog> pCatalogs){
       setSetProperty("catalogs", pCatalogs);
   } 


   public List<java.lang.String> getKeywordsDefault(){
      return getSimpleProperty("keywordsDefault",String.class);
   }

   public void setKeywordsDefault(List<java.lang.String> pKeywordsDefault){
      setSimpleProperty("keywordsDefault", pKeywordsDefault);
   }


   public String getDisplayName(){
      return getSimpleProperty("displayName",String.class);
   }

   public void setDisplayName(String pDisplayName){
      setSimpleProperty("displayName", pDisplayName);
   }


   public List<Category> getFixedRelatedCategories(){
      return getListProperty("fixedRelatedCategories", Category.class);
   }

   public void setFixedRelatedCategories(List<Category> pFixedRelatedCategories){
       setListProperty("fixedRelatedCategories", pFixedRelatedCategories);
   } 


                                                                                                                        
}                                                                                                                                         
