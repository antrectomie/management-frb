<template>
  <div>
    <b-navbar toggleable="lg" type="light" variant="light">
      <b-navbar-brand>
        <router-link to="/"><img
            src="https://www.frbaschet.ro/public/storage/settings/March2019/SJciz4SydNZ6TxwIIxt3.png"
            alt="FRB"
            class="d-inline-block align-top logo"
        ></router-link>
      </b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item>
            <router-link to="/clubs">Cluburi</router-link>
          </b-nav-item>
          <b-nav-item>
            <router-link to="/games">Campionat</router-link>
          </b-nav-item>
        </b-navbar-nav>


        <FrbLeaguesDropdown></FrbLeaguesDropdown>
        <!-- Right aligned nav items -->
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
      </b-collapse>
    </b-navbar>
  </div>

</template>

<script lang="ts">
import {Component, Vue} from "vue-property-decorator";
import {leaguesStoreFacade} from "@/store/leagues/leagues-store.facade";
import FrbLeaguesDropdown from "@/components/leagues/FrbLeaguesDropdown.vue";

@Component({
  name: "FrbNavbar",
  components: {FrbLeaguesDropdown},

})
export default class FrbNavbar extends Vue {

  beforeMount() {
    leaguesStoreFacade.fetchAllLeagues();
  }

}
</script>

<style scoped>

</style>
