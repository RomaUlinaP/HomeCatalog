package controller;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;

import model.Fasilitas;
import model.Pemilik;
import model.Rumah;
import model.Ukuran;

public class MongoDBUtils {	
	MongoDatabase database;
	MongoCollection<Pemilik> collection;	
	MongoCollection<Rumah> RumahCollection;
	
	public MongoDBUtils() {
		// Creating Credentials 
		MongoCredential credential; 
		credential = MongoCredential.createCredential("sampleUser", "myDb", 
				"password".toCharArray()); 
		System.out.println("Connected to the database successfully");  
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));		
		 MongoClient mongo = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
		// Accessing the database 
		database = mongo.getDatabase("myDb"); 
		database = database.withCodecRegistry(pojoCodecRegistry);
		System.out.println("Credentials ::"+ credential);
		collection = database.getCollection("pemilikCollection", Pemilik.class);
		RumahCollection = database.getCollection("rumahCollection", Rumah.class);
	}
	
	public ArrayList<Pemilik> getPemilik() throws IOException {		
		ArrayList<Pemilik> resultList = new ArrayList<>();
		FindIterable<Pemilik> pemilikIterable = collection.find();		
		for (Pemilik pemilik : pemilikIterable) {
			System.out.println(pemilik);
			resultList.add(pemilik);
		}		
		return resultList;
	}
	
	public ArrayList<Rumah> getMotor() throws IOException {		
		ArrayList<Rumah> resultList = new ArrayList<>();
		FindIterable<Rumah> rumahIterable = RumahCollection.find();		
		for (Rumah rumah : rumahIterable) {
			System.out.println(rumah);
			resultList.add(rumah);
		}		
		return resultList;
	}
	//pemilik meng-insert data rumah
	public boolean inserting() {
		return true;
	}
	//pemilik update status rumah (terjual/belum terjual)
	public boolean updateData() {
		return true;
	}
	//sistem mendelete otomatis rumah yang terjual/pemilik menghapus data
	public boolean delete() {
		return true;
	}
}
