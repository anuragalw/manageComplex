<%@page import="com.manage.complex.util.ManageComplexConstant"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Sign in Page</title>
</head>
<body>
	<center>
		<h3>Sign in Page</h3>
		<br />
		<form:form commandName="<%=ManageComplexConstant.SIGN_UP_MODEL %>"
			method="POST" name="login">
Username:<form:input path="email" />
			<font color="red"><form:errors path="email" /></font>
			<br />
			<br />
Password:<form:password path="password" type="password" />
			<font color="red"><form:errors path="password" /></font>
			<br />
			<br />
			<input type="submit" value="signin" />
		</form:form>
	</center>
</body>
</html>

