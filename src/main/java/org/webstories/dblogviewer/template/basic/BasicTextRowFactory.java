package org.webstories.dblogviewer.template.basic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.webstories.dblogviewer.template.LogEvent;
import org.webstories.dblogviewer.template.datafield.LogDataFieldWrapper;

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
	String createDate() {
		Long dateMillis = log.getAccess().getDateInc();
		if ( dateMillis == null ) {
			return "(Undefined date)";
		}
		DateFormat dateFormat = new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss 'GMT' Z" );
		return dateFormat.format( dateMillis );
	}
	String createQuerystring() {
		String dataField = log.getAccess().getData();
		LogDataFieldWrapper dataWrapper = new LogDataFieldWrapper( dataField );
		return dataWrapper.queryString();
	}
}
