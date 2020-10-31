import Vue from 'vue'
import VueRouter, { RouteConfig } from 'vue-router'
import FrbPlayerTable from "@/components/client/player/FrbPlayerTable.vue";

Vue.use(VueRouter)

const routes: Array<RouteConfig> = [
  {
    path: '/',
    name: 'Home',
    component: FrbPlayerTable
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
