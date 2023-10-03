
package com.examples.partnerDevelopment.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examples.partnerDevelopment.entity.VwPlanHoursEntity;


@Repository
public interface DetailsRepository extends JpaRepository<VwPlanHoursEntity, String> {
	
	@Query(value="Call VwPlanHours(?1)",nativeQuery = true)
	VwPlanHoursEntity getUtilizationPercentage(String partner);

	@Query(value="Select TVC from xyz where userId=?1",nativeQuery = true)
	String getTvc(String userId);

		/*
		 * @Query(value="Call public.usp_temp(?1)",nativeQuery = true) Map<String,?>
		 * getMoviesProcedureCall(String actorName);
		 */

}
