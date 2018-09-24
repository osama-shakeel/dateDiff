package com.au.calendar.datediff;

import com.au.calendar.datediff.model.CalDate;
import com.au.calendar.datediff.utils.CalDateParser;

/**
 * Main class to calculate the date difference
 */
public class DateDifferenceMain {

    public static void main(String[] args) {

        // Get the date arguments
        if (args != null && args.length > 1) {
            String date1Str = args[0];
            String date2Str = args[1];

            // Create CalDate instances for both the dates by parsing it
            CalDate date1 = CalDateParser.parseCalDate(date1Str, "/");
            CalDate date2 = CalDateParser.parseCalDate(date2Str, "/");

            // If both the dates are the same then report error.
            if (date1.equals(date2)) {
                throw new IllegalArgumentException("Both dates cannot be similar");
            }
            // Display dates difference in days
            System.out.println("Date Difference is " + date1.findDifferenceInDays(date2));
        } else {
            throw new IllegalArgumentException("No dates provided - Exiting program");
        }
    }

}
