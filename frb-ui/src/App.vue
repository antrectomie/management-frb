<template>
  <div id="app">
    <div>
      <b-navbar toggleable="lg" type="dark" variant="light">
        <b-navbar-brand><router-link  to="/"><img
            src="https://www.frbaschet.ro/public/storage/settings/March2019/SJciz4SydNZ6TxwIIxt3.png"
            alt="FRB"
            class="d-inline-block align-top logo"
        ></router-link></b-navbar-brand>

        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav>
          <b-navbar-nav>
            <b-nav-item> <router-link to="/clubs">Cluburi</router-link></b-nav-item>
            <b-nav-item> <router-link to="/games">Campionat</router-link></b-nav-item>
          </b-navbar-nav>

          <!-- Right aligned nav items -->
          <b-navbar-nav class="ml-auto">
            <b-nav-item-dropdown right>
              <!-- Using 'button-content' slot -->
              <template #button-content>
                <em>User</em>
              </template>
              <b-dropdown-item href="#">Profile</b-dropdown-item>
              <b-dropdown-item href="#">Sign Out</b-dropdown-item>
            </b-nav-item-dropdown>
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    </div>
    <router-view/>
  </div>
</template>

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

</style>
