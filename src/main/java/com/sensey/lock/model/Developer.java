package com.sensey.lock.model;


import javax.persistence.*;

@Entity
@Table(name = "developer")
public class Developer {

    @Id
    @Column(name = "id_developer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_task")
    private Task task;

    public Developer() {
        //Not Implemented
    }

    public void name(String name) {
        this.name = name;
    }

    public Integer id() {
        return id;
    }

    public Task task() {
        return task;
    }

    public void task(Task task) {
        this.task = task;
    }

    public static class Builder {
        private String name;

        public static Builder create() {
            return new Builder();
        }

        public Developer build() {
            Developer developer = new Developer();
            developer.name(name);
            return developer;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }
    }
}
