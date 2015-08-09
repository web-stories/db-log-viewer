package org.webstories.dblogviewer.template;

public class TemplateFactoryNotFound extends Exception {
	private static final long serialVersionUID = 1;
	public TemplateFactoryNotFound( String templateArgument ) {
		super( "Factory implementation for template '" + templateArgument + "' not found!" );
	}
}
