package model.Cliente;

public enum Profissao {
	OUTROS("outros");
	
	private String descricao;
	
	Profissao(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
