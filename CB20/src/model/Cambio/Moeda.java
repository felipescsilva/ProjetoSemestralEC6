package model.Cambio;

	public enum Moeda	{Dolar, Real;
	
		@Override
		public String toString()
		{
			if(this.equals(Moeda.Real))
			{
				return "Real";
			}
			else if(this.equals(Moeda.Dolar))
			{
				return "Dólar";
			}
			return "";
		}
	}