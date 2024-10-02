package faang.amazon;

import java.util.*;

public class ReOrderLogFiles {
    public String[] reorderLogFiles(String[] logs) {

        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log: logs){
            if (Character.isLetter(log.split(" ",2)[1].charAt(0))){
                letterLogs.add(log);
            }else{
                digitLogs.add(log);
            }
        }

        //Sort the letter logs
        Collections.sort(letterLogs, new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                String[] split1 = log1.split(" ",2);
                String[] split2 = log2.split(" ",2);

                int contentCompare = split1[1].compareTo(split2[1]);
                if (contentCompare!=0){
                    return contentCompare;
                }
                return split1[0].compareTo(split2[0]);
            }
        });

        //Combine the sorted letter logs and digit logs
        letterLogs.addAll(digitLogs);

        return letterLogs.toArray(new String[0]);

    }



    public String[] reorderLogFiles2(String[] logs) {

        Arrays.sort(logs, (log1, log2) ->{

            String[] split1 = log1.split(" ",2);
            String[] split2 = log2.split(" ",2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if (!isDigit1 && !isDigit2){
                int compare = split1[1].compareTo(split2[1]);
                if (compare!=0){
                    return compare;
                }
                return split1[0].compareTo(split2[0]);
            }

            if (!isDigit1 && isDigit2){
                return -1;
            } else if (!isDigit2 && isDigit1) {
                return 1;
            }

            return 0;
        });

        return logs;
    }
}
