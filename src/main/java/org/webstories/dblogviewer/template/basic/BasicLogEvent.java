package org.webstories.dblogviewer.template.basic;

import org.webstories.dblogviewer.template.LogEvent;
import org.webstories.dblogviewer.template.orm.AccessRecord;
import org.webstories.dblogviewer.template.orm.ExceptionRecord;
import org.webstories.dblogviewer.template.orm.UserRecord;

public class BasicLogEvent implements LogEvent {
	private AccessRecord access;
	private ExceptionRecord exception;
	private UserRecord user;
	public BasicLogEvent( AccessRecord access, ExceptionRecord exception, UserRecord user ) {
		this.access = access;
		this.exception = exception;
		this.user = user;
	}
	@Override
	public AccessRecord getAccess() {
		return access;
	}
	@Override
	public ExceptionRecord getException() {
		return exception;
	}
	@Override
	public UserRecord getUser() {
		return user;
	}
}
