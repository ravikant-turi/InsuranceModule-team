<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>


<f:view>
	<!DOCTYPE html>
	<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   
    <h:outputText value="Add Plan to Insurance" style="font-weight:bold; font-size:16px;" /><br/><br/>
        
        <h:form>
            <h:outputText value="Enter the Plan ID: " />
            <h:inputText value="#{insurancePlan.planId}" /><br/><br/>
            
            
             <h:outputText value="Company ID:" />
                <h:inputText value="#{insuranceCompany.companyId}" />

            <h:outputText value="Enter the Plan Name: " />
            <h:inputText value="#{insurancePlan.planName}" /><br/><br/>

            <h:outputText value="Select Plan Type: " />
            <h:selectOneMenu value="#{insurancePlan.planType}">
                <f:selectItem itemLabel="--Select--" itemValue="" />
                <f:selectItem itemLabel="INDIVIDUAL" itemValue="INDIVIDUAL" />
                <f:selectItem itemLabel="FAMILY" itemValue="FAMILY" />
                <f:selectItem itemLabel="SENIOR" itemValue="SENIOR" />
            </h:selectOneMenu><br/><br/>

            <h:outputText value="Min Entry Age: " />
            <h:inputText value="#{insurancePlan.minEntryAge}" /><br/><br/>

            <h:outputText value="Max Entry Age: " />
            <h:inputText value="#{insurancePlan.maxEntryAge}" /><br/><br/>

            <h:outputText value="Description: " />
            <h:inputTextarea value="#{insurancePlan.description}" rows="3" cols="30" /><br/><br/>

            <h:outputText value="Available Cover Amounts: " />
            <h:inputText value="#{insurancePlan.availableCoverAmounts}" /><br/><br/>

            <h:outputText value="Waiting Period: " />
            <h:inputText value="#{insurancePlan.waitingPeriod}" /><br/><br/>

            <h:outputText value="Active On (yyyy-MM-dd): " />
            <h:inputText value="#{insurancePlan.activeOn}">
                <f:convertDateTime pattern="yyyy-MM-dd" />
            </h:inputText><br/><br/>

            <h:outputText value="Periodic Diseases (YES/NO): " />
            <h:selectOneMenu value="#{insurancePlan.periodicDiseases}">
                <f:selectItem itemLabel="--Select--" itemValue="" />
                <f:selectItem itemLabel="YES" itemValue="YES" />
                <f:selectItem itemLabel="NO" itemValue="NO" />
            </h:selectOneMenu><br/><br/>

            <!-- Add more fields if needed (e.g., expireDate, createdOn if you want editable) -->

            <h:commandButton value="Add Plan" action="#{insurancePlanController.addPlan(insurancePlan)}" />
        </h:form>
   
</body>
	</html>
</f:view>