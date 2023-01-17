package ircnl.gob.mx.mioficinaapi.utils;

public class Utils {

	public static String padLeft(String cadena, int length) {
	    return String.format("%" + length + "s", cadena);  
	}
	
	public static String padRight(String cadena, int length) {
	     return String.format("%-" + length + "s", cadena);  
	}
	
}
