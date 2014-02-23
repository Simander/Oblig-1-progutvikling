package bileier;

import java.io.Serializable;

public class Person extends Bileier implements Serializable
{
	private static int personalNum = 0; 
	private int pNr;
	public Person(String n, String a)
	{
		super(n, a);
		personalNum += 1;
		pNr = personalNum;
	}
	public int getpNr()
	{
		return pNr;
	}
}
