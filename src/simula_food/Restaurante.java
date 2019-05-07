package simula_food;
import java.lang.Thread;

public class Restaurante {
	CLista clientes;
	Cozinha cozinha;
	public Boolean exiting;
	
	
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
		this.exiting = false;
		
		
		// create process thread
		Thread t = new Thread(proc);
		t.start();
	}
	
	public void BeginExit()
	{
		this.exiting = true;
	}
	
	
	
	
	
	private Runnable proc = new Runnable() 
	{
		public void run()
		{
			//System.out.println("Thread criada!");
			
			
			long auxTime = System.currentTimeMillis();
			long now = 0;
			long delta = 0;
			
			while(!exiting)
			{
				now = System.currentTimeMillis();
				delta = now - auxTime;
				auxTime = System.currentTimeMillis();				
				
				
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
			
			
			
			// clear console
			for (int i = 0; i < 100; ++i)  
			       System.out.println();
			
			// print all history
			for(Cozinheiro c : cozinha.GetCozinheiros())
				c.PrintHistorico();
		}
	};
}
