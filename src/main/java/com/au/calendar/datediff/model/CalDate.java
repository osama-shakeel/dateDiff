package com.au.calendar.datediff.model;

import com.au.calendar.datediff.utils.DateUtils;

import java.util.Objects;

/**
 * Immutable class representing date excluding the time info.
 */
public class CalDate {
    private final int day;
    private final int month;
    private final int year;
    private int longDate;

    public CalDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;

        this.longDate = calculateLongDate();
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getLongDate() {
        return longDate;
    }

    /**
     * Calculates the difference in days between this date and the provided
     * otherDate. In calculation both the dates are considered as partial
     * and hence not considered in the calculation. Only days between these
     * dates are considered.
     * @param otherDate
     * @return Difference in days of both dates.
     * @throws IllegalArgumentException If the provided date is
     * either null or the same as this date then report error.
     */
    public int findDifferenceInDays(CalDate otherDate) {
        if (otherDate != null) {
            // If both dates are equal then report error.
            if (otherDate.equals(this)) {
                throw new IllegalArgumentException("Both dates cannot be similar");
            }
            return Math.abs(this.getLongDate() - otherDate.getLongDate()) - 1;
        }
        throw new IllegalArgumentException("Date used for date-difference cannot be null");
    }

    /**
     * Calculates the long version of this instance.
     * and provides this date's representation in days starting from
     * 01/01/0000 AD.
     * @return Long representation of this date in days.
     */
    private int calculateLongDate() {
        int dateDiff =
                day +
                DateUtils.monthDays.get(month-1).getDaysSumFromYearStart() +
                (year * 365);
        int forLeapYear = year;
        if (month < 3) {
            forLeapYear--;
        }
        int leapYears = year/4 - year/100 + year/400;
        dateDiff += leapYears;

        return dateDiff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalDate calDate = (CalDate) o;
        return longDate == calDate.longDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(longDate);
    }

    @Override
    public String toString() {
        return "CalDate [" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                " ]";
    }
}
