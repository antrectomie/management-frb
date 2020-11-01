import store from '..';
import {ClubActionsTypes} from "@/store/clubs/clubs-actions";
import {clubsStore} from "@/store/clubs/clubs-store";

export class ClubsStoreFacade {

  public fetchClubsByLeague(leagueId: number) {
    store.dispatch(ClubActionsTypes.FETCH_CLUBS_BY_LEAGUE, leagueId);
  }

  public getClubsBySelectedLeague() {
    return clubsStore.state.clubs;
  }

}

export const clubsStoreFacade = new ClubsStoreFacade();
