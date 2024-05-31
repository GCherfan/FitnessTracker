package com.techelevator.controller;

import com.techelevator.dao.ProfileDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping(path= "/profile")
//@PreAuthorize("isAuthorized()")
public class ProfileController {

    @Autowired
    ProfileDao dao;
    UserDao userDao;


    @RequestMapping(path= "/profile", method = RequestMethod.POST)
    public Profile saveProfile(@RequestBody Profile profile){

        Profile profileFromDB = dao.saveProfile(profile);
        return profileFromDB;
    }

    @RequestMapping(path= "/{id}", method = RequestMethod.GET)
    public Profile getProfile(@Valid @PathVariable("id") int profileId){
        Profile profile = dao.getProfile(profileId);
        return profile;
    }

    @RequestMapping(path= "/update/{id}", method = RequestMethod.PUT)
    public Profile updateProfile(@Valid @PathVariable int id){
        Profile profile = dao.updateProfile(id);
        return profile;
    }



}
