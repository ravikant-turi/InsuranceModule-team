package com.infinite.jsf.insurance.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.infinite.jsf.insurance.dao.InsuranceSubscribeDao;
import com.infinite.jsf.insurance.daoImpl.InsuranceSubscribeDaoImpl;
import com.infinite.jsf.insurance.model.InsuranceCompany;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;
import com.infinite.jsf.insurance.model.InsurancePlan;
import com.infinite.jsf.insurance.model.PlanType;
import com.infinite.jsf.insurance.model.Subscribe;
import com.infinite.jsf.insurance.model.SubscribedMember;

public class InsuranceSubscribeController {
	InsurancePlan insurancePlan;
	InsuranceCompany insuranceCompany;
	InsuranceCoverageOption coverageOption;
	InsuranceCoverageOption coverageOption1;
	InsuranceCoverageOption coverageOption2;
	InsuranceCoverageOption coverageOption3;

	Subscribe subscribe;
	SubscribedMember subscribedMember;
	InsuranceSubscribeDao insuranceSubscribeDao = new InsuranceSubscribeDaoImpl();
	List<SubscribedMember> subscribedMemberList;
	List<InsuranceCoverageOption> coverageOptionsList;

	private PlanType selectedPlanType;

	public PlanType getSelectedPlanType() {
	    return selectedPlanType;
	}

	public void setSelectedPlanType(PlanType selectedPlanType) {
	    this.selectedPlanType = selectedPlanType;
	}

	public List<InsuranceCoverageOption> getFilteredCoverageOptions() {
	    if (selectedPlanType == null) {
	        return exploreInsurancePlan(); // return all
	    }

	    return coverageOptionsList.stream()
	        .filter(option -> option.getInsurancePlan().getPlanType() == selectedPlanType)
	        .collect(Collectors.toList());
	}


	public List<InsuranceCoverageOption> exploreInsurancePlan() {

		coverageOptionsList = insuranceSubscribeDao.exploreInsurancePlan();

		return coverageOptionsList;
	}
	
	public String showPlicyDetailsToSuscribe(String policyId) {
		coverageOption=insuranceSubscribeDao.getInsurancePolicyById(policyId);
		System.out.println("show plicy by id  :" + coverageOption);
		
		return "ShowPlanDetailsToBeSuscribe?faces-redirect=true";
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

	
	public Subscribe getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(Subscribe subscribe) {
		this.subscribe = subscribe;
	}

	public SubscribedMember getSubscribedMember() {
		return subscribedMember;
	}

	public void setSubscribedMember(SubscribedMember subscribedMember) {
		this.subscribedMember = subscribedMember;
	}

	public InsuranceSubscribeDao getInsuranceSubscribeDao() {
		return insuranceSubscribeDao;
	}

	public void setInsuranceSubscribeDao(InsuranceSubscribeDao insuranceSubscribeDao) {
		this.insuranceSubscribeDao = insuranceSubscribeDao;
	}

	public List<SubscribedMember> getSubscribedMemberList() {
		return subscribedMemberList;
	}

	public void setSubscribedMemberList(List<SubscribedMember> subscribedMemberList) {
		this.subscribedMemberList = subscribedMemberList;
	}

	public List<InsuranceCoverageOption> getCoverageOptionsList() {
		return coverageOptionsList;
	}

	public void setCoverageOptionsList(List<InsuranceCoverageOption> coverageOptionsList) {
		this.coverageOptionsList = coverageOptionsList;
	}

	public InsuranceCoverageOption getCoverageOption() {
		return coverageOption;
	}

	public void setCoverageOption(InsuranceCoverageOption coverageOption) {
		this.coverageOption = coverageOption;
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
	

}
