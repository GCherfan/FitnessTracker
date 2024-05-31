package com.techelevator.model;
//"SELECT food_id, foods.food_name, calories, fat, protein, carbohydrate " +
//        "FROM foods " +
//        "JOIN user_foods ON foods.food_id = user_foods.food_id " +
//        "WHERE user_foods.food_name ILIKE ?";
public class UserFoodSummary {

    private long foodId;
    private String foodName;
    private int calories;
    private double fat;
    private double protein;
    private double carbohydrate;

    public UserFoodSummary(long foodId, String foodName, int calories, double fat, double protein, double carbohydrates) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.calories = calories;
        this.fat = fat;
        this.protein = protein;
        this.carbohydrate = carbohydrates;
    }

    public long getFoodId() {
        return foodId;
    }

    public void setFoodId(long foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }
}
