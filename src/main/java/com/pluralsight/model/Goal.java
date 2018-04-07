package com.pluralsight.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "goals")
public class Goal {

    @Id
    @GeneratedValue
    @Column(name = "GOAL_ID")
    private Long id;

    @Range(min = 1, max = 120)
    @Column(name = "MINUTES")
    private int minutes;

    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL)
    private List<Exercise> excercises = new ArrayList<>();

    public List<Exercise> getExcercises() {
        return excercises;
    }

    public void setExcercises(List<Exercise> excercises) {
        this.excercises = excercises;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

}
