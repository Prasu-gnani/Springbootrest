package com.hospital.restspringboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.restspringboot.model.HospitalModel;

@Repository
public interface HospitalRepository extends JpaRepository<HospitalModel, Long> 
{
	public Optional<List<HospitalModel>> findByLocation(String location);
	public Optional<List<HospitalModel>> findByRating(double rating);
	public Optional<List<HospitalModel>> findByRatingGreaterThan(double rating);
	public Optional<List<HospitalModel>> findByRatingLessThan(double rating);

}
