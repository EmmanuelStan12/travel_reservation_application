<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/3/2023
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<!DOCTYPE html PUBLIC "-//WSC/DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>Title</title>
    <link rel="stylesheet" href="styles/base_styles.css" />
    <link rel="stylesheet" href="styles/home_styles.css" />
</head>
<sx:head />
<body>
<s:include value="header.jsp" />
<main class="home">
    <sx:tabbedpanel id="search_panel" selectedTab="%{tab}">
        <sx:div id="details" label="Details" theme="ajax">
            <s:include value="home_details_search.jsp" />
        </sx:div>
    </sx:tabbedpanel>
    <div class="list">
        <div class="list_first_section">
            <s:submit theme="simple" cssClass="btn_submit btn_compact" value="First" />
            <s:a theme="simple" href="#">1</s:a>
            <s:a theme="simple" href="#">2</s:a>
            <s:submit theme="simple" cssClass="btn_submit btn_compact" value="Next" />
            <s:submit theme="simple" cssClass="btn_submit btn_compact" value="Last" />
            <p class="list_desc">Displaying 1 - 20 Of 205</p>
        </div>
        <div class="list_main_section">
            <table class="list_table" cellpadding="5" cellspacing="1" align="center">
                <tbody>
                <tr class="list_header">
                    <th scope="col">
                        <p>No</p>
                    </th>
                    <th scope="col">
                        <p class="divmenutable">Date</p>
                    </th>
                    <th scope="col">
                        <p>Office</p>
                    </th>
                    <th scope="col">
                        <p>Client (Type)</p>
                    </th>
                    <th scope="col">
                        <p>Trips</p>
                    </th>
                    <th scope="col">
                        <p>Status</p>
                    </th>
                    <th scope="col">
                        <p>Task</p>
                    </th>
                    <th width="10%" height="5" colspan="3" class="bgtable" scope="col"></th>
                </tr>
                <tr align="center" class="list_entry">
                    <td>
                        0000952
                    </td>
                    <td>
                        04/02/2023
                    </td>
                    <td>
                        Abuja Office
                    </td>
                    <td>Admin</td>
                    <td align="center" style="padding: 0;">
                        04/02/2023 12:39 AM : Garki -&gt; Wuse
                    </td>
                    <td>
                        Submitted
                    </td>
                    <td>
                    </td>
                    <td>
                        <div align="center">
                            <a href="/reservation/SetUpForViewOrUpdate.do?reservation.id=952&amp;operation=VIEW" class="hintanchor" onmouseover="showhint('View', this, event, '30px')"><img src="/images/view.gif" width="16" height="15" align="absmiddle" border="false"></a>
                        </div>
                    </td>
                    <td>
                        <div align="center">
                            <a href="/reservation/SetUpForViewOrUpdate.do?reservation.id=952&amp;operation=EDIT" class="hintanchor" onmouseover="showhint('Edit', this, event, '30px')"><img src="/images/edit.gif" width="16" height="15" align="absmiddle" border="false"></a>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</main>
</body>
</html>
