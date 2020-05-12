<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Meeting Form</title>
 <link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="../webjars/jquery/3.0.0/js/jquery.min.js" ></script>
</head>
<body>
 <div class="container">
  <h2 style="text-align:center;">Training Schedule Data</h2>
  <table class="table table-striped">
   <thead>
    <tr>
     <th scope="row">Id</th>
     <th scope="row">Name</th>
     <th scope="row">Email</th>
     <th scope="row">Duration</th>
     <th scope="row">Mode of Training</th>
     <th scope="row">Start Date</th>
     <th scope="row">End Date</th>
     <th scope="row">Domain</th>
     <th scope="row">Venue</th>
     <th scope="row">Status</th>
     <th scope="row">Edit</th>
    </tr>
   </thead>
   <tbody>
    <c:forEach items="${employee_list }" var="meeting" >
     <tr>
      <td>${meeting.employeeId }</td>
      <td>${meeting.name }</td>
      <td>${meeting.email }</td>
      <td>${meeting.duration }</td>
      <td>${meeting.modeOfTraining }</td>
      <td>${meeting.startDate }</td>
      <td>${meeting.endDate }</td>
      <td>${meeting.domain }</td>
      <td>${meeting.venue }</td>
      <td>${meeting.status }</td> 
      <td>
       <spring:url value="/meeting/update/${meeting.employeeId }" var="updateURL" />
       <a class="btn btn-primary" href="${updateURL }" role="button">Update</a>
      </td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
  <spring:url value="/meeting/add" var="addURL" />
  <a class="btn btn-primary" href="${addURL }" role="button">Add New Trainer</a>
 </div>
</body>
</html>