package model.Cambio;

public enum Moeda {
	Real("real"),
	Dolar("dolar"),
	Euro("euro");
	
	private String descricao;
	
	Moeda(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
