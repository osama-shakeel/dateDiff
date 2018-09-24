package com.au.calendar.datediff.utils;

import org.junit.Assert;
import org.junit.Test;

import static com.au.calendar.datediff.utils.ErrorMessages.*;

public class DateUtilsTest {

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateWithNegDay() {
        try {
            DateUtils.validateDate(-1, 2, 2000);
        } catch (IllegalArgumentException ex) {
            if (ex.getMessage().equalsIgnoreCase(INVALID_DAY_RANGE_ERR)) {
                throw ex;
            }
        }
        Assert.fail("Expected exception not thrown");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateWithDayBeyond31() {
        try {
            DateUtils.validateDate(50, 2, 2000);
        } catch (IllegalArgumentException ex) {
            if (ex.getMessage().equalsIgnoreCase(INVALID_DAY_RANGE_ERR)) {
                throw ex;
            }
        }
        Assert.fail("Expected exception not thrown");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateWithNegMonth() {
        try {
            DateUtils.validateDate(1, -2, 2000);
        } catch (IllegalArgumentException ex) {
            if (ex.getMessage().equalsIgnoreCase(INVALID_MONTH_RANGE_ERR)) {
                throw ex;
            }
        }
        Assert.fail("Expected exception not thrown");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateWithMonthBeyond12() {
        try {
            DateUtils.validateDate(5, 15, 2000);
        } catch (IllegalArgumentException ex) {
            if (ex.getMessage().equalsIgnoreCase(INVALID_MONTH_RANGE_ERR)) {
                throw ex;
            }
        }
        Assert.fail("Expected exception not thrown");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateWithYearLessThan1901() {
        try {
            DateUtils.validateDate(1, 2, 1900);
        } catch (IllegalArgumentException ex) {
            if (ex.getMessage().equalsIgnoreCase(INVALID_YEAR_RANGE_ERR)) {
                throw ex;
            }
        }
        Assert.fail("Expected exception not thrown");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateWithYearBeyond2999() {
        try {
            DateUtils.validateDate(5, 5, 3000);
        } catch (IllegalArgumentException ex) {
            if (ex.getMessage().equalsIgnoreCase(INVALID_YEAR_RANGE_ERR)) {
                throw ex;
            }
        }
        Assert.fail("Expected exception not thrown");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateWith31Sept() {
        try {
            DateUtils.validateDate(31, 9, 2000);
        } catch (IllegalArgumentException ex) {
            if (ex.getMessage().equalsIgnoreCase(INVALID_30DAY_MONTH_ERR)) {
                throw ex;
            }
        }
        Assert.fail("Expected exception not thrown");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateWith29FebNoLeapYear() {
        try {
            DateUtils.validateDate(29, 2, 2001);
        } catch (IllegalArgumentException ex) {
            if (ex.getMessage().equalsIgnoreCase(INVALID_29_FEB_ERR)) {
                throw ex;
            }
        }
        Assert.fail("Expected exception not thrown");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateWith30FebInLeapYear() {
        try {
            DateUtils.validateDate(30, 2, 2004);
        } catch (IllegalArgumentException ex) {
            if (ex.getMessage().equalsIgnoreCase(INVALID_30_FEB_LEAP_YR_ERR)) {
                throw ex;
            }
        }
        Assert.fail("Expected exception not thrown");
    }

    @Test
    public void testValidNonLeapYearDate() {
        DateUtils.validateDate(1, 1, 2001);
    }

    @Test
    public void testValidLeapYearDate() {
        DateUtils.validateDate(29, 2, 2004);
    }

    @Test
    public void testIsLeapYear() {
        Assert.assertTrue(DateUtils.isLeapYear(2004));
        Assert.assertFalse(DateUtils.isLeapYear(2001));
        Assert.assertTrue(DateUtils.isLeapYear(2000));
        Assert.assertTrue(DateUtils.isLeapYear(1600));
    }

}
