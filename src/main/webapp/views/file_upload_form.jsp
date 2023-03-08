<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.btn {
	border: none; /* Remove borders */
	color: white; /* Add a text color */
	padding: 14px 28px; /* Add some padding */
	cursor: pointer; /* Add a pointer cursor on mouse-over */
}

.button {
	background-color: #04AA6D;
	border: none;
	color: white;
	padding: 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
}

.button1 {
	background-color: purple;
	border: none;
	color: white;
	padding: 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	border: none;
}

.button4 {
	border-radius: 12px;
}

.success {
	background-color: #04AA6D;
} /* Green */
</style>
<meta charset="ISO-8859-1">
<title>File UploadPage</title>
</head>
<body background="images/Dhoni.jpg"
	style="background-repeat: no-repeat; background-position: top; background-attachment: fixed; background-size: cover;">

	<h1 style="color: green;" align="center">File Upload Page</h1>
	<h3 style="color: red;">${alertMesg}</h3>
	<form action="/fileSubmit" method="post" name="fileUpload"
		enctype="multipart/form-data">
		<h3 align="center" style="color: black;">
			<input type="file" name="file" id="file" accept="text/xml"
				size="10240" multiple="multiple" />
		</h3>
		<h3 align="center">
			<input type="submit" value="Upload File" />
		</h3>
	</form>
	<form action="/getAllDetails">
		<h3 style="color: blue;" align="center">
			<button class="button1 button4">Get Channel Details</button>
		</h3>
	</form>
	<form action="/createEPG">
		<h1 style="color: green;" align="center">
			<button class="button button4">Create EPG Channel</button>
		</h1>
	</form>
</body>



</html>