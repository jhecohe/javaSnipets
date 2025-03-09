import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

class CurrencyCountrie {

    public static void main(String[] args) {
        double payment = 12324.134;

        Locale inr = new Locale("en", "IN");

        // Write your code here.
        NumberFormat f = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        NumberFormat c = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat u = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat i = NumberFormat.getCurrencyInstance(inr);

        Currency cf = Currency.getInstance("EUR");
        f.setCurrency(cf);
        Currency cc = Currency.getInstance("CNY");
        c.setCurrency(cc);
        Currency cu = Currency.getInstance("USD");
        u.setCurrency(cu);
        Currency ci = Currency.getInstance("INR");
        i.setCurrency(ci);

        String france = f.format(payment);
        String china = c.format(payment);
        String us = u.format(payment);
        String india = i.format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
    // Expected result
    // US: $12,324.13

    // India: Rs.12,324.13

    // China: ￥12,324.13

    // France: 12 324,13 €
    //
    // Link https://www.hackerrank.com/challenges/java-currency-formatter/problem
}
