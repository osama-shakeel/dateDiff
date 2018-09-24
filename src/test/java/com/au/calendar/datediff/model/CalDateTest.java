package com.au.calendar.datediff.model;

import org.junit.Assert;
import org.junit.Test;

public class CalDateTest {

    @Test
    public void testLonCalDategDateForNonLeapYear() {
        CalDate calDate = new CalDate(3, 3, 2003);
        Assert.assertEquals(calDate.getLongDate(), 731642);
    }

    @Test
    public void testLonCalDategDateFor2004LeapYear() {
        CalDate calDate = new CalDate(3, 3, 2004);
        Assert.assertEquals(calDate.getLongDate(), 732008);
    }

    @Test
    public void testLonCalDategDateFor2000LeapYear() {
        CalDate calDate = new CalDate(1, 1, 2000);
        Assert.assertEquals(calDate.getLongDate(), 730486);
    }
}
