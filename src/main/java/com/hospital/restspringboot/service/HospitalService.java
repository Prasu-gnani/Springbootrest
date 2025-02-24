package com.hospital.restspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.restspringboot.model.HospitalModel;
import com.hospital.restspringboot.repository.HospitalRepository;


@Service
public class HospitalService 
{
  
	@Autowired
	HospitalRepository hospitalRepository;

	public HospitalModel SaveHospitalModel(HospitalModel hospitalModel) 
	{
		return hospitalRepository.save(hospitalModel);
	}

	public List<HospitalModel> SaveAllHospitalModel(List<HospitalModel> hospitalModel) 
	{
		return hospitalRepository.saveAll(hospitalModel);
		
	}

	public List<HospitalModel> getallHospitalModel(List<HospitalModel> hospitalModel) 
	{
		List<HospitalModel> gethos = hospitalRepository.findAll();
		return gethos;
	}

	public Optional<HospitalModel> getById(Long id) 
	{
		return hospitalRepository.findById(id);
	}

	public Optional <List<HospitalModel>> getByLocation(String location) {
		
		return hospitalRepository.findByLocation(location);
	}

	public Optional<List<HospitalModel>> getByRating(double rating) 
	{
		return hospitalRepository.findByRating(rating);
	}

	public boolean deleteById(Long id) 
	{
			if(hospitalRepository.existsById(id))
			{	
			    hospitalRepository.deleteById(id);
			    return true;
			}
			else
			{
			    return false;
		    }
	   }

	public Optional<List<HospitalModel>> greaterThanRating(double rating) 
	{
		return hospitalRepository.findByRatingGreaterThan(rating);	
	}

	public Optional<List<HospitalModel>> lessThanRating(double rating) {
		
		return hospitalRepository.findByRatingLessThan(rating);
	}
}



	
    

