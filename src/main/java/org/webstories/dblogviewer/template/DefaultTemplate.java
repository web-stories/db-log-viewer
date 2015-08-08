package org.webstories.dblogviewer.template;

import org.webstories.dblogviewer.template.implementations.TemplateFactory;

public class DefaultTemplate implements Template {
	private TemplateOutput output;
	public DefaultTemplate( TemplateFactory factory ) {
		this.output = factory.createOutput();
	}
	@Override
	public TemplateOutput getOutput() {
		return output;
	}
}
