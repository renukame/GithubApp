package com.gitapp.android.pojo;


public class UserDetails {

    private String login;
    private String avatarUrl;
    private String followersUrl;
    private String followingUrl;
    private String reposUrl;
    private String name;
    private String company;
    private String location;
    private String email;
    private String noOfFollowers;
    private String noOfFollowing;
    private String createdAt;
    private String publicRepos;


    public String getPublicRepos() {
        return publicRepos;
    }

    public void setPublicRepos(String publicRepos) {

        this.publicRepos = publicRepos;
    }

    public UserDetails(String login, String avatarUrl, String followersUrl, String followingUrl, String reposUrl, String name, String company, String location, String email, String noOfFollowers, String noOfFollowing, String createdAt, String updatedAt, String bio, String publicRepos) {
        if (login.equals("null")) {
            login = "";
        } else if (name.equals("null")) {
            name = "";
        } else if (bio.equals("null")) {
            bio = "";
        } else if (publicRepos.equals("null")) {
            publicRepos = "";
        } else if (followersUrl.equals("null")) {
            followersUrl = "";
        } else if (followingUrl.equals("null")) {
            followingUrl = "";
        } else if (reposUrl.equals("null")) {
            reposUrl = "";
        } else if (location.equals("null")) {
            location = "";
        } else if (company.equals("null")) {
            company = "";
        } else if (email.equals("null")) {
            email = "";
        } else if (noOfFollowers.equals("null")) {
            noOfFollowers = "";
        } else if (noOfFollowing.equals("null")) {
            noOfFollowing = "";
        } else if (updatedAt.equals("null")) {
            updatedAt = "";
        } else if (createdAt.equals("null")) {
            createdAt = "";
        }
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.followersUrl = followersUrl;
        this.followingUrl = followingUrl;
        this.reposUrl = reposUrl;
        this.name = name;
        this.company = company;
        this.location = location;
        this.email = email;
        this.noOfFollowers = noOfFollowers;
        this.noOfFollowing = noOfFollowing;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.bio = bio;
        this.publicRepos = publicRepos;
    }

    private String updatedAt;

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    private String bio;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoOfFollowers() {
        return noOfFollowers;
    }

    public void setNoOfFollowers(String noOfFollowers) {
        this.noOfFollowers = noOfFollowers;
    }

    public String getNoOfFollowing() {
        return noOfFollowing;
    }

    public void setNoOfFollowing(String noOfFollowing) {
        this.noOfFollowing = noOfFollowing;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }


}
