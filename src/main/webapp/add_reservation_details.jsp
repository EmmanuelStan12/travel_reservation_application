<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/3/2023
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="r_form" style="background-color: white; padding: 20px;">
<s:form theme="simple">
    <div class="text_input" style="width: 100%; margin-bottom: 10px;">
        <div class="row">
            <label>Office</label>
            <s:select headerKey="-1" name="office" headerValue="--Select Office--" list="offices" />
        </div>
        <div class="row">
            <label>Owner</label>
            <s:select headerKey="0" name="owner" list="owners" />
        </div>
    </div>
    <div class="first_section">
        <div class="compact_row">
            <label>Client type</label>
            <s:radio label="Client type" name="clientType" list="clientTypes" />
        </div>
        <div class="compact_row">
            <label>Credit type</label>
            <s:radio name="creditType" list="creditTypes" />
        </div>
        <div class="compact_row date_row">
            <label>Date: </label>
            <s:textfield label="Date" cssClass="textfield" readonly="true" name="date" />
        </div>
    </div>
    <div class="second_section">
        <div class="text_input">
            <label>Name</label>
            <s:select
                list="clientNames"
                headerValue="--Select--"
                headerKey="-1"
                id="client_names"
                name="clientName"
                listKey="cid"
                listValue="cname"
            />
        </div>
        <div class="text_input">
            <label>Contact Name</label>
            <div style="display: flex; flex-direction: column; gap: 5px; width: 100%;">
                <div class="text_input">
                    <s:textfield id="contact_name" readonly="true" name="contactName" cssClass="textfield" />
                </div>
                <s:select
                        style="width: fit-content;"
                        headerValue="--Select--"
                        headerKey="-1"
                        list="{}"
                        id="contact_names"
                />
            </div>
        </div>
        <div class="text_input">
            <label>Email</label>
            <s:textfield label="Email" type="email" name="email" cssClass="textfield" />
        </div>
        <div class="text_input">
            <label>Phone number</label>
            <s:textfield label="Phone number" type="number" name="phoneNumber" cssClass="textfield" />
        </div>
        <div class="text_input">
            <label>Remark/Reason</label>
            <s:textfield label="Remark/Reason" type="text" name="remark" cssClass="textfield" />
        </div>
    </div>
    <div class="fourth_section">
        <div class="">
            <label>Status</label>
            <s:select list="{'Submitted'}" name="status" label="Status" />
        </div>
        <div class="text_input">
            <label>Approval Status</label>
            <s:radio name="approvalStatus" list="{'Approved','Not Approved'}" />
        </div>
    </div>
    <script src="js/details.js"></script>
</s:form>
</div>
