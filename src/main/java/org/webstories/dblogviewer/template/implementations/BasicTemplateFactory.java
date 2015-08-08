package org.webstories.dblogviewer.template.implementations;

import org.webstories.dblogviewer.sql.SQLExecutor;
import org.webstories.dblogviewer.template.TemplateOutput;

public class BasicTemplateFactory extends TemplateFactory {
	public BasicTemplateFactory( SQLExecutor sqlExecutor ) {
		super( sqlExecutor );
	}
	@Override
	public TemplateOutput createOutput() {
		// TODO
		return null;
	}
}
