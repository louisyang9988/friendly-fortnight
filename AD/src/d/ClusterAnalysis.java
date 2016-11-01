package d;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class ClusterAnalysis {
   public List<Cluster> startAnalysis(List<DataPoint> dataPoints,int ClusterNum){
      List<Cluster> finalClusters=new ArrayList<Cluster>();
    
      List<Cluster> originalClusters=initialCluster(dataPoints);
      finalClusters=originalClusters;
      while(finalClusters.size()>ClusterNum){
          double min=Double.MAX_VALUE;
          double sum=0;
          int mergeIndexA=0;
          int mergeIndexB=0;
          for(int i=0;i<finalClusters.size();i++){
              for(int j=0;j<finalClusters.size();j++){
                  if(i!=j){
                      Cluster clusterA=finalClusters.get(i);
                      Cluster clusterB=finalClusters.get(j);

                      List<DataPoint> dataPointsA=clusterA.getDataPoints();
                      List<DataPoint> dataPointsB=clusterB.getDataPoints();
                        double tempDis=0;
                      for(int m=0;m<dataPointsA.size();m++){
                    	  double b =0;
                          for(int n=0;n<dataPointsB.size();n++){
                               tempDis=getDistance(dataPointsA.get(m),dataPointsB.get(n));
                             
                              sum+=tempDis;
                              
                             /*if(tempDis>min){
                                  min=tempDis;
                                  mergeIndexA=i;
                                  mergeIndexB=j;
                              }*/
                          }
                         
                      }
                      double avgDis = sum/(dataPointsA.size()*dataPointsB.size());
                      if(tempDis<min){
                          min=tempDis;
                          mergeIndexA=i;
                          mergeIndexB=j;
                      }
                      
                  }
                  
              } //end for j
              
          }// end for i
          //merge cluster[mergeIndexA] and cluster[mergeIndexB]
          finalClusters=mergeCluster(finalClusters,mergeIndexA,mergeIndexB);
      }//end while

      return finalClusters;
   }
   private List<Cluster> mergeCluster(List<Cluster> clusters,int mergeIndexA,int mergeIndexB){
       if (mergeIndexA != mergeIndexB) {
           // put tDataPoint of cluster[mergeIndexB] into cluster[mergeIndexA]
           Cluster clusterA = clusters.get(mergeIndexA);
           Cluster clusterB = clusters.get(mergeIndexB);

           List<DataPoint> dpA = clusterA.getDataPoints();
           List<DataPoint> dpB = clusterB.getDataPoints();

           for (DataPoint dp : dpB) {
               DataPoint tempDp = new DataPoint();
               tempDp.setDataPointName(dp.getDataPointName());
               tempDp.setDimensioin(dp.getDimensioin());
               tempDp.setCluster(clusterA);
               dpA.add(tempDp);
           }

           clusterA.setDataPoints(dpA);

           // List<Cluster> clusters remove cluster[mergeIndexB]
           clusters.remove(mergeIndexB);
       }

       return clusters;
  }

  // initialize
  private List<Cluster> initialCluster(List<DataPoint> dataPoints){
      List<Cluster> originalClusters=new ArrayList<Cluster>();
      for(int i=0;i<dataPoints.size();i++){
          DataPoint tempDataPoint=dataPoints.get(i);
          List<DataPoint> tempDataPoints=new ArrayList<DataPoint>();
          tempDataPoints.add(tempDataPoint);

          Cluster tempCluster=new Cluster();
          tempCluster.setClusterName("Cluster "+String.valueOf(i));
          tempCluster.setDataPoints(tempDataPoints);

          tempDataPoint.setCluster(tempCluster);
          originalClusters.add(tempCluster);
      }

      return originalClusters;
  }

  //calculate the distance between two points
  private static double getDistance(DataPoint dpA,DataPoint dpB){
       double distance=0;
       double[] dimA = dpA.getDimensioin();
       double[] dimB = dpB.getDimensioin();

       if (dimA.length == dimB.length) {
           for (int i = 0; i < dimA.length; i++) {
                double temp=Math.pow((dimA[i]-dimB[i]),2);
                distance=distance+temp;
           }
           distance=Math.pow(distance, 0.5);
       }

      return distance;
  }
///////////
  
  public static void main(String[] args){
      ArrayList<DataPoint> dpoints = new ArrayList<DataPoint>();
      ArrayList<DataPoint> outliers = new ArrayList<DataPoint>();
     
      String input_filepath= "d:/randomnumber2.txt";
      File f = new File(input_filepath);
      FileReader fr;
      BufferedReader br;
      String singleLine, s[];
      int clusterNum=6; //number of clusters
      
      //input file
      int count =1;
      try {
          fr = new FileReader(f);
          br = new BufferedReader(fr);
          try {
              while ((singleLine = br.readLine()) != null) {
                  s = singleLine.split(" ");
                  double[] p = {Double.parseDouble(s[0]),Double.parseDouble(s[1]),Double.parseDouble(s[2])};
                  
                  dpoints.add(new DataPoint(p,""+count));
                  s = null;
                  count++;
                  }
              br.close();
              fr.close();
              
          
          } catch (IOException ex) {
          }
      } catch (FileNotFoundException ex) {
      }

    //find outliers
      
   int c1=0;
      for (int m=0;m<dpoints.size();m++) 
      {
    	  c1=0;
    	  for (int n=0;n<dpoints.size();n++ )
    	  {
    		  double Distance=getDistance(dpoints.get(m),dpoints.get(n));
    		  if (Distance>550)
    		  {   c1++;
    			  //dpoints.remove(dpoints.get(m));
    			  
    			 
    		  }
    		  
    		  if(c1>425)
    		  {
    			  //dpoints.remove(m);
    			  outliers.add(dpoints.get(m));
    			  break;
    		  }
    		  
    	  }
    	 
    	  
    	  
      }
     ////////////////////////////////////////////
     dpoints.removeAll(outliers);// remove outliers
     if(outliers.size()==0)
     
     {
    	 System.out.println("There are no outliers :");
     }
     else
     {
      System.out.println("outliers are :");
      for (int k=0;k<outliers.size();k++) 
    	  
      {
    	 System.out.print(outliers.get(k).dataPointName+",");
    	 
    	  
      }
      
      
      
     }
     
      
  /////////////////////////////////////////////////////////////////////////////
   

     ClusterAnalysis ca=new ClusterAnalysis();
      List<Cluster> clusters=ca.startAnalysis(dpoints, clusterNum);
            int c =0;
      for(Cluster cl:clusters){
    	  System.out.println("");
          System.out.println("------"+cl.getClusterName()+"------");
          List<DataPoint> tempDps=cl.getDataPoints();
          for(DataPoint tempdp:tempDps){
        	  if (c<20)
              {System.out.print(tempdp.getDataPointName()+" ");
        	  c++;
        	  }
        	  else 
        		  if (c==20)
        		  { System.out.println(tempdp.getDataPointName()+" ");
        		  c=0;
        		  }
        	  
          }
      }

  }
}