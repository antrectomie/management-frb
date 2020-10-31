import {ActionContext, ActionTree} from "vuex";
import {LiguesState} from "@/store/ligue/ligues-store";
import {LigueMutationsTypes} from "@/store/ligue/ligues-mutations";
import {FRB_API} from "@/api/frb-api";

export type LiguesContext = ActionContext<LiguesState, LiguesState>;

export enum LiguesActionsTypes {
  fetchAllLeagues = 'fetchAllLeagues',
}

export interface LiguesActions {
  [LiguesActionsTypes.fetchAllLeagues](context: LiguesContext): void;
}

export const liguesActions: ActionTree<LiguesState, LiguesState> & LiguesActions = {
  fetchAllLeagues(context: LiguesContext): void {
    FRB_API.getAllLigues().subscribe(ligues => {
        context.commit(LigueMutationsTypes.setLeagues, ligues);
      }
    );
  }
}
