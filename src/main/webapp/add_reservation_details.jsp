<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/3/2023
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<s:form theme="simple" cssClass="reservation_form">
    <div class="text_input" style="width: 100%">
        <div class="row">
            <label>Office</label>
            <s:select headerKey="-1" headerValue="--Select Office--" list="{'Lorem', 'Ipsum'}" />
        </div>
        <div class="row">
            <label>Owner</label>
            <s:select headerKey="0" list="{'Admin Administrator'}" />
        </div>
    </div>
    <div class="first_section">
        <div class="compact_row">
            <label>Client type</label>
            <s:radio label="Client type" name="clientType" list="{'Individual','Company'}" />
        </div>
        <div class="compact_row">
            <label>Credit type</label>
            <s:radio label="Credit type" name="creditType" list="{'Credit Client','Non Credit Client'}" />
        </div>
        <div class="compact_row date_row">
            <label>Date: </label>
            <s:textfield label="Date" cssClass="textfield" readonly="true" />
        </div>
    </div>
    <div class="second_section">
        <div class="text_input">
            <label>Name</label>
            <s:select headerValue="--Select Client--" headerKey="-1" list="{'MTN', 'Glo'}" />
        </div>
        <div class="text_input">
            <label>Contact Name</label>
            <div style="display: flex; flex-direction: column; gap: 5px; width: 100%;">
                <div class="text_input">
                    <s:textfield cssClass="textfield" />
                </div>
                <s:select style="width: fit-content;" headerValue="--Select--" headerKey="-1" list="{'Hello', 'World'}" />
            </div>
        </div>
        <div class="text_input">
            <label>Email</label>
            <s:textfield label="Email" cssClass="textfield" />
        </div>
        <div class="text_input">
            <label>Phone number</label>
            <s:textfield label="Phone number" cssClass="textfield" />
        </div>
        <div class="text_input">
            <label>Remark/Reason</label>
            <s:textfield label="Remark/Reason" cssClass="textfield" />
        </div>
    </div>
    <div class="fourth_section">
        <div class="">
            <label>Status</label>
            <s:select list="{'Submitted'}" label="Status" />
        </div>
        <div class="text_input">
            <label>Approval Status</label>
            <s:checkboxlist name="approvalStatus" list="{'Approved','Not Approved'}" />
        </div>
        <s:submit cssClass="btn_submit" value="Submit" name="submit" />
    </div>
</s:form>
