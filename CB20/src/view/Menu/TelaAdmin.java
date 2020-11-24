package view.Menu;

public enum TelaAdmin {
	CPF("CPF"),
	NUMCONTA("NUMCONTA");
	
	private String descricao;
	
	TelaAdmin(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
