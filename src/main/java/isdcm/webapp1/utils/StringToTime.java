/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isdcm.webapp1.utils;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author david
 */
public class StringToTime {
    public static Time stringToTime(String timeStr) throws ParseException {
        if (timeStr == null || timeStr.trim().isEmpty()) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        java.util.Date date = sdf.parse(timeStr);
        return new java.sql.Time(date.getTime());
    }
}
