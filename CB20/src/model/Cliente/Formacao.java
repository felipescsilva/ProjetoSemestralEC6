package model.Cliente;

public enum Formacao {
	Sem_Escolaridade(1), Fundamental_Incompleto(2), Fundamental_Completo(3), Medio_Incompleto(4), 
	Medio_Completo(5), Superior_Incompleto(6), Superior_Completo(7);
	
	private int descricao;
	
	Formacao(int descricao){
		this.descricao = descricao;
	}
	
	public int getDescricao() {
		return descricao;
	}
	
}
