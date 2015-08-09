package org.webstories.dblogviewer.template;

public enum TemplateMetadata {
	BASIC( "basic" ), NULL( "" );
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
		if ( templateName == null ) {
			return TemplateMetadata.NULL;
		}
		throw new TemplateNotFoundException( templateName );
	}
}
