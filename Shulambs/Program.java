import java.util.Random;

public class Program {

	private static int[] GerarArray(int size, int tipo)
	{
		int[] vetor = new int[size];
		if(tipo == 1)
		{
			// crescente
			for(int i = 0; i < size; i++)
			{
				vetor[i] = i;
			}
		}
		else
		{
			// descrescente
			int aux = 0;
			for(int i = vetor.length - 1; i > 0; i--)
			{
				vetor[aux] = i;
				aux++;
			}
		}
		
		
		return vetor;
	}
	
	private static int[] GerarArrayRandom(int size, int max)
	{
		int[] vetor = new int[size];
		
		for(int i = 0; i < vetor.length; i++)
		{
			Random rand = new Random(System.nanoTime());
			int value = rand.nextInt(max);
			
			vetor[i] = value;
			//System.out.println(value);
		}
		
		return vetor;
	}
	
	
	private static void PrintArray(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args) 
	{
		
		
		// parte 1
		int arraySize = 10;
		int[] vetorA = GerarArray(arraySize, 1);
		int[] vetorB = GerarArray(arraySize, 2);
		int[] vetorC = GerarArrayRandom(arraySize, 100);
		
		System.out.println("VetorA");
		PrintArray(vetorA);
		
		System.out.println("VetorB");
		PrintArray(vetorB);
		
		System.out.println("VetorC");
		PrintArray(vetorC);
		
		Clock c = new Clock();
		c.Start();
		ArvoreBin binTree = new ArvoreBin();
		binTree.put(0, 5);
		binTree.put(1, 8);
		binTree.put(2, 1);
		binTree.put(3, 4);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Tempo decorrido: " + c.TimeElepsedMillis() + " milliseconds.");
		c.Reset();
		
				
		//binTree.imprimeABP(1);
		//System.out.println(binTree.toString());
		
		c.Start();
		System.out.println("Arvore avl!!!!!\n");
	
		AVLTree<Integer> model = new AVLTree<Integer>();
		model.add(10);
		model.add(5);
		model.add(3);
		
		try {
			Thread.sleep(502);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Tempo decorrido: " + c.TimeElepsed() + " milliseconds.");

		System.out.println(model.size());
	}

}
