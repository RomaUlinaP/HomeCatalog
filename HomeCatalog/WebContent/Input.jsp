<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tambah Data - Katalog Rumah</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="JualRumah.jsp" />
	<div class="container">
  	<h3>Form Data</h3>
	<form class="form-horizontal" action="ActionController" method="post">
		<div class="form-group">
      		<label class="control-label col-sm-2">Nama Rumah:</label>
      		<div class="col-sm-10">
        		<input class="form-control" placeholder="Masukan Nama Rumah" name="NamaRumah" value="${NamaRumah}">
      		</div>
    	</div>
    	<div class="form-group">
      		<label class="control-label col-sm-2">Alamat:</label>
      		<div class="col-sm-10">
        		<input class="form-control" placeholder="Masukan Alamat" name="Alamat" value="${Alamat}">
      		</div>
    	</div>
    	<div class="form-group">
    		<label style="margin-left: 100px;">Kecamatan:</label>
			<select style="margin-left: 210px;width:945px; overflow=auto; height=50%; max-height:100px" class="form-control" name="Kecamatan">
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
		</div>

		<div class="form-group">
      		<label class="control-label col-sm-2">Harga:</label>
      		<div class="col-sm-10">
        		<input class="form-control" placeholder="Masukan Harga" name="Harga" value="${Harga}">
      		</div>
    	</div>
		<div class="form-group">
      		<label class="control-label col-sm-2">Panjang:</label>
      		<div class="col-sm-10">
        		<input class="form-control" placeholder="Masukan Panjang" name="Panjang" value="${Panjang}">
      		</div>
    	</div>
		<div class="form-group">
      		<label class="control-label col-sm-2">Lebar:</label>
      		<div class="col-sm-10">
        		<input class="form-control" placeholder="Masukan Lebar" name="Lebar" value="${Lebar}">
      		</div>
    	</div>
    	<div class="form-group">
      		<label class="control-label col-sm-2">Kamar Tidur:</label>
      		<div class="col-sm-10">
        		<input class="form-control" placeholder="Masukan Jumlah Kamar Tidur" name="KamarTidur" value="${KamarTidur}">
      		</div>
    	</div>
		<div class="form-group">
      		<label class="control-label col-sm-2">Kamar Mandi:</label>
      		<div class="col-sm-10">
        		<input class="form-control" placeholder="Masukan Jumlah Kamar Mandi" name="KamarMandi" value="${KamarMandi}">
      		</div>
    	</div>
		<div class="form-group">
      		<label class="control-label col-sm-2">Garasi:</label>
      		<div class="col-sm-10">
        		<input class="form-control" placeholder="Masukan Jumlah Garasi" name="Garasi" value="${Garasi}">
      		</div>
    	</div>
    	<div class="form-group">
      		<label class="control-label col-sm-2">Dapur:</label>
      		<div class="col-sm-10">
        		<input class="form-control" placeholder="Masukan Jumlah Dapur" name="Dapur" value="${Dapur}">
      		</div>
    	</div>
    	<div class="form-group">
      		<label class="control-label col-sm-2">Halaman Belakang:</label>
      		<div class="col-sm-10">
        		<input class="form-control" placeholder="Masukan Jumlah Halaman Belakang" name="HalamanBelakang" value="${HalamanBelakang}">
      		</div>
    	</div>
		<div class="form-group">
      		<label class="control-label col-sm-2">Nama Pemilik:</label>
      		<div class="col-sm-10">
        		<input class="form-control" placeholder="Masukan Nama Pemilik" name="NamaP" value="${NamaP}">
      		</div>
    	</div>
		<div class="form-group">
      		<label class="control-label col-sm-2">Nomor HP:</label>
      		<div class="col-sm-10">
        		<input class="form-control" placeholder="Masukan Nomor HP" name="NomorHP" value="${NomorHP}">
      		</div>
    	</div>
    	<div class="form-group">
      		<label class="control-label col-sm-2">Email:</label>
      		<div class="col-sm-10">
        		<input class="form-control" placeholder="Masukan Email" name="Email" value="${Email}">
      		</div>
    	</div>
		
		<div class="form-group">
      		<div class="col-sm-offset-2 col-sm-10">
        		<input type="hidden" name="action" value="insert"><input class="btn btn-info" type="submit" value="Simpan"/></td> 
      		</div>
    	</div>
	</form>
	</div>
</body>
</html>