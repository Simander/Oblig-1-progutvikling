package bileier;

import java.io.Serializable;

import bil.Billiste;

public class Bileierliste implements Serializable
{
	private Bileier first;
	
	public Bileierliste()
	{
		first = null;
	}
	public void insertBileier( Bileier neu)
	{
		if( neu == null)
			return;
		if( first == null )
			first = neu;
		else
		{
			Bileier runner = first;
			while ( runner.next != null )
				runner = runner.next;
			runner.next = neu;
		}
	}
	//Method for finding a owner based on owned cars registration number
		public Bileier findOwner( String regNum )
		{
			Bileier runner = first;
			if (first.getCars().findCar(regNum).getRegNum() == regNum)
				return first;
			while (runner.next.getCars().findCar(regNum).getRegNum() != regNum)
			
			return runner.next;
			return runner;
		
		}
		
}
