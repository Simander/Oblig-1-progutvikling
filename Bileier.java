package bileier;
import java.io.Serializable;

import bil.Billiste;
public abstract class Bileier implements Serializable
{
	private String name;
	private String address;
	private Billiste cars;
	Bileier next;
	//constructor
	public Bileier(String n, String a)
	{
		name = n;
		address = a;
		cars = new Billiste();
		next = null;
	}
	public Billiste getCars()
	{
		return cars;
	}
	public String toString()
	{
		String print = "\nNavn: " + name + "\nAdresse: " + address + "\nBiler:\n" + cars.toString();
		return print;
	}
	public Bil getCar()
	{
		return car;
	}
	public void regNewcar( String regno, String brand, String model, Calendar regDate)
	{
	    Bil neu = new Bil( regno, brand, model, regDate );
	    neu.setBileier(this);
	    
	    if(car == null)
	    {
	        car = neu;
	    }
	    else
	    {
	        Bil helper = car;
	        while( helper.ownerNext != null ){
	            helper = helper.ownerNext;
	     }
	  helper.ownerNext = neu;
    }
}
