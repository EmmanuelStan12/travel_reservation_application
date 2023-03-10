<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/4/2023
  Time: 8:08 PM
  To change this template use File | Settings | File Templates.
--%>
<s:form id="form_details" cssClass="form_details" theme="simple">
    <div class="detail_entry">
        <label>Credit type</label>
        <select
                name="creditType"
                id="creditTypes"
        >
            <option value="-1">--Select Type--</option>
            <option value="0">Credit Client</option>
            <option value="1">Non Credit Client</option>
        </select>
    </div>
    <div class="detail_entry">
        <label>Client Type</label>
        <select id="clientTypes"
                name="clientType">
            <option value="-1">--Select Type--</option>
            <option value="0">Individual</option>
            <option value="1">Company</option>
        </select>
    </div>
    <div class="detail_entry">
        <label>Office</label>
        <s:select
                headerKey="-1"
                name="office"
                headerValue="--Select Office--"
                list="offices"
                id="offices"
        />
    </div>
    <div class="detail_entry">
        <label>Owner</label>
        <s:select
                headerKey="-1"
                name="owner"
                headerValue="--Select Owner--"
                list="owners"
                id="owners"
                listValue="firstname + ' ' + lastname"
                listKey="uid"
        />
    </div>
    <div class="detail_entry_2">
        <label>Reservation Date</label>
        <s:select
                headerKey="-1"
                name="operators"
                headerValue="--Select Operators--"
                list="operators"
                id="operators"
                listKey="operator"
                listValue="operator"
        />
        <sx:datetimepicker name="date" displayFormat="yyyy-MM-dd" type="date" id="start_date" />
        <sx:datetimepicker disabled="true" displayFormat="yyyy-MM-dd" id="end_date" type="date" />
    </div>
    <div class="detail_entry">
        <label>Vehicle Type</label>
        <s:select
                list="vehicleTypes"
                headerValue="--Select type--"
                headerKey="-1"
                listKey="id"
                listValue="name"
                id="vehicle_types"
        />
    </div>
    <div class="detail_entry">
        <label>Vehicle</label>
        <s:select
                list="{}"
                headerKey="-1"
                headerValue="--Select Vehicle--"
                id="vehicles"
        />
    </div>
    <div class="detail_entry">
        <label>Personnel Type</label>
        <s:select
                list="personnelTypes"
                headerValue="--Select type--"
                headerKey="-1"
                listKey="id"
                listValue="name"
                id="personnel_types"
        />
    </div>
    <div class="detail_entry">
        <label>Personnel</label>
        <s:select
                list="{}"
                headerKey="-1"
                headerValue="--Select Personnel--"
                id="personals"
        />
    </div>
    <div class="detail_entry">
        <label>Approved</label>
        <s:select id="is_approved" list="{'True', 'False'}" headerKey="-1" headerValue="--Select--" />
    </div>
    <div class="detail_entry">
        <label>Submitted By</label>
        <s:select
                headerKey="-1"
                name="users"
                headerValue="--Select--"
                list="owners"
                id="users"
                listValue="firstname + ' ' + lastname"
                listKey="uid"
        />
    </div>
    <div class="detail_entry">
        <label>Is Resource Available</label>
        <s:select
                id="is_resource_available"
                list="{'True', 'False'}"
                headerKey="-1"
                headerValue="--Select--"
        />
    </div>
<%--    <div class="detail_entry_full">--%>
<%--        <label>Status:  </label>--%>
<%--        <div class="text_input">--%>
<%--            <input type="radio" name="approved" id="approved">--%>
<%--            <label for="approved">Approved</label>--%>
<%--            <input type="radio" name="notApproved" id="notApproved">--%>
<%--            <label for="notApproved">Not Approved</label>--%>
<%--        </div>--%>
<%--    </div>--%>
    <div class="detail_last_section" style="width: 100%; display: flex; justify-content: space-between; align-items: center;">
        <div class="detail_btns">
            <button type="button" class="btn_submit" name="search" id="btn_search">Search</button>
            <button id="btn_clear" type="reset" class="btn_submit" name="clear">Clear</button>
        </div>
        <div class="detail_rows">
            <label>No of Rows: </label>
            <s:select id="num_per_page" list="{'10', '20', '30'}" headerKey="1" />
        </div>
    </div>
</s:form>
