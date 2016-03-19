package pds;
//import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
//import java.awt.FlowLayout;
//import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
public class Home extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTabbedPane jtp;
	JButton jb1;
	
	Home()
	{
		jtp=new JTabbedPane();
		jtp.addTab("Admin Login",new AdminPanel());
		jtp.addTab("Dealer Login",new DealerPanel());
		add(jtp);
		//this.setLocation(180,180);
		this.setSize(660,560); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Home Page!");
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public static void main(String ar[])
	{
		new Home();
	}

	
}
class AdminPanel extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField aname,pwd;
	JButton log;
	//JLabel jl1,jl2;
    JPanel panelBgImg;
	//Container con;

	public AdminPanel() 
	{
		ImageIcon imh = new ImageIcon("C:\\Users\\Shash\\Desktop\\final pro\\pdsFinal\\pds images\\pds_logo12.JPG");
        setSize(imh.getIconWidth(), imh.getIconHeight());
        //this.setLocation(20,20);
        panelBgImg = new JPanel()
        {
            public void paintComponent(Graphics g) 
            {
                Image img = new ImageIcon("C:\\Users\\Shash\\Desktop\\final pro\\pdsFinal\\pds images\\pds_logo12.JPG").getImage();
                g.drawImage(img, 0, 0, null);
            } 
        };
   
        add(panelBgImg);
        panelBgImg.setBounds(0, 0, imh.getIconWidth(), imh.getIconHeight());
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridBagLayout());
		addItem(panel1, new JLabel("Admin Name:"),0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(panel1, new JLabel("Admin Password:"),0, 1, 1, 1, GridBagConstraints.EAST);
		aname = new JTextField(20);
		aname.setFont(new Font("Courier New",Font.BOLD,20));
		pwd = new JPasswordField(20);
		pwd.setFont(new Font("Courier New",Font.BOLD,20));
		addItem(panel1, aname, 1, 0, 2, 1,GridBagConstraints.WEST);
		addItem(panel1, pwd, 1, 1, 1, 1,GridBagConstraints.WEST);
		this.add(panel1);
		Box buttonBox = Box.createHorizontalBox(); 
		log = new JButton("LOGIN");
		buttonBox.add(log);
		addItem(panel1, buttonBox, 1, 5, 6, 1,GridBagConstraints.NORTH);
		//this.pack();
		panel1.setOpaque(false);
		//aname.setOpaque(false);
		//pwd.setOpaque(false);
		this.setVisible(true);
		log.addActionListener(this);
		panelBgImg.add(panel1);  
		panelBgImg.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER,150,200));
	
	}
	public void actionPerformed(ActionEvent ae) {
		String value1=aname.getText();
		String value2=pwd.getText();
		if(ae.getSource()==log)
		{
			if(value1.equalsIgnoreCase("administrator")&& value2.equals("indian")) 
			{
				//JOptionPane.showMessageDialog(this,"correct");
				//Demo a=new Demo();
				AdminPage a=new AdminPage();
				a.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(this,"Incorrect login or password","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	private void addItem(JPanel p, JComponent c,
			int x, int y, int width, int height, int align)
			{
			GridBagConstraints gc = new GridBagConstraints();
			gc.gridx = x;
			gc.gridy = y;
			gc.gridwidth = width;
			gc.gridheight = height;
			gc.weightx = 100.0;
			gc.weighty = 100.0;
			gc.insets = new Insets(5, 5, 5, 5);
			gc.anchor = align;
			gc.fill = GridBagConstraints.NONE;
			p.add(c, gc);
			setOpaque(false);
			}
	}

class DealerPanel extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField t11,t12;
	JButton jb1;
	JLabel jl1,jl2;
	JPanel panel;
	JPanel panelBgImg;
	public DealerPanel() 
	{
		ImageIcon imh = new ImageIcon("C:\\Users\\Shash\\Desktop\\final pro\\pdsFinal\\pds images\\pds_logo12.JPG");
        setSize(imh.getIconWidth(), imh.getIconHeight());
        panelBgImg = new JPanel()
        {
            public void paintComponent(Graphics g) 
            {
                Image img = new ImageIcon("C:\\Users\\Shash\\Desktop\\final pro\\pdsFinal\\pds images\\pds_logo12.JPG").getImage();
                g.drawImage(img, 0, 0, null);
            } 
        };
   
        add(panelBgImg);
        panelBgImg.setBounds(0, 0, imh.getIconWidth(), imh.getIconHeight());
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridBagLayout());
		addItem(panel1, new JLabel("Dealer Name:"),0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(panel1, new JLabel("Dealer Password:"),0, 1, 1, 1, GridBagConstraints.EAST);
		t11 = new JTextField(20);
		t11.setFont(new Font("Courier New",Font.BOLD,20));
		t12 = new JPasswordField(20);
		t12.setFont(new Font("Courier New",Font.BOLD,20));
		addItem(panel1, t11, 1, 0, 2, 1,GridBagConstraints.WEST);
		addItem(panel1, t12, 1, 1, 1, 1,GridBagConstraints.WEST);
		this.add(panel1);
		Box buttonBox = Box.createHorizontalBox(); 
		jb1 = new JButton("LOGIN");
		buttonBox.add(jb1);
		addItem(panel1, buttonBox, 1, 5, 6, 1,GridBagConstraints.NORTH);
		//this.pack();
		this.setVisible(true);
		panelBgImg.add(panel1);  
		panelBgImg.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER,150,200));
		panel1.setOpaque(false);
		//t11.setOpaque(false);
		//t12.setOpaque(false);
		//jb1.setOpaque(false);
		jb1.addActionListener(this);
	
	}
	public void actionPerformed(ActionEvent ace)
	{
		String value1=t11.getText();
		String value2=t12.getText();
		Connection con=null;
		String user1="";
		String pass1="";
		if(ace.getSource()==jb1)
		{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
	    con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/pds","root","indian");
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery("select * from dealerDetails where username='"+value1+"' && password='"+value2+"'");
		while (res.next())
		{
		user1 = res.getString("username");
		pass1 = res.getString("password");
		}
		if (value1.equals(user1) && value2.equals(pass1)) 
		{
		//JOptionPane.showMessageDialog(this,"correct");
			DealerPage a=new DealerPage();
			a.setVisible(true);
		}
		else{
		JOptionPane.showMessageDialog(this,"Incorrect login or password");
		}
		st.close();
		con.close();
		}
		catch(Exception e){
		System.out.println(e.getMessage());
		e.printStackTrace();
		}
		}
	}
	private void addItem(JPanel p, JComponent c,
			int x, int y, int width, int height, int align)
			{
			GridBagConstraints gc = new GridBagConstraints();
			gc.gridx = x;
			gc.gridy = y;
			gc.gridwidth = width;
			gc.gridheight = height;
			gc.weightx = 100.0;
			gc.weighty = 100.0;
			gc.insets = new Insets(5, 5, 5, 5);
			gc.anchor = align;
			gc.fill = GridBagConstraints.NONE;
			p.add(c, gc);
			setOpaque(false);
			}
	}
			
