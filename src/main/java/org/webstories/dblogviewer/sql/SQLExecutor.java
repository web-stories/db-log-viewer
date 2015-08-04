package org.webstories.dblogviewer.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.webstories.dblogviewer.arguments.DatabaseArguments;
import org.webstories.dblogviewer.arguments.MandatoryArgumentNotFoundException;

public abstract class SQLExecutor {
	protected Connection connection;
	SQLExecutor( DatabaseArguments arguments ) throws SQLException, MandatoryArgumentNotFoundException {
		String url = arguments.retrieveIp();
		String user = arguments.retrieveUsername();
		String password = arguments.retrievePassword();
		this.connection = DriverManager.getConnection( url, user, password );
	}
	public abstract ResultSet list( SQLQuery query ) throws SQLException;
}
