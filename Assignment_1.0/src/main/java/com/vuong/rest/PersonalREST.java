package com.vuong.rest;

import com.vuong.entities.Personal;
import com.vuong.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonalREST {
    @Autowired
    PersonalService personalService;

    //tim tat ca personal
    @GetMapping("/personal/showall")
    @ResponseBody
    public List<Personal> findAllPersonal(){
        return personalService.findAllPersonal();
    }

    //tim personal theo id
    @GetMapping("/personal/{id}")
    @ResponseBody
    public Personal findPersonalById(@PathVariable("id") int id){
        return personalService.findPersonalById(id);
    }

    //them personal
    @PostMapping("personal/add")
    @ResponseBody
    public Personal addPersonal(Personal personal){
        personalService.addPersonal(personal);
        return personal;
    }

    //sua personal
    @PutMapping("personal/update/{id}")
    @ResponseBody
    public Personal updatePersonal(@PathVariable("id") int id, Personal personal){
        personalService.updatePersonal(id, personal);
        return personalService.findPersonalById(id);
    }

    //delete personal
    @DeleteMapping("personal/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deletePersonal(@PathVariable("id") int id){
        personalService.deletePersonal(id);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
