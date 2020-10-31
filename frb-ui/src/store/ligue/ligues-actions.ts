import {ActionContext, ActionTree} from "vuex";
import {LiguesState} from "@/store/ligue/leaguesStore";
import {LeagueMutationsTypes} from "@/store/ligue/ligues-mutations";
import {FRB_API} from "@/api/frb-api";
import {League} from "@/models/ligues/ligue-model";

export type LiguesContext = ActionContext<LiguesState, LiguesState>;

export enum LiguesActionsTypes {
  fetchAllLeagues = 'fetchAllLeagues',
  changeSelectedLeague = 'changeSelectedLeague',
}

export interface LiguesActions {
  [LiguesActionsTypes.fetchAllLeagues](context: LiguesContext): void;
  [LiguesActionsTypes.changeSelectedLeague](context: LiguesContext, league: League): void;
}

export const liguesActions: ActionTree<LiguesState, LiguesState> & LiguesActions = {
  changeSelectedLeague(context: LiguesContext, league: League): void {
    context.commit(LeagueMutationsTypes.setSelectedLeague, league);
  },
  fetchAllLeagues(context: LiguesContext): void {
    FRB_API.getAllLigues().subscribe(ligues => {
        context.commit(LeagueMutationsTypes.setLeagues, ligues);
      }
    );
  }
}
