package model.Cartao;

public enum Tipo {
	DEBITO("debito"),
	CREDITO("credito"),
	PRE_PAGO("pre_pago");
	
	private String descricao;
	
	Tipo(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
