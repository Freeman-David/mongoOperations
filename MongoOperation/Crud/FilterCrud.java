package MongoOperation.Crud;

import com.mongodb.BasicDBObject;

public abstract class FilterCrud<T> {
    private BasicDBObject filterQuery = new BasicDBObject();

    @SuppressWarnings("unchecked")
    public T filter(BasicDBObject dbObject) {
        this.filterQuery.putAll(dbObject.toMap());
        return ((T)this);
    }

    public BasicDBObject getFilterQuery() {
        return this.filterQuery;
    }
}