package simula_food;
import java.util.List;
import java.util.ArrayList;

public class Cozinha {
	List<Cozinheiro> cozinheiros;
	CFila pedidos;
	
	public Cozinha()
	{
		cozinheiros = new ArrayList<Cozinheiro>();
		pedidos = new CFila();
		
		// add cozinheiros
		for(int i = 0; i < 3; i++)
		{
			AddCozinheiro(new Cozinheiro("" + i, this::ItemPreparado));
		}
		
	}
	
	
	public void AdicionarPedido(Pedido p)
	{
		pedidos.enfileira(p);
	}
	
	public Boolean PossuiPedido()
	{
		return !pedidos.vazia();
	}
	
	public Pedido PegarProximoPedido()
	{
		return (Pedido)pedidos.desenfileira();
	}
	
	// orderna os cozinheiros em grau de experiencia
	public void OrdenarCozinheiros()
	{
		
	}
	
	public void AddCozinheiro(Cozinheiro cozinheiro)
	{
		cozinheiros.add(cozinheiro);
		
		this.OrdenarCozinheiros();
	}
		
	// retorna os cozinheiros em formato de array
	public Cozinheiro[] GetCozinheiros()
	{
		Cozinheiro[] c = new Cozinheiro[cozinheiros.size()];
		c = cozinheiros.toArray(c);

		return c;
	}
		
	
	// funcao chamada quando o cozinheiro termina o preparo do pedido
	public Boolean ItemPreparado(CallbackResult result)
	{
		
		//  !!! DEBUG !!!
		//System.out.println("Pedido concluido!");
		//System.out.println(result.pedido.GetPrecoTotal());
		
		return true;
	}
	
}
