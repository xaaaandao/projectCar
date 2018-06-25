package Entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Sensores.class)
public abstract class Sensores_ {

	public static volatile SingularAttribute<Sensores, Integer> idsensores;
	public static volatile ListAttribute<Sensores, Dados> dadosList;
	public static volatile SingularAttribute<Sensores, String> nome;
	public static volatile SingularAttribute<Sensores, String> descricao;

}

