<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html lang="en" class="app">
<head>
<meta charset="utf-8" />
<title>Scale | Web Application</title>
<meta name="description"
	content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/animate.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/font-awesome.min.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/icon.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/font.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/app.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/js/calendar/bootstrap_calendar.css"
	type="text/css" />
<!--[if lt IE 9]>
    <script src="js/ie/html5shiv.js"></script>
    <script src="js/ie/respond.min.js"></script>
    <script src="js/ie/excanvas.js"></script>
  <![endif]-->
</head>
<body class="">
	<section class="vbox">
		<tiles:insertAttribute name="header" />

		<section>
			<section class="hbox stretch">
				<!-- .aside -->
				<tiles:insertAttribute name="menu" />
				<!-- /.aside -->
				<section id="content">
					<section class="hbox stretch">
						<section>
							<section class="vbox">
								<section class="scrollable padder">
								
								<tiles:insertAttribute name="content" />
								
								
								</section>
							</section>
						</section>
						<!-- side content -->

						<!-- / side content -->
					</section>
					<a href="#" class="hide nav-off-screen-block"
						data-toggle="class:nav-off-screen" data-target="#nav"></a>
				</section>

				<a href="#" class="hide nav-off-screen-block"
					data-toggle="class:nav-off-screen" data-target="#nav"></a>
			</section>
		</section>
	</section>
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
	<!-- App -->
	<script src="<%=request.getContextPath()%>/resources/js/app.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/slimscroll/jquery.slimscroll.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/charts/easypiechart/jquery.easy-pie-chart.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/charts/sparkline/jquery.sparkline.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/charts/flot/jquery.flot.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/charts/flot/jquery.flot.tooltip.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/charts/flot/jquery.flot.spline.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/charts/flot/jquery.flot.pie.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/charts/flot/jquery.flot.resize.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/charts/flot/jquery.flot.grow.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/charts/flot/demo.js"></script>

	<script
		src="<%=request.getContextPath()%>/resources/js/calendar/bootstrap_calendar.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/calendar/demo.js"></script>

	<script
		src="<%=request.getContextPath()%>/resources/js/sortable/jquery.sortable.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/app.plugin.js"></script>
</body>
</html>