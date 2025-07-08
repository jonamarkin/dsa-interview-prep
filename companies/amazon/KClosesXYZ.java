package companies.amazon;

import java.util.PriorityQueue;

public class KClosesXYZ {
    public static double[][] kClosesXYZ(double[][] points, int k){

        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a,b) ->(
            Double.compare(distanceFromOrigin(b), distanceFromOrigin(a))
        ));

        for (double[] point: points){
            maxHeap.offer(point);

            if (maxHeap.size() >k){
                maxHeap.poll();
            }
        }

        double[][] result = new double[k][3];

        for (int i= k-1; i>=0; i--){
            result[i] = maxHeap.poll();
        }

        return result;
    }

    public static double distanceFromOrigin(double[] point){
        return point[0] * point[0] + point[1] * point[1] + point[2] * point[2];
    }
}
