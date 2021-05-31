/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static org.joda.time.format.ISODateTimeFormat.date;

/**
 *
 * @author johnn
 */
public class Utils {
  
    
    public static String convertDouble(double valor){
        return new DecimalFormat("#0.00").format(valor);
    }
    public static String convertData(Date date){
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }
    
    
    
}
