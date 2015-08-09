package org.webstories.dblogviewer.arguments;

import org.junit.Assert;
import org.junit.Test;

public class LogViewerArgumentsTest {
	@Test
	public void should_retrieve_a_couple_of_arguments() throws MandatoryArgumentNotFoundException {
		String[] argument = new String[] {
			"-host=10.10.1.122",
			"-username=postgres"
		};
		LogViewerArguments arguments = new LogViewerArguments( argument );
		
		String actual = arguments.retrieveHost();
		String expected = "10.10.1.122";
		Assert.assertEquals( expected, actual );
		
		actual = arguments.retrieveUsername();
		expected = "postgres";
		Assert.assertEquals( expected, actual );
	}
}
