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
	
	
	private static void PrintArray(int[] arr, int len)
	{
		for(int i = 0; i < len; i++)
		{
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args) 
	{
		// arvores
		ArvoreBin abp = new ArvoreBin();
		AVLTree<Integer> avl = new AVLTree<Integer>();
		
		// vetor 1
		int[] a0 = GerarArray(100000, 1);
		int[] a1 = GerarArray(100000, 2);
		int[] a2 = GerarArrayRandom(100000, 1000);
		
		// vetor 2
		int[] b0 = GerarArray(100000, 1);
		int[] b1 = GerarArray(100000, 2);
		int[] b2 = GerarArray(10000, 1000);
		
		// clock
		Clock clock = new Clock();
		
		
		// **************** PARTE 1 **************** 
		
		// * Insercao abp
		long nanoElapsedAbpInsert1 = 0;
		long nanoElapsedAbpInsert2 = 0;
		long nanoElapsedAbpInsert3 = 0;
		
		// vetor 1
		clock.Start();
		for(int i = 0; i < a0.length; i++)
			abp.put(i, a0[i]);
		nanoElapsedAbpInsert1 = clock.TimeElepsedMillis();
		clock.Reset();
		System.out.println("Inserção ABP Vetor1: " + nanoElapsedAbpInsert1);
		
		// vetor 2
		clock.Start();
		for(int i = 0; i < a1.length; i++)
			abp.put(i, a1[i]);
		nanoElapsedAbpInsert2 = clock.TimeElepsedMillis();
		clock.Reset();
		System.out.println("Inserção ABP Vetor2: " + nanoElapsedAbpInsert2);
		
		// vetor 3
		clock.Start();
		for(int i = 0; i < a2.length; i++)
			abp.put(i, a2[i]);
		nanoElapsedAbpInsert3 = clock.TimeElepsedMillis();
		clock.Reset();
		System.out.println("Inserção ABP Vetor3: " + nanoElapsedAbpInsert3);
		
		
		
	
		AVLTree<Integer> model = new AVLTree<Integer>();
		model.add(10);
		model.add(5);
		model.add(3);
	
		
	}

}
