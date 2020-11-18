package model.Cambio;

public class Cotacao {
	private static float dolar = 5;
	private static float real = 1;
	
	public static float getDolar()
	{
		return dolar;
	}
	public static float getReal()
	{
		return real;
	}

	public static float converter(float valor, Moeda moedaOriginal, Moeda moedaFinal)
	{
		if(moedaOriginal == Moeda.Real && moedaFinal == Moeda.Dolar)
		{
			return valor / Cotacao.getDolar();
		}
		else if(moedaOriginal == Moeda.Dolar && moedaFinal == Moeda.Real)
		{
			return valor * Cotacao.getDolar();
		}
		else
		{
			return 0;
		}
	}
}
