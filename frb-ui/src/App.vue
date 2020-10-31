<template>
  <div id="app">
    <FrbNavbar></FrbNavbar>
    <router-view/>
  </div>
</template>
<script lang="ts">

import {Component, Vue} from "vue-property-decorator";
import FrbNavbar from "@/components/common/navbar/FrbNavbar.vue";

@Component({
  components: {
    FrbNavbar
  }
})
export default class App extends Vue{

}

</script>
<style lang="scss">
@import 'node_modules/bootstrap/scss/bootstrap.scss';
@import 'node_modules/bootstrap-vue/src/index.scss';

a {
  color: black;
}

a:link {
  text-decoration: none;
}

a:hover {
  font-size: 105%;
}

.logo {
  width: 150px;

}

.frb-page {
  padding: 30px 30px;
}
</style>
