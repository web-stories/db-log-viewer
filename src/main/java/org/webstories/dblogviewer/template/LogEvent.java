package org.webstories.dblogviewer.template;

import org.webstories.dblogviewer.template.orm.AccessRecord;
import org.webstories.dblogviewer.template.orm.ExceptionRecord;
import org.webstories.dblogviewer.template.orm.UserRecord;

public interface LogEvent {
	AccessRecord getAccess();
	ExceptionRecord getException();
	UserRecord getUser();
}
