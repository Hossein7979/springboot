package com.example.clockify.Entities;


import org.apache.tomcat.jni.Time;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "employee_tbl")
@Component
public class employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column(name = "is_requestof_product")
    private boolean isRequstOfProduct;

    @Column(name = "remain_of_free")
    private int remainOfFree;

    @Column(name = "days_requested_free")
    private int daysOfRequestedFree;

    @Column(name = "count_of_work")
    private int countOfWork;

    @Column(name = "requst_free")
    private boolean isRequestOfFRee;

    @Column(name = "last_seen")
    private String lastSeen;

    @Column(name = "employee_code")
    private long employeeCode;

    @Column(name = "password")
    private String password;


    @Column(name = "user_name")
    private String username;


    @Column(name = "name")
    private String name;

    @Column(name = "Role")
    private String role;

    @Column(name = "last_exit")
    private String LastTimeOfExit;


    @Column(name = "reports")
    private String report;

    @Column(name = "Date_Day")
    private String dateOfDay;

    @Column(name = "type_request")
    private  String typeOfRequest;

    @Column(name = "more_explain")
    private  String moreExplain;

   @Column(name = "used_free")
    private  int usedFree;



    public int getUsedFree() {
        return usedFree;
    }

    public void setUsedFree(int usedFree) {
        this.usedFree = usedFree;
    }

    public String getMoreExplain() {
        return moreExplain;
    }

    public void setMoreExplain(String moreExplain) {
        this.moreExplain = moreExplain;
    }

    public String getTypeOfRequest() {
        return typeOfRequest;
    }

    public void setTypeOfRequest(String typeOfProduct) {
        this.typeOfRequest = typeOfProduct;
    }

    public String getDateOfDay() {
        return dateOfDay;
    }

    public void setDateOfDay(String dateOfDay) {
        this.dateOfDay = dateOfDay;
    }

    public String getLastTimeOfExit() {
        return LastTimeOfExit;
    }

    public void setLastTimeOfExit(String lastTimeOfExit) {
        LastTimeOfExit = lastTimeOfExit;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public  employee(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(long employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    public boolean isRequestOfFRee() {
        return isRequestOfFRee;
    }

    public void setRequestOfFRee(boolean requestOfFRee) {
        isRequestOfFRee = requestOfFRee;
    }

    public int getCountOfWork() {
        return countOfWork;
    }

    public void setCountOfWork(int countOfWork) {
        this.countOfWork = countOfWork;
    }

    public int getDaysOfRequestedFree() {
        return daysOfRequestedFree;
    }

    public void setDaysOfRequestedFree(int daysOfRequestedFree) {
        this.daysOfRequestedFree = daysOfRequestedFree;
    }

    public int getRemainOfFree() {
        return remainOfFree;
    }

    public void setRemainOfFree(int remainOfFree) {
        this.remainOfFree = remainOfFree;
    }

    public boolean isRequstOfProduct() {
        return isRequstOfProduct;
    }

    public void setRequstOfProduct(boolean requstOfProduct) {
        isRequstOfProduct = requstOfProduct;
    }
}
