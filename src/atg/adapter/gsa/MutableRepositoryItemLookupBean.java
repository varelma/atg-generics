package atg.adapter.gsa;

import java.io.Serializable;

 
public  class MutableRepositoryItemLookupBean implements  Serializable {
 
 
    private static final long serialVersionUID = -4634456615199160836L;
    private String className;
    private String repositoryId;
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public String getRepositoryId() {
        return repositoryId;
    }
    public void setRepositoryId(String repositoryId) {
        this.repositoryId = repositoryId;
    }

    public MutableRepositoryItemLookupBean(){}

    public MutableRepositoryItemLookupBean(String className, String repositoryId){
	this.className = className;
	this.repositoryId = repositoryId;
    }
    
}
