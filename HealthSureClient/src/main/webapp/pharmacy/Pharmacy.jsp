<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Pharmacy Home</title>
    <link rel="stylesheet" href="/HealthSureClient/resources/css/pharmacy.css" />
</head>

<body>

<f:view>
    <!-- Include Fixed Navbar -->
    <jsp:include page="/navbar/NavPharmacy.jsp" />

    <!-- Main Content -->
    <div class="grid-container">
        <!-- Action Buttons -->
        <h:form>
            <h:commandButton value="Manage Appointments" action="#{providerBean.manageAppointments}"
                styleClass="action-btn" />
        </h:form>

        <h:form>
            <h:commandButton value="View Medical History" action="#{providerBean.viewHistory}"
                styleClass="action-btn" />
        </h:form>

        <h:form>
            <h:commandButton value="Create Claim" action="#{providerBean.createClaim}"
                styleClass="action-btn" />
        </h:form>

        <h:form>
            <h:commandButton value="Search Payments" action="#{providerBean.searchPayments}"
                styleClass="action-btn" />
        </h:form>

    </div>
</f:view>

<!-- Footer -->
<jsp:include page="/footer/Footer.jsp" />
</body>
</html>
