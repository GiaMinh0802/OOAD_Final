<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp" %>
<c:url value="/templates/" var="URL"></c:url>
<c:url value="/admin" var="admin"></c:url>
<c:url value="/sign-out" var="signout"></c:url>

<body>
<!-- **************** MAIN CONTENT START **************** -->
<main>
	<!-- Sidebar START -->
	<nav class="navbar sidebar navbar-expand-xl navbar-light">
		<!-- Navbar brand for xl START -->
		<div class="d-flex align-items-center">
			<a class="navbar-brand" href="${admin}">
				<img class="light-mode-item navbar-brand-item" src="${URL}images/logo.svg" alt="logo">
				<img class="dark-mode-item navbar-brand-item" src="${URL}images/logo-light.svg" alt="logo">
			</a>
		</div>
		<!-- Navbar brand for xl END -->
		
		<div class="offcanvas offcanvas-start flex-row custom-scrollbar h-100" data-bs-backdrop="true" tabindex="-1" id="offcanvasSidebar">
			<div class="offcanvas-body sidebar-content d-flex flex-column pt-4">
	
				<!-- Sidebar menu START -->
				<ul class="navbar-nav flex-column" id="navbar-sidebar">
					<!-- Menu item -->
					<li class="nav-item"><a href="${admin}" class="nav-link">Dashboard</a></li>
	
					<li class="nav-item ms-2 my-2">Airline Management</li>
					
					<li class="nav-item"> <a class="nav-link" href="airports">Airports</a></li>
					
					<li class="nav-item"> <a class="nav-link" href="flightroutes">FlightRoutes</a></li>
					
					<li class="nav-item"> <a class="nav-link" href="ticketclasses">TicketClasses</a></li>
					
					<li class="nav-item"> <a class="nav-link" href="airlines">Airlines</a></li>
					
					<li class="nav-item"> <a class="nav-link" href="flights">Flights</a></li>
					
					<li class="nav-item ms-2 my-2">Infomation Management</li>
					
					<li class="nav-item"> <a class="nav-link active" href="customers">Customer</a></li>
	
				</ul>
				<!-- Sidebar menu end -->
	
				<!-- Sidebar footer START -->
				<div class="d-flex align-items-center justify-content-between text-primary-hover mt-auto p-3">
					<a class="h6 fw-light mb-0 text-body" href="${signout}" data-bs-toggle="tooltip" data-bs-placement="top" aria-label="Sign out">
						<i class="fa-solid fa-arrow-right-from-bracket"></i> Log out
					</a>
				</div>
				<!-- Sidebar footer END -->
				
			</div>
		</div>
	</nav>
	<!-- Sidebar END -->

		
	<!-- Page content START -->
	<div class="page-content">
	
		<!-- Page main content START -->
		<div class="page-content-wrapper p-xxl-4">
	
			<!-- Title -->
			<div class="row">
				<div class="col-12 mb-4 mb-sm-5">
					<div class="d-sm-flex justify-content-between align-items-center">
						<h1 class="h3 mb-3 mb-sm-0">Customer List</h1>			
					</div>
				</div>
			</div>


			<!-- Guest list START -->
			<div class="card shadow mt-1">
				<!-- Card body START -->
				<div class="card-body">
					<!-- Table head -->
					<div class="bg-light rounded p-3 d-none d-lg-block">
						<div class="row row-cols-7 g-4">
							<div class="col"><h6 class="mb-0">No.</h6></div>
							<div class="col"><h6 class="mb-0">Full Name</h6></div>
							<div class="col"><h6 class="mb-0">Phone</h6></div>
							<div class="col"><h6 class="mb-0">Birthday</h6></div>
							<div class="col"><h6 class="mb-0">Address</h6></div>
							<div class="col"><h6 class="mb-0">Email</h6></div>
							<div class="col"><h6 class="mb-0">Status</h6></div>
							<div class="col"><h6 class="mb-0">Action</h6></div>
						</div>
					</div>
					<c:forEach items="${listcus}" var="cus" varStatus="i">
					<!-- Table data -->
					<div class="row row-cols-xl-7 align-items-lg-center border-bottom g-4 px-2 py-4">
						<!-- Data item -->
						<div class="col">
							<small class="d-block d-lg-none">No.:</small>
							<div class="d-flex align-items-center">
								<div class="ms-2">
									<h6 class="mb-0 fw-normal">${i.index+1}</h6>
								</div>
							</div>
						</div>
						
						<!-- Data item -->
						<div class="col">
							<small class="d-block d-lg-none">Full Name:</small>
							<h6 class="mb-0 fw-normal">${cus.nameUS}</h6>
						</div>

						<!-- Data item -->
						<div class="col">
							<small class="d-block d-lg-none">Phone:</small>
							<h6 class="mb-0 fw-normal">${cus.phoneUS}</h6>
						</div>
						
						<!-- Data item -->
						<div class="col">
							<small class="d-block d-lg-none">Birthday:</small>
							<h6 class="mb-0 fw-normal">${cus.birthdayUS}</h6>
						</div>
						
						<!-- Data item -->
						<div class="col">
							<small class="d-block d-lg-none">Address:</small>
							<h6 class="mb-0 fw-normal">${cus.addressUS}</h6>
						</div>

						<!-- Data item -->
						<div class="col">
							<small class="d-block d-lg-none">Email:</small>
							<h6 class="mb-0 fw-normal">${cus.email}</h6>
						</div>
						
						<!-- Data item -->
						<div class="col">
							<small class="d-block d-lg-none">Status:</small>
							<div class="d-flex align-items-center">
								<div class="ms-2">
									<h6 class="mb-0 fw-normal">
										${cus.status == 1 ? '<i class="bi bi-check-circle-fill" style="color: #0ca678"></i>' : cus.status == -1 ? '<i class="bi bi-x-circle-fill" style="color: #e03131"></i>':'<i class="bi bi-circle-fill" style="color: #fab005"></i>'}
									</h6>
								</div>
							</div>	
						</div>

						<!-- Data item -->
						<div class="col">
							<div class="hstack gap-2 mt-3 mt-sm-0">
								<c:if test="${cus.status == -1}">
									<a href="unlock?idCus=${cus.idUS}" class="btn btn-sm btn-primary-soft px-2 mb-0"><i class="bi bi-unlock-fill"></i></a>    
								</c:if>
								<c:if test="${cus.status == 1}">
									<a href="lock?idCus=${cus.idUS}" class="btn btn-sm btn-danger-soft px-2 mb-0"><i class="bi bi-lock-fill"></i></a>
								</c:if>   
							</div>
						</div>
					</div>
					</c:forEach>

				</div>
				<!-- Card body END -->

			</div>
			<!-- Guest list END -->
		</div>
		<!-- Page main content END -->
	</div>
	<!-- Page content END -->
	
</main>
<!-- **************** MAIN CONTENT END **************** -->


<!-- Back to top -->
<div class="back-top"></div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- Vendors -->
<script src="https://cdn.jsdelivr.net/npm/choices.js/public/assets/scripts/choices.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/flatpickr/4.6.13/flatpickr.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/15.6.1/nouislider.min.js"></script>

<!-- ThemeFunctions -->
<script src="${URL}js/functions.js"></script>
</body>
</html>