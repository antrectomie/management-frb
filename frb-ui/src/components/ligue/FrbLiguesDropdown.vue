<template>
  <div>
    <b-navbar-nav class="ml-auto">
      <b-nav-item-dropdown right>
        <!-- Using 'button-content' slot -->
        <template #button-content>
          User
        </template>
        <b-dropdown-item>Profile</b-dropdown-item>
        <b-dropdown-item>Sign Out</b-dropdown-item>
      </b-nav-item-dropdown>
    </b-navbar-nav>
  </div>
</template>

<script lang="ts">
import {Component, Vue} from "vue-property-decorator";

@Component
export default class FrbLiguesDropdown extends Vue {

  get ligues() {

  }

}
</script>

<style scoped>

</style>
