package d;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Vector;

public class FileTest 
{
	static File filea = new File("C://Users//Yang//Desktop//b.txt");  
	  
    static HashMap<String,Integer> hashmap = new HashMap<String,Integer>();  
    static HashMap<String,String> hashMAP = new HashMap<String,String>();
    public static void main(String[] args) throws IOException  
    {    
        BufferedReader cmudict = new BufferedReader(new FileReader(filea));    
        Scanner sa = new Scanner(cmudict);   
         
        while(sa.hasNextLine()){   
            String line = sa.nextLine();  
            String[] name = line.split("  ");  
            
            if (hashmap.containsKey(name[1]))    
               hashmap.put(name[1], hashmap.get(name[1]) + 1);    
            else  
               hashmap.put(name[1], 1);    
            hashMAP.put(name[0], name[1]);
            
        }
           //int max =1;
        for (Entry<String, Integer> entry : hashmap.entrySet()){  
            Object key = entry.getKey();  
            Object val = entry.getValue();  
           String name1="";
           
           for (Entry<String, String> entry1 : hashMAP.entrySet()){  
        	   Object key1 = entry1.getKey();
        	   Object val1 = entry1.getValue();
        	   if (key.toString()==val1.toString());
        	      name1 =key1.toString();
        	 
           }
            ///if(Integer.parseInt(val.toString())>max)
            	///max=Integer.parseInt(val.toString())  ;
          
           System.out.println(name1 + "   number of homophones:" + val.toString() );
            }  
        
        ///System.out.println(max);  
         
        }
	///private static ArrayList<String> putadd(String string) {
		// TODO Auto-generated method stub
		///return null;
	}         
///}  