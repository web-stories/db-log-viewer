package org.webstories.dblogviewer.utils;

public class StringParts {
	private String[] parts;
	public StringParts( String... parts ) {
		this.parts = parts;
	}
	public String join( String delimiter ) {
		String result = "";
		for ( int i = 0; i < parts.length; i++ ) {
			if ( i == 0 ) {
				continue;
			}
			result = delimiter + result;
		}
		return result;
	}
}
