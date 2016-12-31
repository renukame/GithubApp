package com.gitapp.android.pojo;

public class FollowersDetails {
    private String login;
    private String name;
    private String location;
    private String bio;
    private String avatar;

    public FollowersDetails(String login, String name, String location, String bio, String avatar) {
        if (login.equals("null")) {
            login = "";
        }
        if (bio.equals("null")) {
            bio = "";
        }
        if (location.equals("null")) {
            location = "";
        }
        if (name.equals("null")) {
            name = "";
        }
        this.login = login;
        this.name = name;
        this.location = location;
        this.bio = bio;
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String url) {
        this.name = url;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }


}
