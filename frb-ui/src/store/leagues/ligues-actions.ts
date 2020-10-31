import {ActionContext, ActionTree} from "vuex";
import {LeaguesState} from "@/store/leagues/leaguesStore";
import {LeagueMutationsTypes} from "@/store/leagues/ligues-mutations";
import {FRB_API} from "@/api/frb-api";
import {League} from "@/models/ligues/ligue-model";

export type LiguesContext = ActionContext<LeaguesState, LeaguesState>;

export enum LiguesActionsTypes {
  fetchAllLeagues = 'fetchAllLeagues',
  changeSelectedLeague = 'changeSelectedLeague',
}

export interface LiguesActions {
  [LiguesActionsTypes.fetchAllLeagues](context: LiguesContext): void;
  [LiguesActionsTypes.changeSelectedLeague](context: LiguesContext, league: League): void;
}

export const liguesActions: ActionTree<LeaguesState, LeaguesState> & LiguesActions = {
  changeSelectedLeague(context: LiguesContext, league: League): void {
    context.commit(LeagueMutationsTypes.setSelectedLeague, league);
  },
  fetchAllLeagues(context: LiguesContext): void {
    FRB_API.getAllLigues().subscribe(ligues => {
        context.commit(LeagueMutationsTypes.setLeagues, ligues);
        context.commit(LeagueMutationsTypes.setSelectedLeague, ligues[0]);
      }
    );
  }
}
