package org.webstories.dblogviewer.template;

public class NullEventsFilter implements LogEventsFilter {
	@Override
	public boolean ignore( LogEvent log ) {
		return false;
	}
}
