package com.feedback.demo.service;

import java.util.List;

import com.feedback.demo.exception.BusinessException;
import com.feedback.demo.model.Feedback;

public interface FeedbackService {
	
	public Feedback createFeedback(Feedback feedback);
	public List<Feedback> getAllFeedback();
	public Feedback getFeedbackById(int id)throws BusinessException;
	public Feedback updateFeedback(Feedback feedback) throws BusinessException;
	public String deleteFeedback(int id)throws BusinessException;
	public List<Feedback> getFeedbackByUserName(String userName)throws BusinessException;
	public List<Feedback> getFeedbackByUserEmail(String userEmail)throws BusinessException;
	public List<Feedback> getFeedbackByRatings(int ratings)throws BusinessException;

}
