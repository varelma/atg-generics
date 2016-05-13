package atg.repository.beans.productcatalog;                                                                                                     
import java.util.*;                                                                                                                       
import java.util.Comparator;                                                                                                              
import atg.repository.*;                                                                                                                  
import java.sql.Timestamp;                                                                                                                
import atg.adapter.gsa.MutableRepositoryItemExt;                                                                                          

                                                                                                                       
                                                                                                                                          
@SuppressWarnings({ "serial", "unused" })                                                                                             
public class CatalogFolder extends GenericFolder implements java.io.Serializable {                                            
   static transient MutableRepository REPOSITORY;                                                                                         
   static transient String DESCRIPTOR = "catalogFolder";                                                                          
   static transient String REPOSITORY_COMPONENT = "/atg/commerce/catalog/ProductCatalog";                                                                
   static final transient Set<String> COMPLEX_PROPERTIES;                                                                                 
                                                                                                                                          
   static {                                                                                                                               
     Set<String> s  = new HashSet<String>();                                                                                              
          s.add("childItems");
          s.add("parentFolders");
          s.add("siteIds");
          s.add("parent");
          s.add("childFolders");
                                                                                                                  
     COMPLEX_PROPERTIES = s;                                                                                                              
   }                                                                                                                                      
                                                                                                                                          
                                                                                                                                          
   public CatalogFolder()  {                                                                                                           
   }                                                                                                                                      
                                                                                                                                          
   public CatalogFolder(MutableRepositoryItem delegate) {                                                                              
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
                                                                                                                                          
   public String getIdThis(){
      return getSimpleProperty("id",String.class);
   }

   public void setIdThis(String pId){
      setSimpleProperty("id", pId);
   }


   public String getItemAclThis(){
      return getSimpleProperty("itemAcl",String.class);
   }

   public void setItemAclThis(String pItemAcl){
      setSimpleProperty("itemAcl", pItemAcl);
   }


   public List<Catalog> getChildItemsThis(){
      return getListProperty("childItems", Catalog.class);
   }

   public void setChildItemsThis(List<Catalog> pChildItems){
       setListProperty("childItems", pChildItems);
   } 


   public Set<GenericFolder> getParentFoldersThis(){
      return getSetProperty("parentFolders", GenericFolder.class);
   }

   public void setParentFoldersThis(Set<GenericFolder> pParentFolders){
       setSetProperty("parentFolders", pParentFolders);
   } 


   public String getDescriptionThis(){
      return getSimpleProperty("description",String.class);
   }

   public void setDescriptionThis(String pDescription){
      setSimpleProperty("description", pDescription);
   }


   public String getNameThis(){
      return getSimpleProperty("name",String.class);
   }

   public void setNameThis(String pName){
      setSimpleProperty("name", pName);
   }


   public Set<java.lang.String> getSiteIds(){
      return getSimpleProperty("siteIds",String.class);
   }

   public void setSiteIds(Set<java.lang.String> pSiteIds){
      setSimpleProperty("siteIds", pSiteIds);
   }


   public CatalogFolder getParentThis(){
      return getSingleRepositoryProperty("parent",CatalogFolder.class);
   }

   public void setParentThis(CatalogFolder pParent){
      setSingleRepositoryProperty("parent", pParent);
   }


   public String getTypeThis(){
      return getSimpleProperty("type",String.class);
   }

   public void setTypeThis(String pType){
      setSimpleProperty("type", pType);
   }


   public List<GenericFolder> getChildFoldersThis(){
      return getListProperty("childFolders", GenericFolder.class);
   }

   public void setChildFoldersThis(List<GenericFolder> pChildFolders){
       setListProperty("childFolders", pChildFolders);
   } 


                                                                                                                        
}                                                                                                                                         
