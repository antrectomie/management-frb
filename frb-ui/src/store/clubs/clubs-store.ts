import {Club} from "@/models/club/club-model";
import {clubsMutations} from './clubs-mutations';
import {clubsActions} from './clubs-actions';

export interface ClubsState {
  clubs: Club [];
}

export const clubsStore = {
  state: {
    clubs: []
  } as ClubsState,
  mutations: clubsMutations,
  actions: clubsActions,
}
