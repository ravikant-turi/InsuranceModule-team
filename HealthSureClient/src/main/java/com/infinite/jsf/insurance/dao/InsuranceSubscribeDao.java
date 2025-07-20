package com.infinite.jsf.insurance.dao;

import java.util.List;

import com.infinite.jsf.insurance.model.InsuranceCoverageOption;
import com.infinite.jsf.insurance.model.Subscribe;
import com.infinite.jsf.insurance.model.SubscribedMember;


public interface InsuranceSubscribeDao {
      List<InsuranceCoverageOption> exploreInsurancePlan();
      String addSubscribedPlanMember(SubscribedMember members);
      String addSubscribe(Subscribe subscribe);
     InsuranceCoverageOption getInsurancePolicyById(String policyId);
     List<SubscribedMember>getSubscribeMeberByPolicyId(String policyId);
}
