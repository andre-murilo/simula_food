package simula_food;
import java.lang.Thread;

public class Restaurante {
	CLista clientes;
	Cozinha cozinha;
	
	public Cliente AddCliente(String nome)
	{
		Cliente c = new Cliente(nome);
		clientes.insereComeco(c);
		
		return c;
	}
	
	
	public void Pedir(Pedido p)
	{
		cozinha.AdicionarPedido(p);
	}
	
	
	
	
	public Restaurante()
	{
		this.clientes = new CLista();
		this.cozinha = new Cozinha();
		
		
		// create process thread
		Thread t = new Thread(proc);
		t.start();
	}
	
	
	
	
	
	private Runnable proc = new Runnable() 
	{
		public void run()
		{
			//System.out.println("Thread criada!");
			
			
			long startTime = System.currentTimeMillis();
			long now = 0;
			long delta = 0;
			
			while(true)
			{
				now = System.currentTimeMillis();
				delta = now - startTime;
				startTime = System.currentTimeMillis();				
				
				
				// processa os cozinheiros
				for(Cozinheiro c : cozinha.GetCozinheiros())
				{
					if(!c.Ocupado())
					{
						if(cozinha.PossuiPedido())
							c.Preparar(cozinha.PegarProximoPedido());
					}
					
					c.Proc(delta);
				}
				
				
				
				try
				{
					Thread.sleep(1);
				}
				catch(Exception ex)
				{
					
				}
			}
		}
	};
}
