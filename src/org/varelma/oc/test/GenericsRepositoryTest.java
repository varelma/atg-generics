package org.varelma.oc.test;

import java.util.List;

import atg.adapter.gsa.GenericsRepository;
import atg.adapter.gsa.GenericsRepositoryView;
import atg.adapter.gsa.MutableRepositoryItemExt;
import atg.nucleus.GenericService;
import atg.repository.Query;
import atg.repository.RepositoryItem;
import atg.repository.beans.productcatalog.Product;
import atg.repository.beans.productcatalog.Sku;

public class GenericsRepositoryTest extends GenericService {

    private GenericsRepository repository;

    public GenericsRepository getRepository() {
	return repository;
    }

    public void setRepository(GenericsRepository repository) {
	this.repository = repository;
    }

    private String productId;

    public String getProductId() {
	return productId;
    }

    public void setProductId(String productId) {
	this.productId = productId;
    }
 
    public void testIt() {
	try {
	    long start = System.currentTimeMillis();
              
	    
	    // The code below will work using GenericsRepository
 	    Product product0 = repository.getItem(productId, Product.class);
 	    String description0 = product0.getDescription();
	    repository.commit();
 	   // The code below will work using GenericsRepository
 	    Product product1 = repository.getItem(productId, Product.class);
 	    String description1 = product1.getDescription();
	    
	      
	   /* 
	    GenericsRepositoryView view = repository.getGenericRepositoryView("product");
	    Query query = view.getQueryBuilder().createUnconstrainedQuery();
	   // System.out.println("XXXXXXXXX");
	    MutableRepositoryItemExt xxx = (MutableRepositoryItemExt) product1; 
	    Product[] allProducts = view.executeQuery(query, Product.class);
	    
	      
	    for (int i = 0; i < allProducts.length; i++) {
		Product product = allProducts[i];
		 String description = product.getDescription();
		 String description2 = product.getDescription();
		 String id = product.getId();
			  
		 //System.out.println("id=" + id + "description=" +description);
	    }
	    
	    */
	    //Product productNew  = new Product();
	    //productNew.setDisplayNameDefault("my new product");
        	//    productNew.save();
	    
	    
	    
	    // The code below will work using GenericsRepository
 	    Product product = repository.getItem(productId, Product.class);
 	    
 	    
	    String description = product.getDescription();
	    logInfo("1=" + description);

	    List<Sku> skus = product.getChildSKUs();
	    for (Sku sku : skus) {
		String id = sku.getId();
		System.out.println(id);
		String displayNameDefault = sku.getDisplayNameDefault();
		System.out.println(displayNameDefault);
	    }

	    RepositoryItem productRepositoryItem = (RepositoryItem) product;
	    description = (String) productRepositoryItem.getPropertyValue("description");
	    logInfo("2=" + description);

	    List< RepositoryItem> chlidlkjslkfj = (List<RepositoryItem>) productRepositoryItem.getPropertyValue("childSKUs");
	    
	    
	    product = (Product) repository.getItem(productId, "product");
	    description = product.getDescription();
	    logInfo("3=" + description);

	    RepositoryItem item = repository.getItem(productId, "product");
	    description = (String) item.getPropertyValue("description");
	    
	  
	    
	    logInfo("4=" + description);

	    product = (Product) item;
	    description = product.getDescription();
	    logInfo("5=" + description);

	    long totalTime = System.currentTimeMillis() - start;
	    System.out.println("total time " + totalTime);
	} catch (Exception e) {
	    logError(e);
	}
    }
}
