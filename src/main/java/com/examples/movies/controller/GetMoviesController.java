package com.examples.movies.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.examples.movies.entity.MovieNamesEntity;
import com.examples.movies.exceptionhandler.PriceManagerResponse;
import com.examples.movies.pojos.MovieNamesResponse;
import com.examples.movies.pojos.Response;
import com.examples.movies.pojos.TvcResponse;
import com.examples.movies.responseMapper.MovieNamesResponseMapper;
import com.examples.movies.service.GetMoviesService;
import com.google.gson.Gson;
//import com.examples.movies.responseMapper.MovieNamesResponseMapper;

@RestController
@RequestMapping("api/examples")
public class GetMoviesController {

	@Autowired
	GetMoviesService getMoviesService;
	
	@Autowired
	MovieNamesResponseMapper movieNamesResponseMapper;
	
	
	
	/*
	 * @Autowired MovieNamesResponseMapper movieNamesResponseMapper;
	 */


	@GetMapping("/movies/{name}")
	public List<MovieNamesEntity> getMoviesList(@PathVariable("name") String name) {
		PriceManagerResponse mPriceManagerResponse = new PriceManagerResponse();
		List<MovieNamesEntity> movies;
		//try {
			movies = getMoviesService.getMoviesList(name);
			//Gson gson = new Gson();
			
			//MovieNamesResponse olaS4GetApiResponse = gson.fromJson(movies.toString(), MovieNamesResponse.class);
			//List<MovieNamesResponse> movieNamesResponse=movieNamesResponseMapper.mapResponse(movies);
			//String movie=gson.toJson(movies).toString();
			//movie=movie.replace("\\","");
			//mPriceManagerResponse = new PriceManagerResponse("200",movie);
		/*} catch (Exception e) {
			mPriceManagerResponse = new PriceManagerResponse("500", e.toString() + e);
		}*/
		return movies;
	}


@GetMapping("/procedureCall/{file_name}")
public void getProcedureCall(@PathVariable("file_name") String file_name) {
	//PriceManagerResponse mPriceManagerResponse = new PriceManagerResponse();
	//List<MovieNamesEntity> response;
	//try {
		getMoviesService.getProcedureCall(file_name);
		//Gson gson = new Gson();
		
		//MovieNamesResponse olaS4GetApiResponse = gson.fromJson(movies.toString(), MovieNamesResponse.class);
		//List<MovieNamesResponse> movieNamesResponse=movieNamesResponseMapper.mapResponse(movies);
		//String movie=gson.toJson(movies).toString();
		//movie=movie.replace("\\","");
		//mPriceManagerResponse = new PriceManagerResponse("200",movie);
	/*} catch (Exception e) {
		mPriceManagerResponse = new PriceManagerResponse("500", e.toString() + e);
	}*/
	
}

@GetMapping("/moviesProcedureCall/{actorName}")
public List<MovieNamesEntity> getMoviesProcedureCall(@PathVariable("actorName") String actorName) {
	//PriceManagerResponse mPriceManagerResponse = new PriceManagerResponse();
	//List<MovieNamesEntity> response;
	//try {
		return getMoviesService.getMoviesProcedureCall(actorName);
		//Gson gson = new Gson();
		
		//MovieNamesResponse olaS4GetApiResponse = gson.fromJson(movies.toString(), MovieNamesResponse.class);
		//List<MovieNamesResponse> movieNamesResponse=movieNamesResponseMapper.mapResponse(movies);
		//String movie=gson.toJson(movies).toString();
		//movie=movie.replace("\\","");
		//mPriceManagerResponse = new PriceManagerResponse("200",movie);
	/*} catch (Exception e) {
		mPriceManagerResponse = new PriceManagerResponse("500", e.toString() + e);
	}*/
	
}
@GetMapping("/UtilizationPercentage/{partner}/{reportName}")
public PriceManagerResponse getUtilizationPercentage(@PathVariable("partner") String partner,@PathVariable("reportName") String reportName) {
	PriceManagerResponse mPriceManagerResponse = new PriceManagerResponse();
	//List<MovieNamesEntity> response;
	try {
		Response partnerUtilization=getMoviesService.getUtilizationPercentage(partner,reportName);
		//Gson gson = new Gson();
		
		//MovieNamesResponse olaS4GetApiResponse = gson.fromJson(movies.toString(), MovieNamesResponse.class);
		//List<MovieNamesResponse> movieNamesResponse=movieNamesResponseMapper.mapResponse(movies);
		//String movie=gson.toJson(movies).toString();
		//movie=movie.replace("\\","");
		mPriceManagerResponse = new PriceManagerResponse(partnerUtilization.getPartnerUtilization(),partnerUtilization.getPercentage());
	} catch (Exception e) {
		mPriceManagerResponse = new PriceManagerResponse("500", e.toString() + e);
	}
	return mPriceManagerResponse;
}

@GetMapping("/Tvc/{userId}")
public PriceManagerResponse getTvc(@PathVariable("userId") String userId) {
	PriceManagerResponse mPriceManagerResponse = new PriceManagerResponse();
	//List<MovieNamesEntity> response;
	try {
		Boolean isTVC=getMoviesService.getTvc(userId);
		//Gson gson = new Gson();
		
		//MovieNamesResponse olaS4GetApiResponse = gson.fromJson(movies.toString(), MovieNamesResponse.class);
		//List<MovieNamesResponse> movieNamesResponse=movieNamesResponseMapper.mapResponse(movies);
		//String movie=gson.toJson(movies).toString();
		//movie=movie.replace("\\","");
		TvcResponse tvcResponse=movieNamesResponseMapper.mapTvcResponse(isTVC,userId);
		mPriceManagerResponse = new PriceManagerResponse(userId,isTVC);
	} catch (Exception e) {
		mPriceManagerResponse = new PriceManagerResponse("500", e.toString() + e);
	}
	return mPriceManagerResponse;
}

}