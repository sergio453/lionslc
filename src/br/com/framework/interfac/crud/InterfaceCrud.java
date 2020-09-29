package br.com.framework.interfac.crud;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public interface InterfaceCrud<T> extends Serializable {
	
	//Salva os dados
	void save(T obj) throws Exception;
	
	void persiste(T obj) throws Exception;
	
	//Salva ou atualiza os dados
	void saveOrPersiste(T obj) throws Exception;
	
	//Realiza o update/atualização de dados
	void update(T obj) throws Exception;
	
	//Deleta os dados
	void delete(T obj) throws Exception;
	
	//Salva/atualiza e retorna um objeto em estado persistente
	T merge(T obj) throws Exception;

	//Carrega a lista de dados de determinada classe
	List<T> findList(Class<T> objs) throws Exception; 
	
	//
	Object findById(Class<T> entidade, Long id) throws Exception; 

	//
	T findByPorId(Class<T> entidade, Long id) throws Exception; 
	
	List<T> findListByQueryDinamica(String s) throws Exception; 
	
	//Executar update com HQL
	void executeUpdateQueryDinamica(String s) throws Exception; 
	
	//Executar update com SQL
	void executeUpdateSQLDinamica(String s) throws Exception;  
	
	//Limpar a sessão do Hibernate
	void clearSession() throws Exception; 
	
	//Exclui o objeto da sessão do Hibernate
	void evict(Object obj) throws Exception; 
	
	//Retorna a sessão do Hibernate
	Session getSession() throws Exception; 
	
	List<?> getListSQLDinamica(String sql) throws Exception; 
	
	//Trabalhar com JDBC do Spring
	JdbcTemplate getJdbcTemplate();
	
	//Trabalhar com JDBC do Spring
	SimpleJdbcTemplate getSimpleJdbcTemplate(); 
	
	//Trabalhar com JDBC do Spring. Esta é a atulização do método acima.
	NamedParameterJdbcTemplate getSimpleJdbcTemplate2(); 
	
	//Trabalhar com JDBC do Spring	
	SimpleJdbcInsert getSimpleJdbcInsert();
	
	//Passando o total de registros de uma determinada tabela 
	Long totalRegistros(String table) throws Exception; 
	
	Query obterQuery(String query) throws Exception; 
	
	List<Object[]> getListSQLDinamicaArray(String sql) throws Exception;
	
	//Carregamento dinâmico com JSF e PrimeFaces...	
	List<T> findListByQueryDinamica(String query, int iniciaNoRegistro, int maximoResultado) throws Exception; 
		
}
