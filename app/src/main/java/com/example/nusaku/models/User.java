package com.example.nusaku.models;

public class User {
    private String nama;
    private String email;
    private String password;
    private String no_hp;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public User(String nama, String email, String password, String no_hp) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.no_hp = no_hp;
    }
}
