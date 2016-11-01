



import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer
{  
	public static ArrayList<String> userlist =new  ArrayList<String>();
	
	public  static void AddUserlist(String name)
	{
		
		userlist.add(name);
		
		
		
	}
	
	public  static void RemoveUserlist(String name)
	{
		
		userlist.remove(name);
		
		
		
	}
	
	public static void main(String[] args ) 
   {  
      ArrayList<ChatHandler> AllHandlers = new ArrayList<ChatHandler>();
	//  HashMap<ArrayList, String> hashMap = new HashMap<ArrayList, String>();  	
      try 
      {  ServerSocket s = new ServerSocket(4000);
         
         for (;;)
         {  Socket incoming = s.accept( );
            new ChatHandler(incoming, AllHandlers).start();
         }   
      }
      catch (Exception e) 
      {  System.out.println(e);
      } 
   } 
}

class ChatHandler extends Thread
{  
   
    
	
    
    public ChatHandler(Socket i, ArrayList<ChatHandler> h) 
   { 
   		incoming = i;
		handlers = h;
		handlers.add(this);
		try{
			in = new ObjectInputStream(incoming.getInputStream());
			out = new ObjectOutputStream(incoming.getOutputStream());
		}catch(IOException ioe){
				System.out.println("Could not create streams.");
		}
   }
	public synchronized void broadcast(){
	
		ChatHandler left = null;
		for(ChatHandler handler : handlers){
			Message cm = new Message();
			
			if(myObject.getActon()==Message.Action.CONNECT)
			{
				cm.setActon(myObject.action.CONNECT);
				cm.setUsernames(ChatServer.userlist);
				cm.setName(myObject.name);
				
			}
			
			else if(myObject.getActon()==Message.Action.SEND){
				
				cm.setActon(myObject.action.SEND);
				cm.setMessage(myObject.message);
				cm.setName(myObject.getName());
				cm.talkingTo="ALL";
				
				}
			else if(myObject.getActon()==myObject.action.DISCONNECT)
			{
				cm.setActon(myObject.action.DISCONNECT);
				cm.setName(myObject.getName());
				cm.setUsernames(ChatServer.userlist);
				
				
				
			}
			else if(myObject.getActon()==myObject.action.DRAW)
			{
				cm.Draw(myObject.lastx, myObject.lasty, myObject.x, myObject.y);
				cm.setActon(myObject.getActon().DRAW);
				cm.color=myObject.color;
				
				
			}
			else if(myObject.getActon()==myObject.action.CLEAR_DRAW)
			{
				
				cm.setActon(myObject.getActon().CLEAR_DRAW);
				
				
				
			}
		
			
			try{
				handler.out.writeObject(cm);
				System.out.println("Writing to handler outputstream: " + cm.getMessage());
			}catch(IOException ioe){
				//one of the other handlers hung up
				left = handler; // remove that handler from the arraylist
			}
		}
		handlers.remove(left);
		
//		if(myObject.getMessage().equals("bye")){ // my client wants to leave
//			done = true;	
//			handlers.remove(this);
//			System.out.println("Removed handler. Number of handlers: " + handlers.size());
//		}
		System.out.println("Number of handlers: " + handlers.size());
   }

	public  synchronized void PointToPoint(){
		
		ChatHandler left = null;
		for(ChatHandler handler : handlers){
			Message cm = new Message();
			if(handler.myObject.getName().equals(myObject.talkingTo)&&myObject.getActon()==myObject.action.SEND)
			{
				cm.setActon(myObject.action.SEND);
				cm.setMessage(myObject.getMessage());
				cm.setName(myObject.getName());
			}
			
			try{
				handler.out.writeObject(cm);
				System.out.println("Writing to handler outputstream: " + cm.getMessage());
			}catch(IOException ioe){
				//one of the other handlers hung up
				left = handler; // remove that handler from the arraylist
			}
		}
		
		
//		if(myObject.getMessage().equals("bye")){ // my client wants to leave
//			done = true;	
//			handlers.remove(this);
//			System.out.println("Removed handler. Number of handlers: " + handlers.size());
//		}
		System.out.println("Number of handlers: " + handlers.size());
   
	}
	
	
   public void run()
   {  
		try{ 	
			while(!done){
				myObject = (Message)in.readObject();
			System.out.println("Message read: " + myObject.message);
				if (myObject.getActon()==myObject.action.CONNECT)
				{
					ChatServer.AddUserlist(myObject.getName());
					broadcast();
				}
				else if(myObject.getActon()==myObject.action.SEND)
				
				{
					if(myObject.talkingTo.equals("ALL"))
					broadcast();
					else
						PointToPoint()	;
					
				} 
				
				else if(myObject.getActon()==myObject.action.DISCONNECT)
				{
					ChatServer.userlist.remove(myObject.getName());
					broadcast();
					
					
					
					
				}
				else if(myObject.getActon()==myObject.action.DRAW)
				{
					
					broadcast();
					
					
					
				}
				else if(myObject.getActon()==myObject.action.CLEAR_DRAW)
				{
					broadcast();
					
					
					
				}
				
			}			    
		} catch (IOException e){  
			if(e.getMessage().equals("Connection reset")){
				ChatServer.RemoveUserlist(myObject.getName());
				System.out.println("A client terminated its connection.");
			}else{
				System.out.println("Problem receiving: " + e.getMessage());
			}
		}catch(ClassNotFoundException cnfe){
			System.out.println(cnfe.getMessage());
		}finally{
			handlers.remove(this);
		}
   }
   
   Message myObject = null;
   private Socket incoming;

   boolean done = false;
   ArrayList<ChatHandler> handlers;

   ObjectOutputStream out;
   ObjectInputStream in;
   
   
}
