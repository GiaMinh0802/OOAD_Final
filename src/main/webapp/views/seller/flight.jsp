<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp" %>
<c:url value="/templates/" var="URL"></c:url>
<c:url value="/home" var="home"></c:url>
<body class="dashboard">
	
<!-- **************** MAIN CONTENT START **************** -->
<main>
	
<!-- =======================
Content START -->
<section class="pt-3 pb-8">
	<div class="container">
		<div class="row">

			<!-- Sidebar START -->
			<div class="col-lg-4 col-xl-3">
				<!-- Responsive offcanvas body START -->
				<div class="offcanvas-lg offcanvas-end" tabindex="-1" id="offcanvasSidebar" >
					<!-- Offcanvas header -->
					<div class="offcanvas-header justify-content-end pb-2">
						<button type="button" class="btn-close" data-bs-dismiss="offcanvas" data-bs-target="#offcanvasSidebar" aria-label="Close"></button>
					</div>

					<!-- Offcanvas body -->
					<div class="offcanvas-body p-3 p-lg-0">
						<div class="card bg-light w-100">

							<!-- Edit profile button -->
							<div class="position-absolute top-0 end-0 p-3">
								<a href="myprofile" class="text-primary-hover" data-bs-toggle="tooltip" data-bs-title="Edit profile">
									<i class="bi bi-pencil-square"></i>
								</a>
							</div>

							<!-- Card body START -->
							<div class="card-body p-3">
								<!-- Avatar and content -->
								<div class="text-center mb-3">
									<!-- Avatar -->
									<div class="avatar avatar-xl mb-2">
										<img class="avatar-img rounded-circle border border-2 border-white" src="${URL}images/avatar/01.jpg" alt="">
									</div>
									<h6 class="mb-0">${user.nameUS}</h6>
									<p class="text-reset text-primary-hover small">${account.email}</p>
									<hr>
								</div>

								<!-- Sidebar menu item START -->
								<ul class="nav nav-pills-primary-soft flex-column">
									<li class="nav-item">
										<a class="nav-link" href="myprofile"><i class="bi bi-person fa-fw me-2"></i>My Profile</a>
									</li>
									<li class="nav-item">
										<a class="nav-link active" href="mybooking"><i class="bi bi-ticket-perforated fa-fw me-2"></i>My Bookings</a>
									</li>
									<li class="nav-item">
										<a class="nav-link text-danger bg-danger-soft-hover" href="sign-out"><i class="fas fa-sign-out-alt fa-fw me-2"></i>Sign Out</a>
									</li>
								</ul>
								<!-- Sidebar menu item END -->
							</div>
							<!-- Card body END -->
						</div>
					</div>
				</div>	
				<!-- Responsive offcanvas body END -->	
			</div>
			<!-- Sidebar END -->

			<!-- Main content START -->
			<div class="col-lg-8 col-xl-9">

				<!-- Offcanvas menu button -->
				<div class="d-grid mb-0 d-lg-none w-100">
					<button class="btn btn-primary mb-4" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasSidebar" aria-controls="offcanvasSidebar">
						<i class="fas fa-sliders-h"></i> Menu
					</button>
				</div>

					<div class="vstack gap-4">
	
					<div class="card border bg-transparent">
						<!-- Card header -->
						<div class="card-header bg-transparent border-bottom">
							<h4 class="card-header-title">My Bookings</h4>
						</div>
	
						<!-- Card body START -->
						<div class="card-body p-0">
	
							<!-- Tabs -->
							<ul class="nav nav-tabs nav-bottom-line nav-responsive nav-justified">
								<li class="nav-item"> 
									<a class="nav-link mb-0 active" data-bs-toggle="tab" href="#tab-1"><i class="bi bi-briefcase-fill fa-fw me-1"></i>Upcoming Booking</a> 
								</li>
								<li class="nav-item">
									<a class="nav-link mb-0" data-bs-toggle="tab" href="#tab-2"><i class="bi bi-x-octagon fa-fw me-1"></i>Canceled Booking</a> 
									</li>
								<li class="nav-item"> 
									<a class="nav-link mb-0" data-bs-toggle="tab" href="#tab-3"><i class="bi bi-patch-check fa-fw me-1"></i>Completed Booking</a> 
								</li>
							</ul>
	
							<!-- Tabs content START -->
							<div class="tab-content p-2 p-sm-4" id="nav-tabContent">
	
								<!-- Tab content item START -->
								<div class="tab-pane fade show active" id="tab-1">
									<h6>${upcoming.size() != 0 ? 'Upcoming Booking ('.concat(upcoming.size()).concat(')'):''}</h6>
									<c:forEach items="${upcoming}" var="uc">
	                				<!-- Card item START -->
									<div class="card border mb-4">
										<!-- Card header -->
										<div class="card-header border-bottom d-md-flex justify-content-md-between align-items-center">
											<!-- Icon and Title -->
											<div class="d-flex align-items-center">
												<div class="icon-lg bg-light rounded-circle flex-shrink-0"><i class="fa-solid fa-plane"></i></div>	
												<!-- Title -->
												<div class="ms-2">
													<h6 class="card-title mb-0">${uc.placeGo} to ${uc.placeCome}</h6>
													<ul class="nav nav-divider small">
														<li class="nav-item">Booking ID: ${uc.idBK}</li>
														<li class="nav-item">${uc.nameTC}</li>
													</ul>
												</div>
											</div>
		
											<!-- Button -->
											<div class="mt-2 mt-md-0">
												<a href="cancelbooking?idBK=${uc.idBK}" class="btn btn-primary-soft mb-0">Cancel Booking</a>
											</div>
										</div>
		
										<!-- Card body -->
										<div class="card-body">
											<div class="row g-3">
												<div class="col-sm-6 col-md-4">
													<span>Departure Time</span>
													<h6 class="mb-0">${uc.timetoGo}</h6>
												</div>
		
												<div class="col-sm-6 col-md-4">
													<span>Date Booked</span>
													<h6 class="mb-0">${uc.dateBK}</h6>
												</div>
		
												<div class="col-md-4">
													<span>Booked By</span>
													<h6 class="mb-0">${uc.nameBK}</h6>
												</div>
											</div>
										</div>
									</div>
									<!-- Card item END -->
									</c:forEach>
									<c:if test="${upcoming.size() == 0}">
		                				<div class="bg-mode shadow p-4 rounded overflow-hidden">
											<div class="row g-4 align-items-center">
												<!-- Content -->
												<div class="col-md-9">
													<h6>Looks like you have never booked with BOOKING</h6>
													<h4 class="mb-2">When you book your trip will be shown here.</h4>
													<a href="home" class="btn btn-primary-soft mb-0">Start booking now</a>
												</div>
												<!-- Image -->
												<div class="col-md-3 text-end">
													<img src="${URL}images/element/17.svg" class="mb-n5" alt="">
												</div>
											</div>
										</div>
									</c:if>
								</div>
								<!-- Tabs content item END -->
									
								<!-- Tab content item START -->
								<div class="tab-pane fade" id="tab-2">
									<h6>Cancelled Booking (${canceled.size()})</h6>
									<c:forEach items="${canceled}" var="cc">
									<!-- Card item START -->
									<div class="card border mb-4">
										<!-- Card header -->
										<div class="card-header border-bottom d-md-flex justify-content-md-between align-items-center">
											<!-- Icon and Title -->
											<div class="d-flex align-items-center">
												<div class="icon-lg bg-light rounded-circle flex-shrink-0"><i class="fa-solid fa-plane"></i></div>
													<!-- Title -->
												<div class="ms-2">
													<h6 class="card-title mb-0">${cc.placeGo} to ${cc.placeCome}</h6>
													<ul class="nav nav-divider small">
														<li class="nav-item">Booking ID: ${cc.idBK}</li>
														<li class="nav-item">${cc.nameTC}</li>
													</ul>
												</div>
											</div>
		
											<!-- Button -->
											<div class="mt-2 mt-md-0">
												<p class="text-danger text-md-end mb-0">Booking Cancelled</p>
											</div>
										</div>
		
										<!-- Card body -->
										<div class="card-body">
											<div class="row g-3">
												<div class="col-sm-6 col-md-4">
													<span>Departure Time</span>
													<h6 class="mb-0">${cc.timetoGo}</h6>
												</div>
		
												<div class="col-sm-6 col-md-4">
													<span>Date Booked</span>
													<h6 class="mb-0">${cc.dateBK}</h6>
												</div>
		
												<div class="col-md-4">
													<span>Booked By</span>
													<h6 class="mb-0">${cc.nameBK}</h6>
												</div>
											</div>
										</div>
									</div>
									<!-- Card item END -->
									</c:forEach>
								</div>
								<!-- Tabs content item END -->
		
								<!-- Tab content item START -->
								<div class="tab-pane fade" id="tab-3">
									<h6>${completed.size() != 0 ? 'Completed Booking ('.concat(completed.size()).concat(')'):''}</h6>
									<c:forEach items="${completed}" var="cl">
									<!-- Card item START -->
									<div class="card border mb-4">
										<!-- Card header -->
										<div class="card-header border-bottom d-md-flex justify-content-md-between align-items-center">
											<!-- Icon and Title -->
											<div class="d-flex align-items-center">
												<div class="icon-lg bg-light rounded-circle flex-shrink-0"><i class="fa-solid fa-plane"></i></div>
													<!-- Title -->
												<div class="ms-2">
													<h6 class="card-title mb-0">${cl.placeGo} to ${cl.placeCome}</h6>
													<ul class="nav nav-divider small">
														<li class="nav-item">Booking ID: ${cl.idBK}</li>
														<li class="nav-item">${cl.nameTC}</li>
													</ul>
												</div>
											</div>
		
											<!-- Button -->
											<div class="mt-2 mt-md-0">
												<p class="text-success text-md-end mb-0">Booking Completed</p>
											</div>
										</div>
		
										<!-- Card body -->
										<div class="card-body">
											<div class="row g-3">
												<div class="col-sm-6 col-md-4">
													<span>Departure Time</span>
													<h6 class="mb-0">${cl.timetoGo}</h6>
												</div>
		
												<div class="col-sm-6 col-md-4">
													<span>Date Booked</span>
													<h6 class="mb-0">${cl.dateBK}</h6>
												</div>
		
												<div class="col-md-4">
													<span>Booked By</span>
													<h6 class="mb-0">${cl.nameBK}</h6>
												</div>
											</div>
										</div>
									</div>
									<!-- Card item END -->
									</c:forEach>
									<c:if test="${completed.size() == 0}">
		                				<div class="bg-mode shadow p-4 rounded overflow-hidden">
											<div class="row g-4 align-items-center">
												<!-- Content -->
												<div class="col-md-9">
													<h6>Looks like you have never booked with BOOKING</h6>
													<h4 class="mb-2">When you book your trip will be shown here.</h4>
													<a href="home" class="btn btn-primary-soft mb-0">Start booking now</a>
												</div>
												<!-- Image -->
												<div class="col-md-3 text-end">
													<img src="${URL}images/element/17.svg" class="mb-n5" alt="">
												</div>
											</div>
										</div>
									</c:if>
								</div>
								<!-- Tabs content item END -->
							</div>
	
						</div>
						<!-- Card body END -->
					</div>
				</div>
			</div>
			<!-- Main content END -->
		</div>
	</div>
</section>
<!-- =======================
Content END -->

</main>
<!-- **************** MAIN CONTENT END **************** -->


<!-- Back to top -->
<div class="back-top"></div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- Vendors -->
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<script src="https://cdn.jsdelivr.net/npm/choices.js/public/assets/scripts/choices.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/flatpickr/4.6.13/flatpickr.min.js"></script>

<!-- ThemeFunctions -->
<script src="${URL}js/functions.js"></script>

</body>