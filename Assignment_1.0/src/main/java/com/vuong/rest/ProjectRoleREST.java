package com.vuong.rest;

import com.vuong.entities.ProjectRole;
import com.vuong.service.ProjectRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectRoleREST {
    @Autowired
    ProjectRoleService projectRoleService;
    //lay tat ca projectrole
    @GetMapping("role/showall")
    @ResponseBody
    public List<ProjectRole> findAllProject(){
        return projectRoleService.findAllProjectRole();
    }

    //tim prole theo id
    @GetMapping("role/find")
    @ResponseBody
    public ProjectRole findProjectRoleById(@RequestParam("id") int id){
        return projectRoleService.findProjectRoleById(id);
    }

    //them prole
    @PostMapping("role/add")
    @ResponseBody
    public ProjectRole addProjectRole(ProjectRole projectRole){
        projectRoleService.addProjectRole(projectRole);
        return projectRole;
    }

    //sua prole
    @PutMapping("role/update")
    @ResponseBody
    public ProjectRole updateProjectRole(@RequestParam("id") int id, ProjectRole projectRole){
        projectRoleService.updateProjectRole(id, projectRole);
        return projectRole;
    }

    //delete prole theo id
    @DeleteMapping("role/delete")
    @ResponseBody
    public boolean deleteProjectRole(@RequestParam("id")int id){
        return projectRoleService.deleteProjectRole(id);
    }
}
