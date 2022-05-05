<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    <title>Home</title>
  </head>
  <body class="container-sm" ">
    
    <div>
        <nav class="navbar navbar-expand-lg navbar-light">
            <div class="container-fluid">
              <a class="navbar-brand link-dark" href="index.jsp"><b class="align-middle me-2" style="letter-spacing:0.5px;">Home</b></a>
              <button class="navbar-toggler btn-light" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon " ></span>
              </button>
              <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                <ul class="navbar-nav  ">
                    <li class="nav-item">
                        <a style="padding: 5px;"class="nav-link link-dark" href="Profile">Profile</a>
                      </li>
                  <li class="nav-item">
                    <a  style="padding: 5px;" class="nav-link link-dark" aria-current="page" href="signin.jsp">Sign In</a>
                  </li>
                  <li class="nav-item">
                    <a style="padding: 5px;"class="nav-link link-dark" href="signup.jsp">Sign Up</a>
                  </li>  
                    <li class="nav-item">
                    <a style="padding: 5px;"class="nav-link link-dark" href="Logout">Log out</a>
                  </li>      
                </ul>
              </div>
            </div>
          </nav>
        <div>
          <div class="d-flex flex-column align-items-center  justify-content-center " style="height: 400px;">
             <c:choose>  
    <c:when test="${loggedin == true}">  
       You are successfully logged out  
    </c:when>   
    <c:otherwise>  
       Please, Sign In  
    </c:otherwise>  
		</c:choose>
          </div>
        </div>
    </div>
 
    
    
  </body>
</html>