package atg.adapter.gsa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.beanutils.ConstructorUtils;
import org.varelma.oc.util.ComponentResolver;

import atg.nucleus.logging.ApplicationLogging;
import atg.repository.MutableRepository;
import atg.repository.MutableRepositoryItem;
import atg.repository.RepositoryException;
import atg.repository.RepositoryItem;
import atg.repository.RepositoryItemDescriptor;

public abstract class MutableRepositoryItemExt implements MutableRepositoryItem, Serializable {

    private static final long serialVersionUID = -5920055263867935424L;
    public Map<String, Object> cachedData = null;
    public String repositoryId;

    private transient MutableRepositoryItem delegate;

    public MutableRepositoryItemExt() {
	cachedData = new HashMap<String, Object>();
    }

    public MutableRepositoryItemExt(MutableRepositoryItem delegate) {
	cachedData = new HashMap<String, Object>();
	this.delegate = delegate;
	this.repositoryId = this.delegate.getRepositoryId();
    }

    public Map<String, Object> getCachedData() {
	return cachedData;
    }

    public void setCachedData(Map<String, Object> cachedData) {
	this.cachedData = cachedData;
    }

    static transient GenericsRepository REPOSITORY;

    protected abstract String getDescriptor();

    protected abstract String getRepositoryComponent();

    public GenericsRepository getRepository() {
	if (REPOSITORY != null) {
	    return REPOSITORY;
	}
	REPOSITORY = (GenericsRepository) ComponentResolver.getComponent(getRepositoryComponent());
	return REPOSITORY;
    }

    public MutableRepositoryItem getDelegate() {
	try {
	    if (delegate != null) {
		return delegate;
	    }
	    if (getRepositoryId() == null) {
		delegate = getRepository().createItem(getDescriptor());
	    } else {
		delegate = (MutableRepositoryItem) getRepository().getSuperItem(getRepositoryId(), getDescriptor());
	    }
	} catch (RepositoryException e) {
	    e.printStackTrace();
	}
	return delegate;
    }

    public void setDelegate(RepositoryItem delegate) {
	this.delegate = (MutableRepositoryItem) delegate;
    }

    public String getItemDisplayName() {
	return getDelegate().getItemDisplayName();
    }

    public void setPropertyValue(String paramString, Object paramObject) {
	getDelegate().setPropertyValue(paramString, paramObject);
    }

    public String getRepositoryId() {
	return this.repositoryId;
    }

    public void setRepositoryId(String repositoryId) {
	this.repositoryId = repositoryId;
    }

    public Object getPropertyValue(String paramString) {
	return getDelegate().getPropertyValue(paramString);
    }

    public RepositoryItemDescriptor getItemDescriptor() throws RepositoryException {
	return getDelegate().getItemDescriptor();
    }

    public boolean isTransient() {
	return getDelegate().isTransient();
    }

    public Collection<String> getContextMemberships() throws RepositoryException {
	return getDelegate().getContextMemberships();
    }

    public void save() {
	try {
	    MutableRepository mutableRepository = ((MutableRepository) getDelegate().getRepository());
	    if (getDelegate().isTransient()) {
		mutableRepository.addItem(this.getDelegate());
	    } else {
		mutableRepository.updateItem(this.getDelegate());
	    }
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected List wrapList(List<RepositoryItem> in, String repositryId, String propertyName, Class clazz) {
	List<RepositoryItem> list = new ArrayList<RepositoryItem>();
	String itemDescriptorName = "";
	try {
	    itemDescriptorName = this.getItemDescriptor().getItemDescriptorName();
	    for (RepositoryItem repositoryItem : in) {
		MutableRepositoryItemExt mutableRepositoryItemExt = getRepository().getItemCache().get(repositoryItem.getRepositoryId() + GenericsRepository.SPLIT_CHAR + clazz.getCanonicalName());
		if (mutableRepositoryItemExt != null) {
		    // is the item already in the cache.
		    // this can happen if product -- childSkus -- parantProducts so running this check ensures that objects are 
		    // created only once
		    list.add(mutableRepositoryItemExt);
		} else {
		    mutableRepositoryItemExt = ConstructorUtils.invokeExactConstructor(clazz, null);
		    mutableRepositoryItemExt.setDelegate(repositoryItem);
		    mutableRepositoryItemExt.setRepositoryId(repositoryItem.getRepositoryId());
		    list.add(mutableRepositoryItemExt);
		    getRepository().getItemCache().put(mutableRepositoryItemExt.getRepositoryId() + GenericsRepository.SPLIT_CHAR + mutableRepositoryItemExt.getClass().getCanonicalName(), mutableRepositoryItemExt);
		}
	    }
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
	List result = null;
	if (getRepository().isChangeAware()) {
	    result = new ChangeAwareList(list, this, itemDescriptorName, (ApplicationLogging) this.getRepository());
	} else {
	    result = list;
	}
	return result;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected Set wrapSet(Set<RepositoryItem> in, String repositryId, String propertyName, Class clazz) {
	Set<RepositoryItem> set = new HashSet<RepositoryItem>();
	String itemDescriptorName = "";
	try {
	    itemDescriptorName = this.getItemDescriptor().getItemDescriptorName();
	    for (RepositoryItem repositoryItem : in) {
		MutableRepositoryItemExt mutableRepositoryItemExt = getRepository().getItemCache().get(repositoryItem.getRepositoryId() + GenericsRepository.SPLIT_CHAR + clazz.getCanonicalName());
		if (mutableRepositoryItemExt != null) {
		    // is the item already in the cache.
		    // this can happen if product -- childSkus -- parantProducts so running this check ensures that objects are 
		    // created only once
		    set.add(mutableRepositoryItemExt);
		} else {
		    mutableRepositoryItemExt = ConstructorUtils.invokeExactConstructor(clazz, null);
		    mutableRepositoryItemExt.setDelegate(repositoryItem);
		    mutableRepositoryItemExt.setRepositoryId(repositoryItem.getRepositoryId());
		    set.add(mutableRepositoryItemExt);
		    getRepository().getItemCache().put(mutableRepositoryItemExt.getRepositoryId() + GenericsRepository.SPLIT_CHAR + mutableRepositoryItemExt.getClass().getCanonicalName(), mutableRepositoryItemExt);
		}
	    }
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
	Set result = null;
	if (getRepository().isChangeAware()) {
	    result = new ChangeAwareSet(set, this, itemDescriptorName);
	} else {
	    result = set;
	}
	return result;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected Map wrapMap(Map<String, RepositoryItem> in, String repositryId, String propertyName, Class clazz) {
	Map<String, RepositoryItem> map = new HashMap<String, RepositoryItem>();
	String itemDescriptorName = "";
	Set<String> keySet = in.keySet();
	try {
	    itemDescriptorName = this.getItemDescriptor().getItemDescriptorName();
	    for (String key : keySet) {
		RepositoryItem repositoryItem = map.get(key);
		MutableRepositoryItemExt mutableRepositoryItemExt = getRepository().getItemCache().get(repositoryItem.getRepositoryId() + clazz.getCanonicalName());

		if (mutableRepositoryItemExt != null) {
		    map.put(key, mutableRepositoryItemExt);
		} else {
		    mutableRepositoryItemExt = ConstructorUtils.invokeExactConstructor(clazz, null);
		    mutableRepositoryItemExt.setDelegate(repositoryItem);
		    mutableRepositoryItemExt.setRepositoryId(repositoryItem.getRepositoryId());
		    map.put(key, mutableRepositoryItemExt);
		    getRepository().getItemCache().put(mutableRepositoryItemExt.getRepositoryId() + GenericsRepository.SPLIT_CHAR + mutableRepositoryItemExt.getClass().getCanonicalName(), mutableRepositoryItemExt);
		}
	    }
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}

	Map result = null;
	if (getRepository().isChangeAware()) {
	    result = new ChangeAwareMap(map, this, itemDescriptorName);
	} else {
	    result = map;
	}
	return result;
    }

    @SuppressWarnings({ "rawtypes" })
    protected MutableRepositoryItemExt wrapItem(RepositoryItem repositoryItem, Class beanClass) {
	try {
	    MutableRepositoryItemExt mutableRepositoryItemExt = getRepository().findOrCreate((MutableRepositoryItem) repositoryItem, beanClass);
	    return mutableRepositoryItemExt;
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    @Override
    public boolean equals(Object o) {
	if (this == o) {
	    return true;
	}
	if (o == null || getClass() != o.getClass()) {
	    return false;
	}
	MutableRepositoryItemExt that = (MutableRepositoryItemExt) o;
	if (repositoryId != null && !repositoryId.equals(that.repositoryId)) {
	    return false;
	}

	return true;
    }

    protected abstract Set<String> getComplexProperties();

    protected boolean isPropertyComplex(String property) {
	Set<String> complexProperties = getComplexProperties();
	return complexProperties.contains(property);
    }

    @SuppressWarnings("rawtypes")
    protected List<String> getIds(Collection items) {
	List<String> result = new ArrayList<String>();
	if (items == null || items.isEmpty()) {
	    return result;
	}
	for (Object repositoryItem : items) {
	    result.add(((RepositoryItem) repositoryItem).getRepositoryId());
	}
	return result;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected <T> List<T> getListProperty(String propertyName, Class T) {
	List<T> x = (List<T>) getCachedData().get(propertyName);
	if (x != null) {
	    return x;
	}
	List<String> s = (List<String>) getCachedData().get("__" + propertyName);
	if (s != null) {
	    List<T> d = new ArrayList<T>();
	    for (String id : s) {
		try {
		    d.add((T) getRepository().getItem(id, T));
		} catch (RepositoryException e) {
		    getRepository().logError(e);
		}
	    }
	    x = new ChangeAwareList(d, this, getItemDisplayName(), (ApplicationLogging) getRepository());
	    getCachedData().put(propertyName, x);
	    return x;
	}
	x = (List<T>) wrapList((List<RepositoryItem>) getPropertyValue(propertyName), getRepositoryId(), propertyName, T);
	getCachedData().put(propertyName, x);
	if (MutableRepositoryItemExt.class.isAssignableFrom(T)) {
	    getCachedData().put("__" + propertyName, getIds(x));
	}
	getRepository().getItemCache().put(getRepositoryId() + GenericsRepository.SPLIT_CHAR + getClass().getCanonicalName(), this);
	putInRepositoryCache();
	return x;
    }

    @SuppressWarnings("rawtypes")
    protected void setListProperty(String propertyName, List in) {
	setPropertyValue(propertyName, in);
	getCachedData().put(propertyName, in);
	getCachedData().put("__" + propertyName, getIds(in));
	putInRepositoryCache();
    }

    private void putInRepositoryCache() {
	getRepository().getItemCache().put(getRepositoryId() + GenericsRepository.SPLIT_CHAR + getClass().getCanonicalName(), this);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected <T> Set<T> getSetProperty(String propertyName, Class T) {
	Set<T> x = (Set<T>) getCachedData().get(propertyName);
	if (x != null) {
	    return x;
	}
	List<String> s = (List<String>) getCachedData().get("__" + propertyName);
	if (s != null) {
	    Set<T> d = new HashSet<T>();
	    for (String id : s) {
		try {
		    d.add((T) getRepository().getItem(id, T));
		} catch (RepositoryException e) {
		    getRepository().logError(e);
		}
	    }
	    x = new ChangeAwareSet(d, this, getItemDisplayName());
	    getCachedData().put(propertyName, x);
	    return x;
	}
	x = (Set<T>) wrapSet((Set<RepositoryItem>) getPropertyValue(propertyName), getRepositoryId(), propertyName, T);
	getCachedData().put(propertyName, x);
	getCachedData().put("__" + propertyName, getIds(x));
	putInRepositoryCache();
	return x;
    }

    @SuppressWarnings("rawtypes")
    protected void setSetProperty(String propertyName, Set in) {
	setPropertyValue(propertyName, in);
	getCachedData().put(propertyName, in);
	getCachedData().put("__" + propertyName, getIds(in));
	putInRepositoryCache();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected <T> T getSimpleProperty(String propertyName, Class T) {
	T result = (T) getCachedData().get(propertyName);
	if (result != null) {
	    return result;
	} else {
	    result = (T) getPropertyValue(propertyName);
	    getCachedData().put(propertyName, result);
	}
	putInRepositoryCache();
	return result;
    }

    protected void setSimpleProperty(String propertyName, Object in) {
	setPropertyValue(propertyName, in);
	getCachedData().put(propertyName, in);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected <T> T getSingleRepositoryProperty(String propertyName, Class T) {
	T result = (T) getCachedData().get(propertyName);
	if (result != null) {
	    return result;
	} else {
	    result = (T) getPropertyValue(propertyName);
	    getCachedData().put(propertyName, result);
	    getCachedData().put("__" + propertyName, ((RepositoryItem) result).getRepositoryId());
	}
	putInRepositoryCache();
	return result;
    }

    protected void setSingleRepositoryProperty(String propertyName, Object in) {
	setPropertyValue(propertyName, in);
	getCachedData().put(propertyName, in);
	getCachedData().put("__" + propertyName, ((RepositoryItem) in).getRepositoryId());
	putInRepositoryCache();
    }

    public Map<String, Object> simplePropertiesCachedData() {
	Map<String, Object> result = new HashMap<String, Object>(getCachedData());

	Iterator<Entry<String, Object>> it = result.entrySet().iterator();
	while (it.hasNext()) {
	    Entry<String, Object> item = it.next();
	    if (isPropertyComplex(item.getKey())) {
		it.remove();
	    }
	}

	return result;
    }

}
