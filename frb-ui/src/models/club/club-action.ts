export interface ClubAction {
  value: string;
  url: string;
}


export const clubDetails: ClubAction = {
  value: 'Vezi detalii club',
  url: 'club-details'
};


export const viewClubsPlayers: ClubAction = {
  value: 'Arata toti jucatorii clubului',
  url: 'players'
};

export const addNewPlayerToClub: ClubAction = {
  value: 'Vezi jucatorii',
  url: 'add-player'
};

export const addNewDocuments: ClubAction = {
  value: 'Adauga documente',
  url: 'add-document'
};

export const seePendingDocuments: ClubAction = {
  value: 'Vezi documente cerute',
  url: 'documents-pending'
};

export const seeExpiredDocuments: ClubAction = {
  value: 'Vezi documente expirate',
  url: 'documents-expired'
};


export const askDocument: ClubAction = {
  value: 'Solicita document',
  url: 'ask-document'
};


export const seeFollowingGames: ClubAction = {
  value: 'Vezi meciurile urmatoare',
  url: 'following-games'
};

export const contactClub: ClubAction = {
  value: 'Contacteaza clubul',
  url: 'contact-club'
};

export const CLUB_ACTIONS: ClubAction [] = [
  clubDetails,
  viewClubsPlayers,
  addNewPlayerToClub,
  addNewDocuments,
  seePendingDocuments,
  seeExpiredDocuments,
  askDocument,
  seeFollowingGames,
  contactClub,
];
