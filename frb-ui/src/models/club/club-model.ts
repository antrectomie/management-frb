export interface Club {
  id: number;
  name: string;
  nrCis: string;
  creationDate?: string;
  previousName: string;
  nominalComponentOfOrgans: string;
  league?: string;
  personOfContact?: string;
  contactPhone?: string;
  contactEmail?: string
  [key: string]: any;
}
