package org.varelma.oc.test;

import java.util.List;
import java.util.Set;

import atg.adapter.gsa.GenericsRepository;
import atg.nucleus.GenericService;
import atg.repository.beans.productcatalog.Product;
import atg.repository.beans.productcatalog.Sku;

public class GenericsRepositoryPerformanceTest extends GenericService {

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
	    System.gc();
	    StringBuffer sb = new StringBuffer();
	    Thread.sleep(1000);
	    
	    long totalTime = 0;
	    for (int j = 0; j < 10; j++) {
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < 1000; i++) {
		    Product product = repository.getItem(productId, Product.class);
		    String description = product.getDescription();
		    List<Sku> skus = product.getChildSKUs();
		    for (Sku sku : skus) {
			String s = sku.getDisplayNameDefault();
			Set<Product> parents = sku.getParentProducts();
			for (Product parent : parents) {
			    String id = parent.getRepositoryId();
			    String description2 = parent.getDescription();
			    sb.append(product.getId()).append(description).append(s).append(id).append(description2);
			}
		    }
		}
		totalTime += System.currentTimeMillis() - start;
	    }
	    String s = sb.toString();  
	    System.out.println("total time " + totalTime +" result hash " + s.hashCode() + " GenericsRepositoryPerformanceTest");
	} catch (Exception e) {
	    logError(e);
	}
    }
}
