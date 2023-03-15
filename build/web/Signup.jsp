<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">


<div class="container">

    <hr>


    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <header style="background-color: #ffb700" class="card-header">
                    <a  href="Login.jsp" "  class="float-right btn btn-outline-primary mt-1">Log in</a>
                    <h4 class="card-title mt-2">Sign up</h4>
                </header>
                <article class="card-body">
                    <form action="signup" method="post">
                        <p class="text-danger">${mess2}</p>
                        <div class="form-row">
                            <div class="col form-group">
                                <label>User name: </label>   
                                <input value="${user}" name="user" type="text" class="form-control" placeholder="">
                            </div> <!-- form-group end.// -->
                            <div class="col form-group">
                                <label>Phone number: </label>
                                <input value="${phone}" name="phone" type="text" class="form-control" placeholder=" ">
                            </div> <!-- form-group end.// -->
                        </div> <!-- form-row end.// -->
                        <div class="form-group">
                            <label>Gender: </label>
                            <input class="gender choice" type="radio" name="gender" value="M" ${gender?"checked":""} >Male
                            <input class="gender choice" type="radio" name="gender" value="F" ${gender?"":"checked"}>Female
                        </div> <!-- form-group end.// -->
                        <div class="form-group">
                            <label>Birthday: </label>
                            <input value="${dob}" type="date" id="birthday" name="dob" >
                        </div> <!-- form-group end.// -->  
                        <div class="form-group">
                            <label>Email address: </label>
                            <input value="${email}" name="email" type="email" class="form-control" placeholder="">
                            <small class="form-text text-muted">We'll never share your email with anyone else.</small>
                        </div> <!-- form-group end.// -->
                        <div class="form-group">
                            <label>Create password: </label>
                            <input name="pass" class="form-control" type="password">
                        </div> <!-- form-group end.// -->  
                        <div class="form-group">
                            <label>Re-enter password again: </label>
                            <input name="repass" class="form-control" type="password">
                        </div> <!-- form-group end.// -->  
                        <div class="form-group">
                            <label >Security Question: </label>
                            <select name="sq" class="form-control">
                                <option value="What is your childhood dream?">What is your childhood dream?</option>
                                <option value="What do you like to eat best?">What do you like to eat best?</option>
                                <option value="What is your favorite car company?">What is your favorite car company?</option>
                                <option value="What's your favorite name?">What's your favorite name?</option>
                            </select>
                        </div> 
                        <div class="form-group">
                            <label>Answer: </label>
                            <input value="${answer}" name="answer" class="form-control" type="text">
                        </div> <!-- form-group end.// -->  
                        <div class="form-group">
                            <label>Captcha: </label>
                            <input  name="captcha" value="${requestScope.captcha}" class="form-control" type="text" disabled>
                        </div>   
                        <div class="form-group">
                            <label>Re-enter Captcha: </label>
                            <input name="checkcaptcha" class="form-control" type="text">
                        </div> <!-- form-group end.// -->  
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block"> Register  </button>
                        </div> <!-- form-group// -->      
                        <small class="text-muted">By clicking the 'Sign Up' button, you confirm that you accept our <br> Terms of use and Privacy Policy.</small>                                          
                    </form>
                </article> <!-- card-body end .// -->
                <div style="background-color: #ffb700" class="border-top card-body text-center">Have an account? <a href="Login.jsp">Log In</a></div>
            </div> <!-- card.// -->
        </div> <!-- col.//-->

    </div> <!-- row.//-->


</div> 
<!--container end.//-->
