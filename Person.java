package bileier;

import java.io.Serializable;

public class Person extends Bileier implements Serializable
{
	private int personalNum; 
	public Person(String n, String a, int pN)
	{
		super(n, a);
		personalNum = pN;
	}
}
