<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<header class="header menu_2">
	<div id="preloader">
		<div data-loader="circle-side"></div>
	</div>
	<!-- /Preload -->
	<div id="logo">
		<a href="index.html"><img
			src="${pageContext.request.contextPath}/resources/img/logo.png"
			width="149" height="42" data-retina="true" alt=""></a>
	</div>
	<ul id="top_menu">
		
		<li><a href="${pageContext.request.contextPath}/login"
				class="login">Login</a></li>
		
		<li><a href="#0" class="search-overlay-menu-btn">Search</a></li>
		
		<li class="hidden_tablet"><a
			href="${pageContext.request.contextPath}/logout"
			class="btn_1 rounded">Logout</a></li>
	
	
		<li class="hidden_tablet"><a href="admission.html"
			class="btn_1 rounded">Register</a></li>
		
	</ul>
	<!-- /top_menu -->
	<a href="#menu" class="btn_mobile">
		<div class="hamburger hamburger--spin" id="hamburger">
			<div class="hamburger-box">
				<div class="hamburger-inner"></div>
			</div>
		</div>
	</a>
	<nav id="menu" class="main-menu">
		<ul>
			<li><span><a href="${pageContext.request.contextPath}/">Home</a></span></li>
			<li><span><a href="#0">Categories</a></span>
				<ul>
					<c:forEach items="${categories}" var="category">
						<li><a
							href="${pageContext.request.contextPath}/courses?categoryId=${category.id}">${category.name}</a></li>
					</c:forEach>
				</ul></li>
			<li><span><a href="#0">Blog</a></span></li>
			<li><span><a href="#0">Instructor</a></span></li>
			<li><span><a href="#0">About</a></span></li>
		</ul>
	</nav>
	<!-- Search Menu -->
	<div class="search-overlay-menu">
		<span class="search-overlay-close"><span class="closebt"><i
				class="ti-close"></i></span></span>
		<form role="search" id="searchform" method="get">
			<input value="" name="q" type="search" placeholder="Search..." />
			<button type="submit">
				<i class="icon_search"></i>
			</button>
		</form>
	</div>
	<!-- End Search Menu -->
</header>


