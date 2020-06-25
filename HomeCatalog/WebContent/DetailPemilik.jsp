<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detail Pemilik - Katalog Rumah</title>
</head>
<body>
	<jsp:include page="HalamanUtama.jsp" />
	<div class ="container">
		<form action="ActionController" method="post">
			<input type="hidden" name="action" value="Retrieve"><input class="btn btn-info" type="submit" value="Kembali"/>
        </form>
		<h3>Data Pemilik</h3>
        <table class="table">
        	<thead>
        		<tr>
                	<th>Nama Pemilik</th>
                	<th>No HP</th>
                	<th>Email</th>
                	
            	</tr>
            </thead>
            <tbody>
		    	<c:forEach items="${dataPemilik}" var="dataItems">
	            	<form action="ActionController" method="post">
			        	<tr>
			        		<td>${dataItems.namaP}</td>
			            	<td>${dataItems.nomorHP}</td>
			            	<td>${dataItems.email}</td>
			        	</tr>
			        	
			        	<input type="hidden" name="NamaP"  		value="${dataItems.namaP}">
			        	<input type="hidden" name="NomorHP"     value="${dataItems.nomorHP}">
			       		<input type="hidden" name="Email"     	value="${dataItems.email}">
			     	</form>
		    	</c:forEach>
		    </tbody>
        </table>  		
	</div>
</body>
</html>