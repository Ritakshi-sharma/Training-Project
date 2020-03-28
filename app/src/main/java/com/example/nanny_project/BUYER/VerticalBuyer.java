package com.example.nanny_project.BUYER;

public class VerticalBuyer {
    private int images;
    private String titles;

    public VerticalBuyer(int images,String titles){
        this.images=images;
        this.titles=titles;
    }
   public int getImages(){return images;}
   public void setImages(int images){this.images=images;}
   public String getTitles(){return  titles;}
   public void setTitles(String title){this.titles=titles;}
}
