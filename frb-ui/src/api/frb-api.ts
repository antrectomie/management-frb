import {from, Observable, of} from "rxjs";
import {Player} from "@/models/player/player.model";
import {CLUBS, LIGUES, PLAYERS} from "@/api/mock.players";
import {delay, map} from "rxjs/operators";
import {AxiosResponse} from "axios";
import {League} from "@/models/ligues/ligue-model";
import {Club} from "@/models/club/club-model";

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
      return from(this.axios.get('http://79.114.119.116:8080/leagues'))
        .pipe(
          map(res => (res as AxiosResponse).data as League[])
        );
    }
    return of(LIGUES).pipe(delay(200));
  }

  getClubsByLeague(leagueId: number): Observable<Club[]> {
    if (isRealApi) {
      console.log("CLUBS");
      console.log("CLUBS");
      console.log("CLUBS");
      console.log("CLUBS");
      console.log("CLUBS");
      console.log("CLUBS");
      console.log("CLUBS");
      return from(this.axios.get('http://79.114.119.116:8080/leagues/' + leagueId + '/clubs'))
        .pipe(
          map(res => (res as AxiosResponse).data as Club[])
        );
    }
    return of(CLUBS).pipe(delay(200));
  }
}


export const FRB_API = new FrbApi();

