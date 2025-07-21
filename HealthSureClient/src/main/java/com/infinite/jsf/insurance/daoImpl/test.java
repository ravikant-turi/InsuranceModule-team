package com.infinite.jsf.insurance.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinite.jsf.insurance.dao.InsuranceCompanyDao;
import com.infinite.jsf.insurance.model.InsuranceCompany;
import com.infinite.jsf.util.SessionHelper;

public class test implements InsuranceCompanyDao {

    private static final Logger logger = Logger.getLogger(InsuranceCompanyDaoImpl.class);

    private static SessionFactory factory = SessionHelper.getSessionFactory();

    @Override
    public String addCompany(InsuranceCompany company) {
        company.setCompanyId(generateNextCompanyId());
        logger.info("Adding new company: " + company);

        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();

        try {
            session.save(company);
            trans.commit();
            logger.info("Company added successfully: " + company.getCompanyId());
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            logger.error("Error adding company: " + e.getMessage(), e);
            return "error";
        } finally {
            session.close();
        }

        return "success";
    }

    @Override
    public InsuranceCompany findCompanyById(String companyId) {
        logger.info("Finding company by ID: " + companyId);

        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();

        InsuranceCompany company = null;
        try {
            company = (InsuranceCompany) session.get(InsuranceCompany.class, companyId);
            trans.commit();
            logger.info("Company found: " + company);
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            logger.error("Error finding company: " + e.getMessage(), e);
        } finally {
            session.close();
        }

        return company;
    }

    @Override
    public List<InsuranceCompany> findAllCompany() {
        logger.info("Fetching all companies");

        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();

        List<InsuranceCompany> companies = null;
        try {
            Criteria criteria = session.createCriteria(InsuranceCompany.class);
            companies = criteria.list();
            trans.commit();
            logger.info("Total companies fetched: " + companies.size());
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            logger.error("Error fetching companies: " + e.getMessage(), e);
        } finally {
            session.close();
        }

        return companies;
    }

    @Override
    public String deleteCompanyById(InsuranceCompany company) {
        logger.info("Deleting company: " + company.getCompanyId());

        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();

        try {
            session.delete(company);
            trans.commit();
            logger.info("Company deleted successfully");
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            logger.error("Error deleting company: " + e.getMessage(), e);
            return "error";
        } finally {
            session.close();
        }

        return "deleted";
    }

    @Override
    public String updateCompany(InsuranceCompany company) {
        logger.info("Updating company: " + company.getCompanyId());

        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();

        try {
            session.update(company);
            trans.commit();
            logger.info("Company updated successfully");
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            logger.error("Error updating company: " + e.getMessage(), e);
            return "error";
        } finally {
            session.close();
        }

        return "updated";
    }

    public String generateNextCompanyId() {
        logger.info("Generating next company ID");

        Session session = factory.openSession();
        String lastId = null;

        try {
            lastId = (String) session.createQuery(
                "SELECT c.companyId FROM InsuranceCompany c ORDER BY c.companyId DESC")
                .setMaxResults(1)
                .uniqueResult();
        } catch (Exception e) {
            logger.error("Error generating company ID: " + e.getMessage(), e);
        } finally {
            session.close();
        }

        int nextNum = 1;
        if (lastId != null && lastId.toUpperCase().startsWith("COM") && lastId.length() == 6) {
            String numPart = lastId.substring(3);
            if (numPart.matches("\\d{3}")) {
                nextNum = Integer.parseInt(numPart) + 1;
            }
        }

        String nextId = String.format("COM%03d", nextNum);
        logger.info("Next company ID generated: " + nextId);
        return nextId;
    }
}
