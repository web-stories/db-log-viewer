package org.webstories.dblogviewer.template.failure;

import org.webstories.dblogviewer.template.LogEvent;
import org.webstories.dblogviewer.template.LogEventsFilter;
import org.webstories.dblogviewer.template.datafield.LogDataFieldWrapper;

class FailureEventsFilter implements LogEventsFilter {
	@Override
	public boolean ignore( LogEvent log ) {
		LogDataFieldWrapper dataField = new LogDataFieldWrapper( log.getAccess().getData() );
		if ( "fagner.brack".equals( log.getUser().getUsername() ) ) {
			return true;
		}
		if ( "/error/sc-404".equals( dataField.requestedPath() ) ) {
			return true;
		}
		String exception = log.getException().getException();
		if ( exception != null && exception.contains( "UserNotLoggedException" ) ) {
			return true;
		}
		return false;
	}
}
