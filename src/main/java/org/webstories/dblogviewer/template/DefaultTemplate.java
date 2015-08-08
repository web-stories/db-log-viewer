package org.webstories.dblogviewer.template;

import org.webstories.dblogviewer.template.basic.TemplateFactory;

public class DefaultTemplate implements Template {
	private TemplateOutput output;
	public DefaultTemplate( TemplateFactory factory ) throws TemplateExecutionException {
		this.output = factory.createOutput();
	}
	@Override
	public TemplateOutput getOutput() {
		return output;
	}
}
