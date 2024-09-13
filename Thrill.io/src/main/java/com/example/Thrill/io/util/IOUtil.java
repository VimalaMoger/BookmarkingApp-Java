package com.example.Thrill.io.util;

import java.io.*;
import java.util.List;

//utility class
public class IOUtil {

    public static String read(InputStream in) {
        //to build the web content
        StringBuilder text = new StringBuilder();
        //try with resources
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line).append("\n");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    public static void write(String webpage, long id) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("pages/" + String.valueOf(id) + ".html"), "UTF-8"))) {
            writer.write(webpage);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


