<template>
  <div class="nav">
     <router-link to='/main'> <a href="#">Dashboard</a> </router-link>
     <router-link to='/addFood'> <a href="#">Add Food</a> </router-link>
      <router-link to='/update'><a href="#">Update Profile</a> </router-link>
      <router-link to='/logout'><a href="#">Logout</a></router-link>

  </div>
</template>

<script>
export default {
    name: 'header'
}
</script>

<style>
    .nav {
        background-color: #77C3EC;
        width: 100%;

    }
    
    .nav a {
        float: left;
        color: black;
        padding: 14px 16px;
        text-align: center; 
        font-size: 17px;
        text-decoration: none;
        margin-right: 5px;
        font-weight: 600;
        
    }

    .nav a:hover {
        background: rgb(165, 162, 162);
        color: #fff;
    }

</style>