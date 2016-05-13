package org.varelma.oc.test;

import java.util.List;
import java.util.Set;

import atg.nucleus.GenericService;
import atg.repository.Repository;
import atg.repository.RepositoryItem;

public class ColdLookupNonGenericsRepositoryPerformanceTest extends GenericService {

    private Repository repository;

    public Repository getRepository() {
	return repository;
    }

    public void setRepository(Repository repository) {
	this.repository = repository;
    }
 
    public void testIt() {
	try {

	    RepositoryItem loader = repository.getItem("xprod2078", "product");
	    System.gc();
	    Thread.sleep(1000);
  
	    long start = System.currentTimeMillis();

	    String[] products = { "xprod2531", "xprod2536", "xprod2535", "xprod2500", "xprod2502", "xprod2501", "xprod2504", "xprod2503", "xprod2505", "xprod2506", "xprod2507", "xprod2508", "xprod2509", "xprod2521", "xprod2522", "xprod2528", "xprod2527",
		    "xprod2529", "xprod2514", "xprod2512", "xprod2513", "xprod2510", "xprod2511", "xprod2519", "xprod2518", "xprod2517", "xprod2516", "xprod2532", "xprod2533", "xprod1014", "xprod1015", "xprod1003", "xprod1004", "xprod1001", "xprod1002",
		    "xprod1007", "xprod1008", "xprod1005", "xprod1006", "xprod1009", "xprod2523", "xprod2524", "xprod2525", "xprod2526", "xprod2520", "xprod2156", "xprod2157", "xprod2158", "xprod2159", "xprod2152", "xprod2153", "xprod2154", "xprod2155",
		    "xprod2150", "xprod2151", "xprod1010", "xprod1011", "xprod1012", "xprod1013", "xprod1042", "xprod40028", "xprod40022", "xprod1039", "xprod1038", "xprod2169", "xprod2167", "xprod2168", "xprod2165", "xprod2166", "xprod2163", "xprod2164",
		    "xprod2161", "xprod2162", "xprod1043", "xprod2160", "xprod2114", "xprod2113", "xprod1069", "xprod2112", "xprod1057", "xprod1056", "xprod1059", "xprod1058", "xprod1048", "xprod1047", "xprod1046", "xprod1045", "xprod1049", "xprod1040",
		    "xprod40026", "xprod1044", "xprod2129", "xprod2124", "xprod2123", "xprod2126", "xprod2125", "xprod2111", "xprod2110", "xprod1064" };

	    for (int i = 0; i < products.length; i++) {
		StringBuffer buff = new StringBuffer();
		String prodId = products[i];
		RepositoryItem repositoryItem = repository.getItem(prodId, "product");
		String description = (String) repositoryItem.getPropertyValue("description");
		List<RepositoryItem> childSKUs = (List<RepositoryItem>) repositoryItem.getPropertyValue("childSKUs");
		for (RepositoryItem sku : childSKUs) {
		    Set<RepositoryItem> parents = (Set<RepositoryItem>) sku.getPropertyValue("parentProducts");
		    for (RepositoryItem parent : parents) {
			String id = parent.getRepositoryId();
			String description2 = (String) parent.getPropertyValue("description");
			//buff.append(id).append("DESCRIPTION=" + description2  );
		    }
		}
	    }

	    long totalTime =  System.currentTimeMillis() - start;
	    System.out.println("total time " + totalTime);
	} catch (Exception e) {

	    logError(e);
	}
    }
}
