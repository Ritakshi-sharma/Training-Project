package com.example.nanny_project.BUYER;

public class child {
    private int images;
    private String title;
    public child(int images,String title){
        this.title=title;
        this.images=images;
    }
    public int getImages(){return images;}
    public void setImages(int images){this.images=images;}
    public String getTitle(){return title;}
    public void setTitle(String title){this.title=title;}
}
