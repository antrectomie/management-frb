<template>
  <div>

    <FrbDataTable
        :row-data="players"
        :column-defs="columns"
    ></FrbDataTable>

  </div>

</template>

<script lang="ts">
import {Component, Vue} from "vue-property-decorator";
import FrbDataTable from "@/components/common/FrbDataTable.vue";
import {PLAYER_COLUMN_DEF} from "@/models/common/column.definition";
import {playersStoreFacade} from "@/store/players/players-store.facade";

@Component({
  components: {
    FrbDataTable
  }
})
export default class FrbPlayerTable extends Vue {

  get players() {
    return playersStoreFacade.getPlayers();
  }

  get columns() {
    return PLAYER_COLUMN_DEF
  }

  beforeMount() {
    playersStoreFacade.fetchPlayers();
  }

}
</script>

<style scoped>

</style>
