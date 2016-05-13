package atg.adapter.gsa;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Map;

import org.apache.commons.beanutils.ConstructorUtils;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;

public class MutableRepositoryItemExtArrayHazelcastSerializer implements StreamSerializer<MutableRepositoryItemExt[]>, Serializable {

    private static final long serialVersionUID = -4081000041934935901L;

    private Map<String, MutableRepositoryItemExt> itemCache;

    public Map<String, MutableRepositoryItemExt> getItemCache() {
	return itemCache;
    }

    public void setItemCache(Map<String, MutableRepositoryItemExt> itemCache) {
	this.itemCache = itemCache;
    }


    @Override
    public void destroy() {
	// TODO Auto-generated method stub
	
    }

    @Override
    public int getTypeId() {
	// TODO Auto-generated method stub
	return 2;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public MutableRepositoryItemExt[] read(ObjectDataInput in) throws IOException {
	MutableRepositoryItemExt[] result;
	try {
	    //  System.out.println("MutableRepositoryItemExtArraySerializer deserialize");
	    String ids = in.readUTF();
	    String[] mapIds = ids.split(",");
	    result = new MutableRepositoryItemExt[mapIds.length];
	    for (int i = 0; i < mapIds.length; i++) {
		if (i == 0) {
		    String javaClassName = mapIds[0].split(GenericsRepository.SPLIT_CHAR)[1];
		    Class beanClass = Class.forName(javaClassName);
		    result = (MutableRepositoryItemExt[]) Array.newInstance(beanClass, mapIds.length);
		}
		String mapId = mapIds[i];
		MutableRepositoryItemExt item = itemCache.get(mapId);
		if (item != null) {
		    result[i] = item;
		} else {
		    String[] parts = mapId.split(GenericsRepository.SPLIT_CHAR);
		    String id = parts[0];
		    String javaClassName = parts[1];

		    Class beanClass = Class.forName(javaClassName);
		    MutableRepositoryItemExt mutableRepositoryItemExt = ConstructorUtils.invokeExactConstructor(beanClass, null);
		    mutableRepositoryItemExt.setRepositoryId(id);
		    result[i] = mutableRepositoryItemExt;
		}
	    }
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
	return result;
    }

    @Override
    public void write(ObjectDataOutput out, MutableRepositoryItemExt[] items) throws IOException {
	StringBuffer sb = new StringBuffer();
	for (int i = 0; i < items.length; i++) {
	    sb.append(items[i].getRepositoryId()).append(GenericsRepository.SPLIT_CHAR).append(items[i].getClass().getCanonicalName());
	    if (i != items.length) {
		sb.append(',');
	    }
	}
	out.writeUTF(sb.toString());
 
    }

}
