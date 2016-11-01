import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.applet.Applet;


public class Client extends Thread implements ActionListener{

	Message myObject;
    String talkTo="ALL";    
	boolean sendingdone = false, receivingdone = false;
	boolean uesrexisted=true;;
	Scanner scan;
	Socket socketToServer;
	ObjectOutputStream myOutputStream;
	ObjectInputStream myInputStream;
	Frame f;
	TextField tf;
	TextArea ta;
        Graphics g;
        JLabel j ;
        String UserName;
        JButton b;
         Frame f1;
       TextField t;
       JButton box ;
       JButton his;
       JButton clean;
       JButton disFocus; 
       JList l;
       JPanel p1;
       JPanel p2;
       JPanel p3;
       JPanel p4;
       JComboBox b1;
       char color;
       public int lastx,lasty;
	public Client(){	
		box = new JButton("DISCONNECT");
		his = new JButton("HISTORY");
		clean =new JButton("CLEARPAD");
		disFocus=new JButton("ALL");
		f = new Frame();
                j= new JLabel("DrawPad");
		f.setSize(800,400);
		f.setTitle("Chat Client");
                
               l = new JList();
                  l.setSize(50, 300);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				
				 myObject = new Message();
                 myObject.setActon(myObject.action.DISCONNECT);
                 myObject.setName(UserName);
                 
         		try{
        			myOutputStream.reset();
         			myOutputStream.writeObject(myObject);
        		}catch(IOException ioe){
        			System.out.println(ioe.getMessage());
          		}
         		System.exit(0);
			}
		});
		JComboBox b1=new JComboBox();
		p1 =new JPanel();
		p2 =new JPanel();
		p3 =new JPanel();
		p1.setSize(50, 300);
		p2.setSize(50, 300);
		b1.addItem("BLACK");
		b1.addItem("RED");
		b1.addItem("GREEN");
		b1.addItem("PINK");
		b1.addItem("YELLOW");
		
		p1.add(l, BorderLayout.NORTH);
		p1.add(disFocus, BorderLayout.SOUTH);
		//p3.add(b1, BorderLayout.SOUTH);
		tf = new TextField();
		//tf.addActionListener(this);
        f.add(p2, BorderLayout.WEST);
        p2.add(b1, BorderLayout.SOUTH);
		f.add(tf, BorderLayout.NORTH);
		p2.add(j,BorderLayout.SOUTH);
		p2.add(clean,BorderLayout.NORTH);
		p2.setBackground(Color.WHITE);
		ta = new TextArea();
		f.add(ta, BorderLayout.CENTER);
                f.add(box, BorderLayout.SOUTH);
                p1.add(his, BorderLayout.SOUTH);
                f.add(p1, BorderLayout.EAST);
                  f1 = new Frame("Enter the user name");
                  f1.setLocation(500, 500);
    f1.setSize(400, 100);
    t = new TextField();
    b =new JButton("CONNECT");
 ;
    f1.add(t,BorderLayout.NORTH);
    f1.add(b,BorderLayout.CENTER);
    f1.setVisible(true);
  
    l.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		
 		

		@Override
		public void valueChanged(ListSelectionEvent e) {
			talkTo=(String) l.getSelectedValue();
			
		}
 	});


      disFocus.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			l.clearSelection();
			talkTo="ALL";
		}
	});

      box.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			 myObject = new Message();
                 myObject.setActon(myObject.action.DISCONNECT);
                 myObject.setName(UserName);
                 f.setVisible(false);
                 f1.setVisible(true);
         		try{
        			myOutputStream.reset();
         			myOutputStream.writeObject(myObject);
        		}catch(IOException ioe){
        			System.out.println(ioe.getMessage());
          		}
                
    		}
    		
    	});
        
      
      his.addActionListener(new ActionListener() {
  		
  		@Override
  		public void actionPerformed(ActionEvent e) {
  			History h = new History();
  		}
  	});
      
      
      clean.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			myObject = new Message();
    			myObject.setActon(myObject.getActon().CLEAR_DRAW);
    			 
       		 try{
           			myOutputStream.reset();
            			myOutputStream.writeObject(myObject);
           		}catch(IOException ioe){
           			System.out.println(ioe.getMessage());
             		}
    			
             
    		}
    	});
      
      
    p2.addMouseListener(new MouseAdapter() {
//    	  public void mouseEntered(MouseEvent event) {
//    	       myObject.lastx=event.getX();
//    	       myObject.lasty=event.getY();
//    	     }

    	     public void mousePressed(MouseEvent event) {
    	    	lastx=event.getX();
      	        lasty=event.getY();
    	     }
    	  }
    	
    );
    
    p2.addMouseMotionListener(new MouseAdapter() {
    	 
    	 public void mouseDragged(MouseEvent event) {
    		 myObject = new Message();
    		 myObject.Draw(lastx, lasty, event.getX(), event.getY());
    		 myObject.action=myObject.getActon().DRAW;
    		 myObject.color=b1.getSelectedItem().toString().charAt(0);
    		 
    		 try{
        			myOutputStream.reset();
         			myOutputStream.writeObject(myObject);
        		}catch(IOException ioe){
        			System.out.println(ioe.getMessage());
          		}
    		 
    		 lastx=event.getX();
   	        lasty=event.getY();
    		 
    	    }
  	
    });
    
	b.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			  
			
			
			f1.setVisible(false);
                        UserName=t.getText();
                         f.setVisible(true);
                         
                      
                        myObject = new Message();
                        myObject.setActon(myObject.action.CONNECT);
               		    myObject.setName(UserName);
                		try{
               			myOutputStream.reset();
                			myOutputStream.writeObject(myObject);
               		}catch(IOException ioe){
               			System.out.println(ioe.getMessage());
                 		}
                         
			}
			
			
                        
                         
                         
                         
		
	});
        tf.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			myObject = new Message();
                myObject.setName(UserName);
		myObject.setMessage(tf.getText());
		myObject.setActon(myObject.action.SEND);
		myObject.talkingTo=talkTo;
		tf.setText("");
		SQLManager.save(myObject.getName()+":"+myObject.getMessage());
		try{
			myOutputStream.reset();
			myOutputStream.writeObject(myObject);
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
		}
	});
		try{						

			//scan = new Scanner(System.in);

			//myObject = new ChatMessage();

			socketToServer = new Socket("afsaccess1.njit.edu", 4000);

			myOutputStream =
				new ObjectOutputStream(socketToServer.getOutputStream());

			myInputStream =
				new ObjectInputStream(socketToServer.getInputStream());
			start();
			
				
		}
		catch(Exception e){
			System.out.println(e.getMessage());	
        }
		///f.setVisible(true);
	}
        
	public void actionPerformed(ActionEvent ae){
            
		myObject = new Message();
       
		tf.setText("");
		try{
			myOutputStream.reset();
			myOutputStream.writeObject(myObject);
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
		
	}
        	
	public void run(){
           
		System.out.println("Listening for messages from server . . . ");
		try{
			while(!receivingdone){
				  myObject = (Message)myInputStream.readObject();
				  if (myObject.getActon()==myObject.action.CONNECT)
	                {
					
	                	l.setListData(myObject.getUsernames());
	                	              	
	                	ta.append("*****"+myObject.name+" joins to chat"+"*****"+"\n");
	                	
	                } 
				  
				  else if(myObject.getActon()==myObject.action.DISCONNECT)
				  {
					  l.setListData(myObject.getUsernames());
					  ta.append("*****"+myObject.name+" exit chat"+"*****"+"\n");
					  
				  }
				  else if(myObject.getActon()==myObject.action.SEND){
			
               	ta.append(myObject.getName()+" "+":"+myObject.getMessage() + "\n");
              
				  }   
				  
				  else if(myObject.getActon()==myObject.action.DRAW){
						
					  g=p2.getGraphics();
					  switch(myObject.color)
					  {
						  case 'B': g.setColor(Color.BLACK);  break;
						  case 'G': g.setColor(Color.GREEN);  break;
						  case 'Y': g.setColor(Color.YELLOW);  break;
						  case 'R': g.setColor(Color.RED);  break;
						  case 'P': g.setColor(Color.PINK);  break;
					  }
					  
					  g.drawLine(myObject.lastx, myObject.lasty, myObject.x, myObject.y);
					 
						 
				  }
				  else if(myObject.getActon()==myObject.action.CLEAR_DRAW){
						
					  g=p2.getGraphics();
					  g.setColor(Color.WHITE);
					  g.fillRect(0, 40, p2.getWidth(), p2.getHeight());
					 
		              
						  } 
				 
				  
				  
			}
		}catch(IOException ioe){
			System.out.println("IOE: " + ioe.getMessage());
		}catch(ClassNotFoundException cnf){
			System.out.println(cnf.getMessage());
		}
	}

	public static void main(String[] arg){
	
		Client c = new Client();

	}
}