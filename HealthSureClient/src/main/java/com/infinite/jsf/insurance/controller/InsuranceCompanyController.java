package com.infinite.jsf.insurance.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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
	
	
	
	public String saveCompany() {
	    if (validateCompanyWithFacesMessage(company)) {
	        // save company
	        return "successPage?faces-redirect=true";
	    } else {
	        return null; // stay on same page, show error messages
	    }
	}
	public boolean validateCompanyWithFacesMessage(InsuranceCompany company) {
	    FacesContext context = FacesContext.getCurrentInstance();
	    boolean isValid = true;

	    // Check required fields
	    if (company.getCompanyId() == null || company.getCompanyId().trim().isEmpty()) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Company ID is required.", null));
	        isValid = false;
	    } else if (!company.getCompanyId().matches("^[A-Za-z]{3}\\d{3}$")) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Company ID must be 3 letters followed by 3 digits (e.g., COM001).", null));
	        isValid = false;
	    }

	    if (company.getName() == null || company.getName().trim().isEmpty()) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Company name is required.", null));
	        isValid = false;
	    } else if (company.getName().length() < 4) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Company name must be at least 4 characters.", null));
	        isValid = false;
	    }

	    if (company.getContactEmail() == null || company.getContactEmail().trim().isEmpty()) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email is required.", null));
	        isValid = false;
	    } else if (!company.getContactEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid email format.", null));
	        isValid = false;
	    }

	    if (company.getContactPhone() == null || company.getContactPhone().trim().isEmpty()) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phone number is required.", null));
	        isValid = false;
	    } else if (!company.getContactPhone().matches("\\d{10}")) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phone number must be exactly 10 digits.", null));
	        isValid = false;
	    }

	    if (company.getHeadOffice() == null || company.getHeadOffice().trim().isEmpty()) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Head Office is required.", null));
	        isValid = false;
	    }

	    return isValid;
	}

	public InsuranceCompanyDao getCompanyDao() {
		return companyDao;
	}

	public void setCompanyDao(InsuranceCompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	public InsuranceCompany getCompany() {
		return company;
	}

	public void setCompany(InsuranceCompany company) {
		this.company = company;
	}
	
	
//	Getter setter
	
	

}
