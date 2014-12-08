<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Diary</title>
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
	<section id="content" class="m-t-lg wrapper-md animated fadeInDown">
	<div class="container aside-xl">
		<a class="navbar-brand block" href="index.html">Scale</a>
		<section class="m-b-lg"> <header class="wrapper text-center">
		<strong>Sign up to find interesting thing</strong> </header> <form:form
			action="${pageContext.request.contextPath}/user/signup"
			commandName="user">
			<div class="list-group">
				<div class="list-group-item">
					<form:input path="username" placeholder='<spring:message code="register.username"/>' class="form-control no-border"
						name="username"/>
					<form:errors path="username" />
				</div>
				<div class="list-group-item">
					<form:input path="email" placeholder='<spring:message code="register.email"/>' name="email"
						class="form-control no-border"/>
					<form:errors path="email" />
				</div>
				<div class="list-group-item">
					<form:input path="password" placeholder='<spring:message code="register.password"/>'
						class="form-control no-border" name="password"/>
					<form:errors path="password" />
				</div>
				<div class="list-group-item">
					<form:input path="password" placeholder='<spring:message code="register.passwordConfirm"/>'
						class="form-control no-border" name="passwordConfirm"/>
					<form:errors path="passwordConfirm" />
				</div>
			</div>
			<div class="checkbox m-b">
				<label> <input type="checkbox"> Agree the <a
					href="#">terms and policy</a>
				</label>
			</div>
			<button type="submit" class="btn btn-lg btn-primary btn-block">Sign
				up</button>
			<div class="line line-dashed"></div>
			<p class="text-muted text-center">
				<small>Already have an account?</small>
			</p>
			<a href="<c:url value='/login'/>"
				class="btn btn-lg btn-default btn-block">Sign in</a>
		</form:form> </section>
	</div>
	</section>
	<!-- footer -->
	<footer id="footer">
	<div class="text-center padder clearfix">
		<p>
			<small>Web app framework base on Bootstrap<br>&copy;
				2013
			</small>
		</p>
	</div>
	</footer>
	<!-- / footer -->
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