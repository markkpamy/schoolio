class Employe {
  id_employe: number;
  nom: string;
  prenom: string;
  date_naissance: Date;
  adresse: string;
  statut: number;
  telephone: string;
  email: string;
}

class Professeur {
  id_professeur: number;
  employe: Employe;
  grade: string;
}

class Classe {
  id_classe: number;
  nom_classe: string;
  responsable: Professeur;
}

export class Student {

  id_eleve: number;
  prenom: string;
  nom: string;
  email: string;
  adresse: string;
  date_naissance: Date;
  telephone: string;
  //classe: Classe;
}
