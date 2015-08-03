package org.webstories.dblogviewer.arguments;

public interface DatabaseArguments {
	String retrieveIp() throws MandatoryArgumentNotFoundException;
	String retrieveUsername() throws MandatoryArgumentNotFoundException;
	String retrievePassword() throws MandatoryArgumentNotFoundException;
}
