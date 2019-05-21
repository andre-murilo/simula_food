
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
		// Versão híbrida. Combinar as adaptações 1 e 2.
	}

	public static void Selecao(int[] vetor) {
		int i, j, min, aux;
		for (i = 0; i < vetor.length - 1; i++) {
			// Procura o menor elemento a partir
			// da i-ésima posição do vetor. min = i
			// pois consideraremos no início que o
			// i-ésimo elemento é o menor do subvetor
			min = i;
			for (j = i + 1; j < vetor.length; j++)
				if (vetor[j] < vetor[min])
					min = j;
			// Troca o menor elemento de posição com
			// o elemento da posição i
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
			// menor que v (pivô)
			while (v < a[--j]) // varre o vetor dir -> esq procurando um
								// elemento
				if (j == l)
					break; // menor que v (pivô)
			if (i >= j)
				break; // verifica se os índices i(esq) e j(dir) se cruzaram
			temp = a[i];
			a[i] = a[j]; // troca a posição
			a[j] = temp;
		}
		temp = a[i];
		a[i] = a[r]; // troca a posição do pivô
		a[r] = temp;
		return i; // retorna o índice do pivô, o qual sabemos que está
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
