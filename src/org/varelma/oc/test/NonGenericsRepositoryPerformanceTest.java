package org.varelma.oc.test;

import java.util.List;
import java.util.Set;

import atg.nucleus.GenericService;
import atg.repository.Repository;
import atg.repository.RepositoryItem;
import atg.repository.beans.productcatalog.Product;
import atg.repository.beans.productcatalog.Sku;

public class NonGenericsRepositoryPerformanceTest extends GenericService {

    private Repository repository;

    public Repository getRepository() {
	return repository;
    }

    public void setRepository(Repository repository) {
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
		    RepositoryItem repositoryItem = repository.getItem(productId, "product");
		    String description = (String) repositoryItem.getPropertyValue("description");
		    List<RepositoryItem> childSKUs = (List<RepositoryItem>) repositoryItem.getPropertyValue("childSKUs");
		    for (RepositoryItem sku : childSKUs) {
			String s = (String) sku.getPropertyValue("displayNameDefault");
			Set<RepositoryItem> parents = (Set<RepositoryItem>) sku.getPropertyValue("parentProducts");
			for (RepositoryItem parent : parents) {
			    String id = parent.getRepositoryId();
			    String description2 = (String) parent.getPropertyValue("description");
			    sb.append(repositoryItem.getRepositoryId()).append(description).append(s).append(id).append(description2);
			}
		    }
		}
		totalTime += System.currentTimeMillis() - start;
	    }
	    String s = sb.toString();
	    System.out.println("total time " + totalTime +" result hash " + s.hashCode() + " NonGenericsRepositoryPerformanceTest");
	} catch (Exception e) {
	    logError(e);
	}
    }
}
