package com.eisrem.AppUtils;

import java.io.Reader;
import java.io.StringReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.jdbc.ScriptRunner;

//import org.apache.ibatis.jdbc.ScriptRunner;

public class DBConnect {



	//Create Connection to Database
	public static Connection connect() {
		Connection con = null;
		String username = Configuration.User.dbUser;
		String password = Configuration.Password.dbPassword;
		String devDB = Configuration.Database.devDB;
		String uatDB = Configuration.Database.uatDB;
		String dbUrl;

		try {
			if(Configuration.Enviornment.baseEnviornment.equalsIgnoreCase("dev")) {

				dbUrl = "jdbc:oracle:thin:" + username + "/" + password + "@ldap://oid.lb.state.me.us:3060/" + devDB + ",cn=OracleContext,dc=State,dc=me,dc=us";
				con= DriverManager.getConnection(dbUrl, username, password);

			}

			else if (Configuration.Enviornment.baseEnviornment.equalsIgnoreCase("uat")) {

//				dbUrl = "jdbc:oracle:thin:" + username + "/" + password + "@ldap://oit-teaqasorg02.state.me.us:3060/" + uatDB + ",cn=OracleContext,dc=State,dc=me,dc=us";
				dbUrl = "jdbc:oracle:thin:" + username + "/" + password + "@ldap://oid.lb.state.me.us:3060/" + uatDB + ",cn=OracleContext,dc=State,dc=me,dc=us";
				con= DriverManager.getConnection(dbUrl, username, password);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}


		return con;
	}

	//Create Connection to Database
	public void closeConnection() {
		try {
			connect().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//Create Statement using Prepared Statement for given query
	public PreparedStatement getPreparedStatement(String query) {
		PreparedStatement statement = null;
		Connection con;
		try {
			con = connect();
			statement = con.prepareStatement(query);
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return statement;

	}

	//Execute Statement and create result set for given query
	public ResultSet getResultSet(String query) {
		ResultSet result = null;
		try {
			PreparedStatement statement = getPreparedStatement(query);
			result = statement.executeQuery();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//Use result set to get Meta data for given query
	public ResultSetMetaData getMetaData(String query) {
		ResultSetMetaData resultMD = null;
		try {
			resultMD=getResultSet(query).getMetaData();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return resultMD;
	}

	//Get the number of column existing for given query
	public int getAmountOfColumn(String query) {
		ResultSetMetaData resultMD = null;
		int column = 0;
		try {
			resultMD = getResultSet(query).getMetaData();
			column = resultMD.getColumnCount();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return column;
	}

	//Get name of all column for given Query
	public ArrayList<String> getColumnName(String query) {
		ArrayList<String> array = new ArrayList<String>();

		try {
			ResultSetMetaData resultMD = getResultSet(query).getMetaData();
			int column = resultMD.getColumnCount();

			for(int i=1; i<=column; i++) {
				array.add(resultMD.getColumnName(i));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}

	//Get amount of row for given Query
	public int getAmountOfRow(String query) {
		int row = 0;

		try {
			Connection con = connect();
			PreparedStatement statement = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet result = statement.executeQuery();
			result.last();
			row = result.getRow();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	//	//Get data for given query and column index
	//	public ArrayList<String> getAllRowData(String query) {
	//		ArrayList<String> array = null;
	//
	//		try {
	//			ResultSet result = getPreparedStatement(query).executeQuery();
	//			array = new ArrayList<String>();
	//			int column = 1;
	//			int amountOfColumn = getAmountOfColumn(query);
	//			for (int i = 0; i<amountOfColumn; i++) {
	//				result.next();
	//				array.add(result.getString(column));
	//				column++;
	//			}
	////			while(result.next()) {
	////				array.add(result.getString(column));
	////				column++;
	////			}
	//		}catch (Exception e) {
	//			SeleniumHelper.log.error("Was not able to create a successful connection");
	//			e.printStackTrace();
	//		}
	//		return array;
	//	}

	//Get data for given query and column name
	public ArrayList<String> getData(String query, String column) {
		ArrayList<String> array = null;

		try {
			ResultSet result = getPreparedStatement(query).executeQuery();
			array = new ArrayList<String>();

			while(result.next()) {
				array.add(result.getString(column));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}

	//Get data for given query and column index
	public ArrayList<String> getData(String query, int column) {
		ArrayList<String> array = null;

		try {
			ResultSet result = getPreparedStatement(query).executeQuery();
			array = new ArrayList<String>();

			while(result.next()) {
				array.add(result.getString(column));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}

	//Will execute any given query 
	public DBConnect executeQuery(String query) {
		try {
			PreparedStatement statement = connect().prepareStatement(query);
			statement.executeUpdate();
		}catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	//Will execute any given query 
		public DBConnect execute(String sql) {
			try {
			//	PreparedStatement statement = connect().prepareStatement(query);
				CallableStatement cs = connect().prepareCall(sql);
				
				cs.execute();
			}catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}catch (Exception e) {
				e.printStackTrace();
			}
			return this;
		}
	
	//Will execute any given query 
		public DBConnect update(String query, String param) {
			try {
				PreparedStatement statement = connect().prepareStatement(query);
				statement.setString(1,param);
				statement.executeUpdate();
			}catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}catch (Exception e) {
				e.printStackTrace();
			}
			return this;
		}

	//Will check if a select query has a result set that returns an empty row
	public boolean executeHasEmptyResultSetQuery(String query) {
		try {
			PreparedStatement statement = connect().prepareStatement(query,
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = statement.executeQuery();
			int size = 0;
			if (rs != null) 
			{
				rs.last();
				size = rs.getRow(); 
			}
			return size > 1 ? true : false;
		}catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	//Will check if a select query has a result set that is not empty
	public boolean executeHasResultSetQuery(String query) {
		try {
			return getResultSet(query).next();
			
		}catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	//Will execute a query and return if it has a resultset
	public boolean executeScript(String script) {
		try{
			ScriptRunner sr = new ScriptRunner(connect());
			Reader reader = new StringReader(script);
			sr.runScript(reader);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
