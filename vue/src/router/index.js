import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import SignUp from '../views/SignUp.vue'
import calendar from '../views/Calendar.vue'
import Main from '../views/Main.vue'
import Profile from '../views/Profile.vue'
import AddFood from '../views/AddFood.vue'
import DiaryLog from '../views/Dashboard.vue'
import TopHeader from '../views/AppHeader.vue'
import UpdateProfileView from '../views/UpdateProfileView.vue'




Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/profile",
      name: "profile",
      component: Profile,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },

    {
      path: "/signup",
      name: "signup",
      component: SignUp,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/main",
      name: "main",
      component: Main,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/calendar",
      name: "calendar",
      component: calendar,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/addFood",
      name: "add-food",
      component: AddFood,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/dashboard",
      name: "dashboard",
      component: DiaryLog,
      meta: {
        requiresAuth: false
      }

      },
      {
        path: "/header",
        name: "header",
        component: TopHeader,
        meta: {
          requiresAuth: false
        }
      },
      {
        path: "/update",
        name: "update-profile",
        component: UpdateProfileView,
        meta: {
          requiresAuth: false
        }
      } 

  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
