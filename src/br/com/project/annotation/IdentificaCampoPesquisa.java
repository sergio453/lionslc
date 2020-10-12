package br.com.project.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public abstract @interface IdentificaCampoPesquisa {
	
	String descricaoCampo();		//Descrição do campo para a tela
	String campoConsulta();			//Campo do Banco de Dados
	int principal() default 1000; 	//Posição que irá aparecer no Combo(Se não existir
									//como é o caso) ele apontará para o primeiro.

}
