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
	<jsp:include page="HalamanUtama.jsp" />
	<div class ="container">
		<form class ="form-inline" action="ActionController" method="post">
 
    	<div class="form-inline">
    		<label style="margin-left: 10px;">Luas Tanah Min (m2)</label>
    		<label style="margin-left: 20px;">Luas Tanah Max (m2)</label>	
    		<label style="margin-left: 25px;">Luas Bangunan Min (m2)</label>	
    		<label style="margin-left: 15px;">Luas Bangunan Max (m2)</label>	
    	</div>

    	<div class="form-inline">
			<select style="margin-left: 0px;width:150px; overflow=auto; height=50%; max-height:100px" class="form-control" name="LuasTanahMin">
				<option value="0">Berapapun</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="150">150</option>
				<option value="200">200</option>
				<option value="250">250</option>
				<option value="500">500</option>
				<option value="750">750</option>
				<option value="1000">1000</option>
				<option value="2000">2000</option>
				<option value="3000">3000</option>
				<option value="4000">4000</option>
				<option value="5000">5000</option>
				<option value="6000">6000</option>
				<option value="7000">7000</option>
			</select>
			<select style="margin-left: 15px;width:150px; overflow=auto; height=50%; max-height:100px" class="form-control" name="LuasTanahMax">
				<option value="7000">Berapapun</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="150">150</option>
				<option value="200">200</option>
				<option value="250">250</option>
				<option value="500">500</option>
				<option value="750">750</option>
				<option value="1000">1000</option>
				<option value="2000">2000</option>
				<option value="3000">3000</option>
				<option value="4000">4000</option>
				<option value="5000">5000</option>
				<option value="6000">6000</option>
				<option value="7000">7000</option>
			</select>
			<select style="margin-left: 25px;width:150px; overflow=auto; height=50%; max-height:100px" class="form-control" name="LuasBangunanMin">
				<option value="0">Berapapun</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="150">150</option>
				<option value="200">200</option>
				<option value="250">250</option>
				<option value="500">500</option>
				<option value="750">750</option>
				<option value="1000">1000</option>
				<option value="2000">2000</option>
				<option value="3000">3000</option>
				<option value="4000">4000</option>
				<option value="5000">5000</option>
				<option value="6000">6000</option>
				<option value="7000">7000</option>
			</select>
			<select style="margin-left: 30px;width:150px; overflow=auto; height=50%; max-height:100px" class="form-control" name="LuasBangunanMax">
				<option value="10000">Berapapun</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="150">150</option>
				<option value="200">200</option>
				<option value="250">250</option>
				<option value="500">500</option>
				<option value="750">750</option>
				<option value="1000">1000</option>
				<option value="2000">2000</option>
				<option value="3000">3000</option>
				<option value="4000">4000</option>
				<option value="5000">5000</option>
				<option value="6000">6000</option>
				<option value="7000">7000</option>
			</select>
		</div>
		<br>
		<div class="form-inline">
    		<label style="margin-left: 10px;">Kamar Tidur</label>
    		<label style="margin-left: 75px;">Kamar Mandi</label>
    	</div>
    	<div class="form-inline">
    		<select style="margin-left: 0px;width:150px; overflow=auto; height=50%; max-height:100px" class="form-control" name="KamarTidur">
				<option value="0">Berapapun</option>
				<option value="1">1+</option>
				<option value="2">2+</option>
				<option value="3">3+</option>
				<option value="4">4+</option>
				<option value="5">5+</option>
			</select>
			<select style="margin-left: 10px;width:150px; overflow=auto; height=50%; max-height:100px" class="form-control" name="KamarMandi">
				<option value="0">Berapapun</option>
				<option value="1">1+</option>
				<option value="2">2+</option>
				<option value="3">3+</option>
				<option value="4">4+</option>
				<option value="5">5+</option>
			</select>
			<input type="submit" name="action" value="Cari" class="btn btn-info"/>
    	<h3>Daftar Rumah</h3>
    		<select style="margin-left:900px;width:150px; overflow=auto; height=50%; max-height:900px" class="form-control" name="SortHarga">
				<option value="0">Urutkan Harga</option>
				<option value="-1">Harga Tertinggi</option>
				<option value="1">Harga Terendah</option>
			</select>
		  	<input type="submit" name="action" value="Urutkan" class="btn btn-info"/>
		</div>
		</form>
			<br></br>
        <table class="table">
        	<thead>
        		<tr>
                	<th>Nama Rumah</th>
                	<th>Alamat</th>
                	<th>Kecamatan</th>
                	<th>Harga</th>
                	<th>Luas Tanah</th>
					<th>Luas Bangunan</th>
					<th>Kamar Tidur</th>
					<th>Kamar Mandi</th>
					<th>Garasi</th>
					<th>Dapur</th>
					<th>Halaman Belakang</th>
					
            	</tr>
            </thead>
            <tbody>
		    	<c:forEach items="${dataR}" var="dataItem">
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
			            	<td><input type="hidden" name="action" value="TampilPemilik"><input class="btn btn-info" type="submit" value="Hubungi Penjual"/></td> 

			        	</tr>
			        	<input type="hidden" name="idPemilik"  		value="${dataItem.idPemilik}">
			        	<input type="hidden" name="NamaRumah"  		value="${dataItem.nama}">
			        	<input type="hidden" name="Alamat"     		value="${dataItem.alamat}">
			       		<input type="hidden" name="Kecamatan"     	value="${dataItem.kecamatan}">
			       		<input type="hidden" name="Harga"      		value="${dataItem.harga}">
			       		<input type="hidden" name="LuasTanah"  		value="${dataItem.getLuas().getLuasTanah()}">
			       		<input type="hidden" name="LuasBarang"     		value="${dataItem.getLuas().getLuasBangunan()}">
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