package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Fasilitas;
import model.Pemilik;
import model.Rumah;
import model.Ukuran;

public class ActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String currNomorHP;
	public ActionController() {
		super();
	}
	MongoDBUtils mongodbUtils = new MongoDBUtils();
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("ACTION = "+action);
		MongoDBUtils mongodbUtils = new MongoDBUtils();
		
		if("Retrieve".equals(action)){
			showAllData(request, response, mongodbUtils);
		}else if("insert".equals(action)){
			// TODO
			String nama = request.getParameter("NamaRumah");
			String status = "Belum Terjual";
			String provinsi = request.getParameter("Provinsi");
			String alamat = request.getParameter("Alamat");
			int harga = Integer.parseInt(request.getParameter("Harga"));
			String namaP = request.getParameter("NamaP");
			String nomorHP = request.getParameter("NomorHP");
			String email = request.getParameter("Email");
			int panjang = Integer.parseInt(request.getParameter("Panjang"));
			int lebar = Integer.parseInt(request.getParameter("Lebar"));
			int kamarTidur = Integer.parseInt(request.getParameter("KamarTidur"));
			int kamarMandi = Integer.parseInt(request.getParameter("KamarMandi"));
			int garasi = Integer.parseInt(request.getParameter("Garasi"));
			int dapur = Integer.parseInt(request.getParameter("Dapur"));
			int halamanBelakang = Integer.parseInt(request.getParameter("HalamanBelakang"));
			Fasilitas fasilitas = new Fasilitas(kamarTidur, kamarMandi, garasi, dapur, halamanBelakang);
			Ukuran ukuran = new Ukuran(panjang, lebar);
			boolean result= mongodbUtils.inserting(nama, status, provinsi, alamat, harga, 
												   namaP, nomorHP, email, ukuran, fasilitas);
			if(result) {
				showAllData(request, response, mongodbUtils);
				System.out.println("done");
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
		}else if("hapus".equals(action)){
			String id = request.getParameter("idRumah");
			boolean result = mongodbUtils.delete(id, currNomorHP);
			if(result) {
				boolean result2 = mongodbUtils.search(currNomorHP);
				if(result2) {
					showDataRumah(request, response, mongodbUtils, currNomorHP);
				}else {
					RequestDispatcher rd = request.getRequestDispatcher("/Update.jsp");
					rd.forward(request, response);
				}
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
		}else if("Input".equals(action)) {
			RequestDispatcher rd = request.getRequestDispatcher("/Input.jsp");
			rd.forward(request, response);
		}else if("before_update".equals(action)) {
			String id = request.getParameter("idRumah");
			String nama = request.getParameter("NamaRumah");
			String status = request.getParameter("Status");
			String idPemilik = request.getParameter("idPemilik");
			String provinsi = request.getParameter("Provinsi");
			String alamat = request.getParameter("Alamat");
			int harga = Integer.parseInt(request.getParameter("Harga"));
			int panjang = Integer.parseInt(request.getParameter("Panjang"));
			int lebar = Integer.parseInt(request.getParameter("Lebar"));
			int kamarTidur = Integer.parseInt(request.getParameter("KamarTidur"));
			int kamarMandi = Integer.parseInt(request.getParameter("KamarMandi"));
			int garasi = Integer.parseInt(request.getParameter("Garasi"));
			int dapur = Integer.parseInt(request.getParameter("Dapur"));
			int halamanBelakang = Integer.parseInt(request.getParameter("HalamanBelakang"));
			Fasilitas fasilitas = new Fasilitas(kamarTidur, kamarMandi, garasi, dapur, halamanBelakang);
			Ukuran ukuran = new Ukuran(panjang, lebar);
			
			Rumah rumah = new Rumah (id,nama,status,provinsi,alamat,harga,ukuran,fasilitas,idPemilik);
			request.setAttribute("rumah", rumah);
			RequestDispatcher rd = request.getRequestDispatcher("/editrumah.jsp");
			rd.forward(request, response);
		}else if("update".equals(action)) {
			String id = request.getParameter("idRumah");
			String nama = request.getParameter("NamaRumah");
			String status = request.getParameter("Status");
			String provinsi = request.getParameter("Provinsi");
			String alamat = request.getParameter("Alamat");
			int harga = Integer.parseInt(request.getParameter("Harga"));
			int panjang = Integer.parseInt(request.getParameter("Panjang"));
			int lebar = Integer.parseInt(request.getParameter("Lebar"));
			int kamarTidur = Integer.parseInt(request.getParameter("KamarTidur"));
			int kamarMandi = Integer.parseInt(request.getParameter("KamarMandi"));
			int garasi = Integer.parseInt(request.getParameter("Garasi"));
			int dapur = Integer.parseInt(request.getParameter("Dapur"));
			int halamanBelakang = Integer.parseInt(request.getParameter("HalamanBelakang"));
			Fasilitas fasilitas = new Fasilitas(kamarTidur, kamarMandi, garasi, dapur, halamanBelakang);
			Ukuran ukuran = new Ukuran(panjang, lebar);
			boolean resultUpdate;
			try {
				
				System.out.println("Data Rumah Berhasil Diperbaharui");
				resultUpdate = mongodbUtils.updateData(id, nama, status,provinsi,alamat,harga,ukuran,fasilitas);
				RequestDispatcher rd = request.getRequestDispatcher("/ListRumah.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("search".equals(action)) {
			currNomorHP = request.getParameter("NomorHP");
			boolean result = mongodbUtils.search(currNomorHP);
			if(result) {
				RequestDispatcher rd = request.getRequestDispatcher("/ListRumah.jsp");
				rd.forward(request, response);
			}else {
				System.out.println("Data tidak ditemukan");
				RequestDispatcher rd = request.getRequestDispatcher("/Update.jsp");
				rd.forward(request, response);
			}
		}else if("TampilPemilik".equals(action)){
			String idPemilik = request.getParameter("idPemilik");
			showDataPemilik(request, response, mongodbUtils, idPemilik);
		}else if("retrieve".equals(action)){
			showDataRumah(request, response, mongodbUtils, currNomorHP);
		}
	}
	
	public void showAllData(HttpServletRequest request, HttpServletResponse response,
			MongoDBUtils mongodbUtils) {
		try {
			ArrayList<Pemilik> listPemilik = mongodbUtils.getPemilik();
			ArrayList<Rumah> listRumah = mongodbUtils.getRumah();
			for(int i=0; i<listPemilik.size();i++) {
				List<String> idRumah = listPemilik.get(i).getIdRumahList();
				for(int j=0; j<listRumah.size();j++) {
					if(idRumah.contains(listRumah.get(j).getId())) {
						listPemilik.get(i).addRumah(listRumah.get(j));
					}
				}
			}
			request.setAttribute("dataR", listRumah);
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showDataPemilik(HttpServletRequest request, HttpServletResponse response,
			MongoDBUtils mongodbUtils, String id) {
		try {
			System.out.println("Menampilkan Data ...");
			ArrayList<Pemilik> listPemilik = mongodbUtils.getPemilikbyid(id);
			request.setAttribute("dataPemilik", listPemilik);
			request.getRequestDispatcher("DetailPemilik.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showDataRumah(HttpServletRequest request, HttpServletResponse response,
			MongoDBUtils mongodbUtils, String nomorHP) {
		try {
			System.out.println("Menampilkan Data ...");
			ArrayList<Rumah> listRumah = mongodbUtils.getRumahByPemilik(nomorHP);
			request.setAttribute("dataRumah", listRumah);
			request.getRequestDispatcher("ListRumah.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}