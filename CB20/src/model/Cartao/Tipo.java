package model.Cartao;

public enum Tipo {
	D�BITO("D�bito"),
	CR�DITO("Cr�dito"),
	PR�_PAGO("Pr�_Pago");
	
	private String descricao;
	
	Tipo(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
