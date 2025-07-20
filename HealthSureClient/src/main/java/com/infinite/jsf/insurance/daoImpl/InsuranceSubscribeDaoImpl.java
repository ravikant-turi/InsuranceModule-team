package com.infinite.jsf.insurance.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinite.jsf.insurance.dao.InsuranceSubscribeDao;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;
import com.infinite.jsf.insurance.model.SubscribedMember;
import com.infinite.jsf.util.SessionHelper;

public class InsuranceSubscribeDaoImpl implements InsuranceSubscribeDao {
	static SessionFactory factory;
	static Session session;
	static {
		factory = SessionHelper.getSessionFactory();
	}

	@Override
	public String addSubscribedPlanMember(SubscribedMember members) {
		session = factory.openSession();
		Transaction trans = session.getTransaction();
		session.save(members);
		trans.commit();
		session.close();
		return "success";
	}

	@Override
	public InsuranceCoverageOption getInsurancePolicyById(String policyId) {
		InsuranceCoverageOption coverageOption = null;
		policyId=policyId.toUpperCase();
		session = factory.openSession();
		Transaction trans = session.beginTransaction();
		coverageOption = (InsuranceCoverageOption) session.get( InsuranceCoverageOption.class,policyId);
		trans.commit();
		session.close();
		return coverageOption;
	}

	@Override
	public List<InsuranceCoverageOption> exploreInsurancePlan() {
		List<InsuranceCoverageOption> optionsList;
		session = factory.openSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from InsuranceCoverageOption");
		optionsList = query.list();
		trans.commit();
		session.close();
		return optionsList;
	}

	@Override
	public List<SubscribedMember> getSubscribeMeberByPolicyId(String policyId) {
		List<SubscribedMember> optionsList;
		session = factory.openSession();
		Transaction trans = session.getTransaction();
		Query query = session.createQuery("from SubscribedMember where SubscribedMember");
		optionsList = query.list();
		trans.commit();
		session.close();
		return optionsList;
	}

}
