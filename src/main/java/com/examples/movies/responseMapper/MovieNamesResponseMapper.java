
  package com.examples.movies.responseMapper;
  
  import java.util.ArrayList; import java.util.List;
  
  import org.springframework.stereotype.Component;
  
  
  import com.examples.movies.entity.MovieNamesEntity; 
  import com.examples.movies.pojos.MovieNamesResponse;
import com.examples.movies.pojos.TvcResponse;
import com.google.gson.Gson;
  
  @Component
  public class MovieNamesResponseMapper {

	public TvcResponse mapTvcResponse(Boolean isTVC, String userId) {
		// TODO Auto-generated method stub
		TvcResponse tvcResponse= new TvcResponse();
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
 