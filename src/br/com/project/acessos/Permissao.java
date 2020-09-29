package br.com.project.acessos;

public enum Permissao {
	
	ADMIN("ADMIN", "Administrador"),
	USER("USER", "Usuário Padrão"),
	CADASTRO_ACESSAR("CADASTRO_ACESSAR", "Cadastro - Acessar"),
	FINANCEIRO_ACESSAR("FINANCEIRO_ACESSAR", "Fianceiro - Acessar"),
	MENSAGEM_ACESSAR("MENSAGEM_ACESSAR", "Mensagem recebida - Acessar"),
	
	BAIRRO_ACESSAR("BAIRRO_ACESSAR", "Bairro - Acessar"),
	BAIRRO_NOVO("BAIRRO_NOVO", "Bairro - Novo"),
	BAIRRO_EDITAR("BAIRRO_EDITAR", "Bairro - Editar"),
	BAIRRO_EXCLUIR("BAIRRO_EXCLUIR", "Bairro - Excluir");
	
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
	
}
