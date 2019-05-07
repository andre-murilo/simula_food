package simula_food;

public class Sorvete extends Produto {

	@Override
	public float getPreco() {
		return 2.50f;
	}

	@Override
	public int getTempoPreparo() {
		return 1 * 1000; // 1 minuto
	}

	@Override
	public TipoProduto GetTipo() {
		return TipoProduto.Sobremesa;
	}
	
	@Override
	public String toString()
	{
		return "Sorverte";
	}

}
