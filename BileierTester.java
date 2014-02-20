package bileier;

import java.awt.event.*;
public class BileierTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		final BileierRegister bGUI = new BileierRegister();
		bGUI.setVisible(true);
		bGUI.setSize(320, 480);
		bGUI.addWindowListener( new WindowAdapter()
		{
			public void windowClosing ( WindowEvent e)
			{ 
				bGUI.writeToFile();
				System.exit(0);
			}
		});

	}

}
