package com.infinite.jsf.insurance.model;

import java.util.Date;
import java.util.Set;
import com.infinite.jsf.recipient.model.Recipient;

public class Subscribe {


private String subscribeId;

    private String recipientId;
    private InsuranceCoverageOption coverage;
    private Date subscribeDate;
    private Date expiryDate;
    private SubscriptionStatus status;
    private double totalPremium;
    private double amountPaid;
    private Set<SubscribedMember> members;


	public String getSubscribeId() {
		return subscribeId;
	}

	public void setSubscribeId(String subscribeId) {
		this.subscribeId = subscribeId;
	}

	

	public InsuranceCoverageOption getCoverage() {
		return coverage;
	}

	public void setCoverage(InsuranceCoverageOption coverage) {
		this.coverage = coverage;
	}

	public Date getSubscribeDate() {
		return subscribeDate;
	}

	public void setSubscribeDate(Date subscribeDate) {
		this.subscribeDate = subscribeDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public SubscriptionStatus getStatus() {
		return status;
	}

	public void setStatus(SubscriptionStatus status) {
		this.status = status;
	}

	public double getTotalPremium() {
		return totalPremium;
	}

	public void setTotalPremium(double totalPremium) {
		this.totalPremium = totalPremium;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	public Set<SubscribedMember> getMembers() {
		return members;
	}

	public void setMembers(Set<SubscribedMember> members) {
		this.members = members;
	}

}