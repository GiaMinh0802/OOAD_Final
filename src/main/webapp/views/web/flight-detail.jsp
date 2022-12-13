<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp" %>
<c:url value="/templates/" var="URL"></c:url>
<c:url value="/home" var="home"></c:url>

<body>
<!-- **************** MAIN CONTENT START **************** -->
<main>
	
<!-- =======================
Main Content START -->
<section>
	<div class="container position-relative" data-sticky-container>
		<div class="row g-4">
			<!-- Left Content START -->
			<div class="col-xl-9">
				<div class="vstack gap-4">
					
					<!-- Title START -->
					<div class="d-flex align-items-center">
						<!-- Icon -->
						<h1 class="display-4 mb-0"><i class="fa-solid fa-plane rtl-flip"></i></h1>

						<!-- Title and content START -->
						<div class="ms-3">
							<!-- Title -->
							<ul class="list-inline mb-2">
								<li class="list-inline-item me-2">
									<h3 class="mb-0">${infoflight.get(2).substring(5)}</h3>
								</li>
								<li class="list-inline-item me-2">
									<h3 class="mb-0"><i class="bi ${!infoflight.get(5).equals('') ? 'bi-arrow-left-right':'bi-arrow-right'} "></i></h3>
								</li>
								<li class="list-inline-item me-0">
									<h3 class="mb-0">${infoflight.get(3).substring(5)}</h3>
								</li>
							</ul>

							<!-- List -->
							<ul class="nav nav-divider h6 fw-normal text-body mb-0">
								<li class="nav-item">${infoflight.get(4)}</li>
								<c:if test="${!infoflight.get(5).equals('')}">
									<li class="nav-item">${infoflight.get(5)}</li>
								</c:if>
							</ul>
						</div>
						<!-- Title and content END -->
					</div>
					<!-- Title END -->
					
					<!-- Ticket START -->
					<div class="card border">
						<!-- Card header -->
						<div class="card-header d-flex justify-content-between pb-0">
							<div class="d-flex align-items-center mb-2 mb-sm-0">
							</div>
							<h6 class="fw-normal mb-0"><span class="text-body">Travel Class:</span> ${go.nameTC}</h6>
						</div>

						<!-- Card body START -->
						<div class="card-body p-4">
							<!-- Ticket item START -->
							<div class="row g-4">
								<!-- Air line name -->
								<div class="col-md-3 text-center my-sm-auto" align="center">
									<!-- Image -->
									<img src="${URL}images/logoairlines/${go.logoAL}" class="w-80px mb-3" alt="">
									<!-- Title -->
									<h6 class="fw-normal mb-0">${go.nameAL}</h6>
								</div>

								<!-- Airport detail -->
								<div class="col-sm-4 col-md-3 text-center my-sm-auto" align="center">
									<!-- Title -->
									<h4>${go.idAPtoGo}</h4>
									<h6>${go.timetoGo}</h6>
								</div>

								<!-- Time -->
								<div class="col-sm-4 col-md-3 text-center my-sm-auto">
									<!-- Time -->
									<h5>${fn:substring(go.timeFL, 0, 2)}hr ${fn:substring(go.timeFL, 3, 5)}min</h5>

									<div class="position-relative my-4">
										<!-- Line -->
										<hr class="bg-primary opacity-5 position-relative">
										<!-- Icon -->
										<div class="icon-md bg-primary text-white rounded-circle position-absolute top-50 start-50 translate-middle">
											<i class="fa-solid fa-fw fa-plane rtl-flip "></i>
										</div>
									</div>
								</div>

								<!-- Airport detail -->
								<div class="col-sm-4 col-md-3 text-center my-sm-auto"  align="center" >
									<!-- Title -->
									<h4>${go.idAPtoCome}</h4>
									<h6>${go.timetoCome}</h6>
								</div>
							</div>
							<!-- Ticket item END -->
						</div>  
						<!-- Card body END -->
					</div>
					<!-- Ticket END -->

					<c:if test="${infobooking.size()==4}">
					<!-- Ticket START -->
					<div class="card border">
						<!-- Card header -->
						<div class="card-header d-flex justify-content-between pb-0">
							<div class="d-flex align-items-center mb-2 mb-sm-0">
							</div>
							<h6 class="fw-normal mb-0"><span class="text-body">Travel Class:</span> ${back.nameTC}</h6>
						</div>

						<!-- Card body START -->
						<div class="card-body p-4">
							<!-- Ticket item START -->
							<div class="row g-4">
								<!-- Air line name -->
								<div class="col-md-3 text-center my-sm-auto" align="center">
									<!-- Image -->
									<img src="${URL}images/logoairlines/${back.logoAL}" class="w-80px mb-3" alt="">
									<!-- Title -->
									<h6 class="fw-normal mb-0">${back.nameAL}</h6>
								</div>

								<!-- Airport detail -->
								<div class="col-sm-4 col-md-3 text-center my-sm-auto" align="center">
									<!-- Title -->
									<h4>${back.idAPtoGo}</h4>
									<h6>${back.timetoGo}</h6>
								</div>

								<!-- Time -->
								<div class="col-sm-4 col-md-3 text-center my-sm-auto">
									<!-- Time -->
									<h5>${fn:substring(back.timeFL, 0, 2)}hr ${fn:substring(back.timeFL, 3, 5)}min</h5>

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
								<div class="col-sm-4 col-md-3 text-center my-sm-auto"  align="center" >
									<!-- Title -->
									<h4>${back.idAPtoCome}</h4>
									<h6>${back.timetoCome}</h6>
								</div>
							</div>
							<!-- Ticket item END -->
						</div>  
						<!-- Card body END -->
					</div>
					<!-- Ticket END -->
					</c:if>

					<!-- Booking form START -->
					<form class="card border" action="booking" method="get" >
						<!-- Card header -->
						<div class="card-header border-bottom px-4">
							<h3 class="card-title mb-0">Traveler Details</h3>
						</div>

						<!-- Card body START -->
						<div class="card-body py-4">
						<c:forEach var="i" begin="1" end="${infoflight.get(1)}">
							<!-- Accordion START -->
							<div class="accordion accordion-icon accordion-bg-light" id="accordionExample${i}">
								
								<!-- Item -->
								<div class="accordion-item mb-3">
									<h6 class="accordion-header font-base" id="heading-1">
										<button class="accordion-button fw-bold rounded collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse-${i}" aria-expanded="true" aria-controls="collapse-${i}">
											Traveler ${i}
										</button>
									</h6>
									<!-- Accordion Body START -->
									<div id="collapse-${i}" class="accordion-collapse collapse ${i==1 ? 'show':''}" aria-labelledby="heading-1" data-bs-parent="#accordionExample${i}">
										<div class="accordion-body mt-3">
											
											<!-- Form START -->
											<div class="row g-4">
												<!-- Input item -->
												<div class="col-md-6">
													<label class="form-label">Full Name</label>
													<div class="input-group">
														<input type="text" class="form-control" placeholder="Full Name" name="fullname${i}" required>
													</div>
												</div>

												<!-- Input item -->
												<div class="col-md-6">
													<label class="form-label">Mobile number</label>
													<input type="text" class="form-control" placeholder="Enter your mobile number" name="phone${i}" required>
												</div>
		
											</div>
											<!-- Form END -->

										</div>
									</div>
									<!-- Accordion Body END -->
								</div>
								
							</div>
							<!-- Accordion END -->
						</c:forEach>
							<!-- Button -->
							<div class="d-grid mt-4">
								<button type="submit" class="btn btn-primary mb-0">Proceed To Booking</button>
							</div>
						</div>
						<!-- Card body END -->
					</form>
					<!-- Booking form END -->
				</div>
			</div>
			<!-- Left Content END -->

			<!-- Right content START -->
			<aside class="col-xl-3">
				<div data-sticky data-margin-top="80" data-sticky-for="1199">
					<div class="row g-4">
						

						<div class="col-md-6 col-xl-12">
						</div>

						<!-- Fare summary START -->
						<div class="col-md-6 col-xl-12">
							<div class="card bg-light rounded-2">
								<!-- card header -->
								<div class="card-header border-bottom bg-light">
									<h5 class="card-title mb-0">Fare Summary</h5>
								</div>
	
								<!-- Card body -->
								<div class="card-body">
									<ul class="list-group list-group-borderless">
										<li class="list-group-item d-flex justify-content-between align-items-center">
											<span class="h6 fw-normal mb-0">${infobooking.size()==4 ? 'Go':'Basic'} Fare</span>
											<span class="fs-5">${go.price}₫</span>
										</li>
										<c:if test="${infobooking.size()==4}">
											<li class="list-group-item d-flex justify-content-between align-items-center">
												<span class="h6 fw-normal mb-0">Back Fare</span>
												<span class="fs-5">${back.price}₫</span>
											</li>
										</c:if>
									</ul>
								</div>
	
								<!-- Card footer -->
								<div class="card-footer border-top bg-light">
									<div class="d-flex justify-content-between align-items-center">
										<span class="h5 fw-normal mb-0">Total Fare</span>
										<span class="h5 fw-normal mb-0 text-success">${go.price*infoflight.get(1)+back.price*infoflight.get(1)}₫</span>
									</div>
								</div>
							</div>
						</div>
						<!-- Fare summary END -->
						
					</div>
				</div>	
			</aside>
			<!-- Right content END -->

		</div>
	</div>
</section>
<!-- =======================
Main Content END -->

</main>
<!-- *****

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