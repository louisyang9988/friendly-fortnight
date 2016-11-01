



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Apriori {

	private final double minsup = 0.2;// 
	private final double minconf = 0.3;// 
       private final TreeSet data = new TreeSet();
	
	private final IdentityHashMap ruleMap = new IdentityHashMap();
        
        String[] D = buildData("C:\\Users\\Yang\\Desktop\\T5.txt");
        
	private final String[] transSet = D;
							
        
	private int itemCounts = 0;
	private final TreeSet[] frequencySet = new TreeSet[40];
	private TreeSet maxFrequency = new TreeSet();
	private final TreeSet candidate = new TreeSet();
	private final TreeSet candidateSet[] = new TreeSet[40];
	private int frequencyIndex;

	public Apriori() {

		maxFrequency = new TreeSet();
		itemCounts = counts();// 

		// 初始化其他两个
		for (int i = 0; i < itemCounts; i++) {
			frequencySet[i] = new TreeSet();//Initialize the frequent set array
			candidateSet[i] = new TreeSet();//Initialize the candidate set array
		}
		candidateSet[0] = candidate;// 
                
	}

	//main
	public static void main(String[] args) {
		Apriori ap = new Apriori();
		ap.run();
	}
	
	//方法运行
	public void run() {
		int k = 1;
		item1_gen();

		do {
			k++;
			canditate_gen(k);
			frequent_gen(k);
		} while (!is_frequent_empty(k));
		frequencyIndex = k - 1;
		
		maxfrequent_gen();
		
		ruleGen();
		rulePrint();
	}
	
 public String convert(String itemName )
 {
     String a="";
 switch (itemName) {
  case "laptop":
       a="a";
       break;
  case "cellphone":
       a="b";
       break;
  case "television":
       a="c";
       break;
  case "cloth":
       a="d";
       break;
  case "coat":
       a="e";
       break;
       case "cap":
       a="f";
       break;
       case "book":
       a="g";
       break;
       case "pen":
       a="h";
       break;
       case "ink":
       a="i";
       break;
       case "camera":
       a="j";
       break;
       case "a":
       a="laptop";
       break;
       case "b":
           a="cellphone";
           break;
      case "c":
           a="television";
           break;
      case "d":
           a="cloth";
           break;
      case "e":
           a="coat";
           break;
           case "f":
           a="cap";
           break;
           case "g":
           a="book";
           break;
           case "h":
           a="pen";
           break;
           case "i":
           a="ink";
           break;
           case "j":
           a="camera";
           break;
       
 default:
      ;
 }


 return a;
 
 
 
 }
 public String convert1(String itemName )
 {
	 String s="";
	 
	 for (int i=0;i<=itemName.length()-1;i++)
	 { char a=itemName.charAt(i);
	 
	 switch(a)
	 {
	 case 'a':
		 s+="laptop ";
	     break;
	 case 'b':
	     s+="cellphone ";
	     break;
	 case 'c':
		 s+="television ";
	     break;
	 case 'd':
	     s+="cloth ";
	     break;
	 case 'e':
		 s+="coat ";
	     break;
	 case 'f':
	     s+="cap ";
	     break;
	 case 'g':
		 s+="book ";
	     break;
	 case 'h':
	     s+="pen ";
	     break;
	 case 'i':
		 s+="ink ";
	     break;
	 case 'j':
	     s+="camera ";
	     break;
	     
	     
	 }
	 
	 }
	 
	 
	 return s;
 }

 public String[]  buildData(String...fileName){
 String data="";
 int count=1;

  if(fileName.length != 0){
   File file = new File(fileName[0]);
   try{
    BufferedReader reader = new BufferedReader(new FileReader(file));
    String line;
    int len=Integer.parseInt(reader.readLine());
    String[] data1=new String[len];
    while( ( line = reader.readLine()) != null ){
        data="";
    String[]a= line.split(" ");
     for(int i=0;i<=a.length-1;i++)
         
     {
      data+=convert(a[i]);
       
         
     }
     data1[count-1]=data;
     count++;
    }
    return data1;
   }catch (FileNotFoundException e){
    e.printStackTrace();
   }catch (IOException e){
    e.printStackTrace();
   }
  }
  String[] data2=new String[2];
  data2[1]="a";
 return data2;
 }
	public double count_sup(String x) {
		int temp = 0;
		for (int i = 0; i < transSet.length; i++) {
			for (int j = 0; j < x.length(); j++) {
				if (transSet[i].indexOf(x.charAt(j)) == -1)//返回指定字符在此字符串中第一次出现处的索引，如果不作为一个字符串，返回-1
					break;
				else if (j == (x.length() - 1))
					temp++;
			}
		}
		return temp;
	}
	
	//统计1候选集的个数a,b,c,d,e,f,return值为6
	public int counts() {

		String temp1 = null;
		char temp2 = 'a';
		// 
		for (int i = 0; i < transSet.length; i++) {
			temp1 = transSet[i];
			for (int j = 0; j < temp1.length(); j++) {
				temp2 = temp1.charAt(j);
				candidate.add(String.valueOf(temp2));
			}
		}
		return candidate.size();//
	}

	//
	public void item1_gen() {
		String temp1 = "";
		double m = 0;

		Iterator temp = candidateSet[0].iterator();
		while (temp.hasNext()) {
			temp1 = (String) temp.next();
			m = count_sup(temp1);

			// 
			if (m >= minsup * transSet.length) {
				frequencySet[0].add(temp1);
			}
		}
	}
	//求K候选集
	public void canditate_gen(int k) {
		String y = "", z = "", m = "";
		char c1 ,c2 ;

		Iterator temp1 = frequencySet[k - 2].iterator();
		Iterator temp2 = frequencySet[0].iterator();
		TreeSet h = new TreeSet();

		while (temp1.hasNext()) {
			y = (String) temp1.next();//
			c1 = y.charAt(y.length() - 1);

			while (temp2.hasNext()) {
				z = (String) temp2.next();

				c2 = z.charAt(0);
				if (c1 >= c2)
					continue;
				else {
					m = y + z;
					h.add(m);
				}
			}
			temp2 = frequencySet[0].iterator();
		}
		candidateSet[k - 1] = h;
	}

	
	public void frequent_gen(int k) {
		String s1 = "";

		Iterator ix = candidateSet[k - 1].iterator();
		while (ix.hasNext()) {
			s1 = (String) ix.next();
			if (count_sup(s1) >= (minsup * transSet.length)) {
				frequencySet[k - 1].add(s1);
			}
		}
	}
    
	public boolean is_frequent_empty(int k) {
		if (frequencySet[k - 1].isEmpty())
			return true;
		else
			return false;
	}

  
	public void maxfrequent_gen() {
		int i;
		for (i = 1; i < frequencyIndex; i++) {
			maxFrequency.addAll(frequencySet[i]);
		}
	}
   
	
	public void ruleGen() {
		String s;
		Iterator iterator = maxFrequency.iterator();
		while (iterator.hasNext()) {
			s = (String) iterator.next();
			subGen(s);
		}
	}

   
	public void subGen(String s) {
		String x = "", y = "";
		for (int i = 1; i < (1 << s.length()) - 1; i++) {
			for (int j = 0; j < s.length(); j++) {
				if (((1 << j) & i) != 0) {
					x += s.charAt(j);
				}
			}

			for (int j = 0; j < s.length(); j++) {
				if (((1 << j) & (~i)) != 0) {

					y += s.charAt(j);

				}
			}
			if (count_sup(x + y) / count_sup(x) >= minconf) {
				ruleMap.put(x, y);
			}
			x = "";
			y = "";

		}
	}


	
	public void rulePrint() {
		String x, y;
		float temp = 0;

		Set hs = ruleMap.keySet();
		Iterator iterator = hs.iterator();
		System.out.println("Assotiation Rules：");
		while (iterator.hasNext()) {
			x = (String) iterator.next();

			y = (String) ruleMap.get(x);

			temp = (float) (count_sup(x + y) / count_sup(x));

			System.out.println(convert1(x) + (x.length() < 5 ? "\t" : "") + "-->" + convert1(y)+ "\t" + "confident: " + temp);

		}
	}

   




}
