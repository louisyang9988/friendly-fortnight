import java.util.ArrayList;

/**
 *
 * @author Yang
 */
public class Message extends  ChatMessage{
  public int lastx,lasty,x,y;
	public char color;
	boolean userexisted;
	public String talkingTo;  
  public ArrayList<String> userlist= new  ArrayList<String>();
    public Action action;
     public enum Action{
         CONNECT,DISCONNECT,SEND,DRAW,CLEAR_DRAW
     }
     
     
     public Action getActon(){
		 return this.action;
	 }
     
     public String[] getUsernames(){
	 	 String []temp=new String[(userlist.size())];
	        
         for(int i=0;i<userlist.size();i++){
        	temp[i]=userlist.get(i);
         }
         return temp;
	 }
     
     
     public void setActon(Action a){
 	    this.action=a;
 	 }
     
     public void setUsernames(ArrayList<String> users){
	     for(int i=0;i<users.size();i++){
        	 userlist.add(users.get(i));
         }
	 }
     
     public void Draw(int x,int y,int x1, int y1)
     {
    	 this.lastx=x;
    	 this.lasty=y;
    	 this.x=x1;
    	 this.y=y1;
    	 
    	 
     }
     
     
}
