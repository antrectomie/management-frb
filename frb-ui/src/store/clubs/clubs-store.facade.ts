import store from '..';
import {ClubActionsTypes} from "@/store/clubs/club.actions";

export class ClubsStoreFacade {

  public fetchClubsByLeague(leagueId: number) {
    store.dispatch(ClubActionsTypes.fetchAllClubs, leagueId);
  }

}

export const clubsStoreFacade = new ClubsStoreFacade();
