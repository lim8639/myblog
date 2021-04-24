package com.julien.myblog.bean;

/**
 * @function: image
 * @author: 863978160@qq.com
 * @create: 2021-01-26 10:14
 **/




public class ImageBean {
    private String imageName;
    private String path;
    // 缩略图
    private String shortImage;
    private Integer authority;

    public ImageBean(String imageName, String path, String shortImage, Integer authority) {
        this.imageName = imageName;
        this.path = path;
        this.shortImage = shortImage;
        this.authority = authority;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getShortImage() {
        return shortImage;
    }

    public void setShortImage(String shortImage) {
        this.shortImage = shortImage;
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "ImageBean{" +
                "imageName='" + imageName + '\'' +
                ", path='" + path + '\'' +
                ", shortImage='" + shortImage + '\'' +
                ", authority=" + authority +
                '}';
    }
}
