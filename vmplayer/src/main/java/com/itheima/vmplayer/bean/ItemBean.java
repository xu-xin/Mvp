package com.itheima.vmplayer.bean;

import java.io.Serializable;

/**
 * Created by wschun on 2016/11/21.
 */
public class ItemBean implements Serializable{

    private String description;
    private String title;
    private String posterPic;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ItemBean(String description, String title, String posterPic) {
        this.description = description;
        this.title = title;
        this.posterPic = posterPic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterPic() {
        return posterPic;
    }

    public void setPosterPic(String posterPic) {
        this.posterPic = posterPic;
    }
}
