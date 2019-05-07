package simula_food;

public class Sanduiche extends Produto {

	@Override
	public float getPreco() {
		return 15.0f;
	}

	@Override
	public int getTempoPreparo() {
		return 4 * 1000; // 4 minutos
	}

	@Override
	public TipoProduto GetTipo() {
		return TipoProduto.FastFood;
	}

	@Override
	public String toString()
	{
		return "Sanduiche";
	}
}
