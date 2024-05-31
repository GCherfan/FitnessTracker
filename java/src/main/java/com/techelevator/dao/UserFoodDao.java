package com.techelevator.dao;

import com.techelevator.model.UserFood;
import com.techelevator.model.UserFoodSummary;

import java.util.List;

public interface UserFoodDao {

    UserFood saveFood(UserFood userFood);
    List<UserFoodSummary> getAllUserFoods();
    UserFood getUserFoodById(int id);

}
