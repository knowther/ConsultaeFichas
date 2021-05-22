/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudo.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author johnn
 */
public class EstudoDate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        int lastDay = cal.getActualMaximum(Calendar.DATE);
        
        cal.setTime(date);
        
        //cal.set(Calendar.DAY_OF_MONTH, 1);
        int i = 0;
        Date dataSemana = null;
         dataSemana = cal.getTime();
        Date [] dates = new Date [lastDay + 1];
         do{
             i++;
             cal.set(Calendar.DAY_OF_MONTH, i);
             
            Date dataCatch = cal.getTime();
            if(cal.get(Calendar.DAY_OF_WEEK) == 2){
            dates [i] = dataCatch; }
            else if(cal.get(Calendar.DAY_OF_WEEK) == 4){
              dates [i] = dataCatch;  
            }
            else if(cal.get(Calendar.DAY_OF_WEEK) == 6){
              dates [i] = dataCatch;  
            }
            System.out.println(dates[i]);
              //System.out.println(dates[i]);
                     }while(i < lastDay);
            
    }
    
}
