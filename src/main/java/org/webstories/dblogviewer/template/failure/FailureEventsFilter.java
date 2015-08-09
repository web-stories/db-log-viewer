package org.webstories.dblogviewer.template.failure;

import org.webstories.dblogviewer.template.LogEvent;
import org.webstories.dblogviewer.template.LogEventsFilter;

class FailureEventsFilter implements LogEventsFilter {
	@Override
	public boolean ignore( LogEvent log ) {
		if ( "fagner.brack".equals( log.getUser().getUsername() ) ) {
			return true;
		}
		return false;
	}
}
