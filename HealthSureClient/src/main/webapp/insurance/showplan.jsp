<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insurance Plan List</title>
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


    <h1>Insurance Plan List</h1>

    <h:dataTable value="#{insurancePlanController.findAllPlan()}" var="plan" styleClass="insuranceTable" border="1">

        <h:column>
            <f:facet name="header">Plan ID</f:facet>
            <h:outputText value="#{plan.planId}" />
        </h:column>

        <h:column>
            <f:facet name="header">Plan Name</f:facet>
            <h:outputText value="#{plan.planName}" />
        </h:column>

        <h:column>
            <f:facet name="header">Type</f:facet>
            <h:outputText value="#{plan.planType}" />
        </h:column>

        <h:column>
            <f:facet name="header">Min Age</f:facet>
            <h:outputText value="#{plan.minEntryAge}" />
        </h:column>

        <h:column>
            <f:facet name="header">Max Age</f:facet>
            <h:outputText value="#{plan.maxEntryAge}" />
        </h:column>

        <h:column>
            <f:facet name="header">Covers</f:facet>
            <h:outputText value="#{plan.availableCoverAmounts}" />
        </h:column>

        <h:column>
            <f:facet name="header">Waiting</f:facet>
            <h:outputText value="#{plan.waitingPeriod}" />
        </h:column>

        <h:column>
            <f:facet name="header">Created</f:facet>
            <h:outputText value="#{plan.createdOn}" />
        </h:column>

        <h:column>
            <f:facet name="header">Expire</f:facet>
            <h:outputText value="#{plan.expireDate}" />
        </h:column>

        <h:column>
            <f:facet name="header">Active</f:facet>
            <h:outputText value="#{plan.activeOn}" />
        </h:column>

        <h:column>
            <f:facet name="header">Periodic</f:facet>
            <h:outputText value="#{plan.periodicDiseases}" />
        </h:column>
         
         <h:column>
            <f:facet name="header">Description</f:facet>
            <h:outputText value="#{plan.description}" />
        </h:column>

    </h:dataTable>

</body>
</html>
</f:view>
