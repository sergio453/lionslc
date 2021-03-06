package br.com.framework.hibernate.session;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionImpl;
//import org.hibernate.engine.SessionFactoryImplementor;    //N�o consegui fazer este import...

import br.com.framework.implementacao.crud.VariavelConexaoUtil;


/**
 * Respons�vel por estabelecer conex�o com Hibernate
 * @author SergioP
 *
 */
//@ApplicationScoped
public class HibernateUtil implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static String JAVA_COMP_ENV_JDBC_DATA_SOURCE = "java:/comp/env/jdbc/datasource";
	
	public static SessionFactory sessionFactory = buildSessionFactory();
	
	/**
	 * Respons�vel por ler o arquivo de configura��o hibernate.cfg.xml
	 * @return SessionFactory
	 */
	private static SessionFactory buildSessionFactory() {
		try {
			if (sessionFactory == null) {
				sessionFactory = new Configuration().configure().buildSessionFactory();
			}
			
			return sessionFactory;
		}catch(Exception e){
			e.printStackTrace();
			throw new ExceptionInInitializerError("Erro ao criar conex�o SessionFactory");
			
		}
	}
	
	/**
	 * Retorna uma SessionFactory corrente.
	 * @return
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	/**
	 * Retorna a sess�o do SessionFactory
	 * @return
	 */
	public static Session getCurrentSession() {		
		return getSessionFactory().getCurrentSession();
	}
	
	/**
	 * Abre uma nova sess�o no SessionFactory
	 * retorna um Session
	 */
	public static Session openSession() {
		if (sessionFactory == null) {
			buildSessionFactory();
		}		
		return sessionFactory.openSession(); 
	}
	
	/**
	 * Obtem a connection do provedor de conex�es configurado
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnectionProvider() throws SQLException{
		//return ((SessionFactoryImplementor)sessionFactory).getConnectionProvider().getConnection();
		return ((SessionImpl)getCurrentSession()).connection();
	}
	
	
	/**
	 * Retorna um objeto Cpnnection no InitialContext java:/comp/env/jdbc/datasource
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		InitialContext context = new InitialContext();
		DataSource ds = (DataSource) context.lookup(JAVA_COMP_ENV_JDBC_DATA_SOURCE);
		return ds.getConnection();		
	}
	
	/**
	 * Retorna DataSource JNDI Tomcat
	 * @return
	 * @throws NamingException
	 */
	public DataSource getDataSourceJndi() throws NamingException {
		InitialContext context = new InitialContext();
		return (DataSource) context.lookup(VariavelConexaoUtil.JAVA_COMP_ENV_JDBC_DATA_SOURCE);		
	}

}
