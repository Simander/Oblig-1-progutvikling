package bileier;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BileierRegister extends JFrame
{
	Bileierliste carOwner;
	private Commandlistener lytter;
	private JTextField uNr;
	private JTextField name;
	private JTextField add;
	private JButton find;
	private JButton regO;
	private JButton delO;
	private JTextArea info;
	
	public BileierRegister()
	{
		super("Bileier register");
		uNr = new JTextField(25);
		name = new JTextField(25);
		add = new JTextField(25);
		find = new JButton("finn");
		regO = new JButton("Registrer ny neier");
		delO = new JButton("Slett eier");
		
		//Opretter et content pane
		Container c = getContentPane();
		c.setLayout( new FlowLayout() );
		//Legger elementer til ContentPane
		c.add(new JLabel( "Personnummer/Foretaksnummer:"));
		c.add(uNr);
		c.add(new JLabel( "Navn: "));
		c.add(name);
		c.add(new JLabel( "Addresse: "));
		c.add(add);
		c.add(find);
		c.add(regO);
		c.add(delO);
		c.add( new JScrollPane(info));
		info.setEditable( false );
		readFile();
		uNr.addActionListener(lytter);
		name.addActionListener(lytter);
		add.addActionListener(lytter);
		find.addActionListener(lytter);
		regO.addActionListener(lytter);
		delO.addActionListener(lytter);
	}
	private void showErrorMsg(String message)
	  {
	    JOptionPane.showMessageDialog(this, message, 
	            "Problem", JOptionPane.ERROR_MESSAGE);
	  }
	private void readFile()
	{
		try (ObjectInputStream inFile = new ObjectInputStream(
	            new FileInputStream( "src/savefile.data" )))
	    {
	      carOwner = (Bileierliste) inFile.readObject();
	    }
	    catch(ClassNotFoundException cnfe)
	    {
	      info.setText(cnfe.getMessage());
	      info.append("\nOppretter tom liste.\n");
	      carOwner = new Bileierliste();
	    }
	    catch(FileNotFoundException fne)
	    {
	      info.setText("Finner ikke datafil. Oppretter tom liste.\n");
	      carOwner = new Bileierliste();
	    }
	    catch(IOException ioe)
	    {
	      info.setText("Innlesingsfeil. Oppretter tom liste.\n");
	      carOwner = new Bileierliste();
	    }
	  }
	public void writeToFile()
	{
		try (ObjectOutputStream outFile = new ObjectOutputStream(
				new FileOutputStream("src/savefile.data")))
		{
			outFile.writeObject(carOwner);
		}
		catch( NotSerializableException nse )
		{
			showErrorMsg("Objektet er ikke serialisert!");
		}
		catch( IOException ioe )
		{
			showErrorMsg("Problem med utskrift til fil!");
		}
	}
	
	private class Commandlistener implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
	    {
			if ( e.getSource() == find )
		    {
		        
		    }
			else if ( e.getSource() == regO )
			{
				
			}
			else if ( e.getSource() == delO )
			{
				
			}
	    }
	}
	  
	
}
