package grokking.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ClassSchedule{
    String name;
    int startTime;
    int endTime;

    public ClassSchedule(String name, int startTime, int endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

public class ClassroomScheduling {
    /*
    Given:

    A list of classes, each with a start time and end time.

    You can’t hold overlapping classes.

    Objective:

    Select the maximum number of non-overlapping classes.

     */

    public static List<ClassSchedule> scheduleClasses(List<ClassSchedule> classes){

        List<ClassSchedule> result = new ArrayList<>();

        classes.sort((a,b)->a.startTime-b.startTime);
        int lastEndTime = -1;

        for(ClassSchedule c: classes){
            if(c.startTime>=lastEndTime){
                result.add(c);
                lastEndTime = c.endTime;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<ClassSchedule> classes = Arrays.asList(
                new ClassSchedule("Art", 9, 10),
                new ClassSchedule("Art",9, 11),  // e.g., 9:30 - 11:00
                new ClassSchedule("Art",10, 11),
                new ClassSchedule("Art",11, 12),
                new ClassSchedule("Art",13, 14)
        );

        List<ClassSchedule> selected = scheduleClasses(classes);

        System.out.println("Selected classes:");
        for (ClassSchedule cls : selected) {
            System.out.println("Start: " + cls.startTime + ", End: " + cls.endTime);
        }
    }
}
