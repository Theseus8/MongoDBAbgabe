import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class main {
    public static void main( String[] args ) {

        String uri = "mongodb://127.0.0.1:27017";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection<Document> collection = database.getCollection("products");

            collection.find().forEach(document -> {
                System.out.println(document.toJson());
            });
            
            collection.find().forEach(document -> {
                System.out.println(document);
            });
        }
    }
}