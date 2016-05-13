package atg.adapter.gsa;

import atg.repository.RepositoryException;

public class RepositoryWithCachesDisabled extends GSARepository {

    public void doStartService() {
	super.doStartService();
	if (getDisableItemCachesAtStartup()) {
	    disableAllItemCaches();
	}
	if (getDisableQueryCachesAtStartup()) {
	    disableAllQueryCaches();
	}
    }

    public void disableAllItemCaches() {
	String[] descriptorNames = getItemDescriptorNames();

	try {
	    for (int i = 0; i < descriptorNames.length; i++) {
		GSAItemDescriptor gsaItemDescriptor = ((GSAItemDescriptor) getItemDescriptor(descriptorNames[i]));
		gsaItemDescriptor.setCacheMode(GSAItemDescriptor.CACHE_MODE_DISABLED);
		gsaItemDescriptor.disableItemCache();
		gsaItemDescriptor.setItemCacheSize(0);
		gsaItemDescriptor.setItemCacheTimeout(0);
		gsaItemDescriptor.setItemExpireTimeout(0);
	    }
	} catch (RepositoryException exc) {
	    exc.printStackTrace();
	}
    }

    public void disableAllQueryCaches() {
	String[] descriptorNames = getItemDescriptorNames();

	try {
	    for (int i = 0; i < descriptorNames.length; i++) {
		GSAItemDescriptor gsaItemDescriptor = ((GSAItemDescriptor) getItemDescriptor(descriptorNames[i]));
		gsaItemDescriptor.disableQueryCache();
	    }
	} catch (RepositoryException exc) {
	    exc.printStackTrace();
	}
    }
}
