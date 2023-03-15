<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">


<div class="container">
    <br>  <p class="text-center"><a href="http://bootstrap-ecommerce.com/"> </a></p>
    <hr>


    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <header style="background-color: #ffb700" class="card-header">
                    <a href="Home" class="float-right btn btn-outline-primary mt-1">Home</a>
                    <h4 class="card-title mt-2">Change Information</h4>
                </header>
                <article class="card-body">
                    <form action="changeinfo" method="post">
                        <p class="text-danger">${ms}</p>
                        <div class="form-row">

                            <div class="col form-group">
                                <label>User name </label>   
                                <input value="${a.user}" name="user" type="text" class="form-control" readonly placeholder="">
                            </div> <!-- form-group end.// -->
                            <div class="col form-group">
                                <label>Phone number</label>
                                <input value="${a.phone}" name="phone" type="text" class="form-control" placeholder=" ">
                            </div> <!-- form-group end.// -->
                        </div> <!-- form-row end.// -->
                        <div class="form-group">
                            <label>Email address</label>
                            <input value="${a.email}" name="email" type="email" class="form-control" placeholder="">
                            <small class="form-text text-muted">We'll never share your email with anyone else.</small>
                        </div> <!-- form-group end.// -->
                        <div class="form-group">
                            <label>Gender: </label>
                            <input class="gender choice" type="radio" name="gender" value="M" ${a.gender?"checked":""} >Male
                            <input class="gender choice" type="radio" name="gender" value="F" ${a.gender?"":"checked"}>Female
                        </div> <!-- form-group end.// -->
                        <div class="form-group">
                            <label>Birthday: </label>
                            <input value="${dob}" type="date" id="birthday" name="dob" ">
                        </div> <!-- form-group end.// -->  
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block"> Change  </button>
                        </div> <!-- form-group// -->      
                        <small class="text-muted">By clicking the 'Sign Up' button, you confirm that you accept our <br> Terms of use and Privacy Policy.</small>                                          
                    </form>
                </article> <!-- card-body end .// -->

            </div> <!-- card.// -->
        </div> <!-- col.//-->

    </div> <!-- row.//-->


</div> 
<!--container end.//-->
