<template>
  <div class="club-form">
    <b-container fluid>

      <b-form @submit="onSubmit()">
        <b-form-group
            id="input-group-1"
            label="Nume Club:"
            label-for="input-1"
        >
          <b-form-input
              id="input-1"
              v-model="club.name"
              type="text"
              required
              placeholder="Introduceti numele oficial al clubului"
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-2" label="Nume Anterior:" label-for="input-2">
          <b-form-input
              id="input-2"
              v-model="club.previousName"
              required
              placeholder="Introduceti nume anterior. Doar daca este cazul"
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-3" label="Data infiintare:" label-for="input-3">
          <b-form-datepicker id="input-3" v-model="club.creationDate" class="mb-2"></b-form-datepicker>
        </b-form-group>


        <b-form-group id="nrCis-group" label="Numar CIS:" label-for="nr-cis">
          <b-form-input
              id="nr-cis"
              v-model="club.nrCis"
              required
              placeholder="Introduceti numar CIS"
          ></b-form-input>
        </b-form-group>


        <b-form-group id="iban-group" label="IBAN: " label-for="iban">
          <b-form-input
              id="iban"
              v-model="club.iban"
              required
              placeholder="Introduceti IBAN"
          ></b-form-input>
        </b-form-group>

        <b-form-group id="nominal-organs-group" label="Componenta nominala de organe: " label-for="nominal-organs">
          <b-form-input
              id="nominal-organs"
              v-model="club.nominalComponentOfOrgans"
              required
              placeholder="Introduceti organe"
          ></b-form-input>
        </b-form-group>

        <b-form-group style="flex: 33%" id="person-of-contact-label" label="Contact Club: ">
        </b-form-group>
        <b-form class="contact-group" inline>
          <b-form-group style="flex: 33%" id="person-of-contact-group" label="Nume contact: "
                        label-for="person-of-contact">
            <b-form-input style="display: flex; width: 250px;"
                id="person-of-contact"
                v-model="club.personOfContact"
                required
                placeholder="Introduceti nume"
            ></b-form-input>
          </b-form-group>

          <b-form-group style="flex: 33%; margin: auto; display: flex;" id="contact-phone-group" label="Telefon contact: "
                        label-for="contact-phone">
            <b-form-input
                id="contact-phone"
                v-model="club.contactPhone"
                required
                type="number"
                placeholder="Introduceti numar telefon"
                style="width: 250px"
            ></b-form-input>
          </b-form-group>

          <b-form-group style="flex: 33%; margin-left: auto; justify-content: flex-end" id="contact-email-group" label="Email contact: " label-for="contact-email">
            <b-form-input
                id="contact-email"
                v-model="club.contactEmail"
                required
                type="email"
                placeholder="Introduceti email"
                style="width: 250px"
            ></b-form-input>
          </b-form-group>
        </b-form>

        <div class="form-buttons">
          <b-button @click="onSubmit"  variant="primary">Adauga Club</b-button>
          <b-button type="reset" style="margin-left: auto; justify-content: flex-end" variant="danger">Reseteaza campurile</b-button>
        </div>
      </b-form>
    </b-container>

  </div>
</template>

<script lang="ts">

import {Component, Vue} from "vue-property-decorator";
import {Club} from "@/models/club/club-model";
import {FRB_API} from "@/api/frb-api";
import {leaguesStoreFacade} from "@/store/leagues/leagues-store.facade";

@Component
export default class AddNewClubForm extends Vue {

  private club: Club = {} as Club

  onSubmit($event: Event) {
    $event.preventDefault()
    FRB_API.addClub(leaguesStoreFacade.getSelectedLeague().id, this.club).subscribe(res => {
      this.$router.back();
    });
  }
}
</script>

<style scoped lang="scss">

.club-form {
  padding: 30px 30px;
}

.contact-group {
  display: flex;
  flex-direction: row;
  width: 100%;
  margin: auto;
}

.form-buttons {
  padding-top: 30px;
  display: flex;
  flex-direction: row;
}
</style>
