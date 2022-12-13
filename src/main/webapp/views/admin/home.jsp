<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp" %>
<c:url value="/templates/" var="URL"></c:url>
<c:url value="/admin" var="admin"></c:url>

<body>
<!-- **************** MAIN CONTENT START **************** -->
<main>
	<!-- Sidebar START -->
	<nav class="navbar sidebar navbar-expand-xl navbar-light">
		<!-- Navbar brand for xl START -->
		<div class="d-flex align-items-center">
			<a class="navbar-brand" href="admin">
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
					<li class="nav-item"><a href="admin" class="nav-link active">Dashboard</a></li>
	
					<li class="nav-item ms-2 my-2">Airline Management</li>
					
					<li class="nav-item"> <a class="nav-link" href="${admin}/airports">Airports</a></li>
					
					<li class="nav-item"> <a class="nav-link" href="${admin}/flightroutes">FlightRoutes</a></li>
					
					<li class="nav-item"> <a class="nav-link" href="${admin}/ticketclasses">TicketClasses</a></li>
					
					<li class="nav-item"> <a class="nav-link" href="${admin}/airlines">Airlines</a></li>
					
					<li class="nav-item"> <a class="nav-link" href="${admin}/flights">Flights</a></li>
					
					<li class="nav-item ms-2 my-2">Infomation Management</li>
					
					<li class="nav-item"> <a class="nav-link" href="${admin}/customers">Customer</a></li>

				</ul>
				<!-- Sidebar menu end -->
	
				<!-- Sidebar footer START -->
				<div class="d-flex align-items-center justify-content-between text-primary-hover mt-auto p-3">
					<a class="h6 fw-light mb-0 text-body" href="sign-out" data-bs-toggle="tooltip" data-bs-placement="top" aria-label="Sign out">
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
						<h1 class="h3 mb-2 mb-sm-0">Dashboard</h1>		
					</div>
				</div>
			</div>

			<!-- Counter boxes START -->
			<div class="row g-4 mb-5">
				<!-- Counter item -->
				<div class="col-md-6 col-xxl-3">
					<div class="card card-body bg-warning bg-opacity-10 border border-warning border-opacity-25 p-4 h-100">
						<div class="d-flex justify-content-between align-items-center">
							<!-- Digit -->
							<div>
								<h4 class="mb-0">${listdb.get(2)}</h4>
								<span class="h6 fw-light mb-0">Total Flights</span>
							</div>
							<!-- Icon -->
							<div class="icon-lg rounded-circle bg-warning text-white mb-0"><i class="fa-solid fa-hotel fa-fw"></i></div>
						</div>
					</div>
				</div>

				<!-- Counter item -->
				<div class="col-md-6 col-xxl-3">
					<div class="card card-body bg-primary bg-opacity-10 border border-primary border-opacity-25 p-4 h-100">
						<div class="d-flex justify-content-between align-items-center">
							<!-- Digit -->
							<div>
								<h4 class="mb-0">${listdb.get(3)}</h4>
								<span class="h6 fw-light mb-0">Total Member</span>
							</div>
							<!-- Icon -->
							<div class="icon-lg rounded-circle bg-primary text-white mb-0"><i class="fa-solid fa-bed fa-fw"></i></div>
						</div>
					</div>
				</div>

				<!-- Counter item -->
				<div class="col-md-6 col-xxl-3">
					<div class="card card-body bg-info bg-opacity-10 border border-info border-opacity-25 p-4 h-100">
						<div class="d-flex justify-content-between align-items-center">
							<!-- Digit -->
							<div>
								<h4 class="mb-0">${listdb.get(0)}</h4>
								<span class="h6 fw-light mb-0">Booked Ticket</span>
							</div>
							<!-- Icon -->
							<div class="icon-lg rounded-circle bg-info text-white mb-0"><i class="fa-solid fa-building-circle-check fa-fw"></i></div>
						</div>
					</div>
				</div>
							
				<!-- Counter item -->
				<div class="col-md-6 col-xxl-3">
					<div class="card card-body bg-success bg-opacity-10 border border-success border-opacity-25 p-4 h-100">
						<div class="d-flex justify-content-between align-items-center">
							<!-- Digit -->
							<div>
								<h4 class="mb-0">${listdb.get(1)}₫</h4>
								<span class="h6 fw-light mb-0">Total Incomes</span>
							</div>
							<!-- Icon -->
							<div class="icon-lg rounded-circle bg-success text-white mb-0"><i class="fa-solid fa-hand-holding-dollar fa-fw"></i></div>
						</div>
					</div>
				</div>
			</div>
			<!-- Counter boxes END -->

			<div class="row g-4 mb-5">
			
				<div class="col-xxl-8">
					<div class="card shadow h-100">
						<div class="card-header border-bottom">
							<h5 class="card-header-title">Airline Activities</h5>
						</div>
						
						<div class="card-body">
							
							<div>
							 	<canvas id="ChartA" width="1000" height="300"></canvas>
							 	
							</div>
							<p id="jan" hidden="">${jan}</p>
							<p id="feb" hidden="">${feb}</p>
							<p id="mar" hidden="">${mar}</p>
							<p id="apr" hidden="">${apr}</p>
							<p id="may" hidden="">${may}</p>
							<p id="jun" hidden="">${jun}</p>
							<p id="jul" hidden="">${jul}</p>
							<p id="aug" hidden="">${aug}</p>
							<p id="sep" hidden="">${sep}</p>
							<p id="oct" hidden="">${oct}</p>
							<p id="nov" hidden="">${nov}</p>
							<p id="dec" hidden="">${dec}</p>
						</div>
						
					</div>
				</div>
				
				<div class="col-lg-6 col-xxl-4">
					<div class="card shadow h-100">
						<div class="card-header border-bottom">
							<h5 class="card-header-title">Ticket Booking</h5>
						</div>
						
						<div class="card-body p-3">
						
							<div class="col-sm-6 mx-auto">
								<div class="d-flex justify-content-center" style="width: 300px; height: 300px;">
									<canvas id="ChartB" style="margin: 0 auto;"></canvas>
								</div>
							</div>
							
							 <ul class="list-group list-group-borderless mb-0">
								<li class="list-group-item d-flex justify-content-between">
									<span class="h6 fw-light mb-0"><i class="text-success fas fa-circle me-2"></i> Booked</span>
									<span class="h6 fw-light mb-0"><span id="countbooked">${booked}</span> Ticket</span>
								</li>
								<li class="list-group-item d-flex justify-content-between">
									<span class="h6 fw-light mb-0"><i class="text-danger fas fa-circle me-2"></i> Cancel</span>
									<span class="h6 fw-light mb-0"><span id="countcancel">${cancel}</span> Ticket</span>
								</li>
							</ul>
						</div>
					</div>
				</div>
				
			</div>

			<!-- Hotel grid START -->
			<div class="row g-4 mb-5">
				<!-- Title -->
				<div class="col-12">
					<div class="d-flex justify-content-between">
						<h4 class="mb-0">Popular Places</h4>
						<a href="${admin}/airports" class="btn btn-primary-soft mb-0">View All</a>
					</div>	
				</div>

				<c:forEach items="${listap}" var="ap">
					<!-- Plances item -->
					<div class="col-lg-6">
						<div class="card shadow p-3">
							<div class="row g-4">
								<!-- Card img -->
								<div class="col-md-3">
									<img src="${URL}images/airport/${ap.imagePlace}" class="rounded-2" alt="Card image">
								</div>
	
								<!-- Card body -->
								<div class="col-md-9">
									<div class="card-body position-relative d-flex flex-column p-0 h-100">
										<!-- Title -->
										<h5 class="card-title mb-0 me-5"><a href="#">${ap.idAP} - ${ap.cityAP}</a></h5>
										<small><i class="bi bi-geo-alt me-2"></i>${ap.nameAP}</small>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
				
			</div>
			<!-- Hotel grid END -->
			
		</div>
		<!-- Page main content END -->
	</div>
	<!-- Page content END -->
	
</main>
<!-- **************** MAIN CONTENT END **************** -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script>
	const chartA = document.getElementById('ChartA');
	const chartB = document.getElementById('ChartB');
	
	var booked = parseInt(document.getElementById('countbooked').innerText)
	var cancel = parseInt(document.getElementById('countcancel').innerText)
	
	var jan = parseInt(document.getElementById('jan').innerText)
	var feb = parseInt(document.getElementById('feb').innerText)
	var mar = parseInt(document.getElementById('mar').innerText)
	var apr = parseInt(document.getElementById('apr').innerText)
	var may = parseInt(document.getElementById('may').innerText)
	var jun = parseInt(document.getElementById('jun').innerText)
	var jul = parseInt(document.getElementById('jul').innerText)
	var aug = parseInt(document.getElementById('aug').innerText)
	var sep = parseInt(document.getElementById('sep').innerText)
	var oct = parseInt(document.getElementById('oct').innerText)
	var nov = parseInt(document.getElementById('nov').innerText)
	var dec = parseInt(document.getElementById('dec').innerText)
	
	new Chart(chartA, {
		type: 'bar',
		data: {
		    labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
		    datasets: [{
				label: 'Total Incomes (VND)',
				data: [jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec],
				borderWidth: 1
	    	}]
		},
		options: {
			scales: {
				y: {
					beginAtZero: true
	      		}
	    	}
	  }
	});
	new Chart(chartB, {
		type: 'doughnut',
		data: {
		    labels: ['Booked', 'Cancel'],
		    datasets: [{
				label: '# Booked Ticket',
				data: [booked, cancel],
				backgroundColor: ['rgb(92, 184, 92)', 'rgb(217,83,79)'],
				borderWidth: 1
	    	}]
		},
		options: {
			scales: {
				yAxes: [{
					gridLines: {
						drawBorder: false,
				    }, 
				    ticks: {
	                    beginAtZero: true
	                }
				}]
	    	}
	  }
	});
</script>

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