package org.webstories.dblogviewer.utils;

import org.junit.Assert;
import org.junit.Test;

public class StringPartsTest {
	@Test
	public void should_join_strings() {
		StringParts parts = new StringParts( "a", "b" );
		String actual = parts.join( " " );
		String expected = "a b";
		Assert.assertEquals( expected, actual );
	}
}
