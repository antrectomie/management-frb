
export interface ColumnDefinition {
  headerName: string;
  field: string;
}


export const PLAYER_COLUMN_DEF: ColumnDefinition[] = [
  {
    headerName: 'Identifier',
    field: 'id'
  },
  {
    headerName: 'First Name',
    field: 'firstName'
  },
  {
    headerName: 'Last Name',
    field: 'lastName'
  },
];

