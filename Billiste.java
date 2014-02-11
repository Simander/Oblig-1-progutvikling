package bil;

public class Billiste
{
	private Bil first;
	
	public Billiste()
	{
			first = null;
	}
	//Method for inserting a Car into the list
	public void insertCar( Bil neu)
	{
		if( neu == null)
			return;
		if( first == null )
			first = neu;
		else
		{
			Bil runner = first;
			while ( runner.next != null )
				runner = runner.next;
			runner.next = neu;
		}
	}
	
}
