package sort;

public class HeapSort {
	
	static int count=0;
	
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
			
			
		 HeapSort	 h = new  HeapSort();
		 h.heapSort(a);
		 System.out.println("number of key comparisons is "+count);
		 count=0;
		 h.heapSort(b);
		 System.out.println("number of key comparisons is "+count);
		 count=0;
		 h.heapSort(c);
		 System.out.println("number of key comparisons is "+count);
		 count=0;
		 double start  = System.nanoTime();
		 h.heapSort(d);
		 double end  = System.nanoTime(); 
		 System.out.println("number of key comparisons is "+count);
		 count=0;
		 double start1  = System.nanoTime();
		 h.heapSort(e);
		 double end1  = System.nanoTime();
		 System.out.println("number of key comparisons is "+count);
		 count=0;
		 double start2  = System.nanoTime();
		 h.heapSort(f);
		 double end2  = System.nanoTime(); 
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
		 
		 System.out.println("\nwhile n=1024 time is "+(end-start));
		 System.out.println("\nwhile n=32768 time is "+(end1-start1));
		 System.out.println("\nwhile n=1048576 time is "+(end2-start2));
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	///////////////////////////////////////////////////////////////////////////////////////////////////////
	
    public  void heapSort(int[] array){
        buildHeap(array);
        int n = array.length;
        int i=0;
        for(i=n-1;i>=1;i--){
            swap(array,0,i);
            heapify(array,0,i);
            
            }
    }
    
    public static void buildHeap(int[] array){
        int n = array.length;
        for(int i=n/2-1;i>=0;i--)
            heapify(array,i,n);
            
    }
    public static void heapify(int[] A,int idx,int max){
        int left = 2*idx+1;
        int right =2*idx+2;
        int largest = 0;
        if(left<max && A[left]>A[idx])
            {largest = left;
           
           
       }
        else
        { largest = idx;
      
        }
        
        if(right<max && A[right]>A[largest])
        {   largest = right; count++;
       
        }
        if(largest!=idx){
        
            swap(A,largest,idx);
           
            heapify(A,largest,max);   
           

            }   

         
        
    }
    public static void swap(int[] array,int i,int j){
        int temp =0;
        temp=array[i];
        array[i]=array[j];
        array[j]=temp;
        
       
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
