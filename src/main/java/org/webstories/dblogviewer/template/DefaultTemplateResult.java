package org.webstories.dblogviewer.template;

public class DefaultTemplateResult implements TemplateResult {
	TemplateOutput output;
	public DefaultTemplateResult( Template template ) {
		this.output = template.getOutput();
	}
	@Override
	public TemplateOutput toOutput() {
		return output;
	}
}
