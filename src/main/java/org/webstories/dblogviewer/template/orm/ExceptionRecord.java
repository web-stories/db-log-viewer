package org.webstories.dblogviewer.template.orm;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExceptionRecord {
	private String exception;
	private String cause;
	private String cause2;
	private String cause3;
	public ExceptionRecord( ResultSet result ) throws SQLException {
		this.exception = result.getString( "ds_exception" );
		this.cause = result.getString( "ds_cause" );
		this.cause2 = result.getString( "ds_cause2" );
		this.cause3 = result.getString( "ds_cause3" );
	}
	public String getException() {
		return exception;
	}
	public String getCause() {
		return cause;
	}
	public String getCause2() {
		return cause2;
	}
	public String getCause3() {
		return cause3;
	}
}
