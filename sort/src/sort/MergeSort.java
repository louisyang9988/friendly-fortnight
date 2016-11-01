package sort;



public class MergeSort {
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
			
			
		 MergeSort	 m = new  MergeSort();
		 m.sort(a);
		 System.out.println("number of key comparisons is "+count);
		 count=0;
		 m.sort(b);
		
		 System.out.println("number of key comparisons is "+count);
		 count=0;
		 m.sort(c);
		 System.out.println("number of key comparisons is "+count);
		 count=0;
		 double start  = System.nanoTime();
		 m.sort(d);
		 double end  = System.nanoTime();
		 System.out.println("number of key comparisons is "+count);
		 count=0;
		 double start1  = System.nanoTime();
		 m.sort(e);
		 double end1  = System.nanoTime();
		 System.out.println("number of key comparisons is "+count);
		 count=0;
		 double start2  =System.nanoTime();;
		 m.sort(f);
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
	 
	 ////////////////////////////////////////////////////////////////////////////
	 
	 public boolean compare (int x, int y)
	 {
		
		 
		 if (x>y)
		 {count++;
			return true;
	
		 }
		 else{
		 return false;
		 }		 
		 
		 
		 
		 
		 
	 }
	 ///////////////////////////////////////////////////////////////////////////
    public void sort(int[] data) {
        int[] temp=new int[data.length];
        mergeSort(data,temp,0,data.length-1);
    }
    
    private void mergeSort(int[] data,int[] temp,int l,int r){
        int mid=(l+r)/2;
        if(l==r) return ;
        mergeSort(data,temp,l,mid);
        mergeSort(data,temp,mid+1,r);
        for(int i=l;i<=r;i++){
            temp[i]=data[i];
        }
        int i1=l;
        int i2=mid+1;
        for(int cur=l;cur<=r;cur++){
            if(i1==mid+1)
            { data[cur]=temp[i2++];
            count++;}
            else if(i2>r)
                data[cur]=temp[i1++];
            else if(temp[i1]<temp[i2])
                data[cur]=temp[i1++];
            else
                data[cur]=temp[i2++];            
        }
    }

}