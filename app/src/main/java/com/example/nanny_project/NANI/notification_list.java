package com.example.nanny_project.NANI;

public class notification_list {
    private int foodImage;
    private String comment;
    private String duration;


    public notification_list(int foodImage,String comment,String duration){
        this.foodImage=foodImage;
        this.comment=comment;
        this.duration=duration;
    }

    public int getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(int foodImage) {
        this.foodImage =foodImage;
    }
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
