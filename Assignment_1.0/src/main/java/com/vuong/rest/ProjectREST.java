package com.vuong.rest;

import com.vuong.entities.Project;
import com.vuong.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.Date;
import java.util.List;

@RestController
public class ProjectREST {
    @Autowired
    ProjectService projectService;

    //Tim tat ca project
    @GetMapping("/project/showall")
    @ResponseBody
    public List<Project> findAllProject(){
        return projectService.findAllProject();
    }

    //Tim project theo id
    @GetMapping("/project/{id}")
    @ResponseBody
    public Project findProjectById(@PathVariable("id") int id){
        return projectService.findProjectById(id);
    }

    //Them project
    @PostMapping("project/add")
    @ResponseBody
    public boolean addProject(String name, long ldOB, int idPersonal, int idRepo){
        Date dOB = new Date(ldOB);
        projectService.addProject(idPersonal, idRepo, name, dOB);
        return true;
    }

    //Sua project
    @PutMapping("project/update/{id}")
    @ResponseBody
    public boolean updateProject(@PathVariable("id") int id, String name, long ldOB, int idPersonal, int idRepo){
        Date dOB = new Date(ldOB);
        projectService.updateProject(id, idPersonal, idRepo, name, dOB);
        return true;
    }

    //Delete project
    @DeleteMapping("project/delete/{id}")
    @ResponseBody
    public boolean deleteProject(@PathVariable("id") int id){
        projectService.deleteProject(id);
        return true;
    }
}
