
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

