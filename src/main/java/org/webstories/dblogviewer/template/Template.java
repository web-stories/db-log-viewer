package org.webstories.dblogviewer.template;

public enum Template {
	BASIC( "basic" );
	private String name;
	private Template( String name ) {
		this.name = name;
	}
	public static Template forName( String templateName ) throws TemplateNotFoundException {
		for ( int i = 0; i < Template.values().length; i++ ) {
			Template template = Template.values()[ i ];
			if ( template.name.equals( templateName ) ) {
				return template;
			}
		}
		throw new TemplateNotFoundException( templateName );
	}
}
