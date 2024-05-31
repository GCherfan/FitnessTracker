<template>
    <div>
        <top-header/>
        <br>
        <daily-summary/>
        <br>
        <br>
       <diary-log-calendar/>
        <diary-log/>

    </div>
</template>
<script>

import DailySummary from '../components/DailySummary.vue'
import DiaryLog from '../components/DiaryLog.vue'
import DiaryLogCalendar from '../components/DiaryLogCalendar.vue'
import TopHeader from '../components/TopHeader.vue'



export default {
  components: { DailySummary, DiaryLogCalendar, DiaryLog, TopHeader }

}
</script>


<style>

</style>