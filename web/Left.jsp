

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3">
                        <div class="card bg-light mb-3">
                            <div style="background-color: #ffb700" class="card-header text-white text-uppercase"> Categories</div>
                            <ul class="list-group category_block">
                                <c:forEach items="${listC}" var="o">
                                <li class="list-group-item text-white ${tag == o.cid ? "active" : ""}"><a href="CategoryControl?cid=${o.cid}">${o.cname}</a></li>
                                </c:forEach>

                        </ul>
                    </div>
                  
                </div>
