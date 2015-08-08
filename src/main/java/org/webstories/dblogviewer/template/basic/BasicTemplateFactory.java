package org.webstories.dblogviewer.template.basic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.webstories.dblogviewer.sql.GeneralSQLQuery;
import org.webstories.dblogviewer.sql.SQLExecutor;
import org.webstories.dblogviewer.sql.SQLQuery;
import org.webstories.dblogviewer.template.LogEvent;
import org.webstories.dblogviewer.template.TemplateExecutionException;
import org.webstories.dblogviewer.template.TemplateFactory;
import org.webstories.dblogviewer.template.TemplateOutput;
import org.webstories.dblogviewer.template.orm.AccessRecord;
import org.webstories.dblogviewer.template.orm.ExceptionRecord;
import org.webstories.dblogviewer.template.orm.UserRecord;
import org.webstories.dblogviewer.utils.StringParts;

public class BasicTemplateFactory extends TemplateFactory {
	public BasicTemplateFactory( SQLExecutor sqlExecutor ) {
		super( sqlExecutor );
	}
	@Override
	public TemplateOutput createOutput() throws TemplateExecutionException {
		StringParts queryParts = new StringParts(
			"SELECT *",
			"FROM ws_access",
				"LEFT OUTER JOIN ws_user ON ws_user.id_user = ws_access.id_user",
				"LEFT OUTER JOIN ws_exception ON ws_access.id_log = ws_exception.id_log",
			"ORDER BY ws_access.id_log ASC"
		);
		SQLQuery query = new GeneralSQLQuery( queryParts.join( " " ) );
		List<LogEvent> logs = new ArrayList<>();
		try {
			ResultSet result = sqlExecutor.list( query );
			while ( result.next() ) {
				LogEvent log = new BasicLogEvent(
					new AccessRecord( result ),
					new ExceptionRecord( result ),
					new UserRecord( result )
				);
				logs.add( log );
			}
		} catch ( SQLException e ) {
			throw new TemplateExecutionException( e );
		}
		return new BasicTemplateOutput( logs );
	}
}
