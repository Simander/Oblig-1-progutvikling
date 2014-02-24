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
	private JTextField regNr;
	private JTextField name;
	private JTextField add;
	private JButton find;
	private JButton regO;
	private JButton delO;
	private JTextArea info;
	private JCheckBox check;

	public BileierRegister()
	{
		super("Bileier register");
		uNr = new JTextField(35);
		check = new JCheckBox("", null, false);
		//check = new JCheckBox("Person", null, false);
		regNr = new JTextField(30); 
		name = new JTextField(30);
		add = new JTextField(27);
		find = new JButton("finn");
		regO = new JButton("Registrer ny eier");
		delO = new JButton("Slett eier");
		info = new JTextArea(18, 32);
		//Opretter et content pane
		Container c = getContentPane();
		c.setLayout( new FlowLayout() );
		//Legger elementer til ContentPane
		c.add(new JLabel( "Personnummer/Kryss av hvis foretaksnummer"));
		c.add(check);
		c.add(uNr);
		c.add(new JLabel( "RegNr:" ));
		c.add(regNr);
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
	private void insertCarOwner()
	{
		int num = Integer.parseInt(uNr.getText());
		Bileier usr;
		String n = name.getText();
		String a = add.getText();
		if(carOwner.find1(num) == null)
		{
			if (check.isSelected()==false)
			{
				usr = new Person(n, a, num);
				carOwner.insertBileier(usr);
				JOptionPane.showMessageDialog(null, "ny eier, type person er registrert!");
			}
			else
				usr = new Firma(n, a, num);
				carOwner.insertBileier(usr);
		}		JOptionPane.showMessageDialog(null, "ny eier, type firma er registrert!");
		if (carOwner.find1(num) != null)
				JOptionPane.showMessageDialog(null, "eieren er allerede registrert!");
	}
	private void showErrorMsg(String message)
	  {
	    JOptionPane.showMessageDialog(this, message, 
	            "Problem", JOptionPane.ERROR_MESSAGE);
	  }
	//method for reading serialized objects from file
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
	//method for writing serialized data to file
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
		        carOwner.findOwner(regNr.getText());
		    }
			else if ( e.getSource() == regO )
			{
				insertCarOwner();
			}
			else if ( e.getSource() == delO )
			{

			}
	    }
	}


}
