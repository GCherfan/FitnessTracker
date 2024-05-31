import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  }, 

  addUser(user) {
      return axios.post('/signup', user);
  },
  
  saveProfile(profile) {
    return axios.post('/profile/profile', profile);
  },

  updateProfile(profile) {
      return axios.put(`/profile/${profile.id}`, profile);
  },

  deleteProfile(profileID) {
      return axios.delete(`/profile/${profileID}`);
  }


}
