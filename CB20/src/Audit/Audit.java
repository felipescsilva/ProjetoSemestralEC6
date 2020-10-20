package Audit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;

public class Audit implements Runnable{
	private static Audit instancia;
	private Thread thread;
	
	public Audit()
	{
		thread = new Thread(this);		
		thread.start();
	}
	
	public static Audit getInstancia()
	{
		if (instancia == null) instancia = new Audit();
	    return instancia;
	}
	
	public static void gerarRelatorio(String relatorio)
	{		
		new Thread() {
			@Override
			public void run() {
				File arquivo = new File("auditoria.txt");
				if (!arquivo.exists())
				{
					try {
						arquivo.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					FileWriter gravacao = new FileWriter(arquivo, true);
					gravacao.append(Instant.now().toString() + " ");
					gravacao.append(relatorio);
					gravacao.append("\n");
					gravacao.close();		
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}.start();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}