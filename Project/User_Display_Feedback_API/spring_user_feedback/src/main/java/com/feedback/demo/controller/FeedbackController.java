package com.feedback.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.demo.exception.BusinessException;
import com.feedback.demo.model.Feedback;
import com.feedback.demo.service.FeedbackService;


@RestController
public class FeedbackController  {
	
	@Autowired
	private FeedbackService service;
	
	private MultiValueMap<String, String> map;

	@PostMapping("/feedback")
	public Feedback createFeedback(@RequestBody Feedback feedback) {
		return service.createFeedback(feedback);
	}

	@GetMapping("/feedbacks")
	public List<Feedback> getAllFeedback() {
		
		return service.getAllFeedback();
	}

	@GetMapping("/feedback/{id}")
	public ResponseEntity<Feedback> getFeedbackById(@PathVariable("id") int id) {
		
		try {
			return new ResponseEntity<Feedback>(service.getFeedbackById(id),HttpStatus.OK);
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<Feedback>(null,map, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/feedback")
	public ResponseEntity<Feedback> updateFeedback(@RequestBody Feedback feedback) {
		try {
			return new ResponseEntity<Feedback>(service.updateFeedback(feedback),HttpStatus.OK);
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<Feedback>(null,map, HttpStatus.NOT_FOUND);
		}
		
	}

	@DeleteMapping("/feedback/{id}")
	public ResponseEntity<String> deleteFeedback(@PathVariable("id") int id)  {
		
		try {
			return new ResponseEntity<String>(service.deleteFeedback(id),HttpStatus.OK);
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<String>(null,map, HttpStatus.NOT_FOUND);
		}
	
	}

	
	@GetMapping("/feedbacks/userName/{userName}")
	public ResponseEntity<List<Feedback>> getFeedbackByUserName(@PathVariable("userName") String userName) throws BusinessException {
		List<Feedback> feedbackList;
		try {
			feedbackList = service.getFeedbackByUserName(userName);
			
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<>(null,map, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(feedbackList,HttpStatus.OK);
	}

	@GetMapping("/feedbacks/userEmail/{userEmail}")
	public ResponseEntity<List<Feedback>> getFeedbackByUserEmail(@PathVariable("userEmail") String userEmail) throws BusinessException {
		List<Feedback> feedbackList;
		try {
			feedbackList = service.getFeedbackByUserEmail(userEmail);
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<>(null,map, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(feedbackList,HttpStatus.OK);
	}
	
	@GetMapping("/feedbacks/ratings/{ratings}")
	public ResponseEntity<List<Feedback>> getFeedbackByRatings(@PathVariable("ratings") int ratings) throws BusinessException {
		List<Feedback> feedbackList;
		try {
			feedbackList = service.getFeedbackByRatings(ratings);
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<>(null,map, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(feedbackList,HttpStatus.OK);
	}
	
	
	
	

}
