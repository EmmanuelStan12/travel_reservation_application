<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/3/2023
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="trip_form" class="container">
  <div class="text_input">
    <label>Passenger Name(s)</label>
    <input required id="passenger_name" class="textfield" name="passengerName" />
  </div>
  <div class="text_input">
    <label>Number of Passengers</label>
    <input required id="noOfPassengers" type="number" class="textfield" name="noOfPassengers" />
  </div>
  <div class="text_input">
    <label>Phone number</label>
    <input required id="phoneNumber" class="textfield" name="passengerPhoneNumber"  />
  </div>
  <div class="text_input">
    <label>Email</label>
    <input required class="textfield" id="email" />
  </div>
  <div class="text_input">
    <label>Departure</label>
    <input required class="textfield" id="departure"  />
  </div>
  <div class="text_input">
    <label>Destination</label>
    <input required class="textfield" id="destination" />
  </div>
  <div class="text_input">
    <label>Possible Stop(s)</label>
    <input required class="textfield" id="possibleStops" />
  </div>
  <!-- Pickup and End date -->
  <div class="text_input">
    <label>Vehicle Category</label>
    <input required class="textfield" id="vehicleCategory" />
  </div>
<%--  <div class="text_input">--%>
<%--    <label>Vehicle Type</label>--%>
<%--    <s:textfield cssClass="textfield" id="vehicleType" label="Vehicle Type" />--%>
<%--  </div>--%>
  <div class="text_input">
    <label>Service type:</label>
    <input type="radio" name="serviceType" id="poolVehicle" value="Pool Vehicle">
    <label for="poolVehicle">Pool Vehicle</label>
    <input type="radio" name="serviceType" id="rideHailing" value="Ride Hailing">
    <label for="rideHailing">Ride Hailing</label>
  </div>
  <div class="text_input">
    <label>Number of Days</label>
    <input required type="number" class="textfield" id="noOfDays" />
  </div>
  <div class="text_input">
    <label>Price per Day(N)</label>
    <input required type="number" class="textfield" id="pricePerDay" />
  </div>
  <div class="text_input">
    <label>Additional Information</label>
    <textarea required rows="4" class="textfield" id="additionalInformation"></textarea>
  </div>
  <!-- Personnel type -->
  <div class="text_input">
    <label>Personnel: </label>
    <s:select
            list="personnelTypes"
            headerValue="--Select type--"
            headerKey="-1"
            listKey="id"
            listValue="name"
            id="personnel_types"
    />
    <s:select
            list="{}"
            headerKey="-1"
            headerValue="--Select Personnel--"
            id="personals"
    />
  </div>
  <div class="text_input">
    <label>Vehicle: </label>
    <s:select
            list="vehicleTypes"
            headerValue="--Select type--"
            headerKey="-1"
            listKey="id"
            listValue="name"
            id="vehicle_types"
    />
    <s:select
            list="{}"
            headerKey="-1"
            headerValue="--Select Vehicle--"
            id="vehicles"
    />
  </div>
  <div class="text_input">
    <s:checkbox name="isResourceAvailable" id="isResourceAvailable" />
    <label>Is Resource Available</label>
  </div>
  <div class="text_input" style="width: 100%">
    <label id="total_amount">Total Amount: </label>
  </div>
  <!-- Total Amount -->
  <button type="submit" id="btn_save" class="btn_submit btn_save">Save</button>
  <div class="trips">
  <label>Added Trips</label>
    <style>
      .trip_item {
        display: flex;
        flex-direction: column;
        gap: 5px;
        padding: 10px 15px;
        background-color: rgba(0, 89, 255, 0.43);
        border-radius: 10px;
      }
      .trip_item p {
        font-size: 14px;
      }

      .trip_item p span {
        font-size: 12px;
        font-weight: 400;
        font-style: italic;
      }
    </style>
    <div class="trip_items" style="display: flex; flex-direction: column; gap: 10px; width: 100%;">
    </div>
  </div>
</form>
