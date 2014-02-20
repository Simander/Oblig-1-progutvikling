package bileier;

import java.io.Serializable;

public class Firma extends Bileier implements Serializable
{
	private int businessNum;
	
	public Firma(String n, String a, int bN)
	{
		super(n, a);
		businessNum = bN; 
	}
}
