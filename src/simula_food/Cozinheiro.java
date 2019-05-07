package simula_food;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Cozinheiro {
	int experiencia;
	Pedido ultimoPedido;
	Boolean preparando;
	long timer;
	long tempoTotalPreparo;
	String nome;
	
	List<Pedido> historico;
	Function <CallbackResult, Boolean> callback;

	
	public Cozinheiro(String nome, Function <CallbackResult, Boolean> callback)
	{
		this.experiencia = 0;
		this.preparando = false;
		
		this.historico = new ArrayList<Pedido>();
		this.callback = callback;
		this.nome = nome;
	}
	
	
	public Boolean Ocupado()
	{
		return preparando;
	}
	
	public void Preparar(Pedido pedido)
	{
		ultimoPedido = pedido;
		preparando = true;
		
		long tempoExp = this.experiencia * 10;
		tempoTotalPreparo = pedido.GetTempoTotalPreparo() - tempoExp;
		
		// add in history list
		historico.add(pedido);
		
		//  !!! DEBUG !!!
		System.out.println("[Cozinheiro: " + nome + " ] Preparando refeicao: " + pedido.toString() + " --> Tempo: "  + tempoTotalPreparo + " ms.");
	}
	
	public void Proc(long delta)
	{
		if(preparando)
		{
			timer += delta;
			
			// se o pedido estiver pronto
			if(timer >= tempoTotalPreparo) 
			{
				// pedido preparado
				preparando = false;
				timer = 0;
				tempoTotalPreparo = 0;
				experiencia++;
	
				//  !!! DEBUG !!!
				System.out.println("[Cozinheiro: " + nome + " ] Pedido concluido!");
				
				
				callback.apply(new CallbackResult(ultimoPedido));
			}
		}
	}
	
	public void PrintHistorico()
	{
		for(Pedido p : historico)
			System.out.println("[Cozinheiro: " + nome + " ] Historico: " + p.toString() + " --> Tempo: " + p.GetTempoTotalPreparo() + " ms.");
	}
	
	
}
