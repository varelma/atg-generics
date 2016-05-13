package atg.repository.beans.productcatalog;                                                                                                     
import java.util.*;                                                                                                                       
import java.util.Comparator;                                                                                                              
import atg.repository.*;                                                                                                                  
import java.sql.Timestamp;                                                                                                                
import atg.adapter.gsa.MutableRepositoryItemExt;                                                                                          

                                                                                                                       
                                                                                                                                          
@SuppressWarnings({ "serial", "unused" })                                                                                             
public class PromotionalContent extends MutableRepositoryItemExt implements java.io.Serializable {                                            
   static transient MutableRepository REPOSITORY;                                                                                         
   static transient String DESCRIPTOR = "promotionalContent";                                                                          
   static transient String REPOSITORY_COMPONENT = "/atg/commerce/catalog/ProductCatalog";                                                                
   static final transient Set<String> COMPLEX_PROPERTIES;                                                                                 
                                                                                                                                          
   static {                                                                                                                               
     Set<String> s  = new HashSet<String>();                                                                                              
          s.add("parentFolder");
          s.add("promotion");
          s.add("associatedProduct");
          s.add("template");
          s.add("associatedCategory");
                                                                                                                  
     COMPLEX_PROPERTIES = s;                                                                                                              
   }                                                                                                                                      
                                                                                                                                          
                                                                                                                                          
   public PromotionalContent()  {                                                                                                           
   }                                                                                                                                      
                                                                                                                                          
   public PromotionalContent(MutableRepositoryItem delegate) {                                                                              
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


   public PromotionalContent getParentFolder(){
      return getSingleRepositoryProperty("parentFolder",PromotionalContent.class);
   }

   public void setParentFolder(PromotionalContent pParentFolder){
      setSingleRepositoryProperty("parentFolder", pParentFolder);
   }


   public String getLinkUrl(){
      return getSimpleProperty("linkUrl",String.class);
   }

   public void setLinkUrl(String pLinkUrl){
      setSimpleProperty("linkUrl", pLinkUrl);
   }


   public String getAssociatedSite(){
      return getSimpleProperty("associatedSite",String.class);
   }

   public void setAssociatedSite(String pAssociatedSite){
      setSimpleProperty("associatedSite", pAssociatedSite);
   }


   public String getDerivedDeviceImage(){
      return getSimpleProperty("derivedDeviceImage",String.class);
   }

   public void setDerivedDeviceImage(String pDerivedDeviceImage){
      setSimpleProperty("derivedDeviceImage", pDerivedDeviceImage);
   }


   public PromotionalContent getPromotion(){
      return getSingleRepositoryProperty("promotion",PromotionalContent.class);
   }

   public void setPromotion(PromotionalContent pPromotion){
      setSingleRepositoryProperty("promotion", pPromotion);
   }


   public Timestamp getEndDate(){
      return getSimpleProperty("endDate",Timestamp.class);
   }

   public void setEndDate(Timestamp pEndDate){
      setSimpleProperty("endDate", pEndDate);
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


   public String getLinkText(){
      return getSimpleProperty("linkText",String.class);
   }

   public void setLinkText(String pLinkText){
      setSimpleProperty("linkText", pLinkText);
   }


   public String getLinkTextDefault(){
      return getSimpleProperty("linkTextDefault",String.class);
   }

   public void setLinkTextDefault(String pLinkTextDefault){
      setSimpleProperty("linkTextDefault", pLinkTextDefault);
   }


   public String getDescription(){
      return getSimpleProperty("description",String.class);
   }

   public void setDescription(String pDescription){
      setSimpleProperty("description", pDescription);
   }


   public String getPath(){
      return getSimpleProperty("path",String.class);
   }

   public void setPath(String pPath){
      setSimpleProperty("path", pPath);
   }


   public String getLongDescription(){
      return getSimpleProperty("longDescription",String.class);
   }

   public void setLongDescription(String pLongDescription){
      setSimpleProperty("longDescription", pLongDescription);
   }


   public PromotionalContent getAssociatedProduct(){
      return getSingleRepositoryProperty("associatedProduct",PromotionalContent.class);
   }

   public void setAssociatedProduct(PromotionalContent pAssociatedProduct){
      setSingleRepositoryProperty("associatedProduct", pAssociatedProduct);
   }


   public String getDerivedImage(){
      return getSimpleProperty("derivedImage",String.class);
   }

   public void setDerivedImage(String pDerivedImage){
      setSimpleProperty("derivedImage", pDerivedImage);
   }


   public String getStoreDisplayNameDefault(){
      return getSimpleProperty("storeDisplayNameDefault",String.class);
   }

   public void setStoreDisplayNameDefault(String pStoreDisplayNameDefault){
      setSimpleProperty("storeDisplayNameDefault", pStoreDisplayNameDefault);
   }


   public PromotionalContent getTemplate(){
      return getSingleRepositoryProperty("template",PromotionalContent.class);
   }

   public void setTemplate(PromotionalContent pTemplate){
      setSingleRepositoryProperty("template", pTemplate);
   }


   public String getLongDescriptionDefault(){
      return getSimpleProperty("longDescriptionDefault",String.class);
   }

   public void setLongDescriptionDefault(String pLongDescriptionDefault){
      setSimpleProperty("longDescriptionDefault", pLongDescriptionDefault);
   }


   public String getDeviceDescription(){
      return getSimpleProperty("deviceDescription",String.class);
   }

   public void setDeviceDescription(String pDeviceDescription){
      setSimpleProperty("deviceDescription", pDeviceDescription);
   }


   public String getStoreDisplayName(){
      return getSimpleProperty("storeDisplayName",String.class);
   }

   public void setStoreDisplayName(String pStoreDisplayName){
      setSimpleProperty("storeDisplayName", pStoreDisplayName);
   }


   public String getDisplayNameDefault(){
      return getSimpleProperty("displayNameDefault",String.class);
   }

   public void setDisplayNameDefault(String pDisplayNameDefault){
      setSimpleProperty("displayNameDefault", pDisplayNameDefault);
   }


   public PromotionalContent getAssociatedCategory(){
      return getSingleRepositoryProperty("associatedCategory",PromotionalContent.class);
   }

   public void setAssociatedCategory(PromotionalContent pAssociatedCategory){
      setSingleRepositoryProperty("associatedCategory", pAssociatedCategory);
   }


   public String getDeviceLinkUrl(){
      return getSimpleProperty("deviceLinkUrl",String.class);
   }

   public void setDeviceLinkUrl(String pDeviceLinkUrl){
      setSimpleProperty("deviceLinkUrl", pDeviceLinkUrl);
   }


   public String getLinkUrlDefault(){
      return getSimpleProperty("linkUrlDefault",String.class);
   }

   public void setLinkUrlDefault(String pLinkUrlDefault){
      setSimpleProperty("linkUrlDefault", pLinkUrlDefault);
   }


   public String getImage(){
      return getSimpleProperty("image",String.class);
   }

   public void setImage(String pImage){
      setSimpleProperty("image", pImage);
   }


   public Integer getMarketingPriority(){
      return getSimpleProperty("marketingPriority",Integer.class);
   }

   public void setMarketingPriority(Integer pMarketingPriority){
      setSimpleProperty("marketingPriority", pMarketingPriority);
   }


   public Timestamp getCreationDate(){
      return getSimpleProperty("creationDate",Timestamp.class);
   }

   public void setCreationDate(Timestamp pCreationDate){
      setSimpleProperty("creationDate", pCreationDate);
   }


   public String getDescriptionDefault(){
      return getSimpleProperty("descriptionDefault",String.class);
   }

   public void setDescriptionDefault(String pDescriptionDefault){
      setSimpleProperty("descriptionDefault", pDescriptionDefault);
   }


   public String getDisplayName(){
      return getSimpleProperty("displayName",String.class);
   }

   public void setDisplayName(String pDisplayName){
      setSimpleProperty("displayName", pDisplayName);
   }


   public String getDeviceImage(){
      return getSimpleProperty("deviceImage",String.class);
   }

   public void setDeviceImage(String pDeviceImage){
      setSimpleProperty("deviceImage", pDeviceImage);
   }


                                                                                                                        
}                                                                                                                                         
