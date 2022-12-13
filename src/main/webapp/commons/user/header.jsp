<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>
<c:url value="/templates/" var="URL"></c:url>
<c:url value="/home" var="home"></c:url>

<!-- Header START -->
<header class="navbar-light header-sticky">
	<!-- Logo Nav START -->
	<nav class="navbar navbar-expand-xl">
		<div class="container">
			<!-- Logo START -->
			<a class="navbar-brand" href="${home}">
				<img class="light-mode-item navbar-brand-item" src="${URL}images/logo.svg" alt="logo">
				<img class="dark-mode-item navbar-brand-item" src="${URL}images/logo-light.svg" alt="logo">
			</a>
			<!-- Logo END -->
			
			<!-- Responsive navbar toggler -->
			<button class="navbar-toggler ms-auto mx-3 me-xl-0 p-0 p-sm-1" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-animation">
					<span></span>
					<span></span>
					<span></span>
				</span>
			</button>

			<!-- Main navbar START -->
			<div class="navbar-collapse collapse" id="navbarCollapse">
				<ul class="navbar-nav navbar-nav-scroll me-auto">
				</ul>
				<!-- Nav main menu START -->
				<ul class="navbar-nav navbar-nav-scroll me-auto">
					<!-- Nav item Listing -->
					<li class="nav-item">
						<a class="nav-link" href="${home}">Home</a>
					</li>

					<li class="nav-item">
						<a class="nav-link" href="myprofile">My Profile</a>
					</li>

					<li class="nav-item">
						<a class="nav-link" href="mybooking">My Bookings</a>
					</li>
				</ul>
				<!-- Nav main menu END -->
			</div>
			<!-- Main navbar END -->

			<c:if test="${account != null}">
			<!-- Profile and Notification START -->
			<ul class="nav flex-row align-items-center list-unstyled ms-xl-auto">
			<!-- Search dropdown START -->
			<li class="nav-item dropdown nav-search me-3 d-none d-sm-block">
				<a class="nav-notification btn btn-light mb-0 p-0" href="#" id="searchDropdown" role="button" data-bs-auto-close="outside" data-bs-display="static" data-bs-toggle="dropdown" aria-expanded="false">
					<i class="bi bi-search"> </i>
				</a>
				<div class="dropdown-menu dropdown-animation dropdown-menu-end p-2" aria-labelledby="searchDropdown">
					<div class="nav flex-nowrap align-items-center">
						<div class="nav-item w-100">
							<form class="input-group">
								<input class="form-control border-primary" type="search" placeholder="Search..." aria-label="Search">
								<button class="btn btn-primary m-0" type="submit">Search</button>
							</form>
						</div>
					</div>
				</div>
			</li>
			<!-- Search dropdown END -->
			
			<!-- Notification dropdown START -->
			<li class="nav-item dropdown me-3">
				<!-- Notification button -->
				<a class="nav-notification btn btn-light p-0 mb-0" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" data-bs-auto-close="outside">
					<i class="bi bi-bell fa-fw"></i>
				</a>
				<!-- Notification dote -->
				<span class="notif-badge animation-blink"></span>
			
				<!-- Notification dropdown menu START -->
				<div class="dropdown-menu dropdown-animation dropdown-menu-end dropdown-menu-size-md shadow-lg p-0">
					<div class="card bg-transparent">
						<!-- Card header -->
						<div class="card-header bg-transparent d-flex justify-content-between align-items-center border-bottom">
							<h6 class="m-0">Notifications <span class="badge bg-danger bg-opacity-10 text-danger ms-2">4 new</span></h6>
							<a class="small" href="#">Clear all</a>
						</div>
			
						<!-- Card body START -->
						<div class="card-body p-0">
							<ul class="list-group list-group-flush list-unstyled p-2">
								<!-- Notification item -->
								<li>
									<a href="#" class="list-group-item list-group-item-action rounded notif-unread border-0 mb-1 p-3">
										<h6 class="mb-2">New! Booking flights from New York ✈️</h6>
										<p class="mb-0 small">Find the flexible ticket on flights around the world. Start searching today</p>
										<span>Wednesday</span>
									</a>
								</li>
								<!-- Notification item -->
								<li>
									<a href="#" class="list-group-item list-group-item-action rounded border-0 mb-1 p-3">
										<h6 class="mb-2">Sunshine saving are here 🌞 save 30% or more on a stay</h6>
										<span>15 Nov 2022</span>
									</a>
								</li>
							</ul>
						</div>
						<!-- Card body END -->
			
						<!-- Card footer -->
						<div class="card-footer bg-transparent text-center border-top">
							<a href="#" class="btn btn-sm btn-link mb-0 p-0">See all incoming activity</a>
						</div>
					</div>
				</div>
				<!-- Notification dropdown menu END -->
			</li>
			<!-- Notification dropdown END -->
			<!-- Profile dropdown START -->
			<li class="nav-item dropdown">
				<!-- Avatar -->
				<a class="avatar avatar-sm p-0" href="#" id="profileDropdown" role="button" data-bs-auto-close="outside" data-bs-display="static" data-bs-toggle="dropdown" aria-expanded="false">
					<img class="avatar-img rounded-2" src="${URL}images/avatar/01.jpg" alt="avatar">
				</a>
			
				<ul class="dropdown-menu dropdown-animation dropdown-menu-end shadow pt-3" aria-labelledby="profileDropdown">
					<!-- Profile info -->
					<li class="px-3 mb-3">
						<div class="d-flex align-items-center">
							<!-- Avatar -->
							<div class="avatar me-3">
								<img class="avatar-img rounded-circle shadow" src="${URL}images/avatar/01.jpg" alt="avatar">
							</div>
							<div>
								<a class="h6 mt-2 mt-sm-0" href="myprofile">${user.nameUS}</a>
								<p class="small m-0">${account.email}</p>
							</div>
						</div>
					</li>
			
					<!-- Links -->
					<li> <hr class="dropdown-divider"></li>
					<li><a class="dropdown-item" href="myprofile"><i class="bi bi-person fa-fw me-2"></i>My Profile</a></li>
					<li><a class="dropdown-item" href="mybooking"><i class="bi bi-ticket-perforated fa-fw me-2"></i>My Bookings</a></li>
					<li><a class="dropdown-item bg-danger-soft-hover" href="sign-out"><i class="bi bi-power fa-fw me-2"></i>Sign Out</a></li>
					<li> <hr class="dropdown-divider"></li>
			
					<!-- Dark mode switch START -->
					<li>
						<div class="modeswitch-wrap" id="darkModeSwitch">
							<div class="modeswitch-item">
								<div class="modeswitch-icon"></div>
							</div>
							<span>Dark mode</span>
						</div>
					</li> 
					<!-- Dark mode switch END -->
				</ul>
			</li>
			<!-- Profile dropdown END -->
			</ul>
			<!-- Profile and Notification START -->
			</c:if>

			<c:if test="${account == null}">
			<!-- Navbar right side START -->
			<ul class="nav flex-row align-items-center list-unstyled ms-xl-auto">
				<!-- Dark mode switch -->
				<li class="nav-item modeswitch-mini me-2" id="darkModeSwitch">
					<div class="modeswitch-mini-item">
						<div class="modeswitch-mini-icon"></div>
					</div>
				</li>

				<!-- Search -->
				<li class="nav-item dropdown nav-search me-2">
					<a class="nav-link mb-0 py-0" role="button" href="#" id="navSearch" data-bs-toggle="dropdown" aria-expanded="false" data-bs-auto-close="outside" data-bs-display="static">
						<i class="bi bi-search fs-5"> </i>
					</a>
					<div class="dropdown-menu dropdown-menu-end shadow rounded p-2" aria-labelledby="navSearch">
						<form class="input-group">
							<input class="form-control border-primary" type="search" placeholder="Search..." aria-label="Search">
							<button class="btn btn-primary m-0" type="submit">Search</button>
						</form>
					</div>
				</li>

				<!-- Sign In button -->
				<li class="nav-item ms-2 d-none d-sm-block">
					<a href="sign-in" class="btn btn-sm btn-primary-soft mb-0"><i class="fa-solid fa-right-to-bracket me-2"></i>Sign In</a>
				</li>
			</ul>
			<!-- Navbar right side END -->
			</c:if>
		</div>
	</nav>
	<!-- Logo Nav END -->
</header>
<!-- Header END -->

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- Vendors -->
<script src="https://cdn.jsdelivr.net/npm/choices.js/public/assets/scripts/choices.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/flatpickr/4.6.13/flatpickr.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/15.6.1/nouislider.min.js"></script>

<!-- ThemeFunctions -->
<script src="${URL}js/functions.js"></script>
