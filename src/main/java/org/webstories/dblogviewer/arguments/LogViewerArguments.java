package org.webstories.dblogviewer.arguments;

public class LogViewerArguments implements DatabaseArguments, FileArguments {
	private String[] args;
	public LogViewerArguments( String[] args ) {
		this.args = args;
	}
	public String retrieveOutputFile() throws MandatoryArgumentNotFoundException {
		return retrieveMandatoryValue( "out" );
	}
	public String retrieveIp() throws MandatoryArgumentNotFoundException {
		return retrieveMandatoryValue( "ip" );
	}
	public String retrieveUsername() throws MandatoryArgumentNotFoundException {
		return retrieveMandatoryValue( "username" );
	}
	public String retrievePassword() throws MandatoryArgumentNotFoundException {
		return retrieveMandatoryValue( "password" );
	}
	private String retrieveMandatoryValue( String key ) throws MandatoryArgumentNotFoundException {
		key = "-" + key;
		for ( String argument : args ) {
			if ( !argument.contains( "=" ) ) {
				continue;
			}
			String[] pair = argument.split( "=" );
			if ( pair.length != 2 ) {
				continue;
			}
			if ( key.equals( pair[ 0 ] ) ) {
				return pair[ 1 ];
			}
		}
		throw new MandatoryArgumentNotFoundException( key );
	}
}
