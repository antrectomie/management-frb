import {Player} from "@/models/player/player.model";
import {Store} from "vuex";
import {playersMutations} from "@/store/players/mutations/players-mutations";
import {playersActions} from "@/store/players/actions/players-actions";

export interface PlayersState{
  players: Player[];
}

export const playersStore = {
  state: {
    players: [] as Player []
  } as PlayersState,
  mutations: playersMutations,
  actions: playersActions
}
