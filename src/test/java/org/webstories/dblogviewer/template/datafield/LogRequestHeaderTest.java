package org.webstories.dblogviewer.template.datafield;

import org.junit.Assert;
import org.junit.Test;

public class LogRequestHeaderTest {
	@Test
	public void should_retrieve_the_requested_path() {
		LogRequestHeader content = new LogDataFieldWrapper(
			"GET /error/sc-404 ( /original-page ) HTTP/1.1"
		);
		String actual = content.requestedPath();
		String expected = "/error/sc-404";
		Assert.assertEquals( expected, actual );
	}
	@Test
	public void should_retrieve_the_original_requested_path() {
		LogRequestHeader content = new LogDataFieldWrapper(
			"GET /error/sc-404 ( /original-page ) HTTP/1.1"
		);
		String actual = content.originalRequestPath();
		String expected = "/original-page";
		Assert.assertEquals( expected, actual );
	}
}
