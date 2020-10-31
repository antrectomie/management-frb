import {LiguesState} from "@/store/ligue/ligues-store";
import {Ligue} from "@/models/ligues/ligue-model";
import {MutationTree} from "vuex";

export enum LigueMutationsTypes {
  setLeagues = 'setLeagues',
  setSelectedLeague = 'setSelectedLeague',
}

export interface LiguesMutations {
  [LigueMutationsTypes.setLeagues](state: LiguesState, ligues: Ligue[]): void;

  [LigueMutationsTypes.setSelectedLeague](state: LiguesState, ligue: Ligue): void;
}

export const liguesMutations: LiguesMutations & MutationTree<LiguesState> = {
  setLeagues(state: LiguesState, ligues: Ligue[]): void {
    state.ligues = ligues;
  }, setSelectedLeague(state: LiguesState, ligue: Ligue): void {
    state.selectedLigue = ligue;
  }

}
