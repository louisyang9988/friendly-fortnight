package d;

import java.util.ArrayList;
import java.util.List;


public class Cluster {
    private List<DataPoint> dataPoints = new ArrayList<DataPoint>(); // 类簇中的样本点
    private String clusterName;

   

    public void setDataPoints(List<DataPoint> dataPoints) {
        this.dataPoints = dataPoints;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

	public List<DataPoint> getDataPoints() {
		// TODO Auto-generated method stub
		 return dataPoints;
	}

}