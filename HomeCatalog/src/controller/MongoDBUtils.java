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

import model.Motor;
import model.Student;

public class MongoDBUtils {	
	MongoDatabase database;
	MongoCollection<Student> collection;	
	
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
		collection = database.getCollection("studentsCollection", Student.class);
	}

	public ArrayList<Student> getStudent() throws IOException {		
		ArrayList<Student> resultList = new ArrayList<>();
		FindIterable<Student> studentIterable = collection.find();		
		for (Student student : studentIterable) {
			System.out.println(student);
			resultList.add(student);
		}		
		return resultList;
	}
	
	public boolean insertData(String name, String city, String designation, int salary) {
		String id = new ObjectId().toString();
		try {	
			Student student = new Student(name, city, designation, salary, null, null);	
			student.setKode(id);
			collection.insertOne(student);			
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	
	public boolean insertDataNewDataList(String name, String city, String designation, int salary, String newList) {
		String id = new ObjectId().toString();
		try {	
			List<String> listNew = Arrays.asList(newList.split(","));
			Student student = new Student(name, city, designation, salary, listNew, null);	
			student.setKode(id);
			collection.insertOne(student);			
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	
	public boolean insertDataNewObjectList(String name, String city, String designation, int salary, String newList, List<Motor> objectList) {
		String id = new ObjectId().toString();
		try {	
			List<String> listNew = Arrays.asList(newList.split(","));
			Student student = new Student(name, city, designation, salary, listNew, objectList);	
			student.setKode(id);
			collection.insertOne(student);			
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	
	public boolean updateData(String row, String name, String city, String designation, int salary) {		
		return true;
	}
		
	public boolean delete(String row) {
//		DeleteResult del = collection.deleteOne(eq("_id", row));
		DeleteResult del = collection.deleteOne(eq("kode", row));
		System.out.println("del = "+del.getDeletedCount());
		return true;
	}
	
}
