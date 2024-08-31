package Currency;

import java.util.*;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Hard-coded exchange rates for common currencies (from USD)
        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0); // Base currency
        exchangeRates.put("EUR", 0.85); // 1 USD = 0.85 EUR
        exchangeRates.put("INR", 74.50); // 1 USD = 74.50 INR
        exchangeRates.put("GBP", 0.75); // 1 USD = 0.75 GBP
        exchangeRates.put("JPY", 110.0); // 1 USD = 110 JPY
        exchangeRates.put("AUD", 1.35); // 1 USD = 1.35 AUD

        // Step 2: Get Base Currency
        System.out.print("Enter base currency (e.g., USD, EUR): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        // Step 3: Get Target Currency
        System.out.print("Enter target currency (e.g., INR, GBP): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Step 4: Get the amount to convert
        double amount = 0;
        while (true) {
            System.out.print("Enter amount to convert: ");
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount < 0) {
                    System.out.println("Amount must be a positive number. Please try again.");
                } else {
                    break;
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // Clear the invalid input
            }
        }

        // Step 5: Check if currencies exist in exchange rate map
        if (!exchangeRates.containsKey(baseCurrency) || !exchangeRates.containsKey(targetCurrency)) {
            System.out.println("Error: Invalid currency code. Please enter a valid currency.");
            return;
        }

        // Step 6: Convert currency
        double baseRate = exchangeRates.get(baseCurrency);
        double targetRate = exchangeRates.get(targetCurrency);

        // Convert the amount from base currency to target currency
        double convertedAmount = (amount / baseRate) * targetRate;

        // Step 7: Display Result
        System.out.printf("Converted Amount: %.2f %s\n", convertedAmount, targetCurrency);
    }
}
