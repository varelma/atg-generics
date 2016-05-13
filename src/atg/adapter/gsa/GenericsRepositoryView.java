/*   
Copyright 2011 Jon Pallas

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package atg.adapter.gsa;

import java.lang.reflect.Array;
import java.util.Map;

import atg.repository.MutableRepositoryItem;
import atg.repository.Query;
import atg.repository.QueryBuilder;
import atg.repository.QueryOptions;
import atg.repository.RepositoryException;
import atg.repository.RepositoryItem;
import atg.repository.RepositoryItemDescriptor;
import atg.repository.RepositoryView;
import atg.repository.SortDirectives;

/**
 * @author Jon Pallas
 */
public class GenericsRepositoryView implements RepositoryView {
    private RepositoryView deligate;
    private GenericsRepository genericsRepository;

    public GenericsRepositoryView(RepositoryView deligate, GenericsRepository genericsRepository) {
	this.deligate = deligate;
	this.genericsRepository = genericsRepository;
    }

    /**
     * @param arg0
     * @return
     * @throws RepositoryException
     * @see atg.repository.RepositoryView#executeCountQuery(atg.repository.Query)
     */
    public int executeCountQuery(Query arg0) throws RepositoryException {
	return deligate.executeCountQuery(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @return
     * @throws RepositoryException
     * @see atg.repository.RepositoryView#executeQuery(atg.repository.Query, int, int, atg.repository.SortDirectives)
     */
    public RepositoryItem[] executeQuery(Query arg0, int arg1, int arg2, SortDirectives arg3) throws RepositoryException {
	return deligate.executeQuery(arg0, arg1, arg2, arg3);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <T extends MutableRepositoryItemExt> T[] executeQuery(Query arg0, int arg1, int arg2, SortDirectives arg3, Class<T> T) throws RepositoryException {
	String key = this.getViewName() + arg0 + arg1 + arg2 + arg3;
	Map cache = genericsRepository.getQueryCache();
	T[] result = (T[]) cache.get(key);
	if (result != null) {
	    return result;
	}
	result = convert(deligate.executeQuery(arg0, arg1, arg2, arg3), T);
	cache.put(key, result);
	genericsRepository.putAllToItemCache(result);
	return result;
    }

    /**
     * @param arg0
     * @param arg1
     * @param arg2
     * @return
     * @throws RepositoryException
     * @see atg.repository.RepositoryView#executeQuery(atg.repository.Query, int, int)
     */
    public RepositoryItem[] executeQuery(Query arg0, int arg1, int arg2) throws RepositoryException {
	return deligate.executeQuery(arg0, arg1, arg2);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <T extends MutableRepositoryItemExt> T[] executeQuery(Query arg0, int arg1, int arg2, Class<? extends MutableRepositoryItemExt> T) throws RepositoryException {
	String key = this.getViewName() + arg0 + arg1 + arg2;
	Map cache = genericsRepository.getQueryCache();
	T[] result = (T[]) cache.get(key);
	if (result != null) {
	    return result;
	}
	result = convert(deligate.executeQuery(arg0, arg1, arg2), T);
	cache.put(key, result);
	genericsRepository.putAllToItemCache(result);
	return result;
    }

    /**
     * @param arg0
     * @param arg1
     * @param arg2
     * @return
     * @throws RepositoryException
     * @see atg.repository.RepositoryView#executeQuery(atg.repository.Query, int, atg.repository.SortDirectives)
     */
    public RepositoryItem[] executeQuery(Query arg0, int arg1, SortDirectives arg2) throws RepositoryException {
	return deligate.executeQuery(arg0, arg1, arg2);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <T extends MutableRepositoryItemExt> T[] executeQuery(Query arg0, int arg1, SortDirectives arg3, Class<? extends MutableRepositoryItemExt> T) throws RepositoryException {
	String key = this.getViewName() + arg0 + arg1 + arg3;
	Map cache = genericsRepository.getQueryCache();
	T[] result = (T[]) cache.get(key);
	if (result != null) {
	    return result;
	}
	result = convert(deligate.executeQuery(arg0, arg1, arg3), T);
	cache.put(key, result);
	genericsRepository.putAllToItemCache(result);
	return result;
    }

    /**
     * @param arg0
     * @param arg1
     * @return
     * @throws RepositoryException
     * @see atg.repository.RepositoryView#executeQuery(atg.repository.Query, int)
     */
    public RepositoryItem[] executeQuery(Query arg0, int arg1) throws RepositoryException {
	return deligate.executeQuery(arg0, arg1);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <T extends MutableRepositoryItemExt> T[] executeQuery(Query arg0, int arg1, Class<? extends MutableRepositoryItemExt> T) throws RepositoryException {
	String key = this.getViewName() + arg0 + arg1;
	Map cache = genericsRepository.getQueryCache();
	T[] result = (T[]) cache.get(key);
	if (result != null) {
	    return result;
	}
	result = convert(deligate.executeQuery(arg0, arg1), T);
	cache.put(key, result);
	genericsRepository.putAllToItemCache(result);
	return result;
    }

    /**
     * @param arg0
     * @param arg1
     * @return
     * @throws RepositoryException
     * @see atg.repository.RepositoryView#executeQuery(atg.repository.Query, atg.repository.QueryOptions)
     */
    public RepositoryItem[] executeQuery(Query arg0, QueryOptions arg1) throws RepositoryException {
	return deligate.executeQuery(arg0, arg1);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <T extends MutableRepositoryItemExt> T[] executeQuery(Query arg0, QueryOptions arg1, Class<? extends MutableRepositoryItemExt> T) throws RepositoryException {
	String key = this.getViewName() + arg0 + arg1;
	Map cache = genericsRepository.getQueryCache();
	T[] result = (T[]) cache.get(key);
	if (result != null) {
	    return result;
	}
	result = convert(deligate.executeQuery(arg0, arg1), T);
	cache.put(key, result);
	genericsRepository.putAllToItemCache(result);
	return result;
    }

    /**
     * @param arg0
     * @param arg1
     * @return
     * @throws RepositoryException
     * @see atg.repository.RepositoryView#executeQuery(atg.repository.Query, atg.repository.SortDirectives)
     */
    public RepositoryItem[] executeQuery(Query arg0, SortDirectives arg1) throws RepositoryException {
	return deligate.executeQuery(arg0, arg1);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <T extends MutableRepositoryItemExt> T[] executeQuery(Query arg0, SortDirectives arg1, Class<? extends MutableRepositoryItemExt> T) throws RepositoryException {
	String key = this.getViewName() + arg0 + arg1;
	Map cache = genericsRepository.getQueryCache();
	T[] result = (T[]) cache.get(key);
	if (result != null) {
	    return result;
	}
	result = convert(deligate.executeQuery(arg0, arg1), T);
	cache.put(key, result);
	genericsRepository.putAllToItemCache(result);
	return result;
    }

    /**
     * @param arg0
     * @return
     * @throws RepositoryException
     * @see atg.repository.RepositoryView#executeQuery(atg.repository.Query)
     */
    public RepositoryItem[] executeQuery(Query arg0) throws RepositoryException {
	return deligate.executeQuery(arg0);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <T extends MutableRepositoryItemExt> T[] executeQuery(Query arg0, Class<? extends MutableRepositoryItemExt> T) throws RepositoryException {
	String key = this.getViewName() + arg0;
	Map cache = genericsRepository.getQueryCache();
	T[] result = (T[]) cache.get(key);
	if (result != null) {
	    return result;
	}
	result = convert(deligate.executeQuery(arg0), T);
	cache.put(key, result);
	genericsRepository.putAllToItemCache(result);
	return result;
    }

    /**
     * @return
     * @throws RepositoryException
     * @see atg.repository.RepositoryView#getItemDescriptor()
     */
    public RepositoryItemDescriptor getItemDescriptor() throws RepositoryException {
	return deligate.getItemDescriptor();
    }

    /**
     * @return
     * @see atg.repository.RepositoryView#getQueryBuilder()
     */
    public QueryBuilder getQueryBuilder() {
	return deligate.getQueryBuilder();
    }

    /**
     * @return
     * @see atg.repository.RepositoryView#getViewName()
     */
    public String getViewName() {
	return deligate.getViewName();
    }

    @SuppressWarnings("unchecked")
    private <T extends MutableRepositoryItemExt> T[] convert(RepositoryItem[] in, Class<? extends MutableRepositoryItemExt> T) {
	if (in == null) {
	    return null;
	}
	try {
	    T[] out = (T[]) Array.newInstance(T, in.length);
	    for (int i = 0; i < in.length; i++) {
		out[i] = (T) genericsRepository.findOrCreate((MutableRepositoryItem) in[i], T);
	    }
	    return out;
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

}
