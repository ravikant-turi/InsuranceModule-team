<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insurance Company Home</title>
<style>
    html, body {
        height: 100%;
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background: #f0f2f5;
    }
    .wrapper {
        min-height: 100%;
        display: flex;
        flex-direction: column;
    }
    .header {
        background: #007bff;
        color: #fff;
        padding: 15px 0;
        text-align: center;
    }
    .container {
        flex: 1;
        max-width: 1000px;
        margin: 30px auto;
        padding: 0 20px;
    }
    .plans-grid {
        display: grid;
        grid-template-columns: repeat(3, 1fr);
        gap: 20px;
    }
    .plan-box {
        background: #fff;
        padding: 15px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
        text-align: center;
        cursor: pointer;
        transition: transform 0.3s, box-shadow 0.3s;
        text-decoration: none; /* remove underline */
    }
    .plan-box:hover {
        transform: translateY(-5px);
        box-shadow: 0 5px 20px rgba(0,0,0,0.2);
    }
    .plan-title {
        font-size: 18px;
        color: #007bff;
        margin: 10px 0 5px 0;
    }
    .plan-desc {
        font-size: 14px;
        color: #555;
        line-height: 1.4;
        text-decoration: none;
    }
    .plan-image {
        width: 100%;
        height: 120px;
        object-fit: cover;
        border-radius: 8px;
    }
    .footer {
        background: #007bff;
        color: #fff;
        padding: 15px 20px;
        text-align: center;
    }
    .footer p {
        margin: 5px 0;
    }
</style>
</head>
<body>
<div class="wrapper">
    <div class="header">
        <h1>Welcome to Our Insurance Company</h1>
    </div>

    <div class="container">
        <h:form>
            <div class="plans-grid">
                <h:commandLink action="selfPlan" styleClass="plan-box">
                    <div>
                        <img src="https://via.placeholder.com/250x120?text=Self+Plan" class="plan-image"/>
                        <div class="plan-title">SELF HealthPlus Basic</div>
                        <div class="plan-desc">
                            A simple plan for individuals.<br/>
                            Covers basic health needs.
                        </div>
                    </div>
                </h:commandLink>

                <h:commandLink action="familyPlan" styleClass="plan-box">
                    <div>
                        <img src="https://via.placeholder.com/250x120?text=Family+Plan" class="plan-image"/>
                        <div class="plan-title">FAMILYCare Shield</div>
                        <div class="plan-desc">
                            Designed for the whole family.<br/>
                            Affordable and reliable protection.
                        </div>
                    </div>
                </h:commandLink>

                <h:commandLink action="seniorPlan" styleClass="plan-box">
                    <div>
                        <img src="https://via.placeholder.com/250x120?text=Senior+Plan" class="plan-image"/>
                        <div class="plan-title">SENIOR Secure</div>
                        <div class="plan-desc">
                            Tailored for senior citizens.<br/>
                            Extra care and higher coverage.
                        </div>
                    </div>
                </h:commandLink>

                <h:commandLink action="criticalPlan" styleClass="plan-box">
                    <div>
                        <img src="https://via.placeholder.com/250x120?text=Critical+Illness" class="plan-image"/>
                        <div class="plan-title">CRITICAL ILLNESS</div>
                        <div class="plan-desc">
                            Support during major illnesses.<br/>
                            Focus on prior disease cover.
                        </div>
                    </div>
                </h:commandLink>

                <h:commandLink action="elitePlan" styleClass="plan-box">
                    <div>
                        <img src="https://via.placeholder.com/250x120?text=Elite+Plan" class="plan-image"/>
                        <div class="plan-title">Super Health Elite</div>
                        <div class="plan-desc">
                            Premium plan for high earners.<br/>
                            Comprehensive and top-tier cover.
                        </div>
                    </div>
                </h:commandLink>

                <h:commandLink action="superPlan" styleClass="plan-box">
                    <div>
                        <img src="https://via.placeholder.com/250x120?text=Super+Comprehensive" class="plan-image"/>
                        <div class="plan-title">SUPER Comprehensive</div>
                        <div class="plan-desc">
                            All-in-one protection plan.<br/>
                            Maximum security for all needs.
                        </div>
                    </div>
                </h:commandLink>
            </div>
        </h:form>
    </div>

    <div class="footer">
        <p>&copy; 2025 Our Insurance Company. All rights reserved.</p>
        <p>This is the best insurance company because it offers reliable, affordable, and comprehensive plans for everyone.</p>
    </div>
</div>
</body>
</html>
</f:view>
