package com.cg.trainee.service;

import java.util.List;

import com.cg.trainee.dao.TraineeDao;
import com.cg.trainee.entity.Trainee;
import com.cg.trainee.exception.TraineeException;

public interface TraineeService {
	


	public List<Trainee> getAllTrainee();
	public Trainee getTraineeById(int traineeId)throws TraineeException;
	public Trainee updateTraineeById(Trainee trainee)throws TraineeException;
	public Trainee deleteTraineeById(int traineeId)throws TraineeException;
	public Trainee addTrainee(Trainee trainee);

}
