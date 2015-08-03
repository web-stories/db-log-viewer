package org.webstories.dblogviewer.arguments;

public class MandatoryArgumentNotFoundException extends Exception {
	private static final long serialVersionUID = 1;
	public MandatoryArgumentNotFoundException( String argument ) {
		super( "Argument '" +  argument + "' is mandatory!" );
	}
}
