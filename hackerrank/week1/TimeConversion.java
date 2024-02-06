package hackerrank.week1;

/*
 * Given a time in 12-hour AM/PM format, convert it to military (24-hour) time. 
 * Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
 * 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
 */
public class TimeConversion {
    public static String timeConversion(String s) {
        // Write your code here
        String[] time = s.split(":");
        String hour = time[0];
        String min = time[1];
        // The last split after the last : contains both seconds and period
        String secPeriod = time[2];
        // To get the second and period we need to substring the secperiod
        String sec = time[2].substring(0, secPeriod.length() - 2);
        String period = time[2].substring(secPeriod.length() - 2, secPeriod.length());
        String militaryHour = "";

        if (period.equalsIgnoreCase("AM")) {
            if (hour.equals("12")) {
                militaryHour = "00";
            } else {
                militaryHour = hour;
            }
        } else {
            if (hour.equals("12")) {
                militaryHour = hour;
            } else {
                militaryHour = Integer.toString(Integer.parseInt(hour) + 12);
            }
        }

        return militaryHour + ":" + min + ":" + sec;

    }

    public static String timeConversion2(String s) {
        int hour = Integer.parseInt(s.substring(0, 2));
        int minutes = Integer.parseInt(s.substring(3, 5));
        int seconds = Integer.parseInt(s.substring(6, 8));
        String period = s.substring(8, 10);

        if ("PM".equals(period) && hour != 12) {
            hour += 12;
        } else if ("AM".equals(period) && hour == 12) {
            hour = 0;
        }

        return String.format("%02d:%02d:%02d", hour, minutes, seconds);

    }

    /*
     * The format specifier %02d is used in languages like C, C++, Java, and others
     * to format an integer variable as a decimal number, filling in leading zeros
     * to at least 2 digits.
     * 
     * % indicates the start of the format specifier.
     * 0 is the flag for zero-padding. This means that if the number has fewer
     * digits than specified (in this case, fewer than 2), it will be padded with
     * zeros from the left.
     * 2 specifies the minimum width of the field. If the number has fewer than 2
     * digits, it will be padded with zeros to meet this width.
     * d indicates that the argument should be formatted as a decimal (base-10)
     * integer.
     * For example:
     * 
     * String.format("%02d", 3) will produce the string "03".
     * String.format("%02d", 12) will produce the string "12".
     * String.format("%02d", 0) will produce the string "00".
     */

    public static void main(String[] args) {
        System.out.println(timeConversion("07:05:45PM"));
    }

}
