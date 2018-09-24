package com.au.calendar.datediff.utils;

public class ErrorMessages {

    public static final String INVALID_DAY_RANGE_ERR = "Invalid day value. Day should be between 1 and 31";
    public static final String INVALID_MONTH_RANGE_ERR = "Invalid month value. Month should be between 1 and 12";
    public static final String INVALID_YEAR_RANGE_ERR = "Invalid year value. Year should be between 1901 and 2999";
    public static final String INVALID_30DAY_MONTH_ERR = "Cannot have more than 30 days in the given month";
    public static final String INVALID_29_FEB_ERR = "Cannot have more than 28 days in FEB as the year is not a leap year";
    public static final String INVALID_30_FEB_LEAP_YR_ERR = "Cannot have more than 29 days in the February in a leap year";
}
