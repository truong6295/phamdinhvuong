package com.vuong.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "projectrole")
//@Proxy(lazy = false)
public class ProjectRole {
    private Integer projectrole_id;
    private String qualifications;
    private String other_details;
    @JsonIgnore
    private Set<Project> project = new HashSet<>(0);

    public ProjectRole() {
    }

    public ProjectRole(String qualifications, String other_details) {
        this.qualifications = qualifications;
        this.other_details = other_details;
    }

    public ProjectRole(String qualifications, String other_details, Set<Project> project) {
        this.qualifications = qualifications;
        this.other_details = other_details;
        this.project = project;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "projectrole_id")
    public Integer getProjectrole_id() {
        return projectrole_id;
    }

    public void setProjectrole_id(Integer projectrole_id) {
        this.projectrole_id = projectrole_id;
    }

    @Column(name = "qualifications")
    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }
    @Column(name = "other_details")
    public String getOther_details() {
        return other_details;
    }

    public void setOther_details(String other_details) {
        this.other_details = other_details;
    }

    @OneToMany(mappedBy = "projectRole", fetch = FetchType.LAZY)
    public Set<Project> getProject() {
        return project;
    }

    public void setProject(Set<Project> project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "ProjectRole{" +
                "projectrole_id=" + projectrole_id +
                ", qualifications='" + qualifications + '\'' +
                ", other_details='" + other_details + '\'' +
                '}';
    }
}
