package com.infinite.jsf.test;

import com.infinite.jsf.insurance.controller.InsuranceSubscribeController;

import java.util.List;

public class SuscribeTesting {

    public static void main(String[] args) {
    	
        InsuranceSubscribeController controller=new InsuranceSubscribeController();
        controller.exploreInsurancePlan().forEach(System.out::println);
        
        controller.showPlicyDetailsToSuscribe("COV001");
    }
}
