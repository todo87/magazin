package ro.stefan.DAO;

import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import org.springframework.beans.factory.annotation.Autowired;
import ro.stefan.mongoStuff.MongoStandardCollections;

public class UsersAdminDAO {

    @Autowired
    DB db;

    public DBCursor getAll(){
       return db.getCollection(MongoStandardCollections.getAdminUsers()).find();
    }

    public Cursor UserCursor(String user){
        BasicDBObject basicUser = new BasicDBObject("_id",user);
        return db.getCollection(MongoStandardCollections.getAdminUsers()).find(basicUser).limit(1);
    }
}
