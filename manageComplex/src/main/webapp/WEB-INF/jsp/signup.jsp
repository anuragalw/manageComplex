<%@page import="com.manage.complex.util.ManageComplexConstant"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>Sign Up</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <style>
      body { background-color: #eee; font: helvetica; }
      #container { width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; box-shadow: 5px; }
      .green { font-weight: bold; color: green; }
      .message { margin-bottom: 10px; }
      label {width:120px; display:inline-block;}
      form {line-height: 300%; }
      .hide { display: none; }
    </style>
  </head>
  <body>

  <div id="container">

    
    <form:form commandName="<%=ManageComplexConstant.SIGN_UP_MODEL %>">
    <%if(request.getAttribute(ManageComplexConstant.USER_EXIT)!=null){ %>
    	<p style="color:red"> Email id already exit.</p>
    <%} %>
  	  </br>
      <label for="nameInput">First Name: </label>
      <form:input path="firstName" id="firstnameInput"/>
      <br/>
    	 <label for="nameInput">Last Name: </label>
      <form:input path="lastName" id="nameInput" />
      <br/>
      <label for="emailInput">Email: </label>
      <form:input path="email" id="emailInput" />
      <br/>
		
	<label for="phoneNo">Phone No: </label>
      <form:input path="phoneNo" id="phoneNo" />
      <br/>
		
     <label for="password">Password : </label>
      <form:input type="password" path="password" id="pwd" />
      <br/>
      
	 <label for="password">Confirm Password : </label>
      <form:input type="password" path="confirmPassword" id="confirmPassword"/>
      
      <input type="submit" value="Submit" style="align:center" />
    </form:form>
  </div>

 

  </body>
</html>