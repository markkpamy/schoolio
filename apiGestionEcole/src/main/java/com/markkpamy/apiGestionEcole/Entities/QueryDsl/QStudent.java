package com.markkpamy.apiGestionEcole.Entities.QueryDsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.markkpamy.apiGestionEcole.Entities.Student;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStudent is a Querydsl query type for Student
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudent extends EntityPathBase<Student> {

    private static final long serialVersionUID = 1609948033L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStudent student = new QStudent("student");

    public final StringPath adresse = createString("adresse");

    public final QClasse classe;

    public final DatePath<java.util.Date> date_naissance = createDate("date_naissance", java.util.Date.class);

    public final StringPath email = createString("email");

    public final NumberPath<Integer> id_eleve = createNumber("id_eleve", Integer.class);

    public final StringPath lieu_naissance = createString("lieu_naissance");

    public final StringPath nom = createString("nom");

    public final StringPath prenom = createString("prenom");

    public final StringPath telephone = createString("telephone");

    public QStudent(String variable) {
        this(Student.class, forVariable(variable), INITS);
    }

    public QStudent(Path<? extends Student> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStudent(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStudent(PathMetadata metadata, PathInits inits) {
        this(Student.class, metadata, inits);
    }

    public QStudent(Class<? extends Student> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.classe = inits.isInitialized("classe") ? new QClasse(forProperty("classe"), inits.get("classe")) : null;
    }

}

