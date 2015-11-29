package com.example.custom.wildkrafts;

/**
 * Created by Tatwika Kashyap on 16-10-2015.
 */
public class list {
    public int imageId;
    public String title;
    public String desc;

    public list(int imageId, String title, String desc) {
        super();
        this.imageId = imageId;
        this.title = title;
        this.desc = desc;
    }
    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return title + "\n" ;
    }
}


