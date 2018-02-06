
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>

<title>List Students</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Student Directory</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!-- put new button: Add Student -->

			<input type="button" value="Add Student"
				onclick="window.location.href='addStudent'; return false;"
				class="add-button" />

			<!--  add a search box -->
			<form:form action="searchStudent" method="POST">
                Search customer: <input type="text" name="searchName" />
				<input type="submit" value="Search" class="add-button" />
			</form:form>

			<!--  add our html table here -->

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="stud" items="${students}">

					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/student/updateStudent">
						<c:param name="studentId" value="${stud.id}" />
					</c:url>

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/student/deleteStudent">
						<c:param name="studentId" value="${stud.id}" />
					</c:url>


					<tr>
						<td>${stud.firstName}</td>
						<td>${stud.lastName}</td>
						<td>${stud.email}</td>
						<td>
							<!-- display the update link --> <a href="${updateLink}">Update</a>
							| <a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a>

						</td>
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>

	<div>


		<br>
		<table>

			<!-- put new button: Logout -->
			<form:form action="logoutStudent" method="POST">
				<input type="submit" value="Logout" class="save" />
			</form:form>

		</table>
	</div>


</body>

</html>









