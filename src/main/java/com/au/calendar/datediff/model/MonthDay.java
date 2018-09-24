package com.au.calendar.datediff.model;

public class MonthDay {
    int daysInMonth;
    int daysSumFromYearStart;

    public MonthDay(int daysInMonth, int daysSumFromYearStart) {
        this.daysInMonth = daysInMonth;
        this.daysSumFromYearStart = daysSumFromYearStart;
    }

    public int getDaysInMonth() {
        return daysInMonth;
    }

    public int getDaysSumFromYearStart() {
        return daysSumFromYearStart;
    }
}
