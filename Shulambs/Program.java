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
		int[] a0 = GerarArray(100000, 1); // crescente
		int[] a1 = GerarArray(100000, 2); // decrescente
		int[] a2 = GerarArrayRandom(100000, 1000); // valores maximos: 1000
		
		// vetor 2
		int[] b0 = GerarArray(100000, 1); // crescente
		int[] b1 = GerarArray(100000, 2); // descrescente
		int[] b2 = GerarArrayRandom(100000, 1000); // valores maximos: 1000
		
		// clock
		Clock clock = new Clock();
		Clock clock2 = new Clock();
		
		
		// **************** PARTE 1 **************** 
		
		Boolean isNeedInsertABP = false;
		Boolean isNeedSearchABP = false;
		
		Boolean isNeedInsertAVL = false;
		Boolean isNeedSearchAVL = false;
		
		Boolean verbose = false;
		Boolean debug = false;
		
		
		
		
		if(isNeedInsertABP) {
			clock.Start();
			
			long ElapsedAbpInsert1 = 0;
			long ElapsedAbpInsert2 = 0;
			long ElapsedAbpInsert3 = 0;
		
			int contador = 0;
			
			
			// vetor 1
			if(debug)
				System.out.println("[Insercao ABP] Inserindo elementos no vetor 1!");
			clock2.Start();
			for(int i = 0; i < a0.length; i++) {
				if(verbose) {
					if(contador >= 10000) {
						System.out.println("Elementos inseridos: " + i + "	| 	Tempo total decorrido: " + clock2.TimeElepsedMillis() + " milissegundos!");
						contador = 0;
					}
				}
				abp.insertIterative(a0[i]);
				contador++;
			}
			ElapsedAbpInsert1 = clock.TimeElepsedMillis();
			clock.Reset();
			clock2.Reset();
			System.out.println("\n[Tempo de Inserção] ABP Vetor1: " + ElapsedAbpInsert1 + " millisegundos\n");
			
			// procurar na arvore
			if(isNeedSearchABP) {
				if(debug)
					System.out.println("[Pesquisa ABP] Pesquisando elementos no vetor 1!");
				
				clock.Start();
				for(int i = 0; i < a0.length; i++)
				{
					abp.achou(i);
				}
				
				System.out.println("\n[Tempo de Busca] ABP Vetor1: " + clock.TimeElepsedMillis() + " milissegundos!\n");
				
				clock.Reset();
			}
			
			abp.clear();
			contador = 0;
			
			
			// vetor 2
			if(debug)
				System.out.println("[Insercao ABP] Inserindo elementos no vetor 2!");
			clock.Start();
			clock2.Start();
			for(int i = 0; i < a1.length; i++)
			{
				if(verbose) {
					if(contador >= 10000) {
						System.out.println("Elementos inseridos: " + i + "	| 	Tempo total decorrido: " + clock2.TimeElepsedMillis() + " milissegundos!");
						contador = 0;
					}
				}
				
				abp.insertIterative(a1[i]);
				contador++;
			}
				
			ElapsedAbpInsert2 = clock.TimeElepsedMillis();
			clock.Reset();
			clock2.Reset();
			System.out.println("\n[Tempo de Inserção] ABP Vetor2: " + ElapsedAbpInsert2 + " millisegundos\n");
			
			// procurar na arvore
			if(isNeedSearchABP) {
				if(debug)
					System.out.println("[Pesquisa ABP] Pesquisando elementos no vetor 2!");
				
				clock.Start();
				for(int i = 0; i < a1.length; i++)
				{
					abp.achou(i);
				}
				
				System.out.println("\n[Tempo de Busca] ABP Vetor2: " + clock.TimeElepsedMillis() + " milissegundos!\n");
				
				clock.Reset();
			}
			abp.clear();
			contador = 0;
			
			// vetor 3
			if(debug)
				System.out.println("[Insercao ABP] Inserindo elementos no vetor 3!");
			clock.Start();
			clock2.Start();
			for(int i = 0; i < a2.length; i++) {
				if(verbose) {
					if(contador >= 10000) {
						System.out.println("Elementos inseridos: " + i + "	| 	Tempo total decorrido: " + clock2.TimeElepsedMillis() + " milissegundos!");
						contador = 0;
					}
				}
				
				abp.insertIterative(a2[i]);
				contador++;
			}
				
			ElapsedAbpInsert3 = clock.TimeElepsedMillis();
			clock.Reset();
			clock2.Reset();
			System.out.println("\n[Tempo de Inserção] ABP Vetor3: " + ElapsedAbpInsert3 + " millisegundos\n");
			// procurar na arvore
			if(isNeedSearchABP) {
				if(debug)
					System.out.println("[Pesquisa ABP] Pesquisando elementos no vetor 3!");
				
				clock.Start();
				for(int i = 0; i < a2.length; i++)
				{
					abp.achou(i);
				}
				
				System.out.println("\n[Tempo de Busca] ABP Vetor3: " + clock.TimeElepsedMillis() + " milissegundos!\n");
				
				clock.Reset();
			}
			
			abp.clear();
			contador = 0;
		}
		
		
	
		
		// ************* ARVORE AVL ***********
		if(isNeedInsertAVL) {
			long elapsedAvlInsert1 = 0;
			long elapsedAvlInsert2 = 0;
			long elapsedAvlInsert3 = 0;
			
			int contador = 0;
			
			// vetor 1
			if(debug)
				System.out.println("[Insercao AVL] Inserindo elementos no vetor 1!");
			clock.Start();
			clock2.Start();
			for(int i = 0; i < a0.length; i++) {
				if(verbose) {
					if(contador >= 10000) {
						System.out.println("Elementos inseridos: " + i + "	| 	Tempo total decorrido: " + clock2.TimeElepsedMillis() + " milissegundos!");
						contador = 0;
					}
				}
				
				avl.add(a0[i]);
				contador++;
			}
			elapsedAvlInsert1 = clock.TimeElepsedMillis();
			clock.Reset();
			clock2.Reset();
			System.out.println("\nInserção AVL Vetor1: " + elapsedAvlInsert1 + "\n");
			// busca na arvore
			if(isNeedSearchAVL) {
				if(debug)
					System.out.println("[Pesquisa AVL] Pesquisando elementos no vetor 1!");
				
				clock.Start();
				for(int i = 0; i < a0.length; i++)
				{
					avl.contains(i);
				}
				
				System.out.println("\n[Tempo de Busca] AVL Vetor1: " + clock.TimeElepsedMillis() + " milissegundos!\n");
				
				clock.Reset();
			}
			
			avl.clear();
			contador = 0;
			
			// vetor 2
			if(debug)
				System.out.println("[Insercao AVL] Inserindo elementos no vetor 2!");
			clock.Start();
			clock2.Start();
			for(int i = 0; i < a1.length; i++) {
				if(verbose) {
					if(contador >= 10000) {
						System.out.println("Elementos inseridos: " + i + "	| 	Tempo total decorrido: " + clock2.TimeElepsedMillis() + " milissegundos!");
						contador = 0;
					}
				}
				
				avl.add(a1[i]);
				contador++;
			}
			elapsedAvlInsert2 = clock.TimeElepsedMillis();
			clock.Reset();
			clock2.Reset();
			System.out.println("\nInserção AVL Vetor2: " + elapsedAvlInsert2 + "\n");
			// busca na arvore
			if(isNeedSearchAVL) {
				if(debug)
					System.out.println("[Pesquisa AVL] Pesquisando elementos no vetor 2!");
				
				clock.Start();
				for(int i = 0; i < a1.length; i++)
				{
					avl.contains(i);
				}
				
				System.out.println("\n[Tempo de Busca] AVL Vetor2: " + clock.TimeElepsedMillis() + " milissegundos!\n");
				
				clock.Reset();
			}
			avl.clear();
			contador = 0;
			
			// vetor 3
			if(debug)
				System.out.println("[Insercao AVL] Inserindo elementos no vetor 2!");
			clock.Start();
			clock2.Start();
			for(int i = 0; i < a2.length; i++) {
				if(verbose) {
					if(contador >= 10000) {
						System.out.println("Elementos inseridos: " + i + "	| 	Tempo total decorrido: " + clock2.TimeElepsedMillis() + " milissegundos!");
						contador = 0;
					}
				}
				
				avl.add(a2[i]);
				contador++;
			}
			elapsedAvlInsert3 = clock.TimeElepsedMillis();
			clock.Reset();
			clock2.Reset();
			System.out.println("\nInserção AVL Vetor3: " + elapsedAvlInsert3 + "\n");
			// busca na arvore
			if(isNeedSearchAVL) {
				if(debug)
					System.out.println("[Pesquisa AVL] Pesquisando elementos no vetor 3!");
				
				clock.Start();
				for(int i = 0; i < a2.length; i++)
				{
					avl.contains(i);
				}
				
				System.out.println("\n[Tempo de Busca] AVL Vetor3: " + clock.TimeElepsedMillis() + " milissegundos!\n");
				
				clock.Reset();
			}
			avl.clear();
			contador = 0;
		}
		
		
		// **************** PARTE 2 **************** 
		clock.Reset();
		
		long elapsedBubbleSort1Vetor1 = 0;
		long elapsedBubbleSort1Vetor2 = 0;
		long elapsedBubbleSort1Vetor3 = 0;
		
		long elapsedBubbleSort2Vetor1 = 0;
		long elapsedBubbleSort2Vetor2 = 0;
		long elapsedBubbleSort2Vetor3 = 0;
		
		long elapsedBubbleSort3Vetor1 = 0;
		long elapsedBubbleSort3Vetor2 = 0;
		long elapsedBubbleSort3Vetor3 = 0;
		
		long elapsedBubbleSort4Vetor1 = 0;
		long elapsedBubbleSort4Vetor2 = 0;
		long elapsedBubbleSort4Vetor3 = 0;
		
		long elapsedInsercaoVetor1 = 0;
		long elapsedInsercaoVetor2 = 0;
		long elapsedInsercaoVetor3 = 0;
		
		long elapsedSelecaoVetor1 = 0;
		long elapsedSelecaoVetor2 = 0;
		long elapsedSelecaoVetor3 = 0;
		
		long elapsedMergeSortVetor1 = 0;
		long elapsedMergeSortVetor2 = 0;
		long elapsedMergeSortVetor3 = 0;
		
		long elapsedShellSortVetor1 = 0;
		long elapsedShellSortVetor2 = 0;
		long elapsedShellSortVetor3 = 0;
	
		long elapsedQuickSortVetor1 = 0;
		long elapsedQuickSortVetor2 = 0;
		long elapsedQuickSortVetor3 = 0;
		
		// bubble sort classico
		clock.Start();
		Sort.BBSortClassico(b0.clone());
		elapsedBubbleSort1Vetor1 = clock.TimeElepsedMillis();
		System.out.println("[Bubble Sort classico] Crescente: " + elapsedBubbleSort1Vetor1 + " milissegundos!");
		
		clock.Start();
		Sort.BBSortClassico(b1.clone());
		elapsedBubbleSort1Vetor2 = clock.TimeElepsedMillis();
		System.out.println("[Bubble Sort classico] Decrescente: " + elapsedBubbleSort1Vetor2 + " milissegundos!");
		
		clock.Start();
		Sort.BBSortClassico(b2.clone());
		elapsedBubbleSort1Vetor3 = clock.TimeElepsedMillis();
		System.out.println("[Bubble Sort classico] Random: " + elapsedBubbleSort1Vetor3 + " milissegundos!");
		
		System.out.println();
		
		// bubble sort adapt1
		clock.Start();
		Sort.BBSortAdap1(b0.clone());
		elapsedBubbleSort2Vetor1 = clock.TimeElepsedMillis();
		System.out.println("[Bubble Sort Adapt1] Crescente: " + elapsedBubbleSort2Vetor1 + " milissegundos!");
		
		clock.Start();
		Sort.BBSortAdap1(b1.clone());
		elapsedBubbleSort2Vetor2 = clock.TimeElepsedMillis();
		System.out.println("[Bubble Sort Adapt1] Decrescente: " + elapsedBubbleSort2Vetor2 + " milissegundos!");
		
		clock.Start();
		Sort.BBSortAdap1(b2.clone());
		elapsedBubbleSort2Vetor3 = clock.TimeElepsedMillis();
		System.out.println("[Bubble Sort Adapt1] Random: " + elapsedBubbleSort2Vetor3 + " milissegundos!");
		
		System.out.println();
		
		// bubble sort adapt2
		clock.Start();
		Sort.BBSortAdap2(b0.clone());
		elapsedBubbleSort3Vetor1 = clock.TimeElepsedMillis();
		System.out.println("[Bubble Sort Adapt2] Crescente: " + elapsedBubbleSort3Vetor1 + " milissegundos!");
		
		clock.Start();
		Sort.BBSortAdap2(b1.clone());
		elapsedBubbleSort3Vetor2 = clock.TimeElepsedMillis();
		System.out.println("[Bubble Sort Adapt2] Decrescente: " + elapsedBubbleSort3Vetor2 + " milissegundos!");
		
		clock.Start();
		Sort.BBSortAdap2(b2.clone());
		elapsedBubbleSort3Vetor3 = clock.TimeElepsedMillis();
		System.out.println("[Bubble Sort Adapt2] Random: " + elapsedBubbleSort3Vetor3 + " milissegundos!");
		
		System.out.println();
		
		// bubble sort adapt3
		clock.Start();
		Sort.BBSortAdap3(b0.clone());
		elapsedBubbleSort4Vetor1 = clock.TimeElepsedMillis();
		System.out.println("[Bubble Sort Hibrido] Crescente: " + elapsedBubbleSort4Vetor1 + " milissegundos!");
		
		clock.Start();
		Sort.BBSortAdap3(b1.clone());
		elapsedBubbleSort4Vetor2 = clock.TimeElepsedMillis();
		System.out.println("[Bubble Sort Hibrido] Decrescente: " + elapsedBubbleSort4Vetor2 + " milissegundos!");
		
		clock.Start();
		Sort.BBSortAdap3(b2.clone());
		elapsedBubbleSort4Vetor3 = clock.TimeElepsedMillis();
		System.out.println("[Bubble Sort Hibrido] Random: " + elapsedBubbleSort4Vetor3 + " milissegundos!");
		
		System.out.println();
		
		// insercao
		clock.Start();
		Sort.Insercao(b0.clone());
		elapsedInsercaoVetor1 = clock.TimeElepsedMillis();
		System.out.println("[Inserção] Crescente: " + elapsedInsercaoVetor1 + " milissegundos!");
		
		clock.Start();
		Sort.Insercao(b1.clone());
		elapsedInsercaoVetor2 = clock.TimeElepsedMillis();
		System.out.println("[Inserção] Decrescente: " + elapsedInsercaoVetor2 + " milissegundos!");
		
		clock.Start();
		Sort.Insercao(b2.clone());
		elapsedInsercaoVetor3 = clock.TimeElepsedMillis();
		System.out.println("[Inserção] Random: " + elapsedInsercaoVetor3 + " milissegundos!");
		
		System.out.println();
		
		// selecao
		clock.Start();
		Sort.Selecao(b0.clone());
		elapsedSelecaoVetor1 = clock.TimeElepsedMillis();
		System.out.println("[Seleção] Crescente: " + elapsedSelecaoVetor1 + " milissegundos!");
		
		clock.Start();
		Sort.Selecao(b1.clone());
		elapsedSelecaoVetor2 = clock.TimeElepsedMillis();
		System.out.println("[Seleção] Decrescente: " + elapsedSelecaoVetor2 + " milissegundos!");
		
		clock.Start();
		Sort.Selecao(b2.clone());
		elapsedSelecaoVetor3 = clock.TimeElepsedMillis();
		System.out.println("[Seleção] Random: " + elapsedSelecaoVetor3 + " milissegundos!");
		
		System.out.println();
		
		// merge sort
		clock.Start();
		Sort.mergesort(b0.clone(), 0, b0.clone().length - 1);
		elapsedMergeSortVetor1 = clock.TimeElepsedMillis();
		System.out.println("[Merge Sort] Crescente: " + elapsedMergeSortVetor1 + " milissegundos!");
		
		clock.Start();
		Sort.mergesort(b1.clone(), 0, b1.clone().length - 1);
		elapsedMergeSortVetor2 = clock.TimeElepsedMillis();
		System.out.println("[Merge Sort] Decrescente: " + elapsedMergeSortVetor2 + " milissegundos!");
		
		clock.Start();
		Sort.mergesort(b2.clone(), 0, b2.clone().length - 1);
		elapsedMergeSortVetor3 = clock.TimeElepsedMillis();
		System.out.println("[Merge Sort] Random: " + elapsedMergeSortVetor3 + " milissegundos!");
		
		System.out.println();
		
		// shell sort
		clock.Start();
		Sort.shellSort(b0.clone());
		elapsedShellSortVetor1 = clock.TimeElepsedMillis();
		System.out.println("[Shell Sort] Crescente: " + elapsedShellSortVetor1 + " milissegundos!");
		
		clock.Start();
		Sort.shellSort(b1.clone());
		elapsedShellSortVetor2 = clock.TimeElepsedMillis();
		System.out.println("[Shell Sort] Decrescente: " + elapsedShellSortVetor2 + " milissegundos!");
		
		clock.Start();
		Sort.shellSort(b2.clone());
		elapsedShellSortVetor3 = clock.TimeElepsedMillis();
		System.out.println("[Shell Sort] Random: " + elapsedShellSortVetor3 + " milissegundos!");
		
		System.out.println();
		
		// quick sort
		clock.Start();
		Sort.quicksort(b0.clone(), 0, b0.clone().length - 1);
		elapsedQuickSortVetor1 = clock.TimeElepsedMillis();
		System.out.println("[Quick Sort] Crescente: " + elapsedQuickSortVetor1 + " milissegundos!");
		
		clock.Start();
		Sort.quicksort(b1.clone(), 0, b1.clone().length - 1);
		elapsedQuickSortVetor2 = clock.TimeElepsedMillis();
		System.out.println("[Quick Sort] Decrescente: " + elapsedQuickSortVetor2 + " milissegundos!");
		
		clock.Start();
		Sort.quicksort(b1.clone(), 0, b1.clone().length - 1);
		elapsedQuickSortVetor3 = clock.TimeElepsedMillis();
		System.out.println("[Quick Sort] Random: " + elapsedQuickSortVetor3 + " milissegundos!");
		
		
		
		
		
		
	}

}
