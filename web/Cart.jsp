<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>

    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
            <div class="shopping-cart">
                <div class="px-4 px-lg-0">

                    <div class="pb-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                                    <!-- Shopping cart table -->
                                    <div class="table-responsive">
                                        <table  class="table">
                                            <thead >
                                                <tr style="background-color: #ffb700">
                                                    <th scope="col" class="border-0 ">
                                                        <div class="p-2 px-3 text-uppercase">STT</div>
                                                    </th>
                                                    <th scope="col" class="border-0 ">
                                                        <div class="p-2 px-3 text-uppercase">Tên</div>
                                                    </th>
                                                    <th scope="col" class="border-0 ">
                                                        <div class="py-2 text-uppercase">Số Lượng</div>
                                                    </th>
                                                    <th scope="col" class="border-0">
                                                        <div class="py-2 text-uppercase">Đơn Giá</div>
                                                    </th>  
                                                    <th scope="col" class="border-0">
                                                        <div class="py-2 text-uppercase">Tổng tiền</div>
                                                    </th> 
                                                    <th scope="col" class="border-0">
                                                        <div class="py-2 text-uppercase">Xóa</div>
                                                    </th>
                                                </tr>
                                            </thead>
                                            
                                            <c:set var="o" value="${requestScope.cart}"/>
                                            <c:set var="tt" value="0"/>
                                            <c:forEach items="${o.items}" var="i">
                                                <c:set var="tt" value="${tt+1}"/>
                                                <tr>
                                                    <td>${tt}</td>
                                                    <td>${i.product.title}</td>
                                                    <td >
                                                        <button><a href="process?num=-1&id=${i.product.id}">-</a></button>
                                                        ${i.quantity}
                                                        <button><a href="process?num=1&id=${i.product.id}">+</a></button>
                                                    </td>
                                                    <td class="align-middle"><strong>${i.price}</strong></td>
                                                    <td class="align-middle"><strong>${i.price*i.quantity}</strong></td>
                                                    
                                                    
                                                    <td class="align-middle">
                                                        <form action ="process" method="post">
                                                            <input type="hidden" name="id" value="${i.product.id}"/>
                                                            <input type="submit" value="delete"/>
                                                        </form>
                                                        </a>
                                                    </td>
                                                </tr> 
                                            </c:forEach>
                                        
                                    </table>
                                </div>
                                <!-- End -->
                            </div>
                        </div>

                        <div class="row py-5 p-4 bg-white rounded shadow-sm">
                            <div  class="col-lg-6">
                                <div style="background-color: #ffb700" class="rounded-pill px-4 py-3 text-uppercase font-weight-bold">Voucher</div>
                                <div class="p-4">
                                    <div class="input-group mb-4 border rounded-pill p-2">
                                        <input type="text" placeholder="Nhập Voucher" aria-describedby="button-addon3" class="form-control border-0">
                                        <div class="input-group-append border-0">
                                            <button style="background-color: #ffb700" id="button-addon3" type="button" class="btn btn-dark px-4 rounded-pill"><i class="fa fa-gift mr-2"></i>Sử dụng</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div style="background-color: #ffb700" class="rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành tiền</div>
                                <div class="p-4">
                                    <ul class="list-unstyled mb-4">
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong style="color: #ffb700" >Tổng tiền hàng</strong><strong>$ ${o.totalMoney}</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong style="color: #ffb700">Phí vận chuyển</strong><strong>${o.totalMoney*5/100}</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong style="color: #ffb700">VAT</strong><strong>${o.totalMoney*10/100}</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong style="color: #ffb700">Tổng thanh toán</strong>
                                            <h5 class="font-weight-bold">${o.totalMoney + o.totalMoney*5/100 + o.totalMoney*10/100}</h5>
                                        </li>
                                        <form action="checkout" method="post">
                                    </ul><button style="background-color: #ffb700; color: white" type="submit" style="color: white" class="btn btn-dark rounded-pill py-2 btn-block">Mua hàng</button> 
                                        </form>
                                    
                                </div>
                            </div>
                        </div>
                                        <a href="Home">CONTINUE SHOPPING</a>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>

</html>
</html>
