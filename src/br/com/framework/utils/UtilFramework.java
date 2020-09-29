package br.com.framework.utils;

import java.io.Serializable;
import org.springframework.stereotype.Component;

/**
 * Esta classe será responsável por gravar o usuário que está movimentando 
 * (Incluindo, editando e excluindo registros) no Banco de Dados...
 * @author SergioP
 *
 */

@Component
public class UtilFramework implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();
	
	public synchronized static ThreadLocal<Long> getTreadLocal(){
		return threadLocal;
	}

}
