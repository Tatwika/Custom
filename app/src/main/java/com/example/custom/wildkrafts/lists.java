package com.example.custom.wildkrafts;

/**
 * Created by Tatwika Kashyap on 29-10-2015.
 */
public class lists {
    public int imageId;
    public String title;
    public int arrow;

    public lists(int imageId, String title, int arrow) {
        super();
        this.imageId = imageId;
        this.title = title;
        this.arrow = arrow;
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
    public int getArrow() {
        return arrow;
    }
    public void setArrow(int  arrow) {
        this.arrow = arrow;
    }

    @Override
    public String toString() {
        return title + "\n" ;
    }
}


