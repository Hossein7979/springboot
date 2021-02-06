package com.example.clockify.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class restController {

    @RequestMapping(value = "/list")
    public List<String> getList(){
       List myList=new ArrayList();
       myList.add("dgf");
       myList.add("fdfdff");
       return  myList;
    }
}
