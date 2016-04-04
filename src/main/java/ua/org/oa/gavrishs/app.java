package ua.org.oa.gavrishs;

import java.util.Date;

/**
 * Created by Anna on 04.04.2016.
 */
public class app {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        String dateStr = "2015-01-01";
        int[] dateInt = new int[3];
        int i = 0;

        for (String s : dateStr.split("-")) {
            System.out.println(s);
            dateInt[i++] = Integer.parseInt(s);
        }
        System.out.println( new Date(dateInt[0]-1900,dateInt[1],dateInt[2]));
    }
}
