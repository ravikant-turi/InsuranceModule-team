package com.infinite.jsf.insurance.model;

public class SubscribedMember {

	private String memberId;
	private Subscribe subscribe;
	private String fullName;
	private Integer age;
	private Gender gender;
	private RelationWithProposer relationWithProposer;
	private String aadharNo;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Subscribe getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(Subscribe subscribe) {
		this.subscribe = subscribe;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public RelationWithProposer getRelationWithProposer() {
		return relationWithProposer;
	}

	public void setRelationWithProposer(RelationWithProposer relationWithProposer) {
		this.relationWithProposer = relationWithProposer;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

}