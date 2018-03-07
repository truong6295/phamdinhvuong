package com.vuong.service;

import com.vuong.entities.Personal;
import com.vuong.entities.Project;
import com.vuong.repo.PersonalRepo;
import com.vuong.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalService {
    @Autowired
    PersonalRepo personalRepo;
    @Autowired
    ProjectRepo projectRepo;

    //hien thi tat ca personal
    public List<Personal> findAllPersonal(){
        return personalRepo.findAll();
    }

    //tim personal theo id
    public Personal findPersonalById(int id){
        return personalRepo.getOne(id);
    }

    //Them personal
    public boolean addPersonal(Personal personal){
        try{
            personalRepo.save(personal);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    //Sua personal theo id
    public boolean updatePersonal(int id, Personal personalNew){
        try {
            Personal personal = personalRepo.getOne(id);
            personal.setName(personalNew.getName());
            personal.setdOB(personalNew.getdOB());
            personal.setSex(personalNew.getSex());
            personal.setAddress(personalNew.getAddress());
            personal.setPhone(personalNew.getPhone());
            personal.setEmail(personalNew.getEmail());
            personal.setOther_details(personalNew.getOther_details());
            personalRepo.save(personal);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    //Xoa personal theo id
    public boolean deletePersonal(int id){
        try {
            for (Project project: projectRepo.findAll()){
                if (project.getPersonal().getPersonal_id()==id){
                    return false;
                }
            }
            personalRepo.delete(id);
            return true;
        }
        catch (EmptyResultDataAccessException e){
            return false;
        }
    }

}
