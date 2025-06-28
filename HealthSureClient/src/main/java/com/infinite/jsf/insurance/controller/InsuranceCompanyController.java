package com.infinite.jsf.insurance.controller;

import java.util.List;

import com.infinite.jsf.insurance.dao.InsuranceCompanyDao;
import com.infinite.jsf.insurance.daoImpl.InsuranceCompanyDaoImpl;
import com.infinite.jsf.insurance.model.InsuranceCompany;

import lombok.Data;

@Data
public class InsuranceCompanyController {

	InsuranceCompanyDao companyDao = new InsuranceCompanyDaoImpl();

	InsuranceCompany company;

	public String addInsuranceCompany(InsuranceCompany company) {

		this.companyDao.addCompany(company);
		return "showcompany?faces-redirect=true";

	}

	public String findCompnayById(String companyId){
		
		company = companyDao.findCompanyById(companyId);

		System.out.println("controller company : " + company);

		return "success";

	}

	public List<InsuranceCompany> findAllCompany() {
		System.out.println("findall company is called");
		return companyDao.findAllCompany();
	}
	public String deleteCompanyById(String companyId) {
		
		company=companyDao.findCompanyById(companyId);
		
		System.out.println("===========contoller method is called==========");
		System.out.println("===========contoller method is called==========");
		System.out.println("===========contoller method is called==========");

		
//		if(company==null) {
//			System.out.println("company : "+ company);
//			return "not found";
//		}
		System.out.println("company in controller  : "+ company + "with id : "+companyId);

		return companyDao.deleteCompanyById(company);
	}
	
	
	

}
