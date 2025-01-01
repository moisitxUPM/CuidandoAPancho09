package org.pancho.controller;
import org.pancho.model.enums.LanguageEnum;
import servidor.Autenticacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {

    boolean error = false;

    public boolean getError(){
        return error;
    }

    /*public static boolean validEmail(String email){
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }*/

    public static boolean upmEmail(String email){
        Autenticacion autenticacion = new Autenticacion();
        return autenticacion.existeCuentaUPM(email);
    }

    public static boolean validLanguage(String language){
        return LanguageEnum.fromValue(language) != null;
    }

    public static boolean validNumberOfParameters(String[] parameters, int expected) {
        int count = 0;
        if (parameters!=null) {
            for (String string : parameters) {
                count++;
            }
            return count == expected;
        }else {
            return expected == 0;
        }
    }

    public static boolean isInteger(String parameter){
        try {
            Integer.parseInt(parameter);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isFloat(String parameter) {
        try {
            Float.parseFloat(parameter);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String parameter) {
        try {
            Double.parseDouble(parameter);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static Date stringToDate(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date convertedDate = null;
        try {
            convertedDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return convertedDate;
    }

    public static boolean isValidDate(String start, String end){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = sdf.parse(start);
            endDate = sdf.parse(end);
        } catch (ParseException e) {
            return false;
        }
        return startDate.before(endDate);
    }

    public static boolean isAPicture(String parameter) {
        return parameter.endsWith(".jpg") || parameter.endsWith(".png") || parameter.endsWith(".jpeg");
    }

}
