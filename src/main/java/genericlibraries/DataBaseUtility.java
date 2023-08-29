package genericlibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	
	private Statement statement;
	private Connection connection;
	
	 
	public void databaseInitialization(String url, String user, String pwd)
	{
		Driver dbDriver=null;
		try {
			dbDriver = new Driver();
		    } catch (SQLException e) {
			  e.printStackTrace();
		    }
	    try {
			DriverManager.registerDriver(dbDriver);
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }	
	    
		try {
			connection = DriverManager.getConnection(url,user, pwd);
		    } catch (SQLException e) {
			  e.printStackTrace();
		    }
		
	     try {
			statement=connection.createStatement();
		     } catch (SQLException e) {
			   e.printStackTrace();
		     }
		}
	/*
	 * This method is used to read data from database
	 * @parameter query
	 * @parameter columnName
	 * @return
	 * @throws SQLException
	 */

   public List<String> readFromDatabase(String query, String columnName) throws SQLException 
   {
	  ResultSet result=statement.executeQuery(query);
	  List<String> list=new ArrayList<String>();
	  while(result.next()) 
	  {
		list.add(result.getString(columnName));
	  }
	  return list;
   }	

/*
 * This method is used to modify database
 * @parameter query
 * @return
 */
  public int modifyDatabase(String query)
   {
    int result=0;
    try {
        result=statement.executeUpdate(query);
        }catch(SQLException e) 
        {
	     e.printStackTrace();
        }
    return result;
   }


/*
 * This method is used to close database connection 
 */
   public void closDatabase()
   {
	  try {
		   connection.close();
	      } catch (SQLException e) 
	      {
		   e.printStackTrace();
	      }
	
   }
	
	
}

