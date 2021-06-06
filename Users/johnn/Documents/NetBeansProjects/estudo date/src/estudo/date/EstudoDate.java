/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudo.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
            int i = 0;
         int numDialises = 0;
         
        do{
             i++;
             cal.set(Calendar.DAY_OF_MONTH, i);
             
            Date dataCatch = cal.getTime();
            if(cal.get(Calendar.DAY_OF_WEEK) == 2){
                numDialises++;
            }
            else if(cal.get(Calendar.DAY_OF_WEEK) == 4){
                numDialises++;
            }
            else if(cal.get(Calendar.DAY_OF_WEEK) == 6){
               numDialises++;
    }
    

        }while(i < 31);
        System.out.println(numDialises);
       
        
        //cal.set(Calendar.DAY_OF_MONTH, 1);
          i = 0;
        Date dataSemana = null;
         dataSemana = cal.getTime();
        Date [] dates = new Date [lastDay +1];
        int whatday = 2;
         do{
             i++;
             cal.set(Calendar.DAY_OF_MONTH, i);
             
            Date dataCatch = cal.getTime();
            if(whatday == 1){
            if(cal.get(Calendar.DAY_OF_WEEK) == 2){
            dates [i] = dataCatch; }
            else if(cal.get(Calendar.DAY_OF_WEEK) == 4){
              dates [i] = dataCatch;  
            }
            else if(cal.get(Calendar.DAY_OF_WEEK) == 6){
              dates [i] = dataCatch;  
            }
            }
            if(whatday == 2){
              if(cal.get(Calendar.DAY_OF_WEEK) == 3){
            dates [i] = dataCatch; }
            else if(cal.get(Calendar.DAY_OF_WEEK) == 5){
              dates [i] = dataCatch;  
            }
            else if(cal.get(Calendar.DAY_OF_WEEK) == 7){
              dates [i] = dataCatch;  
            }  
            }
            //System.out.println(dates[i]);
              //System.out.println(dates[i]);
                     }while(i < lastDay);
        List<Date> list = new ArrayList<>(Arrays.asList(dates));
            
             while (list.remove(null));
             System.out.println(list);

          Date data1 = list.get(0);
          
          System.out.println(data1);
    }
}
    
   
