<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<html>
<f:view>
	<head>
<title>Insurance Coverage Details</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 20px;
	background-color: #f4f4f4;
}

.container {
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	max-width: 800px;
	margin: auto;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h2 {
	text-align: center;
	color: #333;
}

.section {
	margin-bottom: 20px;
}

.section h3 {
	border-bottom: 1px solid #ccc;
	padding-bottom: 5px;
	color: #444;
}

.field {
	margin: 5px 0;
}

.label {
	font-weight: bold;
	color: #555;
}

.value {
	margin-left: 10px;
	color: #000;
}
</style>
	</head>
	<body>

		<h:form>
			<div class="container">
				<h2>Insurance Coverage Summary</h2>

				<div class="section">
					<h3>Coverage Details</h3>
					<div class="field">
						<span class="label">Coverage ID:</span><span class="value"><h:outputText
								value="#{insuranceSubscribeController.coverageOption.coverageId}" /></span>
					</div>
					<div class="field">
						<span class="label">Premium Amount:</span><span class="value"><h:outputText
								value="#{insuranceSubscribeController.coverageOption.premiumAmount}" /></span>
					</div>
					<div class="field">
						<span class="label">Coverage Amount:</span><span class="value"><h:outputText
								value="#{insuranceSubscribeController.coverageOption.coverageAmount}" /></span>
					</div>
					<div class="field">
						<span class="label">Status:</span><span class="value"><h:outputText
								value="#{insuranceSubscribeController.coverageOption.status}" /></span>
					</div>
				</div>

				<div class="section">
					<h3>Plan Information</h3>
					<div class="field">
						<span class="label">Plan ID:</span><span class="value"><h:outputText
								value="#{insuranceSubscribeController.coverageOption.insurancePlan.planId}" /></span>
					</div>
					<div class="field">
						<span class="label">Plan Name:</span><span class="value"><h:outputText
								value="#{insuranceSubscribeController.coverageOption.insurancePlan.planName}" /></span>
					</div>
					<div class="field">
						<span class="label">Plan Type:</span><span class="value"><h:outputText
								value="#{insuranceSubscribeController.coverageOption.insurancePlan.planType}" /></span>
					</div>
					<div class="field">
						<span class="label">Min Entry Age:</span><span class="value"><h:outputText
								value="#{insuranceSubscribeController.coverageOption.insurancePlan.minEntryAge}" /></span>
					</div>
					<div class="field">
						<span class="label">Max Entry Age:</span><span class="value"><h:outputText
								value="#{insuranceSubscribeController.coverageOption.insurancePlan.maxEntryAge}" /></span>
					</div>
					<div class="field">
						<span class="label">Description:</span><span class="value"><h:outputText
								value="#{insuranceSubscribeController.coverageOption.insurancePlan.description}" /></span>
					</div>
					<div class="field">
						<span class="label">Available Cover Amounts:</span><span
							class="value"><h:outputText
								value="#{insuranceSubscribeController.coverageOption.insurancePlan.availableCoverAmounts}" /></span>
					</div>
					<div class="field">
						<span class="label">Waiting Period:</span><span class="value"><h:outputText
								value="#{insuranceSubscribeController.coverageOption.insurancePlan.waitingPeriod}" />
							months</span>
					</div>
					<div class="field">
						<span class="label">Created On:</span><span class="value"><h:outputText
								value="#{insuranceSubscribeController.coverageOption.insurancePlan.createdOn}" /></span>
					</div>
					<div class="field">
						<span class="label">Active On:</span><span class="value"><h:outputText
								value="#{insuranceSubscribeController.coverageOption.insurancePlan.activeOn}" /></span>
					</div>
					<div class="field">
						<span class="label">Expire Date:</span><span class="value"><h:outputText
								value="#{insuranceSubscribeController.coverageOption.insurancePlan.expireDate}" /></span>
					</div>
					<div class="field">
						<span class="label">Periodic Diseases:</span><span class="value"><h:outputText
								value="#{insuranceSubscribeController.coverageOption.insurancePlan.periodicDiseases}" /></span>
					</div>
				</div>

				<div class="section">
					<h3>Insurance Company</h3>
					<div class="field">
						<span class="label">Company ID:</span><span class="value"><h:outputText
								value="#{insuranceSubscribeController.coverageOption.insurancePlan.insuranceCompany.companyId}" /></span>
					</div>
					<div class="field">
						<span class="label">Name:</span><span class="value"><h:outputText
								value="#{insuranceSubscribeController.coverageOption.insurancePlan.insuranceCompany.name}" /></span>
					</div>
					<div class="field">
						<span class="label">Head Office:</span><span class="value"><h:outputText
								value="#{insuranceSubscribeController.coverageOption.insurancePlan.insuranceCompany.headOffice}" /></span>
					</div>
					<div class="field">
						<span class="label">Contact Email:</span><span class="value"><h:outputText
								value="#{insuranceSubscribeController.coverageOption.insurancePlan.insuranceCompany.contactEmail}" /></span>
					</div>
					<div class="field">
						<span class="label">Contact Phone:</span><span class="value"><h:outputText
								value="#{insuranceSubscribeController.coverageOption.insurancePlan.insuranceCompany.contactPhone}" /></span>
					</div>
					<div class="field">
						<span class="label">Logo:</span><span class="value"><img
							src="<h:outputText value='#{insuranceSubscribeController.coverageOption.insurancePlan.insuranceCompany.logoUrl}' />"
							style="max-height: 50px;" /></span>
					</div>
				</div>
			</div>

			<!-- Dynamic Input Fields Based on Plan Type -->

			<h:outputLabel value="Member Details (FAMILY Plan)"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />



			<!-- HUSBAND -->
			<h:outputLabel value="Husband Member ID:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<h:outputLabel value="Husband Full Name:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<h:outputLabel value="Husband Age:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<h:outputLabel value="Husband Gender:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:selectOneMenu value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}">
				<f:selectItem itemLabel="Select Gender" itemValue="#{null}" />
				<f:selectItem itemLabel="MALE" itemValue="MALE" />
				<f:selectItem itemLabel="FEMALE" itemValue="FEMALE" />
				<f:selectItem itemLabel="OTHER" itemValue="OTHER" />
			</h:selectOneMenu>

			<h:outputLabel value="Relation with Proposer:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:selectOneMenu value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}">
				<f:selectItem itemLabel="HUSBAND" itemValue="HUSBAND" />
			</h:selectOneMenu>

			<h:outputLabel value="Husband Aadhar No:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<br />
			<br />

			<!-- WIFE -->
			<h:outputLabel value="Wife Member ID:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<h:outputLabel value="Wife Full Name:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<h:outputLabel value="Wife Age:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<h:outputLabel value="Wife Gender:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:selectOneMenu value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}">
				<f:selectItem itemLabel="Select Gender" itemValue="#{null}" />
				<f:selectItem itemLabel="MALE" itemValue="MALE" />
				<f:selectItem itemLabel="FEMALE" itemValue="FEMALE" />
				<f:selectItem itemLabel="OTHER" itemValue="OTHER" />
			</h:selectOneMenu>

			<h:outputLabel value="Relation with Proposer:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:selectOneMenu value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}">
				<f:selectItem itemLabel="WIFE" itemValue="WIFE" />
			</h:selectOneMenu>

			<h:outputLabel value="Wife Aadhar No:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<br />
			<br />

			<!-- CHILD 1 -->

			<h:outputLabel value="Child 1 Details (FAMILY Plan)"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<h:outputLabel value="Member ID:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<h:outputLabel value="Full Name:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<h:outputLabel value="Age:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<h:outputLabel value="Gender:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:selectOneMenu value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}">
				<f:selectItem itemLabel="Select Gender" itemValue="#{null}" />
				<f:selectItem itemLabel="MALE" itemValue="MALE" />
				<f:selectItem itemLabel="FEMALE" itemValue="FEMALE" />
				<f:selectItem itemLabel="OTHER" itemValue="OTHER" />
			</h:selectOneMenu>

			<h:outputLabel value="Relation with Proposer:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:selectOneMenu value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}">
				<f:selectItem itemLabel="CHILD" itemValue="CHILD" />
			</h:selectOneMenu>

			<h:outputLabel value="Aadhar No:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<br />
			<br />

			<!--  Child 2-->
			<h:outputLabel value="Child 2 Details (FAMILY Plan)"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<h:outputLabel value="Member ID:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<h:outputLabel value="Full Name:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<h:outputLabel value="Age:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<h:outputLabel value="Gender:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:selectOneMenu value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}">
				<f:selectItem itemLabel="Select Gender" itemValue="#{null}" />
				<f:selectItem itemLabel="MALE" itemValue="MALE" />
				<f:selectItem itemLabel="FEMALE" itemValue="FEMALE" />
				<f:selectItem itemLabel="OTHER" itemValue="OTHER" />
			</h:selectOneMenu>

			<h:outputLabel value="Relation with Proposer:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:selectOneMenu value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}">
				<f:selectItem itemLabel="CHILD" itemValue="CHILD" />
			</h:selectOneMenu>

			<h:outputLabel value="Aadhar No:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<br />
			<br />
			<!--Child 3,  -->
			<h:outputLabel value="Child 3 Details (FAMILY Plan)"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<h:outputLabel value="Member ID:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<h:outputLabel value="Full Name:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<h:outputLabel value="Age:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<h:outputLabel value="Gender:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:selectOneMenu value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}">
				<f:selectItem itemLabel="Select Gender" itemValue="#{null}" />
				<f:selectItem itemLabel="MALE" itemValue="MALE" />
				<f:selectItem itemLabel="FEMALE" itemValue="FEMALE" />
				<f:selectItem itemLabel="OTHER" itemValue="OTHER" />
			</h:selectOneMenu>

			<h:outputLabel value="Relation with Proposer:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:selectOneMenu value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}">
				<f:selectItem itemLabel="CHILD" itemValue="CHILD" />
			</h:selectOneMenu>

			<h:outputLabel value="Aadhar No:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<br />
			<br />
			<!--  Child 4 -->
			<h:outputLabel value="Child 4 Details (FAMILY Plan)"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<h:outputLabel value="Member ID:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<h:outputLabel value="Full Name:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<h:outputLabel value="Age:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<h:outputLabel value="Gender:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:selectOneMenu value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}">
				<f:selectItem itemLabel="Select Gender" itemValue="#{null}" />
				<f:selectItem itemLabel="MALE" itemValue="MALE" />
				<f:selectItem itemLabel="FEMALE" itemValue="FEMALE" />
				<f:selectItem itemLabel="OTHER" itemValue="OTHER" />
			</h:selectOneMenu>

			<h:outputLabel value="Relation with Proposer:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:selectOneMenu value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}">
				<f:selectItem itemLabel="CHILD" itemValue="CHILD" />
			</h:selectOneMenu>

			<h:outputLabel value="Aadhar No:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'FAMILY'}" />

			<br />
			<br />





			<!-- SENIOR Plan: Husband and Wife -->
			<h:outputLabel value="Member Details (SENIOR Plan)"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}" />


			<!-- HUSBAND -->
			<h:outputLabel value="Husband Member ID:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}" />

			<h:outputLabel value="Husband Full Name:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}" />

			<h:outputLabel value="Husband Age:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}" />

			<h:outputLabel value="Husband Gender:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}" />
			<h:selectOneMenu value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}">
				<f:selectItem itemLabel="Select Gender" itemValue="#{null}" />
				<f:selectItem itemLabel="MALE" itemValue="MALE" />
				<f:selectItem itemLabel="FEMALE" itemValue="FEMALE" />
				<f:selectItem itemLabel="OTHER" itemValue="OTHER" />
			</h:selectOneMenu>

			<h:outputLabel value="Relation with Proposer:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}" />
			<h:selectOneMenu value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}">
				<f:selectItem itemLabel="HUSBAND" itemValue="HUSBAND" />
			</h:selectOneMenu>

			<h:outputLabel value="Husband Aadhar No:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}" />

			<br />
			<br />

			<!-- WIFE -->
			<h:outputLabel value="Wife Member ID:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}" />

			<h:outputLabel value="Wife Full Name:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}" />

			<h:outputLabel value="Wife Age:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}" />

			<h:outputLabel value="Wife Gender:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}" />
			<h:selectOneMenu value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}">
				<f:selectItem itemLabel="Select Gender" itemValue="#{null}" />
				<f:selectItem itemLabel="MALE" itemValue="MALE" />
				<f:selectItem itemLabel="FEMALE" itemValue="FEMALE" />
				<f:selectItem itemLabel="OTHER" itemValue="OTHER" />
			</h:selectOneMenu>

			<h:outputLabel value="Relation with Proposer:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}" />
			<h:selectOneMenu value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}">
				<f:selectItem itemLabel="WIFE" itemValue="WIFE" />
			</h:selectOneMenu>

			<h:outputLabel value="Wife Aadhar No:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}" />
			<h:inputText value="#{null}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SENIOR'}" />

			<!-- Individual Plans  	private String memberId;
	private Subscribe subscribe;
	private String fullName;
	private Integer age;
	private Gender gender;
	private RelationWithProposer relationWithProposer;
	private String aadharNo
	 -->
			<h:inputText value="Member Details (Individual
				Plan)"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SELF' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'CRITICAL_ILLNESS' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'EPIDEMIC_PROTECT' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SUPER_ELITE'}" />

			<!-- Member ID -->
			<h:outputLabel value="Member ID:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SELF' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'CRITICAL_ILLNESS' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'EPIDEMIC_PROTECT' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SUPER_ELITE'}" />
			<h:inputText value="#{insuranceSubscribeController.subscribedMember1.memberId}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SELF' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'CRITICAL_ILLNESS' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'EPIDEMIC_PROTECT' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SUPER_ELITE'}" />

			<!-- Full Name -->
			<h:outputLabel value="Full Name:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SELF' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'CRITICAL_ILLNESS' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'EPIDEMIC_PROTECT' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SUPER_ELITE'}" />
			<h:inputText value="#{insuranceSubscribeController.subscribedMember1.fullName}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SELF' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'CRITICAL_ILLNESS' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'EPIDEMIC_PROTECT' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SUPER_ELITE'}" />

			<!-- Age -->
			<h:outputLabel value="Age:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SELF' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'CRITICAL_ILLNESS' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'EPIDEMIC_PROTECT' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SUPER_ELITE'}" />
			<h:inputText value="#{insuranceSubscribeController.subscribedMember1.age}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SELF' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'CRITICAL_ILLNESS' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'EPIDEMIC_PROTECT' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SUPER_ELITE'}" />

			<!-- Gender -->
			<h:outputLabel value="Gender:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SELF' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'CRITICAL_ILLNESS' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'EPIDEMIC_PROTECT' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SUPER_ELITE'}" />
			<h:selectOneMenu value="#{insuranceSubscribeController.subscribedMember1.gender}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SELF' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'CRITICAL_ILLNESS' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'EPIDEMIC_PROTECT' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SUPER_ELITE'}">
				<f:selectItem itemLabel="Select Gender" itemValue="" />
				<f:selectItem itemLabel="MALE" itemValue="MALE" />
				<f:selectItem itemLabel="FEMALE" itemValue="FEMALE" />
				<f:selectItem itemLabel="OTHER" itemValue="OTHER" />
			</h:selectOneMenu>

			<!-- Relation with Proposer -->
			<h:outputLabel value="Relation with Proposer:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SELF' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'CRITICAL_ILLNESS' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'EPIDEMIC_PROTECT' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SUPER_ELITE'}" />
			<h:selectOneMenu value="#{insuranceSubscribeController.subscribedMember1.relationWithProposer}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SELF' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'CRITICAL_ILLNESS' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'EPIDEMIC_PROTECT' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SUPER_ELITE'}">
				<f:selectItem itemLabel="INDIVIDUAL" itemValue="INDIVIDUAL" />
			</h:selectOneMenu>

			<!-- Aadhar No -->
			<h:outputLabel value="Aadhar No:"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SELF' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'CRITICAL_ILLNESS' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'EPIDEMIC_PROTECT' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SUPER_ELITE'}" />
			<h:inputText value="#{insuranceSubscribeController.subscribedMember1.aadharNo}"
				rendered="#{insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SELF' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'CRITICAL_ILLNESS' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'EPIDEMIC_PROTECT' or 
                insuranceSubscribeController.coverageOption.insurancePlan.planType == 'SUPER_ELITE'}" />

			<br />
			<br />

			<!-- Subscribe Button -->
			<h:commandButton value="Subscribe" action="#{insuranceSubscribeController.subscribeToPlan(insuranceSubscribeController.coverageOption)}"/>
		</h:form>

	</body>
</f:view>
</html>
