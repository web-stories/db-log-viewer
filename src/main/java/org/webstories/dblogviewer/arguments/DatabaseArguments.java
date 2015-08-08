package org.webstories.dblogviewer.arguments;

public interface DatabaseArguments {
	String retrieveHost() throws MandatoryArgumentNotFoundException;
	String retrieveUsername() throws MandatoryArgumentNotFoundException;
	String retrievePassword() throws MandatoryArgumentNotFoundException;
}
