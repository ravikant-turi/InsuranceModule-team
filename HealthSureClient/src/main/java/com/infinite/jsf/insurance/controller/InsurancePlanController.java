package com.infinite.jsf.insurance.controller;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.infinite.jsf.insurance.dao.InsuranceCoverageOptionDao;
import com.infinite.jsf.insurance.dao.InsurancePlanDao;
import com.infinite.jsf.insurance.daoImpl.InsurancePlanDaoImpl;
import com.infinite.jsf.insurance.model.InsuranceCompany;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;
import com.infinite.jsf.insurance.model.InsurancePlan;

//this controller contains all the method related to InsurancePlan
public class InsurancePlanController {

	private InsurancePlan insurancePlan;
	private InsuranceCompany insuranceCompany;
	private String showSuccessMessage;
	private InsuranceCoverageOption coverageOption1;
	private InsuranceCoverageOption coverageOption2;
	private InsuranceCoverageOption coverageOption3;
	private InsuranceCoverageOptionDao insuranceCoverageOptionDao;
	private InsurancePlanDao plandao = new InsurancePlanDaoImpl();

//	=============methods==============

//Show all InsurancePlan
	public List<InsurancePlan> findAllPlan() {
		return plandao.showAllPlans();
	}

//add InsurancePlan
	public String addPlan(InsurancePlan insurancePlan) {
		insurancePlan.setInsuranceCompany(insuranceCompany);
		if (validateInsurancePlanWithFacesMessage(insurancePlan)) {

			plandao.addInsurancePlan(insurancePlan);

			return "showplan?faces-redirect=true";

		}

		return null;

	}

	// addInsurancePlanWithCoveragePlan directly

	public String addInsurancePlanWithCoveragePlan() {
		FacesContext context = FacesContext.getCurrentInstance();

		insurancePlan.setInsuranceCompany(insuranceCompany);

		if (insurancePlan == null) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, " is null", null));
			return null;
		}
		if (coverageOption1 == null && coverageOption2 == null && coverageOption3 == null) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "add Coverage amount properly is null", null));
			return null;
		}
		if (insurancePlan != null && validateInsurancePlanWithFacesMessage(insurancePlan)) {

			plandao.addInsurancePlan(insurancePlan);
			
			if (coverageOption1 != null || coverageOption2 != null || coverageOption3 != null) {
				System.out.println("===========================================================");
                  System.out.println("planId : "+ insurancePlan.getPlanId());
				if (coverageOption1 != null && validateInsuranceCoverageOptionWithFacesMessage(coverageOption1)) {
					coverageOption1.setInsurancePlan(insurancePlan);
					insuranceCoverageOptionDao.addInsuranceCoverageOption(coverageOption1);
				}
				if (coverageOption2 != null && validateInsuranceCoverageOptionWithFacesMessage(coverageOption2)) {
					coverageOption2.setInsurancePlan(insurancePlan);
					insuranceCoverageOptionDao.addInsuranceCoverageOption(coverageOption2);
				}
				if (coverageOption3 != null && validateInsuranceCoverageOptionWithFacesMessage(coverageOption3)) {
					coverageOption3.setInsurancePlan(insurancePlan);
					insuranceCoverageOptionDao.addInsuranceCoverageOption(coverageOption3);
				}

			}

		}

		return "showplan?faces-redirect=true";
	}

//search Plan By planId
	public String searchPlanById(String planId) {

		FacesContext context = FacesContext.getCurrentInstance();
		insurancePlan = plandao.searchInsurancePlanById(planId);
		System.out.println("=====search method is called==========");
		System.out.println(insurancePlan);

		context.getExternalContext().getSessionMap().put("planId", planId);

		if (insurancePlan == null) {
			context.addMessage(null, new FacesMessage("plan is not found with this id : " + planId, null));
			return null;
		}

		return "searchPlanById?faces-redirect=true";

	}

//delete operation By planId
	public String deletePlaneById(String planId) {
		FacesContext context = FacesContext.getCurrentInstance();
		insurancePlan = plandao.searchInsurancePlanById(planId);
		if (insurancePlan == null) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "plan is not found with this id : " + planId, null));
			return null;
		}

		plandao.deleteInsurancePlan(insurancePlan);

		showSuccessMessage = "plan deleted showsuccessfully!";

		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "company deleted succussfully!", null));

		return "showplan?faces-redirect=true";
	}

//update plan 
	public String updateInsurancePlan(InsurancePlan plan) {
		FacesContext context = FacesContext.getCurrentInstance();
//	  String planId=(String) context.getExternalContext().getSessionMap().get("planId");
//	  plan.setPlanId(planId);
		System.out.println("=====update method is called==========");
		System.out.println(plan);

		if (validateInsurancePlanWithFacesMessage(plan)) {

			plandao.updateInsurancePlan(plan);
			return "showplan?faces-redirect=true";
		}

		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "validation Fails", null));
		return null;

	}

	// show plan details

	public String showPlanById(InsurancePlan plan) {
		insurancePlan = plan;
		return "showplanDetails?faces-redirect=true";
	}

	// validation of plan
	public boolean validateInsurancePlanWithFacesMessage(InsurancePlan plan) {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean isValid = true;

		// Plan Name
		if (plan.getPlanName() == null || plan.getPlanName().trim().isEmpty()) {
			context.addMessage("companyForm:planName",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Plan name is required.", null));
			isValid = false;
		} else if (plan.getPlanName().trim().length() < 4) {
			context.addMessage("companyForm:planName",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Plan name must be at least 4 characters.", null));
			isValid = false;
		}

		// Insurance Company
		if (plan.getInsuranceCompany() == null || plan.getInsuranceCompany().getCompanyId() == null) {
			context.addMessage("companyForm:companyId",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Insurance company is required.", null));
			isValid = false;
		}

		// Description
		if (plan.getDescription() == null || plan.getDescription().trim().isEmpty()) {
			context.addMessage("companyForm:description",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Description is required.", null));
			isValid = false;
		} else if (plan.getDescription().trim().length() <= 5) {
			context.addMessage("companyForm:description",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Description must be more than 5 characters.", null));
			isValid = false;
		}

		// Available Cover Amounts (assume it's a String, convert to double if needed)
		try {
			double coverAmount = Double.parseDouble(plan.getAvailableCoverAmounts().trim());
			if (coverAmount <= 0) {
				context.addMessage("companyForm:cover",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cover amount must be positive.", null));
				isValid = false;
			}
		} catch (Exception e) {
			context.addMessage("companyForm:cover",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid cover amount.", null));
			isValid = false;
		}

		// Min Entry Age
		if (plan.getMinEntryAge() <= 0) {
			context.addMessage("companyForm:minAge",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Minimum age must be greater than 0.", null));
			isValid = false;
		}

		// Max Entry Age
		if (plan.getMaxEntryAge() <= 0 || plan.getMaxEntryAge() < plan.getMinEntryAge()) {
			context.addMessage("companyForm:maxAge", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Maximum age must be greater than minimum age.", null));
			isValid = false;
		}

		// Waiting Period (must be between 0 and 12)
		try {
			int waiting = Integer.parseInt(plan.getWaitingPeriod().trim());
			if (waiting < 0 || waiting > 12) {
				context.addMessage("companyForm:waitingPeriod", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Waiting period must be between 0 and 12 months.", null));
				isValid = false;
			}
		} catch (Exception e) {
			context.addMessage("companyForm:waitingPeriod",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid waiting period.", null));
			isValid = false;
		}

		// Periodic Diseases
		if (plan.getPeriodicDiseases() == null || plan.getPeriodicDiseases().trim().isEmpty()) {
			context.addMessage("companyForm:periodicDiseases",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Periodic diseases field is required.", null));
			isValid = false;
		}

		// Active On, Created On, Expire Date logic
		Date activeOn = plan.getActiveOn();
		Date createdOn = plan.getCreatedOn();
		Date expireDate = plan.getExpireDate();

		if (activeOn == null) {
			context.addMessage("companyForm:activeOn",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Active On date is required.", null));
			isValid = false;
		} else {
			if (createdOn != null && activeOn.before(createdOn)) {
				context.addMessage("companyForm:activeOn", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Active On date cannot be before Created On date.", null));
				isValid = false;
			}
			if (expireDate != null && activeOn.after(expireDate)) {
				context.addMessage("companyForm:activeOn", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Active On date cannot be after Expire date.", null));
				isValid = false;
			}
		}

		return isValid;
	}

	// validation CaverageOptions
	public boolean validateInsuranceCoverageOptionWithFacesMessage(InsuranceCoverageOption option) {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean isValid = true;

		// Validate plan
		if (option.insurancePlan == null || option.insurancePlan.getPlanId() == null) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Linked Insurance Plan is required.", null));
			isValid = false;
		}

		// Validate premiumAmount
		if (option.premiumAmount < 500 || option.premiumAmount > 100000) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Premium amount must be between ₹500 and ₹100,000.", null));
			isValid = false;
		}

		// Validate coverageAmount
		if (option.coverageAmount < 100000 || option.coverageAmount > 50000000) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Coverage amount must be between ₹1,00,000 (1L) and ₹5,00,00,000 (5Cr).", null));
			isValid = false;
		}

		// Validate status
		if (option.status == null || option.status.trim().isEmpty()) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Status is required.", null));
			isValid = false;
		}

		return isValid;
	}

//Getter and Setters
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

	public String getShowSuccessMessage() {
		return showSuccessMessage;
	}

	public void setShowSuccessMessage(String showSuccessMessage) {
		this.showSuccessMessage = showSuccessMessage;
	}

	public InsurancePlanDao getPlandao() {
		return plandao;
	}

	public void setPlandao(InsurancePlanDao plandao) {
		this.plandao = plandao;
	}

	public InsuranceCoverageOption getCoverageOption1() {
		return coverageOption1;
	}

	public void setCoverageOption1(InsuranceCoverageOption coverageOption1) {
		this.coverageOption1 = coverageOption1;
	}

	public InsuranceCoverageOption getCoverageOption2() {
		return coverageOption2;
	}

	public void setCoverageOption2(InsuranceCoverageOption coverageOption2) {
		this.coverageOption2 = coverageOption2;
	}

	public InsuranceCoverageOption getCoverageOption3() {
		return coverageOption3;
	}

	public void setCoverageOption3(InsuranceCoverageOption coverageOption3) {
		this.coverageOption3 = coverageOption3;
	}

	public InsuranceCoverageOptionDao getInsuranceCoverageOptionDao() {
		return insuranceCoverageOptionDao;
	}

	public void setInsuranceCoverageOptionDao(InsuranceCoverageOptionDao insuranceCoverageOptionDao) {
		this.insuranceCoverageOptionDao = insuranceCoverageOptionDao;
	}

}
