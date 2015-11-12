package me.servername.core.util;

public class Txt {

    public static String from(String str){
        return str.replaceAll("&", "§");
    }

    public static String concat(String[] arr, int start){
        String str = "";
        for(int i = start; i < arr.length; i++){
            str += arr[i] + " ";
        }
        return str.trim();
    }

}