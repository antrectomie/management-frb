<template>
  <div>
    <b-navbar-nav class="ml-auto">
      <b-nav-item-dropdown right>
        <!-- Using 'button-content' slot -->
        <template #button-content>
          Actiuni asupra clubului selectat
        </template>
        <b-dropdown-item v-for="action in actions" :key="action.url" @click="doAction(action)">
          {{ action.value }}
        </b-dropdown-item>
      </b-nav-item-dropdown>
    </b-navbar-nav>
  </div>
</template>

<script lang="ts">

import {Component, Vue} from "vue-property-decorator";
import {CLUB_ACTIONS, ClubAction} from "@/models/club/club-action";

@Component
export default class ClubActionsDropdown extends Vue {
  private actions: ClubAction[] = CLUB_ACTIONS;

  private doAction(action: ClubAction) {
    console.log('go to ' + action.url);
  }

}
</script>

<style scoped>

</style>
