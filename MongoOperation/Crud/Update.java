package MongoOperation.Crud;

import Dal.DBConnection;
import Entities.Entity;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

public class Update<T extends Entity> extends FilterCrud<Delete<T>> {
    private BasicDBObject setQuery = new BasicDBObject();
    private String collectionName;

    public Update(String collectionName) {
        this.collectionName = collectionName;
    }

    private DBCollection getCollection() {
        return DBConnection.getInstance().db.getCollection(this.collectionName);
    }

    public Update<T> set(String key, Object value) {
        this.setQuery.append(key, value);
        return this;
    }

    public void one() {
        this.getCollection().update(super.getFilterQuery(), new BasicDBObject("$set", this.setQuery));
    }

    public void many() {
        this.getCollection().updateMulti(super.getFilterQuery(), new BasicDBObject("$set", this.setQuery));
    }
}
