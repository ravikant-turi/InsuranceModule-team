package com.infinite.jsf.insurance.controller;

import java.security.MessageDigest;
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

	private InsuranceCoverageOptionDao coverageOptionDao = new InsuranceCoverageOptionDaoImpl();;

	private InsurancePlan insurancePlan;

	private String showSuccessMessage;

	List<InsuranceCoverageOption> coverageOptionsType;

	public List<InsuranceCoverageOption> findAllcoverageOption() {
		return coverageOptionDao.findAllCoverageOption();
	}

	public String addcoverageOption(InsuranceCoverageOption coverageOption) {
		
		if (validateInsuranceCoverageOptionWithFacesMessage(coverageOption)) {
            

		this.coverageOption.setInsurancePlan(insurancePlan);
		coverageOptionDao.addInsuranceCoverageOption(this.coverageOption);
		showSuccessMessage="added successfully!";
		return "showInsuranceCoverageOption?faces-redirect=true";
		}
		return null;
	}

	
	
	public String searchStatus( InsuranceCoverageOption cov) {
		System.out.println("===================coverage Details");

		System.out.println("==============");
		System.out.println(cov);
		coverageOption = cov;
		// Put cov into session map
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("selectedCoverage", cov);
		return "searchcoveragedetails";
	}

	public String getCoverageDetail() {

		coverageOption = (InsuranceCoverageOption) FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get("selectedCoverage");
		System.out.println("get map : " + coverageOption.getCoverageId());
		return "searchcoveragedetails";
	}

	public String searchInsuranceCoverageOptionByPlanType(String planType) {

		coverageOptionsType = coverageOptionDao.searchInsuranceCoverageOptionByPlanType(planType);
		System.out.println("================");
		System.out.println(coverageOptionsType);
		return "showcoverageplanbyplantype.jsp?faces-redirect=true";

	}

	// delete method
	public String deleteCoverageOptions(InsuranceCoverageOption coverageOption) {

		FacesContext context = FacesContext.getCurrentInstance();
		coverageOption = coverageOptionDao.searchInsuranceCoverageOption(coverageOption.getCoverageId());

		if (coverageOption != null) {
			showSuccessMessage = "deleted succssfully";
			coverageOptionDao.deleteInsuranceCoverageOption(coverageOption);
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CoverageId is not found", null));
		return null;
	}

	// searchByid
	public String searchCoverageOptionById(String coverageId) {
		FacesContext context = FacesContext.getCurrentInstance();

		context.getExternalContext().getSessionMap().put("coverageId", coverageId);

		coverageOption = coverageOptionDao.searchInsuranceCoverageOption(coverageId);
		if (coverageOption == null) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"coverage option is not found with this id : " + coverageId, null));
		}

		return "updateCoverageOption?faces-redirect=true";

	}

	public String helpUpdatemethod(InsuranceCoverageOption coverageOption) {
		FacesContext context = FacesContext.getCurrentInstance();

		context.getExternalContext().getSessionMap().put("coverageId", coverageOption.getCoverageId());

		this.coverageOption = coverageOption;
		return "updateCoverageOption?faces-redirect=true";

	}
	// update method

	public String updateCoverageOption(InsuranceCoverageOption coverageOption) {
		FacesContext context = FacesContext.getCurrentInstance();

		if (coverageOption == null) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "coverage not foudn", null));
		}
		String coveragId = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("coverageId");
		coverageOption.setCoverageId(coveragId);
		if (validateInsuranceCoverageOptionWithFacesMessage(coverageOption)) {

			coverageOptionDao.updateInsuranceCoverageOption(coverageOption);
			showSuccessMessage = "update successfully!";

			return "showInsuranceCoverageOption?faces-redirect=true";
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "validation fails!", null));

		return null;

	}
	public String searchCoverageOptionById(InsuranceCoverageOption coverageOption) {
		
		this.coverageOption=coverageOptionDao.searchInsuranceCoverageOption(coverageOption);
		return null;
		
	}
	

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

//	<h:messages globalOnly="true" style="color:red" />

}
