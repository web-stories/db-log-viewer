package org.webstories.dblogviewer.template;

import org.webstories.dblogviewer.sql.SQLExecutor;

public abstract class TemplateFactory {
	protected SQLExecutor sqlExecutor;
	public TemplateFactory( SQLExecutor sqlExecutor ) {
		this.sqlExecutor = sqlExecutor;
	};
	public abstract TemplateOutput createOutput() throws TemplateExecutionException;
}
