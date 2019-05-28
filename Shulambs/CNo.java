
public class CNo 
{
    public int chave;
    public Object valor;
    public CNo esq, dir;

    public CNo()
    {
        valor = esq = dir = null;
    }

    public CNo(int k)
    {
        chave = k;
        valor = esq = dir = null;
    }

    public CNo(int k, Object v)
    {
        chave = k;
        valor = v;
        esq = null;
        dir = null;
    }

    public CNo(int k, Object v, CNo e, CNo d)
    {
        chave = k;
        valor = v;
        esq = e;
        dir = d;
    }
}