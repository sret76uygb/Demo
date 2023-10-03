package com.examples.partnerDevelopment.entity;

import javax.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;

@Entity
public class VwPlanHoursEntity {

	@Id
	@Column(name = "ProjectId")
	private String ProjectId;

	@Column(name = "year")
	private String year;
	

	@Column(name = "month")
	private String month;
	
	@Column(name = "ResourceId")
	private String ResourceId;
	
	@Column(name = "PlanHours")
	private int PlanHours;
	
	@Column(name = "RatePerHours")
	private String RatePerHours;

	@Column(name = "Plan Monthly Value")
	private int Plan_Monthly_Value;
	
	@Column(name = "ActualHours")
	private int ActualHours;
	
	@Column(name = "Actual Monthly Value")
	private int ActualMonthlyValue;

	@Override
	public String toString() {
		return "VwPlanHoursEntity [ProjectId=" + ProjectId + ", year=" + year + ", month=" + month + ", ResourceId="
				+ ResourceId + ", PlanHours=" + PlanHours + ", RatePerHours=" + RatePerHours + ", Plan_Monthly_Value="
				+ Plan_Monthly_Value + ", ActualHours=" + ActualHours + ", ActualMonthlyValue=" + ActualMonthlyValue
				+ "]";
	}

	public String getProjectId() {
		return ProjectId;
	}

	public void setProjectId(String projectId) {
		ProjectId = projectId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRatePerHours() {
		return RatePerHours;
	}

	public void setRatePerHours(String ratePerHours) {
		RatePerHours = ratePerHours;
	}

	public int getPlan_Monthly_Value() {
		return Plan_Monthly_Value;
	}

	public void setPlan_Monthly_Value(int plan_Monthly_Value) {
		Plan_Monthly_Value = plan_Monthly_Value;
	}

	public int getActualHours() {
		return ActualHours;
	}

	public void setActualHours(int actualHours) {
		//actualHours=184;
		ActualHours = actualHours;
	}

	public int getActualMonthlyValue() {
		return ActualMonthlyValue;
	}

	public void setActualMonthlyValue(int actualMonthlyValue) {
		ActualMonthlyValue = actualMonthlyValue;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getResourceId() {
		return ResourceId;
	}

	public void setResourceId(String resourceId) {
		ResourceId = resourceId;
	}

	public int getPlanHours() {
		return PlanHours;
	}

	public void setPlanHours(int planHours) {
		//planHours=184;
		PlanHours = planHours;
	}

	public VwPlanHoursEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
