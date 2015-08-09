package org.webstories.dblogviewer.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringParts {
	private List<String> parts = new ArrayList<>();
	public StringParts( String... parts ) {
		this.parts = new ArrayList<String>( Arrays.asList( parts ) );
	}
	public StringParts add( String part ) {
		parts.add( part );
		return this;
	}
	public String join( String delimiter ) {
		String result = "";
		for ( int i = 0; i < parts.size(); i++ ) {
			result += parts.get( i );
			if ( i != parts.size() - 1 ) {
				result += delimiter;
			}
		}
		return result;
	}
}
