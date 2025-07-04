package com.infinite.jsf.insurance.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.infinite.jsf.insurance.dao.InsuranceCoverageOptionDao;
import com.infinite.jsf.insurance.daoImpl.InsuranceCoverageOptionDaoImpl;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;
import com.infinite.jsf.insurance.model.InsurancePlan;

import lombok.Data;

@Data
public class InsuranceCoverageOptionController {
	
	private InsuranceCoverageOption coverageOption;
	
	private InsuranceCoverageOptionDao coverageOptionDao=new InsuranceCoverageOptionDaoImpl();  ;
	
	private InsurancePlan insurancePlan;
	
	List<InsuranceCoverageOption> coverageOptionsType;
	
	public List<InsuranceCoverageOption> findAllcoverageOption() {
		return coverageOptionDao.findAllCoverageOption();
	}
	public String addcoverageOption(InsuranceCoverageOptionDao coverageOption) {
	
		this.coverageOption.setInsurancePlan(insurancePlan);
		coverageOptionDao.addInsuranceCoverageOption(this.coverageOption);
		return "showInsuranceCoverageOption?faces-redirect=true";
	}
	
	public String searchStatus( InsuranceCoverageOption cov) {
		System.out.println("===================coverage Details");
		
		System.out.println("==============");
		System.out.println(cov);
		coverageOption=cov;
		// Put cov into session map
	    FacesContext.getCurrentInstance()
	                .getExternalContext()
	                .getSessionMap()
	                .put("selectedCoverage", cov);
        return "searchcoveragedetails";
	}
	public String getCoverageDetail() {
		
		coverageOption= (InsuranceCoverageOption)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("selectedCoverage");
		System.out.println("get map : "+ coverageOption.getCoverageId());
		return "searchcoveragedetails";
	}
	public String searchInsuranceCoverageOptionByPlanType(String planType) {
		
		coverageOptionsType= coverageOptionDao.searchInsuranceCoverageOptionByPlanType(planType);
		System.out.println("================");
		System.out.println(coverageOptionsType);
		return "showcoverageplanbyplantype.jsp?faces-redirect=true";

		
	}
	
	
	public String saveCoverageOption() {
	    if (validateInsuranceCoverageOptionWithFacesMessage(coverageOption)) {
	    }
	    return null;
	    }
	
	public boolean validateInsuranceCoverageOptionWithFacesMessage(InsuranceCoverageOption option) {
	    FacesContext context = FacesContext.getCurrentInstance();
	    boolean isValid = true;

	    // Validate coverageId
	    if (option.coverageId == null || option.coverageId.trim().isEmpty()) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Coverage ID is required.", null));
	        isValid = false;
	    } else if (!option.coverageId.toUpperCase().matches("^COV\\d{3}$")) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
	            "Coverage ID must start with 'COV' followed by 3 digits (e.g., COV001).", null));
	        isValid = false;
	    }

	    // Validate plan
	    if (option.insurancePlan == null || option.insurancePlan.getPlanId() == null) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Linked Insurance Plan is required.", null));
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
	
//	<h:messages globalOnly="true" style="color:red" />


}
