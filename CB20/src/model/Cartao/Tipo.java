package model.Cartao;

public enum Tipo {
	DEBITO("debito"),
	CREDITO("credito"),
	PRE_PAGO("prePago");
	
	private String descricao;
	
	Tipo(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
