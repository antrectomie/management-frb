<template>
  <div>
    <h5>{{title}}{{ligue}}</h5>
  </div>
</template>

<script lang="ts">

import {Component, Prop, Vue} from "vue-property-decorator";

@Component
export default class FrbClubsPage extends Vue {
  private ligue = 'Liga I'
  private title = 'Cluburi din campionatul '
}
</script>

<style scoped>

</style>
