package com.example.renuka.githubapp.pojo;

import java.util.List;

public class FollowersFollowingDetails {
    private List<String> login;
    private List<String> url;
    private List<String> location;
    private List<String> bio;

    public FollowersFollowingDetails(List<String> login, List<String> url, List<String> location, List<String> bio) {
        this.login = login;
        this.url = url;
        this.location = location;
        this.bio = bio;
    }

    public List<String> getLogin() {
        return login;
    }

    public void setLogin(List<String> login) {
        this.login = login;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    public List<String> getLocation() {
        return location;
    }

    public void setLocation(List<String> location) {
        this.location = location;
    }

    public List<String> getBio() {
        return bio;
    }

    public void setBio(List<String> bio) {
        this.bio = bio;
    }


}
