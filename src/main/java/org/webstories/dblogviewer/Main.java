package org.webstories.dblogviewer;

import java.sql.SQLException;
import java.util.logging.Logger;

import org.webstories.dblogviewer.arguments.LogViewerArguments;
import org.webstories.dblogviewer.arguments.MandatoryArgumentNotFoundException;
import org.webstories.dblogviewer.sql.PostgreSQLExecutor;
import org.webstories.dblogviewer.template.DefaultTemplateProcessor;
import org.webstories.dblogviewer.template.TemplateExecutionException;
import org.webstories.dblogviewer.template.TemplateFactoryNotFound;

public class Main {
	private static Logger LOGGER = Logger.getLogger( "org.webstories.dblogviewer" );
	public static void main( String[] args ) throws SQLException, TemplateFactoryNotFound, TemplateExecutionException {
		try {
			LogViewerArguments arguments = new LogViewerArguments( args );
			CharSequence result = new DefaultTemplateProcessor(
					arguments,
					new PostgreSQLExecutor( arguments )
				)
				.executeTemplate()
				.toOutput()
				.toCharSequence();
			System.out.println( result );
		} catch ( MandatoryArgumentNotFoundException e ) {
			LOGGER.severe( e.getMessage() );
		}
	}
}
