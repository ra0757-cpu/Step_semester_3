package week8;

public class HostelElectricityBill {

    public static void main(String[] args) {

        String[] types = {"SINGLE", "SHARED", "AC"};
        int[] units = {120, 150, 100};
        int[] occupants = {1, 3, 1};

        double total = 0;

        for (int i = 0; i < types.length; i++) {

            double bill = 0;

            if (types[i].equals("SINGLE")) {
                bill = units[i] * 8.0;
            } else if (types[i].equals("SHARED")) {
                bill = (units[i] * 6.0) / occupants[i];
            } else if (types[i].equals("AC")) {
                bill = (units[i] * 10.0) + 200;
            }

            System.out.printf("%s: %.2f%n", types[i], bill);

            total = total + bill;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}