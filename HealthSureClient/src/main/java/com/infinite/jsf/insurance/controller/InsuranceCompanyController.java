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

	private InsuranceCompanyDao companyDao = new InsuranceCompanyDaoImpl();
	private String showSuccessMessage;
	private InsuranceCompany company;

	public String addInsuranceCompany(InsuranceCompany company) {

		if (validateCompanyWithFacesMessage(company)) {
			this.companyDao.addCompany(company); // save company
			showSuccessMessage="company added showsuccessfully!";
			return "showcompany?faces-redirect=true";
			
		}

		return null; // stay on same page, show error messages

	}

	public String findCompnayById(String companyId) {

		company = companyDao.findCompanyById(companyId);

		System.out.println("controller company : " + company);

		return "success";

	}

	public List<InsuranceCompany> findAllCompany() {
		System.out.println("findall company is called");
		return companyDao.findAllCompany();
	}

	public String deleteCompanyById(String companyId) {
		FacesContext context = FacesContext.getCurrentInstance();

		company = companyDao.findCompanyById(companyId);

		if (company == null) {
           context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"company is not found with this id "+ companyId ,null));
			return "not found";
		}
		System.out.println("company in controller  : " + company + "with id : " + companyId);

		 companyDao.deleteCompanyById(company);
		 
         context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"company deleted succussfully!",null));
     
//         return "showcompany?faces-redirect=true";
         
         return null;
	}

	public String updateCompanyById() {
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

		if (company.getName() == null || company.getName().trim().isEmpty()) {
		    context.addMessage("companyForm:name",
		        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Company name is required.", null));
		    isValid = false;
		} else {
		    String name = company.getName().trim();

		    if (name.length() < 4) {
		        context.addMessage("companyForm:name",
		            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Company name must be at least 4 characters.", null));
		        isValid = false;
		    }

		    // Check if name contains any digit
		    else if (name.matches(".*\\d.*")) {
		        context.addMessage("companyForm:name",
		            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Company name must not contain digits.", null));
		        isValid = false;
		    }
		}


		if (company.getContactEmail() == null || company.getContactEmail().trim().isEmpty()) {
		    context.addMessage("companyForm:email",
		        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email is required.", null));
		    isValid = false;
		} else {
		    String email = company.getContactEmail().trim();
		    // Check length before @
		    int atIndex = email.indexOf('@');
		    if (atIndex < 4) {  // less than 4 chars before '@' or '@' missing
		        context.addMessage("companyForm:email",
		            new FacesMessage(FacesMessage.SEVERITY_ERROR,
		                "Email must have at least 4 characters before '@' symbol.", null));
		        isValid = false;
		    } else if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
		        context.addMessage("companyForm:email",
		            new FacesMessage(FacesMessage.SEVERITY_ERROR,
		                "Invalid email format. Example: something@gmail.com", null));
		        isValid = false;
		    }
		}


		if (company.getContactPhone() == null || company.getContactPhone().trim().isEmpty()) {
			context.addMessage("companyForm:phone", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phone number is required.", null));
			isValid = false;
		} else if (!company.getContactPhone().matches("\\d{10}")) {
			context.addMessage("companyForm:phone",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phone number must be exactly 10 digits with no letters, spaces, or special characters.", null));
			isValid = false;
		}

		if (company.getHeadOffice() == null || company.getHeadOffice().trim().isEmpty()) {
			context.addMessage("companyForm:headOffice", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Head Office is required.", null));
			isValid = false;
		}
		else if (company.getHeadOffice().length() < 4) {
			context.addMessage("companyForm:headOffice",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "getHeadOffice name must be at least 4 characters.", null));
			isValid = false;
		}
		if (company.getLogoUrl() == null || company.getLogoUrl().trim().isEmpty()) {
		    context.addMessage("companyForm:logoUrl",
		        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Logo URL is required.", null));
		    isValid = false;
		} else {
		    String logoUrl = company.getLogoUrl().trim();
		    // Check length
		    if (logoUrl.length() < 4) {
		        context.addMessage("companyForm:logoUrl",
		            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Logo URL must be at least 4 characters.", null));
		        isValid = false;
		    }
		    // Validate format: allow simple filename or optional folder + filename with image extensions
		    else if (!logoUrl.matches("^([\\w\\-]+/)?[\\w\\-]+\\.(jpg|jpeg|png|gif)$")) {
		        context.addMessage("companyForm:logoUrl",
		            new FacesMessage(FacesMessage.SEVERITY_ERROR,
		                "Logo URL must be a valid image filename with extension jpg, jpeg, png, or gif.", null));
		        isValid = false;
		    }
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
