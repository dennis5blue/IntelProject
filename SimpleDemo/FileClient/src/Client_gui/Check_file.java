package Client_gui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.util.Set;
//import java.util.HashSet;
import java.util.ArrayList;

//import org.omg.CORBA.INTERNAL;

public class Check_file {
	public Check_file (){
		line1 = null;
		line2 = null;
		
	}
	public int Check (final String filename1, final String filename2)  { // file 1 has size 1, file 2 has size 2 
		try{
	    FileReader fr1 = new FileReader(filename1);
	    FileReader fr2 = new FileReader(filename2);
	    BufferedReader br1 = new BufferedReader(fr1);
	    BufferedReader br2 = new BufferedReader(fr2);
	    while ((line1 = br1.readLine())!=null && (line2 = br2.readLine())!=null){
	    	String[] tokens1 = line1.split(" ");
	    	String[] tokens2 = line2.split(" ");
	    	ArrayList<Integer> array1 = new ArrayList<Integer>();
	    	array1.add(Integer.valueOf(tokens1[0]));
	    	ArrayList<Integer> array2 = new ArrayList<Integer>();
	    	int i;
	    	for (i=0; i<tokens2.length; i++){
	    		array2.add(Integer.valueOf(tokens2[i]));
	    	}
	    	int id = 0;
	    	for (i=0; i<array2.size(); i++){
	    		if (array2.get(i) == array1.get(0))
	    			id = array2.get(i);
	    	}
	    	//System.out.println(id);
	    	fr1.close();
		    fr2.close();
		    br1.close();
		    br2.close();
	    	return id;
	    }
	    }catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
        return 0 ;
	  }
	public static String line1;
	public static String line2;
}
