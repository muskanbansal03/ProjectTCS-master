package com.example.keshav.projecttcs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.w3c.dom.Text;

/**
 * Created by muskan on 21-06-2017.
 */

public class Contact {



    String email_add, name, password, city, age, pincode, gender, phone;



    public void setAge (String age)
    {
        this.age = age;
    }
    public String getAge()
    {
        return this.age;
    }

    public void setName (String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setPassword (String password)
    {
        this.password = password;
    }
    public String getPassword()
    {
        return this.password;
    }

    public void setEmail_add (String email_add)
    {
        this.email_add = email_add;
    }
    public String getEmail_add()
    {
        return this.email_add;
    }

    public void setCity (String city)
    {
        this.city = city;
    }
    public String getCity()
    {
        return this.city;
    }

    public void setPincode (String pincode)
    {
        this.pincode = pincode;
    }
    public String getPincode()
    {
        return this.pincode;
    }

    public void setGender (String gender)
    {
        this.gender = gender;
    }
    public String getGender()
    {
        return this.gender;
    }

    public void setPhone (String phone)
    {
        this.phone = phone;
    }
    public String getPhone()
    {
        return this.phone;
    }



}
