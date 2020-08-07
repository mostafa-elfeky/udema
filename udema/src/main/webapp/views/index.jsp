<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<%@ include file="tiles/header.jsp"%>
<body>
	<div id="page">
		<main>
		<%@ include file="/views/tiles/menu.jsp"%>
		<section class="hero_single version_2">
			<div class="wrapper">
				<div class="container">
					<h3>What would you learn?</h3>
					<p>Increase your expertise in business, technology and personal
						development</p>
					<form method="get"
						action="${pageContext.request.contextPath}/courses">
						<div id="custom-search-input">
							<div class="input-group">
								<input type="text" class=" search-query"
									placeholder="Ex. Development, Design..."> <input
									type="submit" class="btn_search" value="Search">
							</div>
						</div>
					</form>
				</div>
			</div>
		</section>
		<!-- /hero_single -->

		<div class="features clearfix">
			<div class="container">
				<ul>
					<li><i class="pe-7s-study"></i>
						<h4>+200 courses</h4>
						<span>Explore a variety of fresh topics</span></li>
					<li><i class="pe-7s-cup"></i>
						<h4>Expert teachers</h4>
						<span>Find the right instructor for you</span></li>
					<li><i class="pe-7s-target"></i>
						<h4>Focus on target</h4>
						<span>Increase your personal expertise</span></li>
				</ul>
			</div>
		</div>
		<!-- /features -->

		<div class="container-fluid margin_120_0">
			<div class="main_title_2">
				<span><em></em></span>
				<h2>Udema Popular Courses</h2>
				<p>Cum doctus civibus efficiantur in imperdiet deterruisset.</p>
			</div>
			<div id="reccomended" class="owl-carousel owl-theme">
				<c:forEach items="${courses}" var="course">
				<div class="item">
					<div class="box_grid">
						<figure>
							<a href="#0" class="wish_bt"></a>
							<a href="course-detail.html">
								<div class="preview">
									<span>Preview course</span>
								</div>
								<img src="${course.image}" class="img-fluid" alt="">
							</a>
						</figure>
						<div class="wrapper">
							<small>${course.category.name}</small>
							<h3>${course.title}</h3>
							<p>${course.description}</p>
							<div class="rating">
								<i
									class="icon_star ${course.statistics.reviewRate ge 1 ? 'voted' : ''}"></i>
								<i
									class="icon_star ${course.statistics.reviewRate ge 2 ? 'voted' : ''}"></i>
								<i
									class="icon_star ${course.statistics.reviewRate ge 3 ? 'voted' : ''}"></i>
								<i
									class="icon_star ${course.statistics.reviewRate ge 4 ? 'voted' : ''}"></i>
								<i
									class="icon_star ${course.statistics.reviewRate ge 5 ? 'voted' : ''}"></i>
								<small>(${course.statistics.reviewCount})</small>
							</div>
						</div>
						<ul>
							<li><i class="icon_clock_alt"></i>
								${course.statistics.contentTotalTime}</li>
							<li><i class="icon-user-add"></i>
								${course.statistics.enrollmentCount}</li>
							<sec:authorize access="hasAuthority('STUDENT')">
								<li><a href="course-detail.html">Enroll now</a></li>
							</sec:authorize>
						</ul>
					</div>
				</div>
				</c:forEach>
			</div>
			<!-- /carousel -->
			<div class="container">
				<p class="btn_home_align">
					<a href="${pageContext.request.contextPath}/courses" class="btn_1 rounded">View all
						courses</a>
				</p>
			</div>
			<!-- /container -->
			<hr>
		</div>
		<!-- /container -->

		<div class="container margin_30_95">
			<div class="main_title_2">
				<span><em></em></span>
				<h2>Udema Categories Courses</h2>
				<p>Cum doctus civibus efficiantur in imperdiet deterruisset.</p>
			</div>
			<div class="row">
				<c:forEach items="${categories}" var="catgory">
					<div class="col-lg-4 col-md-6 wow" data-wow-offset="150">
						<a href="#0" class="grid_item">
							<figure class="block-reveal">
								<div class="block-horizzontal"></div>
								<img
									src="https://www.talentedge.co.nz/wp-content/uploads/2019/04/TE-Title-Development.png"
									class="img-fluid" alt="">
								<div class="info">
									<h3>${catgory.name}</h3>
								</div>
							</figure>
						</a>
					</div>
				</c:forEach>
			</div>
			<!-- /row -->
		</div>
		<!-- /container --> 
		</main>
		<!-- /main -->
	</div>
	<%@ include file="tiles/footer.jsp"%>
</body>
