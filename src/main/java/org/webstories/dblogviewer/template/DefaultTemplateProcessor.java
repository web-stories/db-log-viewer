package org.webstories.dblogviewer.template;

import org.webstories.dblogviewer.arguments.TemplateArguments;
import org.webstories.dblogviewer.sql.SQLExecutor;
import org.webstories.dblogviewer.template.implementations.BasicTemplateFactory;

public class DefaultTemplateProcessor implements TemplateProcessor {
	private SQLExecutor sqlExecutor;
	private TemplateMetadata templateMetadata;
	public DefaultTemplateProcessor( TemplateArguments arguments, SQLExecutor sqlExecutor ) throws TemplateNotFoundException {
		this.sqlExecutor = sqlExecutor;
		this.templateMetadata = TemplateMetadata.forName( arguments.retrieveTemplateName() );
	}
	@Override
	public TemplateResult executeTemplate() throws TemplateFactoryNotFound {
		Template template = null;
		switch ( templateMetadata ) {
			case BASIC:
				template = new DefaultTemplate( new BasicTemplateFactory( sqlExecutor ) );
				break;
		}
		if ( template == null ) {
			throw new TemplateFactoryNotFound( templateMetadata );
		}
		final Template finalTemplate = template;
		return new TemplateResult() {
			@Override
			public TemplateOutput toOutput() {
				return finalTemplate.getOutput();
			}
		};
	}
}
