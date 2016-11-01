package d;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class BuildRandomNumber {

	static void main()
	{
          BuildRandomNumber brn = new BuildRandomNumber(500, 1000, 1000,1000);
	     brn.build();
	    String output = "d:/randomnumber00.txt";
	      brn.outFile(output);
		
		
	}
	
	
    private int count;
    private int x_max;
    private int y_max;
    private int z_max;
    private ArrayList<StringBuilder> list;

    public BuildRandomNumber(int count, int x_max, int y_max,int z_max) {
        this.count = count;
        this.x_max = x_max;
        this.y_max = y_max;
        this.z_max = z_max;
        this.list = new ArrayList();
    }

    public ArrayList build() {
        StringBuilder sb;
        String x_random, y_random,z_random;
        while (list.size() < count) {
            sb = new StringBuilder();
            x_random = Double.toString(Math.random() * x_max);
            y_random = Double.toString(Math.random() * y_max);
            z_random = Double.toString(Math.random() * z_max);
            sb.append(x_random).append(" ").append(y_random).append(" ").append(z_random);
            if (!list.contains(sb)) {
                list.add(sb);
            }
            sb = null;
        }
        return list;
    }

    public void outFile(String output) {
        StringBuilder singleLine;
        File f = new File(output);
        if (f.exists()) {
            f.delete();
        }
        FileWriter fw;
        BufferedWriter bw;
        try {
            fw = new FileWriter(f, true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < list.size(); i++) {
                singleLine = new StringBuilder();
                System.out.println(list.get(i));
                singleLine.append(list.get(i).toString()).append("\r\n");
                bw.write(singleLine.toString(), 0, singleLine.length());
                singleLine = null;
            }
            bw.close();
            fw.close();
        } catch (IOException ex) {
        }
    }

    public void run() {
        BuildRandomNumber brn = new BuildRandomNumber(1000, 99, 99,99);
        build();
        String output = "d:/randomnumber.txt";
        outFile(output);
    }
}
