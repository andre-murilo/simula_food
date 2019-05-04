package simula_food;
import java.util.List;
import java.util.ArrayList;

public class Pedido {
	List<Produto> items;
	Cliente cliente;
	
	public Pedido(Cliente cliente)
	{
		this.items = new ArrayList<Produto>();
		this.cliente = cliente;
	}
	
	public void AddItem(Produto item)
	{
		items.add(item);
	}
	
	public void RemoveItem(Produto item)
	{
		items.remove(item);
	}
	
	public Produto[] GetItems()
	{
		Produto[] p = new Produto[items.size()];
		p = items.toArray(p);
		return p;
	}
	

	public float GetPrecoTotal()
	{
		float valor = 0.0f;
		for(Produto p : this.GetItems())
			valor += p.getPreco();
		
		return valor;
	}
	
	public int GetTempoTotalPreparo()
	{
		int tempo = 0;
		for(Produto p : this.GetItems())
			tempo += p.getTempoPreparo();
		
		return tempo;
	}
	
	
	public Cliente GetCliente()
	{
		return this.cliente;
	}
}

