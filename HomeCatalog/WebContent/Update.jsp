<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Data - Katalog Rumah</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="JualRumah.jsp" />
	<div class="container">
  	<h3>Form Data Pemilik</h3>
  	<form class="form-horizontal" action="ActionController" method="post">
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
      			<input type="hidden" name="action" value="search"><input class="btn btn-info" type="submit" value="Cari Data Rumah"/></td>
      		</div>
    	</div>
    </form>
    </div>
</body>
</html>