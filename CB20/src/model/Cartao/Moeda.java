package model.Cartao;

public enum Moeda {
	REAL("real"),
	DOLAR("dolar"),
	EURO("euro");
	
	private String descricao;
	
	Moeda(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
