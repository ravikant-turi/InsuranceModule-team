package com.infinite.jsf.insurance.controller;

import java.util.List;

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

}
