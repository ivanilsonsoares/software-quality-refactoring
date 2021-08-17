/**
 * @author Lais Frigério da Silva
 */

package model;

import controller.PacienteController;
import controller.UsuarioController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Validacao {
    public static boolean isEmpty(String v){
        return v.isEmpty();
    }
    
    public static boolean isLessOrEqualThan(String v, int tam) {
        return v.length() <= tam;
    }
    
    public static boolean lengthIsEqualsTo(String v, int tam) {
        return v.length() == tam;
    }
    
    public static boolean equals(String v, int tam){
        return v.length() == tam;
    }
    
    public static boolean isNumeric(String n){
        try{
            Long.parseLong(n);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }
    
    public static boolean hasOnlyLettersAndNumbers(String n){
        return n.matches("^[a-zA-Z0-9]*$");
    }
    
    public static boolean isDouble(String p){
        try{
            Double.parseDouble(p);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }
    
    public static boolean isDate(String d){
        try {
            new SimpleDateFormat("dd/MM/yyyy").parse(d);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
    
    
    public static boolean timeIsValid(String t){
        String[] v = t.split(":");
        if(Integer.parseInt(v[0]) <0 || Integer.parseInt(v[0]) >23)
            return false;
        if(Integer.parseInt(v[1])<0 || Integer.parseInt(v[1])>59)
            return false;
        return true;
    }
    
    
    public static boolean CPFexists(String cpf, int id) {
        return PacienteController.CPFexists(cpf, id);
    }
    
    public static boolean loginExists(String login, int id) {
        return UsuarioController.loginExists(login, id);
    }
    
    public static boolean hasComma(String v){
        return v.contains(",");
    }
    
    public static String setDateMask(String d){
        return d.substring(0, 2) + "/" + d.substring(2, 4) + "/" + d.substring(4, 8);
    }
}
