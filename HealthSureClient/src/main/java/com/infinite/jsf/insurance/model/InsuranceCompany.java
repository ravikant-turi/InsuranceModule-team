package com.infinite.jsf.insurance.model;


import lombok.Data;

@Data
public  class InsuranceCompany {
    private String companyId;
    private String name;
    private String logoUrl;
    private String headOffice;
    private String contactEmail;
    private String contactPhone; 
    
}