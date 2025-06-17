import java.util.Scanner;
public class code {
    static final String[] currencies = {"USD", "INR", "EUR", "GBP"};
    static final double[][] rates = {
            {1.0,86.24,0.92,0.78} ,
            {0.0116,1.0,0.0109,0.0090} ,
            {1.087,93.75,1.0,0.853},
            {1.274,109.79,1.172,1.0} ,};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== Currency Converter ====");
        System.out.println("Supported currencies: USD, INR, EUR, GBP");
        System.out.print("Enter FROM currency:");
        String from = scanner.nextLine().trim().toUpperCase();
        System.out.print("Enter TO currency:");
        String to = scanner.nextLine().trim().toUpperCase();
        System.out.print("Enter amount: ");
        double amt = scanner.nextDouble();
        int fromIndex = getCurrencyIndex(from);
        int toIndex = getCurrencyIndex(to);
        if (fromIndex == -1 || toIndex == -1) {
            System.out.println("❌Invalid currency entered...TRY AGAIN");
        } else {
            double rate = rates[fromIndex][toIndex];
            double converted_AMT = amt * rate;
            System.out.printf("%.2f %s = %.2f %s%n", amt, from, converted_AMT, to);
        }
        scanner.close();
    }

    public static int getCurrencyIndex(String code) {
        for (int i = 0; i < currencies.length; i++) {
            if (currencies[i].equals(code)) {
                return i;
            }
        }
        return -1;
    }
}