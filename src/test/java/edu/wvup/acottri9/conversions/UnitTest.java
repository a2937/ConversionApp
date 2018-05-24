package edu.wvup.acottri9.conversions;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A unit tests , which will execute on the development machine (host).
 * Instantiates a new converter object and tests default values.
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTest
{
    @Test
    public void testConverterClass() throws Exception
    {
        Converter converter = new Converter();
        assertNotNull(converter);
        assertEquals(converter.getMode(),ConvertModes.values()[1]);
		assertEquals(converter.getFormattedInitial(),"0.00");
    }
}