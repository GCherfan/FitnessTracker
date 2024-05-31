<template>
 <center> <div>
    <p id="calendarFont">Your food diary for:  <button class="previous button">&#8249;</button>
        <input type="date" id="calendar" name="diary-log"
       v-model="diaryEntryDate.date"
       min="2021-09-01" max="2021-09-31">
       <button class="next button">&#8250;</button></p>
  </div> </center>
</template> 

<script>
export default {
    name: "diaryCalendar",
data(){
    return {
        diaryEntryDate: {
            dairyId: "",
            date: "",

    }};
},

}
</script>

<style>
.previous{
    background-color: white;
    color: black;
    height: 40px;
    width: 70px
}
.next{
    background-color: white;
    color: black;
    height: 40px;
    width: 70px
}
#calendar{
    background-color: white;
    color: black;
    height: 40px;
    width:350px;
}

#calendarFont {
    font-size: 20px;
    font-weight: 600;
}
</style>