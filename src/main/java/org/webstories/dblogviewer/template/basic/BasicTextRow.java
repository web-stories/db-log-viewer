package org.webstories.dblogviewer.template.basic;

import org.webstories.dblogviewer.utils.StringParts;

class BasicTextRow {
	private String idLogField;
	private String dateField;
	private String userField;
	private String ipField;
	private String dataField;
	private String exceptionField;
	BasicTextRow( BasicTextRowFactory factory ) {
		this.idLogField = factory.createIdLogField();
		this.dateField = factory.createDate();
		this.userField = factory.createUserField();
		this.ipField = factory.createIpField();
		this.dataField = factory.createDataField();
		this.exceptionField = factory.createExceptionField();
	}
	@Override
	public String toString() {
		StringParts columns = new StringParts();
		columns.add( dateField + ":" );
		columns.add( "Log id: " + idLogField );
		columns.add( "User: " + userField );
		columns.add( "IP: " + ipField );
		columns.add( "Request: " + dataField.split( "\n" )[ 0 ] );
		columns.add( "Exception: " + exceptionField.split( "\n" )[ 0 ] );
		return columns.join( "\n" );
	}
}
