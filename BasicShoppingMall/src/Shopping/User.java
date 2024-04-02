package Shopping;

import java.util.*;
import java.time.*;

public class User {
    
    private String uid;
    private String password;
    private String address;
    private String tel;

    public User() {}
    
    public User(String uid, String password) {
    	this.uid = uid;
    	this.password =password;
    }
    public String getUid() {
        return uid;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getTel() {
        return tel;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}