package model.Cartao;

public interface ICartao {
	
	public void DesbloquearCartao(String senha);
	
	public void PagarDebito(double valor);
	
	public void PagarCredito(double valor);
	
	public void PagarFatura();
	
	
}
