package com.vuong.service;

import com.vuong.entities.Project;
import com.vuong.entities.ProjectRole;
import com.vuong.repo.ProjectRepo;
import com.vuong.repo.ProjectRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectRoleService {
    @Autowired
    ProjectRoleRepo projectRoleRepo;
    @Autowired
    ProjectRepo projectRepo;

    //Tim tat ca projectrepo
    public List<ProjectRole> findAllProjectRole(){
        return projectRoleRepo.findAll();
    }

    //Tim projectrepo theo id
    public ProjectRole findProjectRoleById(int id){
        return projectRoleRepo.getOne(id);
    }

    //Them projectrole
    public boolean addProjectRole(ProjectRole projectRole){
        try {
            projectRoleRepo.save(projectRole);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    //Sua projecrole theo id
    public boolean updateProjectRole(int id, ProjectRole projectRoleNew){
        try {
            ProjectRole projectRole = projectRoleRepo.getOne(id);
            projectRole.setQualifications(projectRoleNew.getQualifications());
            projectRole.setOther_details(projectRoleNew.getOther_details());
            projectRoleRepo.save(projectRole);
            return true;
        }
        catch (EmptyResultDataAccessException e){
            return false;
        }
    }

    //Xoa projectrole theo id
    public boolean deleteProjectRole(int id){
        try {
            for (Project project: projectRepo.findAll()){
                if (project.getProjectRole().getProjectrole_id()==id){
                    return false;
                }
            }
            projectRoleRepo.delete(id);
            return true;
        }
        catch (EmptyResultDataAccessException e){
            return false;
        }
    }
}
