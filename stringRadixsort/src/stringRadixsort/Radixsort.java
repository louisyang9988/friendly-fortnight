package stringRadixsort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Radixsort {
	public void countingSort(String[] A,char[] B,int k) {    
		String[] temp = new String[A.length+1];
		int[] c = new int[k+1];
		int i,j;
		for(i = 0; i <= k; i++)
			c[i] = 0;
		for(j = 0; j < B.length; j++) {
			c[B[j]-'A'] = c[B[j]-'A'] + 1;
		}
		for(i = 1; i <= k; i++)
			c[i] = c[i] + c[i-1];
		
		for(j = A.length - 1; j >= 0; j--) {
			temp[c[B[j]-'A']] = A[j];
			c[B[j]-'A'] = c[B[j]-'A'] - 1;
		}
		
		for(i = 1; i <= A.length; i++) {
			A[i-1] = temp[i];	
		}
	}
	
    public void radixSort(String[] A,int d) {
    	ArrayList[] arr = new ArrayList[26];
    	countingSort(A,divide(A,d),max(divide(A,d))-'A');
    	for(int i = 0; i < A.length; i++) {
    		int temp = A[i].charAt(d-1)-'A';
    		if(arr[temp] == null)
    			arr[temp] = new ArrayList();
    		arr[temp].add(A[i]);
    	}
    	for(int j = 0; j < 26; j++) {        
    		if(arr[j] != null) {
    			insert(arr[j]);
    		}
    	}
    	
    	//将各个桶结果进行合并
    	int count = 0;                  
    	for(int i = 0; i < 26; i++) {
    		if(arr[i] != null) {
    			Iterator it = arr[i].iterator();
    			while(it.hasNext()) {
    				String temp = (String)it.next();
    				A[count] = temp;
    				count++;
    			}
    			
    		}
    	}
    }
    
    public void insert(ArrayList list) {          
    	if(list.size() > 1) {
    		for(int i = 1; i < list.size() ; i++) {		
    			if(compareTo((String)list.get(i),(String)list.get(i-1))< 0) {
    				String temp = (String)list.get(i);
    				int j = i -1;
    				for(; j >= 0 && compareTo(temp,(String)list.get(j))< 0;j-- )
    					list.set(j + 1, list.get(j));
    				list.set(j + 1, temp);
    			}
    		}
    	}

}
    
   int compareTo(String a, String b) {        
    	return a.compareTo(b);
    }
    public char[] divide(String[] A, int count) {  //取数组中每个字符串的第d个字符
    	char[] B = new char[A.length];
    	for(int i = 0; i < A.length; i++) {
    		B[i] = A[i].charAt(count-1);
    	}
    	return B;
    }
    
    public char max(char[] B) {         //求数组当中的最大值
    	char max = 'a';
    	for(int i = 0 ; i < B.length; i++) {
    		if(B[i] > max) max = B[i];
    	}
    	return max;
    }
	public static void main(String[] args) throws IOException {
		public class MyObject{
			int number;
			public MyObject(int n){
			 number = n;
			}
			public static void main(String[] args){
			MyObject A = new MyObject(5);
			MyObject B = new MyObject(5);
			if ( A.equals(B) )
			System.out.println(“Equal”);
			else
			 System.out.println(“Not Equal”);
			}
			}
	}

}