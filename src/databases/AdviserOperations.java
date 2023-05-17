
package databases;

import java.sql.*;

public class AdviserOperations
{
	public static boolean addAdviser(String username,String password)
	{
		try(Connection conn=Connect.getConnection())
		{
			Statement stmt = conn.createStatement();
			String query="insert into adviser values('"+username+"', '"+password+"')";
		    stmt.executeUpdate(query);
		    return true;
		}
		catch(SQLException e)
		{
			System.out.println("Some Error Occured in addUser().");
		}
		return false;
	}
	
	public static boolean deleteUser(String adviser_id)
	{
		try(Connection conn=Connect.getConnection())
		{
			Statement stmt = conn.createStatement();
			String query="delete from adviser where ad_id='"+adviser_id+"'";
		    stmt.executeUpdate(query);
		    return true;
		}
		catch(SQLException e)
		{
			System.out.println("Some Error Occured in deleteUser().");
		}
		return false;
	}
	
	public static String[][] allUsers()
	{
		try(Connection conn=Connect.getConnection())
		{
			Statement stmt = conn.createStatement();
			String query="select * from adviser";
		    ResultSet rs=stmt.executeQuery(query);
		    ResultSetMetaData rsmd = rs.getMetaData();
		    
		    int rows,cols;
		    cols=rsmd.getColumnCount();
		    if(rs.last())
		    {
		    	rows=rs.getRow();
		    }
		    else
		    {
		    	return new String[0][0];
		    }
		    
		    String[][] arr=new String[rows][cols];		    
		    rs.beforeFirst();
		    while(rs.next())
		    {
		    	for(int j=0;j<cols;j++)
		    	{
		    		arr[rs.getRow()-1][j]=rs.getString(j+1);
//		    		System.out.print((arr[rs.getRow()-1][j])+" ");
		    	}
//		    	System.out.println();
		    }
		    return arr;
		}
		catch(SQLException e)
		{
			System.out.println("Some Error Occured in allUsers().");
		}
		return null;
	}
	
}
