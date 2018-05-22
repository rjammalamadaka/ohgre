package com.macquarium.ong;

public class CommonUtil {

	
	public static String stackTraceToString(Exception ex) {
	    Throwable e = ex;
	    String trace = e.toString() + "\n";
	    for (StackTraceElement e1 : e.getStackTrace()) {
	        trace += "\t at " + e1.toString() + "\n";
	    }
	    while (e.getCause() != null) {
	        e = e.getCause();
	        trace += "Cause by: " + e.toString() + "\n";
	        for (StackTraceElement e1 : e.getStackTrace()) {
	            trace += "\t at " + e1.toString() + "\n";
	        }
	    }
	    return trace;
	}
}
