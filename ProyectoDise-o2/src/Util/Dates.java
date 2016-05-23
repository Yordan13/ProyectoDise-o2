/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jasc9
 */
public class Dates {
    public static String getCurrentDate(String pFormat) {
        DateFormat dateFormat = new SimpleDateFormat(pFormat);
        Date date = new Date();
        return dateFormat.format(date);
    }
}
