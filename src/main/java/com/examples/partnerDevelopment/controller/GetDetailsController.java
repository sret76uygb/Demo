package com.examples.partnerDevelopment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.examples.partnerDevelopment.exceptionhandler.GetDetailsResponse;
import com.examples.partnerDevelopment.pojos.TvcResponseDTO;
import com.examples.partnerDevelopment.pojos.VwPlanHoursDTO;
import com.examples.partnerDevelopment.responseMapper.DetailsResponseMapper;
import com.examples.partnerDevelopment.service.GetDetailsService;
import com.google.gson.Gson;
//import com.examples.movies.responseMapper.MovieNamesResponseMapper;

@RestController
@RequestMapping("api/examples")
public class GetDetailsController {

	@Autowired
	GetDetailsService getDetailsService;
	
	@Autowired
	DetailsResponseMapper detailsResponseMapper;
	
	
	
	/*
	 * @Autowired MovieNamesResponseMapper movieNamesResponseMapper;
	 */


	
@RequestMapping(value = "/UtilizationPercentage/{partner}/{reportName}", method = RequestMethod.GET)
public GetDetailsResponse getUtilizationPercentage(@PathVariable("partner") String partner,@PathVariable("reportName") String reportName) {
	GetDetailsResponse getDetailsResponse = new GetDetailsResponse();
	//List<MovieNamesEntity> response;
	try {
		VwPlanHoursDTO partnerUtilization=getDetailsService.getUtilizationPercentage(partner,reportName);
		//Gson gson = new Gson();
		
		//MovieNamesResponse olaS4GetApiResponse = gson.fromJson(movies.toString(), MovieNamesResponse.class);
		//List<MovieNamesResponse> movieNamesResponse=movieNamesResponseMapper.mapResponse(movies);
		//String movie=gson.toJson(movies).toString();
		//movie=movie.replace("\\","");
		getDetailsResponse = new GetDetailsResponse(partnerUtilization.getPartnerUtilization(),partnerUtilization.getPercentage());
	} catch (Exception e) {
		getDetailsResponse = new GetDetailsResponse("500", e.toString() + e);
	}
	return getDetailsResponse;
}


@RequestMapping(value = "/Tvc/{userId}", method = RequestMethod.GET)
public GetDetailsResponse getTvc(@PathVariable("userId") String userId) {
	GetDetailsResponse mPriceManagerResponse = new GetDetailsResponse();
	//List<MovieNamesEntity> response;
	try {
		Boolean isTVC=getDetailsService.getTvc(userId);
		//Gson gson = new Gson();
		
		//MovieNamesResponse olaS4GetApiResponse = gson.fromJson(movies.toString(), MovieNamesResponse.class);
		//List<MovieNamesResponse> movieNamesResponse=movieNamesResponseMapper.mapResponse(movies);
		//String movie=gson.toJson(movies).toString();
		//movie=movie.replace("\\","");
		TvcResponseDTO tvcResponse=detailsResponseMapper.mapTvcResponse(isTVC,userId);
		mPriceManagerResponse = new GetDetailsResponse(userId,isTVC);
	} catch (Exception e) {
		mPriceManagerResponse = new GetDetailsResponse("500", e.toString() + e);
	}
	return mPriceManagerResponse;
}

}