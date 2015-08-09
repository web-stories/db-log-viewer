package org.webstories.dblogviewer.template.datafield;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogDataFieldWrapper implements LogRequestHeader, LogRequestParameters {
	private List<String> lines;
	private String dataField;
	public LogDataFieldWrapper( String dataField ) {
		this.lines = new ArrayList<String>( Arrays.asList( dataField.split( "\n" ) ) );
		this.dataField = dataField;
	}
	@Override
	public String requestedPath() {
		String firstLine = lines.get( 0 );
		String[] sections = firstLine.split( " " );
		String requestedPath = sections[ 1 ];
		return requestedPath;
	}
	@Override
	public String originalRequestPath() {
		String firstLine = lines.get( 0 );
		String[] sections = firstLine.split( " " );
		String originalRequestPath = sections[ 3 ];
		return originalRequestPath;
	}
	@Override
	public String queryString() {
		String[] blocks = dataField.split( "\n\n" );
		if ( blocks.length == 3 ) {
			return blocks[ 2 ];
		}
		return "(Empty query)";
	}
}
