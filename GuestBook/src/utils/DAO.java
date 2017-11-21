package utils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.Person;
public class DAO {
	String connecturl="jdbc:sqlserver://192.168.1.4:1433;" +  
	         "databaseName=GUESTBOOK;user=minh;password=123";
	Connection con = null;  
    Statement stmt = null;
    List<Person> persons;
	public DAO(){
		con = null;  
	    stmt = null; 
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	         con = DriverManager.getConnection(connecturl);  
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	}
	public List<Person> Select (){
		persons=new ArrayList<Person>();
		try{
		 String SQL = "SELECT * FROM PERSON";  
		 PreparedStatement stm=con.prepareStatement(SQL);
		 ResultSet rs= stm.executeQuery();
         while(rs.next()){
        	 Person person=new Person();
        	 person.setID(rs.getInt(1));
        	 person.setName(rs.getString(2));
        	 person.setMessage(rs.getString(3));
        	 persons.add(person);
         }
		}catch(Exception e){
			e.printStackTrace();
		}
		return persons;
	}
	public void Insert (int ID,String name,String message){
		try{
	         String SQL = "Insert into PERSON values("+ID+",N'"+name+"',N'"+message+"')";  
	         PreparedStatement stm=con.prepareStatement(SQL);
	         int i=stm.executeUpdate();
		}catch(Exception e){
			
		}
	}
	public void Update (int ID,String name,String message){
		try{
	         String SQL = "Update PERSON set name=N'"+name+"',message=N'"+message+"' where ID="+ID+"" ;  
	         PreparedStatement stm=con.prepareStatement(SQL);
	         int i=stm.executeUpdate();
		}catch(Exception e){
			
		}
	}
	public void Delete(int ID)
	{
		try{
	         String SQL = "Delete from PERSON where ID="+ID+"" ;  
	         PreparedStatement stm=con.prepareStatement(SQL);
	         int i=stm.executeUpdate();
		}catch(Exception e){
			
		}
	}
	public Person person(int ID){
		 Person person=new Person();
	try{
		String SQL = "SELECT * FROM PERSON where ID="+ID+"";  
		 PreparedStatement stm=con.prepareStatement(SQL);
		 ResultSet rs= stm.executeQuery();
		
        while(rs.next()){
       	 person.setID(rs.getInt(1));
       	 person.setName(rs.getString(2));
       	 person.setMessage(rs.getString(3));
        }
	}catch(Exception e){
		e.printStackTrace();
	}
        return person;	
	}
}
