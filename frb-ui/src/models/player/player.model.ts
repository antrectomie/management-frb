import {RowTable} from "@/models/common/row-table";

export interface Player extends RowTable {
  id: number;
  firstName?: string;
  lastName?: string;
  dateOfBirth?: string;
  cnp?: string;
  birthNationality?: string;
  currentNationality?: string;
  street?: string;
  number?: string;
  city?: string;
  county?: string;
  postOffice?: string;
  phoneNumber?: string;
  faxNumber?: string;
  email?: string;
}
