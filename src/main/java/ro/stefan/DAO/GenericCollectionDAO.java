package ro.stefan.DAO;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import ro.stefan.mongoStuff.MongoStandardCollections;

import java.util.List;
import java.util.Set;

public class GenericCollectionDAO {

    @Autowired
    DB db;

    public List<DBObject> getAll(String collection){
        return db.getCollection(collection).find().toArray();
    }

    public String getAllJson(String collection){
        DBCursor cursor = db.getCollection(collection).find();
        List<DBObject> objects = cursor.toArray();
        cursor.close();

        return JSON.serialize(objects);
    }

    public String getAllKeysJson(String collection){
        BasicDBObject collName = new BasicDBObject("_id",collection);
        DBObject collNameKeys = db.getCollection(MongoStandardCollections.getListOfCollectionsKeys()).findOne(collName);
        return JSON.serialize(collNameKeys.get("keys"));
    }


}
