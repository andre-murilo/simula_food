package simula_food;
import java.util.function.Function;

public class Cozinheiro {
	int experiencia;
	Pedido ultimoPedido;
	Boolean preparando;
	long timer;
	long tempoTotalPreparo;
	
	Function <CallbackResult, Boolean> callback;

	
	public Cozinheiro(Function <CallbackResult, Boolean> callback)
	{
		experiencia = 0;
		preparando = false;
		
		this.callback = callback;
	}
	
	
	public Boolean Ocupado()
	{
		return preparando;
	}
	
	public void Preparar(Pedido pedido)
	{
		ultimoPedido = pedido;
		preparando = true;
		
		tempoTotalPreparo = pedido.GetTempoTotalPreparo();
		
		System.out.println("Preparando refeicao: " + tempoTotalPreparo + " ms.");
	}
	
	public void Proc(long delta)
	{
		if(preparando)
		{
			timer += delta;
			
			if(timer >= tempoTotalPreparo) 
			{
				// pedido preparado
				preparando = false;
				timer = 0;
				tempoTotalPreparo = 0;
				experiencia++;
	
				callback.apply(new CallbackResult(ultimoPedido));
			}
		}
	}
	
	
	
	
}
