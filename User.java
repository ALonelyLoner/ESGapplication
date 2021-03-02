import java.util.ArrayList;
public class User {
    public String username;
    public ArrayList<Stock> portfolio;
    public String password;

    User(String usernameIn, String passwordIn) {
        this.username = usernameIn;
        this.password = passwordIn;
    }
    public ArrayList<Stock> getPortfolio() {
        return null;
    }

    public Stock addStock(String stockTicker) {
        return null;
    }

    public void removeStock(String stockTicker) {

    }
    public ArrayList<Stock> sortEnvironmental() {
        return null;
    }
    public ArrayList<Stock> sortGovernance() {
        return null;
    }
    public ArrayList<Stock> sortSocial() {
        return null;
    }
    public double getAverageESG() {
        return 0.0;
    }
    public ArrayList<Stock> getRecomendations(double lowBound, double upperBound) {
        return null;
    }

}
