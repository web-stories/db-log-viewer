package org.webstories.dblogviewer.template.basic;

import java.util.List;

import org.webstories.dblogviewer.template.LogEvent;
import org.webstories.dblogviewer.template.TemplateOutput;

public class BasicTemplateOutput implements TemplateOutput {
	private List<LogEvent> logs;
	public BasicTemplateOutput( List<LogEvent> logs ) {
		this.logs = logs;
	}
	@Override
	public CharSequence toCharSequence() {
		// TODO print all data
		return logs.size() + " log occurrences";
	}
}
