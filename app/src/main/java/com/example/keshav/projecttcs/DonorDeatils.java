package com.example.keshav.projecttcs;

import java.io.Serializable;
import java.util.List;

/**
 * Created by muskan on 21-07-2017.
 */

public class DonorDeatils implements Serializable {

    public String username;
    public String city;
    public String mobile;
    public String bloodgroup;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String email;

    public String getGender() {        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String gender;
    public String age;
    public String pincode;


    public DonorDeatils(){}

    public void setUsername(String username) { this.username = username; }

    public void setCity(String city) { this.city = city; }

    public void setMobile(String mobile) { this.mobile = mobile; }

    public void setBloodgroup(String bloodgroup){ this.bloodgroup = bloodgroup; }

    public String getUsername() { return username; }

    public String getCity() { return city; }

    public String getMobile() { return mobile; }

    public String getBloodgroup() { return bloodgroup; }






}
