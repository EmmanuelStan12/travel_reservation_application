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
<s:form theme="simple" id="detail_form">
    <p style="color: red; font-size: 12px;" id="error_field"></p>
    <div class="text_input" style="width: 100%; margin-bottom: 10px;">
        <div class="row">
            <label>Office</label>
            <s:select
                    headerKey="-1"
                    name="office"
                    headerValue="--Select Office--"
                    list="offices"
                    id="offices"
            />
        </div>
        <div class="row">
            <label>Owner</label>
            <s:select id="owners" headerKey="0" name="owner" list="owners" />
        </div>
    </div>
    <div class="first_section">
        <div class="compact_row">
            <label>Client type</label>
            <s:radio id="client_type" name="clientType" list="clientTypes" />
        </div>
        <div class="compact_row">
            <label>Credit type</label>
            <s:radio id="credit_type" name="creditType" list="creditTypes" />
        </div>
        <div class="compact_row date_row">
            <label>Date: </label>
            <s:textfield id="date" cssClass="textfield" readonly="true" name="date" />
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
            <input type="email" name="email" id="detailEmail" required class="textfield" />
        </div>
        <div class="text_input">
            <label>Phone number</label>
            <input required id="detailPhoneNumber" type="number" name="phoneNumber" class="textfield" />
        </div>
        <div class="text_input">
            <label>Remark/Reason</label>
            <input required id="remark" type="text" name="remark" class="textfield" />
        </div>
    </div>
    <div class="fourth_section">
        <div class="">
            <label>Status</label>
            <s:select id="status" list="{'Submitted'}" name="status" label="Status" />
        </div>
        <div class="text_input">
            <label>Approval Status</label>
            <input type="radio" name="approved" id="approved">
            <label for="approved">Approved</label>
            <input type="radio" name="notApproved" id="notApproved">
            <label for="notApproved">Not Approved</label>
        </div>
    </div>
</s:form>
</div>
