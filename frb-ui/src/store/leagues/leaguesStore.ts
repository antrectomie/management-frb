import {League} from "@/models/ligues/ligue-model";
import {liguesMutations} from "@/store/leagues/ligues-mutations";
import {liguesActions} from "@/store/leagues/ligues-actions";


export interface LeaguesState {
  leagues: League[];
  selectedLeague: League;
}

export const leaguesStore = {
  state: {
    leagues: [] as League[],
    selectedLeague: {}
  } as LeaguesState,
  mutations: liguesMutations,
  actions: liguesActions,
}
