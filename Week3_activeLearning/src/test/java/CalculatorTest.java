import org.junit.Test;
import org.junit.Assert;

public class CalculatorTest {
	private Calculator calculator = new Calculator();
	
	@Test
	public void testAddValidIntegersZeroZero() {
		Assert.assertEquals(calculator.add(0, 0), 0);
	}
	
	@Test
	public void testAddValidIntegersZeroNonZero() {
		Assert.assertEquals(calculator.add(0, 2), 2);
	}
	
	@Test
	public void testAddValidIntegersNonZeroZero() {
		Assert.assertEquals(calculator.add(2, 0), 2);
	}
	
	@Test
	public void testAddValidIntegersNegativeZero() {
		Assert.assertEquals(calculator.add(-2, 0), -2);
	}
	
	@Test
	public void testAddValidIntegersZeroNegative() {
		Assert.assertEquals(calculator.add(0, -2), -2);
	}
	
	@Test
	public void testAddValidIntegersBigNormal() {
		Assert.assertEquals(calculator.add(10000000, 2), 10000002);
	}
	
	@Test
	public void testAddValidIntegersNormalBig() {
		Assert.assertEquals(calculator.add(2, 10000000), 10000002);
	}
	
	@Test
	public void testAddValidIntegersDecimalInteger() {
		Assert.assertEquals(calculator.add(2.1, 2), 4.1);
	}
	
	@Test
	public void testAddValidIntegersIntegerDecimal() {
		Assert.assertEquals(calculator.add(2, 2.1), 4.1);
	}
	
	@Test
	public void testAddValidIntegersDecimalDecimal() {
		Assert.assertEquals(calculator.add(2.1, 2.1), 4.2);
	}
	
	@Test
	public void testConcatCharChar() {
		Assert.assertEquals(calculator.concat("0", "0"), "00");
	}
	
	@Test
	public void testConcatCharEmpty() {
		Assert.assertEquals(calculator.concat("0", ""), "0");
	}
	
	@Test
	public void testConcatNullChar() {
		Assert.assertEquals(calculator.concat(null, "0"), "null0");
	}
	
	@Test
	public void testConcatCharNull() {
		Assert.assertEquals(calculator.concat("0", null), "0null");
	}
	
	@Test
	public void testConcatNullNull() {
		Assert.assertEquals(calculator.concat(null, null), "nullnull");
	}
	
	
	
	//Below this is the test case generate from ChatGPT
	@Test
	public void testAddValidIntegersNegativeNegative() {
	    Assert.assertEquals(calculator.add(-2, -3), -5);
	}

	@Test
	public void testAddValidIntegersLargeNegativeLargePositive() {
	    Assert.assertEquals(calculator.add(-1000000, 1000000), 0);
	}

	@Test
	public void testAddValidIntegersMaxMin() {
	    Assert.assertEquals(calculator.add(Integer.MAX_VALUE, Integer.MIN_VALUE), -1);
	}

	@Test
	public void testAddValidIntegersMaxZero() {
	    Assert.assertEquals(calculator.add(Integer.MAX_VALUE, 0), Integer.MAX_VALUE);
	}

	@Test
	public void testAddValidIntegersMinZero() {
	    Assert.assertEquals(calculator.add(Integer.MIN_VALUE, 0), Integer.MIN_VALUE);
	}

	@Test
	public void testConcatEmptyEmpty() {
	    Assert.assertEquals(calculator.concat("", ""), "");
	}

	@Test
	public void testConcatStringEmpty() {
	    Assert.assertEquals(calculator.concat("Hello", ""), "Hello");
	}

	@Test
	public void testConcatEmptyString() {
	    Assert.assertEquals(calculator.concat("", "World"), "World");
	}

	@Test
	public void testConcatSpecialCharacters() {
	    Assert.assertEquals(calculator.concat("@#$", "%^&"), "@#$%^&");
	}

	@Test
	public void testConcatWhitespace() {
	    Assert.assertEquals(calculator.concat("Hello", " World"), "Hello World");
	}

}
