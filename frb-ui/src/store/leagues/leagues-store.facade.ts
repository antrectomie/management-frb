import {Vue} from "vue-property-decorator";
import store from '..';
import {LiguesActionsTypes} from "@/store/leagues/ligues-actions";
import {leaguesStore} from "@/store/leagues/leaguesStore";
import {League} from "@/models/ligues/ligue-model";

export class LeaguesStoreFacade {

  fetchAllLeagues() {
    store.dispatch(LiguesActionsTypes.fetchAllLeagues);
  }

  getAllLeagues() {
    return leaguesStore.state.leagues;
  }

  changeSelectedLeague(league: League) {
    store.dispatch(LiguesActionsTypes.changeSelectedLeague, league);
  }

  getSelectedLeague() {
    return leaguesStore.state.selectedLeague;
  }

}

export const leaguesStoreFacade = new LeaguesStoreFacade();
