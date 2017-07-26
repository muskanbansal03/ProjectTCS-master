package com.example.keshav.projecttcs;

import java.io.Serializable;

/**
 * Created by muskan on 21-07-2017.
 */

public class AcceptRequest implements Serializable {

    String username;
    String mobile;
    String mesage;
    boolean requestPending;

    //jhghjk
    public AcceptRequest(String username, String mobile, String mesage, boolean requestPending){
        this.username = username;
        this.mobile = mobile;
        this.mesage = mesage;
        this.requestPending = requestPending;
    }

    public String getUsername (){ return username; }
    public void setUsername(String username) { this.username = username; }
    public void setMobile(String mobile) { this.mobile = mobile; }
    public String getMobile() { return mobile; }
    public void setMesage(String mesage){ this. mesage = mesage; }
    public String getMesage() { return mesage; }
    public void setRequestPending(boolean requestPending){ this.requestPending = requestPending; }
    public boolean getRequestPending() {return requestPending;}

}
