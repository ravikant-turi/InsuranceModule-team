package com.infinite.jsf.insurance.controller;

import java.util.List;

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
	
	public List<InsuranceCoverageOption> findAllcoverageOption() {
		return coverageOptionDao.findAllCoverageOption();
	}
	public String addcoverageOption(InsuranceCoverageOptionDao coverageOption) {
	
		this.coverageOption.setInsurancePlan(insurancePlan);
		coverageOptionDao.addInsuranceCoverageOption(this.coverageOption);
		return "showInsuranceCoverageOption?faces-redirect=true";
	}

}
