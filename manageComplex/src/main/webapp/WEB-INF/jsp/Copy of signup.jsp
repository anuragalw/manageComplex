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
      label {width:70px; display:inline-block;}
      form {line-height: 160%; }
      .hide { display: none; }
    </style>
  </head>
  <body>

  <div id="container">

    
    <form:form modelAttribute="signupmodel">
      <label for="nameInput">First Name: </label>
      <form:input path="firstName" id="nameInput" />
      <br/>

    	 <label for="nameInput">Last Name: </label>
      <form:input path="lastName" id="nameInput" />
      <br/>
      <label for="emailInput">Email: </label>
      <form:input path="emailId" id="emailInput" />
      <br/>

     
      

     
      
      
      <br/>

      <br/>
      <input type="submit" value="Submit" />
    </form:form>
  </div>

  <script type="text/javascript">

    $(document).ready(function() {

      toggleFrequencySelectBox(); // show/hide box on page load

      $('#newsletterCheckbox').change(function() {
        toggleFrequencySelectBox();
      })

    });

    function toggleFrequencySelectBox() {
      if(!$('#newsletterCheckbox').is(':checked')) {
        $('#frequencySelect').val('');
        $('#frequencySelect').prop('disabled', true);
      } else {
        $('#frequencySelect').prop('disabled', false);
      }
    }

  </script>

  </body>
</html>