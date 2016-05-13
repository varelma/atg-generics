package atg.adapter.gsa;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import org.apache.commons.beanutils.ConstructorUtils;
import org.mapdb.Serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MutableRepositoryItemExtMapDBSerializer implements   Serializer<MutableRepositoryItemExt>, Serializable {

    private static final long serialVersionUID = -4081000041934935901L;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public MutableRepositoryItemExt deserialize(DataInput in, int available) throws IOException {
	try {
	    System.out.println("MutableRepositoryItemExtMapDBSerializer deserialize");
	    String gsonString = in.readUTF();
	    Gson gson = new GsonBuilder().create();
	    Map<String, Object> cache = gson.fromJson(gsonString, Map.class);

	    String javaClassName = (String) cache.get("__class");
	    String repositoryId = (String) cache.get("__repositoryId");
	  
	    Class beanClass = Class.forName(javaClassName);
	    MutableRepositoryItemExt mutableRepositoryItemExt = ConstructorUtils.invokeExactConstructor(beanClass, null);
	    mutableRepositoryItemExt.setRepositoryId(repositoryId);
	    mutableRepositoryItemExt.setCachedData(cache);

	    return mutableRepositoryItemExt;
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    @Override
    public int fixedSize() {
	return -1;
    }  

    @Override
    public void serialize(DataOutput out, MutableRepositoryItemExt item) throws IOException {
	System.out.print("MutableRepositoryItemExtMapDBSerializer serialize");		
	Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
	Map<String, Object> cache = item.simplePropertiesCachedData();
	 
	cache.put("__class", item.getClass().getCanonicalName());
	cache.put("__repositoryId", item.getRepositoryId());

	out.writeUTF(gson.toJson(cache));
	System.out.println(gson.toJson(cache));		
	
    }

}
