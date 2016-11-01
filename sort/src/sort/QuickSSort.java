package sort;

public class QuickSSort {
	static int count;
	 public static void main(String[] args)
	 {
		 
		 int a[]=new int[32];
			for(int i=0;i<32;i++)
			{
				a[i]=i;
				
			}
			
			int b []=new int[32];
			for(int j=0;j<32;j++)
			{
				b[j]=31-j;
				
			}
			
			int c []=new int[32];
			for(int j=0;j<32;j++)
			{
				c[j]= (int) (Math.random() * 32);
				
			}
			int d []=new int[1024];
			for(int j=0;j<1024;j++)
			{
				d[j]= (int) (Math.random() * 1024);
				
			}
			int e []=new int[32768];
			for(int j=0;j<32768;j++)
			{
				e[j]= (int) (Math.random() * 32768);
				
			}
			
			int f []=new int[1048576];
			for(int j=0;j<1048576;j++)
			{
				f[j]= (int) (Math.random() * 1048576);
				
			}
			
		 QuickSSort	 q = new  QuickSSort();
		 q.quickSort(a, 0, a.length);
		 System.out.println("number of key comparisons is "+count);
		 count=0;
		 q.quickSort(b, 0, b.length);
		 System.out.println("number of key comparisons is "+count);
		 count=0;
		 q.quickSort(c, 0, c.length);
		 System.out.println("number of key comparisons is "+count);
		 count=0;
		 double start  = System.nanoTime() ; 
		 q.quickSort(d, 0, d.length);
		 double end  = System.nanoTime() ; 
		 System.out.println("number of key comparisons is "+count);
		 count=0;
		 double start1  = System.nanoTime() ; 
		 q.quickSort(e, 0, e.length);
		 double end1  = System.nanoTime() ;
		 System.out.println("number of key comparisons is "+count);
		 count=0;
		 double start2  = System.nanoTime(); 
		 q.quickSort(f, 0, f.length);
		 double end2  = System.nanoTime() ; 
		 System.out.println("number of key comparisons is "+count);
		 for(int i=0;i<32;i++)
			{
				System.out.print(a[i]+" ");
				
			}
		 System.out.println("");
		 for(int i=0;i<32;i++)
			{
				System.out.print(b[i]+" ");
				
			}
		 
		 System.out.println("");
		 for(int i=0;i<32;i++)
			 
			{
				System.out.print(c[i]+" ");
				
			}
		 System.out.println("\nwhile n=1024 nanotime is "+(end-start));
		 System.out.println("\nwhile n=32768 nanotime is "+(end1-start1));
		 System.out.println("\nwhile n=1048576 nanotime is "+(end2-start2));
		 
	 }
	
	 ////////////////////////////////////////////////////////////////////////////////
    public  void quickSort(int[] pData,int left,int right)
    {
     int i ,j ;
     int middle,temp ;
     i = left ;
     j = right ;
     middle = pData[left] ;
     while(true)
     {
      while((++i)<right-1 && pData[i]<middle) ;
      while((--j)>left && pData[j]>middle) ;
      if(i>=j)
       break ;
      
         temp = pData[i] ;
         pData[i] = pData[j] ;
         pData[j] = temp ;
           count++;
     }
     pData[left] = pData[j] ;
     pData[j] = middle ;
     
       
     if(left<j)
      quickSort(pData,left,j) ;
     ///count++;
    
     if(right>i)
      quickSort(pData,i,right) ;
     ///count++;
    }
}
