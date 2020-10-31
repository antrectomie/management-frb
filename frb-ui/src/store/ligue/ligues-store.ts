import {Ligue} from "@/models/ligues/ligue-model";
import {liguesMutations} from "@/store/ligue/ligues-mutations";
import {liguesActions} from "@/store/ligue/ligues-actions";


export interface LiguesState {
  ligues: Ligue[];
  selectedLigue: Ligue;
}

export const liguesStore = {
  state: {
    ligues: [] ,
    selectedLigue: {}
  } ,
  mutations: liguesMutations,
  actions: liguesActions,
}
