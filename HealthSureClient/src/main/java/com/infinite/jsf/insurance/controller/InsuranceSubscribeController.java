package com.infinite.jsf.insurance.controller;

import java.util.Date;
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
import com.infinite.jsf.insurance.model.SubscriptionStatus;

public class InsuranceSubscribeController {
	InsurancePlan insurancePlan;
	InsuranceCompany insuranceCompany;
	InsuranceCoverageOption coverageOption;
	InsuranceCoverageOption coverageOption1;
	InsuranceCoverageOption coverageOption2;
	InsuranceCoverageOption coverageOption3;

	Subscribe subscribe;
	SubscribedMember subscribedMember;
	SubscribedMember subscribedMember1;
	SubscribedMember subscribedMember2;
	SubscribedMember subscribedMember3;
	SubscribedMember subscribedMember4;
	SubscribedMember subscribedMember5;
	SubscribedMember subscribedMember6;
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
		coverageOption = insuranceSubscribeDao.getInsurancePolicyById(policyId);
		System.out.println("show plicy by id  :" + coverageOption);

		return "ShowPlanDetailsToBeSuscribe?faces-redirect=true";
	}

	public String subscribeToPlan(InsuranceCoverageOption policy) {
		System.out.println("=============\n coverage : "+policy);
		SubscribedMember[] meberlist = { subscribedMember1, subscribedMember2, subscribedMember3, subscribedMember4,
				subscribedMember5, subscribedMember6 };
        subscribe.setSubscribeId("sub001");		

		subscribe.setCoverage(policy);
		subscribe.setAmountPaid(0);
		subscribe.setExpiryDate(policy.insurancePlan.getCreatedOn());
		subscribe.setTotalPremium(policy.getCoverageAmount());
		subscribe.setStatus(SubscriptionStatus.valueOf("ACTIVE")); 
        insuranceSubscribeDao.addSubscribe(subscribe);
		for (SubscribedMember member : meberlist) {
			if (member != null) {

				member.setSubscribe(subscribe);
				insuranceSubscribeDao.addSubscribedPlanMember(member);

			}
		}

		return "InsurancePlanExplore?faces-redirect=true";
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

	public SubscribedMember getSubscribedMember1() {
		return subscribedMember1;
	}

	public void setSubscribedMember1(SubscribedMember subscribedMember1) {
		this.subscribedMember1 = subscribedMember1;
	}

	public SubscribedMember getSubscribedMember2() {
		return subscribedMember2;
	}

	public void setSubscribedMember2(SubscribedMember subscribedMember2) {
		this.subscribedMember2 = subscribedMember2;
	}

	public SubscribedMember getSubscribedMember3() {
		return subscribedMember3;
	}

	public void setSubscribedMember3(SubscribedMember subscribedMember3) {
		this.subscribedMember3 = subscribedMember3;
	}

	public SubscribedMember getSubscribedMember4() {
		return subscribedMember4;
	}

	public void setSubscribedMember4(SubscribedMember subscribedMember4) {
		this.subscribedMember4 = subscribedMember4;
	}

	public SubscribedMember getSubscribedMember5() {
		return subscribedMember5;
	}

	public void setSubscribedMember5(SubscribedMember subscribedMember5) {
		this.subscribedMember5 = subscribedMember5;
	}

	public SubscribedMember getSubscribedMember6() {
		return subscribedMember6;
	}

	public void setSubscribedMember6(SubscribedMember subscribedMember6) {
		this.subscribedMember6 = subscribedMember6;
	}

}
