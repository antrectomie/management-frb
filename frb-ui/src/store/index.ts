import Vue from 'vue'
import Vuex from 'vuex'
import {playersStore} from "@/store/players/players-store";
import {liguesStore} from "@/store/ligue/ligues-store";

Vue.use(Vuex)

export default new Vuex.Store({


  modules: {
    playersStore,
    liguesStore,
  }
})
