package com.infinite.jsf.insurance.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinite.jsf.insurance.dao.InsuranceCoverageOptionDao;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;
import com.infinite.jsf.util.SessionHelper;

public class InsuranceCoverageOptionDaoImpl implements InsuranceCoverageOptionDao {

	static SessionFactory factory;
	static Session session;
	static {
		factory = SessionHelper.getSessionFactory();
	}

	@Override
	public String addInsuranceCoverageOption(InsuranceCoverageOption coverageOption) {
		// TODO Auto-generated method stub
		session = factory.openSession();

		Transaction trans = session.beginTransaction();
        session.save(coverageOption);
		trans.commit();
		session.close();
		return "success";
	}

	@Override
	public String deleteInsuranceCoverageOption(InsuranceCoverageOption coverageOption) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InsuranceCoverageOption> findAllCoverageOption() {
		// TODO Auto-generated method stub

		session = factory.openSession();

		Transaction trans = session.beginTransaction();

		Criteria criteria = session.createCriteria(InsuranceCoverageOption.class);

		List<InsuranceCoverageOption> coverageOptions = criteria.list();

		trans.commit();
		session.close();
		return coverageOptions;
	}

	@Override
	public String updateInsuranceCoverageOption(InsuranceCoverageOption coverageOption) {
		// TODO Auto-generated method stub
		session = factory.openSession();

		Transaction trans = session.beginTransaction();

		trans.commit();
		session.close();
		return null;
	}

	@Override
	public String searchInsuranceCoverageOption(InsuranceCoverageOption coverageOption) {
		// TODO Auto-generated method stub
		session = factory.openSession();

		Transaction trans = session.beginTransaction();

		trans.commit();
		session.close();
		return null;
	}

}
