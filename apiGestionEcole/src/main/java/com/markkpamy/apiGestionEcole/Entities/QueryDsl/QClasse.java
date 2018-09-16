package com.markkpamy.apiGestionEcole.Entities.QueryDsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.markkpamy.apiGestionEcole.Entities.Classe;
import com.markkpamy.apiGestionEcole.Entities.Student;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QClasse is a Querydsl query type for Classe
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QClasse extends EntityPathBase<Classe> {

    private static final long serialVersionUID = -1245385753L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QClasse classe = new QClasse("classe");

    public final NumberPath<Integer> id_classe = createNumber("id_classe", Integer.class);

    public final StringPath nom_classe = createString("nom_classe");

    public final QProfesseur responsable;

    public final SetPath<Student, QStudent> students = this.<Student, QStudent>createSet("students", Student.class, QStudent.class, PathInits.DIRECT2);

    public QClasse(String variable) {
        this(Classe.class, forVariable(variable), INITS);
    }

    public QClasse(Path<? extends Classe> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QClasse(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QClasse(PathMetadata metadata, PathInits inits) {
        this(Classe.class, metadata, inits);
    }

    public QClasse(Class<? extends Classe> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.responsable = inits.isInitialized("responsable") ? new QProfesseur(forProperty("responsable"), inits.get("responsable")) : null;
    }

}

