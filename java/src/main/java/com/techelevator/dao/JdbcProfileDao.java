package com.techelevator.dao;

import com.techelevator.model.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class JdbcProfileDao implements ProfileDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcProfileDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

   @Override
    public Profile saveProfile(Profile profile) {
        Profile returnObject = null;
            String sql = "INSERT INTO profiles (user_id, first_name, last_name, age, height, " +
                    "current_weight, goal_weight, birthday, profile_picture)" +
                    "VALUES ((SELECT user_id FROM users WHERE username = ?), ?, ?, 27, ?, ?, ?, ?, ?) returning profile_id";

       String birthdayStr = profile.getBirthday();
       LocalDate birthday = LocalDate.of(
               Integer.parseInt(birthdayStr.substring(6)),
               Integer.parseInt(birthdayStr.substring(0,2)),
               Integer.parseInt(birthdayStr.substring(3,5))
       );

            int createProfileId = jdbcTemplate.queryForObject(sql,Integer.class,
                    profile.getUsername(),
                    profile.getFirstName(),
                    profile.getLastName(),
                    Long.parseLong(profile.getHeight()),
                    profile.getCurrentWeight(),
                    profile.getGoalWeight(),
                    birthday,
                    profile.getProfilePicture());


            Profile temp = getProfile(createProfileId);
            temp.setUsername(profile.getUsername());
            return temp;
    }

    @Override
    public Profile getProfile(int id) {
        Profile profile = null;
        String sql = "SELECT * FROM profiles WHERE profile_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

        if(result.next()){
            profile = mapToRowProfiles(result);
        }
        return profile;
    }

    @Override
    public List<Profile> listOfProfiles() {
        return null;
    }

    //TODO Refactor UPDATE PROFILE METHOD TO TAKE TO PROFILE OBJECT
    @Override
    public Profile updateProfile(int id) {
        Profile updatedProfile = getProfile(id);
        String sql = "UPDATE profiles SET first_name, last_name, age, height, current_weight, goal_weight, birthday, profile_picture =" +
                " ?, ?, ?, ?, ?, ?, ?, ? WHERE profile_id = ?";
        jdbcTemplate.update(sql, updatedProfile);
        return  updatedProfile;
    }

    private Profile mapToRowProfiles(SqlRowSet results){
        Profile profile = new Profile();
        profile.setProfile_id(results.getInt("profile_id"));
        profile.setUser_id(results.getInt("user_id"));
        profile.setFirstName(results.getString("first_name"));
        profile.setLastName(results.getString("last_name"));
        profile.setAge(results.getInt("age"));
        profile.setHeight(results.getString("height"));
        profile.setCurrentWeight(results.getDouble("current_weight"));
        profile.setGoalWeight(results.getDouble("goal_weight"));
        profile.setBirthday(results.getString("birthday"));
        profile.setProfilePicture(results.getString("profile_picture"));

        return profile;
    }


}
