package com.infinite.jsf.insurance.controller;

import java.util.List;

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

}
