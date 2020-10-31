import {from, Observable, of} from "rxjs";
import {Player} from "@/models/player/player.model";
import {LIGUES, PLAYERS} from "@/api/mock.players";
import {delay, map} from "rxjs/operators";
import {AxiosResponse} from "axios";
import {League} from "@/models/ligues/ligue-model";

const isRealApi = true;

export class FrbApi{

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

  getAllLigues(): Observable<League[]> {
    if (isRealApi) {
      return from(this.axios.get('http://79.114.119.116:8080/ligues'))
        .pipe(
          map(res => (res as AxiosResponse).data as League[])
        );
    }
    return of(LIGUES).pipe(delay(200));
  }
}


export const FRB_API = new FrbApi();

