package com.hexaware.medicalbillingsystems.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


	@Entity
	public class InsurancePlans implements Serializable {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int planId;
		@NotBlank
		private String planName;
		@NotBlank
		private String planType;
		@NotNull
		private double planCoverAmount;
		@NotBlank
		private double planEmi;
		@NotBlank
		private String planDetails;

		@OneToOne(mappedBy = "plans")
		private Patients patient;

		@OneToMany(cascade = CascadeType.ALL, mappedBy = "plans")
		Set<InsuranceClaims> claims = new HashSet<>();

		public InsurancePlans() {
			super();
		}

		public InsurancePlans(int planId, @NotBlank String planName, String planType, double planCoverAmount,
				double planEmi, String planDetails, Patients patient, Set<InsuranceClaims> claims) {
			super();
			this.planId = planId;
			this.planName = planName;
			this.planType = planType;
			this.planCoverAmount = planCoverAmount;
			this.planEmi = planEmi;
			this.planDetails = planDetails;
			this.patient = patient;
			this.claims = claims;
		}

		public int getPlanId() {
			return planId;
		}

		public void setPlanId(int planId) {
			this.planId = planId;
		}

		public String getPlanName() {
			return planName;
		}

		public void setPlanName(String planName) {
			this.planName = planName;
		}

		public String getPlanType() {
			return planType;
		}

		public void setPlanType(String planType) {
			this.planType = planType;
		}

		public double getPlanCoverAmount() {
			return planCoverAmount;
		}

		public void setPlanCoverAmount(double planCoverAmount) {
			this.planCoverAmount = planCoverAmount;
		}

		public double getPlanEmi() {
			return planEmi;
		}

		public void setPlanEmi(double planEmi) {
			this.planEmi = planEmi;
		}

		public String getPlanDetails() {
			return planDetails;
		}

		public void setPlanDetails(String planDetails) {
			this.planDetails = planDetails;
		}

		public Patients getPatient() {
			return patient;
		}

		public void setPatient(Patients patient) {
			this.patient = patient;
		}

		public Set<InsuranceClaims> getClaims() {
			return claims;
		}

		public void setClaims(Set<InsuranceClaims> claims) {
			this.claims = claims;
		}

		@Override
		public String toString() {
			return "InsurancePlans [planId=" + planId + ", planName=" + planName + ", planType=" + planType
					+ ", planCoverAmount=" + planCoverAmount + ", planEmi=" + planEmi + ", planDetails=" + planDetails
					+ ", patient=" + patient + ", claims=" + claims + "]";
		}

	}	