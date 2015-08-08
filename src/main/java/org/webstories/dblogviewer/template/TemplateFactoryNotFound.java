package org.webstories.dblogviewer.template;

public class TemplateFactoryNotFound extends Exception {
	private static final long serialVersionUID = 1;
	public TemplateFactoryNotFound( TemplateMetadata templateMetadata ) {
		super( "Factory implementation for template '" + templateMetadata.getTemplateName() + "' not found!" );
	}
}
