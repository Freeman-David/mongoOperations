package MongoOperation.Crud;

import Dal.DBConnection;
import Entities.Entity;
import com.mongodb.DBCollection;

public class Delete<T extends Entity> extends FilterCrud<Delete<T>> {
    private String collectionName;

    public Delete(String collectionName) {
        this.collectionName = collectionName;
    }

    private DBCollection getCollection() {
        return DBConnection.getInstance().db.getCollection(this.collectionName);
    }

    public void execute() {
        this.getCollection().remove(super.getFilterQuery());
    }
}
