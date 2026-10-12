package week9;

public class MovieTicketCounter {

    public static void main(String[] args) {

        String[] seatTypes = {"REGULAR", "PREMIUM", "RECLINER"};
        int[] tickets = {2, 3, 1};

        double total = 0;

        for (int i = 0; i < seatTypes.length; i++) {

            double price = 0;

            if (seatTypes[i].equals("REGULAR")) {
                price = 150;
            } else if (seatTypes[i].equals("PREMIUM")) {
                price = 250;
            } else if (seatTypes[i].equals("RECLINER")) {
                price = 400;
            }

            double amount = (price + 20) * tickets[i];

            System.out.printf("%s: Rs. %.2f%n", seatTypes[i], amount);

            total = total + amount;
        }

        System.out.printf("Total: Rs. %.2f%n", total);
    }
}