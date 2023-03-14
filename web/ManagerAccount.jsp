<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
          <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    <body style="background-image: url('https://demoda.vn/wp-content/uploads/2022/01/hinh-nen-cho.jpg')">
        <div class="container">
            <div  class="table-wrapper">
                     <div style="background-color: #ffb700" class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>ACCOUNT LIST</h2>
                        </div>
                        <div class="col-sm-6">
                         
                            <a style="background-color: blue" href="/Home" class="btn" data-toggle="modal"> <span>HOME</span></a>						
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                   
                    <tbody>
                        <c:forEach items="${listP}" var="o">
                            <tr>
                                
                                <td>${o.id}</td>
                                <td>${o.user}</td>
                                <td>${o.email}</td>
                                <td>${o.dateOfBirth}</td>
                                <td>
                                    <a style="color: #ffb700" href="loadaccount?auser=${o.user}"  class="edit" data-toggle="modal">edit</a>
                                    <a style="color: black" href="deleteaccount?aid=${o.id}" class="delete" data-toggle="modal">delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
               
            </div>
        </div>
        
        
       
        <script src="js/manager.js" type="text/javascript"></script>
        <script>
               
        </script>
    </body>
</html>