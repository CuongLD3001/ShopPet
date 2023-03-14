
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin of menu-->
<nav style="background-color: #ffb700" class="navbar navbar-expand-md navbar-dark">
    <div  class="container">
       
        
        
        <form action="search" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input value="${txtS}" name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button style="background-color: blue" type="submit" class="btn btn-secondary btn-number">
                            search
                        </button>
                    </div>
                </div>
                
            </form>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                
                <c:if test="${sessionScope.acc != null}">
                    <li class="nav-item">
                        <a style="color: black; font-weight: bold;" class="nav-link" href="logout">LOGOUT</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.acc == null}">
                    <li class="nav-item">
                        <a style="color: black; font-weight: bold;" class="nav-link" href="Login.jsp">LOGIN</a>
                    </li>
                </c:if>
            </ul>
            <a  style="background-color: blue; color: white" class="btn btn-sm ml-3" href="show">
                    Cart <span class="badge badge-light">${requestScope.size}</span>
                </a>

            
        </div>
    </div>
</nav>
<section class="jumbotron text-center">
    <div class="banner">
        <img class="banner" src="/images/banner.png" />

    </div>
</section>
<!--end of menu-->