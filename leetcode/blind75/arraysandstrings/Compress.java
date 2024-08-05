package leetcode.blind75.arraysandstrings;

public class Compress {

    public int compress(char[] chars) {

        int index = 0;
        int i = 0;

        while (i <chars.length){
            char currentChar = chars[i];
            int count = 0;

            while (i <chars.length && chars[i] ==currentChar){
                i++;
                count++;
            }

            //Write the char
            chars[index++] = currentChar;

            if (count >1){
                String countStr = String.valueOf(count);
                for(char c : countStr.toCharArray()){
                    chars[index++] = c;
                }
            }
        }

        return index;
    }
}
