class Professeur {
  
}

class Classe {
  idClasse: number;
  nomClasse: string;
  responsable: Professeur;
}

export class Student {

  idEleve: number;
  prenom: string;
  nom: string;
  email: string;
  adresse: string;
  dateNaissance: Date;
  telephone: string;
  classe: Classe;
}
