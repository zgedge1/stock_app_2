
package com.stockapp1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class stockappnogui {

    public static String apiKey = "Enter API KEy";
    public static String apiURl = "https://api.twelvedata.com/time_series";

    public static void main(String[] args) {
        
        System.out.println("Welcome to Stock App: \n");

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Enter a ticker or type 'quit' at anytime to exit: \n");
            String tickerinp = scanner.nextLine();

            if (tickerinp.equals("quit")) {
                System.out.println("Exiting Stock App\n");
                break;  
            }

            if (tickerinp.isBlank()) {
                System.out.println("ERROR: Ticker entery cannot be blank:");
                continue;  
            }

            try {
                
                URI uri = new URI(buildApiUrl(tickerinp));
                URL url = uri.toURL();

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                
                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {

                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    String line;

                    StringBuffer response = new StringBuffer();

                    while ((line = reader.readLine())!= null) {
                        response.append(line);
                        
                    }

                    parseStockData(response.toString());
                    
                }


            } catch (Exception e) {
                // TODO: handle exception
            }

            
        }

    }

    public static String buildApiUrl(String tickerInp) {
        String symbols = tickerInp;
        String interval = "1min";

        return String.format("%s?symbol=%s&interval=%s&apikey=%s", apiURl, symbols, interval, apiKey);

    }

    private static void parseStockData(String stockInfo) {

        JSONObject json = new JSONObject(stockInfo);

        if (!json.has("values") || json.isEmpty()) {
            System.out.println("ERROR: No Ticker Found\n");
            return;
            
        }

        JSONArray valueArr = json.getJSONArray("values");
        JSONObject zero = valueArr.getJSONObject(0);

        String openPrice = zero.optString("open");
        String highPrice = zero.optString("high");
        String lowPrice = zero.optString("low");
        String closePrice = zero.optString("close");

        System.out.println("The Opening Price: " + openPrice + "\n");
        System.out.println("The High Price is: " + highPrice + "\n");
        System.out.println("The Low Price is: " + lowPrice + "\n");
        System.out.println("The Closing Price is:" + closePrice + "\n");

        
    }
}