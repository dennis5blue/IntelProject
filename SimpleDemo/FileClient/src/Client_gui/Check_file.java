package Client_gui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.omg.CORBA.INTERNAL;

public class Check_file {
	public Check_file (){
		line = null;
		
	}
	public int Check (final String filename)  {
		try{  
	    FileReader fr = new FileReader(filename);
	    BufferedReader br = new BufferedReader(fr);
	    while ((line = br.readLine())!=null){
	    	return Integer.valueOf(line);
	    }
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
        return 0 ;
	  }
	public static String line;
}
