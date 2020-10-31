import Vue from 'vue'
import Vuex from 'vuex'
import {playersStore} from "@/store/players/players-store";
import {leaguesStore} from "@/store/leagues/leaguesStore";

Vue.use(Vuex)

export default new Vuex.Store({


  modules: {
    playersStore,
    leaguesStore,
  }
})
