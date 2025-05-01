package sit707_tasks;

import java.util.Random;

/**
 * Hello world!
 * Demonstrates boundary behavior of DateTimeUtil.
 */
public class Main 
{
    public static void main(String[] args) 
    {   
        System.out.println("\nIncrement minute from 23:59 on 31 Jan 2024 → should become 00:00 on 1 Feb 2024:");
        DateTimeUtil dateTime = new DateTimeUtil(31, 1, 2024, 23, 59);
        System.out.println(dateTime);
        dateTime.incrementMinute();
        System.out.println(dateTime);

        System.out.println("\nDecrement minute from 00:00 on 1 Mar 2024 → should become 23:59 on 29 Feb 2024:");
        dateTime = new DateTimeUtil(1, 3, 2024, 0, 0);
        System.out.println(dateTime);
        dateTime.decrementMinute();
        System.out.println(dateTime);

        System.out.println("\nIncrement minute from 10:59 → should roll over to 11:00 on same day:");
        dateTime = new DateTimeUtil(15, 6, 2024, 10, 59);
        System.out.println(dateTime);
        dateTime.incrementMinute();
        System.out.println(dateTime);

        System.out.println("\nDecrement minute from 12:00 → should go to 11:59:");
        dateTime = new DateTimeUtil(15, 6, 2024, 12, 0);
        System.out.println(dateTime);
        dateTime.decrementMinute();
        System.out.println(dateTime);

        System.out.println("\nRandom date-time in January → increment minute once:");
        int rand_day = 1 + new Random().nextInt(31);
        int rand_hour = new Random().nextInt(24);
        int rand_minute = new Random().nextInt(60);
        dateTime = new DateTimeUtil(rand_day, 1, 2024, rand_hour, rand_minute);
        System.out.println(dateTime);
        dateTime.incrementMinute();
        System.out.println(dateTime);
    }
}
