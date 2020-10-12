package br.com.project.acessos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public enum Permissao {
	
	ADMIN("ADMIN", "Administrador"),
	USER("USER", "Usuário Padrão"),
	CADASTRO_ACESSAR("CADASTRO_ACESSAR", "Cadastro - Acessar"),
	FINANCEIRO_ACESSAR("FINANCEIRO_ACESSAR", "Fianceiro - Acessar"),
	MENSAGEM_ACESSAR("MENSAGEM_ACESSAR", "Mensagem recebida - Acessar"),
	
	PESSOAS_ACESSAR("PESSOAS_ACESSAR", "Pessoas - Acessar"),
	PESSOAS_NOVO("PESSOAS_NOVO", "Pessoas - Novo"),
	PESSOAS_EDITAR("PESSOAS_EDITAR", "Pessoas - Editar"),
	PESSOAS_EXCLUIR("PESSOAS_EXCLUIR", "Pessoas - Excluir"),
	
	CODESTADO_ACESSAR("CODESTADO_ACESSAR", "Codestado - Acessar"),
	CODESTADO_NOVO("CODESTADO_NOVO", "Codestado - Novo"),
	CODESTADO_EDITAR("CODESTADO_EDITAR", "Codestado - Editar"),
	CODESTADO_EXCLUIR("CODESTADO_EXCLUIR", "Codestado - Excluir"),
	
	CODMUNICIPIO_ACESSAR("CODMUNICIPIO_ACESSAR", "Codmunicipio - Acessar"),
	CODMUNICIPIO_NOVO("CODMUNICIPIO_NOVO", "Codmunicipio - Novo"),
	CODMUNICIPIO_EDITAR("CODMUNICIPIO_EDITAR", "Codmunicipio - Editar"),
	CODMUNICIPIO_EXCLUIR("CODMUNICIPIO_EXCLUIR", "Codmunicipio - Excluir"),
	
	CLIENTES_ACESSAR("CLIENTES_ACESSAR", "Clientes - Acessar"),
	CLIENTES_NOVO("CLIENTES_NOVO", "Clientes - Novo"),
	CLIENTES_EDITAR("CLIENTES_EDITAR", "Clientes - Editar"),
	CLIENTES_EXCLUIR("CLIENTES_EXCLUIR", "Clientes - Excluir"),
	
	LOJAS_ACESSAR("LOJAS_ACESSAR", "Lojas - Acessar"),
	LOJAS_NOVO("LOJAS_NOVO", "Lojas - Novo"),
	LOJAS_EDITAR("LOJAS_EDITAR", "Lojas - Editar"),
	LOJAS_EXCLUIR("LOJAS_EXCLUIR", "Lojas - Excluir"),
	
	LOJASFORNECEDORES_ACESSAR("LOJASFORNECEDORES_ACESSAR", "Lojasfornecedores - Acessar"),
	LOJASFORNECEDORES_NOVO("LOJASFORNECEDORES_NOVO", "Lojasfornecedores - Novo"),
	LOJASFORNECEDORES_EDITAR("LOJASFORNECEDORES_EDITAR", "Lojasfornecedores - Editar"),
	LOJASFORNECEDORES_EXCLUIR("LOJASFORNECEDORES_EXCLUIR", "Lojasfornecedores - Excluir"),
	
	FORNECEDORES_ACESSAR("FORNECEDORES_ACESSAR", "Fornecedores - Acessar"),
	FORNECEDORES_NOVO("FORNECEDORES_NOVO", "Fornecedores - Novo"),
	FORNECEDORES_EDITAR("FORNECEDORES_EDITAR", "Fornecedores - Editar"),
	FORNECEDORES_EXCLUIR("FORNECEDORES_EXCLUIR", "Fornecedores - Excluir"),
	
	USUARIOS_ACESSAR("USUARIOS_ACESSAR", "Usuarios - Acessar"),
	USUARIOS_NOVO("USUARIOS_NOVO", "Usuarios - Novo"),
	USUARIOS_EDITAR("USUARIOS_EDITAR", "Usuarios - Editar"),
	USUARIOS_EXCLUIR("USUARIOS_EXCLUIR", "Usuarios - Excluir"),
	
	FORNECEDORESPRODUTOS_ACESSAR("CLIENTES_ACESSAR", "Fornecedoresprodutos - Acessar"),
	FORNECEDORESPRODUTOS_NOVO("FORNECEDORESPRODUTOS_NOVO", "Fornecedoresprodutos - Novo"),
	FORNECEDORESPRODUTOS("FORNECEDORESPRODUTOS_EDITAR", "Fornecedoresprodutos - Editar"),
	FORNECEDORESPRODUTOS_EXCLUIR("FORNECEDORESPRODUTOS_EXCLUIR", "Fornecedoresprodutos - Excluir"),
	
	PRODUTOS_ACESSAR("PRODUTOS_ACESSAR", "Produtos - Acessar"),
	PRODUTOS_NOVO("PRODUTOS_NOVO", "Produtos - Novo"),
	PRODUTOS_EDITAR("PRODUTOS_EDITAR", "Produtos - Editar"),
	PRODUTOS_EXCLUIR("PRODUTOS_EXCLUIR", "Produtos - Excluir"),
	
	LOJASUSUARIOS_ACESSAR("LOJASUSUARIOS_ACESSAR", "Lojasusuarios - Acessar"),
	LOJASUSUARIOS_NOVO("LOJASUSUARIOS_NOVO", "Lojasusuarios - Novo"),
	LOJASUSUARIOS_EDITAR("LOJASUSUARIOS_EDITAR", "Lojasusuarios - Editar"),
	LOJASUSUARIOS_EXCLUIR("LOJASUSUARIOS_EXCLUIR", "Lojasusuarios - Excluir");
	
	
	
	
	
	private String valor = "";
	private String descricao = "";
	
	private Permissao() {
		
	}
	
	private Permissao(String name, String descricao) {
		this.valor = name;
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return getValor();
	}
	
	public static List<Permissao> getListPermissao(){
		List<Permissao> permissoes = new ArrayList<Permissao>();
		for(Permissao permissao: Permissao.values()){
			permissoes.add(permissao);
		}
		Collections.sort(permissoes, new Comparator<Permissao>() {
			@Override
			public int compare(Permissao o1, Permissao o2) {
				//Ordenando a lista...
				return new Integer(o1.ordinal()).compareTo(new Integer(o2.ordinal()));
			}			
		});
		return permissoes;
	}
	
}
