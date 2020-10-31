import {League} from "@/models/ligues/ligue-model";
import {liguesMutations} from "@/store/ligue/ligues-mutations";
import {liguesActions} from "@/store/ligue/ligues-actions";


export interface LiguesState {
  ligues: League[];
  selectedLigue: League;
}

export const leaguesStore = {
  state: {
    leagues: [] ,
    selectedLigue: {}
  } ,
  mutations: liguesMutations,
  actions: liguesActions,
}
