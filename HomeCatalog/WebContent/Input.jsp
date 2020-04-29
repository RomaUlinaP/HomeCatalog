<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ActionController" method="post">
		Enter Nama Rumah					:<input type="text" name="NamaRumah"> 		<BR>
		Enter Status (Belum Terjual/Terjual):<input type="text" name="Status"> 			<BR>
		Enter Alamat 						:<input type="text" name="Alamat"> 			<BR>
		Enter Provinsi 						:<input type="text" name="Provinsi"> 		<BR>
		Enter Harga 						:<input type="text" name="Harga"> 			<BR>
		Enter Panjang (m)					:<input type="text" name="Panjang"> 		<BR>
		Enter Lebar (m)						:<input type="text" name="Lebar"> 			<BR>
		Enter Jumlah Kamar Tidur 			:<input type="text" name="KamarTidur"> 		<BR>
		Enter Jumlah Kamar Mandi 			:<input type="text" name="KamarMandi"> 		<BR>
		Enter Jumlah Garasi 				:<input type="text" name="Garasi"> 			<BR>
		Enter Jumlah Dapur 					:<input type="text" name="Dapur"> 			<BR>
	    Enter Jumlah Halaman Belakang 		:<input type="text" name="HalamanBelakang"> <BR>
		Enter Nama Pemilik 					:<input type="text" name="NamaPemilik"> 	<BR>
		Enter Nomor HP 						:<input type="text" name="NomorHP"> 		<BR>
		Enter Email 						:<input type="text" name="Email"> 			<BR>
		<input type="hidden" name="action" value="insert">
		<input type="submit" />
	</form>
</body>
</html>