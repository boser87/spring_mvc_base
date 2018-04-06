package com.pluralsight.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pluralsight.model.Activity;


@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {

	public List<Activity> findAllActivities() {
		
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity run = new Activity();
		run.setDescription("Run");
		activities.add(run);
		
		Activity bike = new Activity();
		bike.setDescription("Bike");
		activities.add(bike);
		
		Activity swim = new Activity();
		swim.setDescription("Swim");
		activities.add(swim);

		Activity play = new Activity();
		swim.setDescription("play");
		activities.add(play);
		
		return activities;
	}
	
}
