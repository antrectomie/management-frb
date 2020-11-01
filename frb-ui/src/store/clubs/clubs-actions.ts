import {ActionContext, ActionTree} from "vuex";
import {ClubsState} from "@/store/clubs/clubs-store";
import {FRB_API} from "@/api/frb-api";
import {ClubsMutationsTypes} from "@/store/clubs/clubs-mutations";

export enum ClubActionsTypes {
  FETCH_CLUBS_BY_LEAGUE = 'FETCH_CLUBS_BY_LEAGUE',
}


export interface ClubsActions {
  [ClubActionsTypes.FETCH_CLUBS_BY_LEAGUE](context: ActionContext<ClubsState, ClubsState>, leagueId: number): void;
}

export const clubsActions: ActionTree<ClubsState, ClubsState> & ClubsActions = {
  [ClubActionsTypes.FETCH_CLUBS_BY_LEAGUE](context: ActionContext<ClubsState, ClubsState>, leagueId: number): void {
    FRB_API.getClubsByLeague(leagueId).subscribe(clubs => {
      context.commit(ClubsMutationsTypes.setClubs, clubs);
    })
  }

}
