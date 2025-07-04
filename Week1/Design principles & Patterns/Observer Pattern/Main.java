public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("MobileApp");
        Observer webApp = new WebApp("WebApp");

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStock("AAPL", 192.34);
        stockMarket.setStock("GOOGL", 2894.56);

        stockMarket.removeObserver(mobileApp);
        stockMarket.setStock("TSLA", 765.23);
    }
}
