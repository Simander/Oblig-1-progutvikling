package bileier;

import java.io.Serializable;

import bil.Bil;
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
	//Method for finding a owner based on personalnumber/businessnumber
	public Bileier find1( int usNum )
	{
			
		Bileier runner = first;
		if(runner instanceof Person )
			
		if (runner != null)
		{
			if(runner instanceof Person)
			{
				Person usr = (Person)runner;
				if (usr.getpNr() == usNum)
					return runner;
			}
			else if (runner instanceof Firma )
			{
				Firma usr = (Firma)runner;
				if ( usr.getbNr() == usNum)
					return runner;
			}
		}
		else
		{
			while ( runner.next != null)
			{
				if(runner.next instanceof Person)
				{
					Person usr = (Person)runner.next;
					if(usr.getpNr() == usNum)
						return usr;
				}
				else if( runner.next instanceof Firma )
				{
					Firma usr = (Firma)runner.next;
					if ( usr.getbNr() == usNum)
						return usr;
				}
				else
					runner = runner.next;
			}
		}
		return runner.next;
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
