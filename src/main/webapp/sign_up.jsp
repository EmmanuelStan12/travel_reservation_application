<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//WSC/DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/base_styles.css">
    <title>Login</title>
    <style>
        .form_field {
            width: 100%;
            display: block;
        }
    </style>
</head>
<body>
<main>
    <div class="container">
        <s:form theme="simple" action="loginAction">
            <h2>Register</h2>
            <div class="form_fields">
                <div class="auth_field">
                    <label>Firstname</label>
                    <s:textfield style="flex: 1;" cssClass="textfield" name="email" />
                </div>
                <div class="auth_field">
                    <label>Lastname</label>
                    <s:textfield style="flex: 1;" cssClass="textfield" name="email" />
                </div>
                <div class="auth_field">
                    <label>Email</label>
                    <s:textfield style="flex: 1;" cssClass="textfield" name="email" />
                </div>
                <div class="auth_field">
                    <label>Password</label>
                    <s:textfield style="flex: 1;" cssClass="textfield" name="email" />
                </div>
                <s:submit cssClass="btn_submit" value="Sign up" />
                <a style="display: block; margin-top: 10px" href="#">Already have an account? Login</a>
            </div>
        </s:form>
    </div>
</main>
</body>
</html>