package com.au.calendar.datediff.utils;

import com.au.calendar.datediff.model.CalDate;
import org.junit.Assert;
import org.junit.Test;

public class CalDateParserTest {

    @Test
    public void testParseValidDateString() {
        // Prepare Test Data
        CalDate testCalDate = new CalDate(31, 12, 2000);

        CalDate calDate = CalDateParser.parseCalDate("31/12/2000", "/");

        Assert.assertNotNull(calDate);
        Assert.assertEquals(calDate, testCalDate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseEmptyDate() {
        try {
            CalDateParser.parseCalDate("", "/");
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ex.getMessage(), "Date argument cannot be null");
            throw ex;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseIncompleteDate() {
        try {
            CalDateParser.parseCalDate("31/01", "/");
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ex.getMessage(), "Day, Month and Year should be in format: dd/MM/yyyy");
            throw ex;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseNonNumericalDate() {
        try {
            CalDateParser.parseCalDate("31/JAN/1980", "/");
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ex.getMessage(), "Day, Month and Year should be in format: dd/MM/yyyy");
            throw ex;
        }
    }
}
