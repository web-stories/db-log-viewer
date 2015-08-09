package org.webstories.dblogviewer.template.failure;

import java.util.Arrays;

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
		boolean ignoredIp = Arrays.asList(
			"69.64.84.27"
		).contains( log.getAccess().getIp() );
		if ( ignoredIp ) {
			return true;
		}
		if ( dataField.originalRequestPath().startsWith( "/static" ) ) {
			return true;
		}
		Long logDate = log.getAccess().getDateInc();
		if ( logDate != null ) {
			long dateAround90DaysAgo = System.currentTimeMillis() - (1000L * 60L * 60L * 24L * 90L);
			if ( logDate < dateAround90DaysAgo ) {
				return true;
			}
		}
		return false;
	}
}
