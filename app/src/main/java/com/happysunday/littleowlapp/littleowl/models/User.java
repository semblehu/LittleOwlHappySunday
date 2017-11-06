package com.happysunday.littleowlapp.littleowl.models;

import java.util.Date;

/**
 * Created by Andreas on 29/10/2017.
 */

public class User {

    private String username;
    private String email;
    private String namalengkap;
    private String password;
    private Date tgllahir;
    private String FotoProfile;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getTgllahir() {
        return tgllahir;
    }

    public void setTgllahir(Date tgllahir) {
        this.tgllahir = tgllahir;
    }

    public String getFotoProfile() {
        return FotoProfile;
    }

    public void setFotoProfile(String fotoProfile) {
        FotoProfile = fotoProfile;
    }


    public User() {
    }

    public User(String username, String email, String namalengkap, String password, Date tgllahir, String fotoProfile) {
        this.username = username;
        this.email = email;
        this.namalengkap = namalengkap;
        this.password = password;
        this.tgllahir = tgllahir;
        FotoProfile = fotoProfile;
    }


}
