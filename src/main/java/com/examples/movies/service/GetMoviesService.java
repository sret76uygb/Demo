package com.examples.movies.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.movies.entity.MovieNamesEntity;
import com.examples.movies.entity.VwPlanHoursEntity;
import com.examples.movies.pojos.Response;
import com.examples.movies.repository.MoviesRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;

@Service
public class GetMoviesService {

	@Autowired
	MoviesRepository moviesRepository;

	@PersistenceContext
	EntityManager em;

	public List<MovieNamesEntity> getMoviesList(String name) {
		// TODO Auto-generated method stub
		List<MovieNamesEntity> moviesList = null;
		moviesList = moviesRepository.getMoviesByActor(name);
		return moviesList;
	}

	public void getProcedureCall(String file_name) {
		// TODO Auto-generated method stub
		moviesRepository.getProcedureCall(file_name);

	}

	@Transactional
	public List<MovieNamesEntity> getMoviesProcedureCall(String actorName) {
		// TODO Auto-generated method stub
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("mov.getAllMovies");
		spq.setParameter(2, actorName);
		spq.execute();
		return spq.getResultList();
	}

	public Response getUtilizationPercentage(String partner, String reportName) {
		// TODO Auto-generated method stub
		VwPlanHoursEntity vwPlanHoursEntity =new VwPlanHoursEntity();
		String partnerUtilization = null;
		Response response= new Response();
		int percentage=0;
		//vwPlanHoursEntity = moviesRepository.getUtilizationPercentage(partner);
		vwPlanHoursEntity.setActualHours(184);
		vwPlanHoursEntity.setPlanHours(184);
		vwPlanHoursEntity.setActualMonthlyValue(13800);
		vwPlanHoursEntity.setPlan_Monthly_Value(13800);
		if (reportName.equals("TVC Utilization") ) {
			if ((vwPlanHoursEntity.getActualHours() / vwPlanHoursEntity.getPlanHours()) * 100 > 100)
				{partnerUtilization = "Over Realization";
			     
				}
			else if ((vwPlanHoursEntity.getActualHours() / vwPlanHoursEntity.getPlanHours()) * 100 < 100)
				partnerUtilization = "Under Realization";
			    
			else
				partnerUtilization = "Ideal Realization";
			percentage=(vwPlanHoursEntity.getActualHours() / vwPlanHoursEntity.getPlanHours())*100;
		} else if (reportName.equals("partner Realization")) {
			if ((vwPlanHoursEntity.getActualMonthlyValue() / (vwPlanHoursEntity.getPlanHours()* vwPlanHoursEntity.getPlan_Monthly_Value())) * 100 > 100)
				partnerUtilization = "Over Realization";
			else if ((vwPlanHoursEntity.getActualMonthlyValue() / (vwPlanHoursEntity.getPlanHours()* vwPlanHoursEntity.getPlan_Monthly_Value())) * 100 < 100)
				partnerUtilization = "Under Realization";
			else
				partnerUtilization = "Ideal Realization";
			percentage=vwPlanHoursEntity.getActualMonthlyValue() / (vwPlanHoursEntity.getPlanHours()* vwPlanHoursEntity.getPlan_Monthly_Value())*100;
		} else if (reportName.equals( "Actual Realization")) {
			if ((vwPlanHoursEntity.getActualMonthlyValue() / vwPlanHoursEntity.getPlan_Monthly_Value()) * 100 > 100)
				partnerUtilization = "Over Realization";
			else if ((vwPlanHoursEntity.getActualMonthlyValue() / vwPlanHoursEntity.getPlan_Monthly_Value()) * 100 > 100)
				partnerUtilization = "Under Realization";
			else
				partnerUtilization = "Ideal Realization";
			percentage=(vwPlanHoursEntity.getActualMonthlyValue() / vwPlanHoursEntity.getPlan_Monthly_Value())*100;
		}
        response.setPartnerUtilization(partnerUtilization);
        response.setPercentage(percentage);
		return response;
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
