<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/3/2023
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Reservation</title>
  <link rel="stylesheet" href="styles/base_styles.css" />
  <link rel="stylesheet" href="styles/reservation.css" />
  <sx:head />
</head>
<body>
  <s:include value="header.jsp" />
  <div class="box">
    <sx:tabbedpanel id="test" selectedTab="%{tab}">
      <sx:div id="details" label="Details" theme="ajax">
        <s:action name="addReservationActionDetails" executeResult="true"/>
      </sx:div>
      <sx:div id="trips" label="Trips" theme="ajax">
        <s:action name="addReservationActionTrips" executeResult="true"/>
      </sx:div>
    </sx:tabbedpanel>
  </div>
</body>
</html>
