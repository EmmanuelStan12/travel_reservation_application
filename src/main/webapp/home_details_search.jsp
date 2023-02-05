<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/4/2023
  Time: 8:08 PM
  To change this template use File | Settings | File Templates.
--%>
<s:form cssClass="form_details" theme="simple">
    <div class="detail_entry">
        <label>Credit type</label>
        <s:textfield class="textfield" type="text" />
    </div>
    <div class="detail_entry">
        <label>Client name</label>
        <s:textfield class="textfield" type="text" />
    </div>
    <div class="detail_entry">
        <label>Has task</label>
        <s:select list="{'True', 'False'}" headerKey="-1" headerValue="--Select--" />
    </div>
    <div class="detail_entry">
        <label>Reservation</label>
        <s:textfield class="textfield" type="text" />
    </div>
    <div class="detail_entry">
        <label>Office</label>
        <s:select list="{'True', 'False'}" headerKey="-1" headerValue="--Select Office--" />
    </div>
    <div class="detail_entry">
        <label>Owner</label>
        <s:select list="{'True', 'False'}" headerKey="-1" headerValue="--Select Owner--" />
    </div>
    <div class="detail_entry_2">
        <label>Reservation Date</label>
        <s:select list="{'True', 'False'}" headerKey="-1" headerValue="--Select Operator--" />
        <sx:datetimepicker type="date" />
        <sx:datetimepicker type="date" />
    </div>
    <div class="detail_entry">
        <label>Online Reservation</label>
        <s:select list="{'True', 'False'}" headerKey="-1" headerValue="--Select--" />
    </div>
    <div class="detail_entry">
        <label>Vehicle</label>
        <s:select list="{'True', 'False'}" headerKey="-1" headerValue="--Select Vehicle--" />
    </div>
    <div class="detail_entry">
        <label>Vehicle Type</label>
        <s:select list="{'True', 'False'}" headerKey="-1" headerValue="--Select Type--" />
    </div>
    <div class="detail_entry">
        <label>Personnel</label>
        <s:select list="{'True', 'False'}" headerKey="-1" headerValue="--Select Personnel--" />
    </div>
    <div class="detail_entry">
        <label>Approved</label>
        <s:select list="{'True', 'False'}" headerKey="-1" headerValue="--Select--" />
    </div>
    <div class="detail_entry">
        <label>Submitted By</label>
        <s:select list="{'True', 'False'}" headerKey="-1" headerValue="--Select--" />
    </div>
    <div class="detail_entry">
        <label>Is Resource Available</label>
        <s:select list="{'True', 'False'}" headerKey="-1" headerValue="--Select--" />
    </div>
    <div class="detail_entry_full">
        <label>Status:  </label>
        <s:checkboxlist list="{'Nice', 'Hello', 'Good', 'Wow'}" name="status" />
    </div>
    <div class="detail_last_section" style="width: 100%; display: flex; justify-content: space-between; align-items: center;">
        <div class="detail_btns">
            <s:submit cssClass="btn_submit" value="Search" name="search" />
            <s:submit cssClass="btn_submit" value="Clear" name="clear" />
        </div>
        <div class="detail_rows">
            <label>No of Rows: </label>
            <s:select list="{'10', '20', '30'}" headerKey="1" />
        </div>
    </div>
</s:form>
