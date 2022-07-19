package com.plantapp.authentication.util;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.plantapp.authentication.models.Planter;


@FeignClient(value="Planter-Service",url="http://localhost:8085/planter")
public interface FeignClientUtilPlanter {
	
	@GetMapping("/allplanters") 
	public ResponseEntity<List<Planter>> getAllPlanters(@RequestHeader("Authorization") String token);
	
	@GetMapping("/planters/{id}")
	public ResponseEntity<Planter> getPlanterById(@RequestHeader("Authorization") String token,Integer id);
	
	
	@PostMapping("/addplanters") 
	public ResponseEntity<Planter> addPlanter(Planter planter);

	
	@DeleteMapping(path="/planters/{id}")
	public ResponseEntity<String> deletePlanter( @RequestHeader("Authorization") String token,int id);


    @PutMapping("/updateplanter")
          public String updatePlanter(@RequestHeader("Authorization") String token,Planter planter);


}
