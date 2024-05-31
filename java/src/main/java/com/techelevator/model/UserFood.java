package com.techelevator.model;

public class UserFood {

    private String foodName;
    private int foodId;
    private int servingSize;
    private String mealType;

    public UserFood(String foodName, int foodId, int servingSize, String mealType) {

        this.foodName = foodName;
        this.foodId = foodId;
        this.servingSize = servingSize;
        this.mealType = mealType;
    }

    public UserFood(){

    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getServingSize() {
        return servingSize;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    @Override
    public String toString() {
        return "UserFood{" +
                "foodName='" + foodName + '\'' +
                ", foodId=" + foodId +
                ", servingSize=" + servingSize +
                ", mealType='" + mealType + '\'' +
                '}';
    }
}
