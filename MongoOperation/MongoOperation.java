package MongoOperation;

import Entities.Collection;
import Entities.Entity;
import MongoOperation.Crud.Delete;
import MongoOperation.Crud.Find;
import MongoOperation.Crud.Insert;
import MongoOperation.Crud.Update;

public class MongoOperation {
    public static <T extends Entity> Find<T> find(Class<T> type) {
        return new Find<>(getCollectionName(type), type);
    }

    public static <T extends Entity> Update<T> update(Class<T> type) {
        return new Update<>(getCollectionName(type));
    }

    public static <T extends Entity> Insert<T> insert(Class<T> type) {
        return new Insert<>(getCollectionName(type));
    }

    public static <T extends Entity> Delete<T> delete(Class<T> type) {
        return new Delete<>(getCollectionName(type));
    }

    private static <T extends Entity> String getCollectionName(Class<T> type) {
        return type.getAnnotation(Collection.class).collectionName();
    }
}
