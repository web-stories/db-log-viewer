package org.webstories.dblogviewer.template.basic;

import java.util.List;

import org.webstories.dblogviewer.template.LogEvent;
import org.webstories.dblogviewer.template.TemplateOutput;
import org.webstories.dblogviewer.utils.StringParts;

public class BasicTemplateOutput implements TemplateOutput {
	private List<LogEvent> logs;
	public BasicTemplateOutput( List<LogEvent> logs ) {
		this.logs = logs;
	}
	@Override
	public CharSequence toCharSequence() {
		StringParts parts = new StringParts( logs.size() + " log occurrences\n\n-----\n" );
		for ( LogEvent log : logs ) {
			BasicTextRow line = new BasicTextRow( new BasicTextRowFactory( log ) );
			parts.add( line.toString() );
			parts.add( "\n" );
		}
		return parts.join( "\n" );
	}
}
