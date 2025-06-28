package com.infinite.jsf.insurance.model;


import lombok.Data;
@Data
public class InsuranceCoverageOption {
	
    public String coverageId;
    
    public InsurancePlan insurancePlan; // FK (planId)

    public double premiumAmount;
    
    public double coverageAmount;
    
    public String status = "ACTIVE";
    
    
}
	
