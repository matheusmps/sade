<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="favicon.ico">
	
	<title>SADE- Conpec</title>
	
	<link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet">
	<link href="<c:url value='/static/css/ie10-viewport-bug-workaround.css' />" rel="stylesheet">
	<link href="<c:url value='/static/css/jumbotron.css' />" rel="stylesheet">
	<link href="<c:url value='/static/css/globalstyle.css' />" rel="stylesheet">
	<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
	<script src="scripts/ie-emulation-modes-warning.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="scripts/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="scripts/ie10-viewport-bug-workaround.js"></script>
	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>

<script>
   //Verify the document height to size the bg image
   $(document).ready(function(){
       var docHeight = ($(document).height());
       $('.main').css('min-height',docHeight-115);
   });
</script>