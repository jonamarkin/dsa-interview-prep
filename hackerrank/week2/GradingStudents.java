package hackerrank.week2;

import java.util.ArrayList;
import java.util.List;

public class GradingStudents {
    public static void main(String[] args) {

    }

    public static List<Integer> gradingStudents(List<Integer> grades) {

        // Loop through the grades
        // Check if a number is a multiple of 5 leeave it
        // If not not multiple of 5 ,check if it is less than 38, leave it as well
        // Otherwise check if the difference between the number and the next multiple of
        // 5 is less than 3 then round it up
        // Else leave it

        // I can use a logical OR for some operations

        List<Integer> resultGrades = new ArrayList<>();
        for (int grade : grades) {

            // Use logical OR to check if less than 38 or already a multiple of 5
            if (grade < 38 || grade % 5 == 0) {
                resultGrades.add(grade);
            } else {

                // Find the next multiple of 5
                int nextMultipleOfFive = (grade / 5 + 1) * 5;

                if (Math.abs(nextMultipleOfFive - grade) < 3) {
                    resultGrades.add(nextMultipleOfFive);
                } else {
                    resultGrades.add(grade);
                }

            }

        }

        return resultGrades;

    }
}
