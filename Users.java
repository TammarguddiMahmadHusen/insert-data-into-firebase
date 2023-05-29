package com.example.youtubelogindatasave;

public class Users {
    String firstname, lastname, age, username;

    public Users() {
    }

    public Users(String firstname, String lastname, String age, String username) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAge() {
        return age;
    }

    public String getUsername() {
        return username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

