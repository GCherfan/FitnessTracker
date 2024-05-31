import axios from 'axios';

export default {

    getFoodByName(name) {

        return axios.get(`/all-foods/filter?name=${name}`);
    },
    updateDiary(newFoodItem) {
        return axios.post('/userFood', newFoodItem);
    },

    getUserFoods(){
        return axios.get('/userFood')
    }


}