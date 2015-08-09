package org.webstories.dblogviewer.template.orm;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccessRecord {
	private Long idLog;
	private Long idUser;
	private String ip;
	private String data;
	private Long dateInc;
	public AccessRecord( ResultSet result ) throws SQLException {
		this.idLog = result.getLong( "id_log" );
		this.idUser = result.getLong( "id_user" );
		this.ip = result.getString( "ds_ip" );
		this.data = result.getString( "ds_data" );
		this.dateInc = result.getLong( "dt_inc" );
	}
	public Long getIdLog() {
		return idLog;
	}
	public Long getIdUser() {
		return idUser;
	}
	public String getIp() {
		return this.ip;
	}
	public String getData() {
		return this.data;
	}
	public Long getDateInc() {
		return this.dateInc;
	}
}
