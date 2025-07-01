package com.infinite.jsf.insurance.model;


import java.io.Serializable;

import lombok.Data;

@Data
public  class InsuranceCompany implements Serializable{
    private String companyId;
    private String name;
    private String logoUrl;
    private String headOffice;
    private String contactEmail;
    private String contactPhone; 
    
}
