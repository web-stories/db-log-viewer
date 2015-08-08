package org.webstories.dblogviewer.sql;

public class GeneralSQLQuery implements SQLQuery {
	private String query;
	public GeneralSQLQuery( String query ) {
		this.query = query;
	}
	@Override
	public String toString() {
		return query;
	}
}
