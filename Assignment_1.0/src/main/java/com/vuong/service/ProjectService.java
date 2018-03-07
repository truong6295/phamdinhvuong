package com.vuong.service;

import com.vuong.entities.Personal;
import com.vuong.entities.Project;
import com.vuong.entities.ProjectRole;
import com.vuong.repo.PersonalRepo;
import com.vuong.repo.ProjectRepo;
import com.vuong.repo.ProjectRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    PersonalRepo personalRepo;
    @Autowired
    ProjectRoleRepo projectRoleRepo;

    //tim tat ca project
    public List<Project> findAllProject(){
        return projectRepo.findAll();
    }

    //tim project theo id
    public Project findProjectById(int id){
        return projectRepo.getOne(id);
    }

    //Them project
    public boolean addProject(int idPersonal, int idRepo, String name, Date deadline){
        try {
            Personal personal = personalRepo.getOne(idPersonal);
            ProjectRole projectRole = projectRoleRepo.getOne(idRepo);
            Project project = new Project(name, deadline, personal, projectRole);
            projectRepo.save(project);
            return true;
        }
        catch (EmptyResultDataAccessException e){
            return false;
        }
    }

    //Sua project theo id
    public boolean updateProject(int idProject, int idPersonal, int idRepo, String name, Date deadline){
        try {
            Project project = projectRepo.getOne(idPersonal);
            project.setName(name);
            project.setDeadline(deadline);
            project.setPersonal(personalRepo.getOne(idPersonal));
            project.setProjectRole(projectRoleRepo.getOne(idRepo));
            projectRepo.save(project);
            return true;
        }
        catch (EmptyResultDataAccessException e){
            return false;
        }
    }

    //Xoa 1 project theo id
    public boolean deleteProject(int id){
        try {
            projectRepo.delete(id);
            return true;
        }
        catch (EmptyResultDataAccessException e){
            return false;
        }
    }
}
