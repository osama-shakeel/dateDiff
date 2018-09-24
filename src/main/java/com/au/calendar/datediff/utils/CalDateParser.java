package com.au.calendar.datediff.utils;

import com.au.calendar.datediff.model.CalDate;

public class CalDateParser {

    public static CalDate parseCalDate(String dateStr, String delim) {
        CalDate calDate = null;

        // Date String to be parsed cannot be null or empty
        if (dateStr != null && dateStr.length() > 0) {
            try {
                // Extract day, month and year
                String fields[] = dateStr.split(delim);
                if (fields != null && fields.length == 3) {
                    int day = Integer.valueOf(fields[0]);
                    int month = Integer.valueOf(fields[1]);
                    int year = Integer.valueOf(fields[2]);

                    // Validate date fields
                    DateUtils.validateDate(day, month, year);

                    calDate = new CalDate(day, month, year);
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("Day, Month and Year should be in format: dd/MM/yyyy");
            }
        } else {
            throw new IllegalArgumentException("Date argument cannot be null");
        }

        return calDate;
    }

}
