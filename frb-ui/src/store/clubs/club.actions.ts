import {ActionContext, ActionTree} from "vuex";
import {ClubsState} from "@/store/clubs/clubs-store";
import {FRB_API} from "@/api/frb-api";
import {ClubsMutationsTypes} from "@/store/clubs/clubs.mutations";

export enum ClubActionsTypes {
  fetchAllClubs = 'fetchAllClubs',
}

export type ClubsContext = ActionContext<ClubsState, ClubsState>

export interface ClubsActions {
  [ClubActionsTypes.fetchAllClubs](context: ClubsContext, leagueId: number): void;
}

export const clubsActions: ActionTree<ClubsState, ClubsState> & ClubsActions = {
  fetchAllClubs(context: ClubsContext, leagueId: number): void {
    FRB_API.getClubsByLeague(leagueId).subscribe(clubs => {
      context.commit(ClubsMutationsTypes.setClubs, clubs);
    })
  }

}
