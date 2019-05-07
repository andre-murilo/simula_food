package simula_food;

public class Refrigerante extends Produto {

	@Override
	public float getPreco() {
		return 15.0f;
	}

	@Override
	public int getTempoPreparo() {
		return 2 * 1000; // 2 minutos
	}

	@Override
	public TipoProduto GetTipo() {
		return TipoProduto.Bebida;
	}
	
	
	@Override
	public String toString()
	{
		return "Refrigerante";
	}

}
