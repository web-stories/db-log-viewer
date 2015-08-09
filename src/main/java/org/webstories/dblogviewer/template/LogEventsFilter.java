package org.webstories.dblogviewer.template;

public interface LogEventsFilter {
	boolean ignore( LogEvent log );
}
