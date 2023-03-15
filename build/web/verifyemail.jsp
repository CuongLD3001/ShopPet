<%-- 
    Document   : PassReset
    Created on : Oct 26, 2022, 2:10:07 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="card card-outline-secondary">
                        <div class="card-header">
                            <h3 class="mb-0">Verify Email</h3>
                        </div>
                        <div class="card-body">
                            <form action="verifymail" class="form" role="form" autocomplete="off" method="post">
                                <div class="form-group">
                                    <label for="inputResetPasswordEmail">Enter code</label>
                                    <input type="text" name="authcode" class="form-control" id="inputResetPasswordEmail" required="">
                                    <span id="helpResetPasswordEmail" class="form-text small text-muted">
                                            We've sent an email code to your email.
                                        </span>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-success btn-lg float-right">Submit</button>
                                </div>
                            </form>
                        </div>
                    </div>
    </body>
</html>
