package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "224588035";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Phongsin";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	
	@Test
	public void testTrueNumberIsEven() {
		Assert.assertTrue(WeatherAndMathUtils.isEven(4));
	}

	@Test
	public void testFalseNumberIsEven() {
		Assert.assertFalse(WeatherAndMathUtils.isEven(3));
	}

	@Test
	public void testPrimeNumberTrue() {
		Assert.assertTrue(WeatherAndMathUtils.isPrime(3));
	}

	@Test
	public void testPrimeNumberFalseEven() {
		Assert.assertFalse(WeatherAndMathUtils.isPrime(4));
	}

	@Test
	public void testPrimeNumberTrueOdd() {
		Assert.assertTrue(WeatherAndMathUtils.isPrime(7));
	}

	@Test
	public void testPrimeNumberFalseOdd() {
		Assert.assertFalse(WeatherAndMathUtils.isPrime(9));
	}
	
    @Test
    public void testCancelWeatherAdvice() {
    	Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeInputThrowsException() {
    	WeatherAndMathUtils.weatherAdvice(-1, 2);
    }

    @Test
    public void testAllClearWeatherAdvice() {
    	Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(10.0, 2.0));
    }

    @Test
    public void testWarnWeatherAdviceWindOnly() {
    	Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(50.0, 2.0));
    }

    @Test
    public void testWarnWeatherAdviceRainOnly() {
    	Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(30.0, 5.0));
    }

    @Test
    public void testCancelWeatherAdviceRainOnly() {
    	Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(10.0, 7.0));
    }

    @Test
    public void testCancelWeatherAdviceWindAndRainCombo() {
    	Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(50.1, 4.1));
    }
    
    
    
    @Test
	public void testSumToN() {
		Assert.assertEquals(15, WeatherAndMathUtils.sumToN(5));
	}

	@Test
	public void testSumToZero() {
		Assert.assertEquals(0, WeatherAndMathUtils.sumToN(0));
	}

	@Test
	public void testCountEvenToN() {
		Assert.assertEquals(2, WeatherAndMathUtils.countEvenToN(5));
	}

	@Test
	public void testCountEvenToZero() {
		Assert.assertEquals(0, WeatherAndMathUtils.countEvenToN(0));
	}
}
