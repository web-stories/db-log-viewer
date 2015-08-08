package org.webstories.dblogviewer.template;

public interface TemplateProcessor {
	TemplateResult executeTemplate() throws TemplateFactoryNotFound, TemplateExecutionException;
}
