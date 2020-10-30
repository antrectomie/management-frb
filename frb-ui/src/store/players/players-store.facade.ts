import store from '..';
import {PlayersActionsType} from "@/store/players/actions/players-actions";
import {playersStore} from "@/store/players/players-store";

export class PlayersStoreFacade{
  public fetchPlayers() {
    store.dispatch(PlayersActionsType.fetchAllPlayers);
  }

  public getPlayers() {
    return playersStore.state.players;
  }
}

export const playersStoreFacade = new PlayersStoreFacade();
