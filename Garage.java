package bil;
//viktige importsetninger
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;

public class Garage extends JFrame implements ActionListener
{
	//Oppretter datafelter
	Billiste carList;
	private JTextField regNr;
	private JTextField brand;
	private JTextField model;
	private JButton reg;
	private JButton find;
	private JButton del;
	private JButton check;
	private JButton om;
	private JTextArea info;
		
	//Constructor
	public Garage(Billiste b)
	{
			super("Bilregister!");
			//tilegner variabler verdier
			carList = b;
			regNr = new JTextField( 25 );
			brand = new JTextField( 25 );
			model = new JTextField( 25 );
			find = new JButton( "Finn" );
			reg = new JButton( "Registrer bil" );
			del = new JButton( "Slett!" );
			check = new JButton( "check" );
			om = new JButton( "List biler" );
			info = new JTextArea( 25, 30);
			//Opretter et content pane
			Container c = getContentPane();
			c.setLayout( new FlowLayout() );
			//Legger elementer til ContentPane
			c.add(new JLabel( "RegNr:"));
			c.add(regNr);
			c.add(new JLabel( "Merke: "));
			c.add(brand);
			c.add(new JLabel( "Modell: "));
			c.add(model);
			c.add(find);
			c.add(reg);
			c.add(del);
			c.add(check);
			c.add(om);
			c.add( new JScrollPane(info));
			info.setEditable( false );
			
			//knytter lyttere til knapper
			find.addActionListener( this );
			reg.addActionListener( this );
			del.addActionListener( this );
			check.addActionListener( this );
			om.addActionListener( this );
	
			
	}
	
	private void iCar()
	{
		String rNum = regNr.getText();
		String b = brand.getText();
		String m = model.getText();
		Calendar d = Calendar.getInstance();
		Bil neues = new Bil(rNum, b, m, d);
		carList.insertCar(neues);
	}
	private void findCar()
	{
		Bil car = carList.findCar(regNr.getText());
		if (car!= null)
			info.setText(car.toString());
		else if(car == null)
			info.setText("Bilen finnes ikke i registeret!");
	}
	
	public void actionPerformed( ActionEvent e )
	{
		if( e.getSource() == find)
		{
			findCar();
		}
		else if( e.getSource() == del)
		{
			carList.delCar(regNr.getText());
		}
		else if( e.getSource() == reg )
		{
			iCar();
		}
		else if( e.getSource() == check )
		{
			info.setText(carList.numEntries());
		}
		else if ( e.getSource() == om )
		{
			info.setText(carList.listEntries());
		}	
	}
}
