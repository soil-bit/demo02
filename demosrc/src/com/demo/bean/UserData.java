package com.demo.bean;

import java.util.Objects;

public class UserData {
    private String username;
    private String password;
    private Integer logCount;
    private String lastLogTime;

    public UserData() {
    }

    public UserData(String username, String password, Integer logCount, String lastLogTime) {
        this.username = username;
        this.password = password;
        this.logCount = logCount;
        this.lastLogTime = lastLogTime;
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

    public Integer getLogCount() {
        return logCount;
    }

    public void setLogCount(Integer logCount) {
        this.logCount = logCount;
    }

    public String getLastLogTime() {
        return lastLogTime;
    }

    public void setLastLogTime(String lastLogTime) {
        this.lastLogTime = lastLogTime;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", logCount=" + logCount +
                ", lastLogTime='" + lastLogTime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return Objects.equals(username, userData.username) &&
                Objects.equals(password, userData.password);

    }

    @Override
    public int hashCode() {

        return Objects.hash(username, password);
    }
}
