package org.webstories.dblogviewer.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.webstories.dblogviewer.arguments.DatabaseArguments;
import org.webstories.dblogviewer.arguments.MandatoryArgumentNotFoundException;

public abstract class SQLExecutor {
	protected Connection connection;
	SQLExecutor( DatabaseArguments dbArgs ) throws SQLException, MandatoryArgumentNotFoundException {
		String host = dbArgs.retrieveHost();
		String user = dbArgs.retrieveUsername();
		String password = dbArgs.retrievePassword();
		this.connection = DriverManager.getConnection( "jdbc:postgresql://" + host + "/webstories", user, password );
	}
	public abstract ResultSet list( SQLQuery query ) throws SQLException;
}
