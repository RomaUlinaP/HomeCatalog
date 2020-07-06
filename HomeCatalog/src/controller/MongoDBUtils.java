package controller;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.DBRef;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;

import java.io.File;
import java.io.FileInputStream;
 
import org.bson.types.Binary;
import com.mongodb.DBCollection;

import model.Fasilitas;
import model.Pemilik;
import model.Rumah;
import model.Luas;

public class MongoDBUtils {	
	MongoDatabase database;
	MongoCollection<Pemilik> PemilikCollection;	
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
		PemilikCollection = database.getCollection("pemilikCollection", Pemilik.class);
		RumahCollection = database.getCollection("rumahCollection", Rumah.class);
	}
	
	public ArrayList<Pemilik> getPemilik() throws IOException {		
		ArrayList<Pemilik> resultList = new ArrayList<>();
		FindIterable<Pemilik> pemilikIterable = PemilikCollection.find();		
		for (Pemilik pemilik : pemilikIterable) {
			System.out.println(pemilik);
			resultList.add(pemilik);
		}		
		return resultList;
	}
	
	public ArrayList<Pemilik> getPemilikbyid(String id) throws IOException {	
		ArrayList<Pemilik> resultList = new ArrayList<>();
		ArrayList<Pemilik> p = getPemilik();
		for (Pemilik pemilik : p) {
	        if (pemilik.getId().equals(id)) {
	        	resultList.add(pemilik);
	        	return resultList;
	        }
	    }
		return resultList;
	}
	
	public List<Rumah> getRumahbyFilter1(String kecamatan, int HargaMin, int HargaMax) throws IOException {	
		List<Rumah> resultList = RumahCollection.find(Filters.and(
				Filters.and(
						Filters.eq("kecamatan",kecamatan),
						Filters.gte("harga", HargaMin),
						Filters.lte("harga", HargaMax)),
				Filters.or(
						Filters.eq("kecamatan",kecamatan),
						Filters.and(
						Filters.gte("harga", HargaMin),
						Filters.lte("harga", HargaMax))))).into(new ArrayList<Rumah>());
		return resultList;
	}
	
	public List<Rumah> getRumahbyFilter2(int HargaMin, int HargaMax) throws IOException {	
		List<Rumah> resultList = RumahCollection.find(Filters.and(
				Filters.gte("harga", HargaMin),
				Filters.lte("harga", HargaMax))).into(new ArrayList<Rumah>());
		return resultList;
	}
	
	public List<Rumah> getRumahbyFilter2Fix1(int LuasTanahMin, int LuasTanahMax, int LuasBangunanMin,
			int LuasBangunanMax, int HargaMin, int HargaMax, int KamarTidur,int KamarMandi){
		ArrayList<Rumah> resultList = new ArrayList<>();
		if(KamarTidur==0) {
			if(KamarMandi==0) {
				resultList = RumahCollection.find(Filters.and(
						Filters.gte("harga", HargaMin),
						Filters.lte("harga", HargaMax),
						Filters.gte("luas.luasTanah", LuasTanahMin),
						Filters.lte("luas.luasTanah", LuasTanahMax),
						Filters.and(
							Filters.gte("luas.luasBangunan", LuasBangunanMin),
							Filters.lte("luas.luasBangunan", LuasBangunanMax),
						Filters.gte("fasilitas.kamarTidur", KamarTidur),
						Filters.gte("fasilitas.kamarMandi", KamarMandi)))).into(new ArrayList<Rumah>());
			}else {
				resultList = RumahCollection.find(Filters.and(
						Filters.gte("harga", HargaMin),
						Filters.lte("harga", HargaMax),
						Filters.gte("luas.luasTanah", LuasTanahMin),
						Filters.lte("luas.luasTanah", LuasTanahMax),
						Filters.and(
							Filters.gte("luas.luasBangunan", LuasBangunanMin),
							Filters.lte("luas.luasBangunan", LuasBangunanMax),
						Filters.gte("fasilitas.kamarTidur", KamarTidur),
						Filters.eq("fasilitas.kamarMandi", KamarMandi)))).into(new ArrayList<Rumah>());
			}
		}else {
			if(KamarMandi==0) {
				resultList = RumahCollection.find(Filters.and(
						Filters.gte("harga", HargaMin),
						Filters.lte("harga", HargaMax),
						Filters.gte("luas.luasTanah", LuasTanahMin),
						Filters.lte("luas.luasTanah", LuasTanahMax),
						Filters.and(
							Filters.gte("luas.luasBangunan", LuasBangunanMin),
							Filters.lte("luas.luasBangunan", LuasBangunanMax),
						Filters.eq("fasilitas.kamarTidur", KamarTidur),
						Filters.gte("fasilitas.kamarMandi", KamarMandi)))).into(new ArrayList<Rumah>());
			}else {
				resultList = RumahCollection.find(Filters.and(
						Filters.gte("harga", HargaMin),
						Filters.lte("harga", HargaMax),
						Filters.gte("luas.luasTanah", LuasTanahMin),
						Filters.lte("luas.luasTanah", LuasTanahMax),
						Filters.and(
							Filters.gte("luas.luasBangunan", LuasBangunanMin),
							Filters.lte("luas.luasBangunan", LuasBangunanMax),
					Filters.eq("fasilitas.kamarTidur", KamarTidur),
					Filters.eq("fasilitas.kamarMandi", KamarMandi)))).into(new ArrayList<Rumah>());
			}
		}
		return resultList;
	}
	
	public List<Rumah> getRumahbyFilter2Fix2(int LuasTanahMin, int LuasTanahMax, int LuasBangunanMin, 
			int LuasBangunanMax, String Kecamatan, int HargaMin, int HargaMax, int KamarTidur, int KamarMandi){
		ArrayList<Rumah> resultList = new ArrayList<>();
		if(KamarTidur==0) {
			if(KamarMandi==0) {
				resultList = RumahCollection.find(Filters.and(
						Filters.eq("kecamatan",Kecamatan),
						Filters.gte("harga", HargaMin),
						Filters.lte("harga", HargaMax),
						Filters.gte("luas.luasTanah", LuasTanahMin),
						Filters.lte("luas.luasTanah", LuasTanahMax),
						Filters.and(
							Filters.gte("luas.luasBangunan", LuasBangunanMin),
							Filters.lte("luas.luasBangunan", LuasBangunanMax),
						Filters.gte("fasilitas.kamarTidur", KamarTidur),
						Filters.gte("fasilitas.kamarMandi", KamarMandi)))).into(new ArrayList<Rumah>());
			}else {
				resultList = RumahCollection.find(Filters.and(
						Filters.eq("kecamatan",Kecamatan),
						Filters.gte("harga", HargaMin),
						Filters.lte("harga", HargaMax),
						Filters.gte("luas.luasTanah", LuasTanahMin),
						Filters.lte("luas.luasTanah", LuasTanahMax),
						Filters.and(
							Filters.gte("luas.luasBangunan", LuasBangunanMin),
							Filters.lte("luas.luasBangunan", LuasBangunanMax),
						Filters.gte("fasilitas.kamarTidur", KamarTidur),
						Filters.eq("fasilitas.kamarMandi", KamarMandi)))).into(new ArrayList<Rumah>());
			}
		}else {
			if(KamarMandi==0) {
				resultList = RumahCollection.find(Filters.and(
						Filters.eq("kecamatan",Kecamatan),
						Filters.gte("harga", HargaMin),
						Filters.lte("harga", HargaMax),
						Filters.gte("luas.luasTanah", LuasTanahMin),
						Filters.lte("luas.luasTanah", LuasTanahMax),
						Filters.and(
							Filters.gte("luas.luasBangunan", LuasBangunanMin),
							Filters.lte("luas.luasBangunan", LuasBangunanMax),
						Filters.eq("fasilitas.kamarTidur", KamarTidur),
						Filters.gte("fasilitas.kamarMandi", KamarMandi)))).into(new ArrayList<Rumah>());
			}else {
				resultList = RumahCollection.find(Filters.and(
						Filters.eq("kecamatan",Kecamatan),
						Filters.gte("harga", HargaMin),
						Filters.lte("harga", HargaMax),
						Filters.gte("luas.luasTanah", LuasTanahMin),
						Filters.lte("luas.luasTanah", LuasTanahMax),
						Filters.and(
							Filters.gte("luas.luasBangunan", LuasBangunanMin),
							Filters.lte("luas.luasBangunan", LuasBangunanMax),
					Filters.eq("fasilitas.kamarTidur", KamarTidur),
					Filters.eq("fasilitas.kamarMandi", KamarMandi)))).into(new ArrayList<Rumah>());
			}
		}
		return resultList;
	}
	
	/*Sort Harga*/
	public List<Rumah> getRumahbyFilter3( int SortValue,int LuasTanahMin, int LuasTanahMax, int LuasBangunanMin, 
			int LuasBangunanMax, String Kecamatan, int HargaMin, int HargaMax, int KamarTidur, int KamarMandi) {
		ArrayList<Rumah> resultList = new ArrayList<>();
			if(KamarTidur==0) {
				if(KamarMandi==0) {
					FindIterable<Rumah> rumahIterable = RumahCollection.find(Filters.and(
							Filters.eq("kecamatan",Kecamatan),
							Filters.gte("harga", HargaMin),
							Filters.lte("harga", HargaMax),
							Filters.gte("luas.luasTanah", LuasTanahMin),
							Filters.lte("luas.luasTanah", LuasTanahMax),
							Filters.and(
								Filters.gte("luas.luasBangunan", LuasBangunanMin),
								Filters.lte("luas.luasBangunan", LuasBangunanMax),
							Filters.gte("fasilitas.kamarTidur", KamarTidur),
							Filters.gte("fasilitas.kamarMandi", KamarMandi)))).sort(new BasicDBObject("harga",SortValue));
							for (Rumah rumah : rumahIterable) {
								resultList.add(rumah);
							}
				}else {
					FindIterable<Rumah> rumahIterable = RumahCollection.find(Filters.and(
							Filters.eq("kecamatan",Kecamatan),
							Filters.gte("harga", HargaMin),
							Filters.lte("harga", HargaMax),
							Filters.gte("luas.luasTanah", LuasTanahMin),
							Filters.lte("luas.luasTanah", LuasTanahMax),
							Filters.and(
								Filters.gte("luas.luasBangunan", LuasBangunanMin),
								Filters.lte("luas.luasBangunan", LuasBangunanMax),
							Filters.gte("fasilitas.kamarTidur", KamarTidur),
							Filters.eq("fasilitas.kamarMandi", KamarMandi)))).sort(new BasicDBObject("harga",SortValue));
							for (Rumah rumah : rumahIterable) {
								resultList.add(rumah);
							}
				}
			}else {
				if(KamarMandi==0) {
					FindIterable<Rumah> rumahIterable = RumahCollection.find(Filters.and(
							Filters.eq("kecamatan",Kecamatan),
							Filters.gte("harga", HargaMin),
							Filters.lte("harga", HargaMax),
							Filters.gte("luas.luasTanah", LuasTanahMin),
							Filters.lte("luas.luasTanah", LuasTanahMax),
							Filters.and(
								Filters.gte("luas.luasBangunan", LuasBangunanMin),
								Filters.lte("luas.luasBangunan", LuasBangunanMax),
							Filters.eq("fasilitas.kamarTidur", KamarTidur),
							Filters.gte("fasilitas.kamarMandi", KamarMandi)))).sort(new BasicDBObject("harga",SortValue));
							for (Rumah rumah : rumahIterable) {
								resultList.add(rumah);
							}
				}else {
					FindIterable<Rumah> rumahIterable = RumahCollection.find(Filters.and(
							Filters.eq("kecamatan",Kecamatan),
							Filters.gte("harga", HargaMin),
							Filters.lte("harga", HargaMax),
							Filters.gte("luas.luasTanah", LuasTanahMin),
							Filters.lte("luas.luasTanah", LuasTanahMax),
							Filters.and(
								Filters.gte("luas.luasBangunan", LuasBangunanMin),
								Filters.lte("luas.luasBangunan", LuasBangunanMax),
						Filters.eq("fasilitas.kamarTidur", KamarTidur),
						Filters.eq("fasilitas.kamarMandi", KamarMandi)))).sort(new BasicDBObject("harga",SortValue));
					for (Rumah rumah : rumahIterable) {
						resultList.add(rumah);
					}
				}
		}
	
		return resultList;
	}
	
	public List<Rumah> getRumahbyFilter4( int SortValue,int LuasTanahMin, int LuasTanahMax, int LuasBangunanMin, 
			int LuasBangunanMax,int HargaMin, int HargaMax, int KamarTidur, int KamarMandi) {
		ArrayList<Rumah> resultList = new ArrayList<>();
			if(KamarTidur==0) {
				if(KamarMandi==0) {
					FindIterable<Rumah> rumahIterable = RumahCollection.find(Filters.and(
							Filters.gte("harga", HargaMin),
							Filters.lte("harga", HargaMax),
							Filters.gte("luas.luasTanah", LuasTanahMin),
							Filters.lte("luas.luasTanah", LuasTanahMax),
							Filters.and(
								Filters.gte("luas.luasBangunan", LuasBangunanMin),
								Filters.lte("luas.luasBangunan", LuasBangunanMax),
							Filters.gte("fasilitas.kamarTidur", KamarTidur),
							Filters.gte("fasilitas.kamarMandi", KamarMandi)))).sort(new BasicDBObject("harga",SortValue));
							for (Rumah rumah : rumahIterable) {
								resultList.add(rumah);
							}
				}else {
					FindIterable<Rumah> rumahIterable = RumahCollection.find(Filters.and(
							Filters.gte("harga", HargaMin),
							Filters.lte("harga", HargaMax),
							Filters.gte("luas.luasTanah", LuasTanahMin),
							Filters.lte("luas.luasTanah", LuasTanahMax),
							Filters.and(
								Filters.gte("luas.luasBangunan", LuasBangunanMin),
								Filters.lte("luas.luasBangunan", LuasBangunanMax),
							Filters.gte("fasilitas.kamarTidur", KamarTidur),
							Filters.eq("fasilitas.kamarMandi", KamarMandi)))).sort(new BasicDBObject("harga",SortValue));
							for (Rumah rumah : rumahIterable) {
								resultList.add(rumah);
							}
				}
			}else {
				if(KamarMandi==0) {
					FindIterable<Rumah> rumahIterable = RumahCollection.find(Filters.and(
							Filters.gte("harga", HargaMin),
							Filters.lte("harga", HargaMax),
							Filters.gte("luas.luasTanah", LuasTanahMin),
							Filters.lte("luas.luasTanah", LuasTanahMax),
							Filters.and(
								Filters.gte("luas.luasBangunan", LuasBangunanMin),
								Filters.lte("luas.luasBangunan", LuasBangunanMax),
							Filters.eq("fasilitas.kamarTidur", KamarTidur),
							Filters.gte("fasilitas.kamarMandi", KamarMandi)))).sort(new BasicDBObject("harga",SortValue));
							for (Rumah rumah : rumahIterable) {
								resultList.add(rumah);
							}
				}else {
					FindIterable<Rumah> rumahIterable = RumahCollection.find(Filters.and(
							Filters.gte("harga", HargaMin),
							Filters.lte("harga", HargaMax),
							Filters.gte("luas.luasTanah", LuasTanahMin),
							Filters.lte("luas.luasTanah", LuasTanahMax),
							Filters.and(
								Filters.gte("luas.luasBangunan", LuasBangunanMin),
								Filters.lte("luas.luasBangunan", LuasBangunanMax),
						Filters.eq("fasilitas.kamarTidur", KamarTidur),
						Filters.eq("fasilitas.kamarMandi", KamarMandi)))).sort(new BasicDBObject("harga",SortValue));
					for (Rumah rumah : rumahIterable) {
						resultList.add(rumah);
					}
						
				}
		}
	
		return resultList;
	}
	
	public ArrayList<Rumah> getRumahByPemilik(String nomorHP) throws IOException {		
		Pemilik p = findPemilikByNomorHP(nomorHP);
		String id = p.getId(); 
		ArrayList<Rumah> resultList = new ArrayList<>();
		ArrayList<Rumah> r = getRumah();
		for (Rumah rumah : r) {
	        if (rumah.getIdPemilik().equals(id)) {
	        	resultList.add(rumah);
	       }
	    }		
		return resultList;
	}
	
	public ArrayList<Rumah> getRumah() throws IOException {		
		ArrayList<Rumah> resultList = new ArrayList<>();
		FindIterable<Rumah> rumahIterable = RumahCollection.find();		
		for (Rumah rumah : rumahIterable) {
			System.out.println(rumah);
			resultList.add(rumah);
		}		
		return resultList;
	}
	//pemilik meng-insert data rumah
	public boolean inserting(String nama, String kecamatan, String alamat, 
						     int harga, String namaP, String nomorHP, String email, 
						     Luas luas, Fasilitas fasilitas) {
		
		try {
			long count = PemilikCollection.countDocuments(new BsonDocument("nomorHP", new BsonString(nomorHP)));
		    if (count > 0){
		    	System.out.println("Data Pemilik Sudah Ada");
		    	//Mencari data pemilik
		    	Pemilik p = findPemilikByNomorHP(nomorHP);
		    	String idPemilik = p.getId();
		    	List<String> idRumahList = p.getIdRumahList();
		    	//Menambahkan data rumah
		    	System.out.println("Menambah Data Rumah");
		    	String idRumah = new ObjectId().toString();
		    	idRumahList.add(idRumah);
	            	Rumah rumah = new Rumah(idRumah, nama, kecamatan, alamat, harga, luas, fasilitas, idPemilik);


				RumahCollection.insertOne(rumah);
				//Menambahkan list rumah pada data pemilik
				PemilikCollection.updateOne(eq("_id", idPemilik), Updates.addToSet("idRumahList", idRumah));
		    }else{
		    	String idPemilik = new ObjectId().toString();
		    	String idRumah = new ObjectId().toString();
		    	List<String> idRumahList = new ArrayList<String>();
				idRumahList.add(idRumah);
				System.out.println("Menambah Data Pemilik");
				Pemilik pemilik = new Pemilik(idPemilik, namaP, nomorHP, email, idRumahList);
				pemilik.setId(idPemilik);
				PemilikCollection.insertOne(pemilik);
				System.out.println("Menambah Data Rumah");

				DBRef myDbRef = new DBRef("myDb", "PemilikCollection", idPemilik);
				Rumah rumah = new Rumah(idRumah, nama, kecamatan, alamat, harga, luas, fasilitas, idPemilik);
				RumahCollection.insertOne(rumah);
		    }
				System.out.println("Data Tersimpan");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
		public boolean updateData(String idRumah,String nama,String kecamatan,String alamat,int harga,Luas luas,Fasilitas fasilitas) throws Exception {
			String id = idRumah;
			try {
				RumahCollection.updateOne(Filters.eq("id", id),Updates.combine(Updates.set("nama", nama), Updates.set("harga", harga),
								Updates.set("kecamatan", kecamatan), Updates.set("alamat", alamat), Updates.set("luas",luas),Updates.set("fasilitas", fasilitas)));
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
	
	public boolean delete(String idRumah, String nomorHP) throws IOException {
		Rumah r = findRumahById(idRumah);
		String idPemilik = r.getIdPemilik();
		long count = RumahCollection.countDocuments(new BsonDocument("idPemilik", new BsonString(idPemilik)));
		//System.out.println("Jumlah rumah :"+count +","+idRumah +","+idPemilik);
	    if (count > 1){
	    	DeleteResult del = RumahCollection.deleteOne(eq("_id", idRumah));
	    	System.out.println(+del.getDeletedCount()+" Data Rumah Berhasil Terhapus");
	    }else {
	    	DeleteResult delR = RumahCollection.deleteOne(eq("_id", idRumah));
	    	DeleteResult delP = PemilikCollection.deleteOne(eq("_id", idPemilik));
	    	System.out.println(+delR.getDeletedCount()+" Data Rumah Berhasil Terhapus");
	    	System.out.println(+delP.getDeletedCount()+" Data Pemilik Berhasil Terhapus");
	    }
		return true;
	}
	
	public boolean search(String nomorHP) {
		try {
			long count = PemilikCollection.countDocuments(new BsonDocument("nomorHP", new BsonString(nomorHP)));
		    if (count > 0){
		    	System.out.println("Data Pemilik Sudah Terdaftar");
		    }else{
		    	return false;
		    }
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Pemilik findPemilikByNomorHP(String nomorHP) throws IOException {
		Pemilik p = PemilikCollection
    			.find(new BasicDBObject("nomorHP", nomorHP))
    			.projection(Projections.fields(Projections.include("id"))).first();
    	return p;
	}
	
	public Rumah findRumahById(String id) throws IOException {
		Rumah p = RumahCollection
				.find(eq("_id", id)).first();
    	return p;
	}
}