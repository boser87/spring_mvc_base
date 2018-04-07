package com.pluralsight.service;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;

import java.util.List;

public interface GoalService {
    Goal saveGoal(Goal goal);

    List<Goal> findAllGoals();

    List<GoalReport> findAllGoalReports();
}
