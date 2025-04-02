package model;

import java.util.Date;

public class Task {
    private String assignment;
    private Date deadline;

    public Task(String name){
        this.assignment = name;
    }

    public Task(String name, Date deadline) {
        this(name);
        this.deadline = deadline;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
