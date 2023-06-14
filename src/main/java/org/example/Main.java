package org.example;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        String urlString = "https://api.zippopotam.us/us/33162";

        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e){
            System.out.println("Problem in URL");
        }

        // connection
        HttpURLConnection conn = null;
        int ResponseValue = 0;
        try {
            conn = (HttpURLConnection) url.openConnection();
            ResponseValue = conn.getResponseCode();
        }catch (Exception e){
            System.out.println("Connection Problem");
        }

        if(ResponseValue == 200){
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder data = new StringBuilder();
            String readLine = null;

            while ((readLine = in.readLine()) != null){
                data.append(readLine);
            }
            JSONObject jsonData = new JSONObject(data.toString());

            System.out.println(jsonData.toString(1));

            in.close();
        }else {
            System.out.println("API not Working");
        }


    }
}
