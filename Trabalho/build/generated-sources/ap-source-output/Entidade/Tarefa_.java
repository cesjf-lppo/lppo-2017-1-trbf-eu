package Entidade;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tarefa.class)
public abstract class Tarefa_ {

	public static volatile SingularAttribute<Tarefa, Etiqueta> etiqueta;
	public static volatile SingularAttribute<Tarefa, String> titulo;
	public static volatile SingularAttribute<Tarefa, Date> dataParaConclusao;
	public static volatile SingularAttribute<Tarefa, Date> dataConclusao;
	public static volatile SingularAttribute<Tarefa, Long> id;
	public static volatile SingularAttribute<Tarefa, String> descricao;

}

