import {Player} from "@/models/player/player.model";
import {playersMutations} from "@/store/players/players-mutations";
import {playersActions} from "@/store/players/players-actions";


export interface PlayersState{
  players: Player[];
}

export const playersStore = {
  state: {
    players: []
  } ,
  mutations: playersMutations,
  actions: playersActions
}
