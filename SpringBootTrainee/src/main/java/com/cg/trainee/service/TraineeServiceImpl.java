package com.cg.trainee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.trainee.dao.TraineeDao;
import com.cg.trainee.entity.Trainee;
import com.cg.trainee.exception.TraineeException;

@Service
public class TraineeServiceImpl implements TraineeService{
	
	@Autowired
	TraineeDao traineeDao;

	@Override
	public List<Trainee> getAllTrainee() {
		 List<Trainee> list=traineeDao.findAll();
		return list;
	}

	@Override
	public Trainee getTraineeById(int traineeId) throws TraineeException{
		 Trainee trainee=null;
		 if(traineeDao.existsById(traineeId))
		 {
		   trainee=traineeDao.findById(traineeId).get();
		 }
		 else
		 {
			 throw new TraineeException("Id not found");
		 }
		return trainee;
	}

	@Override
	public Trainee updateTraineeById(Trainee trainee) throws TraineeException{
		  
		 int id=trainee.getTraineeId();
		 if(traineeDao.existsById(id))
		 {
		 trainee=traineeDao.saveAndFlush(trainee);
		  
		 }
		 else
		 {
			 throw new TraineeException("Id not found");
		 }
		 
		return trainee;
	}

	@Override
	public Trainee deleteTraineeById(int traineeId) throws TraineeException{
		Trainee trainee=null;
		if(traineeDao.existsById(traineeId))
		{
		trainee=traineeDao.findById(traineeId).get();
		traineeDao.deleteById(traineeId);
		}
		else
		{
			throw new TraineeException("Id not found");
		}
		return trainee;
	}

	@Override
	public Trainee addTrainee(Trainee trainee) {

		Trainee tempTrainee=null;
		tempTrainee=traineeDao.saveAndFlush(trainee);
		return tempTrainee;
	}

}
