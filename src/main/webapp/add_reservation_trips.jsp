<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/3/2023
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<s:form theme="simple" cssClass="container">
  <div class="text_input">
    <label>Passenger Name(s)</label>
    <s:textfield id="passenger_name" cssClass="textfield" name="passengerName" />
  </div>
  <div class="text_input">
    <label>Number of Passengers</label>
    <s:textfield cssClass="textfield" name="noOfPassengers" label="Number of Passengers" />
  </div>
  <div class="text_input">
    <label>Phone number</label>
    <s:textfield cssClass="textfield" name="passengerPhoneNumber" label="Phone number" />
  </div>
  <div class="text_input">
    <label>Email</label>
    <s:textfield cssClass="textfield" name="passengerEmail" label="Email" />
  </div>
  <div class="text_input">
    <label>Departure</label>
    <s:textfield cssClass="textfield" name="departure" label="Departure" />
  </div>
  <div class="text_input">
    <label>Destination</label>
    <s:textfield cssClass="textfield" name="destination" label="Destination" />
  </div>
  <div class="text_input">
    <label>Possible Stop(s)</label>
    <s:textfield cssClass="textfield" name="possibleStops" label="Possible Stop(s)" />
  </div>
  <!-- Pickup and End date -->
  <div class="text_input">
    <label>Vehicle Category</label>
    <s:textfield cssClass="textfield" name="vehicleCategory" label="Vehicle Category" />
  </div>
  <div class="text_input">
    <label>Vehicle Type</label>
    <s:textfield cssClass="textfield" name="vehicleType" label="Vehicle Type" />
  </div>
  <div class="text_input">
    <label>Service type:</label>
    <s:radio name="serviceType" cssClass="service_type_list" list="{'Home', 'Jason'}" label="Service Type" />
  </div>
  <div class="text_input">
    <label>Number of Days</label>
    <s:textfield cssClass="textfield" name="noOfDays" />
  </div>
  <div class="text_input">
    <label>Price per Day</label>
    <s:textfield cssClass="textfield" name="pricePerDay" />
  </div>
  <div class="text_input">
    <label>Additional Information</label>
    <s:textarea rows="4" cssClass="textfield" name="additionalInformation" />
  </div>
  <!-- Personnel type -->
  <div class="text_input">
    <label>Personnel: </label>
    <s:select list="{'Driver', 'Battery Changer'}" headerValue="--Select type--" headerKey="-1" />
    <s:select list="{'Driver', 'Battery Changer'}" headerKey="-1" headerValue="--Select Personnel--" />
  </div>
  <div class="text_input">
    <label>Vehicle: </label>
    <s:select list="{'Driver', 'Battery Changer'}" headerValue="--Select type--" headerKey="-1" />
    <s:select list="{'Driver', 'Battery Changer'}" headerKey="-1" headerValue="--Select Vehicle--" />
  </div>
  <div class="text_input">
    <s:checkbox name="isResourceAvailable" />
    <label>Is Resource Available</label>
  </div>
  <div class="text_input" style="width: 100%">
    <label>Total Amount: </label>
  </div>
  <!-- Total Amount -->
  <s:submit value="Save" cssClass="btn_submit btn_save" />
  <div class="trips">
    <label>Added Trips</label>
  </div>
</s:form>
