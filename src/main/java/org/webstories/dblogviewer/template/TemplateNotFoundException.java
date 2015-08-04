package org.webstories.dblogviewer.template;

public class TemplateNotFoundException extends Exception {
	private static final long serialVersionUID = 1;
	public TemplateNotFoundException( String templateName ) {
		super( "Template not found: '" + templateName + "'" );
	}
}
