import {from, Observable, of} from "rxjs";
import {Player} from "@/models/player/player.model";
import {PLAYERS} from "@/api/mock.players";
import {delay, map} from "rxjs/operators";
import {AxiosResponse} from "axios";

const isRealApi = true;

export class PlayerApi{

  private axios = require('axios');

  getAllPlayers(): Observable<Player[]> {
    if (isRealApi) {
      return from(this.axios.get('http://79.114.119.116:8080/players/lazy'))
        .pipe(
          map(res => (res as AxiosResponse).data as Player[])
        );
    }
    return of(PLAYERS).pipe(delay(300));
  }
}


export const PLAYER_API = new PlayerApi();

