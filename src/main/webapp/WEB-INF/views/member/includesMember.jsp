<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="favicon.ico">
	
	<title>SADE- Conpec</title>
	 
	 <!-- Bootstrap core CSS -->
	<link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet" />
	
	<!-- Custom styles for this template -->
	<link href="<c:url value='/static/css/jumbotron.css' /> " rel="stylesheet" />
	
	<!-- Bootstrap core CSS -->
	<link href="<c:url value='/static/css/globalstyle.css' />" rel="stylesheet" />
	
	<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
	<script src="<c:url value='/static/scripts/ie-emulation-modes-warning.js' />" ></script>
	
	<script src="<c:url value='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js' />" ></script>
	<script src="<c:url value='/static/scripts/bootstrap.min.js' />" ></script>
	
	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
</head>

<script>
	$(document).ready(function(){
	    var docHeight = ($(document).height());
	    $('.main').css('min-height',docHeight-115);
	});
</script>
