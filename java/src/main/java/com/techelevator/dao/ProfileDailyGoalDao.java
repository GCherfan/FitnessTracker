package com.techelevator.dao;

import com.techelevator.model.Profile;
import com.techelevator.model.ProfileDailyGoal;

public interface ProfileDailyGoalDao {


    ProfileDailyGoal create(Profile profile);


    ProfileDailyGoal getProfileDailyGoalByProfileDailyGoalId(int dailyGoalId);

    ProfileDailyGoal getProfileDailyGoalByProfileId(int profileId);



}
