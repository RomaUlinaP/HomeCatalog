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

	public ActionController() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("ACTION = "+action);
		MongoDBUtils mongodbUtils = new MongoDBUtils();
		if("Retrieve".equals(action)){
			showAllData(request, response, mongodbUtils);
		}else if("insert".equals(action)){
			// TODO
			String nama = request.getParameter("Nama");
			String status = request.getParameter("Status");
			String provinsi = request.getParameter("Provinsi");
			String alamat = request.getParameter("Alamat");
			int harga = Integer.parseInt(request.getParameter("Harga"));
			String namaP = request.getParameter("NamaP");
			String nomorHP = request.getParameter("NomorHP");
			String email = request.getParameter("Email");
			boolean result= mongodbUtils.inserting(nama, status, provinsi, alamat, harga, 
												   namaP, nomorHP, email);
			if(result) {
				showAllData(request, response, mongodbUtils);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
		}else if("delete".equals(action)){
		
		}else if("Input".equals(action)) {
			RequestDispatcher rd = request.getRequestDispatcher("/Input.jsp");
			rd.forward(request, response);
		}else if("before_update".equals(action)) {

		}else if("to_update".equals(action)) {
		
		}
	}
	
	public void showAllData(HttpServletRequest request, HttpServletResponse response,
			MongoDBUtils mongodbUtils) {
	}
}