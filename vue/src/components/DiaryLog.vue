<template>
  <center>
    <table class="food-input">
      <tr v-for="food in foods" v-bind:key="food.id">
        <td>{{food.foodName}}</td>
        <td>{{food.calories}}</td>
        <td>{{food.carbohydrate}}</td>
        <td>{{food.fat}}</td>
        <td>{{food.protein}}</td>
      </tr>
    </table>
  </center>
</template>

<script>
import apiService from "../services/ApiService";
export default {
  name: "diary-log",
  data() {
    return {
      food: {
        food_id: "",
        food_name: "",
        calories: "",
        fat: "",
        protein: "",
        carbohydrate: "",
        serving_size: "",
        food_group: "",
      },
      foods: [],
    };
  },
  created() {
    apiService.getUserFoods(this.food).then((response) => {
      if (response.status == 200) {
        console.log("success");
        this.foods = response.data;
        console.log(this.foods);
      }
    });
  },
};
</script>

<style>
.food-input {
  font-family: "Helvetica", "Arial", sans-serif;
  font-size: 15px;
  border-collapse: separate;
  table-layout: fixed;
  width: 80%;
  border-spacing: 5px 5px;
}

th {
  background-color: #9dd9f3;
  color: black;
  width: 40%;
}

td {
  border-width: 3px 0;
  width: 50%;
  background-color: whitesmoke;
  color: black;
  padding: 5px 15px;
  text-align: center;
}

#top-headers {
  color: black;
  text-align: center;
}
.first-block {
  background-color: white;
}
</style>