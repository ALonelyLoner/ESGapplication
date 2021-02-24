import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import java.util.Scanner;

public class MyGETRequest {
    public static void main(String[] args) throws IOException{


        URL urlForGetRequest = new URL("https://esg-environmental-social-governance-data.p.rapidapi.com/search?q=");
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection)  urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("x-rapidapi-key", "b80807b1a5msh3eba98eb9edefc2p19c5a8jsn8b514252820e");
        connection.setRequestProperty("x-rapidapi-host", "esg-environmental-social-governance-data.p.rapidapi.com");


        int responseCode = connection.getResponseCode();


        if (responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(new GZIPInputStream(connection.getInputStream())));
            StringBuffer response = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();
            System.out.println("JSON String Result " + response.toString());
        }
        else{
            System.out.println("GET NOT WORKED");
        }





    }
}
