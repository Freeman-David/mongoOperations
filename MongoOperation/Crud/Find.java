package MongoOperation.Crud;

import Dal.DBConnection;
import Entities.Entity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.io.IOException;
import java.util.List;

public class Find<T extends Entity> extends FilterCrud<Find<T>> {
    private String collectionName;
    private BasicDBObject projectQuery = new BasicDBObject();
    private BasicDBObject sortQuery = new BasicDBObject();
    final Class<T> type;

    public Find(String collectionName, Class<T> type) {
        this.collectionName = collectionName;
        this.type = type;
    }

    private DBCollection getCollection() {
        return DBConnection.getInstance().db.getCollection(this.collectionName);
    }

    public Find<T> project(String... fields) {
        this.projectQuery.putAll(this.getSplitFields(fields, 1).toMap());
        return this;
    }

    public Find<T> sort(String... fields) {
        this.sortQuery.putAll(this.getSplitFields(fields, 1).toMap());
        return this;
    }

    public Find<T> sortDesc(String... fields) {
        this.sortQuery.putAll(this.getSplitFields(fields, -1).toMap());
        return this;
    }

    private BasicDBObject getSplitFields(String[] fields, int value) {
        BasicDBObject document = new BasicDBObject();

        for (String field : fields) document.append(field, value);

        return document;
    }

    public T one() {
        ObjectMapper mapper = new ObjectMapper();
        DBObject document = this.getCollection().findOne(super.getFilterQuery(),
                this.projectQuery, this.sortQuery);

        return mapper.convertValue(document, type);
    }

    public List<T> many() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        DBCursor cursor = this.getCollection().find(super.getFilterQuery(),
                this.projectQuery).sort(this.sortQuery);

        return (mapper.readValue(cursor.toArray().toString(),
                mapper.getTypeFactory().constructCollectionType(List.class, type)));
    }
  }
