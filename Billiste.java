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
		if (runner != null && runner.getRegNum().equals(regNum))
			return runner;
		else
		{
			while ( runner.next != null && !(runner.next.getRegNum().equals(regNum)))
					runner = runner.next;
		}
		return runner.next;
	}
	//Method for removing a car from the list
	public void delCar( String regNum )
	{
		
			Bil runner = first;
			if (runner != null && runner.getRegNum().equals(regNum))
				first = runner.next;
			else
			{
				while ( runner.next.getRegNum() != null && !(runner.next.getRegNum().equals(regNum)) )
				runner = runner.next;
				runner.next = runner.next.next;
			}
	}
	//method for listing number of entries in the register 
	public String numEntries()
	{
		
		String chk = "";
			Bil runner = first;
			int counter = 0;
			if(first != null)
				counter = 1;
			while ( runner.next != null)
			{		
				runner = runner.next;
				counter+=1;
			}
			chk = counter + " Biler registrert! "; 
			return chk;
	}
	//method to list all entries in the register
	public String listEntries()
	{
		Bil runner = first;
		String info = null;
		if(first != null)
		{
			info=first.toString() +"\n";
			while ( runner.next != null)
			{
				runner = runner.next;
				info += "\n" + runner.toString() +"\n";
			}
		}
		else
			info="Ingen biler i registeret!";
		return info;
	}
}

