<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Training</title>
 <style type="text/css">
 
lable {
font-weight: bold;
}
.form-header  {
  background-color: #EFF0F1;
  border-top-left-radius: 5px;
  border-top-right-radius: 5px;
}
.form-header h1 {
  font-size: 30px;
  text-align:center;
  color:#666;
  padding:20px 0;
  border-bottom:1px solid #cccccc;
}
.form-body {
  padding:10px 40px;
  color:#000000;
}
.horizontal-group .left{
  float:left;
  width:49%;
}
.horizontal-group .right{
  float:right;
  width:49%;
}
</style>

 <link href="http://localhost:8080/webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="http://localhost:8080/webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="http://localhost:8080/webjars/jquery/3.0.0/js/jquery.min.js" ></script>
</head>
<body>
 <div class="container">
 <div class="form-body">
  <spring:url value="/meeting/save" var="saveURL" />
  <div class="form-header">
  <h1>Training</h1>
  </div>
  <form:form modelAttribute="employeeForm" method="post" action="${saveURL }" cssClass="form">
   <form:hidden path="employeeId"/>
   <div class="form-group">
    <lable for="name">Name</lable>
    <form:input path="name" cssClass="form-control" id="name" />
   </div>
   <div class="form-group">
    <lable for="email">Email</lable>
    <form:input path="email" cssClass="form-control" id="email" />
   </div>
   <div class="horizontal-group">
   <div class="form-group left">
    <lable for="duration">Duration</lable>
    <form:input path="duration" cssClass="form-control" id="duration" />
   </div>
   <div class="form-group right">
    <lable for="modeOfTraining">Mode of Training</lable>
    <form:input path="modeOfTraining" cssClass="form-control" id="modeOfTraining" />
   </div>
   </div>
   <div class="horizontal-group">
   <div class="form-group left">
    <lable for="startDate">Start Date</lable>
    <form:input type="date" path="startDate" cssClass="form-control" id="startDate" />
   </div>
   <div class="form-group right">
    <lable for="endDate">End Date</lable>
    <form:input type="date" path="endDate" cssClass="form-control" id="endDate" />
   </div>
   </div>
   <div class="horizontal-group">
   <div class="form-group left">
    <lable for="domain">Domain</lable>
    <form:input path="domain" cssClass="form-control" id="domain" />
   </div>
   <div class="form-group right">
    <lable for="venue">Venue</lable>
    <form:input path="venue" cssClass="form-control" id="venue" />
   </div>
   </div>
   <div class="form-group">
    <lable for="status">Status</lable>
    <form:input path="status" cssClass="form-control" id="status" />
   </div>
   <div>
      <button type="submit" class="btn btn-primary">Request</button>
	</div>
  </form:form>
  </div>
 </div>
</body>
</html>