package pds;
import java.awt.GridBagConstraints;

import pds.MaxValGen;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class AdminPage extends JFrame
{
	private static final long serialVersionUID = 1L;
	JTabbedPane jtb1;
	public AdminPage() {
		jtb1=new JTabbedPane();
		jtb1.addTab("Add Dealer Details",new addDealer());
		jtb1.addTab("Dealer Details",new dealerDetails());
		jtb1.addTab("Grocery Details",new groceryDetails());
		jtb1.addTab("Logout",new Logout());
		add(jtb1);
		
		//this.setLocation(280,150);
	setSize(700,595);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("Admin Page!");
	this.setVisible(true);
	this.setResizable(false);
	
	}
public static void main(String ar[])
	{
		new AdminPage();
	}
}



class addDealer extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField name, phone, username, password, address ,district;
	JButton okButton, clear;
	JComboBox  state;
	Connection con=null;
	JPanel panelBgImg;
	addDealer()
	{
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon imh = new ImageIcon("C:\\Users\\Shash\\Desktop\\final pro\\pdsFinal\\pds images\\picture_pds215.JPG");
		
        setSize(imh.getIconWidth(), imh.getIconHeight());
       // final int a=imh.getIconWidth();
       
       // final int b=imh.getIconHeight();
       
        panelBgImg = new JPanel()
        {
            public void paintComponent(Graphics g) 
            {
                Image img = new ImageIcon("C:\\Users\\Shash\\Desktop\\final pro\\pdsFinal\\pds images\\picture_pds215.JPG").getImage();
             
                g.drawImage(img, 0, 0, null);
              
            } 
        };
   
        add(panelBgImg);
        panelBgImg.setBounds(0, 0, imh.getIconWidth(), imh.getIconHeight());
    
        state=new JComboBox();
        state.addItem("Andhra Pradesh");
        state.addItem("Goa");
        state.addItem("Karnataka");
        state.addItem("Tamil Nadu");
        state.addItem("Kerela");
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridBagLayout());
		addItem(panel1, new JLabel("Name:"),        13, 0,1, 1, GridBagConstraints.EAST);
		addItem(panel1, new JLabel("Phone:"),		13, 1,1, 1, GridBagConstraints.EAST);
		addItem(panel1, new JLabel("Address:"),		13, 2,1, 1, GridBagConstraints.EAST);
		addItem(panel1, new JLabel("State:"), 		13, 3,1, 1 , GridBagConstraints.EAST);
		addItem(panel1, new JLabel("District:"), 	13, 4,1, 1 , GridBagConstraints.EAST);
		addItem(panel1, new JLabel("UserName:"),	13, 5,1, 1, GridBagConstraints.EAST);
		addItem(panel1, new JLabel("Password:"),	13, 6,1, 1, GridBagConstraints.EAST);
		name = new JTextField(20);
		name.setFont(new Font("Courier New",Font.BOLD,20));
		phone = new JTextField(20);
		phone.setFont(new Font("Courier New",Font.BOLD,20));
		address = new JTextField(20);
		address.setFont(new Font("Courier New",Font.BOLD,20));
		district =new JTextField(20);
		district.setFont(new Font("Courier New",Font.BOLD,20));
		username = new JTextField(20);
		username.setFont(new Font("Courier New",Font.BOLD,20));
		password = new JPasswordField(20);
		password.setFont(new Font("Courier New",Font.BOLD,20));
		addItem(panel1, name, 		14, 0, 0, 1,GridBagConstraints.WEST);
		addItem(panel1, phone,	    14, 1, 1, 1,GridBagConstraints.WEST);
		addItem(panel1, address, 	14, 2, 2, 1,GridBagConstraints.WEST);
		addItem(panel1, state,    	14, 3, 3, 1,GridBagConstraints.WEST);
		addItem(panel1, district, 	14, 4, 4, 1,GridBagConstraints.WEST);
		addItem(panel1, username, 	14, 5, 5, 1,GridBagConstraints.WEST);
		addItem(panel1, password, 	14, 6, 6, 1,GridBagConstraints.WEST);
		state.setEditable(true);
		this.add(panel1);
		Box buttonBox = Box.createHorizontalBox(); 
		okButton = new JButton("STORE");
		clear = new JButton("CLEAR");
		buttonBox.add(okButton);
		buttonBox.add(clear);
		addItem(panel1, buttonBox, 14, 7, 8, 1,GridBagConstraints.WEST);
		//this.pack();
		this.setVisible(true);
		panelBgImg.add(panel1);  
		panel1.setOpaque(false);
		name.setOpaque(false);
		phone.setOpaque(false);
		address.setOpaque(false);
		district.setOpaque(false);
		username.setOpaque(false);
		password.setOpaque(false);
		panelBgImg.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER,176,200));
		okButton.addActionListener(this);
		clear.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==okButton)
		{
			
		String name1,location,state1,dist,contactNum,uname,pwd;
		name1= name.getText();
		location=address.getText();
		contactNum=phone.getText();
		state1= state.getSelectedItem().toString();
		dist=district.getText();
		uname=username.getText();
		pwd=password.getText();
		if(name1.equals("") ||location.equals("") || contactNum.equals("") || dist.equals("") ||uname.equals("") ||pwd.equals("") ) 
		{
			//okButton.setEnabled(false);
			JOptionPane.showMessageDialog(null,"All fields are mandatory!!!!! Please Enter");
		}
		else
		{	
			try
			{
				int id=new MaxValGen().getId();
				Class.forName("com.mysql.jdbc.Driver");
			    con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/pds","root","indian");
				java.sql.PreparedStatement pst =con.prepareStatement("insert into dealerdetails values(?,?,?,?,?,?,?,?)");
				pst.setInt(1,id);
				pst.setString(2,name1);
				pst.setString(3,location);
				pst.setString(4,contactNum);
				pst.setString(5,state1);
				pst.setString(6,dist);
				pst.setString(7,uname);
				pst.setString(8,pwd);
				int done=pst.executeUpdate();
				if(done==1)
				{
					JOptionPane.showMessageDialog(this,"inserted successfully");
				}
				
				pst.close();
				con.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		}
		if(ae.getSource()==clear)
		{
			 name.setText("");
			address.setText("");
			phone.setText("");
			district.setText("");
			username.setText("");
			password.setText("");
			
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
			gc.insets = new Insets(7,7,5,5);
			gc.anchor = align;
			gc.fill = GridBagConstraints.NONE;
			p.add(c, gc);
			}
	
}

class dealerDetails extends JPanel implements TreeSelectionListener// MouseListener
{
	
	
	 
	private static final long serialVersionUID = 1L;
		//JTable jt;
		JFrame frame=new JFrame();
		Container con;
		JScrollPane jsp;
		JTree jtree;
		JTextArea ta;
	dealerDetails()
	{
		//jb=new JButton("SHOW RECORDS");
		//add(jb);
		con=frame.getContentPane();
		con.setLayout(new BorderLayout());
		DefaultMutableTreeNode root=new DefaultMutableTreeNode("States");
		DefaultMutableTreeNode state1=new DefaultMutableTreeNode("AndraPradesh");
		DefaultMutableTreeNode state2=new DefaultMutableTreeNode("Goa");
		DefaultMutableTreeNode state3=new DefaultMutableTreeNode("Karnataka");
		DefaultMutableTreeNode state4=new DefaultMutableTreeNode("Kerela");
		DefaultMutableTreeNode state5=new DefaultMutableTreeNode("Tamil Nadu");
		
		DefaultMutableTreeNode dis1ofstate3=new DefaultMutableTreeNode("Bangalore");
		DefaultMutableTreeNode dis2ofstate3=new DefaultMutableTreeNode("Chitradurga");
		DefaultMutableTreeNode dis3ofstate3=new DefaultMutableTreeNode("Mysore");
		
		DefaultMutableTreeNode dis1ofstate1=new DefaultMutableTreeNode("Hydrabad");
		DefaultMutableTreeNode dis2ofstate1=new DefaultMutableTreeNode("Anantpur");
		
		DefaultMutableTreeNode dis1ofstate2=new DefaultMutableTreeNode("North Goa");
		DefaultMutableTreeNode dis2ofstate2=new DefaultMutableTreeNode("South Goa");
	
		DefaultMutableTreeNode dis1ofstate4=new DefaultMutableTreeNode("Alappuzha");
		DefaultMutableTreeNode dis2ofstate4=new DefaultMutableTreeNode("Ernakulam");
		DefaultMutableTreeNode dis3ofstate4=new DefaultMutableTreeNode("Kozhikode");
		
		DefaultMutableTreeNode dis1ofstate5=new DefaultMutableTreeNode("Coimbatore");
		DefaultMutableTreeNode dis2ofstate5=new DefaultMutableTreeNode(" Erode");
		DefaultMutableTreeNode dis3ofstate5=new DefaultMutableTreeNode("Nagapattinam");
		
		root.add(state1);
		root.add(state2);
		root.add(state3);
		root.add(state4);
		root.add(state5);
		
		state1.add(dis1ofstate1);
		state1.add(dis2ofstate1);
		
		state3.add(dis1ofstate3);
		state3.add(dis2ofstate3);
		state3.add(dis3ofstate3);
		
		state2.add(dis1ofstate2);
		state2.add(dis2ofstate2);
		
		state4.add(dis1ofstate4);
		state4.add(dis2ofstate4);
		state4.add(dis3ofstate4);
		
		state5.add(dis1ofstate5);
		state5.add(dis2ofstate5);
		state5.add(dis3ofstate5);
		
		jtree=new JTree(root);
		ta=new JTextArea(35,35);
		ta.setFont(new Font("Courier New", Font.BOLD,20));
		//add(jtree);
		//jt=new JTable(35,6);
		//add(jt);
		 JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jtree, ta);
		    frame.getContentPane().add(sp, BorderLayout.WEST);
		    jsp=new JScrollPane(sp,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		   // add(sp);
		    add(jsp);
		//jb.addActionListener(this);
		//jt.addMouseListener(this);
		    jtree.addTreeSelectionListener(this);
		
	}
	public void valueChanged(TreeSelectionEvent tse)
	{
		TreePath tp=tse.getNewLeadSelectionPath();
		String selected=tp.getLastPathComponent().toString();
		String id11="";
		String name11="";//,dist11="";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/pds","root","indian");
			Statement stmt=con.createStatement();
			String query="select id,name,district from dealerdetails where district like '%"+selected+"%';";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				id11=id11+rs.getString(1)+"\n";
				name11+=rs.getString(2)+"\n";
				//dist11+=rs.getString(3)+"\n";
			}
			
			ta.setText("Dealer ID:\n"+id11+"Dealer Name:\n"+name11+"\n");//+"Dealer District:"+dist11);
		}
		catch(Exception e)
		{
			System.out.println("exception");
		}
	}
	
}


class groceryDetails extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean DEBUG = false;
	JButton okButton;//,clear;//,update;
	JTable table;
	Connection con=null;
	JPanel panelBgImg;
	groceryDetails()
	{
ImageIcon imh = new ImageIcon("C:\\Users\\Shash\\Desktop\\final pro\\pdsFinal\\pds images\\picture_pds215.JPG");
		
        setSize(imh.getIconWidth(), imh.getIconHeight());
        
        panelBgImg = new JPanel()
        {
            public void paintComponent(Graphics g) 
            {
                Image img = new ImageIcon("C:\\Users\\Shash\\Desktop\\final pro\\pdsFinal\\pds images\\picture_pds215.JPG").getImage();
             
                g.drawImage(img, 0, 0, null);
              
            } 
        };
   
        add(panelBgImg);
        panelBgImg.setBounds(0, 0, imh.getIconWidth(), imh.getIconHeight());
   
        table = new JTable(new MyTableModel());
       // table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFont(new Font("Courier New", Font.BOLD,15));
        JScrollPane scrollPane = new JScrollPane(table);
        

        //Add the scroll pane to this panel.
       
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridBagLayout());
		
		this.add(panel1);
		panelBgImg.add(panel1);
		
		Box buttonBox = Box.createHorizontalBox();
		okButton = new JButton("UPDATE");
		//clear =new JButton("CLEAR");
		initColumnSizes(table);
        //Fiddle with the Sport column's cell editors/renderers.
        setUpSportColumn(table, table.getColumnModel().getColumn(2));
		 add(scrollPane);
		 table.setOpaque(false);
		 scrollPane.setOpaque(false);
		panelBgImg.setLayout((LayoutManager) new FlowLayout(FlowLayout.LEADING,panel1.getWidth(),panel1.getHeight()));
		addItem(panel1, buttonBox, 1, 5, 6, 1,GridBagConstraints.SOUTHWEST);
		 buttonBox.add(okButton);
		// buttonBox.add(update);
		 //buttonBox.add(clear);
		this.setVisible(true);
		okButton.addActionListener(this);
		//update.addActionListener(this);
		//clear.addActionListener(this);

	}
	public void initColumnSizes(JTable table) {
        MyTableModel model = (MyTableModel)table.getModel();
        TableColumn column = null;
        Component comp = null;
        int headerWidth = 0;
        int cellWidth = 0;
        Object[] longValues = model.longValues;
        TableCellRenderer headerRenderer =
            table.getTableHeader().getDefaultRenderer();

        for (int i = 0; i < 5; i++) {
            column = table.getColumnModel().getColumn(i);

            comp = headerRenderer.getTableCellRendererComponent(
                                 null, column.getHeaderValue(),
                                 false, false, 0, 0);
            headerWidth = comp.getPreferredSize().width;

            comp = table.getDefaultRenderer(model.getColumnClass(i)).
                             getTableCellRendererComponent(
                                 table, longValues[i],
                                 false, false, 0, i);
            cellWidth = comp.getPreferredSize().width;

            if (DEBUG) {
                System.out.println("Initializing width of column "
                                   + i + ". "
                                   + "headerWidth = " + headerWidth
                                   + "; cellWidth = " + cellWidth);
            }

            column.setPreferredWidth(Math.max(headerWidth, cellWidth));
        }
    }

    public void setUpSportColumn(JTable table,
                                 TableColumn sportColumn) {
        //Set up the editor for the sport cells.
        sportColumn.setCellEditor(new ComboEditor());

        //Set up tool tips for the sport cells.
        DefaultTableCellRenderer renderer =
                new DefaultTableCellRenderer();
        renderer.setToolTipText("Click for combo box");
        sportColumn.setCellRenderer(renderer);
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
			}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==okButton)
		{	
			
			int x,y;
			//int rice_amt1,rice_qty1,ragi_amt1,ragi_qty1,wheat_amt1,wheat_qty1,sugar_qty1,sugar_amt1,dal_amt1,dal_qty1;
			/*rice_amt1=Integer.parseInt(table.getValueAt(0,2).toString());
			rice_qty1=Integer.parseInt(table.getValueAt(0,1).toString());
			
			ragi_amt1=Integer.parseInt(table.getValueAt(1,2).toString());
			ragi_qty1=Integer.parseInt(table.getValueAt(1,1).toString());
			
			wheat_amt1=Integer.parseInt(table.getValueAt(2,2).toString());
			wheat_qty1=Integer.parseInt(table.getValueAt(2,1).toString());
			
			sugar_amt1=Integer.parseInt(table.getValueAt(3,2).toString());
			sugar_qty1=Integer.parseInt(table.getValueAt(3,1).toString());
			
			dal_amt1=Integer.parseInt(table.getValueAt(4,2).toString());
			dal_qty1=Integer.parseInt(table.getValueAt(4,1).toString());
			*/
			for(int i=0;i<table.getRowCount();i++)
			{
				
				x=Integer.parseInt(table.getValueAt(i,1).toString());
				y=Integer.parseInt(table.getValueAt(i,2).toString());
				table.setValueAt((x*y), i, 3);
			}
			int rice_qty1,ragi_qty1,wheat_qty1,sugar_qty1,dal_qty1;
			rice_qty1=Integer.parseInt(table.getValueAt(0,1).toString());
			ragi_qty1=Integer.parseInt(table.getValueAt(1,1).toString());
			wheat_qty1=Integer.parseInt(table.getValueAt(2,1).toString());
			sugar_qty1=Integer.parseInt(table.getValueAt(3,1).toString());
			dal_qty1=Integer.parseInt(table.getValueAt(4,1).toString());
			System.out.println(rice_qty1);
			System.out.println(ragi_qty1);
			System.out.println(wheat_qty1);
			System.out.println(sugar_qty1);
			System.out.println(dal_qty1);

			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			    con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/pds","root","indian");
				//java.sql.PreparedStatement pst =con.prepareStatement("update deal_custdetails set rice_amt=?,rice_qty=?, ragi_amt=?, ragi_qty=?, wheat_amt=?, wheat_qty=?, sugar_qty=?, sugar_amt=?,dal_amt=?,dal_qty=? ");
			    //java.sql.PreparedStatement pst =con.prepareStatement("update grocerydetails set rice_amt=?,rice_qty=?, ragi_amt=?, ragi_qty=?, wheat_amt=?, wheat_qty=?, sugar_qty=?, sugar_amt=?,dal_amt=?,dal_qty=? ");
				Statement stmt=con.createStatement();
			    String query1="update grocerydetails set quantity='"+rice_qty1+"' where groceryname='rice';";
				String query2="update grocerydetails set quantity='"+ragi_qty1+"' where groceryname='ragi';";
				String query3="update grocerydetails set quantity='"+wheat_qty1+"' where groceryname='wheat';";
				String query4="update grocerydetails set quantity='"+sugar_qty1+"' where groceryname='sugar';";
				String query5="update grocerydetails set quantity='"+dal_qty1+"' where groceryname='dal';";
				stmt.addBatch(query1);
				stmt.addBatch(query2);
				stmt.addBatch(query3);
				stmt.addBatch(query4);
				stmt.addBatch(query5);
				stmt.executeBatch();
				//pst.setInt(3,rice_amt1);
				//pst.setInt(4,rice_qty1);
				//pst.setInt(5,ragi_amt1);
				//pst.setInt(6,ragi_qty1);
				//pst.setInt(7,wheat_amt1);
				//pst.setInt(8,wheat_qty1);
				//pst.setInt(9,sugar_qty1);
				//pst.setInt(10,sugar_amt1);
				//pst.setInt(11,dal_amt1);
				//pst.setInt(12,dal_qty1);		
				//pst.setInt(13,total);
				
				//int done=pst.executeUpdate();
				
				//if(done==1)
				//{
					//JOptionPane.showMessageDialog(this,"UPDATED!!!!!!!!!");
				//}
				
				stmt.close();
				con.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
	}


class ComboEditor extends DefaultCellEditor{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DefaultComboBoxModel model;
    Map<String,List<String>> choicesMap;
    public ComboEditor(){
        super(new JComboBox());
        model = (DefaultComboBoxModel)((JComboBox)getComponent()).getModel();
        buildComboMap();
    }

    public void buildComboMap(){
        choicesMap = new HashMap<String,List<String>>();
        // for "true"
        List<String> choices = new ArrayList<String>();
        choices.add("1");
        choices.add("2");
        choices.add("3");
        choices.add("4");
        choices.add("5");
        choices.add("6");
        choices.add("7");
        choices.add("8");
        choices.add("9");
        choices.add("20");
        choicesMap.put("true", choices);
        // for "false"
        choices = new ArrayList<String>();
        choices.add("5");
        choices.add("7");
        choices.add("10");
        choicesMap.put("false", choices);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        model.removeAllElements();
       String keyColumnValue = table.getValueAt(row, table.getColumnModel().getColumnIndex("check")).toString();
        for (String item : choicesMap.get(keyColumnValue)){
            model.addElement(item);
        }
        return super.getTableCellEditorComponent(table, value,isSelected, row, column);
    }
}
class MyTableModel extends AbstractTableModel {
    /**
	 * 
	 */
	private boolean DEBUG = false;
	private static final long serialVersionUID = 1L;
	public String[] columnNames = {"Grocery Name",                             
                                    "Quantity",
                                    "Amount",
                                    "Total",
                                    "check"};
    public Object[][] data = {
        {"RICE",  new Integer(5),"","", new Boolean(true)},
        {"RAGI",  new Integer(3),"","", new Boolean(true)},
        {"WHEAT", new Integer(2),"","",new Boolean(true)},
        {"SUGAR", new Integer(20),"","",new Boolean(true)},
        {"DAL",   new Integer(10),"","",new Boolean(true)}
    };

    public final Object[] longValues = {"Sharon", "Campione",
                                        "None of the above",
                                        new Integer(20), Boolean.TRUE};

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    @SuppressWarnings("unchecked")
	public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 1) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        if (DEBUG) {
            System.out.println("Setting value at " + row + "," + col
                               + " to " + value
                               + " (an instance of "
                               + value.getClass() + ")");
        }

        data[row][col] = value;
        fireTableCellUpdated(row, col);

        if (DEBUG) {
            System.out.println("New value of data:");
            printDebugData();
        }
    }

    //private
    public void printDebugData() {
        int numRows = getRowCount();
        int numCols = getColumnCount();

        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + data[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
}
}


class Logout extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton jlog;
	public Logout() {
		// TODO Auto-generated constructor stub
		jlog=new JButton("CLICK HERE TO LOGOUT");
		add(jlog);
		jlog.addActionListener(this);
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Home h=new Home();
		h.setVisible(true);
	}
	
	
}