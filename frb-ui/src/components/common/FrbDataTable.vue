<template>
  <div>
    <ag-grid-vue
        class="ag-theme-alpine frb-table"
        :columnDefs="columnDefs"
        :rowData="rowData"
    ></ag-grid-vue>
  </div>
</template>

<script lang="ts">

import {Component, Prop, Vue} from "vue-property-decorator";
import {AgGridVue} from "ag-grid-vue";
import {ColumnDefinition} from "@/models/common/column.definition";
import {RowTable} from "@/models/common/row-table";

@Component({
  name: 'FrbDataTable',
  components: {
    AgGridVue
  }
})
export default class FrbDataTable extends Vue {

  @Prop() columnDefs!: ColumnDefinition[];
  @Prop() rowData!: RowTable[];

}

</script>

<style scoped lang="scss">

@import "../../../node_modules/ag-grid-community/dist/styles/ag-grid.css";
@import "../../../node_modules/ag-grid-community/dist/styles/ag-theme-alpine.css";

.frb-table {
  width: 100%;
  height: 600px;
}

</style>
