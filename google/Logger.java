package google;

import java.util.HashMap;
import java.util.Map;

public class Logger {


    public static void main(String[] args) {

    }

    /*
    Design a logger system that receives a stream of messages along with their timestamps.
    Each unique message should only be printed at most every 10 seconds (i.e. a
    message printed at timestamp t will prevent other identical messages from being printed until timestamp t + 10).


    All messages will come in chronological order. Several messages may arrive at the same timestamp.

    Implement the Logger class:

    Logger() Initializes the logger object.
    bool shouldPrintMessage(int timestamp, string message) Returns true if the message should be printed in the given timestamp, otherwise returns false.
     */

    Map<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        int allowedTimestamp = map.getOrDefault(message, 0);
        if (allowedTimestamp > timestamp){
            return false;
        }else{
            map.put(message, timestamp + 10);
            return true;
        }
    }
}
