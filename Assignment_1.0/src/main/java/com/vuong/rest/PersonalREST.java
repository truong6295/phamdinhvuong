package com.vuong.rest;

import com.vuong.entities.Personal;
import com.vuong.service.PersonalService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonalREST {
    @Autowired
    PersonalService personalService;
    //tim tat ca personal
    @GetMapping("personal/showall")
    @ResponseBody
    public List<Personal> findAllPersonal(){
        return personalService.findAllPersonal();
    }

    //tim personal theo id
    @GetMapping("personal/find")
    @ResponseBody
    public Personal findPersonalById(@RequestParam("id") int id){
        return personalService.findPersonalById(id);
    }

    //them personal
    @PostMapping("personal/add")
    @ResponseBody
    public Personal addPersonal(Personal personal){
        if (personalService.addPersonal(personal)){
            return personal;
        }
        return null;
    }

    //sua personal
    @PutMapping("personal/update")
    @ResponseBody
    public Personal updatePersonal(@RequestParam("id") int id, Personal personal){
        if (personalService.updatePersonal(id, personal)){
            return personalService.findPersonalById(id);
        }
        return null;
    }

    //delete personal
    @DeleteMapping("personal/delete")
    @ResponseBody
    public boolean deletePersonal(@RequestParam("id") int id){
        return personalService.deletePersonal(id);
    }
}
