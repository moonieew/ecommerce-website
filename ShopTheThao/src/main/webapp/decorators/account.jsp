<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/assets" var="url"></c:url>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description"
	content="Start your development with a Dashboard for Bootstrap 4.">
<meta name="author" content="Creative Tim">
<title>Argon Dashboard - Free Dashboard for Bootstrap 4</title>
<!-- Favicon -->
<link rel="icon" href="${url}/img/brand/favicon.png" type="image/png">
<!-- Fonts -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700">
<!-- Icons -->
<link rel="stylesheet" href="${url}/vendor/nucleo/css/nucleo.css"
	type="text/css">
<link rel="stylesheet"
	href="${url}/vendor/@fortawesome/fontawesome-free/css/all.min.css"
	type="text/css">
<!-- Argon CSS -->
<link rel="stylesheet" href="${url}/css/argon.css"
	type="text/css">
</head>
<body>

	<!-- nav-bar -->
	<%@ include file="/common/account/navbar.jsp"%>
	<!-- end of nav-bar -->
	<!-- body -->
	<dec:body />
	<!-- end content -->
	<!-- footer -->
	<%@ include file="/common/account/footer.jsp"%>
	<!-- end of footer -->
	
	<!-- Argon Scripts -->
	<!-- Core -->
	<script src="${url}/vendor/jquery/dist/jquery.min.js"></script>
	<script
		src="${url}/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
	<script src="${url}/vendor/js-cookie/js.cookie.js"></script>
	<script src="${url}/vendor/jquery.scrollbar/jquery.scrollbar.min.js"></script>
	<script
		src="${url}/vendor/jquery-scroll-lock/dist/jquery-scrollLock.min.js"></script>
	<!-- Argon JS -->
	<script src="${url}/js/argon.js?v=1.2.0"></script>

</body>
</html>
