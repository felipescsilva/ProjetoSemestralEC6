package model.Cliente;

public enum Formacao {
	FUNDAMENTAL("fundamental"),
	MEDIO("medio"),
	SUPERIOR("superior");
	
	private String descricao;
	
	Formacao(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
