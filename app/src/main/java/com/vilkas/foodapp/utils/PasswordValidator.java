package com.vilkas.foodapp.utils;

public class PasswordValidator {



    public static boolean validate(String pass) {

        if(containsNumber(pass) && passwordLength(pass) && containsChar(pass)) {
            return true;
        }
        return false;

    }


    private static boolean passwordLength(String pass) {
        if(pass.length()>6) {
            return true;
        }
        else return false;
    }

    private static boolean containsNumber(String pass) {

        int k = 0;
        char[] containNumber = pass.toCharArray();
        for(int i =0; i < containNumber.length; i++) {

            switch(containNumber[i]) {

                case '0': ++k; break;
                case '1': ++k; break;
                case '2': ++k; break;
                case '3': ++k; break;
                case '4': ++k; break;
                case '5': ++k; break;
                case '6': ++k; break;
                case '7': ++k; break;
                case '8': ++k; break;
                case '9': ++k; break;
                default: continue;
            }

        }

        if(k>0) {
            return true;
        }
        else return false;

    }

    private static boolean containsChar(String pass) {


        int p = 0;
        char[] containChar = pass.toCharArray();
        for(int i =0; i < containChar.length; i++) {

            switch(containChar[i]) {

                case '!': ++p; break;
                case '@': ++p; break;
                case '#': ++p; break;
                case '$': ++p; break;
                case '%': ++p; break;
                case '^': ++p; break;
                case '&': ++p; break;
                case '*': ++p; break;
                case '~': ++p; break;
                case '+': ++p; break;
                case '-': ++p; break;
                case ' ': return false;
                default: continue;
            }

        }

        if(p>0) {
            return true;
        }
        else return false;

    }



}
