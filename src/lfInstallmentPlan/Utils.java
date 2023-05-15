
package lfInstallmentPlan;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Luca and Friends :: github.com/lfriends
 */
public class Utils {

    static public java.util.Date strf2date( String date, String format ) {
        java.util.Date dt = null;
        SimpleDateFormat f = new SimpleDateFormat( format );
        try {
            dt = f.parse(date) ;
        }catch (ParseException e){
            e.printStackTrace();
        }
        return dt ;
    }
    
    public static String rpad( String source_string, int target_length, String pad_string ){
        if (source_string==null)source_string="";
        if (pad_string==null || pad_string.equals("") )pad_string=" ";
        while (source_string.length()<target_length)source_string+=pad_string;
        return source_string.substring(0, target_length);
    }    
    
    public static String double2s(double d){
        DecimalFormatSymbols dfs  = new DecimalFormatSymbols(Locale.ITALIAN) ;
        NumberFormat number2dec = new DecimalFormat("#,##0.00",dfs);
        return number2dec.format(d);
    }
    
    public static String date2s( java.util.Date dt ){
        SimpleDateFormat x = new SimpleDateFormat( "dd/MM/yy" );
        return (dt == null) ? "" : x.format(dt);    
    }
    
    public static java.util.Date getFirstDayOfMonth(java.util.Date dt) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
        Date newDate = calendar.getTime();
        return newDate;
    }

    public static java.util.Date addMonth(java.util.Date dt, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        calendar.add(Calendar.MONTH, i);
        return calendar.getTime();
    }  
    
    public static java.util.Date addDay(java.util.Date dt, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        calendar.add(Calendar.DATE, i);
        return calendar.getTime();
    }      
    
    public static int getDayOfMonth(java.util.Date dt) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        return calendar.get(Calendar.DAY_OF_MONTH); 
    }
    
    public static int getMonthNumber(java.util.Date dt) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        return calendar.get(Calendar.MONTH); 
    }        
}
