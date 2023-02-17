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
    <link rel="stylesheet" href="styles/home.css" />
    <script src="https://code.jquery.com/jquery-3.6.3.min.js"
            integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
            crossorigin="anonymous"></script>
    <style type="text/css">
        .show {
            display: block;
        }
        th, td {
            padding: 10px;
        }
    </style>
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
            <button class="btn_submit btn_compact" type="button" id="first">First</button>
            <div id="pages" style="display: flex; gap: 10px;">
            </div>
            <button class="btn_submit btn_compact" type="button" id="next">Next</button>
            <button class="btn_submit btn_compact" type="button" id="last">Last</button>
            <p class="list_desc"></p>
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
                        <p>CreatedAt</p>
                    </th>
                    <th width="10%" height="5" colspan="3" class="bgtable" scope="col">
                        <p>Total Amount</p>
                    </th>
                </tr>
                </tbody>
            </table>
            <form id="doc_generator" method="post" action="generateReport">
                <button class="btn_action" name="file_type" value="pdf" id="btn_pdf">Download PDF</button>
                <button class="btn_submit btn_save" id="btn_pdf_view">View PDF</button>
                <button class="btn_action" name="file_type" value="excel" id="btn_excel">Excel</button>
                <button class="btn_submit btn_save" id="btn_excel_view">View Excel</button>
            </form>
        </div>
        <div class="overlay">
            <div class="cv-spinner">
                <span class="spinner"></span>
            </div>
        </div>
    </div>
</main>
<script src="js/home.js"></script>
</body>
</html>
