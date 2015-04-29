package com.sample;

import java.util.Map;

public class ReadEnvironmentVariables {

	 public static void main (String[] args) {
	        //Map<String, String> env = System.getenv();
	        /*for (String envName : env.keySet()) {
	            System.out.format("%s=%s%n",
	                              envName,
	                              env.get(envName));
	        }*/
	        System.out.format(System.getenv("Ankit"));
	    }
}
