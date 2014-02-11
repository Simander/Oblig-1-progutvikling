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
	//Method for finding a car in the list by registration number
	public Bil findCar( String regNum )
	{
		Bil runner = first;
		while ( runner.next.getRegNum() != null && runner.next.getRegNum() == regNum )
			runner = runner.next;
		return runner.next;
	}
	//Method for removing a car from the list
	public void delCar( String regNum )
	{
		Bil runner = first;
		while ( runner.next.getRegNum() != null && runner.next.getRegNum() == regNum )
			runner = runner.next;
		runner.next = runner.next.next;
	}
	public int listEntries()
	{
		Bil runner = first;
		int counter = 0;
		while ( runner.next != null)
		{
			counter += 1;
			runner = runner.next;
		}
		return counter;
	}
	public String carInfo()
	{
		Bil runner = first;
		String info = null;
		while ( runner.next != null)
		{
			info += runner.toString() +"\n\n";
			runner = runner.next;
		}
		return info;
	}
}
