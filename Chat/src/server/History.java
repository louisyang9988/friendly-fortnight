import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;


public class History {
	JFrame f ;
	static JTextArea a;
	
	
	
	
	public  History()
	{
	f = new JFrame("History");	
	a = new JTextArea();
	f.setSize(400, 600);	
	f.add(a)	;
    f.setVisible(true);
	
	  History.loadHistory(SQLManager.load());
	
	
	
	}
	
	public static  void loadHistory(ArrayList<String> his)
	{
		Iterator i=his.iterator();
		while(i.hasNext())
		{
			a.append(i.next().toString()+"\n");
		 
			
			
		}
		
		
		
	}
	
	
	
}
