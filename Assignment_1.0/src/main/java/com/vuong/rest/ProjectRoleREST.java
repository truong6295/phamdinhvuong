package com.vuong.rest;

import com.vuong.entities.Project;
import com.vuong.entities.ProjectRole;
import com.vuong.repo.ProjectRoleRepo;
import com.vuong.service.ProjectRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectRoleREST {
    @Autowired
    ProjectRoleService projectRoleService;

    //lay tat ca projectrole
    @GetMapping("/role/showall")
    @ResponseBody
    public List<ProjectRole> findAllProject(){
        return projectRoleService.findAllProjectRole();
    }

    //tim prole theo id
    @GetMapping("/role/{id}")
    @ResponseBody
    public ProjectRole findProjectRoleById(@PathVariable("id") int id){
        return projectRoleService.findProjectRoleById(id);
    }

    //them prole
    @PostMapping("/role/add")
    @ResponseBody
    public ProjectRole addProjectRole(ProjectRole projectRole){
        projectRoleService.addProjectRole(projectRole);
        return projectRole;
    }

    //sua prole
    @PutMapping("role/update/{id}")
    @ResponseBody
    public ProjectRole updateProjectRole(@PathVariable("id") int id, ProjectRole projectRole){
        projectRoleService.updateProjectRole(id, projectRole);
        return projectRole;
    }

    //delete prole theo id
    @DeleteMapping("role/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteProjectRole(@PathVariable("id")int id){
        projectRoleService.deleteProjectRole(id);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
