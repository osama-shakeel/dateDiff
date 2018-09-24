package com.au.calendar.datediff.model;

import com.au.calendar.datediff.utils.DateUtils;

import java.util.Objects;

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

    public int findDifferenceInDays(CalDate otherDate) {
        if (otherDate != null) {
            if (otherDate.equals(this)) {
                throw new IllegalArgumentException("Both dates cannot be similar");
            }
            return Math.abs(this.getLongDate() - otherDate.getLongDate()) - 1;
        }
        throw new IllegalArgumentException("Date used for date-difference cannot be null");
    }

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
