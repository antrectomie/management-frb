import {LeaguesState} from "@/store/leagues/leaguesStore";
import {League} from "@/models/ligues/ligue-model";
import {MutationTree} from "vuex";

export enum LeagueMutationsTypes {
  setLeagues = 'setLeagues',
  setSelectedLeague = 'setSelectedLeague',
}

export interface LiguesMutations {
  [LeagueMutationsTypes.setLeagues](state: LeaguesState, ligues: League[]): void;

  [LeagueMutationsTypes.setSelectedLeague](state: LeaguesState, ligue: League): void;
}

export const liguesMutations: LiguesMutations & MutationTree<LeaguesState> = {
  setLeagues(state: LeaguesState, ligues: League[]): void {
    state.leagues = ligues;
  }, setSelectedLeague(state: LeaguesState, ligue: League): void {
    state.selectedLeague = ligue;
  }

}
