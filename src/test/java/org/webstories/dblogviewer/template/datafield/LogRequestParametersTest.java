package org.webstories.dblogviewer.template.datafield;

import org.junit.Assert;
import org.junit.Test;
import org.webstories.dblogviewer.utils.StringParts;

public class LogRequestParametersTest {
	@Test
	public void should_retrieve_the_querystring() {
		LogRequestParameters content = new LogDataFieldWrapper(
			new StringParts()
				.add( "GET /error/sc-404 ( /original-page ) HTTP/1.1" )
				.add( "host: webstories.org" )
				.add( "param=1&other=2" )
			.join( "\n\n" )
		);
		String actual = content.queryString();
		String expected = "param=1&other=2";
		Assert.assertEquals( expected, actual );
	}
}
