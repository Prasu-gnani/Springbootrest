package com.hospital.restspringboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Hospital")
@Entity
public class HospitalModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long isbn;
	private  String name;
	private String location;
	private double rating;

}
