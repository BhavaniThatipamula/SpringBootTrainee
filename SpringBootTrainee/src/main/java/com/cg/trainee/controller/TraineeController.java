package com.cg.trainee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.trainee.entity.Trainee;
import com.cg.trainee.service.TraineeService;

@RestController
@CrossOrigin("*")
public class TraineeController {
	
	@Autowired
	TraineeService traineeService;
	
	@GetMapping("trainee")
	public List<Trainee> findAllTrainee(){
		
		List<Trainee> list=traineeService.getAllTrainee();
		return list;
		
	}
	@GetMapping("trainee/{id}")
	public ResponseEntity<Trainee> findTraineeById(@PathVariable("id")int traineeId) throws Exception{
		
		Trainee trainee=null;
		ResponseEntity rt=null;
		trainee=traineeService.getTraineeById(traineeId);
		if(trainee!=null)
		{
			rt=new ResponseEntity<Trainee>(trainee,HttpStatus.OK);
		}
		else
		{
			rt=new ResponseEntity<Trainee>(trainee,HttpStatus.NOT_FOUND);
		}
		return rt;
	}
	
	@DeleteMapping("trainee/{id}")
	public ResponseEntity<Trainee> deleteTraineeById(@PathVariable("id")int traineeId) throws Exception{
		Trainee trainee=null;
		ResponseEntity rt=null;
		trainee=traineeService.getTraineeById(traineeId);
		if(trainee!=null)
		{
		trainee=traineeService.deleteTraineeById(traineeId);
		rt= new ResponseEntity<Trainee>(trainee,HttpStatus.OK);
		}
		else
		{
			rt=new ResponseEntity<Trainee>(trainee,HttpStatus.NOT_FOUND);
		}
		
		return rt;
	}
	
	@PostMapping("trainee")
	public Trainee addTrainee(@RequestBody Trainee trainee) {
		traineeService.addTrainee(trainee);
		return trainee;
	}
	
	@PutMapping("trainee/{id}")
	public ResponseEntity<Trainee> updateTrainee(@PathVariable("id")int traineeId, @RequestBody Trainee trainee)throws Exception
	{
		Trainee trainee1=traineeService.getTraineeById(trainee.getTraineeId());
		ResponseEntity rt=null;
		if(trainee1!=null)
		{
		trainee1=traineeService.updateTraineeById(trainee);
		rt=new ResponseEntity<Trainee>(trainee, HttpStatus.OK);
		}
		else
		{
			rt=new ResponseEntity<Trainee>(trainee,HttpStatus.NOT_FOUND);
		}
		return rt;
		
	}

}
