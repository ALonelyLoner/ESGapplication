import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
public class Stock {
    //Constructor
    public String stockTicker;
    Stock(String stockTickerIn) {

        this.stockTicker = stockTickerIn;
    }

    // This method return all stock stats in an array pf Hashmaps
    public HashMap<String, String> getESGStats() {
        HashMap<String, String> info = new HashMap<String, String>();
        APIManager API = new APIManager();
        String ESGStats;
        try {
            ESGStats = API.getESGStats(stockTicker);
        } catch (IOException e) {
            return null;
        }
        if (ESGStats == "GET NOT WORKED") {
            return null;
        }
        HashMap<String, String> ESGMap = stringToMap(ESGStats);
        return ESGMap;

    //Method turns string into hashmap
    }

    public HashMap<String, String> getStockPrice() {
        HashMap<String, String> info = new HashMap<String, String>();
        APIManager API = new APIManager();

        String price;

        try {
            price = API.getStockPrice(stockTicker);
        } catch (IOException e) {
            return null;
        }
        if (price == "GET NOT WORKED") {
            return null;
        }
        HashMap<String, String> priceMap = stringToMap(price);
        return priceMap;

        //Method turns string into hashmap
    }

    public HashMap<String, String> getHeadline() {
        HashMap<String, String> info = new HashMap<String, String>();
        APIManager API = new APIManager();
        String headlines;
        try {
            headlines = API.getHeadline(stockTicker);
        } catch (IOException e) {
            return null;
        }
        if (headlines == "GET NOT WORKED") {
            return null;
        }
        HashMap<String, String> headlineMap = stringToMap(headlines);
        return headlineMap;
    }


    private HashMap<String, String> stringToMap(String inputString) {
        String[] keyValue = new String[2];
        HashMap<String, String> myMap = new HashMap<String, String>();
        String[] pairs = inputString.split(",");
        for (int i=0;i<pairs.length;i++) {
            String pair = pairs[i];
            keyValue = pair.split(":");
            if (keyValue.length == 1) {
                String[] keyValue2 = new String[keyValue.length + 1];
                System.arraycopy(keyValue, 0, keyValue2, 0, keyValue.length);
                keyValue2[keyValue.length] = "";
                keyValue = keyValue2;
            }
            myMap.put(keyValue[0].replace("\"", ""), keyValue[1].replaceAll("[^a-zA-Z0-9_.]", ""));
        }
        return myMap;
    }
    public static void main(String[] args) {
        Stock amazon = new Stock("amzn");
        HashMap<String, String> list = new HashMap<String, String>();
        list = amazon.getStockPrice();
        Set<String> marketPrice = list.keySet();
        System.out.println(marketPrice);
    }
}
