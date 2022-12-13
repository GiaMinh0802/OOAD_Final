<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp" %>
<c:url value="/templates/" var="URL"></c:url>
<c:url value="/home" var="home"></c:url>

<body>
<!-- **************** MAIN CONTENT START **************** -->
<main>

<!-- =======================
Search START -->
<section class="pt-0">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<!-- Booking from START -->
				<form class="bg-mode border rounded position-relative px-4 pt-4 mb-4 mb-sm-0" action="findticket" method="get">
					<div class="row g-4">
						<!-- Nav tabs START -->
						<div class="col-lg-6">
							<ul class="nav nav-pills nav-pills-dark" id="pills-tab" role="tablist">
								<c:if test="${infoflight.get(5).equals('')}">
									<li class="nav-item" role="presentation">
										<button name="type" class="nav-link rounded-start rounded-end rounded-0 mb-0 ${infoflight.get(5).equals('') ? 'active':''}" id="pills-one-way-tab" data-bs-toggle="pill" data-bs-target="#pills-one-way" type="button" role="tab" aria-selected="true">
											One Way
										</button>
									</li>
								</c:if>
								<c:if test="${!infoflight.get(5).equals('')}">
									<li class="nav-item" role="presentation">
										<button name="type" class="nav-link rounded-start rounded-end rounded-0 mb-0 ${infoflight.get(5).equals('') ? '':'active'}" id="pills-round-trip-tab" data-bs-toggle="pill" data-bs-target="#pills-round-trip" type="button" role="tab" aria-selected="false">
											Round Trip
										</button>
									</li>
								</c:if>
							</ul>
						</div>
						<!-- Nav tabs END -->
	
						<!-- Ticket class -->
						<div class="col-lg-3 ms-auto">
							<div class="form-control-bg-light form-fs-md">
								<select class="form-select js-choice" name="class">
									<option selected disabled value="">Select class</option>
									<c:forEach items="${listtc}" var="tc">
										<option ${tc.nameTC == infoflight.get(0) ? 'selected':''}>${tc.nameTC}</option>
									</c:forEach>
								</select>
							</div>	
						</div>
	
						
						<!-- Ticket Travelers -->
	          			<div class="col-lg-3 ms-auto">
							<div class="form-control-bg-light form-fs-md">
								<input value="${infoflight.get(1).equals('') ? '':infoflight.get(1)}" class="form-control border-primary" type="search" placeholder="Enter travelers number" aria-label="Search" name="number" required  oninvalid="this.setCustomValidity('Please enter travelers number!')" oninput="this.setCustomValidity('')">
								<p class="help-block text-danger"></p>
							</div>	
						</div>
					</div>
	
					<!-- Tab content START -->
					<div class="tab-content mt-4" id="pills-tabContent">
						<!-- One way tab START -->
						<div class="tab-pane fade ${infoflight.get(5).equals('') ? 'show active':''}" id="pills-one-way" role="tabpanel" aria-labelledby="pills-one-way-tab" >
							<div class="row g-4">
								<!-- Leaving From -->
								<div class="col-md-6 col-lg-4 position-relative">
									<div class="form-border-transparent form-fs-lg bg-light rounded-3 h-100 p-3">
										<!-- Input field -->
										<label class="mb-1"><i class="bi bi-geo-alt me-2"></i>From</label>
										<select class="form-select js-choice" data-search-enabled="true" name="from_oneway">
											<option value="">Select location</option>
					                        <c:forEach items="${listap}" var="ap">
												<option ${infoflight.get(2).contains(ap.idAP) && infoflight.get(5).equals('') ? 'selected':''}>${ap.idAP} - ${ap.cityAP}</option>
					                        </c:forEach>
										</select>
									</div>
								</div>
	
								<!-- Going To -->
								<div class="col-md-6 col-lg-4">
									<div class="form-border-transparent form-fs-lg bg-light rounded-3 h-100 p-3">
										<!-- Input field -->
										<label class="mb-1"><i class="bi bi-send me-2"></i>To</label>
										<select class="form-select js-choice" data-search-enabled="true" name="to_oneway">
											<option value="">Select location</option>
					                        <c:forEach items="${listap}" var="ap">
												<option ${infoflight.get(3).contains(ap.idAP) && infoflight.get(5).equals('') ? 'selected':''}>${ap.idAP} - ${ap.cityAP}</option>
					                        </c:forEach>
										</select>
									</div>		
								</div>
	
								<!-- Departure -->
								<div class="col-lg-4">
									<div class="form-border-transparent form-fs-lg bg-light rounded-3 h-100 p-3">
										<label class="mb-1"><i class="bi bi-calendar me-2"></i>Departure</label>
										<input name="departure_oneway" value="${infoflight.get(5).equals('') ? infoflight.get(4):''}" type="text" class="form-control flatpickr" placeholder="Select date" data-date-format="d M Y" data-min-date="today">
									</div>
								</div>
	
								<div class="col-12 text-end pt-0">
									<button type="submit" class="btn btn-primary mb-n4">Find ticket <i class="bi bi-arrow-right ps-3"></i></button>
								</div>
							</div>
						</div>
						<!-- One way tab END -->
	
						<!-- Round way tab END -->
						<div class="tab-pane fade ${infoflight.get(5).equals('') ? '':'show active'}" id="pills-round-trip" role="tabpanel" aria-labelledby="pills-round-trip-tab">
							<div class="row g-4">
	
								<!-- Leaving From -->
								<div class="col-md-6 col-xl-3 position-relative">
									<div class="form-border-transparent form-fs-lg bg-light rounded-3 h-100 p-3">
										<!-- Input field -->
										<label class="mb-1"><i class="bi bi-geo-alt me-2"></i>From</label>
										<select class="form-select js-choice" data-search-enabled="true" name="from_round">
											<option value="">Select location</option>
					                        <c:forEach items="${listap}" var="ap">
												<option ${infoflight.get(2).contains(ap.idAP) && !infoflight.get(5).equals('') ? 'selected':''}>${ap.idAP} - ${ap.cityAP}</option>
					                        </c:forEach>
										</select>
									</div>
									
								</div>
	
								<!-- Going To -->
								<div class="col-md-6 col-xl-3">
									<div class="form-border-transparent form-fs-lg bg-light rounded-3 h-100 p-3">
										<!-- Input field -->
										<label class="mb-1"><i class="bi bi-send me-2"></i>To</label>
										<select class="form-select js-choice" data-search-enabled="true" name="to_round">
											<option value="">Select location</option>
					                        <c:forEach items="${listap}" var="ap">
												<option ${infoflight.get(3).contains(ap.idAP) && !infoflight.get(5).equals('') ? 'selected':''}>${ap.idAP} - ${ap.cityAP}</option>
					                        </c:forEach>
										</select>
									</div>
								</div>
	
								<!-- Departure -->
								<div class="col-md-6 col-xl-3">
									<div class="form-border-transparent form-fs-lg bg-light rounded-3 h-100 p-3">
										<label class="mb-1"><i class="bi bi-calendar me-2"></i>Departure</label>
										<input name="departure_round" value="${!infoflight.get(5).equals('') ? infoflight.get(4):''}" type="text" class="form-control flatpickr" data-date-format="d M Y" data-min-date="today" placeholder="Select date">
									</div>
								</div>
	
								<!-- Return -->
								<div class="col-md-6 col-xl-3">
									<div class="form-border-transparent form-fs-lg bg-light rounded-3 h-100 p-3">
										<label class="mb-1"><i class="bi bi-calendar me-2"></i>Return</label>
										<input name="return_round" value="${!infoflight.get(5).equals('') ? infoflight.get(5):''}" type="text" class="form-control flatpickr" data-date-format="d M Y" data-min-date="today" placeholder="Select date">
									</div>
								</div>
	
								<div class="col-12 text-end pt-0">
									<button type="submit" class="btn btn-primary mb-n4">Find ticket <i class="bi bi-arrow-right ps-3"></i></button>
								</div>
							</div>
						</div>
						<!-- Round way tab END -->
					</div>
					<!-- Tab content END -->
				</form>
				<!-- Booking from END -->
			</div>
		</div>
	</div>
</section>
<!-- =======================
Search START -->
	
<!-- =======================
Title and notice board START -->
<section class="pt-0">
	<div class="container position-relative">

		<!-- Title and button START -->
		<div class="row">
			<div class="col-12">
				<div class="d-sm-flex justify-content-sm-between align-items-center">
					<!-- Title -->
					<c:if test="${!infoflight.get(7).equals('')}">
						<div class="mb-3 mb-sm-0">
							<h1 class="fs-3">${fn:substring(infoflight.get(3), 0, 3)}<i class="bi bi-arrow-right"></i>${fn:substring(infoflight.get(2), 0, 3)}</h1>
							<ul class="nav nav-divider h6 mb-0">
								<li class="nav-item">${infoflight.get(5)}</li>
								<li class="nav-item">${infoflight.get(0)}</li>
							</ul>
						</div>
					</c:if>
					<c:if test="${infoflight.get(7).equals('')}">
						<div class="mb-3 mb-sm-0">
							<h1 class="fs-3">${fn:substring(infoflight.get(2), 0, 3)}<i class="bi bi-arrow-right"></i>${fn:substring(infoflight.get(3), 0, 3)}</h1>
							<ul class="nav nav-divider h6 mb-0">
								<li class="nav-item">${infoflight.get(4)}</li>
								<li class="nav-item">${infoflight.get(0)}</li>
							</ul>
						</div>
					</c:if>
					<!-- Offcanvas Button -->
					<button class="btn btn-primary d-xl-none mb-0" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasSidebar" aria-controls="offcanvasSidebar">
						<i class="fa-solid fa-sliders-h me-1"></i> Show filters
					</button>
				</div>	
			</div>
		</div>
		<!-- Title and button END -->


	</div>
</section>
<!-- =======================
Title and notice board END -->

<!-- =======================
Flight list START -->
<section class="pt-0">
	<div class="container">
		<div class="row">
<!-- 
			<!-- Main content START -->
			<div class="col-12">
				<div class="vstack gap-4">
					<c:forEach items="${fl}" var="fl">
						<!-- Ticket item START -->
						<div class="card border">
							<!-- Card header -->
							<div class="card-header d-sm-flex justify-content-sm-between align-items-center">
								<!-- Airline Name -->
								<div class="d-flex align-items-center mb-2 mb-sm-0">
									<img src="${URL}images/logoairlines/${fl.logoAL}" class="w-30px me-2" alt="">
									<h6 class="fw-normal mb-0">${fl.nameAL}</h6>
								</div>
								<h6 class="fw-normal mb-0"><span class="text-body">Travel Class:</span> ${fl.nameTC}</h6>
							</div>
	
							<!-- Card body -->
							<div class="card-body p-4 pb-0">
								<!-- Ticket item START -->
								<div class="row g-4">
									<!-- Airport detail -->
									<div class="col-sm-4 col-md-3 my-sm-auto text-center">
										<h4 align="center">${fl.timetoGo}</h4>
										<p class="mb-0" align="center">${fl.idAPtoGo}</p>
									</div>
	
									<!-- Time -->
									<div class="col-sm-4 col-md-3 my-sm-auto text-center">
										<!-- Time -->
										<h5>${fn:substring(fl.timeFL, 0, 2)}hr ${fn:substring(fl.timeFL, 3, 5)}min</h5>
										<div class="position-relative my-4">
											<!-- Line -->
											<hr class="bg-primary opacity-5 position-relative">
											<!-- Icon -->
											<div class="icon-md bg-primary text-white rounded-circle position-absolute top-50 start-50 translate-middle">
												<i class="fa-solid fa-fw fa-plane rtl-flip"></i>
											</div>
										</div>
									</div>
	
									<!-- Airport detail -->
									<div class="col-sm-4 col-md-3 my-sm-auto text-center">
										<h4 align="center">${fl.timetoCome}</h4>
										<p class="mb-0" align="center">${fl.idAPtoCome}</p>
									</div>
									
									<!-- Price -->
									<div class="col-md-3 text-md-end">
										<h4 class="text-danger">${fl.price}₫</h4>
										<a href="check?flID=${fl.idFL}&tcName=${fl.nameTC}" class="btn btn-dark mb-0 mb-sm-2">Book Now</a>
									</div>
								</div>
								<!-- Ticket item END -->
							</div>  
	
							<!-- Card footer -->
							<div class="card-footer pt-4" align="center">
								<p class="text-danger">Only ${fl.emptySeat} Seat Left</p>
							</div>
						</div>
						<!-- Ticket item END -->
					</c:forEach>		
				</div>
			</div>
			<!-- Main content END -->
		</div> <!-- Row END -->
	</div>
</section>
<!-- =======================
Flight list END -->

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