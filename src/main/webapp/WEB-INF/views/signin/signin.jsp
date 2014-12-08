<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<!--[if lt IE 9]>
    <script src="js/ie/html5shiv.js"></script>
    <script src="js/ie/respond.min.js"></script>
    <script src="js/ie/excanvas.js"></script>
  <![endif]-->
</head>
<body class="">
	<section id="content" class="m-t-lg wrapper-md animated fadeInUp">

	<div class="container aside-xl">
		<a class="navbar-brand block" href="index.html">Scale</a>
		<section class="m-b-lg"> <header class="wrapper text-center">
		<strong>Sign in to get in touch</strong> </header> <form:form
			action="${pageContext.request.contextPath}/login.do" method="POST">
			<div class="list-group">
				<c:if test="${not empty param.err}">
					<div th:if="${param.err}" class="alert alert-error">
						<spring:message code="login.error" />
					</div>
				</c:if>

				<div class="list-group-item">
					<input type="email" placeholder='<spring:message code="login.username"/>' name="username"
						class="form-control no-border">
				</div>
				<div class="list-group-item">
					<input type="password" placeholder='<spring:message code="login.password"/>' name="password"
						class="form-control no-border">
				</div>
			</div>
			<button type="submit" class="btn btn-lg btn-primary btn-block">Sign
				in</button>
			<div class="text-center m-t m-b">
				<a href="#"><small>Forgot password?</small></a>
			</div>
			<div class="line line-dashed"></div>
			<p class="text-muted text-center">
				<small>Do not have an account?</small>
			</p>
			<a href="<c:url value='user/signup'/>"
				class="btn btn-lg btn-default btn-block">Create an account</a>
		</form:form> </section>
	</div>
	</section>
	<!-- footer -->
	<footer id="footer">
	<div class="text-center padder">
		<p>
			<small>Web app framework base on Bootstrap<br>&copy;
				2013
			</small>
		</p>
	</div>
	</footer>
	<!-- / footer -->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
	<!-- App -->
	<script src="<%=request.getContextPath()%>/resources/js/app.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/app.plugin.js"></script>
</body>
</html>