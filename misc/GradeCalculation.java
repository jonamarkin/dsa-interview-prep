package misc;

import java.util.List;

public class GradeCalculation {

    public static void main(String[] args) {
        List<Integer> grades = List.of(25,25,29,26,27,27,30,25,30,20,30,27);
        List<Integer> credits = List.of(9,9,9,9,6,9,9,9,6,6,6,9);

        int numerator = 0;
        for(int i = 0; i<grades.size(); i++){
            numerator+=grades.get(i) * credits.get(i);
        }

        int denominator = credits.stream().mapToInt(Integer::intValue).sum();

        System.out.println(numerator);
        System.out.println(denominator);

        int average = numerator/denominator;
        System.out.println("The average " + average);

        System.out.println("Final " + average * 110/30);
    }
}
