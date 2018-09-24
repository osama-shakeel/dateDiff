package com.au.calendar.datediff.utils;

import com.au.calendar.datediff.model.MonthDay;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.au.calendar.datediff.utils.ErrorMessages.*;

public class DateUtils {

    public static List<MonthDay> monthDays =
            Collections.unmodifiableList(Arrays.asList(
                    new MonthDay(31, 0),
                    new MonthDay(28, 31),
                    new MonthDay(31, 59),
                    new MonthDay(30, 90),
                    new MonthDay(31, 120),
                    new MonthDay(30, 151),
                    new MonthDay(31, 181),
                    new MonthDay(31, 212),
                    new MonthDay(30, 243),
                    new MonthDay(31, 273),
                    new MonthDay(30, 304),
                    new MonthDay(31, 334)));

    private static String[] monthStr = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEPT", "OCT", "NOV", "DEC"};

    /**
     * Validates the given date represented by day, month and year.
     * @param day
     * @param month
     * @param year
     * @throws IllegalArgumentException If the date is incorrect/invalid.
     */
    public static void validateDate(int day, int month, int year) {
        if (day < 1 || day > 32) {
            throw new IllegalArgumentException(INVALID_DAY_RANGE_ERR);
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException(INVALID_MONTH_RANGE_ERR);
        }
        if (year < 1901 || year > 2999) {
            throw new IllegalArgumentException(INVALID_YEAR_RANGE_ERR);
        }

        // If not February
        if (month != 2) {
            if (day > monthDays.get(month - 1).getDaysInMonth()) {
                throw new IllegalArgumentException(INVALID_30DAY_MONTH_ERR);
            }
        } else {
            // If year is not a Leap year
            if (!isLeapYear(year)) {
                if (day > 28) {
                    throw new IllegalArgumentException(INVALID_29_FEB_ERR);
                }
            } else {
                if (day > 29) {
                    throw new IllegalArgumentException(INVALID_30_FEB_LEAP_YR_ERR);
                }
            }
        }
    }

    /**
     * Checks whether the given year is a leap year.
     * @param year
     * @return true if the given year is a leap year.
     */
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        } else {
            return true;
        }
    }

}
