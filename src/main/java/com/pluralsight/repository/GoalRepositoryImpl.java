package com.pluralsight.repository;

import com.pluralsight.model.Exercise;
import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("goalRepository")
public class GoalRepositoryImpl implements GoalRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Goal save(Goal goal) {
        entityManager.persist(goal);
        entityManager.flush();
        return goal;
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<Goal> loadAll() {
        Query query = entityManager.createQuery("Select g from Goal g");
        List goals = query.getResultList();
        return goals;
    }

    @Override
    public List<GoalReport> loadAllGoalReports() {
        Query query = entityManager.createQuery("Select new com.pluralsight.model.GoalReport(g.minutes, e.minutes, e.activity) " +
                "from Goal g, Exercise e where g.id = e.goal.id");

        return query.getResultList();
    }
}
