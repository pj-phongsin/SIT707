package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;

public class DateTimeUtilTest {

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
    public void testIncrementMinute_Normal() {
        DateTimeUtil dt = new DateTimeUtil(1, 1, 2024, 10, 30);
        dt.incrementMinute();
        Assert.assertEquals(31, dt.getMinute());
        Assert.assertEquals(10, dt.getHour());
    }

    @Test
    public void testIncrementMinute_RolloverHour() {
        DateTimeUtil dt = new DateTimeUtil(1, 1, 2024, 10, 59);
        dt.incrementMinute();
        Assert.assertEquals(0, dt.getMinute());
        Assert.assertEquals(11, dt.getHour());
    }

    @Test
    public void testIncrementMinute_RolloverDay() {
        DateTimeUtil dt = new DateTimeUtil(31, 1, 2024, 23, 59);
        dt.incrementMinute();
        Assert.assertEquals(0, dt.getMinute());
        Assert.assertEquals(0, dt.getHour());
        Assert.assertEquals(1, dt.getDay());
        Assert.assertEquals(2, dt.getMonth());
    }

    @Test
    public void testDecrementMinute_Normal() {
        DateTimeUtil dt = new DateTimeUtil(1, 1, 2024, 10, 30);
        dt.decrementMinute();
        Assert.assertEquals(29, dt.getMinute());
        Assert.assertEquals(10, dt.getHour());
    }

    @Test
    public void testDecrementMinute_RolloverHour() {
        DateTimeUtil dt = new DateTimeUtil(1, 1, 2024, 10, 0);
        dt.decrementMinute();
        Assert.assertEquals(59, dt.getMinute());
        Assert.assertEquals(9, dt.getHour());
    }

    @Test
    public void testDecrementMinute_RolloverDay() {
        DateTimeUtil dt = new DateTimeUtil(1, 3, 2024, 0, 0); // Leap year
        dt.decrementMinute();
        Assert.assertEquals(59, dt.getMinute());
        Assert.assertEquals(23, dt.getHour());
        Assert.assertEquals(29, dt.getDay());
        Assert.assertEquals(2, dt.getMonth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDateTime_InvalidDay() {
        new DateTimeUtil(32, 1, 2024, 10, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDateTime_InvalidMonth() {
        new DateTimeUtil(10, 13, 2024, 10, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDateTime_InvalidHour() {
        new DateTimeUtil(10, 10, 2024, 24, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDateTime_InvalidMinute() {
        new DateTimeUtil(10, 10, 2024, 23, 60);
    }
} 
