
public class Sort {

	public Sort() {

	}

	
	// --------------------------------------------- Bubble SORT ----------------------------------------------
	
	public static void BBSortClassico(int[] vetor) {
		int i, j, temp;
		for (i = 0; i < vetor.length - 1; i++)
			for (j = 0; j < vetor.length - 1; j++)
				if (vetor[j] > vetor[j + 1]) {
					temp = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = temp;
				}
	}

	public static void BBSortAdap1(int[] vetor) {
		int i, temp;
		Boolean HouveTroca = true;
		while (HouveTroca) {
			HouveTroca = false;
			for (i = 0; i < vetor.length - 1; i++)
				if (vetor[i] > vetor[i + 1]) {
					temp = vetor[i];
					vetor[i] = vetor[i + 1];
					vetor[i + 1] = temp;
					HouveTroca = true;
				}
		}
	}

	public static void BBSortAdap2(int[] vetor) {
		int i, j, temp, cont;
		cont = vetor.length - 1;
		for (i = 0; i < vetor.length - 1; i++) {
			for (j = 0; j < cont; j++)
				if (vetor[j] > vetor[j + 1]) {
					temp = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = temp;
				}
			cont--;
		}
	}

	public static void BBSortAdap3(int[] vetor) {
		// Vers�o h�brida. Combinar as adapta��es 1 e 2.
	}

	public static void Selecao(int[] vetor) {
		int i, j, min, aux;
		for (i = 0; i < vetor.length - 1; i++) {
			// Procura o menor elemento a partir
			// da i-�sima posi��o do vetor. min = i
			// pois consideraremos no in�cio que o
			// i-�simo elemento � o menor do subvetor
			min = i;
			for (j = i + 1; j < vetor.length; j++)
				if (vetor[j] < vetor[min])
					min = j;
			// Troca o menor elemento de posi��o com
			// o elemento da posi��o i
			aux = vetor[min];
			vetor[min] = vetor[i];
			vetor[i] = aux;
		}
	}

	public static void Insercao(int[] vetor) {
		int i, j, v;
		for (i = 1; i < vetor.length; i++) {
			v = vetor[i];
			j = i;
			while ((j > 0) && (vetor[j - 1] > v)) {
				vetor[j] = vetor[j - 1];
				j--;
			}
			vetor[j] = v;
		}
	}
	
	
	// --------------------------------------------- MERGE SORT ----------------------------------------------
	
	
	// --------------------------------------------- SHELL SORT ----------------------------------------------
	
	
	
	// --------------------------------------------- QUICK SORT ----------------------------------------------
	private static int particao(int a[], int l, int r) {
		int i = l - 1, j = r;
		int v = a[r], temp;
		for (;;) {
			while (a[++i] < v)
				; // varre o vetor esq -> dir procurando um elemento
			// menor que v (piv�)
			while (v < a[--j]) // varre o vetor dir -> esq procurando um
								// elemento
				if (j == l)
					break; // menor que v (piv�)
			if (i >= j)
				break; // verifica se os �ndices i(esq) e j(dir) se cruzaram
			temp = a[i];
			a[i] = a[j]; // troca a posi��o
			a[j] = temp;
		}
		temp = a[i];
		a[i] = a[r]; // troca a posi��o do piv�
		a[r] = temp;
		return i; // retorna o �ndice do piv�, o qual sabemos que est�
		// no lugar correto
	}
	
	public static void quicksort(int a[], int l, int r) {
		if (r <= l)
			return;
		int i = particao(a, l, r);
		quicksort(a, l, i - 1);
		quicksort(a, i + 1, r);
	}
}
