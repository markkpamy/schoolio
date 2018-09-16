package com.markkpamy.apiGestionEcole.Entities.QueryDsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.markkpamy.apiGestionEcole.Entities.Matiere;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMatiere is a Querydsl query type for Matiere
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMatiere extends EntityPathBase<Matiere> {

    private static final long serialVersionUID = 35164917L;

    public static final QMatiere matiere = new QMatiere("matiere");

    public final NumberPath<Integer> id_matiere = createNumber("id_matiere", Integer.class);

    public final StringPath nom_matiere = createString("nom_matiere");

    public QMatiere(String variable) {
        super(Matiere.class, forVariable(variable));
    }

    public QMatiere(Path<? extends Matiere> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMatiere(PathMetadata metadata) {
        super(Matiere.class, metadata);
    }

}

