package com.education.ztu;

import java.io.Serializable;

public class User implements Serializable{
    private static final long serialVersionUID = -4570001204132344686L;

    private String username;
    private String password;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public static long getSerialversionuid() {
        return serialVersionUID;
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

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + "]";
    }
}
