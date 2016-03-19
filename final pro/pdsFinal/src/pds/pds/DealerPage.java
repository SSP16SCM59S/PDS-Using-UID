package pds;
import java.io.IOException;

import pds.groceryDetails1;
import javax.swing.*;
public class DealerPage extends JFrame

	{
		private static final long serialVersionUID = 1L;
		JTabbedPane jtb1;
		public DealerPage() throws IOException {
			jtb1=new JTabbedPane();
			//jtb1.addTab("Customer Details",new custDetails1());
			jtb1.addTab("Grocery Details",new groceryDetails1());
			jtb1.addTab("Logout",new Logout());
			add(jtb1);
			
			//this.setLocation(280,150);
		setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Dealer Page!");
		this.setVisible(true);
		this.setResizable(false);
		}
		
	public static void main(String ar[]) throws IOException
		{
			new DealerPage();
		}
	}

