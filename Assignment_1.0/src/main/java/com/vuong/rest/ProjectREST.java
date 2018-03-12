package com.vuong.rest;

import com.vuong.entities.Project;
import com.vuong.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ProjectREST {
    @Autowired
    ProjectService projectService;

    //Tim tat ca project
    @GetMapping(value = "project/showall")
    @ResponseBody
     public List<Project> findAllProject(){
        return projectService.findAllProject();
    }

    //Tim project theo id
    @GetMapping("project/find")
    @ResponseBody
    public Project findProjectById(@RequestParam("id") int id){
        return projectService.findProjectById(id);
    }

    //Them project
    @PostMapping("project/add")
    @ResponseBody
    public Project addProject(@RequestParam("idPersonal") int idPersonal, @RequestParam("idRole") int idRole, String name,
                              Date deadLine){
        if (projectService.addProject(idPersonal, idRole, name, deadLine)){
            return projectService.findProjectById(findAllProject().size());
        }
        return null;
    }

    //Sua project
    @PutMapping("project/update")
    @ResponseBody
    public Project updateProject(@RequestParam("id") int id, @RequestParam("idPersonal") int idPersonal,
                                 @RequestParam("idRole") int idRole, String name, Date deadLine){
        if (projectService.updateProject(id, idPersonal, idRole, name, deadLine)){
            return projectService.findProjectById(id);
        }
        return null;
    }

    //Delete project
    @DeleteMapping("project/delete")
    @ResponseBody
    public boolean deleteProject(@RequestParam("id") int id){
        return projectService.deleteProject(id);
    }
}
