
public class Clock 
{
	long initializeTime;
	
	public Clock()
	{
		this.initializeTime = 0;
	}
	
	private long Now()
	{
		return System.nanoTime();
	}
	
	
	public void Start()
	{
		initializeTime = Now();
	}
	
	public void Reset()
	{
		initializeTime = 0;
	}
	

	public long TimeElepsed()
	{
		return Now() - initializeTime;
	}
	
	public long TimeElepsedMillis()
	{
		return (Now() - initializeTime) / 1000000;
	}

}
