
  package com.examples.partnerDevelopment.responseMapper;
  
  import java.util.ArrayList; import java.util.List;
  
  import org.springframework.stereotype.Component;

import com.examples.partnerDevelopment.pojos.TvcResponseDTO;
import com.google.gson.Gson;
  
  @Component
  public class DetailsResponseMapper {

	public TvcResponseDTO mapTvcResponse(Boolean isTVC, String userId) {
		// TODO Auto-generated method stub
		TvcResponseDTO tvcResponse= new TvcResponseDTO();
		tvcResponse.setIsTvc(isTVC);
		tvcResponse.setUserId(userId);
		return tvcResponse;
	}
  
  //public List<MovieNamesResponse> mapResponse(List<MovieNamesEntity> movies) {
  // TODO Auto-generated method stub //Gson gson = new Gson();
  //MovieNamesResponse olaS4GetApiResponse = gson.fromJson(movies.toString(), MovieNamesResponse.class); 
	  /*List<MovieNamesResponse> olaS4GetApiResponse = new ArrayList<MovieNamesResponse>();
	  for(int i=0;i<movies.size();i++) {
  olaS4GetApiResponse.get(i).setId(movies.get(i).getId());
  olaS4GetApiResponse.get(i).setType(movies.get(i).getType());
  } */
  //return olaS4GetApiResponse; 
  //}
  
  }
 