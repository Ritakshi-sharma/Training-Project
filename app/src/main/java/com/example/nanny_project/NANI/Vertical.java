package com.example.nanny_project.NANI;

public class Vertical {
    private int images;
    private String title;

    public Vertical() {

    }


    public Vertical(int images, String title) {

        this.images = images;
        this.title = title;
    }

    public String getTitle(){
        return title;
    }



    public void setTitle(String title){this.title=title;}
    public int getImages(){
        return images;
    }
    public void setTitle(int images){this.title=title;}
}
