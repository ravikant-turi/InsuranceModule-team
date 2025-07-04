package com.infinite.jsf.insurance.dao;

import java.util.List;

import com.infinite.jsf.insurance.model.InsuranceCoverageOption;

public interface InsuranceCoverageOptionDao{
	
	String addInsuranceCoverageOption(InsuranceCoverageOption coverageOption);
	
	String deleteInsuranceCoverageOption(InsuranceCoverageOption coverageOption);
	
	List<InsuranceCoverageOption> findAllCoverageOption();
	
	String updateInsuranceCoverageOption(InsuranceCoverageOption coverageOption);

	String searchInsuranceCoverageOption(InsuranceCoverageOption coverageOption);
	
	List<InsuranceCoverageOption> searchInsuranceCoverageOptionByPlanType(String planType);


}
