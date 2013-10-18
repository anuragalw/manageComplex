<%@page import="com.manage.complex.util.ManageComplexConstant"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Forgot Password</title>
</head>
<body>
	<center>
		<h3>Forgot Password</h3>
		<br />
		<form:form commandName="<%=ManageComplexConstant.SIGN_UP_MODEL %>"
			method="POST" name="forgotpw">
Username or Email id:<form:input path="email" />
		
			<input type="submit" value="Reset Password" />
		</form:form>
	</center>
</body>
</html>

