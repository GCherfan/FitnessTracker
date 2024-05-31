package com.techelevator.controller;


import com.techelevator.dao.UserFoodDao;
import com.techelevator.exceptions.DiaryNotFoundException;
import com.techelevator.model.UserFood;
import com.techelevator.model.UserFoodSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserFoodController {

    @Autowired
    UserFoodDao userFoodDao;

    @RequestMapping(path="/userFood", method= RequestMethod.GET)
    public List<UserFoodSummary> test() {

        return userFoodDao.getAllUserFoods();
    }


    @RequestMapping(path = "/userFood", method = RequestMethod.POST)
    public UserFood addFood(@RequestBody UserFood newFoodItem) throws DiaryNotFoundException {
                return  userFoodDao.saveFood(newFoodItem);
    }


}
