
public class Program {

	public static void main(String[] args) {
		
		
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
