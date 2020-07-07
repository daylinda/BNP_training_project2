package com.feedback.demo.service;

import java.util.List;

import com.feedback.demo.exception.BusinessException;
import com.feedback.demo.model.Feedback;

public interface FeedbackService {
	
	public Feedback createFeedback(Feedback feedback);
	public List<Feedback> getAllFeedback();
	public Feedback getFeedbackById(int id)throws BusinessException;
	public Feedback updateFeedback(Feedback feedback);
	public Feedback deleteFeedback(int id)throws BusinessException;
	public List<Feedback> getFeedbackByUserName(String userName)throws BusinessException;
	public List<Feedback> getFeedbackByUserEmail(String userEmail)throws BusinessException;

}
