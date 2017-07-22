package fg;

import org.bson.types.ObjectId;
import org.jboss.logging.Property;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Version;

public abstract class BaseEntity {
	 
    @Id
    protected ObjectId id;
 
    @Version
    private Long version;
 
    public BaseEntity() {
        super();
    }
 
    public ObjectId getId() {
        return id;
    }
 
    public void setId(ObjectId id) {
        this.id = id;
    }
 
    public Long getVersion() {
        return version;
    }
 
    public void setVersion(Long version) {
        this.version = version;
    }
 
}
