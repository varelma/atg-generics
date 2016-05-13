package atg.repository.beans.productcatalog;                                                                                                     
import java.util.*;                                                                                                                       
import java.util.Comparator;                                                                                                              
import atg.repository.*;                                                                                                                  
import java.sql.Timestamp;                                                                                                                
import atg.adapter.gsa.MutableRepositoryItemExt;                                                                                          

                                                                                                                       
                                                                                                                                          
@SuppressWarnings({ "serial", "unused" })                                                                                             
public class Catalog extends MutableRepositoryItemExt implements java.io.Serializable {                                            
   static transient MutableRepository REPOSITORY;                                                                                         
   static transient String DESCRIPTOR = "catalog";                                                                          
   static transient String REPOSITORY_COMPONENT = "/atg/commerce/catalog/ProductCatalog";                                                                
   static final transient Set<String> COMPLEX_PROPERTIES;                                                                                 
                                                                                                                                          
   static {                                                                                                                               
     Set<String> s  = new HashSet<String>();                                                                                              
          s.add("rootSubCatalogs");
          s.add("ancestorCatalogsAndSelf");
          s.add("allRootCategoryIds");
          s.add("indirectAncestorCatalogs");
          s.add("ancestorCategories");
          s.add("parentCategories");
          s.add("directParentCatalogs");
          s.add("rootNavigationCategory");
          s.add("parentFolders");
          s.add("directAncestorCatalogsAndSelf");
          s.add("siteIds");
          s.add("rootCategories");
          s.add("rootCategoryIds");
          s.add("allRootCategories");
                                                                                                                  
     COMPLEX_PROPERTIES = s;                                                                                                              
   }                                                                                                                                      
                                                                                                                                          
                                                                                                                                          
   public Catalog()  {                                                                                                           
   }                                                                                                                                      
                                                                                                                                          
   public Catalog(MutableRepositoryItem delegate) {                                                                              
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
                                                                                                                                          
   public Set<Catalog> getRootSubCatalogs(){
      return getSetProperty("rootSubCatalogs", Catalog.class);
   }

   public void setRootSubCatalogs(Set<Catalog> pRootSubCatalogs){
       setSetProperty("rootSubCatalogs", pRootSubCatalogs);
   } 


   public Integer getIndex(){
      return getSimpleProperty("index",Integer.class);
   }

   public void setIndex(Integer pIndex){
      setSimpleProperty("index", pIndex);
   }


   public List<Catalog> getAncestorCatalogsAndSelf(){
      return getListProperty("ancestorCatalogsAndSelf", Catalog.class);
   }

   public void setAncestorCatalogsAndSelf(List<Catalog> pAncestorCatalogsAndSelf){
       setListProperty("ancestorCatalogsAndSelf", pAncestorCatalogsAndSelf);
   } 


   public String getStatus(){
      return getSimpleProperty("status",String.class);
   }

   public void setStatus(String pStatus){
      setSimpleProperty("status", pStatus);
   }


   public Set<java.lang.String> getAllRootCategoryIds(){
      return getSimpleProperty("allRootCategoryIds",String.class);
   }

   public void setAllRootCategoryIds(Set<java.lang.String> pAllRootCategoryIds){
      setSimpleProperty("allRootCategoryIds", pAllRootCategoryIds);
   }


   public List<Catalog> getIndirectAncestorCatalogs(){
      return getListProperty("indirectAncestorCatalogs", Catalog.class);
   }

   public void setIndirectAncestorCatalogs(List<Catalog> pIndirectAncestorCatalogs){
       setListProperty("indirectAncestorCatalogs", pIndirectAncestorCatalogs);
   } 


   public List<Category> getAncestorCategories(){
      return getListProperty("ancestorCategories", Category.class);
   }

   public void setAncestorCategories(List<Category> pAncestorCategories){
       setListProperty("ancestorCategories", pAncestorCategories);
   } 


   public Set<Category> getParentCategories(){
      return getSetProperty("parentCategories", Category.class);
   }

   public void setParentCategories(Set<Category> pParentCategories){
       setSetProperty("parentCategories", pParentCategories);
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


   public String getItemAcl(){
      return getSimpleProperty("itemAcl",String.class);
   }

   public void setItemAcl(String pItemAcl){
      setSimpleProperty("itemAcl", pItemAcl);
   }


   public Set<Catalog> getDirectParentCatalogs(){
      return getSetProperty("directParentCatalogs", Catalog.class);
   }

   public void setDirectParentCatalogs(Set<Catalog> pDirectParentCatalogs){
       setSetProperty("directParentCatalogs", pDirectParentCatalogs);
   } 


   public Catalog getRootNavigationCategory(){
      return getSingleRepositoryProperty("rootNavigationCategory",Catalog.class);
   }

   public void setRootNavigationCategory(Catalog pRootNavigationCategory){
      setSingleRepositoryProperty("rootNavigationCategory", pRootNavigationCategory);
   }


   public Timestamp getCreationDate(){
      return getSimpleProperty("creationDate",Timestamp.class);
   }

   public void setCreationDate(Timestamp pCreationDate){
      setSimpleProperty("creationDate", pCreationDate);
   }


   public Set<CatalogFolder> getParentFolders(){
      return getSetProperty("parentFolders", CatalogFolder.class);
   }

   public void setParentFolders(Set<CatalogFolder> pParentFolders){
       setSetProperty("parentFolders", pParentFolders);
   } 


   public List<Catalog> getDirectAncestorCatalogsAndSelf(){
      return getListProperty("directAncestorCatalogsAndSelf", Catalog.class);
   }

   public void setDirectAncestorCatalogsAndSelf(List<Catalog> pDirectAncestorCatalogsAndSelf){
       setListProperty("directAncestorCatalogsAndSelf", pDirectAncestorCatalogsAndSelf);
   } 


   public Timestamp getLastModifiedDate(){
      return getSimpleProperty("lastModifiedDate",Timestamp.class);
   }

   public void setLastModifiedDate(Timestamp pLastModifiedDate){
      setSimpleProperty("lastModifiedDate", pLastModifiedDate);
   }


   public Set<java.lang.String> getSiteIds(){
      return getSimpleProperty("siteIds",String.class);
   }

   public void setSiteIds(Set<java.lang.String> pSiteIds){
      setSimpleProperty("siteIds", pSiteIds);
   }


   public Set<Category> getRootCategories(){
      return getSetProperty("rootCategories", Category.class);
   }

   public void setRootCategories(Set<Category> pRootCategories){
       setSetProperty("rootCategories", pRootCategories);
   } 


   public String getDisplayName(){
      return getSimpleProperty("displayName",String.class);
   }

   public void setDisplayName(String pDisplayName){
      setSimpleProperty("displayName", pDisplayName);
   }


   public Set<java.lang.String> getRootCategoryIds(){
      return getSimpleProperty("rootCategoryIds",String.class);
   }

   public void setRootCategoryIds(Set<java.lang.String> pRootCategoryIds){
      setSimpleProperty("rootCategoryIds", pRootCategoryIds);
   }


   public Set<Category> getAllRootCategories(){
      return getSetProperty("allRootCategories", Category.class);
   }

   public void setAllRootCategories(Set<Category> pAllRootCategories){
       setSetProperty("allRootCategories", pAllRootCategories);
   } 


                                                                                                                        
}                                                                                                                                         
