<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/assets" var="url"></c:url>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Admin</title>
  <!-- Favicon -->
  <link rel="icon" href="${url}/img/brand/favicon.png" type="image/png" />
  <!-- Fonts -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" />
  <!-- Icons -->
  <link rel="stylesheet" href="${url}/vendor/nucleo/css/nucleo.css"
    type="text/css" />
  <link rel="stylesheet"
    href="${url}/vendor/@fortawesome/fontawesome-free/css/all.min.css"
    type="text/css" />
  <!-- Page plugins -->
  <!-- Argon CSS -->
  <link rel="stylesheet" href="${url}/css/argon.css" type="text/css" />
</head>

<body>
	<%@ include file="/common/admin/slidenav.jsp"%>

  <!-- Main content -->
  <div class="main-content" id="panel">
  	<!-- Top nav -->
    <%@ include file="/common/admin/topnav.jsp"%>
    <!-- Header -->
    <%@ include file="/common/admin/header.jsp"%>
    <!-- Body -->
    <dec:body />
    <!-- Footer -->
    <%@ include file="/common/admin/footer.jsp"%>
  </div>

  <!-- Argon Scripts -->
  <!-- Core -->
  <script src="${url}/vendor/jquery/dist/jquery.min.js"></script>
  <script src="${url}/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
  <script src="${url}/vendor/js-cookie/js.cookie.js"></script>
  <script src="${url}/vendor/jquery.scrollbar/jquery.scrollbar.min.js"></script>
  <script
    src="${url}/vendor/jquery-scroll-lock/dist/jquery-scrollLock.min.js"></script>
  <!-- Optional JS -->
  <script src="${url}/vendor/chart.js/dist/Chart.min.js"></script>
  <script src="${url}/vendor/chart.js/dist/Chart.extension.js"></script>
  <!-- Argon JS -->
  <script src="${url}/js/argon.js"></script>
</body>

</html>