package com.hospital.restspringboot.error;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apiresponse {
	private int statuscode;
	private String errormessage;
	private LocalDateTime timestamp;

}
