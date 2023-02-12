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
  <script src="https://code.jquery.com/jquery-3.6.3.min.js"
          integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
          crossorigin="anonymous"></script>
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
      <button class="btn_submit" type="button" id="add_reservation_btn">Submit</button>
    </div>
    <div id="overlay">
      <div class="cv-spinner">
        <span class="spinner"></span>
      </div>
    </div>
  <script src="js/trip.js"></script>
  <script src="js/details.js"></script>
  <script src="js/add_reservation.js"></script>
</body>
</html>
