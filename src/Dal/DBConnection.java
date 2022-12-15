package Dal;

import com.mongodb.*;
import java.net.UnknownHostException;
import java.util.*;

// Singleton object to connect your DB.
// You can get only instance becouse we want the connection
// to happens only once.
public class DBConnection {
    private final String IP_ADDRESS = ""; // Set here your DB IP.
    private final int PORT = 27017;

    private static DBConnection instance;
    public DB db;

    static {
        try {
            instance = new DBConnection();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private DBConnection() throws UnknownHostException {
        final String user = ""; // Set here DB user name.
        final String cluster = ""; // Set here cluster name.
        final String password = ""; // Set here DB pass.
        final String dbName = ""; // Set here DB name.

        MongoCredential credential = MongoCredential.createCredential(user,
                cluster, password.toCharArray());
        MongoClient mongoClient = new MongoClient(new ServerAddress(this.IP_ADDRESS, this.PORT),
                Collections.singletonList(credential));

        this.db = mongoClient.getDB(dbName);
    }

    public static DBConnection getInstance() {
        return instance;
    }
}