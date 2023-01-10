package MongoOperation;

import com.mongodb.BasicDBObject;

public class Query {
    public static BasicDBObject eq(String key, Object value) {
        return new BasicDBObject(key, value);
    }

    public static BasicDBObject gte(String key, Object value) {
        return new BasicDBObject(key, new BasicDBObject("$gte", value));
    }

    public static BasicDBObject gt(String key, Object value) {
        return new BasicDBObject(key, new BasicDBObject("$gt", value));
    }

    public static BasicDBObject lte(String key, Object value) {
        return new BasicDBObject(key, new BasicDBObject("$lte", value));
    }

    public static BasicDBObject lt(String key, Object value) {
        return new BasicDBObject(key, new BasicDBObject("$lt", value));
    }

    public static BasicDBObject and(BasicDBObject... dbObjects) {
        return new BasicDBObject("$and", dbObjects);
    }

    public static BasicDBObject or(BasicDBObject... dbObjects) {
        return new BasicDBObject("$or", dbObjects);
    }
}
