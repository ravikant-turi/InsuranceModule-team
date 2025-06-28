<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
	<!DOCTYPE html>
	<html>
<head>
<meta charset="UTF-8">
<title>Insurance company List</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
}

h1 {
	text-align: center;
	color: #2c3e50;
	background-color: #3498db;
	padding: 10px;
	border-radius: 5px;
	color: white;
}

table {
	width: 90%;
	margin: 20px auto;
	border-collapse: collapse;
}

th {
	background-color: #2980b9;
	color: white;
	padding: 8px;
}

td {
	background-color: #ecf0f1;
	padding: 8px;
	text-align: center;
}

tr:nth-child(even) td {
	background-color: #d0e4f7;
}

tr:hover td {
	background-color: #b2bec3;
}

table, th, td {
	border: 1px solid #34495e;
}
</style>
</head>
<body>
	
	<h1>Insurance company List</h1>

	<h:dataTable value="#{insuranceCompanyController.findAllCompany()}"
		var="company" styleClass="insuranceTable" border="1">

		<h:column>
			<f:facet name="header">company ID</f:facet>
			<h:outputText value="#{company.companyId}" />
		</h:column>

		<h:column>
			<f:facet name="header">company Name</f:facet>
			<h:outputText value="#{company.name}" />
		</h:column>

		<h:column>
			<f:facet name="header">lDogoUrl</f:facet>
			<h:outputText value="#{company.logoUrl}" />
		</h:column>

		<h:column>
			<f:facet name="header">ContactEmail</f:facet>
			<h:outputText value="#{company.contactEmail}" />
		</h:column>

		<h:column>
			<f:facet name="header">HeadOffice</f:facet>
			<h:outputText value="#{company.headOffice}" />
		</h:column>

		<h:column>
			<f:facet name="header">ContactPhone</f:facet>
			<h:outputText value="#{company.contactPhone}" />
		</h:column>



	</h:dataTable>

</body>
	</html>
</f:view>
