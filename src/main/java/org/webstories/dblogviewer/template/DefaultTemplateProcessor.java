package org.webstories.dblogviewer.template;

import org.webstories.dblogviewer.arguments.TemplateArguments;
import org.webstories.dblogviewer.sql.SQLExecutor;
import org.webstories.dblogviewer.template.basic.BasicTemplateFactory;

public class DefaultTemplateProcessor implements TemplateProcessor {
	private SQLExecutor sqlExecutor;
	private TemplateMetadata templateMetadata;
	private String templateArgument;
	public DefaultTemplateProcessor( TemplateArguments templateArgs, SQLExecutor sqlExecutor ) {
		this.sqlExecutor = sqlExecutor;
		this.templateArgument = templateArgs.retrieveTemplateName();
		try {
			this.templateMetadata = TemplateMetadata.forName( templateArgs.retrieveTemplateName() );
		} catch ( TemplateNotFoundException e ) {}
	}
	@Override
	public TemplateResult executeTemplate() throws TemplateFactoryNotFound, TemplateExecutionException {
		Template template = null;
		if ( templateMetadata != null ) {
			switch ( templateMetadata ) {
				case BASIC:
				case NULL:
					template = new DefaultTemplate( new BasicTemplateFactory( sqlExecutor ) );
					break;
			}
		}
		if ( template == null ) {
			throw new TemplateFactoryNotFound( templateArgument );
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
