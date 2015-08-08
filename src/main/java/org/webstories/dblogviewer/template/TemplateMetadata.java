package org.webstories.dblogviewer.template;

public enum TemplateMetadata {
	BASIC( "basic" );
	private String name;
	private TemplateMetadata( String name ) {
		this.name = name;
	}
	public String getTemplateName() {
		return name;
	}
	public static TemplateMetadata forName( String templateName ) throws TemplateNotFoundException {
		for ( int i = 0; i < TemplateMetadata.values().length; i++ ) {
			TemplateMetadata template = TemplateMetadata.values()[ i ];
			if ( template.name.equals( templateName ) ) {
				return template;
			}
		}
		throw new TemplateNotFoundException( templateName );
	}
}
