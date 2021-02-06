package com.example.clockify.Entities;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "Manager_Tbl")
@Component
public class manager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Lob
    @Column(name = "Special_Notation")
    private String specialNotation;

    @Lob
    @Column(name = "Totally_Notation")
    private String totallyNotation;

    @Column(name = "last_seen")
    private String lastSeen;

    @Column(name = "password")
    private  String password;

    @Column(name = "user_name")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "Role")
    private String role;

    @Column(name = "last_exit")
    private Date LastTimeOfExit;

    public Date getLastTimeOfExit() {
        return LastTimeOfExit;
    }

    public void setLastTimeOfExit(Date lastTimeOfExit) {
        LastTimeOfExit = lastTimeOfExit;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getTotallyNotation() {
        return totallyNotation;
    }

    public void setTotallyNotation(String totallyNotation) {
        this.totallyNotation = totallyNotation;
    }

    public String getSpecialNotation() {
        return specialNotation;
    }

    public void setSpecialNotation(String specialNotation) {
        this.specialNotation = specialNotation;
    }
}
