import {ActionContext, ActionTree} from "vuex";
import {PlayersState} from "@/store/players/players-store";
import {FRB_API} from "@/api/frb-api";
import {PlayersMutationsType} from "@/store/players/players-mutations";

export enum PlayersActionsType {
  fetchAllPlayers = 'fetchAllPlayers',
}

export type PlayersActionContext = ActionContext<PlayersState, PlayersState>

export interface PlayersActions {
  [PlayersActionsType.fetchAllPlayers](context: PlayersActionContext): void;
}

export const playersActions: ActionTree<PlayersState, PlayersState> & PlayersActions = {
  fetchAllPlayers(context: PlayersActionContext): void {
    FRB_API.getAllPlayers().subscribe(res => {
      context.commit(PlayersMutationsType.SET_PLAYERS, res);
    });
  }

}
