package org.webstories.dblogviewer.template.basic;

import org.webstories.dblogviewer.template.LogEvent;

class BasicTextRowFactory {
	private LogEvent log;
	BasicTextRowFactory( LogEvent log ) {
		this.log = log;
	}
	String createIdLogField() {
		return log.getAccess().getIdLog().toString();
	};
	String createUserField() {
		String userField = log.getUser().getUsername();
		if ( userField == null ) {
			userField = "Anonymous";
		}
		return userField;
	};
	String createIpField() {
		return log.getAccess().getIp();
	};
	String createDataField() {
		return log.getAccess().getData();
	};
	String createExceptionField() {
		String exception = log.getException().getException();
		if ( exception == null ) {
			exception = "No exception";
		}
		return exception;
	};
}
