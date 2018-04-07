package com.pluralsight.repository;

import com.pluralsight.model.Exercise;
import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("goalRepository")
public class GoalRepositoryImpl implements GoalRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Goal save(Goal goal) {
        if(goal.getId() == null) {
            entityManager.persist(goal);
            entityManager.flush();
        } else {
            entityManager.merge(goal);
        }
        return goal;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public List<Goal> loadAll() {
        Query query = entityManager.createQuery("Select g from Goal g");
        List goals = query.getResultList();
        return goals;
    }

    @Override
    public List<GoalReport> loadAllGoalReports() {
        TypedQuery<GoalReport> query = entityManager.createNamedQuery(Goal.FIND_GOAL_REPORTS, GoalReport.class);
        return query.getResultList();
    }
}
