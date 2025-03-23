package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = 224588035;
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = Phongsin;
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
        System.out .println("----------");
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        System.out .println("----------");
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
        System.out .println("----------");
	}
	
	/*
	 * Complete below test cases.
	 */
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		// Code here
	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		// Code here
	}
	
	/*
	 * Write tests for rest months of year 2024.
	 */
	@Test
	public void testCase1B() {
		System.out.println("Test1B");
		DateUtil date = new DateUtil(1, 6, 1994);
		System.out.println("june1ShouldIncrementToJune2 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        System.out .println("----------");
	}
	
	@Test
	public void testCase2B() {
		System.out.println("Test2B");
		DateUtil date = new DateUtil(2, 6, 1994);
		System.out.println("june2ShouldIncrementToJune3 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(3, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        System.out .println("----------");
	}
	
	@Test
	public void testCase3B() {
		System.out.println("Test3B");
		DateUtil date = new DateUtil(15, 6, 1994);
		System.out.println("june15ShouldIncrementToJune16 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        System.out .println("----------");
	}
	
	@Test
	public void testCase4B() {
		System.out.println("Test4B");
		DateUtil date = new DateUtil(30, 6, 1994);
		System.out.println("june30ShouldIncrementToJuly1 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(7, date.getMonth());
        System.out .println("----------");
	}
	
	@Test
	public void testCase5B() {
		System.out.println("Test5B");
		try {
            DateUtil date = new DateUtil(31, 6, 1994);
            Assert.fail("Expected RuntimeException was not thrown");
        } catch (RuntimeException e) {
            System.out.println("Invalid Date (June only have 30 days)");
            System.out.println(e.getMessage());
            System.out .println("----------");
        }
	}
	
	@Test
	public void testCase6B() {
		System.out.println("Test6B");
		DateUtil date = new DateUtil(15, 1, 1994);
		System.out.println("january15ShouldIncrementToJanuary16 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        System.out .println("----------");
	}
	
	@Test
	public void testCase7B() {
		System.out.println("Test7B");
		DateUtil date = new DateUtil(15, 2, 1994);
		System.out.println("febuary15ShouldIncrementToFebuary16 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        System.out .println("----------");
	}
	
	@Test
	public void testCase8B() {
		System.out.println("Test8B");
		DateUtil date = new DateUtil(15, 11, 1994);
		System.out.println("november15ShouldIncrementToNovember16 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(11, date.getMonth());
        System.out .println("----------");
	}
	
	@Test
	public void testCase9B() {
		System.out.println("Test9B");
		DateUtil date = new DateUtil(15, 12, 1994);
		System.out.println("december15ShouldIncrementToDecember16 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        System.out .println("----------");
	}
	
	@Test
	public void testCase10B() {
		System.out.println("Test10B");
		DateUtil date = new DateUtil(15, 6, 1700);
		System.out.println("june15ShouldIncrementToJune16 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        System.out .println("----------");
	}
	
	@Test
	public void testCase11B() {
		System.out.println("Test11B");
		DateUtil date = new DateUtil(15, 6, 1701);
		System.out.println("june15ShouldIncrementToJune16 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        System.out .println("----------");
	}
	
	@Test
	public void testCase12B() {
		System.out.println("Test12B");
		DateUtil date = new DateUtil(15, 6, 2023);
		System.out.println("june15ShouldIncrementToJune16 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        System.out .println("----------");
	}
	
	@Test
	public void testCase13B() {
		System.out.println("Test13B");
		DateUtil date = new DateUtil(15, 6, 1994);
		System.out.println("june15ShouldIncrementToJune16 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        System.out .println("----------");
	}
	
	//Additional test case for Febuary with a leap year condition.
	@Test
    public void testFebruary28_2024_Increment_NonLeap() {
        DateUtil date = new DateUtil(28, 2, 2024); // 2024 IS a leap year
        System.out.println("February 28, 2024 increment test > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        System.out .println("----------");
    }
	
	@Test
    public void testFebruary29_2024_Increment_Leap() {
        DateUtil date = new DateUtil(29, 2, 2024); // 2024 IS a leap year
        System.out.println("February 29, 2024 increment test > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        System.out .println("----------");
    }
	
	@Test
    public void testFebruary28_2023_Increment_NonLeap() {
        DateUtil date = new DateUtil(28, 2, 2023); // 2023 is NOT a leap year
        System.out.println("February 28, 2023 increment test > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        System.out .println("----------");
    }
	
	@Test
    public void testFebruaryInvalidDay_Leap() {
        try {
            DateUtil date = new DateUtil(30, 2, 2024); // 2024 is a leap year
            Assert.fail("Expected RuntimeException was not thrown");
        } catch (RuntimeException e) {
            System.out.println("Invalid Date (February 2024 only has 29 days)");
            System.out.println(e.getMessage());
            System.out .println("----------");
        }
    }

}
