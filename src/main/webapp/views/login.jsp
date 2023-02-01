<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//WSC/DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../styles/base_styles.css">
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
            <s:form>
                <h2>Login</h2>
                <div class="form_fields">
                    <label><s:text name="global.email" /></label>
                    <s:textfield theme="simple" />
                    <label><s:text name="global.password" /></label>
                    <s:textfield theme="simple" />
                    <s:submit cssClass="btn_submit" key="global.signin" />
                    <a href="#">Forgot Password?</a>
                </div>
            </s:form>
        </div>
    </main>
</body>
</html>