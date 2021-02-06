package com.example.clockify.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeAndDate {
    public String getDay(){

        String date;

        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat sim=new SimpleDateFormat("dd:MM:yyyy");
        date=sim.format(calendar.getTime());

        return  date;
    }
    public String getTime(){

        String date;

        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat sim=new SimpleDateFormat("hh:mm:ss");
        date=sim.format(calendar.getTime());

        return  date;
    }
}
