package com.examples.partnerDevelopment.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.partnerDevelopment.entity.VwPlanHoursEntity;
import com.examples.partnerDevelopment.pojos.VwPlanHoursDTO;
import com.examples.partnerDevelopment.repository.DetailsRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;

@Service
public interface GetDetailsService {

	public VwPlanHoursDTO getUtilizationPercentage(String partner, String reportName);
	public Boolean getTvc(String userId);

}
