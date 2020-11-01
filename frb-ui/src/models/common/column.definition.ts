
export interface ColumnDefinition {
  headerName: string;
  field: string;
}


export const PLAYER_COLUMN_DEF: ColumnDefinition[] = [
  {
    headerName: 'Id unic',
    field: 'id'
  },
  {
    headerName: 'Nume',
    field: 'firstName'
  },
  {
    headerName: 'Nume de Familie',
    field: 'lastName'
  },
  {
    headerName: 'CNP',
    field: 'cnp'
  },
  {
    headerName: 'Nationalitate la nastere',
    field: 'birthNationality'
  },
  {
    headerName: 'Nationalitate',
    field: 'currentNationality'
  },

  {
    headerName: 'Email',
    field: 'email'
  },

  {
    headerName: 'Numar Telefon',
    field: 'phoneNumber'
  },

];

export const CLUB_COLUMN_DEF: ColumnDefinition[] = [
  {
    headerName: 'Id unic',
    field: 'id'
  },
  {
    headerName: 'Nume Club',
    field: 'name'
  },
  {
    headerName: 'Numar CIS',
    field: 'nrCis'
  },
  {
    headerName: 'IBAN',
    field: 'iban'
  },
  {
    headerName: 'Data infiintare',
    field: 'creationDate'
  },
  {
    headerName: 'Nume anterior',
    field: 'previousName'
  },

  {
    headerName: 'Organe component nominal',
    field: 'nominalComponentOfOrgans'
  },

  {
    headerName: 'Nume Contact',
    field: 'personOfContact'
  },
  {
    headerName: 'Numar Telefon',
    field: 'contactPhone'
  },
  {
    headerName: 'Email',
    field: 'contactEmail'
  },

];

