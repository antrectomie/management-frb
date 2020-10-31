import Vue from 'vue'
import VueRouter, { RouteConfig } from 'vue-router'
import FrbPlayerTable from "@/components/player/FrbPlayerTable.vue";
import FrbClubsPage from "@/components/clubs/FrbClubsPage.vue";

Vue.use(VueRouter)

const routes: Array<RouteConfig> = [
  {
    path: '/',
    name: 'Home',
    component: FrbPlayerTable
  },
  {
    path: '/clubs',
    name: 'Clubs',
    component: FrbClubsPage,
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
