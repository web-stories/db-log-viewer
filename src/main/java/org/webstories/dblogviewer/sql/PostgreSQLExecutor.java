package org.webstories.dblogviewer.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.webstories.dblogviewer.arguments.DatabaseArguments;
import org.webstories.dblogviewer.arguments.MandatoryArgumentNotFoundException;

public class PostgreSQLExecutor extends SQLExecutor {
	public PostgreSQLExecutor( DatabaseArguments arguments ) throws SQLException, MandatoryArgumentNotFoundException {
		super( arguments );
	}
	@Override
	public ResultSet list( SQLQuery query ) throws SQLException {
		return connection.createStatement().executeQuery( query.toString() );
	}
}
