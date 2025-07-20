<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
<f:view>
<head>
    <title>Explore Insurance Plans</title>
    <style>
        .card-container {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }
        .card {
            border: 1px solid #ccc;
            padding: 15px;
            background-color: #f9f9f9;
            transition: background-color 0.3s;
        }
        .card:hover {
            background-color: #eef;
        }
        .card-item {
            margin-bottom: 8px;
        }
        .card-label {
            font-weight: bold;
        }
        .card-button {
            margin-top: 10px;
        }
    </style>
</head>
<body>

<h:form>
    <h2>Filter by Plan Type</h2>
   SelectedPlanType('SELF')}" /> |
    <h:commandLink value="FAMILY" action="#{insuranceSubscribeController.setSelectedPlanType('FAMILY')}" /> |
    <h:commandLink value="SELF" action="#{insuranceSubscribeController.setSelectedPlanType('SELF')}" /> |
    <h:commandLink value="SENIOR" action="#{insuranceSubscribeController.setSelectedPlanType('SENIOR')}" /> |
    <h:commandLink value="CRITICAL_ILLNESS" action="#{insuranceSubscribeController.setSelectedPlanType('CRITICAL_ILLNESS')}" /> |
    <h:commandLink value="EPIDEMIC_PROTECT" action="#{insuranceSubscribeController.setSelectedPlanType('EPIDEMIC_PROTECT')}" /> |
    <h:commandLink value="SUPER_ELITE" action="#{insuranceSubscribeController.setSelectedPlanType('SUPER_ELITE')}" /> |
    <h:commandLink value="Show All" action="#{insuranceSubscribeController.setSelectedPlanType(null)}" />

    <h3>Showing Plans for: 
        <h:outputText value="#{insuranceSubscribeController.selectedPlanType}" />
    </h3>

    <div class="card-container">
        <h:dataTable value="#{insuranceSubscribeController.filteredCoverageOptions}" var="option">
            <h:column>
                <div class="card">
                    <div class="card-item">
                        <span class="card-label">Coverage ID:</span>
                        <h:outputText value="#{option.coverageId}" />
                    </div>
                    <div class="card-item">
                        <span class="card-label">Premium Amount:</span>
                        <h:outputText value="#{option.premiumAmount}" />
                    </div>
                    <div class="card-item">
                        <span class="card-label">Coverage Amount:</span>
                        <h:outputText value="#{option.coverageAmount}" />
                    </div>
                    <div class="card-item">
                        <span class="card-label">Status:</span>
                        <h:outputText value="#{option.status}" />
                    </div>
                    <div class="card-item">
                        <span class="card-label">Plan Name:</span>
                        <h:outputText value="#{option.insurancePlan.planName}" />
                    </div>
                    <div class="card-item">
                        <span class="card-label">Plan Type:</span>
                        <h:outputText value="#{option.insurancePlan.planType}" />
                    </div>
                    <div class="card-item">
                        <span class="card-label">Company Name:</span>
                        <h:outputText value="#{option.insurancePlan.insuranceCompany.name}" />
                    </div>
                    <div class="card-button">
                        <h:commandButton value="View Details" action="#{insuranceSubscribeController.showPlicyDetailsToSuscribe(option.coverageId)}" />
                    </div>
                </div>
            </h:column>
        </h:dataTable>
    </div>
</h:form>

</body>
</f:view>
</html>
