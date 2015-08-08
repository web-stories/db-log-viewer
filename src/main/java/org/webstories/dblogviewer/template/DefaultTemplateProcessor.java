package org.webstories.dblogviewer.template;

import org.webstories.dblogviewer.arguments.TemplateArguments;
import org.webstories.dblogviewer.sql.SQLExecutor;
import org.webstories.dblogviewer.template.basic.BasicTemplateFactory;

public class DefaultTemplateProcessor implements TemplateProcessor {
	private SQLExecutor sqlExecutor;
	private TemplateMetadata templateMetadata;
	public DefaultTemplateProcessor( TemplateArguments arguments, SQLExecutor sqlExecutor ) {
		this.sqlExecutor = sqlExecutor;
		try {
			this.templateMetadata = TemplateMetadata.forName( arguments.retrieveTemplateName() );
		} catch ( TemplateNotFoundException e ) {
			this.templateMetadata = TemplateMetadata.BASIC;
		}
	}
	@Override
	public TemplateResult executeTemplate() throws TemplateFactoryNotFound, TemplateExecutionException {
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
