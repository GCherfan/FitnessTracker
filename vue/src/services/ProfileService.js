import axios from 'axios';

export default {
    
    addProfile(profile) {
      return axios.post('/profile/save', profile);
    },
  
    updateProfile(profile) {
        return axios.put(`/profile/${profile.id}`, profile);
    },
  
    deleteProfile(profileID) {
        return axios.delete(`/profile/${profileID}`);
    },
  

    getDailyCalories(profileID){
        return axios.get(`/profile/daily-calories/${profileID}`)
    }
  
  }
  