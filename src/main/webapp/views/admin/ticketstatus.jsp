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
					
					<li class="nav-item"> <a class="nav-link active" href="flights">Flights</a></li>
					
					<li class="nav-item ms-2 my-2">Infomation Management</li>
					
					<li class="nav-item"> <a class="nav-link" href="customers">Customer</a></li>

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
						<a class="btn btn-danger-soft mb-2" href="flights" type="button"><i class="bi bi-backspace-fill"></i> Back</a>
						<h1 class="h3 mb-3 mb-sm-0">Ticket Status</h1>		
						<div class="d-grid">
						</div>	
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
							<div class="col"><h6 class="mb-0">TicketClass</h6></div>
							<div class="col"><h6 class="mb-0">Total Seats</h6></div>
							<div class="col"><h6 class="mb-0">Empty Seats</h6></div>
							<div class="col"><h6 class="mb-0">Action</h6></div>
						</div>
					</div>
					<c:forEach items="${listts}" var="ts" varStatus="i">
					<!-- Table data -->
					<div class="row row-cols-xl-7 align-items-lg-center border-bottom g-4 px-2 py-4">
						<!-- Data item -->
						<div class="col">
							<small class="d-block d-lg-none">No.:</small>
							<div class="d-flex align-items-center">
								<!-- Info -->
								<div class="ms-2">
									<h6 class="mb-0 fw-light">${i.index+1}</h6>
								</div>
							</div>
						</div>	
						
						<!-- Data item -->
						<div class="col">
							<small class="d-block d-lg-none">TicketClass:</small>
							<h6 class="mb-0 fw-normal ${ts.totalseats == 0 ? 'text-danger':''}">${ts.nameTC}</h6>
						</div>
						
						<!-- Data item -->
						<div class="col">
							<small class="d-block d-lg-none">Total Seats:</small>
							<h6 class="mb-0 fw-normal ${ts.totalseats == 0 ? 'text-danger':''}">${ts.totalseats}</h6>
						</div>
						
						<!-- Data item -->
						<div class="col">
							<small class="d-block d-lg-none">Empty Seats:</small>
							<h6 class="mb-0 fw-normal ${ts.totalseats == 0 ? 'text-danger':''}">${ts.emptyseats}</h6>
						</div>

						<!-- Data item -->
						<div class="col">
							<div class="hstack gap-2 mt-3 mt-sm-0">
								<button type="button" class="btn btn-sm btn-primary-soft px-2 mb-0" data-bs-toggle="modal" data-bs-target="#editForm" 
									data-bs-nameTC="${ts.nameTC}" data-bs-total="${ts.totalseats}" data-bs-empty="${ts.emptyseats}" 
									data-bs-idFL="${ts.idFL}" data-bs-idTC="${ts.idTC}" data-bs-idAL="${price.idAL}">
										<i class="bi bi-pencil-square fa-fw"></i>
								</button>   
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

<div class="modal fade" id="editForm" tabindex="-1" role="dialog"  aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<!-- Title -->
			<div class="modal-header">
				<h5 class="modal-title" id="editFormlabel">Edit Ticket Status</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<form role="form" action="edit-ticketstatus" method="post">
			<!-- Body -->
			<div class="modal-body p-3">
				<div class="card bg-transparent">
					<!-- Card body -->
					<div class="card-body pt-0">
						
							<input name="idFL" id="idFL" type="text" class="form-control" value="" hidden="">
							<input name="idTC" id="idTC" type="text" class="form-control" value="" hidden="">
						
							<div class="mb-3">
								<label class="form-label">TicketClass</label>
								<input name="nameTC" id="nameTC" type="text" class="form-control" value="" readonly>
							</div>
							
							<div class="mb-3">
								<label class="form-label">Total Seats</label>
								<input name="totalseats" id="totalseats" type="text" class="form-control" required>
							</div>
							
							<div class="mb-3">
								<label class="form-label">Empty Seats</label>
								<input name="emptyseats" id="emptyseats" type="text" class="form-control" required>
							</div>
							
					</div>
				</div>
			</div>
			
			<div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
		        <button type="submit" class="btn btn-primary">Edit</button>     
        	</div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
	var exampleModal = document.getElementById('editForm')
	exampleModal.addEventListener('show.bs.modal', event => {
		var button = event.relatedTarget
		var nameTC = button.getAttribute('data-bs-nameTC')
		var total = button.getAttribute('data-bs-total')
		var empty = button.getAttribute('data-bs-empty')
		var idFL = button.getAttribute('data-bs-idFL')
		var idTC = button.getAttribute('data-bs-idTC')
		exampleModal.querySelector('.modal-body #nameTC').value = nameTC
		exampleModal.querySelector('.modal-body #totalseats').value = total
		exampleModal.querySelector('.modal-body #emptyseats').value = empty
		exampleModal.querySelector('.modal-body #idFL').value = idFL
		exampleModal.querySelector('.modal-body #idTC').value = idTC
	})
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