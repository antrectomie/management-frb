<template>
  <div class="frb-page">
    <h6><b>{{ title }}{{ league.name }}</b></h6>

    <FrbDataTable
        :row-data="clubs"
        :column-defs="columns"
    ></FrbDataTable>

  </div>
</template>

<script lang="ts">

import {Component, Vue, Watch} from "vue-property-decorator";
import {leaguesStoreFacade} from "@/store/leagues/leagues-store.facade";
import {League} from "@/models/leagues/ligue-model";
import {clubsStoreFacade} from "@/store/clubs/clubs-store.facade";
import {Club} from "@/models/club/club-model";
import {CLUB_COLUMN_DEF, ColumnDefinition} from "@/models/common/column.definition";
import FrbDataTable from "@/components/common/FrbDataTable.vue";

@Component({
  components: {
    FrbDataTable
  }
})
export default class FrbClubsPage extends Vue {

  private title = 'Cluburi din campionatul '

  get league(): League {
    return leaguesStoreFacade.getSelectedLeague();
  }

  get clubs(): Club [] {
    return clubsStoreFacade.getClubsBySelectedLeague();
  }

  get columns(): ColumnDefinition[] {
    return CLUB_COLUMN_DEF;
  }

  @Watch('league')
  public watchLeague(newVal: League) {
    console.log(this.league.name);
    if (this.league) {
      console.log(this.league.name);
      clubsStoreFacade.fetchClubsByLeague(this.league.id);
    }
  }


}
</script>

<style scoped>

</style>
