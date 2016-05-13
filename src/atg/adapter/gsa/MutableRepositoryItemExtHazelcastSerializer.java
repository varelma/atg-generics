package atg.adapter.gsa;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import org.apache.commons.beanutils.ConstructorUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;

public class MutableRepositoryItemExtHazelcastSerializer implements StreamSerializer<MutableRepositoryItemExt>,  Serializable {

    private static final long serialVersionUID = -408100041934935901L;
 

    @Override
    public void destroy() {	
    }

    @Override
    public int getTypeId() {
	return 1;
    }
     

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public MutableRepositoryItemExt read(ObjectDataInput in) throws IOException {
	try {
	    
	    String gsonString = in.readUTF();  
	    System.out.println("MutableRepositoryItemExtHazelcastSerializer deserialize " + System.currentTimeMillis() + " "  + gsonString);
		  
	    Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
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
    public void write(ObjectDataOutput out, MutableRepositoryItemExt item) throws IOException {
	System.out.print("MutableRepositoryItemExtHazelcastSerializer serialize");		
 	Map<String, Object> cache = item.simplePropertiesCachedData();
 	Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
	cache.put("__class", item.getClass().getCanonicalName());
	cache.put("__repositoryId", item.getRepositoryId());

	out.writeUTF(gson.toJson(cache));	
	//System.out.println(gson.toJson(cache));		

    }

}
