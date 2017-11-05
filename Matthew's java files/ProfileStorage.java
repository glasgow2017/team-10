package com.example.rodrick.charityappjavafiles;

//import android.content.Intent;
//import android.os.Bundle;
//import android.support.design.widget.BottomNavigationView;
//import android.support.v7.widget.Toolbar;
//import android.view.View;

/**
 * Created by charl on 05/11/2017.
 */

public class ProfileStorage {

    private String name;
    private int age;
    private String gender;
    private String service;

    public void setName(String Name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int Age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(String gender){
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setService(String service){
        this.service = service;
    }

    public String getService() {
        return service;
    }


}

