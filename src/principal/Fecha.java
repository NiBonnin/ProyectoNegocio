/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nico
 */
public class Fecha {
    
    public Fecha() {
    }
    
    //FECHA dd-mm-yyyy NORMAL
    public String getTimeNormal() {//String FECHA DE AHORA
        return this.toStringDate(this.sqlDateToday());
    }
    
    public String getTimeNormal(java.sql.Date sqlDate) {//dd-mm-yyyy FECHA DE SQL(yyyy-mm-dd)
        return this.toStringDate(sqlDate);
    }
    
    public String getTimeNormal(Date date) {//FECHA DE date A String  
        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
        String fecha=formatter.format(date);
        return fecha;
    }
    
    
    
    
    //FECHA DE TIPO DATE, devuelve en Date
    public Date getTimeDate() {//Date FECHA DE AHORA
        Date date = new Date();
        return date;
    }
    
    public Date getTimeDate(java.sql.Date sqlDate) {//FECHA DE SQL A Date
        Date date = new Date();
        return date;
    }
    
    
    
    //FECHA DE TIPO SQL, devuelve yyyy-mm-dd

    public java.sql.Date getTimeSql() {//yyyy-mm-dd FECHA DE AHORA
        return sqlDateToday();
    }
    
    
    
    
    //Demas metodos utilizados
    private java.sql.Date sqlDateToday(){
        Date date = new Date();                             //ejemplo
        long d = date.getTime();                            //d = 1495429015836
        java.sql.Date sqlDate = new java.sql.Date(d);       //sqlDate = 2017-05-22
        return sqlDate;
    }
    
    private String toStringDate(java.sql.Date sqlDate){//le paso un sql y me devuelve un string
        Date date = convertFromSQLDateToJAVADate(sqlDate); 
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-mm-yyyy");
        String fechapiola=dt1.format(date);
        return fechapiola;
    }
    private java.util.Date convertFromSQLDateToJAVADate(java.sql.Date sqlDate) {//le paso un sql y me devuelve un date
        java.util.Date javaDate = null;
        if (sqlDate != null) {
            javaDate = new Date(sqlDate.getTime());
        }
        return javaDate;
    }
}
