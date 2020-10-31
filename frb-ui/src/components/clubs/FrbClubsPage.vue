<template>
  <div class="frb-page">
    <h6><b>{{ title }}{{ league.name }}</b></h6>
  </div>
</template>

<script lang="ts">

import {Component, Vue, Watch} from "vue-property-decorator";
import {leaguesStoreFacade} from "@/store/leagues/leagues-store.facade";
import {League} from "@/models/ligues/ligue-model";
import {clubsStoreFacade} from "@/store/clubs/clubs-store.facade";

@Component
export default class FrbClubsPage extends Vue {

  private title = 'Cluburi din campionatul '

  get league(): League {
    return leaguesStoreFacade.getSelectedLeague();
  }

  @Watch('league')
  public watchLeague(newVal: League) {
    console.log(this.league);
    if (this.league) {
      console.log(this.league);
      clubsStoreFacade.fetchClubsByLeague(this.league.id);
    }
  }


}
</script>

<style scoped>

</style>
