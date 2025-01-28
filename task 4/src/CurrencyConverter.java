import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class CurrencyConverter {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/1b96ba6c21724587a0c80c0e/latest/";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter!");
        System.out.print("Enter the base currency (e.g., INR, USD, EUR, GBP): ");
        String baseCurrency = sc.next().toUpperCase();
        System.out.print("Enter the target currency (e.g., INR, USD, EUR, GBP): ");
        String targetCurrency = sc.next().toUpperCase();

        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
        if (exchangeRate == -1) {
            System.out.println("Error: Could not fetch exchange rate. Please check the currencies entered.");
            return;
        }

        System.out.print("Enter the amount to convert: ");
        double amount = sc.nextDouble();

        double convertedAmount = amount * exchangeRate;

        System.out.printf("%.2f %s is equal to %.2f %s\n", amount, baseCurrency, convertedAmount, targetCurrency);

        sc.close();
    }

    private static double getExchangeRate(String baseCurrency, String targetCurrency) {
        try {
            URL url = new URL(API_URL + baseCurrency);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            Scanner responseScanner = new Scanner(connection.getInputStream());
            StringBuilder response = new StringBuilder();
            while (responseScanner.hasNext()) {
                response.append(responseScanner.nextLine());
            }
            responseScanner.close();

            JSONObject jsonResponse = new JSONObject(response.toString());

            if (!jsonResponse.getString("result").equals("success")) {
                return -1;
            }

            JSONObject conversionRates = jsonResponse.getJSONObject("conversion_rates");
            return conversionRates.getDouble(targetCurrency);

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
