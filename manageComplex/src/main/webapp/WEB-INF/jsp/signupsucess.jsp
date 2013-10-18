<%@page import="com.manage.complex.util.ManageComplexConstant"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>Sign Up successfully </title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <style>
      body { background-color: #eee; font: helvetica; }
      #container { width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; box-shadow: 5px; }
      .green { font-weight: bold; color: green; }
      .message { margin-bottom: 10px; }
      label {width:70px; display:inline-block;}
      form {line-height: 160%; }
      .hide { display: none; }
    </style>
  </head>
  <body>

  <div id="container">
<form:form commandName="<%=ManageComplexConstant.SIGN_UP_MODEL %>">
  <b> Dear ${signupModel.firstName},</b><br/><br/>
   Your account has been created successfully in managecomplex.
   <br/>
   Please confirm your email id. 
   </form:form>
  </div>

 

  </body>
</html>