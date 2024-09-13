package com.example.Thrill.io.util;
import java.io.IOException;
import java.net.*;

public class HttpConnect {

    public static String download(String sourceUrl) throws MalformedURLException, URISyntaxException {
        System.out.println("Downloading: " + sourceUrl);
        //using java.net classes
        URL url = new URI(sourceUrl).toURL();

        try {
            // con represents a connection to the remote object
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            int responseCode = con.getResponseCode();

            if(responseCode >= 200 && responseCode < 301) { // ok
                return IOUtil.read(con.getInputStream());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

