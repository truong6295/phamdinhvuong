package com.vuong.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "personal")
@Proxy(lazy = false)
public class Personal {
    private Integer personal_id;
    private String name;
    private Date dOB;
    private Integer sex;
    private String address;
    private String phone;
    private String email;
    private String other_details;
    @JsonIgnore
    private Set<Project> project = new HashSet<>(0);

    public Personal() {
    }

    public Personal(String name, Integer sex, String phone, String email) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
    }

    public Personal(String name, Date dOB, Integer sex, String address, String phone, String email, String other_details) {
        this.name = name;
        this.dOB = dOB;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.other_details = other_details;
    }

    public Personal(String name, Date dOB, Integer sex, String address, String phone, String email, String other_details, Set<Project> project) {
        this.name = name;
        this.dOB = dOB;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.other_details = other_details;
        this.project = project;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personal_id")
    public Integer getPersonal_id() {
        return personal_id;
    }

    public void setPersonal_id(Integer personal_id) {
        this.personal_id = personal_id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "dOB")
    @Temporal(TemporalType.DATE)
    public Date getdOB() {
        return dOB;
    }

    public void setdOB(Date dOB) {
        this.dOB = dOB;
    }

    @Column(name = "sex")
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "other_details")
    public String getOther_details() {
        return other_details;
    }

    public void setOther_details(String other_details) {
        this.other_details = other_details;
    }

    @OneToMany(mappedBy = "personal", fetch = FetchType.LAZY)
    public Set<Project> getProject() {
        return project;
    }

    public void setProject(Set<Project> project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "personal_id=" + personal_id +
                ", name='" + name + '\'' +
                ", dOB=" + dOB +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", other_details='" + other_details + '\'' +
                '}';
    }
}
