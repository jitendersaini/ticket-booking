package com.booking.management.api.helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Jitender Saini
 */
public class Helper {
    public static String[] read_file(String fileName) throws IOException {
        String s = "";
        StringBuffer sb = new StringBuffer();
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        while((s = br.readLine()) != null)
        {
            sb.append(s);
        }
        br.close();
        return sb.toString().split(";");
    }
}
