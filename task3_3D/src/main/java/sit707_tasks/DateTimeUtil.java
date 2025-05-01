package sit707_tasks;

public class DateTimeUtil {
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;

    private static final int[] DAYS_IN_MONTH_COMMON = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    private static final int[] DAYS_IN_MONTH_LEAP =   { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    private static final String[] MONTHS = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };

    public DateTimeUtil(int day, int month, int year, int hour, int minute) {
        if (!isValidDateTime(day, month, year, hour, minute)) {
            throw new IllegalArgumentException("Invalid date or time");
        }
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
    }

    public void incrementMinute() {
        minute++;
        if (minute >= 60) {
            minute = 0;
            hour++;
            if (hour >= 24) {
                hour = 0;
                incrementDay();
            }
        }
    }

    public void decrementMinute() {
        minute--;
        if (minute < 0) {
            minute = 59;
            hour--;
            if (hour < 0) {
                hour = 23;
                decrementDay();
            }
        }
    }

    private void incrementDay() {
        int[] daysInMonth = isLeapYear(year) ? DAYS_IN_MONTH_LEAP : DAYS_IN_MONTH_COMMON;
        day++;
        if (day > daysInMonth[month - 1]) {
            day = 1;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }
    }

    private void decrementDay() {
        int[] daysInMonthPrev = isLeapYear(year) ? DAYS_IN_MONTH_LEAP : DAYS_IN_MONTH_COMMON;
        day--;
        if (day < 1) {
            month--;
            if (month < 1) {
                month = 12;
                year--;
            }
            int[] daysInMonth = isLeapYear(year) ? DAYS_IN_MONTH_LEAP : DAYS_IN_MONTH_COMMON;
            day = daysInMonth[month - 1];
        }
    }

    private boolean isValidDateTime(int day, int month, int year, int hour, int minute) {
        if (year < 1700 || year > 2024) return false;
        if (month < 1 || month > 12) return false;
        int[] daysInMonth = isLeapYear(year) ? DAYS_IN_MONTH_LEAP : DAYS_IN_MONTH_COMMON;
        if (day < 1 || day > daysInMonth[month - 1]) return false;
        if (hour < 0 || hour > 23) return false;
        if (minute < 0 || minute > 59) return false;
        return true;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }
    public int getHour() { return hour; }
    public int getMinute() { return minute; }

    public String toString() {
        return String.format("%02d %s %04d %02d:%02d", day, MONTHS[month - 1], year, hour, minute);
    }
} 
