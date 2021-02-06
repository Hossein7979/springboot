package com.example.clockify.controllers;

import com.example.clockify.Entities.employee;
import com.example.clockify.Entities.manager;
import com.example.clockify.repsitories.empRepository;
import com.example.clockify.repsitories.managerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class managerController {

    int id=1;
    int empId;
    @Autowired
    managerRepository managerRepository;
    @Autowired
    com.example.clockify.repsitories.empRepository empRepository;
    @GetMapping(value = "/manager")
    public String managerLog(Model model){
        model.addAttribute("manager",new manager());
        return "manager";
    }

    @PostMapping(value = "/manager")
    public String managerPost(@ModelAttribute manager mng, RedirectAttributes redirectAttributes,Model model){
        manager myManager=managerRepository.findAllById(id);
        if(mng.getUsername().equals(myManager.getUsername())&&myManager.getPassword().equals(myManager.getPassword())
                &&myManager.getRole().equals("Manager")){
            model.addAttribute("persons",empRepository.findAll());
            return "reports";
        }else{
            redirectAttributes.addFlashAttribute("wrong","نام کاربری یا رمزعبورنادرست است");
            return "redirect:/manager";
        }

    }

    //go operation page:
    @GetMapping(value = "/report/{id}")
    public String operate(@PathVariable("id")int ids,Model model){
        employee getInfo=empRepository.findAllById(ids);
        model.addAttribute("employeeInformations",getInfo);
        empId=ids;
        return  "operation";
    }
    @PostMapping (value = "/report/post")
    public String yes( Model model, RedirectAttributes redirectAttributes){
        employee obj=empRepository.findAllById(empId);
        if(obj.isRequestOfFRee()){
            obj.setRequestOfFRee(false);
            int remain=obj.getRemainOfFree()-obj.getDaysOfRequestedFree();
            obj.setRemainOfFree(remain);
            obj.setUsedFree(obj.getDaysOfRequestedFree());
            empRepository.save(obj);
            redirectAttributes.addFlashAttribute("success_message","مرخصی ثبت شد");
        }

        model.addAttribute("employeeInformations",obj);


        return  "operation";
    }

}
