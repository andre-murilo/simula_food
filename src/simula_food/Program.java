package simula_food;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

public class Program {

	
	
	public static Pedido[] GerarPedidos(Cliente c, int count)
	{
		Pedido[] pedidos = new Pedido[count];
		
		for(int i = 0; i < count; i++)
		{
			pedidos[i] = new Pedido(c);
			Random rd = new Random(System.nanoTime());
			
			long value = rd.nextInt(100);
			
			//  !!! DEBUG !!!
			//System.out.println(value);
			
			
			if(value > 0 && value < 40)
			{
				pedidos[i].AddItem(new Refrigerante());
			}
			else
			{
				pedidos[i].AddItem(new Sanduiche());
			}
			
			
			pedidos[i].AddItem(new Sorvete());
		}
		
		
		return pedidos;
	}
	
	public static void main(String[] args) {
		Restaurante restaurante = new Restaurante();
		
		Cliente joao = restaurante.AddCliente("Joao");

		
		
		
		Scanner scanner = new Scanner(System.in);
		while(true)
		{
			System.out.println("Digite uma opção: ");
			System.out.println("[1] Fazer pedidos aleatorios");
			System.out.println("[2] Sair e imprimir o historico");
			
			int opt = scanner.nextInt();
			switch(opt)
			{
			case 1:
				Pedido[] pedidos = GerarPedidos(joao, 10);
				for(Pedido p : pedidos)
				{
					restaurante.Pedir(p);
				}
				break;
			case 2:
				restaurante.BeginExit();
				break;
			default:
				System.out.println("Opção invalida!");
				break;
			}
			
		}
		
	}

}
