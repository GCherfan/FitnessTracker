package com.techelevator.dao;

import com.techelevator.model.Profile;
import com.techelevator.model.ProfileDailyGoal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcProfileDailyGoalDao implements ProfileDailyGoalDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcProfileDailyGoalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ProfileDailyGoal create(Profile profile) {
        String query = "INSERT INTO profile_daily_goal (profile_id,profile_daily_calories) VALUES (?,?) RETURNING profile_daily_goal_id;";

        int id = jdbcTemplate.queryForObject(query,Integer.class,profile.getProfile_id(),2000);
        return getProfileDailyGoalByProfileDailyGoalId(id);
    }

    @Override
    public ProfileDailyGoal getProfileDailyGoalByProfileDailyGoalId(int dailyGoalId) {
        ProfileDailyGoal profileDailyGoal = null;
        String query = "select profile_daily_goal_id, profile_id , profile_daily_calories from profile_daily_goal where profile_daily_goal_id = ? ;";


        SqlRowSet results = jdbcTemplate.queryForRowSet(query, dailyGoalId);

        if(results.next()){
            profileDailyGoal = mapToProfileDailyGoal(results);
        }

        return profileDailyGoal;
    }

    @Override
    public ProfileDailyGoal getProfileDailyGoalByProfileId(int profileId) {
        ProfileDailyGoal profileDailyGoal = null;
        String query = "select profile_daily_goal_id, profile_id , profile_daily_calories from profile_daily_goal where profile_id = ? ;";


        SqlRowSet results = jdbcTemplate.queryForRowSet(query, profileId);

        if(results.next()){
            profileDailyGoal = mapToProfileDailyGoal(results);
        }

        return profileDailyGoal;
    }


    private ProfileDailyGoal mapToProfileDailyGoal(SqlRowSet res){
        ProfileDailyGoal profileDailyGoal = new ProfileDailyGoal();
        profileDailyGoal.setProfileId(res.getInt("profile_id"));
        profileDailyGoal.setProfileDailyGoalId(res.getInt("profile_daily_goal_id"));
        profileDailyGoal.setProfileDailyCalories(res.getInt("profile_daily_calories"));
        return profileDailyGoal;
    }


}
