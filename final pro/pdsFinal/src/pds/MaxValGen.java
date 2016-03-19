package pds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MaxValGen {
	public int getId()throws Exception{ //for scrapbook

		Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("Jdbc:mysql://localhost:3306/pds","root","indian");
		Statement stm=con.createStatement();
		String qry="select max(id) from dealerdetails";
		ResultSet rs=stm.executeQuery(qry);
		int id=0;
		while(rs.next()){
			id=rs.getInt(1);
			System.out.println("idval"+id);
			id++;
		}
		return id;
		
	}
	public static void main(String[] args)throws Exception {
		System.out.println(new MaxValGen().getId());

	}


}
