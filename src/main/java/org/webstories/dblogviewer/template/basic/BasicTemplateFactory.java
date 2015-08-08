package org.webstories.dblogviewer.template.basic;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.webstories.dblogviewer.sql.GeneralSQLQuery;
import org.webstories.dblogviewer.sql.SQLExecutor;
import org.webstories.dblogviewer.sql.SQLQuery;
import org.webstories.dblogviewer.template.TemplateExecutionException;
import org.webstories.dblogviewer.template.TemplateOutput;
import org.webstories.dblogviewer.utils.StringParts;

public class BasicTemplateFactory extends TemplateFactory {
	public BasicTemplateFactory( SQLExecutor sqlExecutor ) {
		super( sqlExecutor );
	}
	@Override
	public TemplateOutput createOutput() throws TemplateExecutionException {
		StringParts queryParts = new StringParts(
			"SELECT",
				"ws_access.id_log, ws_user.ds_username, ws_access.id_user, ws_access.ds_ip, ws_access.ds_data, ws_exception.ds_exception, ws_exception.ds_cause, ws_exception.ds_cause2",
			"FROM ws_access",
				"LEFT OUTER JOIN ws_user ON ws_user.id_user = ws_access.id_user",
				"LEFT OUTER JOIN ws_exception ON ws_access.id_log = ws_exception.id_log",
			"ORDER BY ws_access.id_log ASC"
		);
		SQLQuery query = new GeneralSQLQuery( queryParts.join( " " ) );
		try {
			ResultSet result = sqlExecutor.list( query );
			while ( result.next() ) {
				// TODO
			}
		} catch ( SQLException e ) {
			throw new TemplateExecutionException( e );
		}
		return null;
	}
}
