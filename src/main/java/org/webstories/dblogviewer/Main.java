package org.webstories.dblogviewer;

import java.sql.SQLException;

import org.webstories.dblogviewer.arguments.LogViewerArguments;
import org.webstories.dblogviewer.arguments.MandatoryArgumentNotFoundException;
import org.webstories.dblogviewer.sql.PostgreSQLExecutor;
import org.webstories.dblogviewer.sql.SQLExecutor;
import org.webstories.dblogviewer.template.DefaultTemplateProcessor;
import org.webstories.dblogviewer.template.TemplateNotFoundException;
import org.webstories.dblogviewer.template.TemplateProcessor;
import org.webstories.dblogviewer.template.TemplateResult;

public class Main {
	public static void main( String[] args ) throws SQLException, MandatoryArgumentNotFoundException, TemplateNotFoundException {
		LogViewerArguments arguments = new LogViewerArguments( args );
		SQLExecutor sqlExecutor = new PostgreSQLExecutor( arguments );
		TemplateProcessor processor = new DefaultTemplateProcessor( arguments , sqlExecutor);
		TemplateResult result = processor.executeTemplate();
		System.out.println( result.toCharSequence() );
	}
}
