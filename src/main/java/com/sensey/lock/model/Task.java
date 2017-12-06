package com.sensey.lock.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "task")
public class Task implements Serializable {

    private static final long serialVersionUID = -6880317640804962307L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_task")
    private Integer id;

    @Column
    private String description;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "task",
            fetch = FetchType.EAGER)
    private List<Developer> developers = new ArrayList<>();


    public Task() {
        //Not Implemented
    }

    public Task(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }


    public void description(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != null ? !id.equals(task.id) : task.id != null) return false;
        return description != null ? description.equals(task.description) : task.description == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Integer id() {
        return id;
    }


    @Override
    public String toString() {
        return id.toString() + " " + description;
    }

    public void addDeveloper(Developer developer) {
        this.developers.add(developer);
    }

    public List<Developer> developers() {
        return this.developers;
    }
}
