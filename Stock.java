import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
public class Stock {
    //Constructor
    public String stockTicker;
    Stock(String stockTickerIn) {
        this.stockTicker = stockTickerIn;
    }
    // This method return all stock stats in an array pf Hashmaps
    public ArrayList<HashMap<String, String>> getStockStats() {
        ArrayList<HashMap<String, String>> info = new ArrayList<HashMap<String, String>>();
        APIManager API = new APIManager();
        String ESGStats;
        String price;
        String headlines;
        try {
            ESGStats = API.getESGStats(stockTicker);
            price = API.getStockPrice(stockTicker);
            headlines = API.getHeadline(stockTicker);
        } catch (IOException e) {
            return null;
        }
        if (ESGStats == "GET NOT WORKED") {
            return null;
        }
        HashMap<String, String> ESGMap = stringToMap(ESGStats);
        HashMap<String, String> priceMap = stringToMap(price);
        HashMap<String, String> headlineMap = stringToMap(headlines);
        info.add(ESGMap);
        info.add(priceMap);
        info.add(headlineMap);
        return info;

    //Method turns string into hashmap
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
            myMap.put(keyValue[0], keyValue[1]);
        }
        return myMap;
    }
}
