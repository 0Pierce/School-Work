package EstimatedRentalRatePackage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.MenuFrame;

public class RentalRateFrame extends JFrame implements ActionListener{
	//fields
	private JPanel header = new JPanel();
	private JLabel title = new JLabel("Rental Rate");
	private JButton percentChange = new JButton("% Change/Yr");
	private JButton pricePerAcre = new JButton ("$/Acre");
	private JLabel typeData = new JLabel("Type Of Data:");
	
	
	private JLabel yearSelect = new JLabel("Select Year for data:");
	
	private JButton year1 = new JButton("1991");
	private JButton year2 = new JButton("1996");
	private JButton year3 = new JButton("2001");
	private JButton year4 = new JButton("2006");
	private JButton year5 = new JButton("2011"); 
	private JButton year6 = new JButton("2016");
	private JButton year7 = new JButton("1991-2016");
	private JLabel info = new JLabel("<html><pre>*This frame displays rent cost and it's \nchange through the years in various regions\n*Hover over the bars to display specific values<pre><html>");
	
	private String type = "";
	
	
	private percentGraph1991 percentGraph1991 = new percentGraph1991();
	private percentGraph1996 percentGraph1996 = new percentGraph1996();
	private percentGraph2001 percentGraph2001 = new percentGraph2001();
	private percentGraph2006 percentGraph2006 = new percentGraph2006();
	private percentGraph2011 percentGraph2011 = new percentGraph2011();
	private percentGraph2016 percentGraph2016 = new percentGraph2016();
	private percentGraph1991TO2016 percentGraph1991TO2016 = new percentGraph1991TO2016();
	
	
	private moneyGraph1991 moneyGraph1991 = new moneyGraph1991();
	private moneyGraph1996 moneyGraph1996 = new moneyGraph1996();
	private moneyGraph2001 moneyGraph2001 = new moneyGraph2001();
	private moneyGraph2006 moneyGraph2006 = new moneyGraph2006();
	private moneyGraph2011 moneyGraph2011 = new moneyGraph2011();
	private moneyGraph2016 moneyGraph2016 = new moneyGraph2016();
	
	private JButton reset = new JButton("RESET");
	private JMenu selectFrame = new JMenu("Change Frame:");
	private JMenuBar menuBar = new JMenuBar();
	JMenuItem TA = new JMenuItem("Total Farm Area");
	JMenuItem EVL = new JMenuItem("Estimated Value of Land");
	JMenuItem RR = new JMenuItem("Rental Rate : Land Value");
	
	public RentalRateFrame () {
		//Create frame and color
		setLayout(null);
		setTitle("Rental Rate");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,900);
		getContentPane().setBackground(new Color(203,233,254));
		setVisible(false);
		
		//menu bar to switch to other persons frame
		selectFrame.add(TA);
		selectFrame.add(EVL);
		selectFrame.add(RR);
		menuBar.add(selectFrame);
		menuBar.setBounds(0,0,120,30);
		add(menuBar);
		
		menuBar.setVisible(true);
		
		
		
		
		//Set dimensions and placement of each item
		header.setBounds(0,0,1000,200);
		title.setBounds(390,20, 300,100);
		percentChange.setBounds(200,100,100,100);
		pricePerAcre.setBounds(50,100,100,100);
		typeData.setBounds(50,50,150,50);
		yearSelect.setBounds(700,0,150,50);
		reset.setBounds(200,20,100,50);
		year1.setBounds(700,50,50,50);
		year2.setBounds(750,50,50,50);
		year3.setBounds(800,50,50,50);
		year4.setBounds(850,50,50,50);
		year5.setBounds(700,100,50,50);
		year6.setBounds(750,100,50,50);
		year7.setBounds(800,100,100,50);
		info.setBounds(350,100,400,100);
		
		//add action listener to all buttons
		percentChange.addActionListener(this);
		pricePerAcre.addActionListener(this);
		year1.addActionListener(this);
		year2.addActionListener(this);
		year3.addActionListener(this);
		year4.addActionListener(this);
		year5.addActionListener(this);
		year6.addActionListener(this);
		year7.addActionListener(this);
		reset.addActionListener(this);
		TA.addActionListener(this);
		EVL.addActionListener(this);
		RR.addActionListener(this);
		
		 
		
		//Set fonts for titles, headers, buttons, and small text
		title.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		yearSelect.setFont(new Font("Consolas", Font.BOLD, 14));
		typeData.setFont(new Font("Consolas", Font.BOLD, 18));
		info.setFont(new Font("Calibri", Font.ITALIC, 11));
		reset.setFont(new Font("Consolas", Font.BOLD, 15));
		percentChange.setFont(new Font("Consolas", Font.BOLD, 11));
		pricePerAcre.setFont(new Font("Consolas", Font.BOLD, 11));
		
		//modify header 
		header.setLayout(null);
		header.setBackground(new Color(48,213,200));
		
		
		
		
		//Add elements to header
		header.add(pricePerAcre);
		header.add(percentChange);
		header.add(title);
		header.add(typeData);
		header.add(yearSelect);
		header.add(info);
		header.add(year1);
		header.add(year2);
		header.add(year3);
		
		header.add(year4);
		header.add(year5);
		header.add(year6);
		header.add(year7);
		header.add(reset);
		
		//Add items to frame
		add(header);
		add(percentGraph1991);
		add(percentGraph1996);
		add(percentGraph2001);
		add(percentGraph2006);
		add(percentGraph2011);
		add(percentGraph2016);
		add(percentGraph1991TO2016);
		
		add(moneyGraph1991);
		add(moneyGraph1996);
		add(moneyGraph2001);
		add(moneyGraph2006);
		add(moneyGraph2011);
		add(moneyGraph2016);
		
		//set visibility of items
		yearSelect.setVisible(false);	
		year1.setVisible(false);
		year2.setVisible(false);
		year3.setVisible(false);
		year4.setVisible(false);
		year5.setVisible(false);
		year6.setVisible(false);
		year7.setVisible(false);
		percentGraph1991.setVisible(false);
		percentGraph1996.setVisible(false);
		percentGraph2001.setVisible(false);
		percentGraph2006.setVisible(false);
		percentGraph2011.setVisible(false);
		percentGraph2016.setVisible(false);
		percentGraph1991TO2016.setVisible(false);
		
		moneyGraph1991.setVisible(false);
		moneyGraph1996.setVisible(false);
		moneyGraph2001.setVisible(false);
		moneyGraph2006.setVisible(false);
		moneyGraph2011.setVisible(false);
		moneyGraph2016.setVisible(false);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if("Total Farm Area".equals(e.getActionCommand()))
		{
			setVisible(false);
			MenuFrame.FarmArea2.setVisible(true);
		}
		if("Estimated Value of Land".equals(e.getActionCommand()))
		{
			setVisible(false);
			MenuFrame.LVApplication.LVFrame.setVisible(true);
		}
		if("Rental Rate : Land Value".equals(e.getActionCommand()))
		{
			setVisible(false);
			MenuFrame.RatioFrame.setVisible(true);
		}
		
		//set visibility of items based on what buttons are clicked 
		if("RESET".equals(e.getActionCommand()))
		{
			yearSelect.setVisible(false);
			
			year1.setVisible(false);
			year2.setVisible(false);
			year3.setVisible(false);
			year4.setVisible(false);
			year5.setVisible(false);
			year6.setVisible(false);
			year7.setVisible(false);
			percentGraph1991.setVisible(false);
			percentGraph1996.setVisible(false);
			percentGraph2001.setVisible(false);
			percentGraph2006.setVisible(false);
			percentGraph2011.setVisible(false);
			percentGraph2016.setVisible(false);
			percentGraph1991TO2016.setVisible(false);
			
			moneyGraph1991.setVisible(false);
			moneyGraph1996.setVisible(false);
			moneyGraph2001.setVisible(false);
			moneyGraph2006.setVisible(false);
			moneyGraph2011.setVisible(false);
			moneyGraph2016.setVisible(false);
			type = "";
		}
		if("% Change/Yr".equals(e.getActionCommand())) {
			year1.setBounds(700,50,50,50);
			year2.setBounds(700,50,50,50);
			year3.setBounds(750,50,50,50);
			year4.setBounds(800,50,50,50);
			year5.setBounds(700,100,50,50);
			year6.setBounds(750,100,50,50);
			year7.setBounds(800,100,100,50);
			
			
			
			year1.setVisible(false);
			year2.setVisible(true);
			year3.setVisible(true);
			year4.setVisible(true);
			year5.setVisible(true);
			year6.setVisible(true);
			year7.setVisible(true);
			yearSelect.setVisible(true);
			type = "%";
			
		}
		if("$/Acre".equals(e.getActionCommand())) {
			year1.setBounds(700,50,50,50);
			year2.setBounds(750,50,50,50);
			year3.setBounds(800,50,50,50);
			year4.setBounds(850,50,50,50);
			year5.setBounds(700,100,50,50);
			year6.setBounds(750,100,50,50);
			year7.setBounds(800,100,100,50);
			
			year1.setVisible(true);
			year2.setVisible(true);
			year3.setVisible(true);
			year4.setVisible(true);
			year5.setVisible(true);
			year6.setVisible(true);
			year7.setVisible(false);
			yearSelect.setVisible(true);
			type = "$";
		}
		
			
		if(e.getActionCommand().equals("1991")) 
		{
			if(type.equals("%"))
			{
				percentGraph1991.setVisible(true);
				percentGraph1996.setVisible(false);
				percentGraph2001.setVisible(false);
				percentGraph2006.setVisible(false);
				percentGraph2011.setVisible(false);
				percentGraph2016.setVisible(false);
				percentGraph1991TO2016.setVisible(false);
				
				moneyGraph1991.setVisible(false);
				moneyGraph1996.setVisible(false);
				moneyGraph2001.setVisible(false);
				moneyGraph2006.setVisible(false);
				moneyGraph2011.setVisible(false);
				moneyGraph2016.setVisible(false);
			}
			else if(type.equals("$"))
			{
				percentGraph1991.setVisible(false);
				percentGraph1996.setVisible(false);
				percentGraph2001.setVisible(false);
				percentGraph2006.setVisible(false);
				percentGraph2011.setVisible(false);
				percentGraph2016.setVisible(false);
				percentGraph1991TO2016.setVisible(false);
				
				moneyGraph1991.setVisible(true);
				moneyGraph1996.setVisible(false);
				moneyGraph2001.setVisible(false);
				moneyGraph2006.setVisible(false);
				moneyGraph2011.setVisible(false);
				moneyGraph2016.setVisible(false);
				
			}
			
		}
		else if(e.getActionCommand().equals("1996")) 
		{
			if(type.equals("%"))
			{
				percentGraph1991.setVisible(false);
				percentGraph1996.setVisible(true);
				percentGraph2001.setVisible(false);
				percentGraph2006.setVisible(false);
				percentGraph2011.setVisible(false);
				percentGraph2016.setVisible(false);
				percentGraph1991TO2016.setVisible(false);
				
				moneyGraph1991.setVisible(false);
				moneyGraph1996.setVisible(false);
				moneyGraph2001.setVisible(false);
				moneyGraph2006.setVisible(false);
				moneyGraph2011.setVisible(false);
				moneyGraph2016.setVisible(false);
			}
			else if(type.equals("$"))
			{
				percentGraph1991.setVisible(false);
				percentGraph1996.setVisible(false);
				percentGraph2001.setVisible(false);
				percentGraph2006.setVisible(false);
				percentGraph2011.setVisible(false);
				percentGraph2016.setVisible(false);
				percentGraph1991TO2016.setVisible(false);
				
				moneyGraph1991.setVisible(false);
				moneyGraph1996.setVisible(true);
				moneyGraph2001.setVisible(false);
				moneyGraph2006.setVisible(false);
				moneyGraph2011.setVisible(false);
				moneyGraph2016.setVisible(false);
			}
		}
		else if(e.getActionCommand().equals("2001")) {
				
			if(type.equals("%"))
			{
				percentGraph1991.setVisible(false);
				percentGraph1996.setVisible(false);
				percentGraph2001.setVisible(true);
				percentGraph2006.setVisible(false);
				percentGraph2011.setVisible(false);
				percentGraph2016.setVisible(false);
				percentGraph1991TO2016.setVisible(false);
				
				moneyGraph1991.setVisible(false);
				moneyGraph1996.setVisible(false);
				moneyGraph2001.setVisible(false);
				moneyGraph2006.setVisible(false);
				moneyGraph2011.setVisible(false);
				moneyGraph2016.setVisible(false);
			}
			else if(type.equals("$"))
			{
				percentGraph1991.setVisible(false);
				percentGraph1996.setVisible(false);
				percentGraph2001.setVisible(false);
				percentGraph2006.setVisible(false);
				percentGraph2011.setVisible(false);
				percentGraph2016.setVisible(false);
				percentGraph1991TO2016.setVisible(false);
				
				moneyGraph1991.setVisible(false);
				moneyGraph1996.setVisible(false);
				moneyGraph2001.setVisible(true);
				moneyGraph2006.setVisible(false);
				moneyGraph2011.setVisible(false);
				moneyGraph2016.setVisible(false);
			}
		}
		else if(e.getActionCommand().equals("2006")) {
			if(type.equals("%"))
			{
				percentGraph1991.setVisible(false);
				percentGraph1996.setVisible(false);
				percentGraph2001.setVisible(false);
				percentGraph2006.setVisible(true);
				percentGraph2011.setVisible(false);
				percentGraph2016.setVisible(false);
				percentGraph1991TO2016.setVisible(false);
				
				moneyGraph1991.setVisible(false);
				moneyGraph1996.setVisible(false);
				moneyGraph2001.setVisible(false);
				moneyGraph2006.setVisible(false);
				moneyGraph2011.setVisible(false);
				moneyGraph2016.setVisible(false);
			}
			else if(type.equals("$"))
			{
				percentGraph1991.setVisible(false);
				percentGraph1996.setVisible(false);
				percentGraph2001.setVisible(false);
				percentGraph2006.setVisible(false);
				percentGraph2011.setVisible(false);
				percentGraph2016.setVisible(false);
				percentGraph1991TO2016.setVisible(false);
				
				moneyGraph1991.setVisible(false);
				moneyGraph1996.setVisible(false);
				moneyGraph2001.setVisible(false);
				moneyGraph2006.setVisible(true);
				moneyGraph2011.setVisible(false);
				moneyGraph2016.setVisible(false);
			}
		}
		else if(e.getActionCommand().equals("2011")) {
			if(type.equals("%"))
			{
				percentGraph1991.setVisible(false);
				percentGraph1996.setVisible(false);
				percentGraph2001.setVisible(false);
				percentGraph2006.setVisible(false);
				percentGraph2011.setVisible(true);
				percentGraph2016.setVisible(false);
				percentGraph1991TO2016.setVisible(false);
				
				moneyGraph1991.setVisible(false);
				moneyGraph1996.setVisible(false);
				moneyGraph2001.setVisible(false);
				moneyGraph2006.setVisible(false);
				moneyGraph2011.setVisible(false);
				moneyGraph2016.setVisible(false);
			}
			else if(type.equals("$"))
			{
				percentGraph1991.setVisible(false);
				percentGraph1996.setVisible(false);
				percentGraph2001.setVisible(false);
				percentGraph2006.setVisible(false);
				percentGraph2011.setVisible(false);
				percentGraph2016.setVisible(false);
				percentGraph1991TO2016.setVisible(false);
				
				moneyGraph1991.setVisible(false);
				moneyGraph1996.setVisible(false);
				moneyGraph2001.setVisible(false);
				moneyGraph2006.setVisible(false);
				moneyGraph2011.setVisible(true);
				moneyGraph2016.setVisible(false);
			}
		}
		else if(e.getActionCommand().equals("2016")) {
			if(type.equals("%"))
			{
				percentGraph1991.setVisible(false);
				percentGraph1996.setVisible(false);
				percentGraph2001.setVisible(false);
				percentGraph2006.setVisible(false);
				percentGraph2011.setVisible(false);
				percentGraph2016.setVisible(true);
				percentGraph1991TO2016.setVisible(false);
				
				moneyGraph1991.setVisible(false);
				moneyGraph1996.setVisible(false);
				moneyGraph2001.setVisible(false);
				moneyGraph2006.setVisible(false);
				moneyGraph2011.setVisible(false);
				moneyGraph2016.setVisible(false);
	
			}
			else if(type.equals("$"))
			{
				percentGraph1991.setVisible(false);
				percentGraph1996.setVisible(false);
				percentGraph2001.setVisible(false);
				percentGraph2006.setVisible(false);
				percentGraph2011.setVisible(false);
				percentGraph2016.setVisible(false);
				percentGraph1991TO2016.setVisible(false);
				
				moneyGraph1991.setVisible(false);
				moneyGraph1996.setVisible(false);
				moneyGraph2001.setVisible(false);
				moneyGraph2006.setVisible(false);
				moneyGraph2011.setVisible(false);
				moneyGraph2016.setVisible(true);
			}
		}
		else if(e.getActionCommand().equals("1991-2016"))
		{
			if(type.equals("%"))
			{
				percentGraph1991.setVisible(false);
				percentGraph1996.setVisible(false);
				percentGraph2001.setVisible(false);
				percentGraph2006.setVisible(false);
				percentGraph2011.setVisible(false);
				percentGraph2016.setVisible(false);
				percentGraph1991TO2016.setVisible(true);
				
				moneyGraph1991.setVisible(false);
				moneyGraph1996.setVisible(false);
				moneyGraph2001.setVisible(false);
				moneyGraph2006.setVisible(false);
				moneyGraph2011.setVisible(false);
				moneyGraph2016.setVisible(false);
			}
		}
		
		
		
	}
	

}