<template>
  <div>
    <div class="container">

        <h2 class='breakfast'>Add Food to Breakfast</h2>
        <hr>

        <p class="searchbar">
        
            Search out food database by name:
             <input type="search" class="search" v-model="search"> <span><button class="searchbutton" v-on:click="getFood">Search</button></span>
             <span class="matchfoods">Matching Foods:</span>
        </p>
        <div class="foodscroll">
             <div class="matchscroll">
                 <table id="foodtable">
                     <tbody>
                         <tr v-for="food in foodList" v-bind:key="food.id">
               <td class="selectFood" v-on:click="selectedFood(food.food_name)">{{food.food_name}}</td>
                <td>Serving size: {{food.serving_size}}</td>
                <br>
                         </tr>
                     </tbody>
                 </table>
                
            </div>

             <div class="scroll">
                <h4>{{selectedFoodItem}}</h4>
                <h3>Number of servings</h3>
                <input type="number" v-model="diary.servingSize"/>

                <h3>To which Meal?</h3>
                 <select name="" id="breakfast" v-model="diary.mealType">
                    <option>Breakfast</option>
                    <option>Lunch</option>
                    <option>Dinner</option>
                    <option>Snack</option>
                </select>

                <button class="add_diary" v-on:click="addToDiary">Add Food to Diary</button>

            </div> 
            
        </div>
       
        
       
    </div>

  </div>
 
</template>

<script>

import ApiService from '../services/ApiService'

export default {

name: "add-user-food",
data() {
    return{
        foodList: [],
        search: "",
        selectedFoodItem: "",
        selectedFoodId: -1,
        diary: {
            
            foodName: "",
            servingSize: "",
            mealType: ""

        }
    }  
},
methods: {
    getFood(){
        ApiService
        .getFoodByName(this.search)
        .then((response) => {
            if(response.status == 200){
                this.foodList = response.data;
            }
        }).catch(
            (error) =>  {
                alert('Food Not Found');
                console.log(error);
            }
        )
    },

    selectedFood(foodName, foodId){
        this.selectedFoodItem = foodName;
        this.selectedFoodId = foodId;
    }, 
    addToDiary() {
        const newFoodItem = {
             foodName: this.selectedFoodItem,
             foodId: this.selectedFoodId,
            servingSize: this.diary.servingSize,
            mealType: this.diary.mealType
        }

         ApiService
        .updateDiary(newFoodItem)
        .then((response) => {
            if(response.status == 200) {
                alert('Food Added');
                 this.$router.push('/main');
            }
        });
    } 

}


}
</script>

<style scoped>
    * {
        box-sizing: border-box;
    }

    body {
        color: #485e74;
        line-height: 1.6;
        font-family: 'Segoa UI', 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        padding: 1em;
    }

    .container {
        display: grid;
        grid-template-columns: 1fr 1fr;
       
       
    }

    .container hr {
        grid-column: 1/3;
        overflow: visible;
        border: 1px thin gray;
        opacity: 0.5;
        width: 100%;
     
    }

    .breakfast {
        grid-column: 1/3;
        color: rgb(20, 150, 236);
    }

    .searchbar {
        grid-column: 1/3;
        color: rgb(20, 150, 236);
        font-weight: 700;
        font-size: 16px;
    }

    .searchbar > .matchfoods {
        margin-top: 20px;
    }

    .search {
        font-size: 15px;
        margin-bottom: 20px;
    }

   
     .searchbutton {
        font-size: 16px;
        font-weight: 600;
        color: green;
       
    }

    .searchbutton:hover {
        font-size: 16px;
        border: none;
        font-weight: 600;
        background-color: green;
        color:  #fff;
        
    }

    .foodscroll {
        display: grid;
        position: relative;
        grid-column: 1/3;   
        padding: 5px;
        margin-top: 5px;
        width: 100%;
        height: 80vh;
        margin-bottom: 20px;
       
    }

      .matchscroll {
        grid-column: 1/3;   
        border: 1px solid green;
        padding: 5px;
        margin-top: 20px;
        width: 100%;
        height: 50vh;
        margin-bottom: 20px;
        text-align: center;
        overflow: scroll;
        
    }

    .scroll {
        grid-column: 1/3;   
        border: 1px solid green;
        padding: 5px;
        margin-top: 5px;
        width: 100%;
        height: 50vh;
        margin-bottom: 20px;
        text-align: center;
        background-color: whitesmoke;        
        
    }
    
    .scroll h2, h4 {
        font-weight: 700;
        color: rgb(20, 150, 236);     
    }

    .scroll h3 {
        font-size: 20px;
    }


    .scroll input {
        width: 10%;
        border: 1px solid;
        margin: 0px 10px 0px 10px;
    }

    .scroll > #breakfast {
        width: 50%;
        margin: 0px 10px 0px 10px;
    }

      .scroll select {
        width: 40%;
        margin-left: 10px;
    }

    .add_diary {
        margin-top: 15px;
        padding: 7px 7px;
        color:#fff;
        background: green;
        border: none;
        border-radius: 5px;
        font-size: 13px;
        font-weight: 600;
        
    }

      .add_diary:hover {
        margin-top: 15px;
        padding: 7px 7px;
        background: green;
        border: none;
        border-radius: 5px;
        font-size: 13px;
        font-weight: 600;
        color: #000;
        
    }

    #foodtable td{
        margin-top: 20px;
    }

    .selectFood{ 
        cursor: pointer;
    }

    .selectFood:hover{
        color: rgb(20, 150, 236);
        font-weight: 600;
    }


    @media(min-width: 700px) {
        .searchbar {
            display: grid;
            grid-column: 1/3;
            color: rgb(20, 150, 236);
            font-weight: 700;
            font-size: 20px;
        }

        .searchbar > input {
            display: grid;
            grid-column: 1fr 1fr;
            width: 50%;
            color: rgb(20, 150, 236);
            font-weight: 700;
            margin-bottom: 0px;
            
        }

        .foodscroll {
            display: flex;
            padding: 5px;
            margin-top: 5px;
            width: 85%;
            height: 40vh;
           
        }

        .scroll {
          overflow-y: scroll;
          margin: 20px;
          
        }

        .scroll input {
            width: 10%;
            margin: 0px 10px 0px 0px;
            border: 1px solid black;

        }

        .scroll select {
            margin-left: 10px;
         }

        .scroll h3 {
            font-weight: 700;
            padding: 10px;
        }


        .foodscroll :nth-child(2) {
           overflow-y: hidden;
           border: none;
        }

       .container hr {
         width: 100%;
         padding-right: 20px;
     
        }


    }

    @media(max-width: 370px) {
          .scroll {
        grid-column: 1/3;   
        border: 1px solid green;
        padding: 5px;
        margin-top: 5px;
        width: 100%;
        height: 50vh;
        margin-bottom: 20px;
        text-align: center;
        
        
    }
    }
</style>