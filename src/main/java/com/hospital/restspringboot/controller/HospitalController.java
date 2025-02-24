package com.hospital.restspringboot.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.restspringboot.error.Apiresponse;
import com.hospital.restspringboot.model.HospitalModel;
import com.hospital.restspringboot.service.HospitalService;

@RestController
@RequestMapping("/api/v1")
public class HospitalController {
	@Autowired
	HospitalService hospitalService;
	
	@PostMapping("/hospitals")
	public ResponseEntity<HospitalModel> savehospital(@RequestBody HospitalModel hospitalModel)
	{
		HospitalModel savedhos = hospitalService. SaveHospitalModel(hospitalModel);
		return ResponseEntity.status(HttpStatus.CREATED)
				             .header("info", "data saved")
				             .body(savedhos);
	}
	
	@PostMapping("/hospitals/bluk")
	public ResponseEntity <List<HospitalModel>> saveAllhospitals(@RequestBody List<HospitalModel> hospitalModel)
	{
		List<HospitalModel> saveallhos = hospitalService.SaveAllHospitalModel(hospitalModel);
		return ResponseEntity.status(HttpStatus.CREATED)
				            .header("info", "data saved")
				            .body(saveallhos);
	}
	
	@GetMapping("/getallhospitals")
	public ResponseEntity<List<HospitalModel>> getallhospitals(@RequestBody List<HospitalModel> hospitalModel)
	{
		List<HospitalModel> getallhos = hospitalService.getallHospitalModel(hospitalModel);
		return ResponseEntity.status(HttpStatus.CREATED)
				             .header("info", "data saved")
				             .body(getallhos);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity <?> getById(@PathVariable("id") Long id)
	{
		Optional<HospitalModel> hospital = hospitalService.getById(id);
		if(hospital.isPresent())
		{
			return ResponseEntity.status(HttpStatus.OK)
					             .header("info", "data retrieve successfully")
					             .body(hospital.get());
		}
		else
		{
		    Apiresponse apiresponse = new Apiresponse();
			apiresponse.setStatuscode(HttpStatus.NOT_FOUND.value());
			apiresponse.setErrormessage("employee not found with id" + id);
			apiresponse.setTimestamp(LocalDateTime.now());
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					             .header("info", "no data present")
					             .body(apiresponse);
		}
	}
	
	@GetMapping("/getByLocation/{location}")
	public ResponseEntity <?> getByLocation(@PathVariable("location") String location)
	{
		Optional<List<HospitalModel>> hospital = hospitalService.getByLocation(location);
		if(hospital.isPresent())
		{
			return ResponseEntity.status(HttpStatus.OK)
					             .header("info", "data retrieve successfully")
					             .body(hospital.get());
		}
		else
		{
		    Apiresponse apiresponse = new Apiresponse();
			apiresponse.setStatuscode(HttpStatus.NOT_FOUND.value());
			apiresponse.setErrormessage("hospital not found with location" + location);
			apiresponse.setTimestamp(LocalDateTime.now());
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					             .header("info", "no data present")
					             .body(apiresponse);
		}
	}

	
	@GetMapping("/getByRating/{rating}")
	public ResponseEntity <?> getByRating(@PathVariable("rating") double rating)
	{
		Optional<List<HospitalModel>> hospital = hospitalService.getByRating(rating);
		if(hospital.isPresent())
		{
			return ResponseEntity.status(HttpStatus.OK)
					             .header("info", "data retrieve successfully")
					             .body(hospital.get());
		}
		else
		{
		    Apiresponse apiresponse = new Apiresponse();
			apiresponse.setStatuscode(HttpStatus.NOT_FOUND.value());
			apiresponse.setErrormessage("hospital not found with rating" + rating);
			apiresponse.setTimestamp(LocalDateTime.now());
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					             .header("info", "no data present")
					             .body(apiresponse);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Apiresponse> deleteId(@PathVariable("id") Long id)
	{
		boolean hos = hospitalService.deleteById(id);
		if(hos)
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT)
					            .header("info", "data deleted")
					            .build();				
		}
		else
		{
			Apiresponse apiresponse=new Apiresponse();
			apiresponse.setStatuscode(HttpStatus.NOT_FOUND.value());
			apiresponse.setErrormessage("hospital deleted with id"+id);
			apiresponse.setTimestamp(LocalDateTime.now());
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					             .header("info", "data deleted")
					             .body(apiresponse);
		}
	}
	
	
	//---------new commands-------//
	
	
	@GetMapping("/hospitals/rating/greater-than/{rating}")
	public ResponseEntity<?> greaterthanrating(@PathVariable("rating") double rating)
	{
		Optional<List<HospitalModel>> hospital = hospitalService.greaterThanRating(rating);
		if(hospital.isPresent()&&!hospital.get().isEmpty())
		{
			return ResponseEntity.status(HttpStatus.OK)
		             .header("info", "data retrieve successfully")
		             .body(hospital.get());
		}
		else
		{
			Apiresponse apiresponse=new Apiresponse();
			apiresponse.setStatuscode(HttpStatus.NOT_FOUND.value());
			apiresponse.setErrormessage("hospital deleted with rating"+rating);
			apiresponse.setTimestamp(LocalDateTime.now());
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					             .header("info", "data deleted")
					             .body(apiresponse);
		}
	}
	
	@GetMapping("/hospitals/rating/less-than/{rating}")
	public ResponseEntity<?> lessthanrating(@PathVariable("rating") double rating)
	{
		Optional<List<HospitalModel>> hospital = hospitalService.lessThanRating(rating);
		if(hospital.isPresent()&&!hospital.get().isEmpty())
		{
			return ResponseEntity.status(HttpStatus.OK)
		             .header("info", "data retrieve successfully")
		             .body(hospital.get());
		}
		else
		{
			Apiresponse apiresponse=new Apiresponse();
			apiresponse.setStatuscode(HttpStatus.NOT_FOUND.value());
			apiresponse.setErrormessage("hospital deleted with rating"+rating);
			apiresponse.setTimestamp(LocalDateTime.now());
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					             .header("info", "data deleted")
					             .body(apiresponse);
		}
	}
	
	
	
	
	
	
	
	
	
}
