export interface Colis {
  idDemande: number;
  typeColis: string;
  poids: number;
}

export interface Trajet {
  idTrajet: number;
  lieuDepart: string | null;
  destinationFinale: string | null;
  colisTransportes: Colis[];
}
