<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<title>Login Page</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/css/add-student-style.css">
	
</head>

<body>

	<div id="container">

		<h3>Login Details</h3>

		<form:form action="readLoginData" modelAttribute="login" method="POST">

			<table>

				<tbody>

					<tr>
						<td><label>User Name:</label></td>
						<td><form:input path="userName" placeholder="Enter User Name"/></td>
					</tr>

					<tr>
						<td><label>Password:</label></td>
						<td><form:input path="password" type ="password"  placeholder="Enter Password" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Login" class="save" /></td>
					</tr>


				</tbody>

			</table>

		</form:form>

	</div>
</body>

</html>










