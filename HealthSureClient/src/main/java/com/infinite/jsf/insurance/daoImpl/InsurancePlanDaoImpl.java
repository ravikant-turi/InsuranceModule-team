package com.infinite.jsf.insurance.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinite.jsf.insurance.dao.InsurancePlanDao;
import com.infinite.jsf.insurance.model.InsurancePlan;
import com.infinite.jsf.util.SessionHelper;

/**
 * Implementation of the InsurancePlanDao interface.
 * <p>
 * This class provides actual persistence logic for managing InsurancePlan
 * entities. Currently, the methods are placeholders and need to be implemented
 * with database operations.
 * </p>
 * 
 * @author Ravikant Turi
 * @version 1.0
 */
public class InsurancePlanDaoImpl implements InsurancePlanDao {

	static SessionFactory factory;
	static Session session;

	static {
		factory = SessionHelper.getSessionFactory();
	}

	/**
	 * Adds a new insurance plan to the database.
	 *
	 * @param plan the InsurancePlan to be added
	 * @return success message or status
	 */
	@Override
	public String addInsurancePlan(InsurancePlan plan) {
		// TODO: Implement logic to save InsurancePlan to database
		Session	session = factory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(plan);
		trans.commit();
		session.close();
		return "success";
	}

	/**
	 * Searches for an insurance plan by its plan ID.
	 *
	 * @param planId the ID of the plan to search
	 * @return the InsurancePlan if found, or null if not found
	 */
	@Override
	public InsurancePlan searchInsurancePlan(String planId) {
		// TODO: Implement logic to retrieve InsurancePlan from database by ID
		return null;
	}

	/**
	 * Retrieves all insurance plans from the database.
	 *
	 * @return list of InsurancePlan objects
	 */
	@Override
	public List<InsurancePlan> showAllPlans() {
		// TODO: Implement logic to fetch all InsurancePlans
		 Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
//		String hql = "FROM InsurancePlan p JOIN FETCH p.insuranceCompany";
//        Query query = session.createQuery(hql);
//        List<InsurancePlan> plans=query.list();
		
		Criteria criteria=session.createCriteria(InsurancePlan.class);
      List<InsurancePlan> plans=criteria.list();

		trans.commit();
		session.close();
		return  plans;
	}

	/**
	 * Updates the details of an existing insurance plan.
	 *
	 * @param plan the InsurancePlan with updated information
	 * @return success message or status
	 */
	@Override
	public String updateInsurancePlan(InsurancePlan plan) {
		// TODO: Implement logic to update InsurancePlan in database
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();

		trans.commit();
		session.close();
		return null;
	}

	/**
	 * Deletes an insurance plan by its plan ID.
	 *
	 * @param planId the ID of the plan to delete
	 * @return success message or status
	 */
	@Override
	public String deleteInsurancePlan(String planId) {
		// TODO: Implement logic to delete InsurancePlan from database

		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();

		trans.commit();
		session.close();

		return null;
	}
}
