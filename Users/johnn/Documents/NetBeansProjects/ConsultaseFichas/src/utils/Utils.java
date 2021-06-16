/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public static String convertHora(Date date){
        return new SimpleDateFormat("HH:mm:ss").format(date);
    }
     public static Date parseDate(String data)  {
         SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
     
         sdf.setLenient(false);
         
         Date datacon = null;
        try {
            datacon = sdf.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacon ;
    }
    
   public static int calculaIdade(java.util.Date dataNasc){

    
    
Calendar dateOfBirth = new GregorianCalendar();


dateOfBirth.setTime(dataNasc);

 

// Cria um objeto calendar com a data atual

Calendar today = Calendar.getInstance();

 

// Obtém a idade baseado no ano

int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

 

dateOfBirth.add(Calendar.YEAR, age);

 

//se a data de hoje é antes da data de Nascimento, então diminui 1(um)

if (today.before(dateOfBirth)) {

age--;

}



return age;

}
     
    
}
