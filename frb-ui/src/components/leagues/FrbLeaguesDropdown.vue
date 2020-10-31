<template>
  <div>
    <b-navbar-nav class="ml-auto">
      <b-nav-item-dropdown right>
        <!-- Using 'button-content' slot -->
        <template #button-content>
          <strong>{{ selectedLeague.name.toUpperCase() }}</strong>
        </template>

        <b-dropdown-item v-for="league in leagues" :key="league.id" @click="changeLeague(league)">{{ league.name.toUpperCase() }}
        </b-dropdown-item>
      </b-nav-item-dropdown>
    </b-navbar-nav>
  </div>
</template>

<script lang="ts">
import {Component, Vue} from "vue-property-decorator";
import {leaguesStoreFacade} from "@/store/leagues/leagues-store.facade";
import {League} from "@/models/ligues/ligue-model";

@Component
export default class FrbLeaguesDropdown extends Vue {

  get leagues(): League[] {
    return leaguesStoreFacade.getAllLeagues();
  }

  changeLeague(league: League) {
    leaguesStoreFacade.changeSelectedLeague(league);
  }

  get selectedLeague(): League {
    return leaguesStoreFacade.getSelectedLeague();
  }


}
</script>

<style scoped>

</style>
