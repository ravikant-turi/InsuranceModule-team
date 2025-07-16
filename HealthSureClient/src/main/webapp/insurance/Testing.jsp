<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>
	<!DOCTYPE html>
	<html>
<head>
<title>Insurance Plan & Coverage Options</title>
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #f4f6f8;
	margin: 0;
	padding: 20px;
}

.main-container {
	max-width: 1200px;
	margin: auto;
}

.form-box, .coverage-box {
	background-color: #ffffff;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);
	margin-bottom: 30px;
}

.form-row {
	display: flex;
	gap: 20px;
	margin-bottom: 15px;
	flex-wrap: wrap;
}

.form-group {
	flex: 1;
	min-width: 200px;
}

label {
	font-weight: 600;
	display: block;
	margin-bottom: 5px;
	color: #34495e;
}

input[type="text"], textarea, select {
	width: 100%;
	padding: 8px 10px;
	border: 1px solid #ccc;
	border-radius: 6px;
	box-sizing: border-box;
	font-size: 14px;
	background-color: #fdfdfd;
}

textarea {
	resize: vertical;
}

.submit-button {
	background-color: #3498db;
	color: white;
	padding: 10px;
	border: none;
	border-radius: 6px;
	font-size: 15px;
	cursor: pointer;
	width: 100%;
	margin-top: 10px;
}

.submit-button:hover {
	background-color: #2980b9;
}

.coverage-box {
	flex: 1;
	text-align: center;
}

.coverage-box h3 {
	margin-bottom: 15px;
	color: #16a085;
}

.section-title {
	background-color: #3498db;
	color: white;
	padding: 10px 15px;
	border-radius: 8px;
	text-align: center;
	margin-bottom: 20px;
	box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
	height: 40px;
	box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
}

.coverage-box form {
	display: flex;
	flex-direction: column;
	align-items: center;
}

.coverage-box label {
	width: 100%;
	text-align: left;
}

.coverage-box input[type="text"] {
	width: 100%;
	margin-bottom: 10px;
}

.center-button-container {
	display: flex;
	justify-content: center;
	margin-top: 1px;
}

.action-btn {
	background-color: #3498db;
	color: white;
	border: none;
	padding: 8px 12px;
	border-radius: 4px;
	cursor: pointer;
	font-size: 14px;
	width: 90px; /* Fixed width for uniform size */
	text-align: center;
}

.action-btn:hover {
	background-color: #2980b9;
}

h3 {
	text-align: center;
	color: #2c3e50;
	margin-bottom: 20px;
}

.section-title {
	font-size: 22px;
	font-weight: bold;
	margin: 0;
}

form {
	margin-top: 50px;
}
</style>

</head>
<body>
	<div class="main-container">

		<!-- Add Insurance Plan Form -->
		<div class="header-container">
			<h3 class="section-title">Add Insurance Plan</h3>
		</div>

		<h:form>
			<div class="form-box">

				<!-- Row 1 -->
				<div class="form-row">
					<div class="form-group">
						<label>Company ID:</label>
						<h:inputText  value="#{insuranceCompany.companyId}" />
					</div>
					<div class="form-group">
						<label>Plan Name:</label>
						<h:inputText  value="#{insurancePlan.planName}" />
						
					</div>
					<div class="form-group">
						<label>Plan Type:</label>
						<h:selectOneMenu value="#{insurancePlanController.insurancePlan.planType}">
							<f:selectItem itemLabel="--Select--" itemValue="" />
							<f:selectItem itemLabel="SELF" itemValue="INDIVIDUAL" />
							<f:selectItem itemLabel="FAMILY" itemValue="FAMILY" />
							<f:selectItem itemLabel="SENIOR" itemValue="SENIOR" />
						</h:selectOneMenu>
					</div>
				</div>  

				<!-- Row 2 -->
				<div class="form-row">
					<div class="form-group">
						<label>Min Entry Age:</label>
						<h:inputText value="#{insurancePlan.minEntryAge}" />
					</div>
					<div class="form-group">
						<label>Max Entry Age:</label>
						<h:inputText value="#{insurancePlan.maxEntryAge}" />
					</div>
					<div class="form-group">
						<label>Description:</label>
						<h:inputTextarea value="#{insurancePlan.description}" rows="2"
							cols="20" />
					</div>
				</div>

				<!-- Row 3 -->
				<div class="form-row">
					<div class="form-group">
						<label>Coverage Amounts:</label>
						<h:inputText value="#{insurancePlanController.insurancePlan.availableCoverAmounts}" />
					</div>
					<div class="form-group">
						<label>Waiting Period:</label>
						<h:inputText value="#{insurancePlan.waitingPeriod}" />
					</div>
					<div class="form-group">
						<label>Active On (YYYY-MM-dd):</label>
						<h:inputText value="#{insurancePlan.activeOn}">
							<f:convertDateTime pattern="yyyy-MM-dd" />
						</h:inputText>
					</div>
				</div>

				<!-- Row 4 -->
				<div class="form-row">
					<div class="form-group">
						<label>Periodic Diseases:</label>
						<h:selectOneMenu value="#{insurancePlan.periodicDiseases}">
							<f:selectItem itemLabel="--Select--" itemValue="" />
							<f:selectItem itemLabel="YES" itemValue="YES" />
							<f:selectItem itemLabel="NO" itemValue="NO" />
						</h:selectOneMenu>
					</div>
				</div>

				<!-- Coverage Options -->
				<h3>Add Coverage Options</h3>
				<div class="form-row">

					<!-- Coverage Option 1 -->
					<div class="coverage-box">
						<h3>Add Silver Option</h3>
						<label>Premium Amount:</label>
						<h:inputText value="#{insurancePlanController.coverageOption1.premiumAmount}" />

						<label>Coverage Amount:</label>
						<h:inputText value="#{coverageOption1.coverageAmount}" />
					</div>

					<!-- Coverage Option 2 -->
					<div class="coverage-box">
						<h3>Add Gold Option</h3>
						<label>Premium Amount:</label>
						<h:inputText value="#{coverageOption2.premiumAmount}" />

						<label>Coverage Amount:</label>
						<h:inputText value="#{coverageOption2.coverageAmount}" />


					</div>

					<!-- Coverage Option 3 -->
					<div class="coverage-box">
						<h3>Add Platinum Option</h3>
						<label>Premium Amount:</label>
						<h:inputText value="#{insurancePlanController.coverageOption3.premiumAmount}" />

						<label>Coverage Amount:</label>
						<h:inputText value="#{coverageOption3.coverageAmount}" />
					</div>
				</div>

				<!-- Submit Button -->
				<div class="center-button-container">
					<h:commandButton value="SUBMIT"
						action="#{insurancePlanController.addInsurancePlanWithCoveragePlan}"
						styleClass="action-btn" />
				</div>

			</div>
		</h:form>
		

	</div>
		<h:messages globalOnly="true" style="color:red" />
</body>

	</html>
</f:view>


