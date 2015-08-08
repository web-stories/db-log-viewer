package org.webstories.dblogviewer.template.orm;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRecord {
	private String username;
	public UserRecord( ResultSet result ) throws SQLException {
		this.username = result.getString( "ds_username" );
	}
	public String getUsername() {
		return username;
	}
}
