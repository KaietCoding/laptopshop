<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/demo.css">
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  </head>
  <body>
    <div class="container mt-5">
      <div class="row">
        <div class="col-md-6 ol-12 mx-auto">
          <form:form method="POST" action="/admin/user/create" modelAttribute="newUser">
            <h1>CREATE USER</h1>
            <hr/>
            <div class="mb-3">
              <label for="fullname" class="form-label">Fullname</label>
              <form:input type="text" class="form-control" path="fullname"/>
            </div>
            <div class="mb-3">
              <label for="email" class="form-label">Email address</label>
              <form:input type="email" class="form-control" path="email" aria-describedby="emailHelp"/>
            </div>
            <div class="mb-3">
              <label for="exampleInputPassword1" class="form-label">Password</label>
              <form:input type="password" class="form-control" path="password"/>
            </div>
            <div class="mb-3">
              <label for="phone" class="form-label">Phone Number</label>
              <form:input type="phone" class="form-control" path="phone" />
            </div>
            <div class="mb-3">
              <label for="address" class="form-label">Address</label>
              <form:input type="text" class="form-control" path="address" />
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
          </form:form>
        </div>
      </div>
    </div>
  </body>
</html>