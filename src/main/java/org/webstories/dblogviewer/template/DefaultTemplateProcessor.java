package org.webstories.dblogviewer.template;

import org.webstories.dblogviewer.arguments.TemplateArguments;
import org.webstories.dblogviewer.sql.SQLExecutor;

public class DefaultTemplateProcessor implements TemplateProcessor {
	private SQLExecutor sqlExecutor;
	private Template template;
	public DefaultTemplateProcessor( TemplateArguments arguments, SQLExecutor sqlExecutor ) throws TemplateNotFoundException {
		this.sqlExecutor = sqlExecutor;
		this.template = Template.forName( arguments.retrieveTemplateName() );
	}
	@Override
	public TemplateResult executeTemplate() {
		// TODO
		return null;
	}
}
