package model.Cartao;

public enum Tipo {
	DÉBITO("Débito"),
	CRÉDITO("Crédito"),
	PRÉ_PAGO("Pré_Pago");
	
	private String descricao;
	
	Tipo(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
