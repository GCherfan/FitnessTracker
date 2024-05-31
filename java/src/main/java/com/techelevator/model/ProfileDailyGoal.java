package com.techelevator.model;

public class ProfileDailyGoal {

    private int profileDailyGoalId;
    private int profileId;
    private int profileDailyCalories;

    public int getProfileDailyGoalId() {
        return profileDailyGoalId;
    }

    public void setProfileDailyGoalId(int profileDailyGoalId) {
        this.profileDailyGoalId = profileDailyGoalId;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public int getProfileDailyCalories() {
        return profileDailyCalories;
    }

    public void setProfileDailyCalories(int profileDailyCalories) {
        this.profileDailyCalories = profileDailyCalories;
    }
}
