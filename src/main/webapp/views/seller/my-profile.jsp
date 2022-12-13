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
<section class="pt-3">
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
										<a class="nav-link active" href="myprofile"><i class="bi bi-person fa-fw me-2"></i>My Profile</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="mybooking"><i class="bi bi-ticket-perforated fa-fw me-2"></i>My Bookings</a>
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
					<!-- Personal info START -->
					<div class="card border">
						<!-- Card header -->
						<div class="card-header border-bottom">
							<h4 class="card-header-title">Personal Information</h4>
						</div>

						<!-- Card body START -->
						<div class="card-body">
							<!-- Form START -->
							<form class="row g-3" action="myprofile" method="post">
								<!-- Profile photo -->
								<div class="col-12">
									<label class="form-label">Upload your profile photo<span class="text-danger">*</span></label>
									<div class="d-flex align-items-center">
										<label class="position-relative me-4" for="uploadfile-1" title="Replace this pic">
											<!-- Avatar place holder -->
											<span class="avatar avatar-xl">
												<img id="uploadfile-1-preview" class="avatar-img rounded-circle border border-white border-3 shadow" src="${URL}images/avatar/01.jpg" alt="">
											</span>
										</label>
										<!-- Upload button -->
										<label class="btn btn-sm btn-primary-soft mb-0" for="uploadfile-1">Change</label>
										<input id="uploadfile-1" class="form-control d-none" type="file">
									</div>
								</div>

								<!-- Name -->
								<div class="col-md-6">
									<label class="form-label">Full Name<span class="text-danger">*</span></label>
									<input type="text" class="form-control" value="${user.nameUS}" placeholder="Enter your full name" name="fullname">
								</div>

								<!-- Mobile -->
								<div class="col-md-6">
									<label class="form-label">Mobile number<span class="text-danger">*</span></label>
									<input type="text" class="form-control" value="${user.phoneUS}" placeholder="Enter your mobile number" name="phone">
								</div>

								<!-- Date of birth -->
								<div class="col-md-6">
									<label class="form-label">Date of Birth<span class="text-danger">*</span></label>
									<input type="text" class="form-control flatpickr" value="${user.birthdayUS}" placeholder="Enter date of birth" data-date-format="d M Y" name="birthday">
								</div>

								<!-- Gender -->
								<div class="col-md-6">
									<label class="form-label">Select Gender<span class="text-danger">*</span></label>
									<div class="d-flex gap-4 pt-2">
										<div class="form-check radio-bg-light">
										
											<input name="gender" value="1" class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" ${user.sexUS == 1 ? 'checked':''}>
											<label class="form-check-label" for="flexRadioDefault1">
												Male
											</label>
										</div>
										<div class="form-check radio-bg-light">
											<input name="gender" value="0" class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" ${user.sexUS == 0 ? 'checked':''}>
											<label class="form-check-label" for="flexRadioDefault2">
												Female
											</label>
										</div>
									</div>
								</div>

								<!-- Address -->
								<div class="col-12">
									<label class="form-label">Address</label>
									<textarea class="form-control" rows="3" spellcheck="false" placeholder="Enter your address" name="address">${user.addressUS}</textarea>
								</div>

								<!-- Button -->
								<div class="col-12 text-end">
									<button type="submit" class="btn btn-primary mb-0">Save Changes</button>
								</div>
							</form>
							<!-- Form END -->
						</div>
						<!-- Card body END -->
					</div>
					<!-- Personal info END -->
					
					<!-- Update Password START -->
					<div class="card border">
						<!-- Card header -->
						<div class="card-header border-bottom">
							<h4 class="card-header-title">Update Password</h4>
						</div>
						
						<!-- Card body START -->
						<form class="card-body" action="changepass" method="post">
							<p class="text-danger" role="alert">
								${noti}
							</p>
							<!-- Current password -->
							<div class="mb-3">
								<label class="form-label">Current password<span class="text-danger">*</span></label>
								<input class="form-control" type="password" placeholder="Enter current password" name="currentpass">
							</div>
							<!-- New password -->
							<div class="mb-3">
								<label class="form-label"> New password<span class="text-danger">*</span></label>
								<div class="input-group">
									<input class="form-control fakepassword" placeholder="Enter new password" type="password" id="psw-input" name="newpass">
									<span class="input-group-text p-0 bg-transparent">
										<i class="fakepasswordicon fas fa-eye-slash cursor-pointer p-2"></i>
									</span>
								</div>
							</div>
							<!-- Confirm -->
							<div class="mb-3">
								<label class="form-label">Confirm new password<span class="text-danger">*</span></label>
								<input class="form-control" type="password" placeholder="Confirm new password" name="confirmnewpass">
							</div>

							<div class="text-end">
								<button type="submit" class="btn btn-primary mb-0">Change Password</button>
							</div>
						</form>
						<!-- Card body END -->
					</div>
					<!-- Update Password END -->
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