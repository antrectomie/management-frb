import {MutationTree} from "vuex";
import {ClubsState} from "@/store/clubs/clubs-store";
import {Club} from "@/models/club/club-model";

export enum ClubsMutationsTypes {
  setClubs = 'setClubs',
}

export interface ClubsMutations {
  [ClubsMutationsTypes.setClubs](state: ClubsState, clubs: Club[]): void;
}

export const clubsMutations: MutationTree<ClubsState> & ClubsMutations = {
  setClubs(state: ClubsState, clubs: Club[]): void {
    state.clubs = clubs;
  }

}
