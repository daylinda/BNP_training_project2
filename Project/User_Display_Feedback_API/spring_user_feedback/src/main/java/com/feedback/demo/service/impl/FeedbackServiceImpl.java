package com.feedback.demo.service.impl;



import java.util.List;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.demo.dao.FeedbackDAO;
import com.feedback.demo.exception.BusinessException;
import com.feedback.demo.model.Feedback;
import com.feedback.demo.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	private FeedbackDAO dao;
	
	@Override
	public Feedback createFeedback(Feedback feedback){
		
		return dao.save(feedback);
		
	}

	@Override
	public List<Feedback> getAllFeedback() {
		
		return dao.findAll();
	}

	@Override
	public Feedback getFeedbackById(int id) throws BusinessException{
		
		if(id<=0) {
			throw new BusinessException("Id "+id +" is invalid");
		}
		Feedback feedback = null;
		try {
		feedback=dao.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("No Feedback found for id "+id);
		}
		
		return feedback;
	}

	@Override
	public Feedback updateFeedback(Feedback feedback){
			
		return dao.save(feedback);
	}

	@Override
	public Feedback deleteFeedback(int id) throws BusinessException{
		
		
		if(id<=0) {
			throw new BusinessException("Id "+id +" is invalid");
		}
		Feedback feedback = null;
		try {
		feedback=dao.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("No Feedback found for id "+id);
		}
		
		dao.deleteById(id);
		
		return feedback;
		
	}

	@Override
	public List<Feedback> getFeedbackByUserName(String userName) throws BusinessException {
		
		List<Feedback> list = dao.findFeedbackByUserName(userName);
		
		if(list.isEmpty()) {
			throw new BusinessException("No feedback of User "+userName+" available");
		}
		
		return list ;
	}

	@Override
	public List<Feedback> getFeedbackByUserEmail(String userEmail) throws BusinessException {
		
		List<Feedback> list = dao.findFeedbackByUserEmail(userEmail);
		
		if(list.isEmpty()) {
			throw new BusinessException("No feedback of User with emailID "+userEmail+" available");
		}
		
		return list ;
	}

}
