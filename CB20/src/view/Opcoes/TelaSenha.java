package view.Opcoes;

public enum TelaSenha {
	APP("APP"),
	CONTA("CONTA");
	
	private String descricao;
	
	TelaSenha(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
