package model.Cambio;

	public enum Moeda	{Dolar, Real;
	
		@Override
		public String toString()
		{
			if(this == Moeda.Real)
			{
				return "Real";
			}
			else if(this == Moeda.Dolar)
			{
				return "Dolar";
			}
			return "";
		}
	}