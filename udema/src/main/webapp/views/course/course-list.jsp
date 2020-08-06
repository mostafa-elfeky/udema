
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="/views/tiles/header.jsp" %>
	
	<main>
		<section id="hero_in" class="courses">
			<div class="wrapper">
				<div class="container">
					<h1 class="fadeInUp"><span></span>Online courses</h1>
				</div>
			</div>
		</section>
		<!--/hero_in-->
		<div class="filters_listing sticky_horizontal">
			<form:form method="get" action="${pageContext.request.contextPath}/courses" modelAttribute="filter">
				<form:input type="hidden" path="keyword"></form:input>
				<div class="container">
					<ul class="clearfix">
						<li>
							<div class="switch-field">
								<form:radiobutton id="all" path="listingType" value="ALL" onchange="this.form.submit()"/>
								<label for="all">All</label>
								<form:radiobutton id="popular" path="listingType" value="POPULAR" onchange="this.form.submit()"/>
								<label for="popular">Popular</label>
								<form:radiobutton id="latest" path="listingType" value="LATEST" onchange="this.form.submit()"/>
								<label for="latest">Latest</label>
							</div>
						</li>
						<li>
							<form:select path="category" class="selectbox" onchange="this.form.submit()">
								<option value="">category</option>
								<form:options itemValue="id" items="${categories}"  itemLabel="name"/>
							</form:select>
						</li>
					</ul>
				</div>
			</form:form>
			<!-- /container -->
		</div>
		<!-- /filters -->
		<div class="container margin_60_35">
			<div class="row">
			<c:forEach var="course" items="${courses}">
			<div class="col-xl-4 col-lg-6 col-md-6">
				<div class="box_grid wow">
					<figure class="block-reveal">
						<div class="block-horizzontal"></div>
						<a href="${pageContext.request.contextPath}/courses/${course.id}"><img src="${course.image}" class="img-fluid" alt=""></a>
						<div class="preview"><span>Preview course</span></div>
					</figure>
					<div class="wrapper">
						<small>${course.category.name}</small>
						<h3>${course.title}</h3>
						<p>${course.description}</p>
						<div class="rating">
							<i class="icon_star ${course.statistics.reviewRate ge 1 ? 'voted' : ''}"></i>
							<i class="icon_star ${course.statistics.reviewRate ge 2 ? 'voted' : ''}"></i>
							<i class="icon_star ${course.statistics.reviewRate ge 3 ? 'voted' : ''}"></i>
							<i class="icon_star ${course.statistics.reviewRate ge 4 ? 'voted' : ''}"></i>
							<i class="icon_star ${course.statistics.reviewRate ge 5 ? 'voted' : ''}"></i> 
							<small>(${course.statistics.reviewCount})</small></div>
					</div>
					<ul>
						<li><i class="icon_clock_alt"></i> ${course.statistics.contentTotalTime}</li>
						<li><i class="icon-user-add"></i> ${course.statistics.enrollmentCount}</li>
						<sec:authorize access="hasAuthority('STUDENT')">
							<li><a href="course-detail.html">Enroll now</a></li>
						</sec:authorize>
					</ul>
				</div>
				</div>
			</c:forEach>
			</div>
		</div>
		<!-- /container -->
		<div class="bg_color_1">
			<div class="container margin_60_35">
				<div class="row">
					<div class="col-md-4">
						<a href="#0" class="boxed_list">
							<i class="pe-7s-help2"></i>
							<h4>Need Help? Contact us</h4>
							<p>Cum appareat maiestatis interpretaris et, et sit.</p>
						</a>
					</div>
					<div class="col-md-4">
						<a href="#0" class="boxed_list">
							<i class="pe-7s-wallet"></i>
							<h4>Payments and Refunds</h4>
							<p>Qui ea nemore eruditi, magna prima possit eu mei.</p>
						</a>
					</div>
					<div class="col-md-4">
						<a href="#0" class="boxed_list">
							<i class="pe-7s-note2"></i>
							<h4>Quality Standards</h4>
							<p>Hinc vituperata sed ut, pro laudem nonumes ex.</p>
						</a>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /bg_color_1 -->
	</main>
	<!--/main-->
<%@ include file="/views/tiles/footer.jsp" %>