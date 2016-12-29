package com.gitapp.android.pojo;


public class RepoDetails {
    private String repoName;
    private String description;
    private String language;
    private String createdAt;
    private String updatedAt;

    public RepoDetails(String repoName, String description, String createdAt, String language, String updatedAt) {
        this.repoName = repoName;
        this.description = description;
        this.createdAt = createdAt;
        this.language = language;
        this.updatedAt = updatedAt;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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
