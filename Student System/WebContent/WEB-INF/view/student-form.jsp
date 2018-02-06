<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<title>Save Student</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/css/add-student-style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Student Directory</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Student</h3>

		<form:form action="saveStudent" modelAttribute="student" method="POST">

			<!-- need to associate this data with student id -->
			<form:hidden path="id" />

			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" placeholder="Enter First Name"/></td>
					</tr>

					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" placeholder="Enter Last Name"/></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" placeholder="Enter E-mail Address"/></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>


				</tbody>
			</table>


		</form:form>

		<div style=""></div>

		<p>
			<a href="${pageContext.request.contextPath}/student/showStudents">Back to
				Student Home</a>
		</p>

	</div>

</body>

</html>










