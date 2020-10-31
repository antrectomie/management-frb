import {Vue} from "vue-property-decorator";
import store from '..';
import {LiguesActionsTypes} from "@/store/ligue/ligues-actions";
import {leaguesStore} from "@/store/ligue/leaguesStore";
import {League} from "@/models/ligues/ligue-model";

export class LiguesStoreFacade {

  fetchAllLeagues() {
    store.dispatch(LiguesActionsTypes.fetchAllLeagues);
  }

  getAllLeagues() {
    return leaguesStore.state.leagues;
  }

  changeSelectedLeague(league: League) {
    store.dispatch(LiguesActionsTypes.changeSelectedLeague, league);
  }

}
