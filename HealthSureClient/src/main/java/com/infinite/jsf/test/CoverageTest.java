package com.infinite.jsf.test;

import com.infinite.jsf.insurance.controller.InsuranceCoverageOptionController;
import com.infinite.jsf.insurance.dao.InsuranceCoverageOptionDao;
import com.infinite.jsf.insurance.daoImpl.InsuranceCoverageOptionDaoImpl;

public class CoverageTest {
	
	public static void main(String[] args) {
		
		InsuranceCoverageOptionController controller= new InsuranceCoverageOptionController();
		
//		controller.findAllcoverageOption().forEach(System.out::println);
		
		InsuranceCoverageOptionDao dao=new InsuranceCoverageOptionDaoImpl();
		
		System.out.println("====================Family=================");
//		controller.searchInsuranceCoverageOptionByPlanType("SELF").forEach(System.out::println);
		
		dao.searchInsuranceCoverageOptionByPlanId("P001").forEach(System.out::println);
		
		
	}

}
