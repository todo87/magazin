package ro.stefan.DAO;

import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GenericCollectionDAO {

    @Autowired
    DB db;

    public DBCursor getAll(String collection){
        return db.getCollection(collection).find();
    }

    public String getAllJson(String collection){
        DBCursor cursor = db.getCollection(collection).find();
        List<DBObject> objects = cursor.toArray();
        cursor.close();

        return JSON.serialize(objects);
    }


}
