<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>
  <head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/wallStyle.css"/>
  </head>
  <body>
  <div class="container">
    <div class="row">
        <div class="form_bg">
            <form name="form" method="post" action="">
                <div class="form-group">
                    <p align="center">
                    <img src="images/image.png" height=50px width=200px></p>
                </div>
                <h1 align="center" class="text-center">Login</h1>
                <div class="form-group">
                  <p align="center">
                    <label><b>User Name</b></label>&nbsp;
                    <input type="text" name="user_name" class="form-control" id="userid" placeholder="User id">
                  </p>
                </div>
                <div class="form-group">
                  <p align="center">
                  <label><b>Password</b></label> &nbsp;&nbsp;
                  <input type="password" name="password" class="form-control" id="pwd" placeholder="Password">
                  </p>
                </div>
                <br/>
                <div class="align-center">
                    <button type="submit" class="btn btn-default" id="login"><b>Login</b></button>&nbsp;&nbsp;
                    <button type="reset" class="btn btn-default" id="reset"><b>Reset</b></button>
                </div>
            </form>
        </div>
    </div>
</div>
  </body>
  </html>