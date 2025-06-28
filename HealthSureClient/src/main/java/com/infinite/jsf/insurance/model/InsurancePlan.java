package com.infinite.jsf.insurance.model;

import java.util.Date;
import lombok.Data;

@Data
public class InsurancePlan {
    private String planId;
    private InsuranceCompany insuranceCompany; // FK (companyId)

    private String planName;
    private PlanType planType; // The actual enum field

    private int minEntryAge = 18;
    private int maxEntryAge = 65;

    private String description;
    private String availableCoverAmounts;
    private String waitingPeriod;

    private Date createdOn = java.sql.Date.valueOf("2025-06-01");
    private Date expireDate = java.sql.Date.valueOf("2099-12-31");
    private Date activeOn;
    private String periodicDiseases; // YES or NO

    // Helper for Hibernate to store enum as string
    public String getPlanTypeString() {
        return planType != null ? planType.name() : null;
    }

    public void setPlanTypeString(String planTypeString) {
        this.planType = (planTypeString != null) ? PlanType.valueOf(planTypeString) : null;
    }

    
}
