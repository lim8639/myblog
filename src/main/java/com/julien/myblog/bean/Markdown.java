package com.julien.myblog.bean;

/**
 * @function: Markdwon
 * @author: 863978160@qq.com
 * @create: 2021-01-21 16:08
 **/
public class Markdown {
     private  Integer id;
     private  Integer userId;
     private  String title;
     private  String fristTime;
     private  String cover;
     private  String updateTime;
     private  int authority;
     private  String content;

    public Markdown(Integer id, int userId, String title, String fristTime, String cover, String updateTime, int authority, String content) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.fristTime = fristTime;
        this.cover = cover;
        this.updateTime = updateTime;
        this.authority = authority;
        this.content = content;
    }

    public Markdown(Integer userId, String title, String cover, String updateTime, int authority, String content) {
        this.userId = userId;
        this.title = title;
        this.cover = cover;
        this.updateTime = updateTime;
        this.authority = authority;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Markdown{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", fristTime='" + fristTime + '\'' +
                ", cover='" + cover + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", authority=" + authority +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFristTime() {
        return fristTime;
    }

    public void setFristTime(String fristTime) {
        this.fristTime = fristTime;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
