import {LiguesState} from "@/store/ligue/leaguesStore";
import {League} from "@/models/ligues/ligue-model";
import {MutationTree} from "vuex";

export enum LeagueMutationsTypes {
  setLeagues = 'setLeagues',
  setSelectedLeague = 'setSelectedLeague',
}

export interface LiguesMutations {
  [LeagueMutationsTypes.setLeagues](state: LiguesState, ligues: League[]): void;

  [LeagueMutationsTypes.setSelectedLeague](state: LiguesState, ligue: League): void;
}

export const liguesMutations: LiguesMutations & MutationTree<LiguesState> = {
  setLeagues(state: LiguesState, ligues: League[]): void {
    state.leagues = ligues;
  }, setSelectedLeague(state: LiguesState, ligue: League): void {
    state.selectedLigue = ligue;
  }

}
