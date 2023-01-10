package MongoOperation.Crud;

import Dal.DBConnection;
import Entities.Entity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Insert<T extends Entity> {
    private String collectionName;

    public Insert(String collectionName) {
        this.collectionName = collectionName;
    }

    public void execute(T[] entities) {
        ObjectMapper mapper = new ObjectMapper();
        DBObject dbObject = new BasicDBObject();

        for (T entity : entities) {
            BasicDBObject convertedField = mapper.convertValue(entity, BasicDBObject.class);
            dbObject.putAll(convertedField.toMap());
        }

        DBConnection.getInstance().db.getCollection(this.collectionName).insert(dbObject);
    }
}
