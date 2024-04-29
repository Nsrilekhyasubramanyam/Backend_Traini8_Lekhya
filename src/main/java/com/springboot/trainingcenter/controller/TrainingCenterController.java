package com.springboot.trainingcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.trainingcenter.entity.TrainingCenter;
import com.springboot.trainingcenter.exceptionhandeler.CenterAlreadyExistException;
import com.springboot.trainingcenter.exceptionhandeler.ProperValidationsExceptions;
import com.springboot.trainingcenter.service.TrainingCenterService;
/*
 * Post- create or insert the data
 * Get- Retrieve data
 * RestController- combination of Controller and ResponseBody. It is used to create RestFull web Services
 * (request handling component that produces and consumes JSON or XML data).
 * Autowired- used to automatically inject dependencies into your beans.
 * ResponseEntity- used to represent the entire HTTP response, including status code,
 * headers and body. it allow to us to customize the response returned from our API endpoints.
 */
@RestController
public class TrainingCenterController {

	@Autowired
	TrainingCenterService service;
	
	@PostMapping("/save")
	// Endpoint to save training center details
	public ResponseEntity<TrainingCenter> savedDetails(@RequestBody TrainingCenter center) throws ProperValidationsExceptions, CenterAlreadyExistException{
		TrainingCenter trainingCenter=service.saveDetails(center);
		return ResponseEntity.ok().body(trainingCenter);
	}
	
	@GetMapping("/get/all")
	// Endpoint to retrieve all training center details
	public ResponseEntity<List<TrainingCenter>> getAllDetails(){
		return ResponseEntity.ok().body(service.getAllTrainingCenterDetails());
	}
}
