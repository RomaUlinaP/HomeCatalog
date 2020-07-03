<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lihat Rumah - Katalog Rumah</title>
</head>
<body>
	<jsp:include page="JualRumah.jsp" />
	<div class ="container">
		<form action="ActionController" method="post">
			<input class="btn btn-info" type="submit" name="action" value="retrieve">
        </form>
    	<h3>Daftar Rumah</h3>
        <table class="table">
        	<thead>
        		<tr>
                	<th>Nama Rumah</th>
                	<th>Alamat</th>
                	<th>Kecamatan</th>
                	<th>Harga</th>
                	<th>Luas Tanah</th>
					<th>Luas Bangunan</th>
					<th>Foto</th>
					<th>Kamar Tidur</th>
					<th>Kamar Mandi</th>
					<th>Garasi</th>
					<th>Halaman Belakang</th>
					
            	</tr>
            </thead>
            <tbody>
		    	<c:forEach items="${dataRumah}" var="dataItem">
	            	<form action="ActionController" method="post">
			        	<tr>
			        		<td>${dataItem.nama}</td>
			            	<td>${dataItem.alamat}</td>
			            	<td>${dataItem.kecamatan}</td>
			            	<td>${dataItem.harga}</td>
			            	<td>${dataItem.getLuas().getLuasTanah()}</td>
			            	<td>${dataItem.getLuas().getLuasBangunan()}</td>
			            	<td>${dataItem.getFasilitas().getKamarTidur()}</td>
			            	<td>${dataItem.getFasilitas().getKamarMandi()}</td>
			            	<td>${dataItem.getFasilitas().getGarasi()}</td>
			            	<td>${dataItem.getFasilitas().getDapur()}</td>
			            	<td>${dataItem.getFasilitas().getHalamanBelakang()}</td>
			            	<td><input type="submit" name="action" value="hapus" class="btn btn-info"/></td> 
							<td><input type="hidden" name="action" value="before_update"><input class="btn btn-info" type="submit" value="Edit Data"/></td>
							
			        	</tr>
			        	<input type="hidden" name="idRumah"  		value="${dataItem.id}">
			        	<input type="hidden" name="idPemilik"  		value="${dataItem.idPemilik}">
			        	<input type="hidden" name="NamaRumah"  		value="${dataItem.nama}">
			        	<input type="hidden" name="Alamat"     		value="${dataItem.alamat}">
			       		<input type="hidden" name="Kecamatan"     	value="${dataItem.kecamatan}">
			       		<input type="hidden" name="Harga"      		value="${dataItem.harga}">
			       		<input type="hidden" name="LuasTanah"  		value="${dataItem.getLuas().getLuasTanah()}">
			       		<input type="hidden" name="LuasBangunan"     		value="${dataItem.getLuas().getLuasBangunan()}">
			       		<input type="hidden" name="KamarTidur"     	value="${dataItem.getFasilitas().getKamarTidur()}">
			       		<input type="hidden" name="KamarMandi"     	value="${dataItem.getFasilitas().getKamarMandi()}">
			       		<input type="hidden" name="Garasi"      	value="${dataItem.getFasilitas().getGarasi()}">
			       		<input type="hidden" name="Dapur"     		value="${dataItem.getFasilitas().getDapur()}">
		        		<input type="hidden" name="HalamanBelakang" value="${dataItem.getFasilitas().getHalamanBelakang()}">
			     	</form>
		    	</c:forEach>
		    </tbody>
        </table>
    </div>
</body>
</html>