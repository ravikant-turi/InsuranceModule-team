package com.infinite.jsf.insurance.controller;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.infinite.jsf.insurance.dao.InsurancePlanDao;
import com.infinite.jsf.insurance.daoImpl.InsurancePlanDaoImpl;
import com.infinite.jsf.insurance.model.InsuranceCompany;
import com.infinite.jsf.insurance.model.InsurancePlan;

import lombok.Data;

@Data
public class InsurancePlanController {

	private InsurancePlan insurancePlan;
	private InsuranceCompany insuranceCompany;

	private InsurancePlanDao plandao=new InsurancePlanDaoImpl();

	public List<InsurancePlan> findAllPlan() {
		return plandao.showAllPlans();
	}
	public String addPlan(InsurancePlan insurancePlan) {
		
		insurancePlan.setInsuranceCompany(insuranceCompany);
		plandao.addInsurancePlan(insurancePlan);
		
		return "showplan?faces-redirect=true";
		
	}
	
	
	
	
	
	
	public String saveInsurancePlan() {
	    // Validate plan before saving
	    if (validateInsurancePlanWithFacesMessage(insurancePlan)) {
	    	
	    	
	    }
	    return null;
	    }
	    
public boolean validateInsurancePlanWithFacesMessage(InsurancePlan plan) {
    FacesContext context = FacesContext.getCurrentInstance();
    boolean isValid = true;

    // Required field checks
    if (plan.getPlanId() == null || plan.getPlanId().trim().isEmpty()) {
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Plan ID is required.", null));
        isValid = false;
    }

    if (plan.getPlanName() == null || plan.getPlanName().trim().isEmpty()) {
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Plan name is required.", null));
        isValid = false;
    }

    if (plan.getPlanType() == null) {
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Plan type is required.", null));
        isValid = false;
    }

    if (plan.getInsuranceCompany() == null || plan.getInsuranceCompany().getCompanyId() == null) {
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Insurance company is required.", null));
        isValid = false;
    }

    if (plan.getDescription() == null || plan.getDescription().trim().isEmpty()) {
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Description is required.", null));
        isValid = false;
    }

    if (plan.getAvailableCoverAmounts() == null || plan.getAvailableCoverAmounts().trim().isEmpty()) {
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Available cover amounts are required.", null));
        isValid = false;
    }

    if (plan.getWaitingPeriod() == null || plan.getWaitingPeriod().trim().isEmpty()) {
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Waiting period is required.", null));
        isValid = false;
    }

    if (plan.getPeriodicDiseases() == null || plan.getPeriodicDiseases().trim().isEmpty()) {
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Periodic diseases field is required.", null));
        isValid = false;
    }

    // ActiveOn date check with java.util.Date
    Date createdOn = plan.getCreatedOn();
    Date expireDate = plan.getExpireDate();
    Date activeOn = plan.getActiveOn();

    if (activeOn == null) {
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Active On date is required.", null));
        isValid = false;
    } else {
        if (createdOn != null && activeOn.before(createdOn)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Active On date cannot be before Created On date.", null));
            isValid = false;
        }
        if (expireDate != null && activeOn.after(expireDate)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Active On date cannot be after Expire date.", null));
            isValid = false;
        }
    }

    return isValid;
}
public InsurancePlan getInsurancePlan() {
	return insurancePlan;
}
public void setInsurancePlan(InsurancePlan insurancePlan) {
	this.insurancePlan = insurancePlan;
}
public InsuranceCompany getInsuranceCompany() {
	return insuranceCompany;
}
public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
	this.insuranceCompany = insuranceCompany;
}
public InsurancePlanDao getPlandao() {
	return plandao;
}
public void setPlandao(InsurancePlanDao plandao) {
	this.plandao = plandao;
}
	
	
	
	
	
	

}
