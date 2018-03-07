package com.vuong.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Project {
    private Integer project_id;
    private String name;
    private Date deadline;
    private Personal personal;
    private ProjectRole projectRole;
    private String other_details;

    public Project() {
    }

    public Project(String name, Date deadline, Personal personal, ProjectRole projectRole) {
        this.name = name;
        this.deadline = deadline;
        this.personal = personal;
        this.projectRole = projectRole;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id")
    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "deadline")
    @Temporal(TemporalType.DATE)
    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @ManyToOne
    @JoinColumn(name = "personal_id")
    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    @ManyToOne
    @JoinColumn(name = "projectrole_id")
    public ProjectRole getProjectRole() {
        return projectRole;
    }

    public void setProjectRole(ProjectRole projectRole) {
        this.projectRole = projectRole;
    }

    @Column(name = "other_details")
    public String getOther_details() {
        return other_details;
    }

    public void setOther_details(String other_details) {
        this.other_details = other_details;
    }

    @Override
    public String toString() {
        return "Project{" +
                "project_id=" + project_id +
                ", name='" + name + '\'' +
                ", deadline=" + deadline +
                ", personal=" + personal.getPersonal_id() +
                ", projectRole=" + projectRole.getProjectrole_id() +
                ", other_details='" + other_details + '\'' +
                '}';
    }
}
