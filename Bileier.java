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
		
}
