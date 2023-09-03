<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/bootstrap-4.3.1.css">
</head>

<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container justify-content-center"> <button class="navbar-toggler navbar-toggler-right border-0" type="button" data-toggle="collapse" data-target="#navbar9">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse text-center justify-content-center" id="navbar9">
        <ul class="navbar-nav">
          <li class="nav-item mx-2"> <a class="nav-link" href="<%= request.getContextPath() %>/index.jsp">Create</a> </li>
          <li class="nav-item mx-2"> <a class="nav-link" href="<%= request.getContextPath() %>/read.jsp">Read</a> </li>
          <li class="nav-item mx-2"> <a class="nav-link navbar-brand mr-0 text-white" href="#"><i class="fa d-inline fa-lg fa-stop-circle-o"></i>
              <b>Phoenix</b></a> </li>
          <li class="nav-item mx-2"> <a class="nav-link" href="<%= request.getContextPath() %>/update.jsp?id=1">Update</a> </li>
          <li class="nav-item mx-2"> <a class="nav-link" href="<%= request.getContextPath() %>/delete.jsp?id=1">Delete</a> </li>
        </ul>
      </div>
    </div>
  </nav>
  
${msg}