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
    private String showSuccessMessage ;
	private InsurancePlanDao plandao = new InsurancePlanDaoImpl();

	public List<InsurancePlan> findAllPlan() {
		return plandao.showAllPlans();
	}

	public String addPlan(InsurancePlan insurancePlan) {
		
		insurancePlan.setInsuranceCompany(insuranceCompany);
		if(validateInsurancePlanWithFacesMessage(insurancePlan)) {

			plandao.addInsurancePlan(insurancePlan);

			return "showplan?faces-redirect=true";
			
		}
		
		return null;


	}  
	public String searchPlanById(String planId) {
		insurancePlan= plandao.searchInsurancePlan(planId);
		return null;
	}
	
	public String deletePlane() {
		
		
		return null;
	}

	

	public boolean validateInsurancePlanWithFacesMessage(InsurancePlan plan) {
	    FacesContext context = FacesContext.getCurrentInstance();
	    boolean isValid = true;

	    

	    // Plan Name
	    if (plan.getPlanName() == null || plan.getPlanName().trim().isEmpty()) {
	        context.addMessage("companyForm:planName", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Plan name is required.", null));
	        isValid = false;
	    } else if (plan.getPlanName().trim().length() < 4) {
	        context.addMessage("companyForm:planName", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Plan name must be at least 4 characters.", null));
	        isValid = false;
	    }

	    // Plan Type
	    if (plan.getPlanType() == null) {
	        context.addMessage("companyForm:planType", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Plan type is required.", null));
	        isValid = false;
	    }

	    // Insurance Company
	    if (plan.getInsuranceCompany() == null || plan.getInsuranceCompany().getCompanyId() == null) {
	        context.addMessage("companyForm:companyId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Insurance company is required.", null));
	        isValid = false;
	    }

	    // Description
	    if (plan.getDescription() == null || plan.getDescription().trim().isEmpty()) {
	        context.addMessage("companyForm:description", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Description is required.", null));
	        isValid = false;
	    } else if (plan.getDescription().trim().length() <= 5) {
	        context.addMessage("companyForm:description", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Description must be more than 5 characters.", null));
	        isValid = false;
	    }

	    // Available Cover Amounts (assume it's a String, convert to double if needed)
	    try {
	        double coverAmount = Double.parseDouble(plan.getAvailableCoverAmounts().trim());
	        if (coverAmount <= 0) {
	            context.addMessage("companyForm:cover", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cover amount must be positive.", null));
	            isValid = false;
	        }
	    } catch (Exception e) {
	        context.addMessage("companyForm:cover", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid cover amount.", null));
	        isValid = false;
	    }

	    // Min Entry Age
	    if (plan.getMinEntryAge() <= 0) {
	        context.addMessage("companyForm:minAge", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Minimum age must be greater than 0.", null));
	        isValid = false;
	    }

	    // Max Entry Age
	    if (plan.getMaxEntryAge() <= 0 || plan.getMaxEntryAge() < plan.getMinEntryAge()) {
	        context.addMessage("companyForm:maxAge", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Maximum age must be greater than minimum age.", null));
	        isValid = false;
	    }

	    // Waiting Period (must be between 0 and 12)
	    try {
	        int waiting = Integer.parseInt(plan.getWaitingPeriod().trim());
	        if (waiting < 0 || waiting > 12) {
	            context.addMessage("companyForm:waitingPeriod", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Waiting period must be between 0 and 12 months.", null));
	            isValid = false;
	        }
	    } catch (Exception e) {
	        context.addMessage("companyForm:waitingPeriod", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid waiting period.", null));
	        isValid = false;
	    }

	    // Periodic Diseases
	    if (plan.getPeriodicDiseases() == null || plan.getPeriodicDiseases().trim().isEmpty()) {
	        context.addMessage("companyForm:periodicDiseases", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Periodic diseases field is required.", null));
	        isValid = false;
	    }

	    // Active On, Created On, Expire Date logic
	    Date activeOn = plan.getActiveOn();
	    Date createdOn = plan.getCreatedOn();
	    Date expireDate = plan.getExpireDate();

	    if (activeOn == null) {
	        context.addMessage("companyForm:activeOn", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Active On date is required.", null));
	        isValid = false;
	    } else {
	        if (createdOn != null && activeOn.before(createdOn)) {
	            context.addMessage("companyForm:activeOn", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Active On date cannot be before Created On date.", null));
	            isValid = false;
	        }
	        if (expireDate != null && activeOn.after(expireDate)) {
	            context.addMessage("companyForm:activeOn", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Active On date cannot be after Expire date.", null));
	            isValid = false;
	        }
	    }

	    return isValid;
	}

	
}
