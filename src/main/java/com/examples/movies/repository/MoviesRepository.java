
package com.examples.movies.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examples.movies.entity.MovieNamesEntity;
import com.examples.movies.entity.VwPlanHoursEntity;


@Repository
public interface MoviesRepository extends JpaRepository<MovieNamesEntity, String> {
	@Query(value="Select * from public.temp where name =?1",nativeQuery = true)
	List<MovieNamesEntity> getMoviesByActor(String name);

	@Query(value="Call public.usp_validate_project_id_data(?1)",nativeQuery = true)
	 void getProcedureCall(String file_name);
	
	@Query(value="Call VwPlanHours(?1)",nativeQuery = true)
	VwPlanHoursEntity getUtilizationPercentage(String partner);

	@Query(value="Select TVC from xyz where userId=?1",nativeQuery = true)
	String getTvc(String userId);

		/*
		 * @Query(value="Call public.usp_temp(?1)",nativeQuery = true) Map<String,?>
		 * getMoviesProcedureCall(String actorName);
		 */

}
