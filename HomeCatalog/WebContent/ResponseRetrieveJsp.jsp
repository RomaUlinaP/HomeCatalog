<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Rumah</h2></caption>
            <tr>
				<th>Nama Rumah</th>
                <th>Status</th>
                <th>Alamat</th>
                <th>Provinsi</th>
                <th>Harga</th>
				<th>Panjang</th>
				<th>Lebar</th>
				<th>Foto</th>
				<th>Kamar Tidur</th>
				<th>Kamar Mandi</th>
				<th>Garasi</th>
				<th>Halaman Belakang</th>
				<th>Nama Pemilik</th>
                <th>Nomor HP</th>
                <th>Email</th>           
                <th>Delete</th>
                <th>Update</th>
            </tr>
            <c:forEach items="${dataList}" var="dataItem">
            	<form action="ActionController" method="post">
			        <tr>
			        	<td>${dataItem.nama}</td>
			            <td>${dataItem.status}</td>
			            <td>${dataItem.alamat}</td>
			            <td>${dataItem.provinsi}</td>
			            <td>${dataItem.harga}</td>
			            <td>${dataItem.panjang}</td>
			            <td>${dataItem.lebar}</td>
			            <td>${dataItem.kamarTidur}</td>
			            <td>${dataItem.kamarMandi}</td>
			            <td>${dataItem.garasi}</td>
			            <td>${dataItem.dapur}</td>
			            <td>${dataItem.halamanBelakang}</td>
			            <td>${dataItem.namaP}</td>
			            <td>${dataItem.nomorHP}</td>
			            <td>${dataItem.email}</td>
			            <td><input type="submit" name="action" value="delete"></td>
			        </tr>
			        <input type="hidden" name="Row" value="${dataItem.id}">
			     </form>
		    </c:forEach>
        </table>
    </div>
</body>
</html>