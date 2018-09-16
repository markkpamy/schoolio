package com.markkpamy.apiGestionEcole.Entities.QueryDsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.markkpamy.apiGestionEcole.Entities.Employe;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmploye is a Querydsl query type for Employe
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEmploye extends EntityPathBase<Employe> {

    private static final long serialVersionUID = 1865024989L;

    public static final QEmploye employe = new QEmploye("employe");

    public final StringPath adresse = createString("adresse");

    public final DatePath<java.util.Date> date_naissance = createDate("date_naissance", java.util.Date.class);

    public final DateTimePath<java.util.Date> date_recrutement = createDateTime("date_recrutement", java.util.Date.class);

    public final StringPath email = createString("email");

    public final NumberPath<Integer> id_employe = createNumber("id_employe", Integer.class);

    public final StringPath lieu_naissance = createString("lieu_naissance");

    public final StringPath nom = createString("nom");

    public final StringPath prenom = createString("prenom");

    public final NumberPath<Integer> statut = createNumber("statut", Integer.class);

    public final StringPath telephone = createString("telephone");

    public QEmploye(String variable) {
        super(Employe.class, forVariable(variable));
    }

    public QEmploye(Path<? extends Employe> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmploye(PathMetadata metadata) {
        super(Employe.class, metadata);
    }

}

