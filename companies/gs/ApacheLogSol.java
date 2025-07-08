package companies.gs;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApacheLogSol {

    static String IPADDRESS_PATTERN = "([0-9]{1,3}\\.){3}[0-9]{1,3}";

    public static Set<String> findTopIpAddresses(String[] lines) {

        if (lines == null || lines.length == 0) {
            return null;
        }

        Pattern pattern = Pattern.compile(IPADDRESS_PATTERN, Pattern.CASE_INSENSITIVE);
        Map<String, Integer> ipAddressCountMap = new HashMap<>();

        Arrays.stream(lines).forEach(line -> {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String ipAddress = matcher.group();
                ipAddressCountMap.put(ipAddress, ipAddressCountMap.getOrDefault(ipAddress, 0) + 1);
            } else {
                System.out.println("Invalid IP Address");
            }

        });

        if (ipAddressCountMap.isEmpty()) {
            return null;
        }

        Set<String> topIps = new HashSet<>();
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : ipAddressCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                topIps.clear();
                topIps.add(entry.getKey());
            } else if (entry.getValue() == maxCount) {
                topIps.add(entry.getKey());
            }
        }

        return topIps;
    }

    public static void main(String[] args) {
        String[] lines = {"192.168.127.12 - - [01/Jan/2019:00:00:00 -0800] \"GET / HTTP/1.1\" 200 2326",
                "172.16.17.32 - - [01/Jan/2019:00:00:00 -0800] \"GET / HTTP/1.1\" 200 2326",
                "172.16.17.32 - - [01/Jan/2019:00:00:00 -0800] \"GET / HTTP/1.1\" 200 2326"};

        Set<String> topIps = findTopIpAddresses(lines);
        System.out.println(topIps);
    }
}


