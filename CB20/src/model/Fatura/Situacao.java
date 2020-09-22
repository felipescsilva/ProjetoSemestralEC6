package model.Fatura;

public enum Situacao {
	PENDENTE("pendente"),
	PAGO("pago"),
	VENCEU("venceu");
	
	private String descricao;
	
	Situacao(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
