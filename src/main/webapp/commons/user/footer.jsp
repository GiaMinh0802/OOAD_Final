<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>
<c:url value="/templates/" var="URL"></c:url>
<c:url value="/home" var="home"></c:url>

<!-- Footer START -->
<footer class="bg-dark p-3">
	<div class="container">
		<div class="bg-dark rounded-top py-5 p-sm-5 mx-0">
    <div class="row g-4 align-items-center text-center text-lg-start">
			<!-- Copyright -->
			<div class="col-lg-5">
				<ul class="nav list-inline text-primary-hover justify-content-center justify-content-lg-start mb-0">
					<li class="list-inline-item"><a class="nav-link text-muted" href="#">About</a></li>
					<li class="list-inline-item"><a class="nav-link text-muted" href="#">Policy</a></li>
					<li class="list-inline-item"><a class="nav-link text-muted pe-0" href="#">Terms & Condition</a></li>
				</ul>
			</div>
			
			<!-- Logo -->
			<div class="col-lg-3 text-center">
				<!-- Logo -->
				<a class="me-0" href="${home}">
					<img class="h-60px" src="${URL}images/logo-light.svg" alt="footer logo">
				</a>
				<div class="text-muted text-primary-hover mt-3"> Copyrights <a href="#" class="text-muted">Â©2022 Booking</a>. All rights reserved. </div>
			</div>

			<!-- Social links -->
			<div class="col-lg-4">
				<ul class="nav text-primary-hover hstack gap-2 justify-content-center justify-content-lg-end">
					<li class="nav-item">
						<a class="nav-link fs-5 text-muted" href="#"><i class="fab fa-facebook-f"></i></a>
					</li>
					<li class="nav-item">
						<a class="nav-link fs-5 text-muted" href="#"><i class="fab fa-twitter"></i></a>
					</li>
					<li class="nav-item">
						<a class="nav-link fs-5 text-muted" href="#"><i class="fab fa-instagram"></i></a>
					</li>
					<li class="nav-item">
						<a class="nav-link fs-5 text-muted" href="#"><i class="fab fa-linkedin-in"></i></a>
					</li>
					<li class="nav-item">
						<a class="nav-link fs-5 text-muted" href="#"><i class="fab fa-github"></i></a>
					</li>
				</ul>
			</div>
		</div>
    </div>
	</div>
</footer>
<!-- Footer END -->