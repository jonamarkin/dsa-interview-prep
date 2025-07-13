package grokking.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Box {
    int size;

    public Box(int size) {
        this.size = size;
    }
}

public class TruckPacking {

    public static List<Box> greedyPack(List<Box> boxes, int capacity) {
        boxes.sort((a,b)-> a.size - b.size);

        List<Box> result = new ArrayList<>();
        int capacityUsed = 0;

        for(Box box: boxes){
            if(capacityUsed + box.size <= capacity){
                result.add(box);
                capacityUsed += box.size;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        List<Box> boxes = Arrays.asList(
                new Box(6),
                new Box(4),
                new Box(5),
                new Box(2),
                new Box(3)
        );

        int capacity = 10;
        List<Box> result = greedyPack(boxes, capacity);

        System.out.println("Boxes packed (greedy):");
        for (Box b : result) {
            System.out.println("Box size: " + b.size);
        }
    }
}
