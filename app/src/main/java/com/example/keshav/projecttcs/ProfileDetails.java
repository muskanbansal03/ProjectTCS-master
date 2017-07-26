package com.example.keshav.projecttcs;

import java.io.Serializable;

/**
 * Created by muskan on 24-07-2017.
 */

public class ProfileDetails  implements Serializable{
    private String Name, Age, BloodGroup, City, Contact, Gender, Pincode;


    public ProfileDetails(){}

    public void setAge(String age) {
        Age = age;
    }

    public void setBloodGroup(String bloodGroup) {
        BloodGroup = bloodGroup;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setPincode(String pincode) {
        Pincode = pincode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name){ this.Name = name; }


    public String getAge() {
        return Age;
    }



    public String getBloodGroup() {
        return BloodGroup;
    }


    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getContact() {
        return Contact;
    }

    public String getGender() {
        return Gender;
    }


    public String getPincode() {
        return Pincode;
    }

}
