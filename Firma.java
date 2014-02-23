package bileier;

import java.io.Serializable;

public class Firma extends Bileier implements Serializable
{
	private static int businessNum = 0;
	private int bNr;
	public Firma(String n, String a)
	{
		super(n, a);
		businessNum += 1;
		bNr = businessNum; 
	}
	public int getbNr()
	{
		return bNr;
	}
}
