package simula_food;

public class Program {

	public static void main(String[] args) {
		Restaurante restaurante = new Restaurante();
		
		Cliente joao = restaurante.AddCliente("Joao");
		//System.out.println("Cliente [Joao] cadastrado!");
		
		
		Pedido p = new Pedido(joao);
		p.AddItem(new Sorvete());
		p.AddItem(new Sanduiche());
		
		Pedido p2 = new Pedido(joao);
		p2.AddItem(new Refrigerante());
		p2.AddItem(new Sanduiche());
		
	
		System.out.println("Pedido [Sorvete, Sanduiche] criado!");
		System.out.println("Pedido [Refrigerante, Sanduiche] criado!");
		
		restaurante.Pedir(p);
		restaurante.Pedir(p2);
		
	}

}
