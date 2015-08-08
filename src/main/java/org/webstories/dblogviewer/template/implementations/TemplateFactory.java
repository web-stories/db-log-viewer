package org.webstories.dblogviewer.template.implementations;

import org.webstories.dblogviewer.sql.SQLExecutor;
import org.webstories.dblogviewer.template.TemplateOutput;

public abstract class TemplateFactory {
	protected SQLExecutor sqlExecutor;
	public TemplateFactory( SQLExecutor sqlExecutor ) {
		this.sqlExecutor = sqlExecutor;
	};
	public abstract TemplateOutput createOutput();
}
