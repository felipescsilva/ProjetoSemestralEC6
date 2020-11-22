package model.Cambio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Cotacao {	
	
	private static double taxa = (double) 1.04;
	
	public static double getDolar()
	{
		return apiCotacao();
	}
	public static double getReal()
	{
		String aux = String.valueOf((1 / getDolar()));
		int pontoDecimal = aux.indexOf(".");		
		return Double.valueOf((aux.substring(0, pontoDecimal + 3)));
	}
	
	public static double getDolarTaxa()
	{
		return getDolar() * taxa;
	}
	
	public static double getRealTaxa()
	{
		return getReal() * taxa;
	}

	public static double converter(double valor, Moeda moedaOriginal, Moeda moedaFinal)
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
	
	public static double converterTaxado(double valor, Moeda moedaOriginal, Moeda moedaFinal)
	{		
		if(moedaOriginal == Moeda.Real && moedaFinal == Moeda.Dolar)
		{
			return valor / Cotacao.getDolarTaxa();
		}
		else if(moedaOriginal == Moeda.Dolar && moedaFinal == Moeda.Real)
		{			
			return valor * Cotacao.getDolarTaxa();
		}
		else
		{
			return 0;
		}
	}
	
	private static double apiCotacao()
	{
		String dados = "";
		try {
			URL url = new URL("https://economia.awesomeapi.com.br/all/USD-BRL");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));

	        String line;
	        while ((line = br.readLine()) != null) {
	        	dados += line;
	        }

	        con.disconnect();       
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int posicaoDolar = dados.indexOf("high");
		
		return Double.valueOf(dados.substring(posicaoDolar + 7, posicaoDolar + 11));			
	}
	
	public static double getTaxa()
	{
		return taxa;
	}
}
