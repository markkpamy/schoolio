package com.markkpamy.apiGestionEcole.Entities.QueryDsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.markkpamy.apiGestionEcole.Entities.Classe;
import com.markkpamy.apiGestionEcole.Entities.Matiere;
import com.markkpamy.apiGestionEcole.Entities.Professeur;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProfesseur is a Querydsl query type for Professeur
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProfesseur extends EntityPathBase<Professeur> {

    private static final long serialVersionUID = -115692624L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProfesseur professeur = new QProfesseur("professeur");

    public final SetPath<Classe, QClasse> classes = this.<Classe, QClasse>createSet("classes", Classe.class, QClasse.class, PathInits.DIRECT2);

    public final QEmploye employe;

    public final NumberPath<Integer> grade = createNumber("grade", Integer.class);

    public final NumberPath<Integer> id_professeur = createNumber("id_professeur", Integer.class);

    public final SetPath<Matiere, QMatiere> matieres = this.<Matiere, QMatiere>createSet("matieres", Matiere.class, QMatiere.class, PathInits.DIRECT2);

    public QProfesseur(String variable) {
        this(Professeur.class, forVariable(variable), INITS);
    }

    public QProfesseur(Path<? extends Professeur> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProfesseur(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProfesseur(PathMetadata metadata, PathInits inits) {
        this(Professeur.class, metadata, inits);
    }

    public QProfesseur(Class<? extends Professeur> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.employe = inits.isInitialized("employe") ? new QEmploye(forProperty("employe")) : null;
    }

}

