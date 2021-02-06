package com.example.clockify.controllers;

import com.example.clockify.Entities.employee;
import com.example.clockify.repsitories.empRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class homeController {

    int myId;
    TimeAndDate timeAndDate=new TimeAndDate();
    @Autowired
    empRepository empRep;
    @Autowired
    employee employee=new employee();

    @GetMapping(value = "/index")
    public String index(Model model){
        model.addAttribute("informations",new employee());

        if(myId!=0){
            employee setLastexe=empRep.findAllById(myId);
            setLastexe.setLastTimeOfExit(timeAndDate.getTime());
            empRep.save(setLastexe);
        }
        return "index";
    }

    @PostMapping(value = "/indexm")
    public String mainPage(@ModelAttribute employee emp, Model model, RedirectAttributes redirect){
        for(employee obj:empRep.findAll()){
            if(emp.getUsername().equals(obj.getUsername())&&emp.getPassword().equals(obj.getPassword())&&obj.getRole().equals("Employee")){
                model.addAttribute("profile",empRep.findAllById(obj.getId()));
                model.addAttribute("lastseen",empRep.findAllById(obj.getId()).getLastSeen());
                model.addAttribute("dateofday",String.valueOf(timeAndDate.getDay()));
                com.example.clockify.Entities.employee setLast=empRep.findAllById(obj.getId());
                setLast.setLastSeen(String.valueOf(timeAndDate.getTime()));
                //send id to profile page
              //  model.addAttribute("id",obj.getId());
                myId=obj.getId();
                empRep.save(setLast);
                return "empProfile";
            }
        }
        redirect.addFlashAttribute("wrong","username or password is incorrect!try again");
        return "redirect:/index";
    }


    //signup
    @GetMapping(value = "/signup")
    public String signup(Model model){
        model.addAttribute("setInfo",new employee());
        return  "signup";
    }
    @PostMapping(value = "/signup")
    public String saveInfo(@ModelAttribute employee employee,RedirectAttributes redirectAttributes,Model model){
        employee.setLastSeen(timeAndDate.getTime());
        employee.setLastTimeOfExit(timeAndDate.getTime());
        employee.setRemainOfFree(7);
        employee.setMoreExplain("بدون توضیح");
        employee.setCountOfWork(20);
        empRep.save(employee);

        redirectAttributes.addFlashAttribute("success_signup","You Successfully signed up!");
        boolean isAlert=true;

        model.addAttribute("bool",true);
        return "redirect:/signup";
    }

    //hozurghiab section
    @GetMapping(value = "/clock")
    public String clocking(Model model)
    {
        int counts=empRep.findAllById(myId).getCountOfWork();
        model.addAttribute("days",counts);

        model.addAttribute("employeeInfo",new employee());
        return "clock";
    }

    @PostMapping(value = "/clock")
    public String getEmployeeCode(@ModelAttribute employee employee,RedirectAttributes redirectAttributes){

        String message;
        if(employee.getEmployeeCode()==empRep.findAllById(myId).getEmployeeCode()){
            if(!empRep.findAllById(myId).getDateOfDay().equals(timeAndDate.getDay())){

                employee newCount=empRep.findAllById(myId);
                int temp=newCount.getCountOfWork()+1;
                newCount.setCountOfWork(temp);
                newCount.setDateOfDay(timeAndDate.getDay());
                String rep=empRep.findAllById(myId).getReport();
                String result=empRep.findAllById(myId).getName()+" درتاریخ "+timeAndDate.getDay()+
                        "ودرساعت"+timeAndDate.getTime()+"ثبت حضورانجام داده است";
                newCount.setReport(result);

                empRep.save(newCount);

                message="حضورشماباموفقیت ثبت گردید.";

            }else{
                message="شما برای امروزثبت حضورانجام داده اید!";
            }


        }else{
            message="شماره کارمندی اشتباه است!";
        }
            redirectAttributes.addFlashAttribute("message",message);

        return "redirect:/clock";
    }

    //darkhaste morakhasi:
    @GetMapping(value = "/leave")
    public String leave(Model model){
        model.addAttribute("leavingField",new employee());
        model.addAttribute("leaveInfo",empRep.findAllById(myId));
        return "leave";
    }

    @PostMapping(value = "/leave")
    public String leavePost(@ModelAttribute employee emp,RedirectAttributes attributes,Model model){
        employee getEmp=empRep.findAllById(myId);
        String message;
        //if remain of freedom greater than requested free we set db.
        if(emp.getDaysOfRequestedFree()<=getEmp.getRemainOfFree()){
            getEmp.setRequestOfFRee(true);
            getEmp.setTypeOfRequest(emp.getTypeOfRequest());
            getEmp.setDaysOfRequestedFree(emp.getDaysOfRequestedFree());
            getEmp.setMoreExplain(emp.getMoreExplain());
            //get data for reports:
            String name=getEmp.getName();
            String day=timeAndDate.getDay();
            String time=timeAndDate.getTime();
            String report=getEmp.getReport();
            getEmp.setReport(report+" "+name+" درتاریخ: "+day+"ودرساعت:"+time+"درخواست مرخصی کرده است") ;
            empRep.save(getEmp);

            message="درخواست شما توسط مدیر محترم بررسی خواهد شد";

        }else
            message="تعداد روزهای درخواستی شما بیش از حدمجازاست!";

        attributes.addFlashAttribute("request",message);
        return "redirect:/leave";
    }

//edit info
@GetMapping(value = "/edit")
public String edition(Model model){
    model.addAttribute("setInfo",new employee());
    return  "edit";
}
    @PostMapping(value = "/edit")
    public String editInfo(@ModelAttribute employee employee,RedirectAttributes redirectAttributes,Model model){
        employee obj=empRep.findAllById(myId);
        obj.setName(employee.getName());
        obj.setUsername(employee.getUsername());
        obj.setPassword(employee.getPassword());
        obj.setEmployeeCode(employee.getEmployeeCode());
        obj.setRole(employee.getRole());
        empRep.save(obj);
        redirectAttributes.addFlashAttribute("success_signup","اطلاعات شما با موفقیت ویرایش گردید");
        return "redirect:/edit";
    }
    //this test for git

}
