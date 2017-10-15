package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Assert;

public class CalculatorTest
{
	@Test
	public void testEmptyString()
	{
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber()
	{
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumber()
	{
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testMultiplesNumbers()
	{
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
	public void testNewLineDelimiter()
	{
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Test
	public void testNegativeNumberThrowsException()
	{
		try
		{
			Calculator.add("-1,3,1");
			Assert.fail();
		}
		catch (Exception e)
		{
			String messageExpected = "Negatives not allowed: -1";
			assertEquals(messageExpected, e.getMessage());
		}
	}

	@Test
	public void testNegativeNumbersThrowException()
	{
		try
		{
			Calculator.add("-1,-2,9,-3");
			Assert.fail();
		}
		catch (Exception e)
		{
			String messageExpected = "Negatives not allowed: -1,-2,-3";
			assertEquals(messageExpected, e.getMessage());
		}
	}

}