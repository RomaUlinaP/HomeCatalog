package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Motor;
import model.Student;

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
			String name = request.getParameter("name");
			String city = request.getParameter("city");
			String designation = request.getParameter("designation");
			int salary = Integer.parseInt(request.getParameter("salary"));	
			String newList = request.getParameter("newList");
			String newMerk = request.getParameter("newMerk");
			String newWarna = request.getParameter("newWarna");
			List<Motor> objectList = new ArrayList<Motor>();
			objectList.add(new Motor(newMerk,newWarna));
//			boolean result = mongodbUtils.insertData(name, city, designation, salary);
//			boolean result = mongodbUtils.insertDataNewDataList(name, city, designation, salary, newList);
			System.out.println("newList:"+newList);
			System.out.println("motor:"+objectList);
			boolean result = mongodbUtils.insertDataNewObjectList(name, city, designation, salary, newList, objectList);
			if(result) {
				showAllData(request, response, mongodbUtils);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}			
		}else if("delete".equals(action)){
			String row = request.getParameter("row");
			System.out.println("ROW DELETED = "+row);
			
			boolean result = mongodbUtils.delete(row);
			if(result) {
				showAllData(request, response, mongodbUtils);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
		}else if("Input".equals(action)) {
			RequestDispatcher rd = request.getRequestDispatcher("/Input.jsp");
			rd.forward(request, response);
		}else if("before_update".equals(action)) {
			String vrow = request.getParameter("row");
			String vname = request.getParameter("name");
			String vcity = request.getParameter("city");
			String vdesignation = request.getParameter("designation");
			String vsalary = request.getParameter("salary");			
			Student student = new Student(vname, vcity, vdesignation, Integer.parseInt(vsalary), null, null);
			request.setAttribute("student", student);	
			request.getRequestDispatcher("/edit.jsp").forward(request, response);
		}else if("to_update".equals(action)) {
			String vrow = request.getParameter("row");
			String vname = request.getParameter("name");
			String vcity = request.getParameter("city");
			String vdesignation = request.getParameter("designation");
			int vsalary = Integer.parseInt(request.getParameter("salary"));
				
			System.out.println("ROW UPDATED = "+vrow);				
			boolean resultUpdate = mongodbUtils.updateData(vrow, vname, vcity, vdesignation, vsalary);
			if(resultUpdate) {
				showAllData(request, response, mongodbUtils);
			}else {
				RequestDispatcher rdUpdate = request.getRequestDispatcher("/error.jsp");
				rdUpdate.forward(request, response);
			}
						
		}
	}
	
	public void showAllData(HttpServletRequest request, HttpServletResponse response,
			MongoDBUtils mongodbUtils) {
		try {
			ArrayList<Student> listStudent = mongodbUtils.getStudent();
			request.setAttribute("dataList", listStudent);
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}