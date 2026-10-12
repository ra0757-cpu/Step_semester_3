package week8;

public class CanteenBillingCounter {

    public static void main(String[] args) {

        String[] types = {"STUDENT", "STAFF", "GUEST"};
        double[] amounts = {200, 300, 150};

        double total = 0;

        for (int i = 0; i < types.length; i++) {

            double finalAmount = 0;

            if (types[i].equals("STUDENT")) {
                finalAmount = amounts[i] * 0.90;
            } else if (types[i].equals("STAFF")) {
                finalAmount = amounts[i] * 0.95;
            } else if (types[i].equals("GUEST")) {
                finalAmount = amounts[i] + 10;
            }

            System.out.printf("%s: %.2f%n",
                    types[i], finalAmount);

            total = total + finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}