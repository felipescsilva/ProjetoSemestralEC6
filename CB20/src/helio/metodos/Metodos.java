package helio.metodos;

public class Metodos {
	
	public double juros(double valorIni, int taxa, int meses) {
		return valorIni * Math.pow(((100 + taxa) / 100), meses);		
	}
	
	public double juros(double valorIni, int taxa, int dias, int multa) {
		return (valorIni * ((100 + multa) / 100)) * Math.pow(((100 + taxa) / 100), dias);
		
	}
	
}
