<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="/css/style.css"/>
        <link rel="stylesheet" href="/css/manager.css"/>
        <link rel="stylesheet" href="/css/login.css"/>
        <link rel="stylesheet" href="/css/detal.css"/>

        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <style>
            .pagination{
                display: inline-block;
            }
            .pagination a{
                color: black;
                font-size: 22px;
                float: left;
                padding: 8px 16px;
                text-decoration: none;
            }
            .pagination a.active{
                background-color: #ffb700;
                color: white;
            }
            .pagination a:hover:not(.active){
                background-color: #ffb700;
                }
        </style>
    <body>
        <jsp:include page = "Menu.jsp"></jsp:include>
            <div class="container">
                <div class="row">
                    <div  class="col">
                        <nav  aria-label="breadcrumb">
                            <ol  style="background-color:#ffb700" class="breadcrumb">
                                <li class="breadcrumb-item"><a style="color: black; font-weight: bold;" href="Home">Home</a></li>
                                <c:if test="${sessionScope.acc.isAdmin == 1}">
                                <li class="breadcrumb-item"><a style="color: black; font-weight: bold;" href="manageraccount">Manager Account</a></li>
                                </c:if>
                                <c:if test="${sessionScope.acc.isSell == 1}">
                                <li class="breadcrumb-item"><a style="color: black; font-weight: bold;" href="/manage">Manager Product</a></li>
                                </c:if>
                                <c:if test="${sessionScope.acc != null}">
                                <li class="breadcrumb-item"><a style="color: black; font-weight: bold;" href="/changepass">Change Password</a></li>
                                </c:if>
                                <c:if test="${sessionScope.acc != null}">
                                <li class="breadcrumb-item"><a style="color: black; font-weight: bold;" href="changeinfo">  ${sessionScope.acc.user}</a></li>
                                </c:if>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
        <c:set var="page" value="${requestScope.page}"/>
        <form name="sp" action="" method="post">
            <input type="hidden" name="num" value="1">
            <div class="container">
                <div class="row">
                    <jsp:include page = "Left.jsp"></jsp:include>
                        <div class="col-sm-9">
                            <div class="row">
                            <c:forEach items="${requestScope.listP}" var="o">
                                <c:set var="id" value="${o.id}"/>
                                <div class="col-12 col-md-6 col-lg-4">
                                    <div class="card">
                                        <img class="card-img-top" src="${o.image}" alt="Card image cap">
                                        <div class="card-body">
                                            <h4 class="card-title show_txt"><a  style="color: #ffb700" href="DetailControl?pid=${o.id}" title="View Product">${o.title}</a></h4>
                                            <p class="card-text show_txt">Số lượng: ${o.quantity}</p>
                                            <div class="row">
                                                <div class="col">
                                                    <p style="background-color: white; color: red; font-size: large; font-weight: bold" class="btn btn-block">${o.price} $</p>
                                                </div>
                                                <div  class="col">
                                                    <input style="background-color: #008bf6; color: black; font-weight: bold" type="button" onclick="buy('${id}')" value="ADD TO CART" class="btn btn-block">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                             <div class="pagination">
                        <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                            <a class="${i==page?"active":""}" href="Home?page=${i}">${i}</a>
                        </c:forEach>
                    </div>
                    </div>             
                </div>
            </div>
        </form> 
        <jsp:include page = "Footer.jsp"></jsp:include>
    </body>
</html>
<script type="text/javascript">
    function buy(id) {
        var m = document.sp.num.value;
        document.sp.action = "buy?id=" + id + "&num=" + m;
        document.sp.submit();
    }


</script>

