package com.techelevator.dao;

import com.techelevator.model.Profile;
import com.techelevator.model.UserFood;
import com.techelevator.model.UserFoodSummary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcUserFoodDao implements UserFoodDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcUserFoodDao(DataSource ds){
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public UserFood saveFood(UserFood userFood) {
        String sql = "INSERT INTO user_foods(food_name, food_id, serving_size, meal_type)" +
                "VALUES(?,(SELECT foods.food_id FROM foods WHERE foods.food_name ILIKE ?), ?, ?);";

        jdbcTemplate.update(sql, userFood.getFoodName(), userFood.getFoodName(), userFood.getServingSize(), userFood.getMealType());

        return userFood;
    }

    @Override
    public UserFood getUserFoodById(int id) {
        UserFood userFood = null;
        String sql = "SELECT * FROM user_foods WHERE diary_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if(results.next()){
            userFood = mapRowToUserFood(results);
        }
        return userFood;
    }

    @Override
    public List<UserFoodSummary> getAllUserFoods() {
        List<UserFood> userFood = new ArrayList<>();
        String sql = "SELECT foods.food_id, foods.food_name, calories, fat, protein, carbohydrate " +
                "FROM foods " +
                "JOIN user_foods ON foods.food_id = user_foods.food_id";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        List<UserFoodSummary> userFoods = new ArrayList<UserFoodSummary>();

        while(results.next()) {

            UserFoodSummary currentFood = new UserFoodSummary(
                    results.getInt("food_id"),
                    results.getString("food_name"),
                    results.getInt("calories"),
                    results.getDouble("fat"),
                    results.getDouble("protein"),
                    results.getDouble("carbohydrate")
            );
            userFoods.add(currentFood);
        }
        return userFoods;
    }

    private UserFood mapRowToUserFood(SqlRowSet rowSet) {
        UserFood userFood = new UserFood();
        userFood.setFoodName(rowSet.getString("food_name"));
        userFood.setServingSize(rowSet.getInt("serving_size"));
        userFood.setMealType(rowSet.getString("meal_type"));


        return userFood;
    }



}
