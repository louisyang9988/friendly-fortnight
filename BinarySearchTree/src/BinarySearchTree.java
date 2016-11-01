import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/*
* A binary search tree
*/
public class BinarySearchTree{
 
    public static void main(String[] args) throws IOException{
        BinarySearchTree tree = new BinarySearchTree();
      
        
        
        FileReader fr=new FileReader("src/F.txt");
        BufferedReader br=new BufferedReader(fr);
    	

		tree.printTree(tree.root);
      
        {
        	
        	String[] s =(br.readLine().split(" "));
        	if (s[0].equals("I"))
        	{
        		for(int i=1;i<=s.length-1;i++)
        		{
        			tree.addNode(Integer.parseInt(s[i]));
        			
        		}
        	}
        	else if(s[0].equals("P"))
        	{
        		
        		tree.printTree(tree.root);
        	
        	}
        	
        	else if(s[0].equals("D"))
        	{
        		for(int j=1;j<=s.length-1;j++)
        		{
        			tree.deleteNode(Integer.parseInt(s[j]));
        			
        			
        		}
        		
        	}
        	
        	
        }
        
        
        {
        	
        	String[] s1 =(br.readLine().split(" "));
        	if (s1[0].equals("I"))
        	{
        		for(int i=1;i<=s1.length-1;i++)
        		{
        			tree.addNode(Integer.parseInt(s1[i]));
        			
        		}
        	}
        	else if(s1[0].equals("P"))
        	{
        		
        		tree.printTree(tree.root);
        		System.out.println("");
        	
        	}
        	
        	else if(s1[0].equals("D"))
        	{
        		for(int j=1;j<=s1.length-1;j++)
        		{
        			tree.deleteNode(Integer.parseInt(s1[j]));
        			
        			
        		}
        		
        	}
        	
        	
        }
        
        
        
    	
        
        {
        	
        	String[] s2 =(br.readLine().split(" "));
        	if (s2[0].equals("I"))
        	{
        		for(int i=1;i<=s2.length-1;i++)
        		{
        			tree.addNode(Integer.parseInt(s2[i]));
        			
        		}
        	}
        	else if(s2[0].equals("P"))
        	{
        		
        		tree.printTree(tree.root);
        	
        	}
        	
        	else if(s2[0].equals("D"))
        	{
        		for(int j=1;j<=s2.length-1;j++)
        		{
        			tree.deleteNode(Integer.parseInt(s2[j]));
        			
        			
        		}
        		
        	}
        	
        	
        }
        
        
        
    	
        
        {
        	
        	String[] s3 =(br.readLine().split(" "));
        	if (s3[0].equals("I"))
        	{
        		for(int i=1;i<=s3.length-1;i++)
        		{
        			tree.addNode(Integer.parseInt(s3[i]));
        			
        		}
        	}
        	else if(s3[0].equals("P"))
        	{
        		
        		tree.printTree(tree.root);
        		System.out.println("");
        	
        	}
        	
        	else if(s3[0].equals("D"))
        	{
        		for(int j=1;j<=s3.length-1;j++)
        		{
        			tree.deleteNode(Integer.parseInt(s3[j]));
        			
        			
        		}
        		
        	}
        	
        	
        }
 {
        	
        	String[] s4 =(br.readLine().split(" "));
        	if (s4[0].equals("I"))
        	{
        		for(int i=1;i<=s4.length-1;i++)
        		{
        			tree.addNode(Integer.parseInt(s4[i]));
        			
        		}
        	}
        	else if(s4[0].equals("P"))
        	{
        		
        		tree.printTree(tree.root);
        	
        	}
        	
        	else if(s4[0].equals("D"))
        	{
        		for(int j=1;j<=s4.length-1;j++)
        		{
        			tree.deleteNode(Integer.parseInt(s4[j]));
        			
        			
        		}
        		
        	}
        	
        	
        }
 {
 	
 	String[] s5 =(br.readLine().split(" "));
 	if (s5[0].equals("I"))
 	{
 		for(int i=1;i<=s5.length-1;i++)
 		{
 			tree.addNode(Integer.parseInt(s5[i]));
 			
 		}
 	}
 	else if(s5[0].equals("P"))
 	{
 		
 		tree.printTree(tree.root);
 	
 	}
 	
 	else if(s5[0].equals("D"))
 	{
 		for(int j=1;j<=s5.length-1;j++)
 		{
 			tree.deleteNode(Integer.parseInt(s5[j]));
 			
 			
 		}
 		
 	}
 	
 	
 }
 
 {
 	
 	String[] s6 =(br.readLine().split(" "));
 	if (s6[0].equals("I"))
 	{
 		for(int i=1;i<=s6.length-1;i++)
 		{
 			tree.addNode(Integer.parseInt(s6[i]));
 			
 		}
 	}
 	else if(s6[0].equals("P"))
 	{
 		
 		tree.printTree(tree.root);
 	
 	}
 	
 	else if(s6[0].equals("D"))
 	{
 		for(int j=1;j<=s6.length-1;j++)
 		{
 			tree.deleteNode(Integer.parseInt(s6[j]));
 			
 			
 		}
 		
 	}
 	
 	
 }
        br.close();
        
        
        
        
    }
 
    /* A tree node */
    public class Node{
        int value;
        Node left;
        Node right;
         
        public Node(int value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
     
    public Node root = null;
    public Node doubleListHead = null;
    public Node doubleListTail = null;
     
    public void addNode(int value){
        if(this.root == null){
            this.root = new Node(value, null, null);
        }
        else{
            Node parent = null, node = root;
            while(node != null){
                parent = node;
                if(value == node.value){
                    System.out.println("Node "+value+" already exists!");
                    return;
                }
                else if(value < node.value)
                    node = node.left;
                else
                    node = node.right;
            }
             
            /* Have found the new node's position. Insert it into the tree. */
            if(value < parent.value)
                parent.left = new Node(value, null, null);
            else
                parent.right = new Node(value, null, null);
        }
    }
     
    public void deleteNode(int value){
        /* Firstly search for the node */
        Node parent = null, node = root;
        while(node != null){
            if(node.value == value)
                break;
            else if(value < node.value){
                parent = node;
                node = node.left;
            }
            else{
                parent = node;
                node = node.right;
            }
        }
         
        if(node == null){
            System.out.println("Node " + value + " dosen't exist!");
            return;
        }
         
        if(node.left == null){
            if(parent != null){
                if(node.value < parent.value)
                    parent.left = node.right;
                else
                    parent.right = node.right;
            }
            /* The node to be deleted is root */
            else{
                root = root.right;
            }
        }
        else{
            Node replaceNodeParent = node;
            Node replaceNode = node.left;
            while(replaceNode.right != null){
                replaceNodeParent = replaceNode;
                replaceNode = replaceNode.right;
            }
            if(replaceNode.value < replaceNodeParent.value)
                replaceNodeParent.left = replaceNode.left;
            else
                replaceNodeParent.right = replaceNode.left;
                 
            node.value = replaceNode.value;
        }
    }
     
    /* Print the tree by inorder traversal */
    public void printTree(Node node){
        if(node == null) return;
        printTree(node.left);
        System.out.print(node.value + ",");
        printTree(node.right);
        
    }
     
    /* Convert the tree to a double linked list in ascending order */
   
}