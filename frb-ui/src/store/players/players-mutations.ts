import {PlayersState} from "@/store/players/players-store";
import {Player} from "@/models/player/player.model";
import {MutationTree} from "vuex";

export enum PlayersMutationsType {
  SET_PLAYERS = 'SET_PLAYERS',
}

export interface PlayersMutations {
  [PlayersMutationsType.SET_PLAYERS](state: PlayersState, players: Player[]): void;
}

export const playersMutations: MutationTree<PlayersState> & PlayersMutations = {
  SET_PLAYERS(state: PlayersState, players: Player[]): void {
    state.players = players;
  }

}
