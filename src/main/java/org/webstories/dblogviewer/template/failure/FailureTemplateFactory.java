package org.webstories.dblogviewer.template.failure;

import org.webstories.dblogviewer.sql.SQLExecutor;
import org.webstories.dblogviewer.template.basic.BasicTemplateFactory;

public class FailureTemplateFactory extends BasicTemplateFactory {
	public FailureTemplateFactory( SQLExecutor sqlExecutor ) {
		super( sqlExecutor, new FailureEventsFilter() );
	}
}
