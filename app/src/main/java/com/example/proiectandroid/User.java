package com.example.proiectandroid;

public class User
{
    private String nume;
    private String username;
    private String email;
    private String parola;

    public User(String nume, String username, String email, String parola) {
        this.nume = nume;
        this.username = username;
        this.email = email;
        this.parola = parola;
    }

    public User()
    {

    }

    @Override
    public String toString() {
        return "User{" +
                "nume='" + nume + '\'' +
                ", prenume='" + username + '\'' +
                ", email='" + email + '\'' +
                ", parola='" + parola + '\'' +
                '}';
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getUsername() {
        return username;
    }

    public void setPrenume(String prenume) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }
}
