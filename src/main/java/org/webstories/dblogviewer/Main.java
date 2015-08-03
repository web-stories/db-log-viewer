package org.webstories.dblogviewer;

import java.sql.SQLException;

import org.webstories.dblogviewer.arguments.LogViewerArguments;
import org.webstories.dblogviewer.arguments.MandatoryArgumentNotFoundException;

public class Main {
	public static void main( String[] args ) throws SQLException, MandatoryArgumentNotFoundException {
		LogViewerArguments arguments = new LogViewerArguments( args );
		// TODO
	}
}
