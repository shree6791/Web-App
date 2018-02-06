
<html>
<head>

<title>Student Form</title>

	<script src="<c:url value='/WEB-INF/service/student_service.js' />"></script>
	<script src="<c:url value='/WEB-INF/controller/student_controller.js' />"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	
	<link href="<c:url value='/Resources/css/student.css' />"
		rel="stylesheet"></link>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>

<BODY data-ng-app="">

	<div class="generic-container"
		data-data-ng-controller="StudentController as ctrl">

		<div class="panel panel-default">

			<div class="panel-heading">
				<span class="lead">Student Registration Form </span>
			</div>

			<div class="formcontainer">

				<form data-ng-submit="ctrl.submit()" name="studentForm"
					class="form-horizontal">

					<input type="hidden" data-ng-model="ctrl.student.id" />

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="firstName">Name</label>
							<div class="col-md-7">
								<input type="text" data-ng-model="ctrl.student.firstName"
									id="firstName" class="firstName form-control input-sm"
									placeholder="Enter your name" required data-ng-minlength="3" />
							</div>
						</div>
					</div>


					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="lastName">Last
								Name</label>
							<div class="col-md-7">
								<input type="text" data-ng-model="ctrl.student.lastName"
									id="lastName" class="form-control input-sm" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="email">Email</label>
							<div class="col-md-7">
								<input type="email" data-ng-model="ctrl.student.email"
									id="email" class="email form-control input-sm"
									placeholder="Enter your Email" required />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit"
								value="{{!ctrl.student.id ? 'Add' : 'Update'}}"
								class="btn btn-primary btn-sm"
								data-ng-disabled="studentForm.$invalid">
							<button type="button" data-ng-click="ctrl.reset()"
								class="btn btn-warning btn-sm"
								data-ng-disabled="studentForm.$pristine">Reset Form</button>
						</div>
					</div>

				</form>

			</div>
		</div>

		
	</div>



</BODY>

</HTML>