
// Sample Java code to display HTTP request and response headers using HttpURLConnection

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HttpRequestResponseExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com/hello.txt");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Set request method
            connection.setRequestMethod("GET");

            // Display Request Headers
            System.out.println("Request Headers:");
            Map<String, List<String>> requestProperties = connection.getRequestProperties();
            for (Map.Entry<String, List<String>> entry : requestProperties.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            // Get Response Code
            int responseCode = connection.getResponseCode();
            System.out.println("\nResponse Code: " + responseCode);

            // Display Response Headers
            System.out.println("Response Headers:");
            Map<String, List<String>> headerFields = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            // Read and print the response content
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine).append("\n");
            }
            in.close();

            System.out.println("\nResponse Content:");
            System.out.println(content.toString());

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
