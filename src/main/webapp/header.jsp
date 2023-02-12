<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/3/2023
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//WSC/DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link type="text/css" href="styles/base_styles.css" />
    <title>Title</title>
</head>
<body>
<s:if test="#session.USER_ID==null">
    <s:action name="login" executeResult="true"/>
</s:if>
<div class="navbar">
    <a href="home.jsp">Syserve Solutions</a>
    <ul>
        <li><s:a action="homeAction">Reservations</s:a></li>
        <li><s:a action="addReservation">Add Reservations</s:a></li>
        <li><s:a action="logoutAction">Logout</s:a></li>
    </ul>
</div>
</body>
</html>
