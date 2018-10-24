package com.example.bryanmarchena.foodieapp;




public class MealItem {
    private String mealTitle;
    private String mealDesc;
    private int mealImage;
    private String mealIng;
    private int mealCal;
    private String mealRec;


    MealItem (String mealTitle, String mealDesc, int mealImage, String ingredients, int calories, String recipe){
        this.mealTitle = mealTitle;
        this.mealDesc = mealDesc;
        this.mealImage = mealImage;

        this.mealIng = ingredients;
        this.mealCal = calories;
        this.mealRec = recipe;

    }

    MealItem (String mealTitle, String mealDesc, int mealImage){
        this.mealTitle = mealTitle;
        this.mealDesc = mealDesc;
        this.mealImage = mealImage;

    }

    //getters

    public int getMealImage() {
        return mealImage;
    }

    public String getMealTitle() {
        return mealTitle;
    }

    public String getMealDesc() {
        return mealDesc;
    }

    public int getMealCal() { return mealCal; }

    public String getMealIng() { return mealIng; }

    public String getMealRec() { return mealRec; }
}



