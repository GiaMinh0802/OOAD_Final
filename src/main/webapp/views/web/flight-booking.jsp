<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp" %>
<c:url value="/templates/" var="URL"></c:url>
<c:url value="/home" var="home"></c:url>

<body>
<!-- **************** MAIN CONTENT START **************** -->
<main>

<!-- =======================
Main content START -->
<section class="pt-4">
	<div class="container">
		<div class="row">
			<div class="col-md-10 col-xl-8 mx-auto">

				<div class="card shadow">
					<!-- Image -->
					<img src="${URL}images/bg/04.jpg" class="rounded-top" alt="">

					<!-- Card body -->
					<div class="card-body text-center p-4">
						<!-- Title -->
						<h1 class="card-title fs-3">🎊 Congratulations! 🎊</h1>
						<p class="lead mb-3">Your trip has been booked</p>

						<!-- Second title -->
						<h5 class="text-primary mb-4">Welcome to ${infoflight.get(3).substring(5)}</h5>

						<!-- List -->
						<div class="row justify-content-between text-start mb-4">
							<div class="col-lg-5">
								<ul class="list-group list-group-borderless">
									<li class="list-group-item d-sm-flex justify-content-between align-items-center">
										<span class="mb-0"><i class="bi bi-vr fa-fw me-2"></i>Booking ID:</span>
										<span class="h6 fw-normal mb-0">${infobk.get(0)}</span>
									</li>
									<li class="list-group-item d-sm-flex justify-content-between align-items-center">
										<span class="mb-0"><i class="bi bi-calendar fa-fw me-2"></i>Booking Date:</span>
										<span class="h6 fw-normal mb-0">${infobk.get(1)}</span>
									</li>
								</ul>
							</div>

							<div class="col-lg-5">
								<ul class="list-group list-group-borderless">
									
									<li class="list-group-item d-sm-flex justify-content-between align-items-center">
										<span class="mb-0"><i class="bi bi-currency-dollar fa-fw me-2"></i>Total Price:</span>
										<span class="h6 fw-normal mb-0">${infobk.get(2)}₫</span>
									</li>
									<li class="list-group-item d-sm-flex justify-content-between align-items-center">
										<span class="mb-0"><i class="bi bi-people fa-fw me-2"></i>Guests:</span>
										<span class="h6 fw-normal mb-0">${infoflight.get(1)}</span>
									</li>
								</ul>
							</div>
						</div>

						<!-- Button -->
						<div class="d-sm-flex justify-content-center d-grid">
							<!-- Download button -->
							<a href="home" class="btn btn-primary mb-0">Done</a>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</section>
<!-- =======================
Main content START -->

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