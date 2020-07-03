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
		<div class="form-group">
			<select style="margin-left: 0px;width:595px; overflow=auto; height=50%; max-height:100px" class="form-control" name="Kec">
				<option value="kosong">Cari berdasarkan kecamatan</option>
				<option value="Bandung Barat">Bandung Barat</option>
				<option value="Kab. Bandung">Kab. Bandung</option>
				<option value="Andir">Andir</option>
				<option value="Antapani">Antapani</option>
				<option value="Arcamanik">Arcamanik</option>
				<option value="Astanaanyar">Astanaanyar</option>
				<option value="Babakanciparay">Babakanciparay</option>
				<option value="Bandung Kidul">Bandung Kidul</option>
				<option value="Bandung Kulon">Bandung Kulon</option>
				<option value="Bandung Wetan">Bandung Wetan</option>
				<option value="Batununggal">Batununggal</option>
				<option value="Bojongloa Kaler">Bojongloa Kaler</option>
				<option value="Bojongloa kidul">Bojongloa kidul</option>
				<option value="Buah batu">Buah batu</option>
				<option value="Cibeunying kaler">Cibeunying kaler</option>
				<option value="Cibeunying kidul">Cibeunying kidul</option>
				<option value="Cibiru">Cibiru</option>
				<option value="Cicendo">Cicendo</option>
				<option value="Cidadap">Cidadap</option>
				<option value="Cinambo">Cinambo</option>
				<option value="Coblong">Coblong</option>
				<option value="Gedebage">Gedebage</option>
				<option value="Kiaracondong">Kiaracondong</option>
				<option value="Lengkong">Lengkong</option>
				<option value="Mandalajati">Mandalajati</option>
				<option value="Rancasari">Rancasari</option>
				<option value="Regol">Regol</option>
				<option value="Sukajadi">Sukajadi</option>
				<option value="Sukasari">Sukasari</option>
				<option value="Sumurbandung">Sumurbandung</option>
				<option value="Ujungberung">Ujungberung</option>
			</select>
		
		<input type="hidden" name="action" value="SearchKecamatan"><input class="btn btn-info" type="submit" value="Cari"/>
        </div>
    <br>
    </br>
    	<div class="form-inline">
    		<label style="margin-left: 20px;">Harga Min (Rp.)</label>
    		<label style="margin-left: 100px;">Harga Maks (Rp.)</label>	
    	</div>

    	<div class="form-inline">
			<select style="margin-left: 0px;width:150px; overflow=auto; height=50%; max-height:100px" class="form-control" name="HargaMin">
				<option value="0">Berapapun</option>
				<option value="50000000">50Jt</option>
				<option value="100000000">100Jt</option>
				<option value="200000000">200Jt</option>
				<option value="300000000">300Jt</option>
				<option value="400000000">400Jt</option>
				<option value="500000000">500Jt</option>
				<option value="600000000">600Jt</option>
				<option value="700000000">700Jt</option>
				<option value="800000000">800Jt</option>
				<option value="900000000">900Jt</option>
				<option value="1000000000">1M</option>
				<option value="1200000000">1,2M</option>
				<option value="1400000000">1,4M</option>
				<option value="1600000000">1,6M</option>
				<option value="1800000000">1,8M</option>
				<option value="2000000000">2M</option>
			</select>
			<select style="margin-left: 50px;width:150px; overflow=auto; height=50%; max-height:100px" class="form-control" name="HargaMaks">
				<option value="2000000000">Berapapun</option>
				<option value="50000000">50Jt</option>
				<option value="100000000">100Jt</option>
				<option value="200000000">200Jt</option>
				<option value="300000000">300Jt</option>
				<option value="400000000">400Jt</option>
				<option value="500000000">500Jt</option>
				<option value="600000000">600Jt</option>
				<option value="700000000">700Jt</option>
				<option value="800000000">800Jt</option>
				<option value="900000000">900Jt</option>
				<option value="1000000000">1M</option>
				<option value="1200000000">1,2M</option>
				<option value="1400000000">1,4M</option>
				<option value="1600000000">1,6M</option>
				<option value="1800000000">1,8M</option>
				<option value="2000000000">2M</option>
			</select>
		</div>
		</form>
	</div>
	
    <div class ="container">
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