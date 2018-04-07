package com.pluralsight.service;

import java.util.ArrayList;
import java.util.List;

import com.pluralsight.model.Exercise;
import com.pluralsight.model.Goal;
import com.pluralsight.repository.ExerciseRepository;
import com.pluralsight.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluralsight.model.Activity;
import org.springframework.transaction.annotation.Transactional;


@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {

	@Autowired
	private ExerciseRepository exerciseRepository;

	@Autowired
	private GoalRepository goalRepository;

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
		play.setDescription("play");
		activities.add(play);
		
		return activities;
	}

	@Override
	@Transactional
	public Exercise save(Exercise exercise) {
		return exerciseRepository.save(exercise);
	}

	@Override
	@Transactional
	public Goal saveAndUpdateGoal(Exercise exercise) {
		Exercise savedExercise = save(exercise);
		Goal goal = savedExercise.getGoal();
		goal.setMinutes(goal.getMinutes() - savedExercise.getMinutes());
		goal = goalRepository.save(goal);
		return goal;
	}

}
