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
		<form action="ActionController" method="post">
			<input type="submit" name="action" value="Retrieve">
			<input type="submit" name="action" value="Input">
        </form>
        <table border="1" cellpadding="5">
            <caption><h2>List of users</h2></caption>
            <tr>
            	<th>Nama</th>
                <th>Nomor HP</th>
                <th>Email</th>
                <th>Password</th>
                <td>Nama Rumah</td>
                <th>Status</th>
                <th>Alamat</th>
                <th>Provinsi</th>
                <th>Harga</th>
				<th>Panjang</th>
				<th>Lebar</th>
				<th>Kamar Tidur</th>
				<th>Kamar Mandi</th>
				<th>Garasi</th>
				<th>Halaman Belakang</th>           
                <th>Delete</th>
                <th>Update</th>
            </tr>
           <c:forEach items="${dataList}" var="dataPemilik">
	            	<form action="ActionController" method="post">
			        <tr>
			        	<td>${dataItem.NamaP}</td>
			            <td>${dataItem.NomorHP}</td>
			            <td>${dataItem.Email}</td>
			            <td>${dataItem.Password}</td>
			            <td>${dataItem.nama}</td>
			            <td>${dataItem.status}</td>
			            <td>${dataItem.Alamat}</td>
			            <td>${dataItem.provinsi}</td>
			            <td>${dataItem.Harga}</td>
			            <td>${dataItem.Panjang}</td>
			            <td>${dataItem.Lebar}</td>
			            <td>${dataItem.kamarTidur}</td>
			            <td>${dataItem.kamarMandi}</td>
			            <td>${dataItem.garasi}</td>
			            <td>${dataItem.dapur}</td>
			            <td>${dataItem.halamanBelakang}</td>
			            <td><input type="submit" name="action" value="delete"></td>
			            <td><input type="hidden" name="action" value="before_update"><input type="submit" value="update"/></td>
			        </tr>
			        <input type="hidden" name="NamaPemilik" value="${dataItem.NamaP}">
			        <input type="hidden" name="NomorHP" value="${dataItem.NomorHP}">
			        <input type="hidden" name="Email" value="${dataItem.Email}">
			        <input type="hidden" name="Password" value="${dataItem.Password}">
			        <input type="hidden" name="NamaRumah" value="${dataItem.nama}">
			        <input type="hidden" name="Status" value="${dataItem.status}">
			        <input type="hidden" name="Alamat" value="${dataItem.Alamat}">
			        <input type="hidden" name="Harga" value="${dataItem.Harga}">
			        <input type="hidden" name="Panjang" value="${dataItem.Panjang}">
			        <input type="hidden" name="Lebar" value="${dataItem.Lebar}">
			        <input type="hidden" name="KamarTidur" value="${dataItem.kamarTidur}">
			        <input type="hidden" name="KamarMandi" value="${dataItem.kamarMandi}">
			        <input type="hidden" name="Garasi" value="${{dataItem.garasi}">
			        <input type="hidden" name="Dapur" value="${dataItem.dapur}">
			         <input type="hidden" name="HalamanBelakang" value="${dataItem.halamanBelakang}">
			     </form>
		    </c:forEach>
        </table>
    </div>
</body>
</html>