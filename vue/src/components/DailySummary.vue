<template>
    <div class="daily-summary">
        <header class="daily-summary-header">
            <h3>Your Daily Summary</h3>
            <div class="streak">
                <span class="streak-number">1</span>
                <ul>
                    <li>DAY</li>
                    <li>STREAK</li>
                </ul>
            </div>
        </header>
        <div class="daily-summary-details">
            <div class="daily-summary-details-left-panel">
                <div class="profile-image">
                    <img src="../img/profile_pic.png" alt="Profile Image">
                </div >
                <div class="profile-update-container">
                    <div class="pounds-lost">
                        <p><span class="pounds-lost-number">0</span> lbs <br>LOST</p>
                    </div>
                </div>
            </div>
            <div class="daily-summary-details-right-panel">
                <div class="calories-remaining-section">
                    <p>Calories Remaining <a href="">Change</a></p>
                    <div class="calories-remaining-summary">2200</div>
                    <div class="calories-remaining-details">
                        <div class="goal-calories"><span>2200</span> <br>GOAL</div>
                        <div>-</div>
                        <div class="total-calories"><span>0</span> <br>FOOD</div>
                        <div>=</div>
                        <div class="calories-remaining"><span>0</span> <br>NET</div>
                    </div>
                    <div class="progress-bar">
                        <div class="progress-filled"></div>
                    </div>
                </div>
            </div>



        </div>

        

    </div>
</template>

<script>

export default {
 
    name: "daily-summary"
};
</script>

<style>

    .daily-summary{
        display: flex;
        flex-direction: column;
        background-color: #f6f6f6;
    }

    .daily-summary-header{
        display: flex;
        justify-content: space-between;
        background-color: #0a5282;
        color: white;
    }

    .daily-summary-header h3{
        padding-left: 10px;
        line-height: 36px;
    }
    .streak{
        display: flex;
        align-items:flex-end;
    }


    .streak-number{
        padding: 0 10px;
        display: flex;
        align-items: center;  
         font-size: 45px;
  }
  
    
    .daily-summary-header ul{
           vertical-align: top;
           list-style: none;
           padding-right: 10px;
           padding-left: 2px;
    }
    .daily-summary-details{
        display: flex;
        padding-top: 10px;
        flex-grow: 1;
        height: 300px;
    }

    .daily-summary-details-left-panel{
        display: flex;
        flex-direction: column;
       justify-content: space-between;
       padding-left: 10px;
       padding-right: 5px;
       flex-grow: 1;
    }



  .profile-image  img {
  height: 200px;
}

.profile-image{  
    width: 260px;
  object-fit: cover;
}
    .profile-update-container{
        display: flex;
        justify-content:flex-start;
        align-items: center;
    }

    .pounds-lost-number{
        color: #85C400;
        font-weight: bolder;
        font-size: 1.5em;
    }

    .pounds-lost{
        margin-right: 25px;
    }
    .daily-summary-details-right-panel{
        display: flex;
        flex-direction: column;
        flex-grow: 6;
        
    }
    .calories-remaining-details{
        display: flex;
        width: 50%;
        justify-content: space-around;
    }

    .calories-remaining-summary{
        color: #85C400;
        font-weight: bolder;
        font-size: 3.5em;
        border-bottom: 1px solid #e6e6e6;
    }

    .goal-calories , .total-calories, .calories-remaining{
        font-size: 20px;
        color: #666;
        margin-bottom: 2px;
        letter-spacing: 1px
    }
</style>