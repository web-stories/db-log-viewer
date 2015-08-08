package org.webstories.dblogviewer.arguments;

public class LogViewerArguments implements DatabaseArguments, FileArguments, TemplateArguments {
	private String[] args;
	public LogViewerArguments( String[] args ) {
		this.args = args;
	}
	@Override
	public String retrieveOutputFile() throws MandatoryArgumentNotFoundException {
		return retrieveMandatoryValue( "out" );
	}
	@Override
	public String retrieveHost() throws MandatoryArgumentNotFoundException {
		return retrieveMandatoryValue( "host" );
	}
	@Override
	public String retrieveUsername() throws MandatoryArgumentNotFoundException {
		return retrieveMandatoryValue( "username" );
	}
	@Override
	public String retrievePassword() throws MandatoryArgumentNotFoundException {
		return retrieveMandatoryValue( "password" );
	}
	@Override
	public String retrieveTemplateName() {
		return retrieveValue( "template" );
	}
	private String retrieveValue( String argument ) {
		argument = "-" + argument;
		for ( String current : args ) {
			if ( !current.contains( "=" ) ) {
				continue;
			}
			String[] pair = current.split( "=" );
			if ( pair.length != 2 ) {
				continue;
			}
			if ( argument.equals( pair[ 0 ] ) ) {
				return pair[ 1 ];
			}
		}
		return null;
	}
	private String retrieveMandatoryValue( String argument ) throws MandatoryArgumentNotFoundException {
		String value = retrieveValue( argument );
		if ( value == null ) {
			throw new MandatoryArgumentNotFoundException( argument );
		}
		return value;
	}
}
