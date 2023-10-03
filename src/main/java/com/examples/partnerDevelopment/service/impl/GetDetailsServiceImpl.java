package com.examples.partnerDevelopment.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.examples.partnerDevelopment.entity.VwPlanHoursEntity;
import com.examples.partnerDevelopment.exceptionhandler.GetDetailsResponse;
import com.examples.partnerDevelopment.pojos.VwPlanHoursDTO;
import com.examples.partnerDevelopment.repository.DetailsRepository;
import com.examples.partnerDevelopment.service.GetDetailsService;
import com.examples.partnerDevelopment.utilities.Constants;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;

@Component
public class GetDetailsServiceImpl implements GetDetailsService{

	@Autowired
	DetailsRepository detailsRepository;

	@PersistenceContext
	EntityManager em;

	
	public VwPlanHoursDTO getUtilizationPercentage(String partner, String reportName) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		VwPlanHoursEntity vwPlanHoursEntity =new VwPlanHoursEntity();
		String partnerUtilization = null;
		VwPlanHoursDTO vwPlanHoursDTO= new VwPlanHoursDTO();
		int percentage=0;
		try{
		//vwPlanHoursEntity = detailsRepository.getUtilizationPercentage(partner);
		vwPlanHoursEntity.setActualHours(184);
		vwPlanHoursEntity.setPlanHours(184);
		vwPlanHoursEntity.setActualMonthlyValue(13800);
		vwPlanHoursEntity.setPlan_Monthly_Value(13800);
		if (reportName.equals("TVC Utilization") ) {
			if ((vwPlanHoursEntity.getActualHours() / vwPlanHoursEntity.getPlanHours()) * 100 > 100)
				{partnerUtilization = Constants.OVER_REALIZATION;
			     
				}
			else if ((vwPlanHoursEntity.getActualHours() / vwPlanHoursEntity.getPlanHours()) * 100 < 100) {
				partnerUtilization = Constants.UNDER_REALIZATION;
			    
			}else {
				partnerUtilization = Constants.IDEAL_REALIZATION;
			}percentage=(vwPlanHoursEntity.getActualHours() / vwPlanHoursEntity.getPlanHours())*100;
		} else if (reportName.equals("partner Realization")) {
			if ((vwPlanHoursEntity.getActualMonthlyValue() / (vwPlanHoursEntity.getPlanHours()* vwPlanHoursEntity.getPlan_Monthly_Value())) * 100 > 100) {
				partnerUtilization = Constants.OVER_REALIZATION;
			}else if ((vwPlanHoursEntity.getActualMonthlyValue() / (vwPlanHoursEntity.getPlanHours()* vwPlanHoursEntity.getPlan_Monthly_Value())) * 100 < 100) {
				partnerUtilization = Constants.UNDER_REALIZATION;
			}else {
				partnerUtilization = Constants.IDEAL_REALIZATION;
			}percentage=vwPlanHoursEntity.getActualMonthlyValue() / (vwPlanHoursEntity.getPlanHours()* vwPlanHoursEntity.getPlan_Monthly_Value())*100;
		} else if (reportName.equals( "Actual Realization")) {
			if ((vwPlanHoursEntity.getActualMonthlyValue() / vwPlanHoursEntity.getPlan_Monthly_Value()) * 100 > 100) {
				partnerUtilization = Constants.OVER_REALIZATION;
			}else if ((vwPlanHoursEntity.getActualMonthlyValue() / vwPlanHoursEntity.getPlan_Monthly_Value()) * 100 > 100) {
				partnerUtilization = Constants.UNDER_REALIZATION;
			}else {
				partnerUtilization = Constants.IDEAL_REALIZATION;
			}percentage=(vwPlanHoursEntity.getActualMonthlyValue() / vwPlanHoursEntity.getPlan_Monthly_Value())*100;
		}
		vwPlanHoursDTO.setPartnerUtilization(partnerUtilization);
		vwPlanHoursDTO.setPercentage(percentage);
		}
		catch(IllegalArgumentException e) {
			GetDetailsResponse mPriceManagerResponse = new GetDetailsResponse();
			mPriceManagerResponse = new GetDetailsResponse("500", e.toString() + e);
		}
		return vwPlanHoursDTO;
	}

	public Boolean getTvc(String userId) {
		// TODO Auto-generated method stub
		//String tvc = moviesRepository.getTvc(userId);
		String tvc="Simran";
		if(tvc!= null)
			return true;
		
		return false;
	}

}
