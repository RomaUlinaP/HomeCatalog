<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Data Rumah - Katalog Rumah</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="JualRumah.jsp" />
	<div class="container">
  	<h3>Form Update Data</h3>
	<form class="form-horizontal" action="ActionController" method="post">
		<div class="form-group">
      		<label class="control-label col-sm-2">Nama Rumah:</label>
      		<div class="col-sm-10">
        		<input class="form-control" name="NamaRumah" value="${rumah.nama}">
      		</div>
    	</div>
    		<form class="form-horizontal" action="ActionController" method="post">
		<div class="form-group">
      		<label class="control-label col-sm-2">Status:</label>
      		<div class="col-sm-10">
        		<input class="form-control" name="NamaRumah" value="${rumah.status}">
      		</div>
    	</div>
    	<div class="form-group">
      		<label class="control-label col-sm-2">Alamat:</label>
      		<div class="col-sm-10">
        		<input class="form-control" name="Alamat" value="${rumah.alamat}">
      		</div>
    	</div>
		<div class="form-group">
      		<label class="control-label col-sm-2">Provinsi:</label>
      		<div class="col-sm-10">
        		<input class="form-control" name="Provinsi" value="${rumah.provinsi}">
      		</div>
    	</div>
		<div class="form-group">
      		<label class="control-label col-sm-2">Harga:</label>
      		<div class="col-sm-10">
        		<input class="form-control" name="Harga" value="${rumah.harga}">
      		</div>
    	</div>
		<div class="form-group">
      		<label class="control-label col-sm-2">Panjang:</label>
      		<div class="col-sm-10">
        		<input class="form-control" name="Panjang" value="${rumah.ukuran.panjang}">
      		</div>
    	</div>
		<div class="form-group">
      		<label class="control-label col-sm-2">Lebar:</label>
      		<div class="col-sm-10">
        		<input class="form-control" name="Lebar" value="${rumah.ukuran.lebar}">
      		</div>
    	</div>
    	<div class="form-group">
      		<label class="control-label col-sm-2">Kamar Tidur:</label>
      		<div class="col-sm-10">
        		<input class="form-control" name="KamarTidur" value="${rumah.fasilitas.kamarTidur}">
      		</div>
    	</div>
		<div class="form-group">
      		<label class="control-label col-sm-2">Kamar Mandi:</label>
      		<div class="col-sm-10">
        		<input class="form-control" name="KamarMandi" value="${rumah.fasilitas.kamarMandi}">
      		</div>
    	</div>
		<div class="form-group">
      		<label class="control-label col-sm-2">Garasi:</label>
      		<div class="col-sm-10">
        		<input class="form-control" name="Garasi" value="${rumah.fasilitas.garasi}">
      		</div>
    	</div>
    	<div class="form-group">
      		<label class="control-label col-sm-2">Dapur:</label>
      		<div class="col-sm-10">
        		<input class="form-control" name="Dapur" value="${rumah.fasilitas.dapur}">
      		</div>
    	</div>
    	<div class="form-group">
      		<label class="control-label col-sm-2">Halaman Belakang:</label>
      		<div class="col-sm-10">
        		<input class="form-control" name="HalamanBelakang" value="${rumah.fasilitas.halamanBelakang}">
      		</div>
    	</div>
    
		<div class="form-group">
      		<div class="col-sm-offset-2 col-sm-10">
      			<input type="hidden" name="row" value="${student.vRow}">
        		<input type="hidden" name="action" value="update"><input class="btn btn-info" type="submit" value="Simpan"/></td> 
      		</div>
    	</div>
	</form>
	</div>
</body>
</html>