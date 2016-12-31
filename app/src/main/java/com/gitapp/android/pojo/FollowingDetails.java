package com.gitapp.android.pojo;

/**
 * Created by Renuka on 30-12-2016.
 */

public class FollowingDetails {
    private String login;
    private String name;
    private String location;
    private String bio;
    private String avatar;


    public FollowingDetails(String login, String name, String location, String bio, String avatar) {
        if (login.equals("null")) {
            login = "";
        } if (bio.equals("null")) {
            bio = "";
        } if (location.equals("null")) {
            location = "";
        } if (name.equals("null")) {
            name = "";
        }
        this.login = login;
        this.name = name;
        this.location = location;
        this.bio = bio;
        this.avatar = avatar;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public String getName() {
        return name;
    }

    public void setName(String url) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
