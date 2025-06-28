<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<f:view>
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="UTF-8">
        <title>Add Company</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
            }
            .container {
                width: 400px;
                margin: 50px auto;
                padding: 20px;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0,0,0,0.1);
                border-radius: 8px;
            }
            h2 {
                text-align: center;
                color: #333;
            }
            .form-row {
                margin-bottom: 15px;
            }
            .form-row label {
                display: block;
                font-weight: bold;
                margin-bottom: 5px;
            }
            .form-row input {
                width: 100%;
                padding: 8px;
                box-sizing: border-box;
                border: 1px solid #ccc;
                border-radius: 4px;
            }
            .submit-btn {
                width: 100%;
                padding: 10px;
                background-color: #4CAF50;
                color: #fff;
                border: none;
                border-radius: 4px;
                font-size: 16px;
                cursor: pointer;
            }
            .submit-btn:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>

        <div class="container">
            <h2>Add Insurance Company</h2>
            <h:form>
                <div class="form-row">
                    <label>Enter Company ID:</label>
                    <h:inputText value="#{insuranceCompany.companyId}" />
                </div>

                <div class="form-row">
                    <label>Enter Company Name:</label>
                    <h:inputText value="#{insuranceCompany.name}" />
                </div>

                <div class="form-row">
                    <label>Enter Logo URL:</label>
                    <h:inputText value="#{insuranceCompany.logoUrl}" />
                </div>

                <div class="form-row">
                    <label>Enter Head Office:</label>
                    <h:inputText value="#{insuranceCompany.headOffice}" />
                </div>

                <div class="form-row">
                    <label>Enter Contact Email:</label>
                    <h:inputText value="#{insuranceCompany.contactEmail}" />
                </div>

                <div class="form-row">
                    <label>Enter Contact Phone:</label>
                    <h:inputText value="#{insuranceCompany.contactPhone}" />
                </div>

                <h:commandButton value="Add Company" action="#{insuranceCompanyController.addInsuranceCompany(insuranceCompany)}" 
                                 styleClass="submit-btn" />
            </h:form>
        </div>

    </body>
    </html>
</f:view>
