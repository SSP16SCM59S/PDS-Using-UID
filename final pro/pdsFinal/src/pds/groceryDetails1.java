package pds;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.io.*;
class groceryDetails1 extends JPanel implements ActionListener//,Runnable, SerialPortEventListener
{
	/*static CommPortIdentifier	portId;
	static Enumeration			portList;
	InputStream					  inputStream;
	SerialPort			 		serialPort;
	Thread						  readThread;*/
	private boolean DEBUG = false;
	private static final long serialVersionUID = 1L;
	JTextField id,name;
	
	JButton okButton,clear,getId;
	JTable table;
	Connection con=null;

	groceryDetails1() throws IOException
	{
	
        table = new JTable(new MyTableModel());
       
        JScrollPane scrollPane = new JScrollPane(table);
        //Add the scroll pane to this panel.
       
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridBagLayout());
		addItem(panel1, new JLabel("CUSTOMER ID:"),0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(panel1, new JLabel("CUSTOMER NAME:"),0, 1, 1, 1, GridBagConstraints.EAST);
		id = new JTextField(20);
		name = new JTextField(20);
		addItem(panel1, id, 1, 0, 2, 1,GridBagConstraints.WEST);
		addItem(panel1, name, 1, 1, 1, 1,GridBagConstraints.WEST);
		this.add(panel1);
		
		Box buttonBox = Box.createHorizontalBox();
		okButton = new JButton("STORE");
		clear =new JButton("CLEAR");
		getId=new JButton("GET ID");
		initColumnSizes(table);

        //Fiddle with the Sport column's cell editors/renderers.
        setUpSportColumn(table, table.getColumnModel().getColumn(2));
		 add(scrollPane);
		addItem(panel1, buttonBox, 1, 5, 6, 1,GridBagConstraints.SOUTHWEST);
		 buttonBox.add(getId);
		 buttonBox.add(okButton);
		 buttonBox.add(clear);
		this.setVisible(true);
		getId.addActionListener(this);
		okButton.addActionListener(this);
		clear.addActionListener(this);
		            }
		           
public static String CardValue() throws IOException
{
	String fileName = "C:\\Users\\Shash\\Desktop\\final pro\\pdsFinal\\src\\pds\\pds\\outboxing.txt";

    List<String> lines = new ArrayList<String>();

    // read the file into lines
    BufferedReader r = new BufferedReader(new FileReader(fileName));
    String in;
    while ((in = r.readLine()) != null)
        lines.add(in);
    r.close();

    // check your condition
    String secondFromBottom = lines.get(lines.size() - 2);
    return secondFromBottom;
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
			String name1;
			String ID1;
			int x,y;
			int rice_amt,rice_qty,ragi_amt,ragi_qty,wheat_amt,wheat_qty,sugar_qty,sugar_amt,dal_amt,dal_qty;
			rice_amt=Integer.parseInt(table.getValueAt(0,2).toString());
			rice_qty=Integer.parseInt(table.getValueAt(0,1).toString());
			
			ragi_amt=Integer.parseInt(table.getValueAt(1,2).toString());
			ragi_qty=Integer.parseInt(table.getValueAt(1,1).toString());
			
			wheat_amt=Integer.parseInt(table.getValueAt(2,2).toString());
			wheat_qty=Integer.parseInt(table.getValueAt(2,1).toString());
			
			sugar_amt=Integer.parseInt(table.getValueAt(3,2).toString());
			sugar_qty=Integer.parseInt(table.getValueAt(3,1).toString());
			
			dal_amt=Integer.parseInt(table.getValueAt(4,2).toString());
			dal_qty=Integer.parseInt(table.getValueAt(4,1).toString());
			
			name1=name.getText();
			ID1=id.getText();
			for(int i=0;i<table.getRowCount();i++)
			{
				
				x=Integer.parseInt(table.getValueAt(i,1).toString());
				y=Integer.parseInt(table.getValueAt(i,2).toString());
				table.setValueAt((x*y), i, 3);
			}
			if(name1.equals("") ||ID1.equals("") ) 
			{
				//okButton.setEnabled(false);
				JOptionPane.showMessageDialog(null,"All fields are mandatory!!!!! Please Enter");
			}
			else
			{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			    con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/pds","root","indian");
				java.sql.PreparedStatement pst =con.prepareStatement("insert into deal_custDetails values(?,?,?,?,?,?,?,?,?,?,?,?)");
				
				pst.setString(1,ID1);
				pst.setString(2,name1);
				pst.setInt(3,rice_amt);
				pst.setInt(4,rice_qty);
				pst.setInt(5,ragi_amt);
				pst.setInt(6,ragi_qty);
				pst.setInt(7,wheat_amt);
				pst.setInt(8,wheat_qty);
				pst.setInt(9,sugar_qty);
				pst.setInt(10,sugar_amt);
				pst.setInt(11,dal_amt);
				pst.setInt(12,dal_qty);		
				//pst.setInt(13,total);
				
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
			id.setText("");
			}
			
			if(ae.getSource()==getId)
			{
				try {
					id.setText(CardValue());
				} catch (IOException e) {
					// TODO Auto-generated catch block
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
        {"RICE",  new Integer(6),"","", new Boolean(true)},
        {"RAGI",  new Integer(4),"","", new Boolean(true)},
        {"WHEAT", new Integer(4),"","",new Boolean(true)},
        {"SUGAR", new Integer(5),"","",new Boolean(true)},
        {"DAL",   new Integer(3),"","",new Boolean(true)}
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
        if (col < 2) {
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
/*
public void run() {
	try {
        Thread.sleep(20000);
    } catch (InterruptedException e) 
    {System.out.println(e);}
    // TODO Auto-generated method stub
	
}

public void serialEvent(SerialPortEvent event) {
	// TODO Auto-generated method stub
	switch (event.getEventType()) {

	case SerialPortEvent.BI:

	case SerialPortEvent.OE:

	case SerialPortEvent.FE:

	case SerialPortEvent.PE:

	case SerialPortEvent.CD:

	case SerialPortEvent.CTS:

	case SerialPortEvent.DSR:

	case SerialPortEvent.RI:

	case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
		break;
		
	case SerialPortEvent.DATA_AVAILABLE:
        byte[] readBuffer = new byte[20];
       int c=-1;

      try {
    	  FileWriter fw=new FileWriter("a.txt");
            while (inputStream.available() > 0) {
                int numBytes = inputStream.read(readBuffer);
             //   while (() {
                	fw.write(c);
                	fw.close();
                	
					
				}
       
            String data=new String(readBuffer);
            id.setText(""+data);
            System.out.println(data);

     } 
        catch (Exception e) 
        {
        	System.out.println(e);
        	}
        break;
}}
}

*/