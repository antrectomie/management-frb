import {Club} from "@/models/club/club-model";
import {clubsActions} from "@/store/clubs/club.actions";
import { clubsMutations } from './clubs.mutations';

export interface ClubsState {
  clubs: Club [];
}

export const clubsStore = {
  state: {
    clubs: []
  },
  clubsMutations,
  clubsActions,
}
